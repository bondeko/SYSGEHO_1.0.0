package com.bondeko.sysgeho.be.core.dao.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;

public abstract class BaseDao <T extends BaseEntity, ID extends Serializable>
		implements IBaseDao<T, ID>{
	
	public abstract BaseLogger getLogger();
	
	@PersistenceContext(unitName = "sysgeho-unit")
	private EntityManager manager;
	
	public EntityManager getManager() throws SysGehoPersistenceException {
		if (manager != null)
			return manager;
		else {
			SysGehoPersistenceException sdr = new SysGehoPersistenceException("Erreur de récupération de l'entity manager!");
			getLogger().error("Erreur de récupération de l'entity manager!",
					sdr);
			throw sdr;
		}
	}
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public <X extends BaseEntity> X save(X entity) throws BaseException {
		try{
			//Fixe l'état de l'entité à créer
			((SysGehoBaseEntity) entity).setEtatEnt(EnuEtat.CREE.getValue());
			//On précise que l'entité est actif
			((SysGehoBaseEntity) entity).setBooAct(BigDecimal.ONE);
			//On fixe l'année de création de l'entité
			((SysGehoBaseEntity) entity).setCodExeFis(DateTools.getYear(DateTools.formatDate(new Date())));
			//Fixe la date de création
			((SysGehoBaseEntity) entity).setDatCrt(DateTools.formatDate(new Date()));
			//Fixe l'utilisateur qui cree
			((SysGehoBaseEntity) entity).setCodUsrCrt(entity.getInfoUser().getUser().getCodUsr());
			getLogger().debug("Création de l'entité en BDD ...");
			this.getManager().persist(entity);
			final X saved = this.getManager().merge(entity);
			return saved;
		}catch (SysGehoPersistenceException e){
			throw e;
		}
	}
	
	public <X extends BaseEntity> X update(X entity) throws SysGehoPersistenceException {
		try{
			//Fixe la date de modifiction
			((SysGehoBaseEntity) entity).setDatMod(DateTools.formatDate(new Date()));
			//Fixe l'utilisateur qui modifi
			((SysGehoBaseEntity) entity).setCodUsrMod(entity.getInfoUser().getUser().getCodUsr());
			getLogger().debug("Mise à jour de l'entité en BDD ...");
			final X saved = this.getManager().merge(entity);
			return saved;
		}catch (SysGehoPersistenceException e){
			throw e;
		}
	}
	
	public <X extends BaseEntity> boolean delete(X entity) throws SysGehoPersistenceException {
		try{
			getLogger().debug("Suppression de l'entité en BDD ...");
			this.getManager().merge(entity);
			return true;
		}catch (SysGehoPersistenceException e){
			throw e;
		}
	}
	
	public <X extends BaseEntity> void remove(X entity) throws SysGehoPersistenceException {
		try{
			getLogger().debug("remove de l'entité en BDD ...");
			this.getManager().remove(this.getManager().merge(entity));
		}catch (SysGehoPersistenceException e){
			throw e;
		}
	}

}
