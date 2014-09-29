package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoCpteRenduConsul extends IBaseSvco<TabCpteRenduConsul>{

	TabCpteRenduConsul valider(TabCpteRenduConsul $pCpteRduConsul)
			throws SysGehoAppException;
	
	EntFichier genererEtatCpteRenduCon(TabCpteRenduConsul cpterendu) throws SysGehoAppException;

}
