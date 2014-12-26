package com.bondeko.sysgeho.be.imp.sisv;

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
import com.bondeko.sysgeho.be.imp.dao.IDaoConsul;
import com.bondeko.sysgeho.be.imp.dao.IDaoEtaStat;
import com.bondeko.sysgeho.be.imp.dao.IDaoExam;
import com.bondeko.sysgeho.be.imp.dao.IDaoHospi;
import com.bondeko.sysgeho.be.imp.dao.IDaoSoin;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.imp.entity.TabEtaStat;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCmptPres;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCmptPresElt;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatDosPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatDosPatElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvEtaStat extends BaseSisv<TabEtaStat, String> implements ISisvEtaStat{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvEtaStat.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoEtaStat daoEtaStat; 
	
	@EJB
	IDaoConsul daoConsul; 
	
	@EJB
	IDaoExam daoExam; 
	
	@EJB
	IDaoSoin daoSoin; 
	
	@EJB
	IDaoHospi daoHospi; 
	



	@Override
	public IBaseDao<TabEtaStat, String> getBaseDao() {
		return daoEtaStat;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoEtaStat.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoEtaStat.findAll(entity);
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
			return daoEtaStat.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	/**
	 * chargement des données comptables sur les prestations
	 */
	private SrlEtatCmptPres getCmptPres(TabEtaStat etatstat) throws SysGehoSystemException {
		SrlEtatCmptPres srlEtatCmptPres = new SrlEtatCmptPres();
		try {
			//Chargement de données pour toutes les consultations
			TabConsul consult = new TabConsul();
			List<TabConsul> listConsul = daoConsul.findAll(consult);
			if(listConsul != null && listConsul.size() > 0){
				for(TabConsul con : listConsul){
					srlEtatCmptPres.addElement(new SrlEtatCmptPresElt(con));
				}
			}
			
			//Chargement de toutes les examens
			TabExam exam = new TabExam();
			List<TabExam> listExam = daoExam.findAll(exam);
			if(listExam != null && listExam.size() > 0){
				for(TabExam ex : listExam){
					srlEtatCmptPres.addElement(new SrlEtatCmptPresElt(ex));
				}
			}
			
			//Chargement de toutes les soins
			TabSoin soin = new TabSoin();
			List<TabSoin> listSoin = daoSoin.findAll(soin);
			if(listSoin != null && listSoin.size() > 0){
				for(TabSoin so : listSoin){
					srlEtatCmptPres.addElement(new SrlEtatCmptPresElt(so));
				}
			}
			
			//Chargement de toutes les hospitalisations
			TabHospi hospi = new TabHospi();
			List<TabHospi> listHospi = daoHospi.findAll(hospi);
			if(listHospi != null && listHospi.size() > 0){
				for(TabHospi hos : listHospi){
					srlEtatCmptPres.addElement(new SrlEtatCmptPresElt(hos));
				}
			}
			
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatCmptPres;
	}
	
	/**
	 * generer l'etat comptable des prestation
	 */
	@Override
	public EntFichier genererCmptPres(TabEtaStat etatstat) throws SysGehoSystemException{
		
		try{
			SrlEtatCmptPres datacmptpres = getCmptPres(etatstat);
			getLogger().debug("SisvPat.genererEtatDPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(datacmptpres,
					ResourceLocator.getReportModel(ReportNames.ETAT_CMPT_PREST),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_CMPT_PREST).getDefaulFileName() + "."
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
