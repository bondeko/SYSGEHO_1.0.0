package com.bondeko.sysgehp.be.phar.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.phar.dao.IDaoSousCatProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;

@Stateless
public class DaoSousCatProd extends BaseDao<TabSousCatProd, String> implements IDaoSousCatProd{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoSousCatProd.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codSousCatProd='" + id + "' ";
			
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
			" ORDER BY o.codSousCatProd ";
			
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
		TabSousCatProd currentSousCatProd = (TabSousCatProd)entity;
		if(currentSousCatProd != null && currentSousCatProd.getCodSousCatProd()!= null 
				&& !currentSousCatProd.getCodSousCatProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codSousCatProd) like '%"+currentSousCatProd.getCodSousCatProd()+"%'";
		}
		if(currentSousCatProd != null && currentSousCatProd.getLibSousCatProd()!= null 
				&& !currentSousCatProd.getLibSousCatProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libSousCatProd) like '%"+currentSousCatProd.getLibSousCatProd()+"%'";
		}
		if(currentSousCatProd != null && currentSousCatProd.getTabCatProd()!= null 
				&& currentSousCatProd.getTabCatProd().getCodCatProd() != null
				&& !currentSousCatProd.getTabCatProd().getCodCatProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabCatProd.codCatProd) like '%"+currentSousCatProd.getTabCatProd().getCodCatProd()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codSousCatProd ";

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
