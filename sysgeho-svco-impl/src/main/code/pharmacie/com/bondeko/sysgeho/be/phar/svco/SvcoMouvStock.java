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
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;
import com.bondeko.sysgeho.be.phar.sisv.ISisvMouvStock;
import com.bondeko.sysgeho.be.phar.sisv.ISisvProd;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoMouvStock extends BaseSvco<TabMouvStock> implements IRemoteMouvStock, ILocalMouvStock{

	@EJB
	ISisvMouvStock sisvMouvStock;
	
	@EJB
	ISisvProd sisvProd;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoMouvStock.class);
	
	@Override
	protected IBaseSisv<TabMouvStock, String> getBaseSisv() {
		return sisvMouvStock;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvMouvStock.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvMouvStock.rechercherTout(entity);
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
			return sisvMouvStock.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabMouvStock valider(TabMouvStock $pmouv) throws SysGehoAppException  {
		try {
			return sisvMouvStock.valider($pmouv);
		} catch (SysGehoSystemException e) {
			logger.debug("Erreur de validation de l'examen");
			e.printStackTrace();
			SysGehoAppException sbr = new SysGehoAppException(e);
			throw sbr;
		}
	}
}

