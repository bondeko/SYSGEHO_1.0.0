package com.bondeko.sysgeho.be.ref.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvSoc extends IBaseSisv<TabSoc, String>{

	EntFichier genererListSoc(TabSoc soc) throws SysGehoSystemException;

}
