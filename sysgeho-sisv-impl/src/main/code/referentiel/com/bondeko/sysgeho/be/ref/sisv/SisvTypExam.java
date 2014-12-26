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
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatFichierExam;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatFichierExamElt;
import com.bondeko.sysgeho.be.ref.dao.IDaoTypExam;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvTypExam extends BaseSisv<TabTypExam, String> implements ISisvTypExam{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvTypExam.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoTypExam daoTypExam; 



	@Override
	public IBaseDao<TabTypExam, String> getBaseDao() {
		return daoTypExam;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoTypExam.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoTypExam.findAll(entity);
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
			return daoTypExam.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private SrlEtatFichierExam getListExam(TabTypExam typeexam) throws SysGehoSystemException {
		SrlEtatFichierExam srlExam = new SrlEtatFichierExam();
		try {
			List<TabTypExam> listExam = daoTypExam.findAll(typeexam);
			if(listExam !=null && listExam.size() > 0){
				int i = 1;
				for(TabTypExam ex : listExam){
					srlExam.addElement(new SrlEtatFichierExamElt(ex, i));
					i++;
				}
			}
			
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de generation du fichier de serialisation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
		
		return srlExam;
	}
	
	@Override
	public EntFichier genererFichierExamen(TabTypExam typeexam) throws SysGehoSystemException{
		
		try{
			SrlEtatFichierExam srlExam = getListExam(typeexam);
			getLogger().debug("SisvSoc.genererSoc Serialisation ...");
			SysGehoOutput result = fillAndExport(srlExam,
					ResourceLocator.getReportModel(ReportNames.ETAT_LIST_EXAM),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_LIST_EXAM).getDefaulFileName() + "."
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

}
