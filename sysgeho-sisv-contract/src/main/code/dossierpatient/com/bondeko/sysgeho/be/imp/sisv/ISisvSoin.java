package com.bondeko.sysgeho.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

@Local
public interface ISisvSoin extends IBaseSisv<TabSoin, String>{

	TabSoin valider(TabSoin $pSoin) throws SysGehoSystemException;

	List<TabSoin> rechercherParRefFac(String refFac)
			throws SysGehoSystemException;

	List<TabSoin> rechercherSoinNonPaieParPatient(String codPat)
			throws SysGehoSystemException; 

}
