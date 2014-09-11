package com.bondeko.sysgeho.be.imp.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

@Local
public interface ISisvConsul extends IBaseSisv<TabConsul, String>{

	TabConsul valider(TabConsul $pConsul) throws SysGehoSystemException;

	List<TabConsul> rechercherParRefFac(String refFac)
			throws SysGehoSystemException;

	List<TabConsul> rechercherConsulNonPaieParPatient(String codPat)
			throws SysGehoSystemException; 


}
