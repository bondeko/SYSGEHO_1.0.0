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
import com.bondeko.sysgeho.be.imp.dao.IDaoConsul;
import com.bondeko.sysgeho.be.imp.dao.IDaoCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.dao.IDaoCpteRenduExam;
import com.bondeko.sysgeho.be.imp.dao.IDaoExam;
import com.bondeko.sysgeho.be.imp.dao.IDaoHospi;
import com.bondeko.sysgeho.be.imp.dao.IDaoPat;
import com.bondeko.sysgeho.be.imp.dao.IDaoSoin;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduExam;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduExamElt;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatDosPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatDosPatElt;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatFichePat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatFichePatElt;
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
	
	@EJB
	IDaoConsul daoConsul; 
	
	@EJB
	IDaoExam daoExam; 
	
	@EJB
	IDaoSoin daoSoin; 
	
	@EJB
	IDaoHospi daoHospi; 
	
	@EJB
	IDaoCpteRenduConsul daoCpteRenduConsul; 
	
	@EJB
	IDaoCpteRenduExam daoCpteRenduExam; 


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
		String numero = DateTools.padRigth(String.valueOf(v$inc), 4, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private SrlEtatListPat getListPatient(TabPat patient) throws SysGehoSystemException {
		SrlEtatListPat srlEtatListPat = new SrlEtatListPat();
		try {
			List<TabPat> listPat = daoPat.findAll(patient);
			if(listPat != null && listPat.size() > 0){
				for(TabPat pat : listPat){
					srlEtatListPat.addElement(new SrlEtatListPatElt(pat));
				}
			}
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
	
	@Override
	public EntFichier genererEtatFichePatient(TabPat patient) throws SysGehoSystemException{
		
		try{
			SrlEtatFichePat etatFichePat = getFichePatient(patient);
			getLogger().debug("SisvPat.genererEtatFichePatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatFichePat,
					ResourceLocator.getReportModel(ReportNames.ETAT_FICHE_PAT),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_FICHE_PAT).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvPat.genererEtatFichePatient Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
	private SrlEtatFichePat getFichePatient(TabPat patient) throws SysGehoSystemException {
		SrlEtatFichePat srlEtatFichePat = new SrlEtatFichePat();
		srlEtatFichePat.addElement(new SrlEtatFichePatElt(patient));
		return srlEtatFichePat;
	}
	
	private SrlEtatDosPat getDossierPatient(TabPat patient) throws SysGehoSystemException {
		SrlEtatDosPat srlEtatDosPat = new SrlEtatDosPat();
		try {
			//Chargement de toutes les consultations
			TabConsul consult = new TabConsul();
			consult.setTabPat(patient);
			List<TabConsul> listConsul = daoConsul.findByExample(consult);
			if(listConsul != null && listConsul.size() > 0){
				for(TabConsul con : listConsul){
					TabCpteRenduConsul crconsult = new TabCpteRenduConsul();
					crconsult.setTabConsul(con);
					List<TabCpteRenduConsul> listCRConsul = daoCpteRenduConsul.findByExample(crconsult);
					if(listCRConsul != null && listCRConsul.size() == 1)
						srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, con, listCRConsul.get(0)));
						//srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, con, listCRConsul.get(0), null, null, null, null));
					//srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, con, null, null, null, null, null));
				}
			}
			
			
			//Chargement de toutes les examens
			TabExam exam = new TabExam();
			exam.setTabPat(patient);
			List<TabExam> listExam = daoExam.findByExample(exam);
			if(listExam != null && listExam.size() > 0){
				for(TabExam ex : listExam){
					TabCpteRenduExam crexam = new TabCpteRenduExam();
					crexam.setTabExam(ex);
					List<TabCpteRenduExam> listCRExam = daoCpteRenduExam.findByExample(crexam);
					if(listCRExam != null && listCRExam.size() == 1)
						srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, ex, listCRExam.get(0)));
					//srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, null, null, ex, null, null, null));
				}
			}
			
			//Chargement de toutes les soins
			TabSoin soin = new TabSoin();
			soin.setTabPat(patient);
			List<TabSoin> listSoin = daoSoin.findByExample(soin);
			if(listExam != null && listExam.size() > 0){
				for(TabSoin soins : listSoin){
					srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, soins));
				}
			}
			
			//Chargement de toutes les hospitalisations
			TabHospi hospi = new TabHospi();
			hospi.setTabPat(patient);
			List<TabHospi> listHospi = daoHospi.findByExample(hospi);
			if(listHospi != null && listHospi.size() > 0){
				for(TabHospi hos : listHospi){
					srlEtatDosPat.addElement(new SrlEtatDosPatElt(patient, hos));
				}
			}
			
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatDosPat;
	}
	
	@Override
	public EntFichier genererDossierPatient(TabPat patient) throws SysGehoSystemException{
		
		try{
			SrlEtatDosPat etatDosPat = getDossierPatient(patient);
			getLogger().debug("SisvPat.genererEtatDPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatDosPat,
					ResourceLocator.getReportModel(ReportNames.ETAT_DOSSIER_PAT),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_DOSSIER_PAT).getDefaulFileName() + "."
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
	
	private SrlEtatCpteRenduExam getListCpteRenduExam(TabPat patient) throws SysGehoSystemException {
		SrlEtatCpteRenduExam srlEtatCpteRenduExam = new SrlEtatCpteRenduExam();
		try {
			TabExam exam = new TabExam();
			exam.setTabPat(patient);
			TabCpteRenduExam cpterenduexam = new TabCpteRenduExam();
			cpterenduexam.setTabExam(exam);
			//Recherche tous les mouvements de ce conteneurs
			List<TabCpteRenduExam> listcpterendu = daoCpteRenduExam.findByExampleAndDate(cpterenduexam, patient.getDatDebut(),patient.getDatFin());
			if(listcpterendu != null && listcpterendu.size() > 0){
				//On parcour la liste des mouvement obtenus et on construit la sérialization  
				for(TabCpteRenduExam pat : listcpterendu){
					srlEtatCpteRenduExam.addElement(new SrlEtatCpteRenduExamElt(pat));
				}
			}
//			else{
//				srlMouvCon.addElement(new SrlMouvConElt(conCour, null));
//			}
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatCpteRenduExam;
	}
	
	@Override
	public EntFichier genererListCpteRenduExam(TabPat patient) throws SysGehoSystemException{
		
		try{
			SrlEtatCpteRenduExam etatCpteRenCon = getListCpteRenduExam(patient);
			getLogger().debug("SisvPat.genererEtatListPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatCpteRenCon,
					ResourceLocator.getReportModel(ReportNames.ETAT_CPTE_RENDU_EXAM_LIST),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_CPTE_RENDU_EXAM_LIST).getDefaulFileName() + "."
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
