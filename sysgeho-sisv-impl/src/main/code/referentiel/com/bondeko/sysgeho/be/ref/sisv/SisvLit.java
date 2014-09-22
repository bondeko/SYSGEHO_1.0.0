package com.bondeko.sysgeho.be.ref.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.ref.dao.IDaoLit;
import com.bondeko.sysgeho.be.ref.entity.TabLit;

@Stateless
public class SisvLit extends BaseSisv<TabLit, String> implements ISisvLit{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvLit.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	
	@EJB
	IDaoLit daoLit; 

	@Override
	public IBaseDao<TabLit, String> getBaseDao() {
		return daoLit;
	} 
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabLit litCree = (TabLit) p$entite; 
		litCree = this.initialiserDonnees(litCree);
		//codLit = numChr/numLit
		String codLit = litCree.getTabChrHospi().getNumChrHospi()+"/"+litCree.getNumLit();
		litCree.setCodLit(codLit);
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, litCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		litCree.validateData();
		return (X) getBaseDao().save(litCree);
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoLit.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoLit.findAll(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoSystemException {
		try {
			return daoLit.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public  List<TabLit> rechercherLitByNumChr(String numChr)
			throws SysGehoSystemException {
		try {
			return daoLit.findLitByNumChr(numChr);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private TabLit initialiserDonnees(TabLit lit){
		lit.setBooOqp(BigDecimal.ZERO);
		return lit;
	}

}
