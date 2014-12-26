package com.bondeko.sysgeho.be.ref.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvTypExam extends IBaseSisv<TabTypExam, String>{

	EntFichier genererFichierExamen(TabTypExam typeexam)
			throws SysGehoSystemException;

}
