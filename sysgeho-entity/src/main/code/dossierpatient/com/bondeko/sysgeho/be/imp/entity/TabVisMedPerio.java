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
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_VIS_MED_PERIO") 
public class TabVisMedPerio extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "VisMedPerio";
	}
	
	public TabVisMedPerio(){
		
	}
	
	public TabVisMedPerio(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_VIS_MED_PERIO")
	private String codVisMedPerio;
	
	@Column(name = "LIB_VIS_MED_PERIO")
	private String libVisMedPerio;
	
	@ManyToOne
	@JoinColumn(name = "COD_SOC")
	private TabSoc tabSoc;
	
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
	@Column(name = "DAT_VIS_MED")
	private String datVisMed;
	
	@Column(name = "DAT_DER_VIS_MED")
	private String datDerVisMed;
	
	@Column(name = "LIB_MOTIF")
	private String libMotif;
	
	@Column(name = "LIB_OBS")
	private String libObs;
	
	@Column(name = "BOO_EST_VAL")
	private BigDecimal booEstVal;
	
	@Column(name = "VAL_MNT_TTC")
	private BigDecimal valMntTtc;
	
	@Column(name = "VAL_NBR")
	private BigDecimal valNbr;
	
	public TabUsr getTabUsr() {
		return tabUsr;
	}

	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	
	public Date getDateDerVisMed() {
		if (this.datDerVisMed == null || this.datDerVisMed.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datDerVisMed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateDerVisMed(Date date) {
		if (date == null)
			this.datDerVisMed = null;
		else
			this.datDerVisMed = DateTools.formatDate(date);
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
		return getCodVisMedPerio();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodVisMedPerio((String) id);
		
	}
	
	@Override
	public void initData() {
		tabSoc = (tabSoc == null ? new TabSoc() : tabSoc);
		tabUsr = (tabUsr == null ? new TabUsr() : tabUsr);
	}
	
	@Override
	public void validateData() {
		tabSoc = (tabSoc != null && 
				(tabSoc.getCodSoc() == null || tabSoc.getCodSoc().trim().isEmpty())
				? null : tabSoc);
		
		tabUsr = (tabUsr != null && 
				(tabUsr.getCodUsr() == null || tabUsr.getCodUsr().trim().isEmpty())
				? null : tabUsr);
		
	}

	public void setCodVisMedPerio(String codVisMedPerio) {
		this.codVisMedPerio = codVisMedPerio;
	}

	public String getCodVisMedPerio() {
		return codVisMedPerio;
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

	public void setLibVisMedPerio(String libVisMedPerio) {
		this.libVisMedPerio = libVisMedPerio;
	}

	public String getLibVisMedPerio() {
		return libVisMedPerio;
	}

	public void setTabSoc(TabSoc tabSoc) {
		this.tabSoc = tabSoc;
	}

	public TabSoc getTabSoc() {
		return tabSoc;
	}

	public void setDatDerVisMed(String datDerVisMed) {
		this.datDerVisMed = datDerVisMed;
	}

	public String getDatDerVisMed() {
		return datDerVisMed;
	}

	public void setValMntTtc(BigDecimal valMntTtc) {
		this.valMntTtc = valMntTtc;
	}

	public BigDecimal getValMntTtc() {
		return valMntTtc;
	}

	public void setValNbr(BigDecimal valNbr) {
		this.valNbr = valNbr;
	}

	public BigDecimal getValNbr() {
		return valNbr;
	}
	
}
