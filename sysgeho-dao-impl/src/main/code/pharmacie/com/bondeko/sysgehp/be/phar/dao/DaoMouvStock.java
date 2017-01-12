package com.bondeko.sysgehp.be.phar.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.phar.dao.IDaoMouvStock;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;

@Stateless
public class DaoMouvStock extends BaseDao<TabMouvStock, String> implements IDaoMouvStock{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoMouvStock.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@Override
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException 
	{
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codMouvStock='" + id + "' ";
			
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

	@Override
	public <X extends BaseEntity> List<X> findAll(X entity)
			throws SysGehoPersistenceException 
	{
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" ORDER BY o.codMouvStock ";
			
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
			throws SysGehoPersistenceException 
	{
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabMouvStock currentMouvStock = (TabMouvStock)entity;
		if(currentMouvStock.getTabProd() != null && !currentMouvStock.getTabProd().getLibProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabProd.libProd) like '%"+currentMouvStock.getTabProd().getLibProd()+"%'";
		}
		if(currentMouvStock.getEnuTypMouv()!= null && !currentMouvStock.getEnuTypMouv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.enuTypMouv) like '%"+currentMouvStock.getEnuTypMouv()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codMouvStock ";

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
