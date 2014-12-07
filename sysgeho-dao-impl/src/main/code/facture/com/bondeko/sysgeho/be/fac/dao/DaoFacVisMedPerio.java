package com.bondeko.sysgeho.be.fac.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;
@Stateless
public class DaoFacVisMedPerio extends BaseDao<TabFacVisMedPerio, String> implements IDaoFacVisMedPerio{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoFacVisMedPerio.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.refFacVisMedPerio='" + id + "' ";
			
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
			" ORDER BY o.refFacVisMedPerio ";
			
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
		TabFacVisMedPerio currentFac = (TabFacVisMedPerio)entity;
		if(currentFac != null && currentFac.getRefFacVisMedPerio()!= null 
				&& !currentFac.getRefFacVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.refFacVisMedPerio) like '%"+currentFac.getRefFacVisMedPerio()+"%'";
		}
		if(currentFac != null && currentFac.getTabVisMedPerio()!= null 
				 && currentFac.getTabVisMedPerio().getCodVisMedPerio() != null
				 && !currentFac.getTabVisMedPerio().getCodVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"+currentFac.getTabVisMedPerio().getCodVisMedPerio()+"%'";
		}
		if(currentFac != null && currentFac.getTabVisMedPerio()!= null 
				 && currentFac.getTabVisMedPerio().getTabSoc() != null
				 && currentFac.getTabVisMedPerio().getTabSoc().getCodSoc() != null
				 && !currentFac.getTabVisMedPerio().getTabSoc().getCodSoc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.tabSoc.codSoc) like '%"+currentFac.getTabVisMedPerio().getTabSoc().getCodSoc()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.refFacVisMedPerio ";

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
