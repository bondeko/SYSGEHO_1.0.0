package com.bondeko.sysgeho.be.phar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_DEPART")
public class TabDepart extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "Depart";
	}
	
	public TabDepart(){
	}
	
	public TabDepart(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_DEPART")
	private String codDepart;
	
	@Column(name = "LIB_DEPART")
	private String libDepart;
	
	@Column(name = "LIB_DESC")
	private String libDesc;

	@Override
	public Serializable getId() {
		return getCodDepart();
	}

	@Override
	public void setId(Serializable id) {
		setCodDepart((String)id);
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
		
	}
	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public String getCodDepart() {
		return codDepart;
	}

	public void setCodDepart(String codDepart) {
		this.codDepart = codDepart;
	}

	public String getLibDepart() {
		return libDepart;
	}

	public void setLibDepart(String libDepart) {
		this.libDepart = libDepart;
	}
}
