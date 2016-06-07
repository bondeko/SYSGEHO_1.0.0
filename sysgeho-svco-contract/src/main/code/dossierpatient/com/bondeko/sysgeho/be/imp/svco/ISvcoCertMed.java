package com.bondeko.sysgeho.be.imp.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoCertMed extends IBaseSvco<TabCertMed>{

	TabCertMed valider(TabCertMed $pConsul) throws SysGehoAppException;

	List<TabCertMed> rechercherParRefFac(String refFac)
			throws SysGehoAppException;

	EntFichier genererEtatCertMed(TabCertMed certMed)
			throws SysGehoAppException;

}
