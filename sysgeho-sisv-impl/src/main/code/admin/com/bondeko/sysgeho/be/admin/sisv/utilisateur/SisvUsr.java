package com.bondeko.sysgeho.be.admin.sisv.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.admin.dao.utilisateur.IDaoUsr;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.util.InfoUser;

@Stateless
public class SisvUsr extends BaseSisv<TabUsr, String> implements ISisvUsr {

	private static BaseLogger logger = BaseLogger.getLogger(SisvUsr.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoUsr daoUsr; 

	public TabUsr authenticate(String p$login, String p$pwd)
			throws SysGehoSystemException {
		try {
			return daoUsr.authenticate(p$login, p$pwd);
			//Faire un controle si le mot de passe est expiré
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd, InfoUser infoUser)
			throws SysGehoSystemException {
		try {
			if(p$newPwd == null || p$newPwd.isEmpty()){
				SysGehoSystemException sdr = new SysGehoSystemException("Nouveau mot de passe vide");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			if(p$newPwd.length()>30){
				SysGehoSystemException sdr = new SysGehoSystemException("Taille du nouveau mot de passe trés longue, moins de 30 caractéres");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			if(p$oldPwd.equals(p$newPwd)){
				SysGehoSystemException sdr = new SysGehoSystemException("Ancien mot de passe identique au nouveau");
				logger.error(sdr.getMessage(), sdr);
				throw sdr;
			}
			//Récupération des informations de l'utilisateur en base de données		
			 TabUsr oldUsr = daoUsr.findById(new TabUsr(), p$login);
			 if(null != oldUsr){
				 oldUsr.setCodPwd(p$newPwd);
				 oldUsr.setInfoUser(infoUser);
				 return daoUsr.update(oldUsr);
			 }
		} catch (SysGehoPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IBaseDao<TabUsr, String> getBaseDao() {
		return daoUsr;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoUsr.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoUsr.findAll(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity) throws SysGehoSystemException {
		
		try {
			return daoUsr.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

}
