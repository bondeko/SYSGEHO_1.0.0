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

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_HOSPI")
public class TabHospi extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Hospi";
	}
	
	public TabHospi(){
		
	}
	
	public TabHospi(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_HOSPI")
	private String codHospi;  
	
	//Patient
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	//Service 
	@ManyToOne
	@JoinColumn(name = "COD_SVC")
	private TabSvc tabSvc;
	
	//médecin signataire
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
	@Column(name = "DAT_ADMI")
	private String datAdmi;
	
	@Column(name = "LIB_MOTIF")
	private String libMotif;
	
	@Column(name = "LIB_NUM_CARNET")
	private String libNumCarnet;
	
	@Column(name = "LIB_OBS")
	private String libObs;
	
	@Column(name = "VAL_MNT")
	private BigDecimal valMnt;
	
	@Column(name = "LIB_NUM_CHBRE")
	private String libNumChbre;
	
	@Column(name = "LIB_NUM_LIT")
	private String libNumLit;
	
	@Column(name = "DAT_SORTIE")
	private String datSortie;
	
	@Column(name = "BOO_SOR")
	private BigDecimal booSor;
	
	@Column(name = "LIB_PRESCRI")
	private String libPrescri;
	
	
	public Date getDateAdmi() {
		if (this.datAdmi == null || this.datAdmi.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datAdmi);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateSortie(Date date) {
		if (date == null)
			this.datSortie = null;
		else
			this.datSortie = DateTools.formatDate(date);
	}
	
	public Date getDateSortie() {
		if (this.datSortie == null || this.datSortie.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datSortie);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateAdmi(Date date) {
		if (date == null)
			this.datAdmi = null;
		else
			this.datAdmi = DateTools.formatDate(date);
	}

	
	
	@Override
	public Serializable getId() {
		return getCodHospi();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodHospi((String) id);
		
	}
	
	@Override
	public void initData() {
		tabPat = (tabPat == null ? new TabPat() : tabPat);
		tabSvc = (tabSvc == null ? new TabSvc() : tabSvc);
		tabUsr = (tabUsr == null ? new TabUsr() : tabUsr);

	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabSvc = (tabSvc != null && 
				(tabSvc.getCodSvc() == null || tabSvc.getCodSvc().trim().isEmpty())
				? null : tabSvc);
		
		tabUsr = (tabUsr != null && 
				(tabUsr.getCodUsr() == null || tabUsr.getCodUsr().trim().isEmpty())
				? null : tabUsr);
	}

	public String getCodHospi() {
		return codHospi;
	}

	public void setCodHospi(String codHospi) {
		this.codHospi = codHospi;
	}

	public TabPat getTabPat() {
		return tabPat;
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}

	public TabSvc getTabSvc() {
		return tabSvc;
	}

	public void setTabSvc(TabSvc tabSvc) {
		this.tabSvc = tabSvc;
	}

	public TabUsr getTabUsr() {
		return tabUsr;
	}

	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	public String getDatAdmi() {
		return datAdmi;
	}

	public void setDatAdmi(String datAdmi) {
		this.datAdmi = datAdmi;
	}

	public String getLibMotif() {
		return libMotif;
	}

	public void setLibMotif(String libMotif) {
		this.libMotif = libMotif;
	}

	public String getLibNumCarnet() {
		return libNumCarnet;
	}

	public void setLibNumCarnet(String libNumCarnet) {
		this.libNumCarnet = libNumCarnet;
	}

	public String getLibObs() {
		return libObs;
	}

	public void setLibObs(String libObs) {
		this.libObs = libObs;
	}

	public BigDecimal getValMnt() {
		return valMnt;
	}

	public void setValMnt(BigDecimal valMnt) {
		this.valMnt = valMnt;
	}

	public String getLibNumChbre() {
		return libNumChbre;
	}

	public void setLibNumChbre(String libNumChbre) {
		this.libNumChbre = libNumChbre;
	}

	public String getLibNumLit() {
		return libNumLit;
	}

	public void setLibNumLit(String libNumLit) {
		this.libNumLit = libNumLit;
	}
	
	public String getDatSortie() {
		return datSortie;
	}

	public void setDatSortie(String datSortie) {
		this.datSortie = datSortie;
	}

	public BigDecimal getBooSor() {
		return booSor;
	}

	public void setBooSor(BigDecimal booSor) {
		this.booSor = booSor;
	}

	public String getLibPrescri() {
		return libPrescri;
	}

	public void setLibPrescri(String libPrescri) {
		this.libPrescri = libPrescri;
	}

}
