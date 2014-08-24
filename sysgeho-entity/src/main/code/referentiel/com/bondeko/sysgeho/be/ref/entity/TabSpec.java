package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_SPEC")
public class TabSpec extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Spec";
	}
	
	public TabSpec(){
	}
	
	public TabSpec(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_SPEC")
	private String codSpec;

	@Column(name = "LIB_SPEC")
	private String libSpec;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	


	public String getCodSpec() {
		return codSpec;
	}

	public void setCodSpec(String codSpec) {
		this.codSpec = codSpec;
	}

	public String getLibSpec() {
		return libSpec;
	}

	public void setLibSpec(String libSpec) {
		this.libSpec = libSpec;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	@Override
	public Serializable getId() {
		return getCodSpec();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodSpec((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

}
