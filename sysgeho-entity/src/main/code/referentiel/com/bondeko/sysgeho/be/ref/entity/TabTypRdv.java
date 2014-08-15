package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_TYP_RDV")
public class TabTypRdv extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "TypRdv";
	}
	
	public TabTypRdv(){
	}
	
	public TabTypRdv(InfoUser infoUser){
	}
	
	@Id
	@Column(name = "COD_TYP_RDV")
	private String codTypRdv;

	@Column(name = "LIB_TYP_RDV")
	private String libTypRdv;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	public String getCodTypRdv() {
		return codTypRdv;
	}

	public void setCodTypRdv(String codTypRdv) {
		this.codTypRdv = codTypRdv;
	}

	public String getLibTypRdv() {
		return libTypRdv;
	}

	public void setLibTypRdv(String libTypRdv) {
		this.libTypRdv = libTypRdv;
	}
	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	@Override
	public Serializable getId() {
		return getCodTypRdv();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodTypRdv((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

}
