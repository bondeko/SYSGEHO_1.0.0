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
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.be.ref.entity.TabLit;
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
	
	@ManyToOne
	@JoinColumn(name = "NUM_CHR_HOSPI")
	private TabChrHospi tabChrHospi;
	
	@ManyToOne
	@JoinColumn(name = "COD_LIT")
	private TabLit tabLit;
	
	@Column(name = "DAT_SORTIE")
	private String datSortie;
	
	@Column(name = "BOO_SOR")
	private BigDecimal booSor;
	
	@Column(name = "LIB_PRESCRI")
	private String libPrescri;
	
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
		tabChrHospi = (tabChrHospi == null ? new TabChrHospi() : tabChrHospi);
		tabLit = (tabLit == null ? new TabLit() : tabLit);
		tabVisMedEmb = (tabVisMedEmb == null ? new TabVisMedEmb() : tabVisMedEmb);
		tabVisMedPerio = (tabVisMedPerio == null ? new TabVisMedPerio() : tabVisMedPerio);

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
		
		tabChrHospi = (tabChrHospi != null && 
				(tabChrHospi.getNumChrHospi() == null || tabChrHospi.getNumChrHospi().trim().isEmpty())
				? null : tabChrHospi);
		
		tabLit = (tabLit != null && 
				(tabLit.getCodLit() == null || tabLit.getCodLit().trim().isEmpty())
				? null : tabLit);
		
		tabVisMedEmb = (tabVisMedEmb != null && 
				(tabVisMedEmb.getCodVisMedEmb() == null || tabVisMedEmb.getCodVisMedEmb().trim().isEmpty())
				? null : tabVisMedEmb);
		
		tabVisMedPerio = (tabVisMedPerio != null && 
				(tabVisMedPerio.getCodVisMedPerio() == null || tabVisMedPerio.getCodVisMedPerio().trim().isEmpty())
				? null : tabVisMedPerio);
		
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

	public TabChrHospi getTabChrHospi() {
		return tabChrHospi;
	}

	public void setTabChrHospi(TabChrHospi tabChrHospi) {
		this.tabChrHospi = tabChrHospi;
	}

	public TabLit getTabLit() {
		return tabLit;
	}

	public void setTabLit(TabLit tabLit) {
		this.tabLit = tabLit;
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
	
	public boolean getBEstPaie() {
		return (booPaie != null && booPaie.compareTo(BigDecimal.ONE) == 0);
	}
	
	public boolean getBEstFact() {
		return (refFac != null);
	}

}
