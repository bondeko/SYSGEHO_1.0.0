package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;

@Stateless
public class DaoRapVisMedPerio extends BaseDao<TabRapVisMedPerio, String> implements IDaoRapVisMedPerio{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoRapVisMedPerio.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codRapVisMedPerio='" + id + "' ";
			
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
			" ORDER BY o.codRapVisMedPerio ";
			
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
		TabRapVisMedPerio currentRapVisMedPerio = (TabRapVisMedPerio)entity;
		if(currentRapVisMedPerio!= null && currentRapVisMedPerio.getCodRapVisMedPerio()!= null 
				&& !currentRapVisMedPerio.getCodRapVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codRapVisMedPerio) like '%"+currentRapVisMedPerio.getCodRapVisMedPerio()+"%'";
		}
		if(currentRapVisMedPerio!= null && currentRapVisMedPerio.getTabVisMedPerio()!= null 
				&& currentRapVisMedPerio.getTabVisMedPerio().getCodVisMedPerio()!= null 
				&& !currentRapVisMedPerio.getTabVisMedPerio().getCodVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"+currentRapVisMedPerio.getTabVisMedPerio().getCodVisMedPerio()+"%'";
		}
		if(currentRapVisMedPerio!= null && currentRapVisMedPerio.getTabPat()!= null 
				&& null != currentRapVisMedPerio.getTabPat()
				&& currentRapVisMedPerio.getTabPat().getLibNom()!= null 
				&& !currentRapVisMedPerio.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentRapVisMedPerio.getTabPat().getLibNom()+"%'";
		}
		if(currentRapVisMedPerio!= null && currentRapVisMedPerio.getTabVisMedPerio()!= null 
				&& null != currentRapVisMedPerio.getTabVisMedPerio().getTabUsr()
				&& currentRapVisMedPerio.getTabVisMedPerio().getTabUsr().getLibNom()!= null 
				&& !currentRapVisMedPerio.getTabVisMedPerio().getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.tabUsr.libNom) like '%"+currentRapVisMedPerio.getTabVisMedPerio().getTabUsr().getLibNom()+"%'";
		}
		if(currentRapVisMedPerio!= null && currentRapVisMedPerio.getTabVisMedPerio()!= null 
				&& null != currentRapVisMedPerio.getTabVisMedPerio().getTabSoc()
				&& currentRapVisMedPerio.getTabVisMedPerio().getTabSoc().getLibSoc()!= null 
				&& !currentRapVisMedPerio.getTabVisMedPerio().getTabSoc().getLibSoc().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.tabSoc.libSoc) like '%"+currentRapVisMedPerio.getTabVisMedPerio().getTabSoc().getLibSoc()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codRapVisMedPerio ";

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
