package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoRapVisMedPerio extends IBaseSvco<TabRapVisMedPerio>{

	TabRapVisMedPerio valider(TabRapVisMedPerio $pRapVisMed)
			throws SysGehoAppException;

	EntFichier genererRapportVM(TabRapVisMedPerio rapport)
			throws SysGehoAppException;

}
