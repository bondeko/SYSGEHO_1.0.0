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
@Table(name="TAB_RDV")
public class TabRdv extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Rdv";
	}
	
	public TabRdv(){
		
	}
	
	public TabRdv(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_RDV")
	private String codRdv;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	//Médecin
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
	@Column(name = "COD_TYP_RDV")
	private String codTypRdv;
	
	@Column(name = "LIB_TYP_RDV")
	private String libTypRdv;
	
	//Service d'admission
	@Column(name = "COD_SVC")
	private String codSvc;
	
	@Column(name = "LIB_SVC")
	private String libSvc;
	
	//Date de demande
	@Column(name = "DAT_DEM")
	private String datDem;
	
	//Date RDV
	@Column(name = "DAT_RDV")
	private String datRdv;
	
	//Num d'ordre
	@Column(name = "VAL_NUM_ORDRE")
	private String valNumOrdre;
	
	//Observation
	@Column(name = "LIB_OBS")
	private String libObs;
	
	@Column(name = "BOO_EST_ANN")
	private BigDecimal booEstAnn;
	
	@Column(name = "BOO_EST_CONF")
	private BigDecimal booEstConf;
	
	public BigDecimal getBooEstAnn() {
		return booEstAnn;
	}

	public void setBooEstAnn(BigDecimal booEstAnn) {
		this.booEstAnn = booEstAnn;
	}

	public BigDecimal getBooEstConf() {
		return booEstConf;
	}

	public void setBooEstConf(BigDecimal booEstConf) {
		this.booEstConf = booEstConf;
	}

	public String getCodRdv() {
		return codRdv;
	}

	public void setCodRdv(String codRdv) {
		this.codRdv = codRdv;
	}

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


	public String getCodSvc() {
		return codSvc;
	}

	public void setCodSvc(String codSvc) {
		this.codSvc = codSvc;
	}

	public String getLibSvc() {
		return libSvc;
	}

	public void setLibSvc(String libSvc) {
		this.libSvc = libSvc;
	}

	public String getDatDem() {
		return datDem;
	}

	public void setDatDem(String datDem) {
		this.datDem = datDem;
	}
	
	public Date getDateDem() {
		if (this.datDem == null || this.datDem.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datDem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateDem(Date date) {
		if (date == null)
			this.datDem = null;
		else
			this.datDem = DateTools.formatDate(date);
	}

	public String getDatRdv() {
		return datRdv;
	}

	public void setDatRdv(String datRdv) {
		this.datRdv = datRdv;
	}
	
	public Date getDateRdv() {
		if (this.datRdv == null || this.datRdv.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datRdv);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateRdv(Date date) {
		if (date == null)
			this.datRdv = null;
		else
			this.datRdv = DateTools.formatDate(date);
	}

	public String getValNumOrdre() {
		return valNumOrdre;
	}

	public void setValNumOrdre(String valNumOrdre) {
		this.valNumOrdre = valNumOrdre;
	}

	public String getLibObs() {
		return libObs;
	}

	public void setLibObs(String libObs) {
		this.libObs = libObs;
	}
	
	@Override
	public Serializable getId() {
		return getCodRdv();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodRdv((String) id);
		
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

	public String getCodTypRdv() {
		return codTypRdv;
	}

	public void setCodTypRdv(String codTypRdv) {
		this.codTypRdv = codTypRdv;
	}

	public String getLibTypRdv() {
		return libTypRdv;
	}

	public void setLibTypRdv(String libTypRdv) {
		this.libTypRdv = libTypRdv;
	}
	
	public boolean getBEstAnn() {
		return (booEstAnn != null && booEstAnn.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstAnn(boolean bEstAnn) {
		this.booEstAnn = (bEstAnn ? BigDecimal.ONE : BigDecimal.ZERO);
	}
	
	public boolean getBEstConf() {
		return (booEstConf != null && booEstConf.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstConf(boolean bEstConf) {
		this.booEstConf = (bEstConf ? BigDecimal.ONE : BigDecimal.ZERO);
	}

	

}
