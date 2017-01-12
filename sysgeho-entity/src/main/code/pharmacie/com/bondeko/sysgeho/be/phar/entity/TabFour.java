package com.bondeko.sysgeho.be.phar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_FOUR")
public class TabFour extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "Four";
	}
	
	public TabFour(){
	}
	
	public TabFour(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_FOUR")
	private String codFour;
	
	@Column(name = "LIB_FOUR")
	private String libFour;
	
	@Column(name = "LIB_ADDR")
	private String libAddr;
	
	@Column(name = "LIB_CONT")
	private String libCont;
	
	@Column(name = "LIB_DESC")
	private String libDesc;

	@Override
	public Serializable getId() {
		return getCodFour();
	}

	@Override
	public void setId(Serializable id) {
		setCodFour((String)id);
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

	public String getCodFour() {
		return codFour;
	}

	public void setCodFour(String codFour) {
		this.codFour = codFour;
	}

	public String getLibFour() {
		return libFour;
	}

	public void setLibFour(String libFour) {
		this.libFour = libFour;
	}

	public String getLibAddr() {
		return libAddr;
	}

	public void setLibAddr(String libAddr) {
		this.libAddr = libAddr;
	}

	public String getLibCont() {
		return libCont;
	}

	public void setLibCont(String libCont) {
		this.libCont = libCont;
	}

}
