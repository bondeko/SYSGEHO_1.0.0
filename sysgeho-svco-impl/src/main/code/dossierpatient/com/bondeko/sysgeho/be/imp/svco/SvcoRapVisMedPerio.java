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
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.be.imp.sisv.ISisvRapVisMedPerio;
import com.bondeko.sysgeho.be.util.EntFichier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoRapVisMedPerio extends BaseSvco<TabRapVisMedPerio> implements IRemoteRapVisMedPerio, ILocalRapVisMedPerio{
	
	@EJB
	ISisvRapVisMedPerio sisvRapVisMedPerio;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoRapVisMedPerio.class);
	
	@Override
	protected IBaseSisv<TabRapVisMedPerio, String> getBaseSisv() {
		return sisvRapVisMedPerio;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvRapVisMedPerio.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvRapVisMedPerio.rechercherTout(entity);
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
			return sisvRapVisMedPerio.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabRapVisMedPerio valider(TabRapVisMedPerio $pCpteRduConsul) throws SysGehoAppException {
		try {
			return sisvRapVisMedPerio.valider($pCpteRduConsul);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	/**
	 * Generer le rapport de visite
	 */
	@Override
	public EntFichier  genererRapportVM(TabRapVisMedPerio rapport)
	throws SysGehoAppException {
		try {
			return sisvRapVisMedPerio.genererRapportVM(rapport);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
}
