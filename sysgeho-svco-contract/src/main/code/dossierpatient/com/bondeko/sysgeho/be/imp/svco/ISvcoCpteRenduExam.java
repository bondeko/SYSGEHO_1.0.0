package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoCpteRenduExam extends IBaseSvco<TabCpteRenduExam>{

	TabCpteRenduExam valider(TabCpteRenduExam $pCpteRduExam)
			throws SysGehoAppException;

	EntFichier genererEtatCpteRenduExam(TabCpteRenduExam cpterendu)
			throws SysGehoAppException; 


}
