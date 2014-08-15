package com.bondeko.sysgeho.be.admin.sisv.utilisateur;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabRol;
import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;

@Local
public interface ISisvRol extends IBaseSisv<TabRol, String>{

}
