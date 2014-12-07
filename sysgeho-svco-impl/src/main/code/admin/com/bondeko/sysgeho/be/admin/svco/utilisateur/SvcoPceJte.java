package com.bondeko.sysgeho.be.admin.svco.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bondeko.sysgeho.be.admin.sisv.utilisateur.ISisvPceJte;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.core.svco.base.BaseSvco;
import com.bondeko.sysgeho.be.util.TabPceJte;


/**
 * Session Bean implementation class SvcoPceJte
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoPceJte extends BaseSvco<TabPceJte> implements IRemotePceJte, ILocalPceJte 
{
	private static BaseLogger logger = BaseLogger.getLogger(SvcoPceJte.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@Resource
    SessionContext session;

	@EJB
	ISisvPceJte sisvPce;
	
	@Override
	protected IBaseSisv<TabPceJte, String> getBaseSisv() {
		return sisvPce;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
	throws SysGehoAppException {
		try {
			return sisvPce.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoAppException {
		// TODO Auto-generated method stub
		return null;
	}

}
