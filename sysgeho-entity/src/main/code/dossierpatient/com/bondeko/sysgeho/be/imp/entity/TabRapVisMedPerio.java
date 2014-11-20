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
@Table(name="TAB_RAP_VIS_MED_PERIO")
public class TabRapVisMedPerio extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "RapVisMedPerio";
	}
	
	public TabRapVisMedPerio(){
		
	}
	
	public TabRapVisMedPerio(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_RAP_VIS_MED_PERIO")
	private String codRapVisMedPerio;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_PERIO")
	private TabVisMedPerio tabVisMedPerio;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@Column(name = "LIB_RAP_EXAM_CLI")
	private String libRapExamCli;
	
	@Column(name = "LIB_RAP_EXAM_NOR")
	private String libRapExamNor;
	
	@Column(name = "LIB_RAP_EXAM_ANOR")
	private String libRapExamAnor;
	
	@Column(name = "LIB_CONCL")
	private String libConcl;
	
	@Column(name = "LIB_RECOM_PART")
	private String libRecomPart;
	
	@Column(name = "DAT_EDI")
	private String datEdi;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	

	public String getCodRapVisMedPerio() {
		return codRapVisMedPerio;
	}

	public void setCodRapVisMedPerio(String codRapVisMedPerio) {
		this.codRapVisMedPerio = codRapVisMedPerio;
	}

	public TabVisMedPerio getTabVisMedPerio() {
		return tabVisMedPerio;
	}

	public void setTabVisMedPerio(TabVisMedPerio tabVisMedPerio) {
		this.tabVisMedPerio = tabVisMedPerio;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public String getLibRapExamCli() {
		return libRapExamCli;
	}

	public void setLibRapExamCli(String libRapExamCli) {
		this.libRapExamCli = libRapExamCli;
	}

	public String getLibRapExamNor() {
		return libRapExamNor;
	}

	public void setLibRapExamNor(String libRapExamNor) {
		this.libRapExamNor = libRapExamNor;
	}

	public String getLibRapExamAnor() {
		return libRapExamAnor;
	}

	public void setLibRapExamAnor(String libRapExamAnor) {
		this.libRapExamAnor = libRapExamAnor;
	}

	public String getLibConcl() {
		return libConcl;
	}

	public void setLibConcl(String libConcl) {
		this.libConcl = libConcl;
	}

	public String getLibRecomPart() {
		return libRecomPart;
	}

	public void setLibRecomPart(String libRecomPart) {
		this.libRecomPart = libRecomPart;
	}

	public String getDatEdi() {
		return datEdi;
	}

	public void setDatEdi(String datEdi) {
		this.datEdi = datEdi;
	}
	
	public Date getDateEdi() {
		if (this.datEdi == null || this.datEdi.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datEdi);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateEdi(Date date) {
		if (date == null)
			this.datEdi = null;
		else
			this.datEdi = DateTools.formatDate(date);
	}
	
	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}
	
	@Override
	public Serializable getId() {
		return getCodRapVisMedPerio();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodRapVisMedPerio((String) id);
		
	}
	
	@Override
	public void initData() {
		tabVisMedPerio = (tabVisMedPerio == null ? new TabVisMedPerio() : tabVisMedPerio);
		tabVisMedPerio.initData();
		
		tabPat = (tabPat == null ? new TabPat() : tabPat);
		tabPat.initData();
	}
	
	@Override
	public void validateData() {
		tabVisMedPerio = (tabVisMedPerio != null && 
				(tabVisMedPerio.getCodVisMedPerio() == null || tabVisMedPerio.getCodVisMedPerio().trim().isEmpty())
				? null : tabVisMedPerio);
		tabVisMedPerio.validateData();
		
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		tabPat.validateData();
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}

	public TabPat getTabPat() {
		return tabPat;
	}
	
}
