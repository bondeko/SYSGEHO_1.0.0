package com.bondeko.sysgeho.be.imp.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_ETA_STAT")
public class TabEtaStat extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "EtaStat";
	}
	
	public TabEtaStat(){
	}
	
	public TabEtaStat(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_ETA_STAT")
	private String codEtaStat;

	@Column(name = "LIB_ETA_STAT")
	private String libEtaStat;
	
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@Column(name = "DAT_DEB")
	private String datDebut;
	
	@Column(name = "DAT_FIN")
	private String datFin;
	
	public String getCodEtaStat() {
		return codEtaStat;
	}

	public void setCodEtaStat(String codEtaStat) {
		this.codEtaStat = codEtaStat;
	}

	public String getLibEtaStat() {
		return libEtaStat;
	}

	public void setLibEtaStat(String libEtaStat) {
		this.libEtaStat = libEtaStat;
	}
	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	@Override
	public Serializable getId() {
		return getCodEtaStat();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodEtaStat((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}

	/**
	 * @param datDebut the datDebut to set
	 */
	public void setDatDebut(String datDebut) {
		this.datDebut = datDebut;
	}

	/**
	 * @return the datDebut
	 */
	public String getDatDebut() {
		return datDebut;
	}

	/**
	 * @param datFin the datFin to set
	 */
	public void setDatFin(String datFin) {
		this.datFin = datFin;
	}

	/**
	 * @return the datFin
	 */
	public String getDatFin() {
		return datFin;
	}

	public void setDateDebut(Date date) {
		if (date == null)
			this.datDebut = null;
		else
			this.datDebut = DateTools.formatDate(date);
	}
	
	public Date getDateDebut() {
		if (this.datDebut == null || this.datDebut.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datDebut);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateFin(Date date) {
		if (date == null)
			this.datFin = null;
		else
			this.datFin = DateTools.formatDate(date);
	}
	
	public Date getDateFin() {
		if (this.datFin == null || this.datFin.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
