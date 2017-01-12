package com.bondeko.sysgeho.be.phar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_CAT_PROD")
public class TabCatProd extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "catProd";
	}
	
	public TabCatProd(){
	}
	
	public TabCatProd(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_CAT_PROD")
	private String codCatProd;
	
	@Column(name = "LIB_CAT_PROD")
	private String libCatProd;
	
	@Column(name = "LIB_DESC")
	private String libDesc;

	@Override
	public Serializable getId() {
		return getCodCatProd();
	}

	@Override
	public void setId(Serializable id) {
		setCodCatProd((String)id);
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
		
	}

	public String getCodCatProd() {
		return codCatProd;
	}

	public void setCodCatProd(String codCatProd) {
		this.codCatProd = codCatProd;
	}

	public String getLibCatProd() {
		return libCatProd;
	}

	public void setLibCatProd(String libCatProd) {
		this.libCatProd = libCatProd;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

}
