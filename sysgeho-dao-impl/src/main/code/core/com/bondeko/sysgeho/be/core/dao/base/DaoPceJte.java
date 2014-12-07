package com.bondeko.sysgeho.be.core.dao.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.util.TabPceJte;

/**
 * Session Bean implementation class DaoPce
 */

@SuppressWarnings("unchecked")
@Stateless
public class DaoPceJte extends BaseDao<TabPceJte, String> implements
		IDaoPceJte {

	private static BaseLogger logger = BaseLogger.getLogger(DaoPceJte.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	@Override
	public <X extends BaseEntity> X save(X entite) throws BaseException {
		try {
			TabPceJte entity = (TabPceJte) entite;
			
			entity.setCTypPce("AUTRES");
			
			logger.debug("[save] Génération effective du code la pièce jointe ...");
			entity.setGeneratedCode();
				
			logger.debug("[save] Code de la pièce jointe : <" + entity.getCPce() +">");

			if (getLogger().isDebugEnable())
				getLogger().debug("Mise à jour de l'entité en BDD ...");
			final TabPceJte saved = this.getManager().merge(entity);
			if (getLogger().isDebugEnable())
				getLogger().debug(
						"Entité mise à jour en BDD : " + saved.getCPce() + ":"
								+ saved.getLRefFch());

			return (X) saved;
		} catch (SysGehoPersistenceException e) {
			throw e;
		} catch (IllegalArgumentException ent) {
			SysGehoPersistenceException sdr = new SysGehoPersistenceException(
					"Erreur de mise à jour : entité inconnue dans ce context!",
					ent);
			getLogger().error(sdr.getMessage(), sdr);
			throw sdr;
		} catch (Exception ex) {
			SysGehoPersistenceException sdr = new SysGehoPersistenceException(
					"Erreur de sauvegarde de l'entité!", ex);
			getLogger().error(sdr.getMessage(), sdr);
			throw sdr;
		}
	}

	@SuppressWarnings("unchecked")
	public <X extends BaseEntity> X findById(X entity, Serializable id)
			throws SysGehoPersistenceException {
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o " + 
			" WHERE o.cPce='" + id + "' ";
			
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
			" ORDER BY o.cPce ";
			
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
		TabPceJte currentPceJte = (TabPceJte)entity;
		if(currentPceJte != null && currentPceJte.getCPce()!= null 
				&& !currentPceJte.getCPce().equals("")){
			clauseWhere = clauseWhere + "AND upper(o.cPce) like '%"+currentPceJte.getCPce()+"%'";
		}
		try{
			String query = "SELECT o FROM " + entity.getClass().getSimpleName() + " o where " + clauseWhere +
			" ORDER BY o.cPce ";

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
