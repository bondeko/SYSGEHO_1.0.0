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
import com.bondeko.sysgeho.be.core.enums.EnuTypMouv;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_MOUV_STOCK")
public class TabMouvStock extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "mouvStock";
	}
	
	public TabMouvStock(){
	}
	
	public TabMouvStock(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_MOUV_STOCK")
	private String codMouvStock;
	
	@Column(name = "LIB_MOUV")
	private String libMouv;
	
	@Column(name = "ENU_TYP_MOUV")
	private String enuTypMouv;
	
	@Column(name = "DAT_MOUV")
	private String datMouv;
	
	@Column(name = "QTE_MOUV")
	private BigDecimal qteMouv;
	
	@ManyToOne
	@JoinColumn(name = "COD_PROD")
	private TabProd tabProd;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "LIB_LIV")
	private String libLiv;
	
	@Override
	public Serializable getId() {
		return getCodMouvStock();
	}

	@Override
	public void setId(Serializable id) {
		setCodMouvStock((String)id);
	}
	
	@Override
	public void initData() {
		tabProd = (tabProd == null ? new TabProd() : tabProd);
	}
	
	@Override
	public void validateData() {
		tabProd = (tabProd != null && 
			(tabProd.getCodProd() == null || tabProd.getCodProd().trim().isEmpty())
				? null : tabProd);
	}


	public String getCodMouvStock() {
		return codMouvStock;
	}

	public void setCodMouvStock(String codMouvStock) {
		this.codMouvStock = codMouvStock;
	}

	public String getEnuTypMouv() {
		return enuTypMouv;
	}

	public void setEnuTypMouv(String enuTypMouv) {
		this.enuTypMouv = enuTypMouv;
	}
	
	public String getLEnuTypMouv() {
		EnuTypMouv v$enum = EnuTypMouv.getByValue(this.enuTypMouv); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}

	public String getDatMouv() {
		return datMouv;
	}

	public void setDatMouv(String datMouv) {
		this.datMouv = datMouv;
	}

	public BigDecimal getQteMouv() {
		return qteMouv;
	}

	public void setQteMouv(BigDecimal qteMouv) {
		this.qteMouv = qteMouv;
	}

	public TabProd getTabProd() {
		return tabProd;
	}

	public void setTabProd(TabProd tabProd) {
		this.tabProd = tabProd;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}
	
	public Date getDateMouv() {
		if (this.datMouv == null || this.datMouv.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datMouv);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateMouv(Date date) {
		if (date == null)
			this.datMouv = null;
		else
			this.datMouv = DateTools.formatDate(date);
	}

	public String getLibMouv() {
		return libMouv;
	}

	public void setLibMouv(String libMouv) {
		this.libMouv = libMouv;
	}

	public BigDecimal getBooVal() {
		return booVal;
	}

	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	public String getLibLiv() {
		return libLiv;
	}

	public void setLibLiv(String libLiv) {
		this.libLiv = libLiv;
	}
	
}
