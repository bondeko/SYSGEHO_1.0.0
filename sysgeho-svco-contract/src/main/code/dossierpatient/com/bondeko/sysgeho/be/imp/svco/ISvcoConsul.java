package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

public interface ISvcoConsul extends IBaseSvco<TabConsul>{

	TabConsul valider(TabConsul $pConsul) throws SysGehoAppException;


}
