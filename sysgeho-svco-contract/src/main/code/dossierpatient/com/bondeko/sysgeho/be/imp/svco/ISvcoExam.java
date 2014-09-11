package com.bondeko.sysgeho.be.imp.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabExam;

public interface ISvcoExam extends IBaseSvco<TabExam>{

	TabExam valider(TabExam $pExam) throws SysGehoAppException;

	List<TabExam> rechercherParRefFac(String refFac) throws SysGehoAppException;

	List<TabExam> rechercherExamNonPaieParPatient(String codPat)
			throws SysGehoAppException;

}
