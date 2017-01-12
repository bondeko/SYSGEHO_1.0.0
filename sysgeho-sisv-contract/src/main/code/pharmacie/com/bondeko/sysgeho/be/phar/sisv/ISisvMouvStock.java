package com.bondeko.sysgeho.be.phar.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;

@Local
public interface ISisvMouvStock extends IBaseSisv<TabMouvStock, String>{

	TabMouvStock valider(TabMouvStock $pmouv) throws SysGehoSystemException;
	
}
