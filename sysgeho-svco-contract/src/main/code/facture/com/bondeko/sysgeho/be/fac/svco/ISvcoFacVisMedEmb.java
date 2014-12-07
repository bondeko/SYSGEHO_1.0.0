package com.bondeko.sysgeho.be.fac.svco;

import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;

public interface ISvcoFacVisMedEmb extends IBaseSvco<TabFacVisMedEmb>{
	
	TabFacVisMedEmb valider(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoAppException;
	
	TabFacVisMedEmb payer(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoAppException;

	TabFacVisMedEmb ajouterPieceJte(TabFacVisMedEmb p$entite)
			throws BaseException; 

}
