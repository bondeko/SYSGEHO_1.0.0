package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;

@Stateless
public class DaoVisMedEmb extends BaseDao<TabVisMedEmb, String> implements IDaoVisMedEmb{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoVisMedEmb.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codVisMedEmb='" + id + "' ";
			
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
			" ORDER BY o.codVisMedEmb ";
			
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
		TabVisMedEmb currentVisMedEmb = (TabVisMedEmb)entity;
		if(currentVisMedEmb != null && currentVisMedEmb.getCodVisMedEmb()!= null 
				&& !currentVisMedEmb.getCodVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codVisMedEmb) like '%"+currentVisMedEmb.getCodVisMedEmb()+"%'";
		}
		if(currentVisMedEmb != null && currentVisMedEmb.getTabPat()!= null 
				 && currentVisMedEmb.getTabPat().getLibNom() != null
				 && !currentVisMedEmb.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentVisMedEmb.getTabPat().getLibNom()+"%'";
		}
		if(currentVisMedEmb != null && currentVisMedEmb.getTabUsr() != null 
				&& currentVisMedEmb.getTabUsr().getLibNom() != null
				&& !currentVisMedEmb.getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"+currentVisMedEmb.getTabUsr().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codVisMedEmb ";

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
