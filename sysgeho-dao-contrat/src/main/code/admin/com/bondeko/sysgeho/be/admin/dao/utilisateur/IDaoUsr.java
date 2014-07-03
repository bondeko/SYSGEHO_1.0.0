package com.bondeko.sysgeho.be.admin.dao.utilisateur;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;

@Local
public interface IDaoUsr extends IBaseDao<TabUsr, String>{
	
	TabUsr authenticate(String p$login, String p$pwd) throws SysGehoPersistenceException;
	
}
