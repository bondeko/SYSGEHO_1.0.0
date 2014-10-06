package com.bondeko.sysgeho.be.imp.svco;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoPat extends IBaseSvco<TabPat>{
	
	EntFichier genererEtatListPat(TabPat pat) throws SysGehoAppException;

	EntFichier genererEtatFichePatient(TabPat pat) throws SysGehoAppException; 

}
