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
@Table(name="TAB_CPTE_RENDU_EXAM")
public class TabCpteRenduExam extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "CpteRenduExam";
	}
	
	public TabCpteRenduExam(){
		
	}
	
	public TabCpteRenduExam(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_CPTE_RENDU_EXAM")
	private String codCpteRenduExam;
	
	@ManyToOne
	@JoinColumn(name = "COD_EXAM")
	private TabExam tabExam;

	@Column(name = "LIB_RESUL")
	private String libResul;
	
	@Column(name = "DAT")
	private String dat;
	
	@Column(name = "LIB_CONCLU")
	private String libConclu;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
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

	public String getCodCpteRenduExam() {
		return codCpteRenduExam;
	}

	public void setCodCpteRenduExam(String codCpteRenduExam) {
		this.codCpteRenduExam = codCpteRenduExam;
	}

	public TabExam getTabExam() {
		return tabExam;
	}

	public void setTabExam(TabExam tabExam) {
		this.tabExam = tabExam;
	}

	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}
	
	@Override
	public Serializable getId() {
		return getCodCpteRenduExam();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodCpteRenduExam((String) id);
		
	}
	
	@Override
	public void initData() {
		tabExam = (tabExam == null ? new TabExam() : tabExam);
		tabExam.initData();
	}
	
	@Override
	public void validateData() {
		tabExam = (tabExam != null && 
				(tabExam.getCodExam() == null || tabExam.getCodExam().trim().isEmpty())
				? null : tabExam);
	}

	public void setLibResul(String libResul) {
		this.libResul = libResul;
	}

	public String getLibResul() {
		return libResul;
	}
	
	public String getLibConclu() {
		return libConclu;
	}

	public void setLibConclu(String libConclu) {
		this.libConclu = libConclu;
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}
	
}
