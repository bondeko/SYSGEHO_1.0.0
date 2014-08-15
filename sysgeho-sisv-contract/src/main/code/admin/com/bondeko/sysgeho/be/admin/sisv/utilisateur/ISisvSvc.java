package com.bondeko.sysgeho.be.admin.sisv.utilisateur;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;

@Local
public interface ISisvSvc extends IBaseSisv<TabSvc, String>{

}
