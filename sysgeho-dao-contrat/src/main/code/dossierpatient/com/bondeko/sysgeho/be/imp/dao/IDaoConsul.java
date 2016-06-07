package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

@Local
public interface IDaoConsul extends IBaseDao<TabConsul, String>{

	List<TabConsul> findByRefFac(String refFac)
			throws SysGehoPersistenceException;

	List<TabConsul> findConsulNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException;
	
	public List<TabConsul> findByDate(String dateDeb, String dateFin)
	throws SysGehoPersistenceException;

}
