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

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.ref.entity.TabTypSoin;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_SOIN")
public class TabSoin extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Soin";
	}
	
	public TabSoin(){
		
	}
	
	public TabSoin(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}

	@Id
	@Column(name = "COD_SOIN")
	private String codSoin;  
	
	@ManyToOne
	@JoinColumn(name = "COD_TYP_SOIN")
	private TabTypSoin tabTypSoin;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@Column(name = "LIB_SOIN")
	private String libSoin;
	
	@Column(name = "VAL_MNT_TTC")
	private BigDecimal valMntTtc;
	
	@Column(name = "LIB_MOTIF")
	private String libMotif;
	
	@Column(name = "DAT_SOIN")
	private String datSoin;
	
	@Column(name = "LIB_OBS")
	private String libObs;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "REF_FAC")
	private String refFac;
	
	@Column(name = "ENU_MOD_PCHG")
	private String enuModPchg;
	
	public BigDecimal getBooPaie() {
		return booPaie;
	}

	public void setBooPaie(BigDecimal booPaie) {
		this.booPaie = booPaie;
	}

	public String getRefFac() {
		return refFac;
	}

	public void setRefFac(String refFac) {
		this.refFac = refFac;
	}

	public String getCodSoin() {
		return codSoin;
	}

	public void setCodSoin(String codSoin) {
		this.codSoin = codSoin;
	}


	public String getDatSoin() {
		return datSoin;
	}

	public void setDatSoin(String datSoin) {
		this.datSoin = datSoin;
	}
	
	public Date getDateSoin() {
		if (this.datSoin == null || this.datSoin.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datSoin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateSoin(Date date) {
		if (date == null)
			this.datSoin = null;
		else
			this.datSoin = DateTools.formatDate(date);
	}

	public BigDecimal getValMntTtc() {
		return valMntTtc;
	}

	public void setValMntTtc(BigDecimal valMntTtc) {
		this.valMntTtc = valMntTtc;
	}

	public TabPat getTabPat() {
		return tabPat;
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}
	
	@Override
	public Serializable getId() {
		return getCodSoin();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodSoin((String) id);
		
	}
	
	@Override
	public void initData() {
		tabPat = (tabPat == null ? new TabPat() : tabPat);
		tabTypSoin = (tabTypSoin == null ? new TabTypSoin() : tabTypSoin);

	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabTypSoin = (tabTypSoin != null && 
				(tabTypSoin.getCodTypSoin() == null || tabTypSoin.getCodTypSoin().trim().isEmpty())
				? null : tabTypSoin);
	}

	public TabTypSoin getTabTypSoin() {
		return tabTypSoin;
	}

	public void setTabTypSoin(TabTypSoin tabTypSoin) {
		this.tabTypSoin = tabTypSoin;
	}

	public String getLibSoin() {
		return libSoin;
	}

	public void setLibSoin(String libSoin) {
		this.libSoin = libSoin;
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}

	public void setLibMotif(String libMotif) {
		this.libMotif = libMotif;
	}

	public String getLibMotif() {
		return libMotif;
	}

	public void setLibObs(String libObs) {
		this.libObs = libObs;
	}

	public String getLibObs() {
		return libObs;
	}

	public void setEnuModPchg(String enuModPchg) {
		this.enuModPchg = enuModPchg;
	}

	public String getEnuModPchg() {
		return enuModPchg;
	}
	public String getLEnuModPchg() {
		EnuModPchg v$enum = EnuModPchg.getByValue(this.enuModPchg); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}

}
