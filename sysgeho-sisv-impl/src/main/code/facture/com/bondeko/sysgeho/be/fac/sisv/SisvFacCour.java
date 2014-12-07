package com.bondeko.sysgeho.be.fac.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.core.util.locator.ResourceLocator;
import com.bondeko.sysgeho.be.fac.dao.IDaoFacCour;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.fac.serialize.SrlFacCour;
import com.bondeko.sysgeho.be.fac.serialize.SrlFacCourElt;
import com.bondeko.sysgeho.be.imp.dao.IDaoConsul;
import com.bondeko.sysgeho.be.imp.dao.IDaoExam;
import com.bondeko.sysgeho.be.imp.dao.IDaoHospi;
import com.bondeko.sysgeho.be.imp.dao.IDaoSoin;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvFacCour extends BaseSisv<TabFacCour, String> implements ISisvFacCour{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvFacCour.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoFacCour daoFacCour; 
	
	@EJB
	IDaoConsul daoConsul; 
	
	@EJB
	IDaoExam daoExam; 
	
	@EJB
	IDaoHospi daoHospi; 
	
	@EJB
	IDaoSoin daosoin; 
	
	@Override
	public IBaseDao<TabFacCour, String> getBaseDao() {
		return daoFacCour;
	}
	
	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoFacCour.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoFacCour.findAll(entity);
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
			return daoFacCour.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabFacCour conCree = (TabFacCour) p$entite; 
		conCree = initialiserDonnees(conCree);
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, conCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree.validateData();
		BigDecimal mntTotal = BigDecimal.ZERO;
		//on met à jour REF_FAC des prestations présentes dans la facture
		//Consultation
		List<TabConsul> listConsulFac = conCree.getListConsulFac();
		if(listConsulFac !=null && listConsulFac.size() > 0){
			for(TabConsul consul : listConsulFac){
				consul.setRefFac(conCree.getRefFacCour());
				consul.setInfoUser(conCree.getInfoUser());
				mntTotal = mntTotal.add(consul.getValMntTtc()); 
				daoConsul.update(consul);
			}
		}
		//Hospitalisation
		List<TabHospi> listHospiFac = conCree.getListHospiFac();
		if(listHospiFac !=null && listHospiFac.size() > 0){
			for(TabHospi hospi : listHospiFac){
				hospi.setRefFac(conCree.getRefFacCour());
				hospi.setInfoUser(conCree.getInfoUser());
				mntTotal = mntTotal.add(hospi.getValMnt()); 
				daoHospi.update(hospi);
			}
		}
		//Examen
		List<TabExam> listExamFac = conCree.getListExamFac();
		if(listExamFac !=null && listExamFac.size() > 0){
			for(TabExam exam : listExamFac){
				exam.setRefFac(conCree.getRefFacCour());
				exam.setInfoUser(conCree.getInfoUser());
				mntTotal = mntTotal.add(exam.getValMntTtc()); 
				daoExam.update(exam);
			}
		}
		//Soin
		List<TabSoin> listSoinFac = conCree.getListSoinFac();
		if(listSoinFac !=null && listSoinFac.size() > 0){
			for(TabSoin soin : listSoinFac){
				soin.setRefFac(conCree.getRefFacCour());
				soin.setInfoUser(conCree.getInfoUser());
				mntTotal = mntTotal.add(soin.getValMntTtc()); 
				daosoin.update(soin);
			}
		}
		conCree.setValMntTotal(mntTotal);
		return (X) getBaseDao().save(conCree);
	}
	
	
	private TabFacCour initialiserDonnees(TabFacCour consul){
		consul.setBooVal(BigDecimal.ZERO);
		consul.setBooPaie(BigDecimal.ZERO);
		return consul;
	}
	
	@Override
	public TabFacCour valider(TabFacCour $pFacCour) throws SysGehoSystemException  {
		try {
			$pFacCour.setBooVal(BigDecimal.ONE);
			$pFacCour.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pFacCour);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabFacCour payer(TabFacCour $pFacCour) throws SysGehoSystemException  {
		try {
			//On met à l'état payé toutes les prestations de la facture
			//Consultation
			List<TabConsul> listConsul = daoConsul.findByRefFac($pFacCour.getRefFacCour());
			if(listConsul !=null && listConsul.size() > 0){
				for(TabConsul consul : listConsul){
					consul.setBooPaie(BigDecimal.ONE);
					consul.setEtatEnt(EnuEtat.PAYE.getValue());
					consul.setInfoUser($pFacCour.getInfoUser());
					daoConsul.update(consul);
				}
			}
			//Hospitalisation
			List<TabHospi> listHospi = daoHospi.findByRefFac($pFacCour.getRefFacCour());
			if(listHospi !=null && listHospi.size() > 0){
				for(TabHospi hospi : listHospi){
					hospi.setBooPaie(BigDecimal.ONE);
					hospi.setEtatEnt(EnuEtat.PAYE.getValue());
					hospi.setInfoUser($pFacCour.getInfoUser());
					daoHospi.update(hospi);
				}
			}
			//Examen
			List<TabExam> listExam = daoExam.findByRefFac($pFacCour.getRefFacCour());
			if(listExam !=null && listExam.size() > 0){
				for(TabExam exam : listExam){
					exam.setBooPaie(BigDecimal.ONE);
					exam.setEtatEnt(EnuEtat.PAYE.getValue());
					exam.setInfoUser($pFacCour.getInfoUser());
					daoExam.update(exam);
				}
			}
			//Soin
			List<TabSoin> listSoin = daosoin.findByRefFac($pFacCour.getRefFacCour());
			if(listSoin !=null && listSoin.size() > 0){
				for(TabSoin soin : listSoin){
					soin.setBooPaie(BigDecimal.ONE);
					soin.setEtatEnt(EnuEtat.PAYE.getValue());
					soin.setInfoUser($pFacCour.getInfoUser());
					daosoin.update(soin);
				}
			}
			$pFacCour.setBooPaie(BigDecimal.ONE);
			$pFacCour.setEtatEnt(EnuEtat.PAYE.getValue());
			return getBaseDao().update($pFacCour);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de paiement de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public EntFichier genererFacCour(TabFacCour facCour) throws SysGehoSystemException{
		
		try{
			SrlFacCour srlFacCour = getFacCour(facCour);
			getLogger().debug("SisvFacCour.genererFacCour Serialisation ...");
			SysGehoOutput result = fillAndExport(srlFacCour,
					ResourceLocator.getReportModel(ReportNames.ETAT_FAC_COUR),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_FAC_COUR).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvFacCour.genererFacCour Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
	private SrlFacCour getFacCour(TabFacCour facCour) throws SysGehoSystemException {
		SrlFacCour srlFacCour = new SrlFacCour();
		try {
			List<TabConsul> listConsul = daoConsul.findByRefFac(facCour.getRefFacCour());
			if(listConsul !=null && listConsul.size() > 0){
				for(TabConsul consul : listConsul){
					srlFacCour.addElement(new SrlFacCourElt(facCour.getTabPat(), facCour, "CONSUL", "Consultations", 
							consul.getCodConsul(), consul.getDatConsul(), consul.getValMntTtc()));
				}
			}
			//Hospitalisation
			List<TabHospi> listHospi = daoHospi.findByRefFac(facCour.getRefFacCour());
			if(listHospi !=null && listHospi.size() > 0){
				for(TabHospi hospi : listHospi){
					srlFacCour.addElement(new SrlFacCourElt(facCour.getTabPat(), facCour, "HOSPI", "Hospitalisations", 
							hospi.getCodHospi(), hospi.getDatAdmi(), hospi.getValMnt()));
				}
			}
			//Examen
			List<TabExam> listExam = daoExam.findByRefFac(facCour.getRefFacCour());
			if(listExam !=null && listExam.size() > 0){
				for(TabExam exam : listExam){
					srlFacCour.addElement(new SrlFacCourElt(facCour.getTabPat(), facCour, "EXAM", "Examens", 
							exam.getCodExam(), exam.getDatExam(), exam.getValMntTtc()));
				}
			}
			//Soin
			List<TabSoin> listSoin = daosoin.findByRefFac(facCour.getRefFacCour());
			if(listSoin !=null && listSoin.size() > 0){
				for(TabSoin soin : listSoin){
					srlFacCour.addElement(new SrlFacCourElt(facCour.getTabPat(), facCour, "SOIN", "Soins", 
							soin.getCodSoin(), soin.getDatSoin(), soin.getValMntTtc()));
				}
			}
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de generation du fichier de serialisation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
		
		return srlFacCour;
	}
	
}
