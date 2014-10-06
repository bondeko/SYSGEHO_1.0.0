package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;

@Local
public interface ISisvVisMedEmb extends IBaseSisv<TabVisMedEmb, String>{

	TabVisMedEmb valider(TabVisMedEmb $pVisMedEmb) throws SysGehoSystemException;

}
