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
import com.bondeko.sysgeho.be.imp.dao.IDaoRapVisMedEmb;
import com.bondeko.sysgeho.be.imp.dao.IDaoVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;

@Stateless
public class SisvRapVisMedEmb extends BaseSisv<TabRapVisMedEmb, String> implements ISisvRapVisMedEmb{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvRapVisMedEmb.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoRapVisMedEmb daoRapVisMedEmb; 
	
	@EJB
	IDaoVisMedEmb daoVisMedEmb; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabRapVisMedEmb, String> getBaseDao() {
		return daoRapVisMedEmb;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoRapVisMedEmb.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoRapVisMedEmb.findAll(entity);
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
			return daoRapVisMedEmb.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabRapVisMedEmb rapVisMedCree = (TabRapVisMedEmb) p$entite; 
		//Teste si la consultation n'a pas deja un compte rendu
		if(rapVisMedCree.getTabVisMedEmb().getBooRapVisMed().equals(BigDecimal.ONE))
			throw new BaseException("Erreur : Il existe déjà un rapport pour la visite médicale d'embauche "+ rapVisMedCree.getTabVisMedEmb().getCodVisMedEmb());
		rapVisMedCree = initialiserDonnees(rapVisMedCree);
		//genere le code du compte rendu
		((TabRapVisMedEmb)p$entite).setCodRapVisMedEmb(genererCodeRapVisMed(rapVisMedCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		p$entite.validateData();
		//Met à jour la consultation Boo_Cpte_Rendu = 1
		TabVisMedEmb visMedEmb = rapVisMedCree.getTabVisMedEmb();
		visMedEmb.setBooRapVisMed(BigDecimal.ONE);
		daoVisMedEmb.update(visMedEmb);
		return getBaseDao().save(p$entite);
	}
	
	private String genererCodeRapVisMed(TabRapVisMedEmb tabRapVisMedEmb) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabRapVisMedEmb).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabRapVisMedEmb initialiserDonnees(TabRapVisMedEmb visMed){
		visMed.setBooVal(BigDecimal.ZERO);
		return visMed;
	}
	
	@Override
	public TabRapVisMedEmb valider(TabRapVisMedEmb $pCpteRduConsul) throws SysGehoSystemException  {
		try {
			$pCpteRduConsul.setBooVal(BigDecimal.ONE);
			$pCpteRduConsul.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pCpteRduConsul);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la consultation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
}
