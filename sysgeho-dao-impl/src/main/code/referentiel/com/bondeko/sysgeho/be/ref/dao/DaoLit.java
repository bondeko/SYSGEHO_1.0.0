package com.bondeko.sysgeho.be.ref.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.ref.entity.TabLit;

@Stateless
public class DaoLit extends BaseDao<TabLit, String> implements IDaoLit{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoLit.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codLit='" + id + "' ";
			
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
			" ORDER BY o.codLit ";
			
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

	@Override
	public <X extends BaseEntity> List<X> findByExample(X entity)
			throws SysGehoPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabLit currentLit = (TabLit)entity;
		if(currentLit.getNumLit()!= null && !currentLit.getNumLit().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.numLit) like '%"+currentLit.getNumLit()+"%'";
		}
		if(currentLit.getLibLit()!= null && !currentLit.getLibLit().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libLit) like '%"+currentLit.getLibLit()+"%'";
		}
		if(currentLit.getTabChrHospi()!= null && currentLit.getTabChrHospi().getNumChrHospi() != null 
				&& !currentLit.getTabChrHospi().getNumChrHospi().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabChrHospi.numChrHospi) like '%"+currentLit.getTabChrHospi().getNumChrHospi()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codLit ";

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
	
	@Override
	public List<TabLit> findLitByNumChr(String numChr)
	throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabLit o where o.etatEnt != '2012' AND o.tabChrHospi.numChrHospi='" + numChr +
			"' ORDER BY o.codLit ";

			logger.debug("Requete <" + query + ">");

			List<TabLit> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabLit>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}

}
