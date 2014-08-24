package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

@Local
public interface ISisvConsul extends IBaseSisv<TabConsul, String>{

	TabConsul valider(TabConsul $pConsul) throws SysGehoSystemException; 


}
