package com.bondeko.sysgeho.be.fac.sisv;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface ISisvFacConv extends IBaseSisv<TabFacConv, String>{
	
	TabFacConv valider(TabFacConv $pFacConv) throws SysGehoSystemException; 
	
	TabFacConv payer(TabFacConv $pFacConv) throws SysGehoSystemException;

	List<TabFacConv> rechercherFacConvParSocMoisAnnee(String codSoc,
			String mois, String annee) throws SysGehoSystemException;

	EntFichier genererFacConv(TabFacConv facConv) throws SysGehoSystemException;

	EntFichier genererListFacConv(TabFacConv facConv)
			throws SysGehoSystemException;  

}
