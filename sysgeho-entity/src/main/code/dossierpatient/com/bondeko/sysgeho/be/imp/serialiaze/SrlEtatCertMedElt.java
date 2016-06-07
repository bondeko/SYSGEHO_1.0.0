/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;

public class SrlEtatCertMedElt {

	private String refCertMed;
	private String libNomMed;
	private String libSpec;
	private String libNomPat;
	private BigDecimal valAge;
	private String libSoc;
	private String libVisMed;
	private String datVisMed;
	private String datCertMed;
	/**
	 * Valeur à l'erreur
	 */
	 private static String ERROR_VALUE = "";
	 private static BigDecimal ERROR_NUM = null;

	 public SrlEtatCertMedElt() {

	 }

	 public SrlEtatCertMedElt(TabCertMed certMed){

		 try {
			 this.refCertMed = certMed.getRefCertMed();
		 }catch (Exception e) {
			 this.refCertMed=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libNomMed = certMed.getTabUsr().getLibNom()+" " + certMed.getTabUsr().getLibPre();
		 }catch (Exception e) {
			 this.libNomMed=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libSpec = "CNOM N°3615 spécialiste Diplômé de santé et sécurité au travail et hygiène industrielle";
		 }catch (Exception e) {
			 this.libSpec=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libNomPat = certMed.getTabPat().getLibNom()+" " + certMed.getTabPat().getLibPre();
		 }catch (Exception e) {
			 this.libNomPat=ERROR_VALUE ;
		 }
		 
		 try {
			 this.valAge = certMed.getValAge();
		 }catch (Exception e) {
			 this.valAge=ERROR_NUM ;
		 }
		 
		 try {
			 this.libSoc = (certMed.getTabVisMedEmb()!= null ? "Candidat à l'emploi à la société "+certMed.getTabPat().getTabSoc().getLibSoc(): "Employé à la société "+certMed.getTabPat().getTabSoc().getLibSoc());
		 }catch (Exception e) {
			 this.libSoc=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libVisMed = (certMed.getTabVisMedEmb()!= null ? certMed.getTabVisMedEmb().getLibMotif(): certMed.getTabVisMedPerio().getLibVisMedPerio());
		 }catch (Exception e) {
			 this.libVisMed=ERROR_VALUE ;
		 }
		 
		 try {
			 this.datVisMed = (certMed.getTabVisMedEmb()!= null ?  DateTools.formatDate("dd/MM/yyyy", DateTools
					 .getDateValue(certMed.getTabVisMedEmb().getDatVisMed())): 
						  DateTools.formatDate("dd/MM/yyyy", DateTools
							 .getDateValue(certMed.getTabVisMedPerio().getDatVisMed())));
		 }catch (Exception e) {
			 this.datVisMed=ERROR_VALUE ;
		 }
		 
		 try {
			 this.datCertMed = DateTools.formatDate("dd/MM/yyyy", DateTools
					 .getDateValue(certMed.getDatCert()));
		 } catch (Exception e) {
			 this.datCertMed = ERROR_VALUE;
		 }
		 
		 
	 }

	/**
	 * @return the refCertMed
	 */
	public String getRefCertMed() {
		return refCertMed;
	}

	/**
	 * @param refCertMed the refCertMed to set
	 */
	public void setRefCertMed(String refCertMed) {
		this.refCertMed = refCertMed;
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
	 * @return the libSpec
	 */
	public String getLibSpec() {
		return libSpec;
	}

	/**
	 * @param libSpec the libSpec to set
	 */
	public void setLibSpec(String libSpec) {
		this.libSpec = libSpec;
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
	 * @return the libVisMed
	 */
	public String getLibVisMed() {
		return libVisMed;
	}

	/**
	 * @param libVisMed the libVisMed to set
	 */
	public void setLibVisMed(String libVisMed) {
		this.libVisMed = libVisMed;
	}

	/**
	 * @return the datVisMed
	 */
	public String getDatVisMed() {
		return datVisMed;
	}

	/**
	 * @param datVisMed the datVisMed to set
	 */
	public void setDatVisMed(String datVisMed) {
		this.datVisMed = datVisMed;
	}

	/**
	 * @return the datCertMed
	 */
	public String getDatCertMed() {
		return datCertMed;
	}

	/**
	 * @param datCertMed the datCertMed to set
	 */
	public void setDatCertMed(String datCertMed) {
		this.datCertMed = datCertMed;
	}
	 
	 
}
