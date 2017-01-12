package com.bondeko.sysgeho.be.phar.svco;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.core.svco.base.BaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabProd;
import com.bondeko.sysgeho.be.phar.sisv.ISisvProd;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoProd extends BaseSvco<TabProd> implements IRemoteProd, ILocalProd{
	
	@EJB
	ISisvProd sisvProd;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoProd.class);
	
	@Override
	protected IBaseSisv<TabProd, String> getBaseSisv() {
		return sisvProd;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
		throws SysGehoAppException {
		try {
			return sisvProd.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvProd.rechercherTout(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoAppException {
		try {
			return sisvProd.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
}
