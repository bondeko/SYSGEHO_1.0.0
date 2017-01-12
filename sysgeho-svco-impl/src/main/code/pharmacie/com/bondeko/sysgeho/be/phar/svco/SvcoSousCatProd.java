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
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;
import com.bondeko.sysgeho.be.phar.sisv.ISisvSousCatProd;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoSousCatProd extends BaseSvco<TabSousCatProd> implements IRemoteSousCatProd, ILocalSousCatProd{
	
	@EJB
	ISisvSousCatProd sisvSousCatProd;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoSousCatProd.class);
	
	@Override
	protected IBaseSisv<TabSousCatProd, String> getBaseSisv() {
		return sisvSousCatProd;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvSousCatProd.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvSousCatProd.rechercherTout(entity);
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
			return sisvSousCatProd.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

}
