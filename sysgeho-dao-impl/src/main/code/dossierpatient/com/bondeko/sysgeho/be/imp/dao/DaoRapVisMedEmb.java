package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;

@Stateless
public class DaoRapVisMedEmb extends BaseDao<TabRapVisMedEmb, String> implements IDaoRapVisMedEmb{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoRapVisMedEmb.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codRapVisMedEmb='" + id + "' ";
			
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
			" ORDER BY o.codRapVisMedEmb ";
			
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
		TabRapVisMedEmb currentRapVisMedEmb = (TabRapVisMedEmb)entity;
		if(currentRapVisMedEmb!= null && currentRapVisMedEmb.getCodRapVisMedEmb()!= null 
				&& !currentRapVisMedEmb.getCodRapVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codRapVisMedEmb) like '%"+currentRapVisMedEmb.getCodRapVisMedEmb()+"%'";
		}
		if(currentRapVisMedEmb!= null && currentRapVisMedEmb.getTabVisMedEmb()!= null 
				&& currentRapVisMedEmb.getTabVisMedEmb().getCodVisMedEmb()!= null 
				&& !currentRapVisMedEmb.getTabVisMedEmb().getCodVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"+currentRapVisMedEmb.getTabVisMedEmb().getCodVisMedEmb()+"%'";
		}
		if(currentRapVisMedEmb!= null && currentRapVisMedEmb.getTabVisMedEmb()!= null 
				&& null != currentRapVisMedEmb.getTabVisMedEmb().getTabPat()
				&& currentRapVisMedEmb.getTabVisMedEmb().getTabPat().getLibNom()!= null 
				&& !currentRapVisMedEmb.getTabVisMedEmb().getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.tabPat.libNom) like '%"+currentRapVisMedEmb.getTabVisMedEmb().getTabPat().getLibNom()+"%'";
		}
		if(currentRapVisMedEmb!= null && currentRapVisMedEmb.getTabVisMedEmb()!= null 
				&& null != currentRapVisMedEmb.getTabVisMedEmb().getTabUsr()
				&& currentRapVisMedEmb.getTabVisMedEmb().getTabUsr().getLibNom()!= null 
				&& !currentRapVisMedEmb.getTabVisMedEmb().getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.tabUsr.libNom) like '%"+currentRapVisMedEmb.getTabVisMedEmb().getTabUsr().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codRapVisMedEmb ";

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
