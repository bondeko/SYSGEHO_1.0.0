package com.bondeko.sysgeho.be.ref.entity;

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
	
	@ManyToOne
	@JoinColumn(name = "COD_CAT_EXAM")
	private TabCatExam tabCatExam;
	
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
		
		tabCatExam = (tabCatExam != null && 
				(tabCatExam.getCodCatExam() == null || tabCatExam.getCodCatExam().trim().isEmpty()) 
				? null : tabCatExam);
	}

	@Override
	public void initData() {
		tabCatExam = (tabCatExam == null ? new TabCatExam() : tabCatExam);
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setTabCatExam(TabCatExam tabCatExam) {
		this.tabCatExam = tabCatExam;
	}

	public TabCatExam getTabCatExam() {
		return tabCatExam;
	}

}
