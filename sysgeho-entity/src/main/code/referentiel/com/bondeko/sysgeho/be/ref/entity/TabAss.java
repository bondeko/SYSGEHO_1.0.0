package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_ASS")
public class TabAss extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Ass";
	}
	
	public TabAss(){
	}
	
	public TabAss(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_ASS")
	private String codAss;

	@Column(name = "LIB_ASS")
	private String libAss;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	
	public String getCodAss() {
		return codAss;
	}

	public void setCodAss(String codAss) {
		this.codAss = codAss;
	}

	public String getLibAss() {
		return libAss;
	}

	public void setLibAss(String libAss) {
		this.libAss = libAss;
	}

	@Override
	public Serializable getId() {
		return getCodAss();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodAss((String) id);
		
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
