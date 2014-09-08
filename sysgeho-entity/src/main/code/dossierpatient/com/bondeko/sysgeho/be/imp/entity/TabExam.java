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
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_EXAM")
public class TabExam extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Exam";
	}
	
	public TabExam(){
		
	}
	
	public TabExam(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}

	@Id
	@Column(name = "COD_EXAM")
	private String codExam;  
	
	@ManyToOne
	@JoinColumn(name = "COD_TYP_EXAM")
	private TabTypExam tabTypExam;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@Column(name = "LIB_EXAM")
	private String libExam;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@Column(name = "VAL_MNT_TTC")
	private BigDecimal valMntTtc;
	
	@Column(name = "DAT_EXAM")
	private String datExam;
	
	@Column(name = "LIB_STATUT")
	private String libStatut;
	
	@Column(name = "LIB_PRES")
	private String libPres;
	
	@Column(name = "BOO_CPTE_RENDU")
	private BigDecimal booCpteRendu;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	public String getCodExam() {
		return codExam;
	}

	public void setCodExam(String codExam) {
		this.codExam = codExam;
	}


	public String getDatExam() {
		return datExam;
	}

	public void setDatExam(String datExam) {
		this.datExam = datExam;
	}
	
	public Date getDateExam() {
		if (this.datExam == null || this.datExam.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datExam);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateExam(Date date) {
		if (date == null)
			this.datExam = null;
		else
			this.datExam = DateTools.formatDate(date);
	}

	public String getLibStatut() {
		return libStatut;
	}

	public void setLibStatut(String libStatut) {
		this.libStatut = libStatut;
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
		return getCodExam();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodExam((String) id);
		
	}
	
	@Override
	public void initData() {
		tabPat = (tabPat == null ? new TabPat() : tabPat);
		tabTypExam = (tabTypExam == null ? new TabTypExam() : tabTypExam);

	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabTypExam = (tabTypExam != null && 
				(tabTypExam.getCodTypExam() == null || tabTypExam.getCodTypExam().trim().isEmpty())
				? null : tabTypExam);
	}

	public void setBooCpteRendu(BigDecimal booCpteRendu) {
		this.booCpteRendu = booCpteRendu;
	}

	public BigDecimal getBooCpteRendu() {
		return booCpteRendu;
	}

	public TabTypExam getTabTypExam() {
		return tabTypExam;
	}

	public void setTabTypExam(TabTypExam tabTypExam) {
		this.tabTypExam = tabTypExam;
	}

	public String getLibExam() {
		return libExam;
	}

	public void setLibExam(String libExam) {
		this.libExam = libExam;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public String getLibPres() {
		return libPres;
	}

	public void setLibPres(String libPres) {
		this.libPres = libPres;
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}

}
