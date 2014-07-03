package com.bondeko.sysgeho.be.util;

import java.io.Serializable;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;

public class InfoUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private TabUsr user;

	public void setUser(TabUsr user) {
		this.user = user;
	}

	public TabUsr getUser() {
		return user;
	}

}
