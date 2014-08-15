package com.bondeko.sysgeho.be.ref.sisv;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.sisv.base.IBaseSisv;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;

@Local
public interface ISisvSpec extends IBaseSisv<TabSpec, String>{

}
