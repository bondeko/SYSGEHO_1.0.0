package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;

public interface ISvcoCpteRenduConsul extends IBaseSvco<TabCpteRenduConsul>{

	TabCpteRenduConsul valider(TabCpteRenduConsul $pCpteRduConsul)
			throws SysGehoAppException; 


}
