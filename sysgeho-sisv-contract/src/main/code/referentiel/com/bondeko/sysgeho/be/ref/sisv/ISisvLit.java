package com.bondeko.sysgeho.be.ref.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.ref.entity.TabLit;

@Local
public interface ISisvLit extends IBaseSisv<TabLit, String>{

	List<TabLit> rechercherLitByNumChr(String numChr)
			throws SysGehoSystemException;

}
