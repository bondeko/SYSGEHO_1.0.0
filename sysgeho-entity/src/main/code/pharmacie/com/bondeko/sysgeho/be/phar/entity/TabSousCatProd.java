package com.bondeko.sysgeho.be.phar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_SOUS_CAT_PROD")
public class TabSousCatProd extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "SousCatProd";
	}
	
	public TabSousCatProd(){
	}
	
	public TabSousCatProd(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_SOUS_CAT_PROD")
	private String codSousCatProd;
	
	@Column(name = "LIB_SOUS_CAT_PROD")
	private String libSousCatProd;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@ManyToOne
	@JoinColumn(name = "COD_CAT_PROD")
	private TabCatProd tabCatProd;

	@Override
	public Serializable getId() {
		return getCodSousCatProd();
	}

	@Override
	public void setId(Serializable id) {
		setCodSousCatProd((String)id);
	}

	@Override
	public void validateData() {
		tabCatProd = (tabCatProd != null && 
		    (tabCatProd.getCodCatProd() == null || tabCatProd.getCodCatProd().trim().isEmpty())
				? null : tabCatProd);
	}

	@Override
	public void initData() {
		tabCatProd = (tabCatProd == null ? new TabCatProd() : tabCatProd);
	}

	public String getCodSousCatProd() {
		return codSousCatProd;
	}

	public void setCodSousCatProd(String codSousCatProd) {
		this.codSousCatProd = codSousCatProd;
	}

	public String getLibSousCatProd() {
		return libSousCatProd;
	}

	public void setLibSousCatProd(String libSousCatProd) {
		this.libSousCatProd = libSousCatProd;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public TabCatProd getTabCatProd() {
		return tabCatProd;
	}

	public void setTabCatProd(TabCatProd tabCatProd) {
		this.tabCatProd = tabCatProd;
	}

}
