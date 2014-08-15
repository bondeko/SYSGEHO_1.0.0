package com.bondeko.sysgeho.be.imp.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;

@Local
public interface ISisvRdv extends IBaseSisv<TabRdv, String>{

	TabRdv annuler(TabRdv $pRdv) throws SysGehoSystemException;

	TabRdv confirmer(TabRdv $pRdv) throws SysGehoSystemException;

}
