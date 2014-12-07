package com.bondeko.sysgeho.be.fac.svco;

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
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.core.svco.base.BaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;
import com.bondeko.sysgeho.be.fac.sisv.ISisvFacVisMedPerio;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoFacVisMedPerio extends BaseSvco<TabFacVisMedPerio> implements IRemoteFacVisMedPerio, ILocalFacVisMedPerio{
	
	@EJB
	ISisvFacVisMedPerio sisvFacVisMedPerio;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoFacVisMedPerio.class);
	
	@Override
	protected IBaseSisv<TabFacVisMedPerio, String> getBaseSisv() {
		return sisvFacVisMedPerio;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvFacVisMedPerio.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvFacVisMedPerio.rechercherTout(entity);
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
			return sisvFacVisMedPerio.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedPerio valider(TabFacVisMedPerio $pFacConv) throws SysGehoAppException {
		try {
			return sisvFacVisMedPerio.valider($pFacConv);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedPerio payer(TabFacVisMedPerio $pFacConv) throws SysGehoAppException {
		try {
			return sisvFacVisMedPerio.payer($pFacConv);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedPerio ajouterPieceJte(TabFacVisMedPerio p$entite) throws BaseException {
		try {
			return sisvFacVisMedPerio.ajouterPieceJte(p$entite);
		} catch (BaseException sdr) {
			session.setRollbackOnly();
			throw sdr;
		} catch (Exception e) {
			session.setRollbackOnly();
			throw new SysGehoSystemException("Erreur d'ajout de la pièce!", e);
		}

	}
	
}
