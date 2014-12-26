/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;

/**
 * @author STEPH
 *
 */
public class SrlEtatFichierExamElt {
	
	private String codTypExam;
	private String libTypExam;
	private BigDecimal valCout;
	private String libCatExam;
	private Integer compteur;
	
	/**
	 * Valeur à l'erreur
	 */
	 private static String ERROR_VALUE = "";
	 private static BigDecimal ERROR_NUM = null;
	 private static Integer ERROR_INT = null;
	 
	 public SrlEtatFichierExamElt() {

	 }

	 public SrlEtatFichierExamElt(TabTypExam exam, int i){

		 try {
			 this.compteur = i;
		 }catch (Exception e) {
			 this.compteur=ERROR_INT;
		 }
		 
		 try {
			 this.codTypExam = exam.getCodTypExam();
		 }catch (Exception e) {
			 this.codTypExam=ERROR_VALUE;
		 }
		 
		 try {
			 this.libTypExam = exam.getLibTypExam();
		 }catch (Exception e) {
			 this.libTypExam=ERROR_VALUE;
		 }
		 
		 try {
			 this.libCatExam = exam.getTabCatExam().getLibCatExam();
		 }catch (Exception e) {
			 this.libCatExam=ERROR_VALUE;
		 }
		 
		 try {
			 this.valCout = exam.getValCout();
		 }catch (Exception e) {
			 this.valCout=ERROR_NUM;
		 }
		 
	 }

	/**
	 * @return the codTypExam
	 */
	public String getCodTypExam() {
		return codTypExam;
	}

	/**
	 * @param codTypExam the codTypExam to set
	 */
	public void setCodTypExam(String codTypExam) {
		this.codTypExam = codTypExam;
	}

	/**
	 * @return the libTypExam
	 */
	public String getLibTypExam() {
		return libTypExam;
	}

	/**
	 * @param libTypExam the libTypExam to set
	 */
	public void setLibTypExam(String libTypExam) {
		this.libTypExam = libTypExam;
	}

	/**
	 * @return the valCout
	 */
	public BigDecimal getValCout() {
		return valCout;
	}

	/**
	 * @param valCout the valCout to set
	 */
	public void setValCout(BigDecimal valCout) {
		this.valCout = valCout;
	}

	/**
	 * @return the libCatExam
	 */
	public String getLibCatExam() {
		return libCatExam;
	}

	/**
	 * @param libCatExam the libCatExam to set
	 */
	public void setLibCatExam(String libCatExam) {
		this.libCatExam = libCatExam;
	}

	/**
	 * @return the compteur
	 */
	public Integer getCompteur() {
		return compteur;
	}

	/**
	 * @param compteur the compteur to set
	 */
	public void setCompteur(Integer compteur) {
		this.compteur = compteur;
	}

}
