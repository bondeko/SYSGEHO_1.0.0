package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;

@Local
public interface IDaoCpteRenduExam extends IBaseDao<TabCpteRenduExam, String>{
	public List<TabCpteRenduExam> findByDate(String dateDeb, String dateFin)
	throws SysGehoPersistenceException;

	List<TabCpteRenduExam> findByExampleAndDate(TabCpteRenduExam currentCpteRenduExam, String dateDeb, String dateFin)
			throws SysGehoPersistenceException;

}
