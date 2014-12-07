package com.bondeko.sysgeho.be.fac.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;

@Local
public interface ISisvFacVisMedEmb extends IBaseSisv<TabFacVisMedEmb, String>{
	
	TabFacVisMedEmb valider(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoSystemException; 
	
	TabFacVisMedEmb payer(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoSystemException;

	void saveLotDoc(TabFacVisMedEmb facVM);

	TabFacVisMedEmb ajouterPieceJte(TabFacVisMedEmb p$entite)
			throws BaseException;  

}
