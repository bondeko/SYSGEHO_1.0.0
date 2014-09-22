package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_LIT")
public class TabLit extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Lit";
	}
	
	public TabLit(){
	}
	
	public TabLit(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_LIT")
	private String codLit;
	
	@Column(name = "NUM_LIT")
	private String numLit;

	@Column(name = "LIB_LIT")
	private String libLit;
	
	@ManyToOne
	@JoinColumn(name = "NUM_CHR_HOSPI")
	private TabChrHospi tabChrHospi;
	
	@Column(name = "BOO_OQP")
	private BigDecimal booOqp;
	
	@Override
	public Serializable getId() {
		return getCodLit();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodLit((String) id);
		
	}

	@Override
	public void validateData() {
		
		tabChrHospi = (tabChrHospi != null && 
				(tabChrHospi.getNumChrHospi() == null || tabChrHospi.getNumChrHospi().trim().isEmpty()) 
				? null : tabChrHospi);
	}
	
	@Override
	public void initData() {
		tabChrHospi = (tabChrHospi == null ? new TabChrHospi() : tabChrHospi);
	}

	public String getCodLit() {
		return codLit;
	}

	public void setCodLit(String codLit) {
		this.codLit = codLit;
	}

	public String getNumLit() {
		return numLit;
	}

	public void setNumLit(String numLit) {
		this.numLit = numLit;
	}

	public String getLibLit() {
		return libLit;
	}

	public void setLibLit(String libLit) {
		this.libLit = libLit;
	}

	public TabChrHospi getTabChrHospi() {
		return tabChrHospi;
	}

	public void setTabChrHospi(TabChrHospi tabChrHospi) {
		this.tabChrHospi = tabChrHospi;
	}

	public void setBooOqp(BigDecimal booOqp) {
		this.booOqp = booOqp;
	}

	public BigDecimal getBooOqp() {
		return booOqp;
	}


}
