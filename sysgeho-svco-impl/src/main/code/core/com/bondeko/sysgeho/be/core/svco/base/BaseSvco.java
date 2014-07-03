package com.bondeko.sysgeho.be.core.svco.base;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.ejb.SessionContext;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;

public abstract class BaseSvco <T extends BaseEntity> implements IBaseSvco<T>{
	
	protected abstract IBaseSisv<T, ? extends Serializable> getBaseSisv();

	public abstract BaseLogger getLogger();

	@Resource
	private SessionContext sessionContext;
	
	public SessionContext getSessionContext(){
		return sessionContext;
	}
	protected void rollbackTransactionContext(){
		try {
			getSessionContext().setRollbackOnly();
		} catch (Exception e) {
			getLogger().warn("Erreur de récupération du Session Context : Vérifier sa redéfinition!", e);
			e.printStackTrace();
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException {
		try {
			
			return getBaseSisv().creer(p$entite);			
		} catch (BaseException e) {
			rollbackTransactionContext();
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			rollbackTransactionContext();
			String message =  e.getMessage();
			SysGehoAppException sysEx =  new SysGehoAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
		}
	}
	
	public <X extends BaseEntity> X modifier(X p$entite) throws SysGehoAppException {
		try {
			return getBaseSisv().modifier(p$entite);
		} catch (SysGehoPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			SysGehoAppException sbr = new SysGehoAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			SysGehoAppException sysEx =  new SysGehoAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}
	
	public <X extends BaseEntity> boolean supprimer(X p$entite) throws SysGehoAppException {
		try {
			((SysGehoBaseEntity) p$entite).setBooAct(BigDecimal.ZERO);
			 return getBaseSisv().supprimer(p$entite);
		} catch (SysGehoPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			SysGehoAppException sbr = new SysGehoAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			SysGehoAppException sysEx =  new SysGehoAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}
	
	public <X extends BaseEntity> void retirer(X p$entite) throws SysGehoAppException {
		try {
			 getBaseSisv().retirer(p$entite);
		} catch (SysGehoPersistenceException sdr) {
			sdr.printStackTrace();
			rollbackTransactionContext();
			SysGehoAppException sbr = new SysGehoAppException(sdr);
			throw sbr;
		} catch (Exception e) {
			
			rollbackTransactionContext();
			String message = e.getMessage() + " !";
			SysGehoAppException sysEx =  new SysGehoAppException(message, e);
			getLogger().error(message, sysEx);
			throw sysEx;
			
		}
	}


}
