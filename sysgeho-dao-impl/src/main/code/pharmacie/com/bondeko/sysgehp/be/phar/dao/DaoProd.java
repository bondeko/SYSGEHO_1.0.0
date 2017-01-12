package com.bondeko.sysgehp.be.phar.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.phar.dao.IDaoProd;
import com.bondeko.sysgeho.be.phar.entity.TabProd;

@Stateless
public class DaoProd extends BaseDao<TabProd, String> implements IDaoProd{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoProd.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codProd='" + id + "' ";
			
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
			" ORDER BY o.codProd ";
			
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
		TabProd currentProd = (TabProd)entity;
		if(currentProd != null && currentProd.getCodProd()!= null 
				&& !currentProd.getCodProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codProd) like '%"+currentProd.getCodProd()+"%'";
		}
		if(currentProd != null && currentProd.getLibProd()!= null 
				&& !currentProd.getLibProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libProd) like '%"+currentProd.getLibProd()+"%'";
		}
		if(currentProd != null && currentProd.getTabSousCatProd()!= null 
				&& currentProd.getTabSousCatProd().getCodSousCatProd() != null
				&& !currentProd.getTabSousCatProd().getCodSousCatProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabSousCatProd.codSousCatProd) like '%"+currentProd.getTabSousCatProd().getCodSousCatProd()+"%'";
		}
		if(currentProd != null && currentProd.getTabSousCatProd().getTabCatProd()!= null 
				&& currentProd.getTabSousCatProd().getTabCatProd().getCodCatProd() != null
				&& !currentProd.getTabSousCatProd().getTabCatProd().getCodCatProd().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabSousCatProd.tabCatProd.codCatProd) like '%"+currentProd.getTabSousCatProd().getTabCatProd().getCodCatProd()+"%'";
		}
		if(currentProd != null && currentProd.getTabFour()!= null 
				&& currentProd.getTabFour().getCodFour() != null
				&& !currentProd.getTabFour().getCodFour().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabFour.codFour) like '%"+currentProd.getTabFour().getCodFour()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codProd ";

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
