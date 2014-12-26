package com.bondeko.sysgeho.be.ref.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoTypExam extends IBaseSvco<TabTypExam>{

	EntFichier genererFichierExamen(TabTypExam typeexam)
			throws SysGehoAppException;

}
