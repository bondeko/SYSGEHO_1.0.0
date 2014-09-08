package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;

@Local
public interface ISisvCpteRenduConsul extends IBaseSisv<TabCpteRenduConsul, String>{

	TabCpteRenduConsul valider(TabCpteRenduConsul $pCpteRduConsul)
			throws SysGehoSystemException; 

}
