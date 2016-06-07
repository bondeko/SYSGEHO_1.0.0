package com.bondeko.sysgeho.be.fac.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
@Stateless
public class DaoFacConv extends BaseDao<TabFacConv, String> implements IDaoFacConv{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoFacConv.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.refFacConv='" + id + "' ";
			
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
			" ORDER BY o.tabSoc, o.datFac, o.refFacConv ";
			
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
		TabFacConv currentFac = (TabFacConv)entity;
		if(currentFac != null && currentFac.getRefFacConv()!= null 
				&& !currentFac.getRefFacConv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.refFacConv) like '%"+currentFac.getRefFacConv()+"%'";
		}
		if(currentFac != null && currentFac.getTabSoc()!= null 
				 && currentFac.getTabSoc().getLibSoc() != null
				 && !currentFac.getTabSoc().getLibSoc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabSoc.libSoc) like '%"+currentFac.getTabSoc().getLibSoc()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.tabSoc, o.datFac, o.refFacConv ";

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
	public List<TabFacConv> findBySocMonthYear(String codSoc, String month, String year)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabFacConv o where o.tabSoc.codSoc='" + codSoc + "' AND o.enuMoisFac='" + month +"' AND o.codExeFis='"+year+"' ORDER BY o.enuMoisFac, o.datFac";

			logger.debug("Requete <" + query + ">");

			List<TabFacConv> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabFacConv>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}
}
