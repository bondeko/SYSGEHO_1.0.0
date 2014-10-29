package com.bondeko.sysgeho.be.fac.svco;

import java.util.List;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.be.util.EntFichier;

public interface ISvcoFacConv extends IBaseSvco<TabFacConv>{
	
	TabFacConv valider(TabFacConv $pFacConv) throws SysGehoAppException;
	
	TabFacConv payer(TabFacConv $pFacConv) throws SysGehoAppException;

	List<TabFacConv> rechercherConsulNonPaieParPatient(String codSoc,
			String mois, String annee) throws SysGehoAppException;

	EntFichier genererFacConv(TabFacConv facConv) throws SysGehoAppException; 

}
