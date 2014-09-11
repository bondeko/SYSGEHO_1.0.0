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
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_CONSUL")
public class TabConsul extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Consul";
	}
	
	public TabConsul(){
		
	}
	
	public TabConsul(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_CONSUL")
	private String codConsul;  
	
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@Column(name = "COD_SPEC")
	private String codSpec;
	
	@Column(name = "VAL_POIDS")
	private String valPoids;
	
	@Column(name = "VAL_TENSION")
	private String valTension;
	
	@Column(name = "VAL_POU")
	private String valPou;
	
	@Column(name = "VAL_TAILLE")
	private String valTaille;
	
	@Column(name = "DAT_CONSUL")
	private String datConsul;
	
	@Column(name = "LIB_STATUT")
	private String libStatut;
	
	@Column(name = "VAL_MNT_TTC")
	private BigDecimal valMntTtc;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "BOO_CPTE_RENDU")
	private BigDecimal booCpteRendu;
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "REF_FAC")
	private String refFac;
	
	@Transient
	private String libSpec;
	
	public String getCodConsul() {
		return codConsul;
	}

	public void setCodConsul(String codConsul) {
		this.codConsul = codConsul;
	}

	public String getValPoids() {
		return valPoids;
	}

	public void setValPoids(String valPoids) {
		this.valPoids = valPoids;
	}

	public String getValTension() {
		return valTension;
	}

	public void setValTension(String valTension) {
		this.valTension = valTension;
	}

	public String getValPou() {
		return valPou;
	}

	public void setValPou(String valPou) {
		this.valPou = valPou;
	}

	public String getValTaille() {
		return valTaille;
	}

	public void setValTaille(String valTaille) {
		this.valTaille = valTaille;
	}

	public String getCodSpec() {
		return codSpec;
	}

	public void setCodSpec(String codSpec) {
		this.codSpec = codSpec;
	}

	public String getDatConsul() {
		return datConsul;
	}

	public void setDatConsul(String datConsul) {
		this.datConsul = datConsul;
	}
	
	public Date getDateConsul() {
		if (this.datConsul == null || this.datConsul.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datConsul);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateConsul(Date date) {
		if (date == null)
			this.datConsul = null;
		else
			this.datConsul = DateTools.formatDate(date);
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

	public TabUsr getTabUsr() {
		return tabUsr;
	}

	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	public TabPat getTabPat() {
		return tabPat;
	}

	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}
	
	@Override
	public Serializable getId() {
		return getCodConsul();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodConsul((String) id);
		
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

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}

	public void setBooCpteRendu(BigDecimal booCpteRendu) {
		this.booCpteRendu = booCpteRendu;
	}

	public BigDecimal getBooCpteRendu() {
		return booCpteRendu;
	}

	public void setLibSpec(String libSpec) {
		this.libSpec = libSpec;
	}

	public String getLibSpec() {
		return libSpec;
	}

	public void setBooPaie(BigDecimal booPaie) {
		this.booPaie = booPaie;
	}

	public BigDecimal getBooPaie() {
		return booPaie;
	}

	public void setRefFac(String refFac) {
		this.refFac = refFac;
	}

	public String getRefFac() {
		return refFac;
	}

}
