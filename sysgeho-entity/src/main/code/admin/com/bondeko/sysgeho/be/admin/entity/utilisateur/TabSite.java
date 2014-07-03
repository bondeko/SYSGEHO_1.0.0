package com.bondeko.sysgeho.be.admin.entity.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;


@Entity
@Table(name="TAB_SITE")
public class TabSite extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	public TabSite(){
		
	}
	
	public TabSite(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_SITE")
	private String codSite;

	@Column(name = "LIB_SITE")
	private String libSite;
	
	//Description
	@Column(name = "LIB_DESC")
	private String libDesc;	

	@Override
	public String getEntityCode() {
		return "Site";
	}

	@Override
	public Serializable getId() {
		return getCodSite();
	}

	@Override
	public void setId(Serializable id) {
		setCodSite((String) id);
	}

	public String getCodSite() {
		return codSite;
	}

	public void setCodSite(String codSite) {
		this.codSite = codSite;
	}
	
	public void setLibSite(String libSIte) {
		this.libSite = libSIte;
	}

	public String getLibSite() {
		return libSite;
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public String getLibDesc() {
		return libDesc;
	}


}
