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
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.core.util.locator.ResourceLocator;
import com.bondeko.sysgeho.be.imp.dao.IDaoCertMed;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCertMed;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCertMedElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvCertMed extends BaseSisv<TabCertMed, String> implements ISisvCertMed{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvCertMed.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoCertMed daoCertMed; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabCertMed, String> getBaseDao() {
		return daoCertMed;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoCertMed.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoCertMed.findAll(entity);
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
			return daoCertMed.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabCertMed conCree = (TabCertMed) p$entite; 
		conCree = initialiserDonnees(conCree);
		conCree.setCodCertMed(genererCodeCertificat(conCree));
		conCree.setLibNomPat(conCree.getTabPat().getLibNom()+" " + conCree.getTabPat().getLibPre());
		conCree.setLibNomMed(conCree.getTabUsr().getLibNom() + " " + conCree.getTabUsr().getLibPre());
		
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, conCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree.validateData();
		return (X) getBaseDao().save(conCree);
	}
	
	private String genererCodeCertificat(TabCertMed TabCertMed) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(TabCertMed).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabCertMed initialiserDonnees(TabCertMed consul){
		//consul.setBooCpteRendu(BigDecimal.ZERO);
		consul.setBooVal(BigDecimal.ZERO);
		return consul;
	}
	
	@Override
	public TabCertMed valider(TabCertMed $pConsul) throws SysGehoSystemException  {
		try {
			$pConsul.setBooVal(BigDecimal.ONE);
			$pConsul.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pConsul);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la consultation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabCertMed> rechercherParRefFac(String refFac) throws SysGehoSystemException  {
		try {
			return daoCertMed.findByRefFac(refFac);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherParRefFac");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public EntFichier genererEtatCertMed(TabCertMed certMed) throws SysGehoSystemException{
		
		try{
			SrlEtatCertMed etatcertmed = getCertMed(certMed);
			getLogger().debug("SisvPat.genererEtatFichePatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatcertmed,
					ResourceLocator.getReportModel(ReportNames.ETAT_CERT_MED),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_CERT_MED).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvCertMed.genererCertMed Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
	private SrlEtatCertMed getCertMed(TabCertMed certMed) throws SysGehoSystemException {
		SrlEtatCertMed srlEtatcertificat = new SrlEtatCertMed();
		srlEtatcertificat.addElement(new SrlEtatCertMedElt(certMed));
		return srlEtatcertificat;
	}
	
}
