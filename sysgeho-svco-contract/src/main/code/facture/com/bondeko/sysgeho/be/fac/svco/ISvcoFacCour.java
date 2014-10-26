package com.bondeko.sysgeho.be.fac.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoFacCour extends IBaseSvco<TabFacCour>{
	
	TabFacCour valider(TabFacCour $pFacCour) throws SysGehoAppException;
	
	TabFacCour payer(TabFacCour $pFacCour) throws SysGehoAppException;

	EntFichier genererFacCour(TabFacCour facCour) throws SysGehoAppException;

}
