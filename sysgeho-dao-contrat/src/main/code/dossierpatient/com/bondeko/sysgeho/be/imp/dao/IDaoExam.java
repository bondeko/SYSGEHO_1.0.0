package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabExam;

@Local
public interface IDaoExam extends IBaseDao<TabExam, String>{

	List<TabExam> findByRefFac(String refFac)
			throws SysGehoPersistenceException;

	List<TabExam> findExamNonPaieByPatient(String codPat)
			throws SysGehoPersistenceException;
	
	public List<TabExam> findByDate(String dateDeb, String dateFin)
	throws SysGehoPersistenceException;

}
