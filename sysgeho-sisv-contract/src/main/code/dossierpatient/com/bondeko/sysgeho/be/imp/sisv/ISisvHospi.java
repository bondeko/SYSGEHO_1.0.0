package com.bondeko.sysgeho.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Local
public interface ISisvHospi extends IBaseSisv<TabHospi, String>{

	TabHospi rechercherParCodPat(String codPat) throws SysGehoSystemException;

	TabHospi sortirHospitalisation(TabHospi tabHospi)
			throws SysGehoSystemException;

	List<TabHospi> rechercherParRefFac(String refFac)
			throws SysGehoSystemException;

	List<TabHospi> rechercherHospiNonPaieParPatient(String codPat)
			throws SysGehoSystemException;


}
