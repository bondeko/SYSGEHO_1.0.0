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
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
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
	
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;
	
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
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "REF_FAC")
	private String refFac;
	
	@Column(name = "ENU_MOD_PCHG")
	private String enuModPchg;
	
	@Column(name = "TYP_VIS_MED_SRC")
	private String typVisMedSrc;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_EMB")
	private TabVisMedEmb tabVisMedEmb;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_PERIO")
	private TabVisMedPerio tabVisMedPerio;
	
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
		tabVisMedEmb = (tabVisMedEmb == null ? new TabVisMedEmb() : tabVisMedEmb);
		tabVisMedPerio = (tabVisMedPerio == null ? new TabVisMedPerio() : tabVisMedPerio);
		tabUsr = (tabUsr == null ? new TabUsr() : tabUsr);

	}
	
	@Override
	public void validateData() {
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabTypExam = (tabTypExam != null && 
				(tabTypExam.getCodTypExam() == null || tabTypExam.getCodTypExam().trim().isEmpty())
				? null : tabTypExam);
		
		tabVisMedEmb = (tabVisMedEmb != null && 
				(tabVisMedEmb.getCodVisMedEmb() == null || tabVisMedEmb.getCodVisMedEmb().trim().isEmpty())
				? null : tabVisMedEmb);
		
		tabVisMedPerio = (tabVisMedPerio != null && 
				(tabVisMedPerio.getCodVisMedPerio() == null || tabVisMedPerio.getCodVisMedPerio().trim().isEmpty())
				? null : tabVisMedPerio);
		
		tabUsr = (tabUsr != null && 
				(tabUsr.getCodUsr() == null || tabUsr.getCodUsr().trim().isEmpty())
				? null : tabUsr);
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
	
	public void setTypVisMedSrc(String typVisMedSrc) {
		this.typVisMedSrc = typVisMedSrc;
	}

	public String getTypVisMedSrc() {
		return typVisMedSrc;
	}

	public void setTabVisMedEmb(TabVisMedEmb tabVisMedEmb) {
		this.tabVisMedEmb = tabVisMedEmb;
	}

	public TabVisMedEmb getTabVisMedEmb() {
		return tabVisMedEmb;
	}

	public void setTabVisMedPerio(TabVisMedPerio tabVisMedPerio) {
		this.tabVisMedPerio = tabVisMedPerio;
	}

	public TabVisMedPerio getTabVisMedPerio() {
		return tabVisMedPerio;
	}

	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	public TabUsr getTabUsr() {
		return tabUsr;
	}

}
