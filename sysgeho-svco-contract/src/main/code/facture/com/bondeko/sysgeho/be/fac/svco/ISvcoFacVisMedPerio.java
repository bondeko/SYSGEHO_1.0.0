package com.bondeko.sysgeho.be.fac.svco;

import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;

public interface ISvcoFacVisMedPerio extends IBaseSvco<TabFacVisMedPerio>{
	
	TabFacVisMedPerio valider(TabFacVisMedPerio $pFacVisMedPerio) throws SysGehoAppException;
	
	TabFacVisMedPerio payer(TabFacVisMedPerio $pFacVisMedPerio) throws SysGehoAppException;

	TabFacVisMedPerio ajouterPieceJte(TabFacVisMedPerio p$entite)
			throws BaseException; 

}
