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
import com.bondeko.sysgeho.be.phar.dao.IDaoProd;
import com.bondeko.sysgeho.be.phar.entity.TabProd;

@Stateless
public class SisvProd extends BaseSisv<TabProd, String> implements ISisvProd{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvProd.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoProd daoProd; 
	
	@Override
	public IBaseDao<TabProd, String> getBaseDao() {
		return daoProd;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoProd.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoProd.findAll(entity);
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
			return daoProd.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
}
