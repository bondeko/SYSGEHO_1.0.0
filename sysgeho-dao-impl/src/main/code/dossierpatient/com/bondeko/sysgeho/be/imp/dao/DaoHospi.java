package com.bondeko.sysgeho.be.imp.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.dao.base.BaseDao;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Stateless
public class DaoHospi extends BaseDao<TabHospi, String> implements IDaoHospi {

	private static BaseLogger logger = BaseLogger.getLogger(DaoHospi.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o " + " WHERE o.codHospi='" + id + "' ";

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
					+ " o " + " ORDER BY o.codHospi ";

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
		TabHospi currentHospi = (TabHospi) entity;
		if (currentHospi != null && currentHospi.getCodHospi() != null
				&& !currentHospi.getCodHospi().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.codHospi) like '%"
					+ currentHospi.getCodHospi() + "%'";
		}
		if (currentHospi != null && currentHospi.getTabChrHospi() != null
				&& currentHospi.getTabChrHospi().getNumChrHospi() != null
				&& !currentHospi.getTabChrHospi().getNumChrHospi().equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabChrHospi.numChrHospi) like '%"
					+ currentHospi.getTabChrHospi().getNumChrHospi() + "%'";
		}
		if (currentHospi != null && currentHospi.getTabPat() != null
				&& currentHospi.getTabPat().getLibNom() != null
				&& !currentHospi.getTabPat().getLibNom().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.tabPat.libNom) like '%"
					+ currentHospi.getTabPat().getLibNom() + "%'";
		}
		if (currentHospi != null && currentHospi.getTabSvc() != null
				&& currentHospi.getTabSvc().getLibSvc() != null
				&& !currentHospi.getTabSvc().getLibSvc().equals("")) {
			clauseWhere = clauseWhere + "AND upper(o.tabSvc.libSvc) like '%"
					+ currentHospi.getTabSvc().getLibSvc() + "%'";
		}
		if (currentHospi != null && currentHospi.getTabVisMedEmb() != null
				&& currentHospi.getTabVisMedEmb().getCodVisMedEmb() != null
				&& !currentHospi.getTabVisMedEmb().getCodVisMedEmb().equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabVisMedEmb.codVisMedEmb) like '%"
					+ currentHospi.getTabVisMedEmb().getCodVisMedEmb() + "%'";
		}
		if (currentHospi != null
				&& currentHospi.getTabVisMedPerio() != null
				&& currentHospi.getTabVisMedPerio().getCodVisMedPerio() != null
				&& !currentHospi.getTabVisMedPerio().getCodVisMedPerio()
						.equals("")) {
			clauseWhere = clauseWhere
					+ "AND upper(o.tabVisMedPerio.codVisMedPerio) like '%"
					+ currentHospi.getTabVisMedPerio().getCodVisMedPerio()
					+ "%'";
		}
		try {
			String query = "SELECT o FROM " + entity.getClass().getSimpleName()
					+ " o where " + clauseWhere + " ORDER BY o.codHospi ";

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

	public <X extends BaseEntity> X save(X entity) throws BaseException {
		try {
			// Fixe l'état de l'entité à créer
			((SysGehoBaseEntity) entity)
					.setEtatEnt(EnuEtat.EN_COURS.getValue());
			// On précise que l'entité est actif
			((SysGehoBaseEntity) entity).setBooAct(BigDecimal.ONE);
			// On fixe l'année de création de l'entité
			((SysGehoBaseEntity) entity).setCodExeFis(DateTools
					.getYear(DateTools.formatDate(new Date())));
			// Fixe la date de création
			((SysGehoBaseEntity) entity).setDatCrt(DateTools
					.formatDate(new Date()));
			// Fixe l'utilisateur qui cree
			((SysGehoBaseEntity) entity).setCodUsrCrt(entity.getInfoUser()
					.getUser().getCodUsr());
			getLogger().debug("Création de l'entité en BDD ...");
			this.getManager().persist(entity);
			final X saved = this.getManager().merge(entity);
			return saved;
		} catch (SysGehoPersistenceException e) {
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public TabHospi findByPat(String codPat) throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabHospi o  WHERE o.tabPat.codPat='"
					+ codPat + "' AND o.etatEnt='2009'";

			logger.debug("Requete <" + query + ">");

			List<TabHospi> v$list = getManager().createQuery(query)
					.getResultList();

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

	@Override
	public List<TabHospi> findByRefFac(String refFac)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabHospi o where o.refFac='" + refFac
					+ "' ORDER BY o.codHospi ";

			logger.debug("Requete <" + query + ">");

			List<TabHospi> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabHospi>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	@Override
	public List<TabHospi> findHospiNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException {
		try {
			String query = "SELECT o FROM TabHospi o where o.booPaie='0' AND o.tabPat.codPat='"
					+ codPat + "' ORDER BY o.codHospi ";

			logger.debug("Requete <" + query + ">");

			List<TabHospi> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabHospi>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

	public List<TabHospi> findByDate(String dateDeb, String dateFin)
			throws SysGehoPersistenceException {
		try {
			String query = "";
			if (dateDeb != null || dateFin != null) {
				query = "SELECT o FROM  TabHospi o "
						+ " WHERE o.datAdmi >= " + "'" + dateDeb + "'"
						+ " AND o.datAdmi <= " + "'" + dateFin + "'"
						+ " ORDER BY o.datAdmi ";
			} else {
				query = "SELECT o FROM  o TabHospi ORDER BY o.datAdmi ";
			}

			logger.debug("Requete <" + query + ">");

			List<TabHospi> v$list = getManager().createQuery(query)
					.getResultList();

			getLogger().debug(
					"Nombre d'éléments trouvés : "
							+ (v$list == null ? "0" : v$list.size()));
			if ((v$list == null) || (v$list.size() <= 0)) {
				return new ArrayList<TabHospi>();
			}
			return v$list;
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		}
	}

}
