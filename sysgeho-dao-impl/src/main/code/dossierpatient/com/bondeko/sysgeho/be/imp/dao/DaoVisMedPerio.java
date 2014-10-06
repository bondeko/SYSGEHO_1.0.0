package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;

@Stateless
public class DaoVisMedPerio extends BaseDao<TabVisMedPerio, String> implements IDaoVisMedPerio{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoVisMedPerio.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codVisMedPerio='" + id + "' ";
			
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
			" ORDER BY o.codVisMedPerio ";
			
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
		TabVisMedPerio currentVisMedPerio = (TabVisMedPerio)entity;
		if(currentVisMedPerio != null && currentVisMedPerio.getCodVisMedPerio()!= null 
				&& !currentVisMedPerio.getCodVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codVisMedPerio) like '%"+currentVisMedPerio.getCodVisMedPerio()+"%'";
		}
		if(currentVisMedPerio != null && currentVisMedPerio.getTabSoc()!= null 
				 && currentVisMedPerio.getTabSoc().getLibSoc() != null
				 && !currentVisMedPerio.getTabSoc().getLibSoc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabSoc.libSoc) like '%"+currentVisMedPerio.getTabSoc().getLibSoc()+"%'";
		}
		if(currentVisMedPerio != null && currentVisMedPerio.getTabUsr() != null 
				&& currentVisMedPerio.getTabUsr().getLibNom() != null
				&& !currentVisMedPerio.getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"+currentVisMedPerio.getTabUsr().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codVisMedPerio ";

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
