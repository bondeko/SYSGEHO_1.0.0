package com.bondeko.sysgeho.be.fac.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_FAC_COUR")
public class TabFacCour extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "FacCour";
	}
	
	public TabFacCour(){
	}
	
	public TabFacCour(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "REF_FAC_COUR")
	private String refFacCour;
	
	//Patient
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@Column(name = "VAL_MNT_TOTAL")
	private BigDecimal valMntTotal;
	
	@Column(name = "DAT_FAC")
	private String datFac;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@Column(name = "LIB_INF_COMPL")
	private String libInfCompl;
	
	@Transient
	private List<TabConsul> listConsulFac;
	
	@Transient
	private List<TabHospi> listHospiFac;
	
	@Transient
	private List<TabExam> listExamFac;
	
	@Transient
	private List<TabSoin> listSoinFac;
	
	

	public String getRefFacCour() {
		return refFacCour;
	}

	public void setRefFacCour(String refFacCour) {
		this.refFacCour = refFacCour;
	}

	public TabPat getTabPat() {
		return tabPat;
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}

	public BigDecimal getValMntTotal() {
		return valMntTotal;
	}

	public void setValMntTotal(BigDecimal valMntTotal) {
		this.valMntTotal = valMntTotal;
	}

	public String getDatFac() {
		return datFac;
	}

	public void setDatFac(String datFac) {
		this.datFac = datFac;
	}
	
	public void setDateFac(Date date) {
		if (date == null)
			this.datFac = null;
		else
			this.datFac = DateTools.formatDate(date);
	}
	
	public Date getDateFac() {
		if (this.datFac == null || this.datFac.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datFac);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TabConsul> getListConsulFac() {
		return listConsulFac;
	}

	public void setListConsulFac(List<TabConsul> listConsulFac) {
		this.listConsulFac = listConsulFac;
	}

	public List<TabHospi> getListHospiFac() {
		return listHospiFac;
	}

	public void setListHospiFac(List<TabHospi> listHospiFac) {
		this.listHospiFac = listHospiFac;
	}

	public List<TabExam> getListExamFac() {
		return listExamFac;
	}

	public void setListExamFac(List<TabExam> listExamFac) {
		this.listExamFac = listExamFac;
	}

	public List<TabSoin> getListSoinFac() {
		return listSoinFac;
	}

	public void setListSoinFac(List<TabSoin> listSoinFac) {
		this.listSoinFac = listSoinFac;
	}
	
	@Override
	public Serializable getId() {
		return getRefFacCour();
	}
	
	@Override
	public void setId(Serializable id) {
		setRefFacCour((String) id);
		
	}
	
	@Override
	public void initData() {
		tabPat = (tabPat == null ? new TabPat() : tabPat);
	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
	}

	public BigDecimal getBooVal() {
		return booVal;
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooPaie() {
		return booPaie;
	}

	public void setBooPaie(BigDecimal booPaie) {
		this.booPaie = booPaie;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibInfCompl(String libInfCompl) {
		this.libInfCompl = libInfCompl;
	}

	public String getLibInfCompl() {
		return libInfCompl;
	}

}
