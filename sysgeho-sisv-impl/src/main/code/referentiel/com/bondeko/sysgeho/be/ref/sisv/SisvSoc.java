package com.bondeko.sysgeho.be.ref.sisv;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.core.util.locator.ResourceLocator;
import com.bondeko.sysgeho.be.ref.dao.IDaoSoc;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.ref.serialize.SrlSoc;
import com.bondeko.sysgeho.be.ref.serialize.SrlSocElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvSoc extends BaseSisv<TabSoc, String> implements ISisvSoc{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvSoc.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoSoc daoSoc; 



	@Override
	public IBaseDao<TabSoc, String> getBaseDao() {
		return daoSoc;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoSoc.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoSoc.findAll(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoSystemException {
		try {
			return daoSoc.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public EntFichier genererListSoc(TabSoc soc) throws SysGehoSystemException{
		
		try{
			SrlSoc srlSoc = getSoc(soc);
			getLogger().debug("SisvSoc.genererSoc Serialisation ...");
			SysGehoOutput result = fillAndExport(srlSoc,
					ResourceLocator.getReportModel(ReportNames.ETAT_LIST_SOC),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_LIST_SOC).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvSoc.genererSoc Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
	private SrlSoc getSoc(TabSoc soc) throws SysGehoSystemException {
		SrlSoc srlSoc = new SrlSoc();
		try {
			List<TabSoc> listSoc = daoSoc.findAll(soc);
			if(listSoc !=null && listSoc.size() > 0){
				for(TabSoc fact : listSoc){
					srlSoc.addElement(new SrlSocElt(fact));
				}
			}
			
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de generation du fichier de serialisation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
		
		return srlSoc;
	}

}
