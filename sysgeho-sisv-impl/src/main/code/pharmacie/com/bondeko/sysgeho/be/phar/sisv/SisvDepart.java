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
import com.bondeko.sysgeho.be.phar.dao.IDaoDepart;
import com.bondeko.sysgeho.be.phar.entity.TabDepart;

@Stateless
public class SisvDepart extends BaseSisv<TabDepart, String> implements ISisvDepart{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvDepart.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoDepart daoDepart; 



	@Override
	public IBaseDao<TabDepart, String> getBaseDao() {
		return daoDepart;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoDepart.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoDepart.findAll(entity);
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
			return daoDepart.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

}
