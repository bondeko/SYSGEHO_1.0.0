package com.bondeko.sysgeho.be.admin.svco.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.admin.sisv.utilisateur.ISisvUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.core.svco.base.BaseSvco;

//@Stateless(name = "SvcoUsr", mappedName = "SvcoUsr")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoUsr extends BaseSvco<TabUsr> implements IRemoteUsr, ILocalUsr{
	
	@EJB
	ISisvUsr sisvUsr;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoUsr.class);
	
	@Override
	protected IBaseSisv<TabUsr, String> getBaseSisv() {
		return sisvUsr;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	public TabUsr authenticate(String p$login, String p$pwd) throws SysGehoAppException {
		try {
			return sisvUsr.authenticate(p$login, p$pwd);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	public TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws SysGehoAppException {
		try {
			return sisvUsr.modifierPwd(p$login, p$oldPwd, p$newPwd);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvUsr.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvUsr.rechercherTout(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
	throws SysGehoAppException {
		try {
			return sisvUsr.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

}
