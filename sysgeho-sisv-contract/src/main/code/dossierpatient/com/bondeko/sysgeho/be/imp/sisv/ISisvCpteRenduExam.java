package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvCpteRenduExam extends IBaseSisv<TabCpteRenduExam, String>{

	TabCpteRenduExam valider(TabCpteRenduExam $pCpteRduExam)
			throws SysGehoSystemException;

	EntFichier genererEtatCpteRenduExam(TabCpteRenduExam cpterendu)
			throws SysGehoSystemException; 

}
