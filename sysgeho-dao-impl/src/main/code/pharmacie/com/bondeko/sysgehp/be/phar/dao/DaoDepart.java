package com.bondeko.sysgehp.be.phar.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.phar.dao.IDaoDepart;
import com.bondeko.sysgeho.be.phar.entity.TabDepart;
import com.bondeko.sysgeho.be.phar.entity.TabFour;

@Stateless
public class DaoDepart extends BaseDao<TabDepart, String> implements IDaoDepart{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoDepart.class); 
	
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
			" WHERE o.codDepart='" + id + "' ";
			
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
			" ORDER BY o.codDepart ";
			
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
		TabFour currentFour = (TabFour)entity;
		if(currentFour.getCodFour()!= null && !currentFour.getCodFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codFour) like '%"+currentFour.getCodFour()+"%'";
		}
		if(currentFour.getLibFour()!= null && !currentFour.getLibFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libFour) like '%"+currentFour.getLibFour()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codDepart ";

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
