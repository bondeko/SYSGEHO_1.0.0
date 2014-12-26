package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoRapVisMedEmb extends IBaseSvco<TabRapVisMedEmb>{

	TabRapVisMedEmb valider(TabRapVisMedEmb $pRapVisMed)
			throws SysGehoAppException;

	EntFichier genererRapportVM(TabRapVisMedEmb rapport)
			throws SysGehoAppException;

}
