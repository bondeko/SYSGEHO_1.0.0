package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvPat extends IBaseSisv<TabPat, String>{

	EntFichier genererEtatListPatient(TabPat patient)
			throws SysGehoSystemException;

	EntFichier genererEtatFichePatient(TabPat patient)
			throws SysGehoSystemException;

	EntFichier genererDossierPatient(TabPat patient)
			throws SysGehoSystemException;

}
