package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.math.BigDecimal;
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
			
			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
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
			
			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
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
		if(currentRdv!= null && currentRdv.getCodRdv()!= null && !currentRdv.getCodRdv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codRdv) like '%"+currentRdv.getCodRdv()+"%'";
		}
		if(currentRdv!= null && currentRdv.getTabTypRdv()!= null 
				&& currentRdv.getTabTypRdv().getLibTypRdv()!= null 
				&& !currentRdv.getTabTypRdv().getLibTypRdv().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabTypRdv.libTypRdv) like '%"+currentRdv.getTabTypRdv().getLibTypRdv()+"%'";
		}
		if(currentRdv!= null && currentRdv.getTabSvc()!=null 
				&& currentRdv.getTabSvc().getLibSvc()!= null 
				&& !currentRdv.getTabSvc().getLibSvc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabSvc.libSvc) like '%"+currentRdv.getTabSvc().getLibSvc()+"%'";
		}
		if(currentRdv!= null && currentRdv.getTabPat()!= null 
				&& currentRdv.getTabPat().getLibNom()!= null 
				&& !currentRdv.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentRdv.getTabPat().getLibNom()+"%'";
		}
		if(currentRdv!= null && currentRdv.getTabUsr()!= null 
				&& currentRdv.getTabUsr().getLibNom()!= null 
				&& !currentRdv.getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"+currentRdv.getTabUsr().getLibNom()+"%'";
		}

		if(currentRdv!= null && currentRdv.getBooEstAnn()!= null 
				&& currentRdv.getBooEstAnn().equals(BigDecimal.ONE)){
			clauseWhere = clauseWhere + "AND o.booEstAnn='"+currentRdv.getBooEstAnn()+"'";
		}
		if(currentRdv!= null && currentRdv.getBooEstConf()!= null 
				&& currentRdv.getBooEstConf().equals(BigDecimal.ONE) ){
			clauseWhere = clauseWhere + "AND o.booEstConf='"+currentRdv.getBooEstConf()+"'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codRdv ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'�l�ments trouv�s : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}

}
