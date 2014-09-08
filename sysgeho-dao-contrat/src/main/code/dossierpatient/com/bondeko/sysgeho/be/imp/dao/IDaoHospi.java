package com.bondeko.sysgeho.be.imp.dao;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Local
public interface IDaoHospi extends IBaseDao<TabHospi, String>{

	TabHospi findByPat(String codPat) throws SysGehoPersistenceException;

}
