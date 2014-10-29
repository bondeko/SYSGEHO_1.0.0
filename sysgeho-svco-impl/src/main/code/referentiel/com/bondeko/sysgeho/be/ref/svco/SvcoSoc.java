package com.bondeko.sysgeho.be.ref.svco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.core.svco.base.BaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.be.fac.sisv.ISisvFacConv;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.ref.sisv.ISisvSoc;
import com.bondeko.sysgeho.be.util.EntFichier;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SvcoSoc extends BaseSvco<TabSoc> implements IRemoteSoc, ILocalSoc{
	
	@EJB
	ISisvSoc sisvSoc;
	
	@EJB
	ISisvFacConv sisvFacConv;
	
	@Resource
	SessionContext session;

	private static BaseLogger logger = BaseLogger.getLogger(SvcoSoc.class);
	
	@Override
	protected IBaseSisv<TabSoc, String> getBaseSisv() {
		return sisvSoc;
	}

	@Override
	public BaseLogger getLogger() {
		return logger;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id)
			throws SysGehoAppException {
		try {
			return sisvSoc.rechercher(entity,id);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoAppException {
		try {
			return sisvSoc.rechercherTout(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoAppException {
		try {
			return sisvSoc.rechercherParCritere(entity);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}
	
	@Override
	public TabSoc genererFacConv(TabSoc tabSoc) throws SysGehoAppException {
		try {
			//On fabrique l'objet tabFacConv à creer
			TabFacConv facConv = new TabFacConv(tabSoc.getInfoUser());
			facConv.setRefFacConv(tabSoc.getRefFacConv());
			facConv.setTabSoc(tabSoc);
			facConv.setValEff(tabSoc.getValEff());
			facConv.setValTrfFixMsuel(tabSoc.getValTarifFixMen());
			facConv.setValPrixUni(tabSoc.getValPriUni());
			//On calcule le montant total de la facture
			BigDecimal valMntTotal = null; 
			BigDecimal valMntMulty;
			if(tabSoc.getValPriUni()!=null && tabSoc.getValEff()!= null){
				valMntMulty = tabSoc.getValPriUni().multiply(tabSoc.getValEff());
				if(tabSoc.getValTarifFixMen() != null) valMntTotal = valMntMulty.add(tabSoc.getValTarifFixMen());
			}else{
				if(tabSoc.getValTarifFixMen() != null) valMntTotal = tabSoc.getValTarifFixMen();
			}
			facConv.setValMntTotal(valMntTotal);
			facConv.setDatFac(DateTools.formatDate(new Date()));
			facConv.setEnuMoisFac(tabSoc.getEnuMoisFac());
			facConv.setBooVal(BigDecimal.ZERO);
			facConv.setBooPaie(BigDecimal.ZERO);
			facConv.setLibObj(tabSoc.getLibObj());
			facConv.setLibInfCompl(tabSoc.getLibInfCompl());
			
			sisvFacConv.creer(facConv);
			
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sbr = new SysGehoAppException(e);
			throw sbr;
		} catch (BaseException e) { 
			e.printStackTrace();
		}
		return tabSoc;
	}
	
	@Override
	public EntFichier  genererListSoc(TabSoc soc)
	throws SysGehoAppException {
		try {
			return sisvSoc.genererListSoc(soc);
		} catch (SysGehoSystemException e) {
			e.printStackTrace();
			SysGehoAppException sdr = new SysGehoAppException(e);
			throw sdr;
		}
	}

}
