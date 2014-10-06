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
import com.bondeko.sysgeho.be.imp.dao.IDaoVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;

@Stateless
public class SisvVisMedEmb extends BaseSisv<TabVisMedEmb, String> implements ISisvVisMedEmb{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvVisMedEmb.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoVisMedEmb daoVisMedEmb; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabVisMedEmb, String> getBaseDao() {
		return daoVisMedEmb;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoVisMedEmb.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoVisMedEmb.findAll(entity);
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
			return daoVisMedEmb.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabVisMedEmb conCree = (TabVisMedEmb) p$entite; 
		conCree = initialiserDonnees(conCree);
		conCree.setCodVisMedEmb(genererCodeVisMedEmb(conCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, conCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree.validateData();
		return (X) getBaseDao().save(conCree);
	}
	
	private String genererCodeVisMedEmb(TabVisMedEmb tabVisMedEmb) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabVisMedEmb).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabVisMedEmb initialiserDonnees(TabVisMedEmb visMedEmb){
		visMedEmb.setBooEstVal(BigDecimal.ZERO);
		return visMedEmb;
	}
	
	@Override
	public TabVisMedEmb valider(TabVisMedEmb $pVisMedEmb) throws SysGehoSystemException  {
		try {
			$pVisMedEmb.setBooEstVal(BigDecimal.ONE);
			$pVisMedEmb.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pVisMedEmb);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la visite médicale");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
}
