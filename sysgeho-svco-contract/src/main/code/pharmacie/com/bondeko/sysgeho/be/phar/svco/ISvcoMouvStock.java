package com.bondeko.sysgeho.be.phar.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;

public interface ISvcoMouvStock extends IBaseSvco<TabMouvStock>{

	TabMouvStock valider(TabMouvStock $pmouv) throws SysGehoAppException;

}
