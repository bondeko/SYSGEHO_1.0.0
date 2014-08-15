package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;

public interface ISvcoRdv extends IBaseSvco<TabRdv>{

	TabRdv annuler(TabRdv $pRdv) throws SysGehoAppException;

	TabRdv confirmer(TabRdv $pRdv) throws SysGehoAppException;

}
