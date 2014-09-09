package com.bondeko.sysgeho.be.imp.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.dao.base.IDaoIncCod;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.core.util.locator.ResourceLocator;
import com.bondeko.sysgeho.be.imp.dao.IDaoPat;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatListPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatListPatElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvPat extends BaseSisv<TabPat, String> implements ISisvPat{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvPat.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoPat daoPat; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabPat, String> getBaseDao() {
		return daoPat;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoPat.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoPat.findAll(entity);
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
			return daoPat.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabPat patCree = (TabPat) p$entite; 
		((TabPat)p$entite).setCodPat(genererCodePatient(patCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		p$entite.validateData();
		return getBaseDao().save(p$entite);
	}
	
	private String genererCodePatient(TabPat tabPat) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabPat).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private SrlEtatListPat getListPatient(TabPat patient) throws SysGehoSystemException {
		SrlEtatListPat srlEtatListPat = new SrlEtatListPat();
		try {
			//Recherche tous les mouvements de ce conteneurs
			List<TabPat> listPat = daoPat.findAll(patient);
			if(listPat != null && listPat.size() > 0){
				//On parcour la liste des mouvement obtenus et on construit la sérialization  
				for(TabPat pat : listPat){
					srlEtatListPat.addElement(new SrlEtatListPatElt(pat));
				}
			}
//			else{
//				srlMouvCon.addElement(new SrlMouvConElt(conCour, null));
//			}
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatListPat;
	}
	
	@Override
	public EntFichier genererEtatListPatient(TabPat patient) throws SysGehoSystemException{
		
		try{
			SrlEtatListPat etatListPat = getListPatient(patient);
			getLogger().debug("SisvPat.genererEtatListPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatListPat,
					ResourceLocator.getReportModel(ReportNames.ETAT_LIST_PAT),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_LIST_PAT).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvCon.genererEtatMouvCon Creation de l'entite fichier ..."+result.getUri());
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
