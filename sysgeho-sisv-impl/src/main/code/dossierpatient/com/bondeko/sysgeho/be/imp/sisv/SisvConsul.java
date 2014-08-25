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
import com.bondeko.sysgeho.be.imp.dao.IDaoConsul;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

@Stateless
public class SisvConsul extends BaseSisv<TabConsul, String> implements ISisvConsul{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvConsul.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoConsul daoConsul; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabConsul, String> getBaseDao() {
		return daoConsul;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoConsul.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoConsul.findAll(entity);
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
			return daoConsul.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabConsul conCree = (TabConsul) p$entite; 
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree = initialiserDonnees(conCree);
		conCree.setCodConsul(genererCodeConsul(conCree));
		
		return (X) getBaseDao().save(conCree);
	}
	
	private String genererCodeConsul(TabConsul tabConsul) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabConsul).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabConsul initialiserDonnees(TabConsul consul){
		consul.setBooCpteRendu(BigDecimal.ZERO);
		consul.setBooVal(BigDecimal.ZERO);
		return consul;
	}
	
	@Override
	public TabConsul valider(TabConsul $pConsul) throws SysGehoSystemException  {
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
}
