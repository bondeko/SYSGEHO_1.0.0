package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvCpteRenduConsul extends IBaseSisv<TabCpteRenduConsul, String>{

	TabCpteRenduConsul valider(TabCpteRenduConsul $pCpteRduConsul)
			throws SysGehoSystemException;

	EntFichier genererEtatCpteRenduCon(TabCpteRenduConsul cpterendu)
			throws SysGehoSystemException; 

}
