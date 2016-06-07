package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabEtaStat;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvEtaStat extends IBaseSisv<TabEtaStat, String>{

	EntFichier genererCmptPres(TabEtaStat etatstat)
			throws SysGehoSystemException;

	EntFichier genererCmptConsul(TabEtaStat etatstat)
			throws SysGehoSystemException;

	EntFichier genererCmptExam(TabEtaStat etatstat)
			throws SysGehoSystemException;

	EntFichier genererCmptSoin(TabEtaStat etatstat)
			throws SysGehoSystemException;

	EntFichier genererCmptHospi(TabEtaStat etatstat)
			throws SysGehoSystemException;

}
