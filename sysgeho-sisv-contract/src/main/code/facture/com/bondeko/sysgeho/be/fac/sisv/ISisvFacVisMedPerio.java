package com.bondeko.sysgeho.be.fac.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;

@Local
public interface ISisvFacVisMedPerio extends IBaseSisv<TabFacVisMedPerio, String>{
	
	TabFacVisMedPerio valider(TabFacVisMedPerio $pFacVisMedPerio) throws SysGehoSystemException; 
	
	TabFacVisMedPerio payer(TabFacVisMedPerio $pFacVisMedPerio) throws SysGehoSystemException;

	void saveLotDoc(TabFacVisMedPerio facVM);

	TabFacVisMedPerio ajouterPieceJte(TabFacVisMedPerio p$entite)
			throws BaseException;  

}
