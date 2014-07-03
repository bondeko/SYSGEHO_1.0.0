package com.bondeko.sysgeho.be.admin.sisv.utilisateur;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;

@Local
public interface ISisvUsr extends IBaseSisv<TabUsr, String>{
	
	TabUsr authenticate(String p$login, String p$pwd) throws SysGehoSystemException;
	
	TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws SysGehoSystemException;

}
