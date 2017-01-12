package com.bondeko.sysgeho.be.phar.sisv;

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
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.phar.dao.IDaoMouvStock;
import com.bondeko.sysgeho.be.phar.dao.IDaoProd;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;
import com.bondeko.sysgeho.be.phar.entity.TabProd;

@Stateless
public class SisvMouvStock extends BaseSisv<TabMouvStock, String> implements ISisvMouvStock{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvMouvStock.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoMouvStock daoMouvStock; 
	
	@EJB
	IDaoProd daoProd; 
	
	@EJB
	IDaoIncCod daoIncCod;



	@Override
	public IBaseDao<TabMouvStock, String> getBaseDao() {
		return daoMouvStock;
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabMouvStock mouvCree = (TabMouvStock) p$entite; 
		mouvCree.setCodMouvStock(genererCodeMouv(mouvCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, mouvCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		mouvCree.validateData();
		return (X) getBaseDao().save(mouvCree);
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoMouvStock.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoMouvStock.findAll(entity);
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
			return daoMouvStock.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private String genererCodeMouv(TabMouvStock tabMouv) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabMouv).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	@Override
	public TabMouvStock valider(TabMouvStock $pmouv) throws SysGehoSystemException  {
		try {
			//Update quantite of produit
			TabProd prod = daoProd.findById(new TabProd($pmouv.getInfoUser()), $pmouv.getTabProd().getCodProd()) ;
			prod.setInfoUser($pmouv.getInfoUser());
			if((prod.getQteProd().add($pmouv.getQteMouv())).compareTo(BigDecimal.ZERO)<0)
			{
				throw new SysGehoPersistenceException("Quantite insuffisante"); 
			}
			prod.setQteProd(prod.getQteProd().add($pmouv.getQteMouv()));
			getBaseDao().update(prod);
			
			$pmouv.setBooVal(BigDecimal.ONE);
			$pmouv.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pmouv);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de l'examen");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

}
