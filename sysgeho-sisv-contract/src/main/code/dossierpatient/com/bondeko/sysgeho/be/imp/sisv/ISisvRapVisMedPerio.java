package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;

@Local
public interface ISisvRapVisMedPerio extends IBaseSisv<TabRapVisMedPerio, String>{

	TabRapVisMedPerio valider(TabRapVisMedPerio $pRapVisMed)
			throws SysGehoSystemException;

}
