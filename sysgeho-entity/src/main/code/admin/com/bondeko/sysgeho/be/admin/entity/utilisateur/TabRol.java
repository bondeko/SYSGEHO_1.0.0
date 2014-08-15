package com.bondeko.sysgeho.be.admin.entity.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_ROL")
public class TabRol extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public TabRol(){
		
	}
	
	public TabRol(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_ROL")
	private String codRol;

	@Column(name = "LIB_ROL")
	private String libRol;

	//Description
	@Column(name = "LIB_DESC")
	private String libDesc;	

	@Override
	public String getEntityCode() {
		return "Rol";
	}

	@Override
	public Serializable getId() {
		return getCodRol();
	}

	@Override
	public void setId(Serializable id) {
		setCodRol((String)id);
	}

	@Override
	public void validateData() {
		
	}

	@Override
	public void initData() {
		
	}
	
	public String getCodRol() {
		return codRol;
	}

	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public String getLibRol() {
		return libRol;
	}

	public void setLibRol(String libRol) {
		this.libRol = libRol;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

}
