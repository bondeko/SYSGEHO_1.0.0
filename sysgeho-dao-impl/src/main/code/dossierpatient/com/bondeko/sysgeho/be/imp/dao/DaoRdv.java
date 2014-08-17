package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;

@Stateless
public class DaoRdv extends BaseDao<TabRdv, String> implements IDaoRdv{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoRdv.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codRdv='" + id + "' ";
			
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
			" ORDER BY o.codRdv ";
			
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
		TabRdv currentRdv = (TabRdv)entity;
		if(currentRdv.getCodRdv()!= null && !currentRdv.getCodRdv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codRdv) like '%"+currentRdv.getCodRdv()+"%'";
		}
		if(currentRdv.getLibTypRdv()!= null && !currentRdv.getLibTypRdv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libTypRdv) like '%"+currentRdv.getLibTypRdv()+"%'";
		}
		if(currentRdv.getLibSvc()!= null && !currentRdv.getLibSvc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.libSvc) like '%"+currentRdv.getLibSvc()+"%'";
		}
		if(currentRdv.getTabPat()!= null && currentRdv.getTabPat().getLibNom()!= null && !currentRdv.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentRdv.getTabPat().getLibNom()+"%'";
		}
		if(currentRdv.getTabUsr()!= null && currentRdv.getTabUsr().getLibNom()!= null && !currentRdv.getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"+currentRdv.getTabUsr().getLibNom()+"%'";
		}
		System.out.println("currentRdv.getBooEstAnn() " + currentRdv.getBooEstAnn());
		System.out.println("currentRdv.getBEstAnn() " + currentRdv.getBEstAnn());
		if(currentRdv.getBooEstAnn()!= null ){
			clauseWhere = clauseWhere + "AND o.booEstAnn='"+currentRdv.getBooEstAnn()+"'";
		}
		if(currentRdv.getBooEstConf()!= null ){
			clauseWhere = clauseWhere + "AND o.booEstConf='"+currentRdv.getBooEstConf()+"'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codRdv ";

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
