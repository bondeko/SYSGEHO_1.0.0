package com.bondeko.sysgeho.be.fac.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvFacCour extends IBaseSisv<TabFacCour, String>{
	
	TabFacCour valider(TabFacCour $pFacCour) throws SysGehoSystemException; 
	
	TabFacCour payer(TabFacCour $pFacCour) throws SysGehoSystemException;

	EntFichier genererFacCour(TabFacCour facCour) throws SysGehoSystemException; 

}
