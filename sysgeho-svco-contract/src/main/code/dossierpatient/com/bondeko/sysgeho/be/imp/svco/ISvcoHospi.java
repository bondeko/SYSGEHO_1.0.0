package com.bondeko.sysgeho.be.imp.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

public interface ISvcoHospi extends IBaseSvco<TabHospi>{

	TabHospi rechercherParCodPat(String codPat) throws SysGehoAppException;

	TabHospi sortirHospitalisation(TabHospi tabHospi)
			throws SysGehoAppException;

	List<TabHospi> rechercherParRefFac(String refFac)
			throws SysGehoAppException;

	List<TabHospi> rechercherHospiNonPaieParPatient(String codPat)
			throws SysGehoAppException;

}
