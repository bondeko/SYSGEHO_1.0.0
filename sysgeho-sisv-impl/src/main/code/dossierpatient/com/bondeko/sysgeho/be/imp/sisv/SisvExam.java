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
import com.bondeko.sysgeho.be.imp.dao.IDaoExam;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Stateless
public class SisvExam extends BaseSisv<TabExam, String> implements ISisvExam{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvExam.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoExam daoExam; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabExam, String> getBaseDao() {
		return daoExam;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoExam.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoExam.findAll(entity);
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
			return daoExam.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabExam conCree = (TabExam) p$entite; 
		conCree = initialiserDonnees(conCree);
		conCree.setCodExam(genererCodeExam(conCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, conCree.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		conCree.validateData();
		return (X) getBaseDao().save(conCree);
	}
	
	private String genererCodeExam(TabExam tabExam) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabExam).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabExam initialiserDonnees(TabExam exam){
		exam.setBooCpteRendu(BigDecimal.ZERO);
		exam.setBooVal(BigDecimal.ZERO);
		exam.setBooPaie(BigDecimal.ZERO);
		return exam;
	}
	
	@Override
	public TabExam valider(TabExam $pExam) throws SysGehoSystemException  {
		try {
			$pExam.setBooVal(BigDecimal.ONE);
			$pExam.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pExam);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de l'examen");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabExam> rechercherParRefFac(String refFac) throws SysGehoSystemException  {
		try {
			return daoExam.findByRefFac(refFac);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherParRefFac");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public List<TabExam> rechercherExamNonPaieParPatient(String codPat) throws SysGehoSystemException  {
		try {
			return daoExam.findExamNonPaieByPatient(codPat);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur rechercherExamNonPaieParPatient");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
}
