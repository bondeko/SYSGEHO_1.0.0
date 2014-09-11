package com.bondeko.sysgeho.be.imp.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

public interface ISvcoSoin extends IBaseSvco<TabSoin>{

	TabSoin valider(TabSoin $pSoin) throws SysGehoAppException;

	List<TabSoin> rechercherParRefFac(String refFac) throws SysGehoAppException;

	List<TabSoin> rechercherSoinNonPaieParPatient(String codPat)
			throws SysGehoAppException;

}
