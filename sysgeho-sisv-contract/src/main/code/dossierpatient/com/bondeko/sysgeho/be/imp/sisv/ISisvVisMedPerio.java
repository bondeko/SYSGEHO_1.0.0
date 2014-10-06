package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;

@Local
public interface ISisvVisMedPerio extends IBaseSisv<TabVisMedPerio, String>{

	TabVisMedPerio valider(TabVisMedPerio $pVisMedPerio) throws SysGehoSystemException;

}
