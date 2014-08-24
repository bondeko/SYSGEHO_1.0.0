package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;

@Stateless
public class DaoCpteRenduConsul extends BaseDao<TabCpteRenduConsul, String> implements IDaoCpteRenduConsul{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoCpteRenduConsul.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codCpteRenduConsul='" + id + "' ";
			
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
			" ORDER BY o.codCpteRenduConsul ";
			
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
		TabCpteRenduConsul currentCpteRenduConsul = (TabCpteRenduConsul)entity;
		if(currentCpteRenduConsul.getCodCpteRenduConsul()!= null && !currentCpteRenduConsul.getCodCpteRenduConsul().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codCpteRenduConsul) like '%"+currentCpteRenduConsul.getCodCpteRenduConsul()+"%'";
		}
		if(currentCpteRenduConsul.getTabConsul()!= null && !currentCpteRenduConsul.getTabConsul().getCodConsul().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabConsul.codConsul) like '%"+currentCpteRenduConsul.getTabConsul().getCodConsul()+"%'";
		}
		if(currentCpteRenduConsul.getTabConsul()!= null && null != currentCpteRenduConsul.getTabConsul().getTabPat()
				&& !currentCpteRenduConsul.getTabConsul().getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabConsul.tabPat.libNom) like '%"+currentCpteRenduConsul.getTabConsul().getTabPat().getLibNom()+"%'";
		}
		if(currentCpteRenduConsul.getTabConsul()!= null && null != currentCpteRenduConsul.getTabConsul().getTabUsr()
				&& !currentCpteRenduConsul.getTabConsul().getTabUsr().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabConsul.tabUsr.libNom) like '%"+currentCpteRenduConsul.getTabConsul().getTabUsr().getLibNom()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codCpteRenduConsul ";

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
