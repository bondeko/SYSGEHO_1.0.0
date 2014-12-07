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
import com.bondeko.sysgeho.be.fac.dao.IDaoFacConv;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.fac.serialize.SrlFacConvElt;
import com.bondeko.sysgeho.be.fac.serialize.SrlFactConv;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvFacConv extends BaseSisv<TabFacConv, String> implements ISisvFacConv{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvFacConv.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoFacConv daoFacConv; 
	
	@Override
	public IBaseDao<TabFacConv, String> getBaseDao() {
		return daoFacConv;
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		initialiserDonnees((TabFacConv)p$entite);
		p$entite.validateData();
		return getBaseDao().save(p$entite);
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoFacConv.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoFacConv.findAll(entity);
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
			return daoFacConv.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private TabFacConv initialiserDonnees(TabFacConv consul){
		consul.setBooVal(BigDecimal.ZERO);
		consul.setBooPaie(BigDecimal.ZERO);
		return consul;
	}
	
	@Override
	public TabFacConv valider(TabFacConv $pFacConv) throws SysGehoSystemException  {
		try {
			$pFacConv.setBooVal(BigDecimal.ONE);
			$pFacConv.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pFacConv);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabFacConv payer(TabFacConv $pFacConv) throws SysGehoSystemException  {
		try {
			$pFacConv.setBooPaie(BigDecimal.ONE);
			$pFacConv.setEtatEnt(EnuEtat.PAYE.getValue());
			return getBaseDao().update($pFacConv);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de paiement de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabFacConv> rechercherFacConvParSocMoisAnnee(String codSoc, String mois, String annee) throws SysGehoSystemException  {
		try {
			return daoFacConv.findBySocMonthYear(codSoc,mois, annee);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherFacConvParSocMoisAnnee");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	public <X extends BaseEntity> X modifier(X p$entite) throws SysGehoPersistenceException {
		p$entite.validateData();
		TabFacConv facConv =(TabFacConv) p$entite;
		BigDecimal valMntTotal = null; 
		BigDecimal valMntMulty;
		if(facConv.getValPrixUni()!= null && facConv.getValEff()!= null){
			valMntMulty = facConv.getValPrixUni().multiply(facConv.getValEff());
			if(facConv.getValTrfFixMsuel() != null) valMntTotal = valMntMulty.add(facConv.getValTrfFixMsuel());
		}else{
			if(facConv.getValTrfFixMsuel() != null) valMntTotal = facConv.getValTrfFixMsuel();
		}
		facConv.setValMntTotal(valMntTotal);
		return getBaseDao().update(p$entite);
	}
	
	@Override
	public EntFichier genererFacConv(TabFacConv facConv) throws SysGehoSystemException{
		
		try{
			SrlFactConv srlFacConv = getFacConv(facConv);
			getLogger().debug("SisvFacConv.genererFacConv Serialisation ...");
			SysGehoOutput result = fillAndExport(srlFacConv,
					ResourceLocator.getReportModel(ReportNames.ETAT_FAC_CONV),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_FAC_CONV).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvFacConv.genererFacConv Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
	private SrlFactConv getFacConv(TabFacConv facConv) throws SysGehoSystemException {
		SrlFactConv srlFacConv = new SrlFactConv();
		try {
			List<TabFacConv> listFact = daoFacConv.findByExample(facConv);
			if(listFact !=null && listFact.size() > 0){
				for(TabFacConv fact : listFact){
					srlFacConv.addElement(new SrlFacConvElt(fact));
				}
			}
			
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de generation du fichier de serialisation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
		
		return srlFacConv;
	}
}
