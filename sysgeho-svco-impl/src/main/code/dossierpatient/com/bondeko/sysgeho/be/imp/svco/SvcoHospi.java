package com.bondeko.sysgeho.be.imp.svco;

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
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.sisv.ISisvHospi;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoHospi extends BaseSvco<TabHospi> implements IRemoteHospi, ILocalHospi{
	
	@EJB
	ISisvHospi sisvHospi;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoHospi.class);
	
	@Override
	protected IBaseSisv<TabHospi, String> getBaseSisv() {
		return sisvHospi;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvHospi.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvHospi.rechercherTout(entity);
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
			return sisvHospi.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabHospi rechercherParCodPat(String codPat)
	throws SysGehoAppException {
		try {
			return sisvHospi.rechercherParCodPat(codPat);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabHospi sortirHospitalisation(TabHospi tabHospi) throws SysGehoAppException {
		try {
			return sisvHospi.sortirHospitalisation(tabHospi);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sbr = new SysGehoAppException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabHospi> rechercherParRefFac(String refFac) throws SysGehoAppException {
		try {
			return sisvHospi.rechercherParRefFac(refFac);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public List<TabHospi> rechercherHospiNonPaieParPatient(String codPat) throws SysGehoAppException {
		try {
			return sisvHospi.rechercherHospiNonPaieParPatient(codPat);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
}
