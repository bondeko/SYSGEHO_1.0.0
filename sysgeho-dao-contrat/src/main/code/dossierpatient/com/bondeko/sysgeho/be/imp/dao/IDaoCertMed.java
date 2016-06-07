package com.bondeko.sysgeho.be.imp.dao;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;

@Local
public interface IDaoCertMed extends IBaseDao<TabCertMed, String>{

	List<TabCertMed> findByRefFac(String refFac)
			throws SysGehoPersistenceException;


}
