package com.bondeko.sysgeho.be.fac.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
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
import com.bondeko.sysgeho.be.core.base.IEntityPceJte;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.util.InfoUser;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;

@Entity
@Table(name="TAB_FAC_VIS_MED_EMB")
public class TabFacVisMedEmb extends SysGehoBaseEntity implements Serializable, IEntityPceJte{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "FacVisMedEmb";
	}
	
	public TabFacVisMedEmb(){
	}
	
	public TabFacVisMedEmb(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "REF_FAC_VIS_MED_EMB")
	private String refFacVisMedEmb;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_EMB")
	private TabVisMedEmb tabVisMedEmb;
	
	@Column(name = "VAL_MNT_TOTAL")
	private BigDecimal valMntTotal;
	
	@Column(name = "DAT_FAC")
	private String datFac;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "BOO_PAIE")
	private BigDecimal booPaie;
	
	@Column(name = "LIB_INF_COMPL")
	private String libInfCompl;
	
	@ManyToOne
	@JoinColumn(name = "C_LOT_DOC")
	private TabLotDoc tabLotDoc;
	
	@Transient
	private List<TabPceJte> listNewPce = new ArrayList<TabPceJte>();

	public String getRefFacVisMedEmb() {
		return refFacVisMedEmb;
	}

	public void setRefFacVisMedEmb(String refFacVisMedEmb) {
		this.refFacVisMedEmb = refFacVisMedEmb;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public TabVisMedEmb getTabVisMedEmb() {
		return tabVisMedEmb;
	}

	public void setTabVisMedEmb(TabVisMedEmb tabVisMedEmb) {
		this.tabVisMedEmb = tabVisMedEmb;
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

	public String getLibInfCompl() {
		return libInfCompl;
	}

	public void setLibInfCompl(String libInfCompl) {
		this.libInfCompl = libInfCompl;
	}

	public TabLotDoc getTabLotDoc() {
		return tabLotDoc;
	}

	public void setTabLotDoc(TabLotDoc tabLotDoc) {
		this.tabLotDoc = tabLotDoc;
	}

	public void setListNewPce(List<TabPceJte> listNewPce) {
		this.listNewPce = listNewPce;
	}

	public List<TabPceJte> getListNewPce() {
		return listNewPce;
	}

	@Override
	public <X extends TabPceJte> void addNewPiece(X piece) {
		this.listNewPce.add(piece);
	}
	
	@Override
	public Serializable getId() {
		return getRefFacVisMedEmb();
	}
	
	@Override
	public void setId(Serializable id) {
		setRefFacVisMedEmb((String) id);
		
	}
	
	@Override
	public void initData() {
		tabLotDoc = (tabLotDoc == null ? new TabLotDoc() : tabLotDoc);
		
		tabVisMedEmb = (tabVisMedEmb == null ? new TabVisMedEmb() : tabVisMedEmb);
	}
	
	@Override
	public void validateData() {
		tabLotDoc = (tabLotDoc != null && 
				(tabLotDoc.getCLotDoc() == null || tabLotDoc.getCLotDoc().trim().isEmpty())
				? null : tabLotDoc);
		
		tabVisMedEmb = (tabVisMedEmb != null && 
				(tabVisMedEmb.getCodVisMedEmb() == null || tabVisMedEmb.getCodVisMedEmb().trim().isEmpty())
				? null : tabVisMedEmb);
		
	}

}
