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
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.be.imp.sisv.ISisvRapVisMedEmb;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoRapVisMedEmb extends BaseSvco<TabRapVisMedEmb> implements IRemoteRapVisMedEmb, ILocalRapVisMedEmb{
	
	@EJB
	ISisvRapVisMedEmb sisvRapVisMedEmb;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoRapVisMedEmb.class);
	
	@Override
	protected IBaseSisv<TabRapVisMedEmb, String> getBaseSisv() {
		return sisvRapVisMedEmb;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvRapVisMedEmb.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvRapVisMedEmb.rechercherTout(entity);
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
			return sisvRapVisMedEmb.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabRapVisMedEmb valider(TabRapVisMedEmb $pCpteRduConsul) throws SysGehoAppException {
		try {
			return sisvRapVisMedEmb.valider($pCpteRduConsul);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
}
