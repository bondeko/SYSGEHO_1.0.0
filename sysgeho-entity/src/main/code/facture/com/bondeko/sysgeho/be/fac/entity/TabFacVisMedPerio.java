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
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.util.InfoUser;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;

@Entity
@Table(name="TAB_FAC_VIS_MED_PERIO")
public class TabFacVisMedPerio extends SysGehoBaseEntity implements Serializable, IEntityPceJte{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "FacVisMedPerio";
	}
	
	public TabFacVisMedPerio(){
	}
	
	public TabFacVisMedPerio(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "REF_FAC_VIS_MED_PERIO")
	private String refFacVisMedPerio;
	
	@Column(name = "LIB_OBJ")
	private String libObj;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_PERIO")
	private TabVisMedPerio tabVisMedPerio;
	
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

	public String getRefFacVisMedPerio() {
		return refFacVisMedPerio;
	}

	public void setRefFacVisMedPerio(String refFacVisMedPerio) {
		this.refFacVisMedPerio = refFacVisMedPerio;
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public TabVisMedPerio getTabVisMedPerio() {
		return tabVisMedPerio;
	}

	public void setTabVisMedPerio(TabVisMedPerio tabVisMedPerio) {
		this.tabVisMedPerio = tabVisMedPerio;
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
		return getRefFacVisMedPerio();
	}
	
	@Override
	public void setId(Serializable id) {
		setRefFacVisMedPerio((String) id);
		
	}
	
	@Override
	public void initData() {
		tabLotDoc = (tabLotDoc == null ? new TabLotDoc() : tabLotDoc);
		
		tabVisMedPerio = (tabVisMedPerio == null ? new TabVisMedPerio() : tabVisMedPerio);
	}
	
	@Override
	public void validateData() {
		tabLotDoc = (tabLotDoc != null && 
				(tabLotDoc.getCLotDoc() == null || tabLotDoc.getCLotDoc().trim().isEmpty())
				? null : tabLotDoc);
		
		tabVisMedPerio = (tabVisMedPerio != null && 
				(tabVisMedPerio.getCodVisMedPerio() == null || tabVisMedPerio.getCodVisMedPerio().trim().isEmpty())
				? null : tabVisMedPerio);
		
	}

}
