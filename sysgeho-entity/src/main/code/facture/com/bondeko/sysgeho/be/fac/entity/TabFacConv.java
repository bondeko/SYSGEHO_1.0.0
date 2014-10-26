package com.bondeko.sysgeho.be.fac.entity;

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
import com.bondeko.sysgeho.be.core.enums.EnuMois;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_FAC_CONV")
public class TabFacConv extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "FacConv";
	}
	
	public TabFacConv(){
	}
	
	public TabFacConv(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "REF_FAC_CONV")
	private String refFacConv;
	
	@ManyToOne
	@JoinColumn(name = "COD_SOC")
	private TabSoc tabSoc;
	

	@Column(name = "VAL_EFF")
	private BigDecimal valEff;
	
	@Column(name = "VAL_TRF_FIX_MSUEL")
	private BigDecimal valTrfFixMsuel;
	
	@Column(name = "VAL_PRIX_UNI")
	private BigDecimal valPrixUni;
	
	@Column(name = "VAL_MNT_TOTAL")
	private BigDecimal valMntTotal;
	
	@Column(name = "DAT_FAC")
	private String datFac;
	
	@Column(name = "ENU_MOIS_FAC")
	private String enuMoisFac;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@Column(name = "LIB_INF_COMPL")
	private String libInfCompl;
	

	public String getRefFacConv() {
		return refFacConv;
	}

	public void setRefFacConv(String refFacConv) {
		this.refFacConv = refFacConv;
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

	
	@Override
	public Serializable getId() {
		return getRefFacConv();
	}
	
	@Override
	public void setId(Serializable id) {
		setRefFacConv((String) id);
		
	}
	
	@Override
	public void initData() {
		tabSoc = (tabSoc == null ? new TabSoc() : tabSoc);
	}
	
	@Override
	public void validateData() {
		tabSoc = (tabSoc != null && 
				(tabSoc.getCodSoc() == null || tabSoc.getCodSoc().trim().isEmpty())
				? null : tabSoc);
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
	
	public TabSoc getTabSoc() {
		return tabSoc;
	}

	public void setTabSoc(TabSoc tabSoc) {
		this.tabSoc = tabSoc;
	}

	public BigDecimal getValEff() {
		return valEff;
	}

	public void setValEff(BigDecimal valEff) {
		this.valEff = valEff;
	}

	public BigDecimal getValTrfFixMsuel() {
		return valTrfFixMsuel;
	}

	public void setValTrfFixMsuel(BigDecimal valTrfFixMsuel) {
		this.valTrfFixMsuel = valTrfFixMsuel;
	}

	public BigDecimal getValPrixUni() {
		return valPrixUni;
	}

	public void setValPrixUni(BigDecimal valPrixUni) {
		this.valPrixUni = valPrixUni;
	}

	public String getEnuMoisFac() {
		return enuMoisFac;
	}

	public void setEnuMoisFac(String enuMoisFac) {
		this.enuMoisFac = enuMoisFac;
	}
	
	public String getLEnuMoisFac() {
		EnuMois v$enum = EnuMois.getByValue(this.enuMoisFac); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}

}
