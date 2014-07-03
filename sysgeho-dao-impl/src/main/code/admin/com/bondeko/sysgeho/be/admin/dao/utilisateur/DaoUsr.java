package com.bondeko.sysgeho.be.admin.dao.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;

@Stateless
public class DaoUsr extends BaseDao<TabUsr, String> implements IDaoUsr{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoUsr.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	public TabUsr authenticate(String p$login, String p$pwd) throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + TabUsr.class.getSimpleName() + " o " + 
			" WHERE o.codUsr='" + p$login + "' AND o.codPwd='" + p$pwd + "' ";

			logger.debug("Requete <" + query + ">");

			List v$list = getManager().createQuery(query).getResultList();
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return (TabUsr)v$list.get(0);
		}catch(SysGehoPersistenceException sdr){
			throw sdr; 
		}
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codUsr='" + id + "' ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list.get(0);
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> findAll(X entity)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" ORDER BY o.codUsr ";
			
			logger.debug("Requete <" + query + ">");
			
			List<X> v$list = getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}
	
	public <X extends BaseEntity> List<X> findByExample(X entity)
	throws SysGehoPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabUsr currentUsr = (TabUsr)entity;
		if(currentUsr.getCodUsr() != null && !currentUsr.getCodUsr().equals("")){
			clauseWhere = clauseWhere + " AND upper(o.codUsr) like '%"+currentUsr.getCodUsr()+"%'";
		}
		if(currentUsr.getLibNom() != null && !currentUsr.getLibNom().equals("")){
			clauseWhere = clauseWhere + " AND upper(o.libNom) like '%"+currentUsr.getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codUsr ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}
	
}
