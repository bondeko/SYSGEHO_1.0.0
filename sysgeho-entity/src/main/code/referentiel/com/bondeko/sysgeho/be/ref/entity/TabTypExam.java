package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_TYP_EXAM")
public class TabTypExam extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "TypExam";
	}
	
	public TabTypExam(){
	}
	
	public TabTypExam(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_TYP_EXAM")
	private String codTypExam;

	@Column(name = "LIB_TYP_EXAM")
	private String libTypExam;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@Column(name = "COD_CAT_EXAM")
	private String codCatExam;
	
	@Column(name = "LIB_CAT_EXAM")
	private String libCatExam;
	
	@Transient
	private String libSpec;
	
	public String getCodTypExam() {
		return codTypExam;
	}

	public void setCodTypExam(String codTypExam) {
		this.codTypExam = codTypExam;
	}

	public String getLibTypExam() {
		return libTypExam;
	}

	public void setLibTypExam(String libTypExam) {
		this.libTypExam = libTypExam;
	}


	@Override
	public Serializable getId() {
		return getCodTypExam();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodTypExam((String) id);
		
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

	public void setLibSpec(String libSpec) {
		this.libSpec = libSpec;
	}

	public String getLibSpec() {
		return libSpec;
	}

}
