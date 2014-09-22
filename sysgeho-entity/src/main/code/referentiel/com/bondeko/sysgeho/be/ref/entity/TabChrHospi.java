package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_CHR_HOSPI")
public class TabChrHospi extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "ChrHospi";
	}
	
	public TabChrHospi(){
	}
	
	public TabChrHospi(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "NUM_CHR_HOSPI")
	private String numChrHospi;

	@Column(name = "LIB_CHR_HOSPI")
	private String libChrHospi;
	
	@Column(name = "VAL_NBR_LIT")
	private String valNbrLit;
	
	@Column(name = "LIB_NOM_RESPO")
	private String libNomRespo;
	
	@Column(name = "LIB_OBS")
	private String libObs;
	

	@Override
	public Serializable getId() {
		return getNumChrHospi();
	}
	
	@Override
	public void setId(Serializable id) {
		setNumChrHospi((String) id);
		
	}

	@Override
	public void validateData() {
		
	}
	
	@Override
	public void initData() {

	}

	public String getNumChrHospi() {
		return numChrHospi;
	}

	public void setNumChrHospi(String numChrHospi) {
		this.numChrHospi = numChrHospi;
	}

	public String getLibChrHospi() {
		return libChrHospi;
	}

	public void setLibChrHospi(String libChrHospi) {
		this.libChrHospi = libChrHospi;
	}

	public String getValNbrLit() {
		return valNbrLit;
	}

	public void setValNbrLit(String valNbrLit) {
		this.valNbrLit = valNbrLit;
	}

	public String getLibNomRespo() {
		return libNomRespo;
	}

	public void setLibNomRespo(String libNomRespo) {
		this.libNomRespo = libNomRespo;
	}

	public String getLibObs() {
		return libObs;
	}

	public void setLibObs(String libObs) {
		this.libObs = libObs;
	}

}
