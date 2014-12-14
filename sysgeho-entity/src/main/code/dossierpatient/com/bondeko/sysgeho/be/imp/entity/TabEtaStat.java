package com.bondeko.sysgeho.be.imp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_ETA_STAT")
public class TabEtaStat extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "EtaStat";
	}
	
	public TabEtaStat(){
	}
	
	public TabEtaStat(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_ETA_STAT")
	private String codEtaStat;

	@Column(name = "LIB_ETA_STAT")
	private String libEtaStat;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	public String getCodEtaStat() {
		return codEtaStat;
	}

	public void setCodEtaStat(String codEtaStat) {
		this.codEtaStat = codEtaStat;
	}

	public String getLibEtaStat() {
		return libEtaStat;
	}

	public void setLibEtaStat(String libEtaStat) {
		this.libEtaStat = libEtaStat;
	}
	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	@Override
	public Serializable getId() {
		return getCodEtaStat();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodEtaStat((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

}
