package com.bondeko.sysgeho.be.admin.svco.utilisateur;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;

public interface ISvcoUsr extends IBaseSvco<TabUsr>{

	TabUsr authenticate(String p$login, String p$pwd) throws SysGehoAppException;
	
	TabUsr modifierPwd(String p$login, String p$oldPwd, String p$newPwd) throws SysGehoAppException;

}
