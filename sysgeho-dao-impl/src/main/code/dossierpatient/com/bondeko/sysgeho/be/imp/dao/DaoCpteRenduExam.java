package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;

@Stateless
public class DaoCpteRenduExam extends BaseDao<TabCpteRenduExam, String> implements IDaoCpteRenduExam{
	
private static BaseLogger logger = BaseLogger.getLogger(DaoCpteRenduExam.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codCpteRenduExam='" + id + "' ";
			
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
			" ORDER BY o.codCpteRenduExam ";
			
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
		TabCpteRenduExam currentCpteRenduExam = (TabCpteRenduExam)entity;
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getCodCpteRenduExam()!= null 
				&& !currentCpteRenduExam.getCodCpteRenduExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codCpteRenduExam) like '%"+currentCpteRenduExam.getCodCpteRenduExam()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& currentCpteRenduExam.getTabExam().getCodExam()!= null 
				&& !currentCpteRenduExam.getTabExam().getCodExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.codExam) like '%"+currentCpteRenduExam.getTabExam().getCodExam()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& null != currentCpteRenduExam.getTabExam().getTabPat()
				&& currentCpteRenduExam.getTabExam().getTabPat().getLibNom()!= null 
				&& !currentCpteRenduExam.getTabExam().getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.tabPat.libNom) like '%"+currentCpteRenduExam.getTabExam().getTabPat().getLibNom()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& null != currentCpteRenduExam.getTabExam().getTabTypExam()
				&& null != currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam()
				&& !currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.tabTypExam.codTypExam) like '%"+currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codCpteRenduExam ";

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
	
	public List<TabCpteRenduExam> findByDate(String dateDeb, String dateFin)
	throws SysGehoPersistenceException {
try {
	String query = "";
	if (dateDeb != null || dateFin != null) {
		query = "SELECT o FROM  TabCpteRenduExam o " + " WHERE o.dat >= "
				+ "'" + dateDeb + "'" + " AND o.dat <= " + "'"
				+ dateFin + "'" + " ORDER BY o.dat ";
	} else {
		query = "SELECT o FROM  o TabCpteRenduExam ORDER BY o.dat ";
	}

	logger.debug("Requete <" + query + ">");

	List<TabCpteRenduExam> v$list = getManager().createQuery(query)
			.getResultList();

	getLogger().debug(
			"Nombre d'éléments trouvés : "
					+ (v$list == null ? "0" : v$list.size()));
	if ((v$list == null) || (v$list.size() <= 0)) {
		return new ArrayList<TabCpteRenduExam>();
	}
	return v$list;
} catch (SysGehoPersistenceException sdr) {
	throw sdr;
}
}
	@Override
	public List<TabCpteRenduExam> findByExampleAndDate(TabCpteRenduExam currentCpteRenduExam, String dateDeb, String dateFin)
			throws SysGehoPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001' AND " +
		"o.dat >= "	+ "'" + dateDeb + "'" + " AND o.dat <= " + "'"
			+ dateFin + "' ";
		//TabCpteRenduExam currentCpteRenduExam = (TabCpteRenduExam)entity;
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getCodCpteRenduExam()!= null 
				&& !currentCpteRenduExam.getCodCpteRenduExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codCpteRenduExam) like '%"+currentCpteRenduExam.getCodCpteRenduExam()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& currentCpteRenduExam.getTabExam().getCodExam()!= null 
				&& !currentCpteRenduExam.getTabExam().getCodExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.codExam) like '%"+currentCpteRenduExam.getTabExam().getCodExam()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& null != currentCpteRenduExam.getTabExam().getTabPat()
				&& currentCpteRenduExam.getTabExam().getTabPat().getLibNom()!= null 
				&& !currentCpteRenduExam.getTabExam().getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.tabPat.libNom) like '%"+currentCpteRenduExam.getTabExam().getTabPat().getLibNom()+"%'";
		}
		if(currentCpteRenduExam!= null && currentCpteRenduExam.getTabExam()!= null 
				&& null != currentCpteRenduExam.getTabExam().getTabTypExam()
				&& null != currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam()
				&& !currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabExam.tabTypExam.codTypExam) like '%"+currentCpteRenduExam.getTabExam().getTabTypExam().getCodTypExam()+"%'";
		}
		try{
			String query = "SELECT o FROM " + currentCpteRenduExam.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.dat ";

			logger.debug("Requete <" + query + ">");

			List<TabCpteRenduExam> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabCpteRenduExam>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}


}
