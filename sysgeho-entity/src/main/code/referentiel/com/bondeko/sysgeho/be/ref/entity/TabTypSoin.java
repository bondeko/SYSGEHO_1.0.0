package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_TYP_SOIN")
public class TabTypSoin extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "TypSoin";
	}
	
	public TabTypSoin(){
	}
	
	public TabTypSoin(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_TYP_SOIN")
	private String codTypSoin;

	public String getCodTypSoin() {
		return codTypSoin;
	}

	public void setCodTypSoin(String codTypSoin) {
		this.codTypSoin = codTypSoin;
	}

	public String getLibTypSoin() {
		return libTypSoin;
	}

	public void setLibTypSoin(String libTypSoin) {
		this.libTypSoin = libTypSoin;
	}

	@Column(name = "LIB_TYP_SOIN")
	private String libTypSoin;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	@Override
	public Serializable getId() {
		return getCodTypSoin();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodTypSoin((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

}
