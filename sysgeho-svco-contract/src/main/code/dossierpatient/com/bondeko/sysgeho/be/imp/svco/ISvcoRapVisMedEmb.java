package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;

public interface ISvcoRapVisMedEmb extends IBaseSvco<TabRapVisMedEmb>{

	TabRapVisMedEmb valider(TabRapVisMedEmb $pRapVisMed)
			throws SysGehoAppException;

}
