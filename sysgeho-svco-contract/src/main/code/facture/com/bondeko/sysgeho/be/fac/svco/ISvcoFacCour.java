package com.bondeko.sysgeho.be.fac.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;

public interface ISvcoFacCour extends IBaseSvco<TabFacCour>{
	
	TabFacCour valider(TabFacCour $pFacCour) throws SysGehoAppException;
	
	TabFacCour payer(TabFacCour $pFacCour) throws SysGehoAppException;

}
