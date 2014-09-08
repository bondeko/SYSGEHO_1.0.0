package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabExam;

public interface ISvcoExam extends IBaseSvco<TabExam>{

	TabExam valider(TabExam $pExam) throws SysGehoAppException;

}
