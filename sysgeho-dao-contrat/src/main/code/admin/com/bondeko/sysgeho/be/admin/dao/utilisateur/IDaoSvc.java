package com.bondeko.sysgeho.be.admin.dao.utilisateur;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;

@Local
public interface IDaoSvc extends IBaseDao<TabSvc, String>{

}
