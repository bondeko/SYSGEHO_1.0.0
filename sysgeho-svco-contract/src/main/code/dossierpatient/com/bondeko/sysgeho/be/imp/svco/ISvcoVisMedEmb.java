package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;

public interface ISvcoVisMedEmb extends IBaseSvco<TabVisMedEmb>{

	TabVisMedEmb valider(TabVisMedEmb $pVisMedEmb) throws SysGehoAppException;
	
}
