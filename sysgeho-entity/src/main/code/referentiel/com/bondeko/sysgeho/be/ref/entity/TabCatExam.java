package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_CAT_EXAM")
public class TabCatExam extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "CatExam";
	}
	
	public TabCatExam(){
	}
	
	public TabCatExam(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_CAT_EXAM")
	private String codCatExam;

	@Column(name = "LIB_CAT_EXAM")
	private String libCatExam;
	
	@Column(name = "COD_SPEC")
	private String codSpec;
	
	@Column(name = "LIB_SPEC")
	private String libSpec;
	
	public String getCodCatExam() {
		return codCatExam;
	}

	public void setCodCatExam(String codCatExam) {
		this.codCatExam = codCatExam;
	}

	public String getLibCatExam() {
		return libCatExam;
	}

	public void setLibCatExam(String libCatExam) {
		this.libCatExam = libCatExam;
	}

	
	
	public String getLibSpec() {
		return libSpec;
	}

	public void setLibSpec(String libSpec) {
		this.libSpec = libSpec;
	}
	
	public String getCodSpec() {
		return codSpec;
	}

	public void setCodSpec(String codSpec) {
		this.codSpec = codSpec;
	}

	@Override
	public Serializable getId() {
		return getCodCatExam();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodCatExam((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

}
