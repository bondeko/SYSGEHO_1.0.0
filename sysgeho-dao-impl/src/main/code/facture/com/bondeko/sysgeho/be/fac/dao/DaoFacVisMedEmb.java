package com.bondeko.sysgeho.be.fac.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;
@Stateless
public class DaoFacVisMedEmb extends BaseDao<TabFacVisMedEmb, String> implements IDaoFacVisMedEmb{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoFacVisMedEmb.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.refFacVisMedEmb='" + id + "' ";
			
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
			" ORDER BY o.refFacVisMedEmb ";
			
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
		TabFacVisMedEmb currentFac = (TabFacVisMedEmb)entity;
		if(currentFac != null && currentFac.getRefFacVisMedEmb()!= null 
				&& !currentFac.getRefFacVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.refFacVisMedEmb) like '%"+currentFac.getRefFacVisMedEmb()+"%'";
		}
		if(currentFac != null && currentFac.getTabVisMedEmb()!= null 
				 && currentFac.getTabVisMedEmb().getCodVisMedEmb() != null
				 && !currentFac.getTabVisMedEmb().getCodVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"+currentFac.getTabVisMedEmb().getCodVisMedEmb()+"%'";
		}
		if(currentFac != null && currentFac.getTabVisMedEmb()!= null 
				 && currentFac.getTabVisMedEmb().getTabPat() != null
				 && currentFac.getTabVisMedEmb().getTabPat().getLibNom() != null
				 && !currentFac.getTabVisMedEmb().getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.tabPat.libNom) like '%"+currentFac.getTabVisMedEmb().getTabPat().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.refFacVisMedEmb ";

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
