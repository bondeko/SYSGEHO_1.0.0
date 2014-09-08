package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

public interface ISvcoSoin extends IBaseSvco<TabSoin>{

	TabSoin valider(TabSoin $pSoin) throws SysGehoAppException;

}
