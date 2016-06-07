package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;

@Stateless
public class DaoCertMed extends BaseDao<TabCertMed, String> implements IDaoCertMed {

	private static BaseLogger logger = BaseLogger.getLogger(DaoCertMed.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o " + " WHERE o.codCertMed='" + id + "' ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
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
					+ " o " + " ORDER BY o.datCert ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
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
		TabCertMed currentCert = (TabCertMed) entity;
		if (currentCert != null && currentCert.getRefCertMed() != null
				&& !currentCert.getRefCertMed().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.codCertMed) like '%"
					+ currentCert.getRefCertMed() + "%'";
		}
		if (currentCert != null && currentCert.getTabPat() != null
				&& currentCert.getTabPat().getLibNom() != null
				&& !currentCert.getTabPat().getLibNom().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"
					+ currentCert.getTabPat().getLibNom() + "%'";
		}
//		if (currentCert != null && currentCert.getTabUsr() != null
//				&& currentCert.getTabUsr().getLibNom() != null
//				&& !currentCert.getTabUsr().getLibNom().equals("")) {
//			clauseWhere = clauseWhere + "AND upper(o.tabUsr.libNom) like '%"
//					+ currentCert.getTabUsr().getLibNom() + "%'";
//		}
//		if (currentCert != null
//				&& currentCert.getTabVisMedEmb() != null
//				&& currentCert.getTabVisMedEmb().getCodVisMedEmb() != null
//				&& !currentCert.getTabVisMedEmb().getCodVisMedEmb()
//						.equals("")) {
//			clauseWhere = clauseWhere
//					+ "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"
//					+ currentCert.getTabVisMedEmb().getCodVisMedEmb() + "%'";
//		}
//		if (currentCert != null
//				&& currentCert.getTabVisMedPerio() != null
//				&& currentCert.getTabVisMedPerio().getCodVisMedPerio() != null
//				&& !currentCert.getTabVisMedPerio().getCodVisMedPerio()
//						.equals("")) {
//			clauseWhere = clauseWhere
//					+ "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"
//					+ currentCert.getTabVisMedPerio().getCodVisMedPerio()
//					+ "%'";
//		}
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o where " + clauseWhere + " ORDER BY o.datCert ";

			logger.debug("Requete <" + query + ">");

			List<X> v$list = getManager().createQuery(query).getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
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
	public List<TabCertMed> findByRefFac(String refFac)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabCertMed o where o.codCertMed='"
					+ refFac + "' ORDER BY o.datCert ";

			logger.debug("Requete <" + query + ">");

			List<TabCertMed> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabCertMed>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	
	public List<TabCertMed> findByDate(String dateDeb, String dateFin)
			throws SysGehoPersistenceException {
		try {
			String query = "";
			if (dateDeb != null || dateFin != null) {
				query = "SELECT o FROM  TabCertMed o "
						+ " WHERE o.datCert >= " + "'"+dateDeb+"'"
						+ " AND o.datCert <= " + "'"+dateFin+"'"
						+ " ORDER BY o.datCert ";
			} else {
				query = "SELECT o FROM  o TabCertMed ORDER BY o.datCert ";
			}

			logger.debug("Requete <" + query + ">");

			List<TabCertMed> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabCertMed>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

}
