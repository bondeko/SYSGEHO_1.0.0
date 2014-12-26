package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabEtaStat;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoEtaStat extends IBaseSvco<TabEtaStat>{

	EntFichier genererCmptPres(TabEtaStat etatstat) throws SysGehoAppException;

}
