package com.bondeko.sysgeho.be.ref.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoSoc extends IBaseSvco<TabSoc>{

	TabSoc genererFacConv(TabSoc tabSoc) throws SysGehoAppException;

	EntFichier genererListSoc(TabSoc soc) throws SysGehoAppException; 

}
