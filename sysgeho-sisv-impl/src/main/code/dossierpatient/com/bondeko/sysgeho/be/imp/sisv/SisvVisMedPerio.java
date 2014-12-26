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
import com.bondeko.sysgeho.be.imp.dao.IDaoVisMedPerio;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;

@Stateless
public class SisvVisMedPerio extends BaseSisv<TabVisMedPerio, String> implements ISisvVisMedPerio{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvVisMedPerio.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoVisMedPerio daoVisMedPerio; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabVisMedPerio, String> getBaseDao() {
		return daoVisMedPerio;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoVisMedPerio.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoVisMedPerio.findAll(entity);
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
			return daoVisMedPerio.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabVisMedPerio conCree = (TabVisMedPerio) p$entite; 
		conCree = initialiserDonnees(conCree);
		conCree.setCodVisMedPerio(genererCodeVisMedPerio(conCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, conCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree.validateData();
		return (X) getBaseDao().save(conCree);
	}
	
	private String genererCodeVisMedPerio(TabVisMedPerio tabVisMedPerio) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabVisMedPerio).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabVisMedPerio initialiserDonnees(TabVisMedPerio visMedEmb){
		visMedEmb.setBooEstVal(BigDecimal.ZERO);
		return visMedEmb;
	}
	
	@Override
	public TabVisMedPerio valider(TabVisMedPerio $pVisMedPerio) throws SysGehoSystemException  {
		try {
			$pVisMedPerio.setBooEstVal(BigDecimal.ONE);
			$pVisMedPerio.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pVisMedPerio);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la visite médicale");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	
}
