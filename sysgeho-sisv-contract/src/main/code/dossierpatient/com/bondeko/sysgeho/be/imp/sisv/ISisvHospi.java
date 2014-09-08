package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Local
public interface ISisvHospi extends IBaseSisv<TabHospi, String>{

	TabHospi rechercherParCodPat(String codPat) throws SysGehoSystemException;

	TabHospi sortirHospitalisation(TabHospi tabHospi)
			throws SysGehoSystemException;



}
