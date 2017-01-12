package com.bondeko.sysgeho.be.phar.sisv;

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
import com.bondeko.sysgeho.be.phar.dao.IDaoSousCatProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;

@Stateless
public class SisvSousCatProd extends BaseSisv<TabSousCatProd, String> implements ISisvSousCatProd{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvSousCatProd.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoSousCatProd daoSousCatProd; 
	
	@Override
	public IBaseDao<TabSousCatProd, String> getBaseDao() {
		return daoSousCatProd;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoSousCatProd.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoSousCatProd.findAll(entity);
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
			return daoSousCatProd.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
}
