package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;

public interface ISvcoVisMedPerio extends IBaseSvco<TabVisMedPerio>{

	TabVisMedPerio valider(TabVisMedPerio $pVisMedPerio) throws SysGehoAppException;
	
}
