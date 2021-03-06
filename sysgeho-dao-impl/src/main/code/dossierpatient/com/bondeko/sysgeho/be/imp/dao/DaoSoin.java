package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

@Stateless
public class DaoSoin extends BaseDao<TabSoin, String> implements IDaoSoin {

	private static BaseLogger logger = BaseLogger.getLogger(DaoSoin.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o " + " WHERE o.codSoin='" + id + "' ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return null;
			}
			return v$list.get(0);
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> findAll(X entity)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o " + " ORDER BY o.codSoin ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> findByExample(X entity)
			throws SysGehoPersistenceException {
		String clauseWhere = "1=1 AND o.etatEnt != '2001'";
		TabSoin currentSoin = (TabSoin) entity;
		if (currentSoin != null && currentSoin.getCodSoin() != null
				&& !currentSoin.getCodSoin().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.codSoin) like '%"
					+ currentSoin.getCodSoin() + "%'";
		}
		if (currentSoin != null && currentSoin.getTabPat() != null
				&& currentSoin.getTabPat().getLibNom() != null
				&& !currentSoin.getTabPat().getLibNom().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"
					+ currentSoin.getTabPat().getLibNom() + "%'";
		}
		if (currentSoin != null && currentSoin.getTabTypSoin() != null
				&& currentSoin.getTabTypSoin().getCodTypSoin() != null
				&& !currentSoin.getTabTypSoin().getLibTypSoin().equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabTypSoin.libTypSoin) like '%"
					+ currentSoin.getTabTypSoin().getLibTypSoin() + "%'";
		}
		if (currentSoin != null && currentSoin.getTabVisMedEmb() != null
				&& currentSoin.getTabVisMedEmb().getCodVisMedEmb() != null
				&& !currentSoin.getTabVisMedEmb().getCodVisMedEmb().equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"
					+ currentSoin.getTabVisMedEmb().getCodVisMedEmb() + "%'";
		}
		if (currentSoin != null
				&& currentSoin.getTabVisMedPerio() != null
				&& currentSoin.getTabVisMedPerio().getCodVisMedPerio() != null
				&& !currentSoin.getTabVisMedPerio().getCodVisMedPerio()
						.equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"
					+ currentSoin.getTabVisMedPerio().getCodVisMedPerio()
					+ "%'";
		}
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o where " + clauseWhere + " ORDER BY o.codSoin ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<X>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	@Override
	public List<TabSoin> findByRefFac(String refFac)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabSoin o where o.refFac='" + refFac
					+ "' ORDER BY o.codSoin ";

			logger.debug("Requete <" + query + ">");

			List<TabSoin> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabSoin>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	@Override
	public List<TabSoin> findSoinNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabSoin o where o.booPaie='0' AND o.tabPat.codPat='"
					+ codPat + "' ORDER BY o.codSoin ";

			logger.debug("Requete <" + query + ">");

			List<TabSoin> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabSoin>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	public List<TabSoin> findByDate(String dateDeb, String dateFin)
			throws SysGehoPersistenceException {
		try {
			String query = "";
			if (dateDeb != null || dateFin != null) {
				query = "SELECT o FROM  TabSoin o "
						+ " WHERE o.datSoin >= " + "'" + dateDeb + "'"
						+ " AND o.datSoin <= " + "'" + dateFin + "'"
						+ " ORDER BY o.datSoin ";
			} else {
				query = "SELECT o FROM  o TabSoin ORDER BY o.datSoin ";
			}

			logger.debug("Requete <" + query + ">");

			List<TabSoin> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'�l�ments trouv�s : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabSoin>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

}
