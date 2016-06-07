package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;

@Local
public interface IDaoHospi extends IBaseDao<TabHospi, String>{

	TabHospi findByPat(String codPat) throws SysGehoPersistenceException;

	List<TabHospi> findByRefFac(String refFac)
			throws SysGehoPersistenceException;

	List<TabHospi> findHospiNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException;
	
	public List<TabHospi> findByDate(String dateDeb, String dateFin)
	throws SysGehoPersistenceException;

}
