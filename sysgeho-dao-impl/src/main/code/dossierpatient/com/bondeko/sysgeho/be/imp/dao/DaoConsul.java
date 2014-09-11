package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

@Stateless
public class DaoConsul extends BaseDao<TabConsul, String> implements IDaoConsul{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoConsul.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codConsul='" + id + "' ";
			
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
			" ORDER BY o.codConsul ";
			
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
		TabConsul currentConsul = (TabConsul)entity;
		if(currentConsul != null && currentConsul.getCodConsul()!= null 
				&& !currentConsul.getCodConsul().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codConsul) like '%"+currentConsul.getCodConsul()+"%'";
		}
		if(currentConsul != null && currentConsul.getTabPat()!= null 
				 && currentConsul.getTabPat().getLibNom() != null
				 && !currentConsul.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentConsul.getTabPat().getLibNom()+"%'";
		}
		if(currentConsul != null && currentConsul.getTabUsr() != null 
				&& currentConsul.getTabUsr().getLibNom() != null
				&& !currentConsul.getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"+currentConsul.getTabUsr().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codConsul ";

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
	public List<TabConsul> findByRefFac(String refFac)
	throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabConsul o where o.refFac='" + refFac +
			"' ORDER BY o.codConsul ";

			logger.debug("Requete <" + query + ">");

			List<TabConsul> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabConsul>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}
	 
	@Override
	public List<TabConsul> findConsulNonPaieByPatient(String codPat)
	throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabConsul o where o.booPaie='0' AND o.tabPat.codPat='" + codPat +
			"' ORDER BY o.codConsul ";

			logger.debug("Requete <" + query + ">");

			List<TabConsul> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabConsul>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}

}
