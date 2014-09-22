package com.bondeko.sysgeho.be.ref.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabLit;

public interface ISvcoLit extends IBaseSvco<TabLit>{

	List<TabLit> rechercherLitByNumChr(String numChr)
			throws SysGehoAppException;

}
