package com.bondeko.sysgeho.be.core.dao.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.base.TabIncCod;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.util.InfoUser;

@Stateless
public class DaoIncCod extends BaseDao<TabIncCod, String> implements IDaoIncCod{

	private static BaseLogger logger = BaseLogger.getLogger(DaoIncCod.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@Override
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		return null;
	}

	@Override
	public <X extends BaseEntity> List<X> findAll(X entity)
			throws SysGehoPersistenceException {
		return null;
	}

	@Override
	public <X extends BaseEntity> List<X> findByExample(X entity)
			throws SysGehoPersistenceException {
		return null;
	}
	
	@Override
	public TabIncCod findNextIncCod(SysGehoBaseEntity object) throws SysGehoPersistenceException {
		try {
			InfoUser infoUsr = object.getInfoUser();
			TabIncCod cmp = this.findInc(new TabIncCod(object));
			cmp.setValIncCod(cmp.getValIncCod() == null ? new BigDecimal(1)
					 : cmp.getValIncCod().add(new BigDecimal(1)));
			cmp.setInfoUser(infoUsr);
			return this.update(cmp);
		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		} catch (Exception e) {
			throw new SysGehoPersistenceException("", e);
		}
	}
	
	@Override
	public TabIncCod findInc(TabIncCod compteur) throws SysGehoPersistenceException {
		try {
			// Il faut mettre à null le compteur zCptChrno pour qu'il ne soit pas
			// pris en compte dans la recherche
			compteur.setValIncCod(null);
			
			logger.debug("[findCpt] Recherche du compteur de code = " + compteur.getCodIncCod());
			
			String query = "SELECT o FROM  TabIncCod o ";
			query += "WHERE (o.codIncCod = '" + compteur.getCodIncCod() + "')";
			getLogger().debug("Requete <" + query + ">");
			
			List<TabIncCod> list = this.getManager().createQuery(query).getResultList();
			
			getLogger().debug("Nombre d'éléments trouvés : " + (list == null ? "0" : list.size()));
			
			if (list != null && list.size() == 1) {
				return list.get(0);
			}

			if (list != null && list.size() > 1)
				throw new SysGehoPersistenceException("list.size() > 1");
			
			// On arrive ici que s'il n'existe pas ce compteur en base de données
			// On le créé donc en base et c'est ce dernier qui sera retourné a l'appelant
			
			logger.debug("[findInc] Aucun compteur trouvé. création d'un nouveau compteur  : ");
			logger.debug("[findInc] Initialisation du compteur avant insertion en BDD");
			compteur.setValIncCod(BigDecimal.ZERO);
			
			// On crée et retourne le compteur
			logger.debug("[findInc] Création effective du nouveau compteur " + this);
			return this.save(compteur);

		} catch (SysGehoPersistenceException sdr) {
			throw sdr;
		} catch (Exception e) {
			throw new SysGehoPersistenceException("", e);
		}
	}

}
