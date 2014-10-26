package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabExam;

@Stateless
public class DaoExam extends BaseDao<TabExam, String> implements IDaoExam{
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoExam.class); 
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}


	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.codExam='" + id + "' ";
			
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
			" ORDER BY o.codExam ";
			
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
		TabExam currentExam = (TabExam)entity;
		if(currentExam != null && currentExam.getCodExam()!= null 
				&& !currentExam.getCodExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.codExam) like '%"+currentExam.getCodExam()+"%'";
		}
		if(currentExam != null && currentExam.getTabPat()!= null 
				&& currentExam.getTabPat().getLibNom() != null
				&& !currentExam.getTabPat().getLibNom().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"+currentExam.getTabPat().getLibNom()+"%'";
		}
		if(currentExam != null && currentExam.getTabTypExam()!= null 
				&& currentExam.getTabTypExam().getCodTypExam() != null
				&& !currentExam.getTabTypExam().getLibTypExam().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabTypExam.libTypExam) like '%"+currentExam.getTabTypExam().getLibTypExam()+"%'";
		}
		if(currentExam != null && currentExam.getTabVisMedEmb() != null 
				&& currentExam.getTabVisMedEmb().getCodVisMedEmb() != null
				&& !currentExam.getTabVisMedEmb().getCodVisMedEmb().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"+currentExam.getTabVisMedEmb().getCodVisMedEmb()+"%'";
		}
		if(currentExam != null && currentExam.getTabVisMedPerio() != null 
				&& currentExam.getTabVisMedPerio().getCodVisMedPerio() != null
				&& !currentExam.getTabVisMedPerio().getCodVisMedPerio().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"+currentExam.getTabVisMedPerio().getCodVisMedPerio()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.codExam ";

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
	public List<TabExam> findByRefFac(String refFac)
	throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabExam o where o.refFac='" + refFac +
			"' ORDER BY o.codExam ";

			logger.debug("Requete <" + query + ">");

			List<TabExam> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabExam>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}
	 
	@Override
	public List<TabExam> findExamNonPaieByPatient(String codPat)
	throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM TabExam o where o.booPaie='0' AND o.tabPat.codPat='" + codPat +
			"' ORDER BY o.codExam ";

			logger.debug("Requete <" + query + ">");

			List<TabExam> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug("Nombre d'éléments trouvés : " + (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabExam>();
			}
			return v$list;
		}catch(SysGehoPersistenceException sdr){
			throw sdr;
		}
	}

}
