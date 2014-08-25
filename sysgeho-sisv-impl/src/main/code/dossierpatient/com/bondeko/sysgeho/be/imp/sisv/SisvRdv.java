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
import com.bondeko.sysgeho.be.imp.dao.IDaoRdv;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;

@Stateless
public class SisvRdv extends BaseSisv<TabRdv, String> implements ISisvRdv{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvRdv.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoRdv daoRdv; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabRdv, String> getBaseDao() {
		return daoRdv;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoRdv.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoRdv.findAll(entity);
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
			return daoRdv.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabRdv rdvCree = (TabRdv) p$entite; 
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		rdvCree = initialiserDonnees(rdvCree);
		rdvCree.setCodRdv(genererCodeRdvient(rdvCree));
		return (X) getBaseDao().save(rdvCree);
	}
	
	private String genererCodeRdvient(TabRdv tabRdv) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabRdv).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabRdv initialiserDonnees(TabRdv rdv){
		rdv.setBooEstAnn(BigDecimal.ZERO);
		rdv.setBooEstConf(BigDecimal.ZERO);
		return rdv;
	}
	
	@Override
	public TabRdv annuler(TabRdv $pRdv) throws SysGehoSystemException  {
		try {
			$pRdv.setBooEstAnn(BigDecimal.ONE);
			$pRdv.setEtatEnt(EnuEtat.ANNULER.getValue());
			return getBaseDao().update($pRdv);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur d'annulation du RDV");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabRdv confirmer(TabRdv $pRdv) throws SysGehoSystemException  {
		try {
			$pRdv.setBooEstConf(BigDecimal.ONE);
			$pRdv.setEtatEnt(EnuEtat.CONFIRME.getValue());
			return getBaseDao().update($pRdv);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de confirmation du RDV");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

}
