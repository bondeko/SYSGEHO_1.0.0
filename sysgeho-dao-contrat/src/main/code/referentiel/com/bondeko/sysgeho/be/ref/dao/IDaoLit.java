package com.bondeko.sysgeho.be.ref.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.ref.entity.TabLit;

@Local
public interface IDaoLit extends IBaseDao<TabLit, String>{

	List<TabLit> findLitByNumChr(String numChr)
			throws SysGehoPersistenceException; 

}
