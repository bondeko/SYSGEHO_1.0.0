package com.bondeko.sysgeho.be.ref.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.core.enums.EnuMois;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_SOC")
public class TabSoc extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Soc";
	}

	
	public TabSoc(){
		
	}
	
	public TabSoc(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_SOC")
	private String codSoc;

	@Column(name = "LIB_SOC")
	private String libSoc;
	
	@Column(name = "LIB_RESP")
	private String libResp;
	
	@Column(name = "LIB_BP")
	private String libBP;
	
	@Column(name = "LIB_VIL")
	private String libVil;
	
	@Column(name = "LIB_TEL")
	private String libTel;
	
	@Column(name = "LIB_NUM_CONTRIB")
	private String libNumContrib;
	
	@Column(name = "LIB_SIEGE")
	private String libSiege;
	
	@Column(name = "LIB_ADR_COM")
	private String libAdrCom;
	
	@Column(name = "BOO_EST_AFF")
	private BigDecimal booEstAff;
	
	@Column(name = "DAT_AFF")
	private String datAff;
	
	@Column(name = "VAL_EFF")
	private BigDecimal valEff;
	
	@Column(name = "VAL_PRI_UNI")
	private BigDecimal valPriUni;
	
	@Column(name = "VAL_TARIF_FIX_MEN")
	private BigDecimal valTarifFixMen;
	
	@Column(name = "DAT_CRE")
	private String datCre;
	
	//Adresse
	@Column(name = "LIB_MAIL")
	private String libMail;
	
	//Fax
	@Column(name = "LIB_FAX")
	private String libFax;
	
	@Transient
	String enuMoisFac;
	@Transient
	String refFacConv;
	@Transient
	String libObj;
	@Transient
	String libInfCompl;

	public String getCodSoc() {
		return codSoc;
	}

	public void setCodSoc(String codSoc) {
		this.codSoc = codSoc;
	}

	public String getLibSoc() {
		return libSoc;
	}

	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}

	public String getLibResp() {
		return libResp;
	}

	public void setLibResp(String libResp) {
		this.libResp = libResp;
	}

	public String getLibBP() {
		return libBP;
	}

	public void setLibBP(String libBP) {
		this.libBP = libBP;
	}

	public String getLibVil() {
		return libVil;
	}

	public void setLibVil(String libVil) {
		this.libVil = libVil;
	}

	public String getLibTel() {
		return libTel;
	}

	public void setLibTel(String libTel) {
		this.libTel = libTel;
	}

	public String getLibNumContrib() {
		return libNumContrib;
	}

	public void setLibNumContrib(String libNumContrib) {
		this.libNumContrib = libNumContrib;
	}

	public String getLibSiege() {
		return libSiege;
	}

	public void setLibSiege(String libSiege) {
		this.libSiege = libSiege;
	}

	public String getLibAdrCom() {
		return libAdrCom;
	}

	public void setLibAdrCom(String libAdrCom) {
		this.libAdrCom = libAdrCom;
	}

	public BigDecimal getBooEstAff() {
		return booEstAff;
	}

	public void setBooEstAff(BigDecimal booEstAff) {
		this.booEstAff = booEstAff;
	}
	
	public boolean getBEstAff() {
		return (booEstAff != null && booEstAff.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstAff(boolean bEstAff) {
		this.booEstAff = (bEstAff ? BigDecimal.ONE : BigDecimal.ZERO);
	}

	public String getDatAff() {
		return datAff;
	}

	public void setDatAff(String datAff) {
		this.datAff = datAff;
	}

	public BigDecimal getValEff() {
		return valEff;
	}

	public void setValEff(BigDecimal valEff) {
		this.valEff = valEff;
	}

	public BigDecimal getValPriUni() {
		return valPriUni;
	}

	public void setValPriUni(BigDecimal valPriUni) {
		this.valPriUni = valPriUni;
	}

	public String getDatCre() {
		return datCre;
	}

	public void setDatCre(String datCre) {
		this.datCre = datCre;
	}

	public String getLibMail() {
		return libMail;
	}

	public void setLibMail(String libMail) {
		this.libMail = libMail;
	}

	public String getLibFax() {
		return libFax;
	}

	public void setLibFax(String libFax) {
		this.libFax = libFax;
	}
	
	@Override
	public Serializable getId() {
		return getCodSoc();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodSoc((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}
	
	public Date getDateAff() {
		try {
			if (this.datAff != null && !this.datAff.isEmpty()) {
				return DateTools.getDateValue(this.datAff);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public void setDateAff(Date date) {
		if (date == null)
			this.datAff = null;
		else
			this.datAff = DateTools.formatDate(date);
	}
	
	public Date getDateCre() {
		if (this.datCre == null || this.datCre.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datCre);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateCre(Date date) {
		if (date == null)
			this.datCre = null;
		else
			this.datCre = DateTools.formatDate(date);
	}


	public void setValTarifFixMen(BigDecimal valTarifFixMen) {
		this.valTarifFixMen = valTarifFixMen;
	}


	public BigDecimal getValTarifFixMen() {
		return valTarifFixMen;
	}
	
	public String getLEnuMoisFac() {
		EnuMois v$enum = EnuMois.getByValue(this.enuMoisFac); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}


	public String getEnuMoisFac() {
		return enuMoisFac;
	}


	public void setEnuMoisFac(String enuMoisFac) {
		this.enuMoisFac = enuMoisFac;
	}


	public String getRefFacConv() {
		return refFacConv;
	}


	public void setRefFacConv(String refFacConv) {
		this.refFacConv = refFacConv;
	}


	public String getLibObj() {
		return libObj;
	}


	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}


	public String getLibInfCompl() {
		return libInfCompl;
	}


	public void setLibInfCompl(String libInfCompl) {
		this.libInfCompl = libInfCompl;
	}
	
	
}
