/**
 * 
 */
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

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

/**
 * @author STEPH
 *
 */
@Entity
@Table(name="TAB_CERT_MED")
public class TabCertMed extends SysGehoBaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "CertMed";
	}
	
	public TabCertMed(){
	}
	
	public TabCertMed(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}

	/**
	 * @return the tabPat
	 */
	public TabPat getTabPat() {
		return tabPat;
	}

	/**
	 * @param tabPat the tabPat to set
	 */
	public void setTabPat(TabPat tabPat) {
		this.tabPat = tabPat;
	}

	/**
	 * @return the valAge
	 */
	public BigDecimal getValAge() {
		return valAge;
	}

	/**
	 * @param valAge the valAge to set
	 */
	public void setValAge(BigDecimal valAge) {
		this.valAge = valAge;
	}

	/**
	 * @return the datCert
	 */
	public String getDatCert() {
		return datCert;
	}

	/**
	 * @param datCert the datCert to set
	 */
	public void setDatCert(String datCert) {
		this.datCert = datCert;
	}
	
	public Date getDateCertMed() {
		if (this.datCert == null || this.datCert.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datCert);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateCertMed(Date date) {
		if (date == null)
			this.datCert = null;
		else
			this.datCert = DateTools.formatDate(date);
	}

	/**
	 * @return the enuCat
	 */
	public String getEnuCat() {
		return enuCatCert;
	}

	/**
	 * @param enuCat the enuCat to set
	 */
	public void setEnuCat(String enuCatCert) {
		this.enuCatCert = enuCatCert;
	}

	/**
	 * @return the booVal
	 */
	public BigDecimal getBooVal() {
		return booVal;
	}

	/**
	 * @param booVal the booVal to set
	 */
	public void setBooVal(BigDecimal booVal) {
		this.booVal = booVal;
	}

	/**
	 * @return the libNomPat
	 */
	public String getLibNomPat() {
		return libNomPat;
	}

	/**
	 * @param libNomPat the libNomPat to set
	 */
	public void setLibNomPat(String libNomPat) {
		this.libNomPat = libNomPat;
	}

	/**
	 * @return the libNomMed
	 */
	public String getLibNomMed() {
		return libNomMed;
	}

	/**
	 * @param libNomMed the libNomMed to set
	 */
	public void setLibNomMed(String libNomMed) {
		this.libNomMed = libNomMed;
	}

	/**
	 * @return the libSoc
	 */
	public String getLibSoc() {
		return libSoc;
	}

	/**
	 * @param libSoc the libSoc to set
	 */
	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}

	/**
	 * @return the libPost
	 */
	public String getLibPost() {
		return libPost;
	}

	/**
	 * @param libPost the libPost to set
	 */
	public void setLibPost(String libPost) {
		this.libPost = libPost;
	}

	@Id
	@Column(name = "COD_CERT_MED")
	private String codCertMed;
	
	@Column(name = "REF_CERT_MED")
	private String refCertMed;
	
	@ManyToOne
	@JoinColumn(name = "COD_PAT")
	private TabPat tabPat;
	
	@ManyToOne
	@JoinColumn(name = "COD_USR")
	private TabUsr tabUsr;

	
	@Column(name = "VAL_AGE")
	private BigDecimal valAge;
	
	@Column(name = "DAT_CERT")
	private String datCert;
	
	@Column(name = "ENU_CAT_CERT")
	private String enuCatCert;
	
	@Column(name = "BOO_VAL")
	private BigDecimal booVal;
	
	@Column(name = "LIB_NOM_PAT")
	private String libNomPat;
	
	@Column(name = "LIB_NOM_MED")
	private String libNomMed;
	
	@Column(name = "LIB_SOC")
	private String libSoc; 
	
	@Column(name = "LIB_POST")
	private String libPost;
	
	@Column(name = "TYP_VIS_MED_SRC")
	private String typVisMedSrc;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_EMB")
	private TabVisMedEmb tabVisMedEmb;
	
	@ManyToOne
	@JoinColumn(name = "COD_VIS_MED_PERIO")
	private TabVisMedPerio tabVisMedPerio;

	public Date getDateCert() {
		if (this.datCert == null || this.datCert.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datCert);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateCert(Date date) {
		if (date == null)
			this.datCert = null;
		else
			this.datCert = DateTools.formatDate(date);
	}

	
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return getCodCertMed();
	}

	@Override
	public void setId(Serializable id) {
		// TODO Auto-generated method stub
		setCodCertMed((String)id);
	}

	@Override
	public void validateData() {
		// TODO Auto-generated method stub
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		
		tabUsr = (tabUsr != null && 
				(tabUsr.getCodUsr() == null || tabUsr.getCodUsr().trim().isEmpty())
				? null : tabUsr);
		
		tabVisMedEmb = (tabVisMedEmb != null && 
				(tabVisMedEmb.getCodVisMedEmb() == null || tabVisMedEmb.getCodVisMedEmb().trim().isEmpty())
				? null : tabVisMedEmb);
		
		tabVisMedPerio = (tabVisMedPerio != null && 
				(tabVisMedPerio.getCodVisMedPerio() == null || tabVisMedPerio.getCodVisMedPerio().trim().isEmpty())
				? null : tabVisMedPerio);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub		
		tabPat = (tabPat != null && 
				(tabPat.getCodPat() == null || tabPat.getCodPat().trim().isEmpty())
				? null : tabPat);
		tabVisMedEmb = (tabVisMedEmb == null ? new TabVisMedEmb() : tabVisMedEmb);
		tabVisMedPerio = (tabVisMedPerio == null ? new TabVisMedPerio() : tabVisMedPerio);
	}

	/**
	 * @param refCertMed the refCertMed to set
	 */
	public void setRefCertMed(String refCertMed) {
		this.refCertMed = refCertMed;
	}

	/**
	 * @return the refCertMed
	 */
	public String getRefCertMed() {
		return refCertMed;
	}

	/**
	 * @param codCertMed the codCertMed to set
	 */
	public void setCodCertMed(String codCertMed) {
		this.codCertMed = codCertMed;
	}

	/**
	 * @return the codCertMed
	 */
	public String getCodCertMed() {
		return codCertMed;
	}

	/**
	 * @param tabVisMedEmb the tabVisMedEmb to set
	 */
	public void setTabVisMedEmb(TabVisMedEmb tabVisMedEmb) {
		this.tabVisMedEmb = tabVisMedEmb;
	}

	/**
	 * @return the tabVisMedEmb
	 */
	public TabVisMedEmb getTabVisMedEmb() {
		return tabVisMedEmb;
	}

	/**
	 * @param tabVisMedPerio the tabVisMedPerio to set
	 */
	public void setTabVisMedPerio(TabVisMedPerio tabVisMedPerio) {
		this.tabVisMedPerio = tabVisMedPerio;
	}

	/**
	 * @return the tabVisMedPerio
	 */
	public TabVisMedPerio getTabVisMedPerio() {
		return tabVisMedPerio;
	}
	
	/**
	 * @return the tabUsr
	 */
	public TabUsr getTabUsr() {
		return tabUsr;
	}

	/**
	 * @param tabUsr the tabUsr to set
	 */
	public void setTabUsr(TabUsr tabUsr) {
		this.tabUsr = tabUsr;
	}

	/**
	 * @return the enuCatCert
	 */
	public String getEnuCatCert() {
		return enuCatCert;
	}

	/**
	 * @param enuCatCert the enuCatCert to set
	 */
	public void setEnuCatCert(String enuCatCert) {
		this.enuCatCert = enuCatCert;
	}

	/**
	 * @param typVisMedSrc the typVisMedSrc to set
	 */
	public void setTypVisMedSrc(String typVisMedSrc) {
		this.typVisMedSrc = typVisMedSrc;
	}

	/**
	 * @return the typVisMedSrc
	 */
	public String getTypVisMedSrc() {
		return typVisMedSrc;
	}

}
