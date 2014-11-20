package com.bondeko.sysgeho.be.imp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_VIS_MED_EMB")
public class TabVisMedEmb extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "VisMedEmb";
	}
	
	public TabVisMedEmb(){
		
	}
	
	public TabVisMedEmb(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_VIS_MED_EMB")
	private String codVisMedEmb;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
	@Column(name = "DAT_VIS_MED")
	private String datVisMed;
	
	@Column(name = "LIB_MOTIF")
	private String libMotif;
	
	@Column(name = "LIB_OBS")
	private String libObs;
	
	@Column(name = "BOO_EST_VAL")
	private BigDecimal booEstVal;
	
	@Column(name = "BOO_RAP_VIS_MED")
	private BigDecimal booRapVisMed;
	
	@Column(name = "VAL_MNT_TTC")
	private BigDecimal valMntTtc;
	

	public TabPat getTabPat() {
		return tabPat;
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}

	public TabUsr getTabUsr() {
		return tabUsr;
	}

	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	
	public Date getDateVisMed() {
		if (this.datVisMed == null || this.datVisMed.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datVisMed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateVisMed(Date date) {
		if (date == null)
			this.datVisMed = null;
		else
			this.datVisMed = DateTools.formatDate(date);
	}


	public String getLibObs() {
		return libObs;
	}

	public void setLibObs(String libObs) {
		this.libObs = libObs;
	}
	
	@Override
	public Serializable getId() {
		return getCodVisMedEmb();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodVisMedEmb((String) id);
		
	}
	
	@Override
	public void initData() {
		tabPat = (tabPat == null ? new TabPat() : tabPat);
		tabUsr = (tabUsr == null ? new TabUsr() : tabUsr);
	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabUsr = (tabUsr != null && 
				(tabUsr.getCodUsr() == null || tabUsr.getCodUsr().trim().isEmpty())
				? null : tabUsr);
		
	}

	public void setCodVisMedEmb(String codVisMedEmb) {
		this.codVisMedEmb = codVisMedEmb;
	}

	public String getCodVisMedEmb() {
		return codVisMedEmb;
	}

	public void setDatVisMed(String datVisMed) {
		this.datVisMed = datVisMed;
	}

	public String getDatVisMed() {
		return datVisMed;
	}

	public void setLibMotif(String libMotif) {
		this.libMotif = libMotif;
	}

	public String getLibMotif() {
		return libMotif;
	}

	public void setBooEstVal(BigDecimal booEstVal) {
		this.booEstVal = booEstVal;
	}

	public BigDecimal getBooEstVal() {
		return booEstVal;
	}

	public void setValMntTtc(BigDecimal valMntTtc) {
		this.valMntTtc = valMntTtc;
	}

	public BigDecimal getValMntTtc() {
		return valMntTtc;
	}

	public void setBooRapVisMed(BigDecimal booRapVisMed) {
		this.booRapVisMed = booRapVisMed;
	}

	public BigDecimal getBooRapVisMed() {
		return booRapVisMed;
	}
	
}
