package com.bondeko.sysgeho.be.phar.entity;

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
@Table(name="TAB_PROD")
public class TabProd extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Prod";
	}
	
	public TabProd(){
		
	}
	
	public TabProd(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}

	@Id
	@Column(name = "COD_PROD")
	private String codProd;  
	
	//Sous categorie produit 
	@ManyToOne
	@JoinColumn(name = "COD_SOUS_CAT_PROD")
	private TabSousCatProd tabSousCatProd;
	
	//Fournisseur
	@ManyToOne
	@JoinColumn(name = "COD_FOUR")
	private TabFour tabFour;
	
	//departenemt sanitaire
	@ManyToOne
	@JoinColumn(name = "COD_DEPART")
	private TabDepart tabDepart;
	
	@Column(name = "LIB_PROD")
	private String libProd;
	
	//Grammage
	@Column(name = "LIB_DOSAGE")
	private String libDosage;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@Column(name = "UPC_ITEM")
	private String upcItem;
	
	//Fabricant
	@Column(name = "LIB_FAB")
	private String libFab;
	
	@Column(name = "DATE_PEREM")
	private String datePerem;
	
	//Composition
	@Column(name = "LIB_COMP")
	private String libComp;
	
	//Mode d'emploi
	@Column(name = "LIB_MOD_EMPL")
	private String libModEmpl;
	
	//Active Warning
	@Column(name = "LIB_WARNING")
	private String libWarning;	
	
	//Other Information
	@Column(name = "LIB_OTHER_INF")
	private String libOtherInf;
	
	//Mode de conservation
	@Column(name = "LIB_MODE_CONSER")
	private String libModeConser;
	
	//Forme galenique
	@Column(name = "LIB_FORM_GALE")
	private String libFormGale;
	
	@Column(name = "QTE_PROD")
	private BigDecimal qteProd;
	
	public Date getDatePerem() {
		if (this.datePerem == null || this.datePerem.trim().isEmpty())
			return null;
		try {
			return DateTools.getDateValue(this.datePerem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDatePerem(Date date) {
		if (date == null)
			this.datePerem = null;
		else
			this.datePerem = DateTools.formatDate(date);
	}

	@Override
	public Serializable getId() {
		return getCodProd();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodProd((String) id);
		
	}
	
	@Override
	public void initData() {
		tabSousCatProd = (tabSousCatProd == null ? new TabSousCatProd() : tabSousCatProd);
		tabFour = (tabFour == null ? new TabFour() : tabFour);
		tabDepart = (tabDepart == null ? new TabDepart() : tabDepart);
		tabSousCatProd.initData();
	}
	
	@Override
	public void validateData() {
		tabSousCatProd = (tabSousCatProd != null && 
			(tabSousCatProd.getCodSousCatProd() == null || tabSousCatProd.getCodSousCatProd().trim().isEmpty())
				? null : tabSousCatProd);
		
		tabFour = (tabFour != null && 
				(tabFour.getCodFour() == null || tabFour.getCodFour().trim().isEmpty())
					? null : tabFour);
		
		tabDepart = (tabDepart != null && 
				(tabDepart.getCodDepart() == null || tabDepart.getCodDepart().trim().isEmpty())
					? null : tabDepart);
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public TabSousCatProd getTabSousCatProd() {
		return tabSousCatProd;
	}

	public void setTabSousCatProd(TabSousCatProd tabSousCatProd) {
		this.tabSousCatProd = tabSousCatProd;
	}

	public String getLibProd() {
		return libProd;
	}

	public void setLibProd(String libProd) {
		this.libProd = libProd;
	}

	public String getLibDosage() {
		return libDosage;
	}

	public void setLibDosage(String libDosage) {
		this.libDosage = libDosage;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public String getUpcItem() {
		return upcItem;
	}

	public void setUpcItem(String upcItem) {
		this.upcItem = upcItem;
	}

	public String getLibComp() {
		return libComp;
	}

	public void setLibComp(String libComp) {
		this.libComp = libComp;
	}

	public String getLibModEmpl() {
		return libModEmpl;
	}

	public void setLibModEmpl(String libModEmpl) {
		this.libModEmpl = libModEmpl;
	}

	public String getLibWarning() {
		return libWarning;
	}

	public void setLibWarning(String libWarning) {
		this.libWarning = libWarning;
	}

	public String getLibOtherInf() {
		return libOtherInf;
	}

	public void setLibOtherInf(String libOtherInf) {
		this.libOtherInf = libOtherInf;
	}

	public String getLibModeConser() {
		return libModeConser;
	}

	public void setLibModeConser(String libModeConser) {
		this.libModeConser = libModeConser;
	}

	public String getLibFab() {
		return libFab;
	}

	public void setLibFab(String libFab) {
		this.libFab = libFab;
	}

	public TabFour getTabFour() {
		return tabFour;
	}

	public void setTabFour(TabFour tabFour) {
		this.tabFour = tabFour;
	}

	public String getLibFormGale() {
		return libFormGale;
	}

	public void setLibFormGale(String libFormGale) {
		this.libFormGale = libFormGale;
	}

	public TabDepart getTabDepart() {
		return tabDepart;
	}

	public void setTabDepart(TabDepart tabDepart) {
		this.tabDepart = tabDepart;
	}

	public BigDecimal getQteProd() {
		return qteProd;
	}

	public void setQteProd(BigDecimal qteProd) {
		this.qteProd = qteProd;
	}
}
