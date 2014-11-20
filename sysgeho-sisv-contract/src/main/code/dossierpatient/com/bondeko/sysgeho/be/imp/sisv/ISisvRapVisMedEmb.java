package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;

@Local
public interface ISisvRapVisMedEmb extends IBaseSisv<TabRapVisMedEmb, String>{

	TabRapVisMedEmb valider(TabRapVisMedEmb $pRapVisMed)
			throws SysGehoSystemException;

}
