package com.bondeko.sysgeho.be.core.base;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAB_INC_COD")
public class TabIncCod  extends SysGehoBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "COD_INC_COD")
	private String codIncCod;

	@Column(name = "LIB_DESC")
	private String libDesc;

	@Column(name = "VAL_INC_COD")
	private BigDecimal valIncCod;
	
	public TabIncCod(){
		super();
	}
	
	public TabIncCod(SysGehoBaseEntity object) {	
		this.codIncCod = DateTools.getYear(DateTools.formatDate(new Date())) + object.getClass().getSimpleName();
		this.setValIncCod(null);
		this.setInfoUser(object.getInfoUser());
	}

	public String getCodIncCod() {
		return codIncCod;
	}

	public void setCodIncCod(String codIncCod) {
		this.codIncCod = codIncCod;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public BigDecimal getValIncCod() {
		return valIncCod;
	}

	public void setValIncCod(BigDecimal valIncCod) {
		this.valIncCod = valIncCod;
	}

	@Override
	public String getEntityCode() {
		return "IncCod";
	}

	@Override
	public Serializable getId() {
		return getCodIncCod();
	}

	@Override
	public void setId(Serializable id) {
		if(id == null){
			this.setCodIncCod(null);
		}
		else{
			this.setCodIncCod((String)id);
		}
	}

	@Override
	public void validateData() {
		
	}

	@Override
	public void initData() {
		
	}

}
