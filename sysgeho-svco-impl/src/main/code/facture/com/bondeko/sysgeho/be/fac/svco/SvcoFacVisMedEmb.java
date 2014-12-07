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
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;
import com.bondeko.sysgeho.be.fac.sisv.ISisvFacVisMedEmb;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoFacVisMedEmb extends BaseSvco<TabFacVisMedEmb> implements IRemoteFacVisMedEmb, ILocalFacVisMedEmb{
	
	@EJB
	ISisvFacVisMedEmb sisvFacVisMedEmb;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoFacVisMedEmb.class);
	
	@Override
	protected IBaseSisv<TabFacVisMedEmb, String> getBaseSisv() {
		return sisvFacVisMedEmb;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvFacVisMedEmb.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvFacVisMedEmb.rechercherTout(entity);
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
			return sisvFacVisMedEmb.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedEmb valider(TabFacVisMedEmb $pFacConv) throws SysGehoAppException {
		try {
			return sisvFacVisMedEmb.valider($pFacConv);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedEmb payer(TabFacVisMedEmb $pFacConv) throws SysGehoAppException {
		try {
			return sisvFacVisMedEmb.payer($pFacConv);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabFacVisMedEmb ajouterPieceJte(TabFacVisMedEmb p$entite) throws BaseException {
		try {
			return sisvFacVisMedEmb.ajouterPieceJte(p$entite);
		} catch (BaseException sdr) {
			session.setRollbackOnly();
			throw sdr;
		} catch (Exception e) {
			session.setRollbackOnly();
			throw new SysGehoSystemException("Erreur d'ajout de la pièce!", e);
		}

	}
	
}
