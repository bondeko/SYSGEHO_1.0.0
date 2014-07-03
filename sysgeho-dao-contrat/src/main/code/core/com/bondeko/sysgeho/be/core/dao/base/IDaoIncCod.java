package com.bondeko.sysgeho.be.core.dao.base;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.base.TabIncCod;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;

@Local
public interface IDaoIncCod extends IBaseDao<TabIncCod, String>{

	TabIncCod findNextIncCod(SysGehoBaseEntity object) throws SysGehoPersistenceException;

	TabIncCod findInc(TabIncCod compteur) throws SysGehoPersistenceException;

}
