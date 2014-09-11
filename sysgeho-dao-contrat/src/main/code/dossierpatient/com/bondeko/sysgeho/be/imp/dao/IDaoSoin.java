package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

@Local
public interface IDaoSoin extends IBaseDao<TabSoin, String>{

	List<TabSoin> findByRefFac(String refFac)
			throws SysGehoPersistenceException;

	List<TabSoin> findSoinNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException;

}
