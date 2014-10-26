package com.bondeko.sysgeho.be.fac.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;

@Local
public interface IDaoFacConv extends IBaseDao<TabFacConv, String>{

	List<TabFacConv> findBySocMonthYear(String codSoc, String month, String year)
			throws SysGehoPersistenceException;
}
