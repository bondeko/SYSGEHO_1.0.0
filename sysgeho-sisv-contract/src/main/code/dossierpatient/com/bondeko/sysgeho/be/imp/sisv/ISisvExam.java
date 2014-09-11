package com.bondeko.sysgeho.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabExam;

@Local
public interface ISisvExam extends IBaseSisv<TabExam, String>{

	TabExam valider(TabExam $pExam) throws SysGehoSystemException;

	List<TabExam> rechercherParRefFac(String refFac)
			throws SysGehoSystemException;

	List<TabExam> rechercherExamNonPaieParPatient(String codPat)
			throws SysGehoSystemException; 

}
