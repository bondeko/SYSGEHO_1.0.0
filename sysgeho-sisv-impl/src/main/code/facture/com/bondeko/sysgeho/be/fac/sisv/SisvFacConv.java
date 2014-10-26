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
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.fac.dao.IDaoFacConv;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;

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
}
