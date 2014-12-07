package com.bondeko.sysgeho.be.core.base;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.bondeko.sysgeho.be.core.enums.EnuEtat;


@MappedSuperclass
public abstract class SysGehoBaseEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ETAT_ENT")
	private String etatEnt;
	
	@Column(name = "COD_EXE_FIS")
	private String codExeFis;
	
	@Column(name = "BOO_ACT")
	private BigDecimal booAct;
	
	@Column(name = "COD_USR_CRT")
	private String codUsrCrt;

	@Column(name = "COD_USR_MOD")
	private String codUsrMod;

	@Column(name = "DAT_CRT")
	private String datCrt;

	@Column(name = "DAT_MOD")
	private String datMod;
	
	/**
	 * Constructeur par d�faut
	 */
	public SysGehoBaseEntity(){
		
	}
	public void setCodExeFis(String codExeFis) {
		this.codExeFis = codExeFis;
	}

	public String getCodExeFis() {
		return codExeFis;
	}
	
	public void setBooAct(BigDecimal booAct) {
		this.booAct = booAct;
	}

	public BigDecimal getBooAct() {
		return booAct;
	}
	
	public String getSpecialId(){
		return (this.getId()==null ? "null" : this.getId().toString()) + "-null-null";
	}

	public void setEtatEnt(String etatEnt) {
		this.etatEnt = etatEnt;
	}

	public String getEtatEnt() {
		return etatEnt;
	}
	
	public String getLEtatEnt() {
		EnuEtat v$enum = EnuEtat.getByValue(this.etatEnt); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}
	public void setCodUsrCrt(String codUsrCrt) {
		this.codUsrCrt = codUsrCrt;
	}
	public String getCodUsrCrt() {
		return codUsrCrt;
	}
	public void setCodUsrMod(String codUsrMod) {
		this.codUsrMod = codUsrMod;
	}
	public String getCodUsrMod() {
		return codUsrMod;
	}
	public void setDatCrt(String datCrt) {
		this.datCrt = datCrt;
	}
	public String getDatCrt() {
		return datCrt;
	}
	public void setDatMod(String datMod) {
		this.datMod = datMod;
	}
	public String getDatMod() {
		return datMod;
	}
	
	protected String formatString(String strToFormat){
		return (strToFormat==null || strToFormat.trim().isEmpty()) ? null : strToFormat;
	}
}
