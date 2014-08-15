package com.bondeko.sysgeho.be.ref.dao;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;

@Local
public interface IDaoSpec extends IBaseDao<TabSpec, String>{

}
