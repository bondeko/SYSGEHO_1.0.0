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
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_CPTE_RENDU_CONSUL")
public class TabCpteRenduConsul extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "CpteRenduConsul";
	}
	
	public TabCpteRenduConsul(){
		
	}
	
	public TabCpteRenduConsul(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_CPTE_RENDU_CONSUL")
	private String codCpteRenduConsul;
	
	@ManyToOne
	@JoinColumn(name = "COD_CONSUL")
	private TabConsul tabConsul;

	@Column(name = "LIB_MOTIF_CONSUL")
	private String libMotifConsul;
	
	@Column(name = "LIB_HIS_MAL")
	private String libHisMal;
	
	@Column(name = "LIB_DIAG_PRIN")
	private String libDiagPrin;
	
	@Column(name = "LIB_DIAG_SENC")
	private String libDiagSenc;
	
	@Column(name = "LIB_EXAM_BIO")
	private String libExamBio;
	
	@Column(name = "LIB_EXPLO_FONC")
	private String libExploFonc;
	
	@Column(name = "LIB_EXAM_IMAG")
	private String libExamImag;
	
	@Column(name = "LIB_TRAIT_PRES")
	private String libTraitPres;
	
	@Column(name = "LIB_CONCL")
	private String libConcl;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "DAT")
	private String dat;
	
	public Date getDate() {
		if (this.dat == null || this.dat.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.dat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDate(Date date) {
		if (date == null)
			this.dat = null;
		else
			this.dat = DateTools.formatDate(date);
	}

	public String getCodCpteRenduConsul() {
		return codCpteRenduConsul;
	}

	public void setCodCpteRenduConsul(String codCpteRenduConsul) {
		this.codCpteRenduConsul = codCpteRenduConsul;
	}

	public TabConsul getTabConsul() {
		return tabConsul;
	}

	public void setTabConsul(TabConsul tabConsul) {
		this.tabConsul = tabConsul;
	}

	public String getLibMotifConsul() {
		return libMotifConsul;
	}

	public void setLibMotifConsul(String libMotifConsul) {
		this.libMotifConsul = libMotifConsul;
	}

	public String getLibHisMal() {
		return libHisMal;
	}

	public void setLibHisMal(String libHisMal) {
		this.libHisMal = libHisMal;
	}

	public String getLibDiagPrin() {
		return libDiagPrin;
	}

	public void setLibDiagPrin(String libDiagPrin) {
		this.libDiagPrin = libDiagPrin;
	}

	public String getLibDiagSenc() {
		return libDiagSenc;
	}

	public void setLibDiagSenc(String libDiagSenc) {
		this.libDiagSenc = libDiagSenc;
	}

	public String getLibExamBio() {
		return libExamBio;
	}

	public void setLibExamBio(String libExamBio) {
		this.libExamBio = libExamBio;
	}

	public String getLibExploFonc() {
		return libExploFonc;
	}

	public void setLibExploFonc(String libExploFonc) {
		this.libExploFonc = libExploFonc;
	}

	public String getLibExamImag() {
		return libExamImag;
	}

	public void setLibExamImag(String libExamImag) {
		this.libExamImag = libExamImag;
	}

	public String getLibTraitPres() {
		return libTraitPres;
	}

	public void setLibTraitPres(String libTraitPres) {
		this.libTraitPres = libTraitPres;
	}

	public String getLibConcl() {
		return libConcl;
	}

	public void setLibConcl(String libConcl) {
		this.libConcl = libConcl;
	}

	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}
	
	@Override
	public Serializable getId() {
		return getCodCpteRenduConsul();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodCpteRenduConsul((String) id);
		
	}
	
	@Override
	public void initData() {
		tabConsul = (tabConsul == null ? new TabConsul() : tabConsul);
		tabConsul.initData();
	}
	
	@Override
	public void validateData() {
		tabConsul = (tabConsul != null && 
				(tabConsul.getCodConsul() == null || tabConsul.getCodConsul().trim().isEmpty())
				? null : tabConsul);
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}
	
}
