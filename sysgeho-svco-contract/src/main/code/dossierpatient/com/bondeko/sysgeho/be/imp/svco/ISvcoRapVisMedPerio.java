package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;

public interface ISvcoRapVisMedPerio extends IBaseSvco<TabRapVisMedPerio>{

	TabRapVisMedPerio valider(TabRapVisMedPerio $pRapVisMed)
			throws SysGehoAppException;

}
