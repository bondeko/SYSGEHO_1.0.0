package com.bondeko.sysgeho.be.imp.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.dao.base.IDaoIncCod;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.imp.dao.IDaoHospi;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.ref.dao.IDaoLit;
import com.bondeko.sysgeho.be.ref.entity.TabLit;
import com.bondeko.sysgeho.be.util.InfoUser;

@Stateless
public class SisvHospi extends BaseSisv<TabHospi, String> implements ISisvHospi{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvHospi.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoHospi daoHospi; 
	
	@EJB
	IDaoLit daoLit; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabHospi, String> getBaseDao() {
		return daoHospi;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoHospi.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoHospi.findAll(entity);
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
			return daoHospi.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabHospi entCree = (TabHospi) p$entite; 
		InfoUser info = entCree.getInfoUser();
		if(rechercherParCodPat(entCree.getTabPat().getCodPat()) != null)
			throw new BaseException("Il existe déjà une hospitalisation en cours pour le patient "+entCree.getTabPat().getLibNom());
		entCree = initialiserDonnees(entCree);
		entCree.setCodHospi(genererCodeHospi(entCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, entCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		entCree.validateData();
		if(entCree.getTabLit() != null && entCree.getTabLit().getCodLit() != null){
			TabLit tabLit = daoLit.findById(new TabLit(), entCree.getTabLit().getCodLit());
			tabLit.setInfoUser(info);
			tabLit.setBooOqp(BigDecimal.ONE);
			tabLit.setEtatEnt(EnuEtat.OCCUPE.getValue());
			daoLit.update(tabLit);
		}
		return (X) getBaseDao().save(entCree);
	}
	
	private String genererCodeHospi(TabHospi tabHospi) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabHospi).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabHospi initialiserDonnees(TabHospi Hospi){
		Hospi.setBooSor(BigDecimal.ZERO);
		Hospi.setBooPaie(BigDecimal.ZERO);
		return Hospi;
	}
	
	@Override
	public TabHospi rechercherParCodPat(String codPat) throws SysGehoSystemException {
		try {
			return daoHospi.findByPat(codPat);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabHospi sortirHospitalisation(TabHospi tabHospi) throws SysGehoSystemException {
		try {
			TabLit tabLit = tabHospi.getTabLit();
			tabLit.setInfoUser(tabHospi.getInfoUser());
			if(tabLit != null){
				tabLit.setBooOqp(BigDecimal.ZERO);
				tabLit.setEtatEnt(EnuEtat.LIBRE.getValue());
				daoLit.update(tabLit);
			}
			tabHospi.setEtatEnt(EnuEtat.TERMINE.getValue());
			return daoHospi.update(tabHospi);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabHospi> rechercherParRefFac(String refFac) throws SysGehoSystemException  {
		try {
			return daoHospi.findByRefFac(refFac);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherParRefFac");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabHospi> rechercherHospiNonPaieParPatient(String codPat) throws SysGehoSystemException  {
		try {
			return daoHospi.findHospiNonPaieByPatient(codPat);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherHospiNonPaieParPatient");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
}
