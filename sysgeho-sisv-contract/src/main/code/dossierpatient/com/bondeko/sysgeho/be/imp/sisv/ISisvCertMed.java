package com.bondeko.sysgeho.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvCertMed extends IBaseSisv<TabCertMed, String>{

	TabCertMed valider(TabCertMed $pConsul) throws SysGehoSystemException;

	List<TabCertMed> rechercherParRefFac(String refFac)
			throws SysGehoSystemException;

	EntFichier genererEtatCertMed(TabCertMed certMed)
			throws SysGehoSystemException; 


}
