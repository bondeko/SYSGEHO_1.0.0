/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;

/**
 * @author STEPH
 *
 */
public class SrlEtatCpteRenduExamElt {
	
	  private String codCpteRenduExam;
      private String datCpteRenduExam;
	  private String codExam;
	  private String libExam;
	  private String libCatExam;
	  private String codPat;
	  private String libTit;
	  private String libMat;
	  private String libNom;
	  private String datNais;
	  private String libSex;
	  private String libSoc;
	  private String libNumTel;
	  private String libProf;
	  private String libMedTrait;
	  private String libTechExam;
	  private String libMedConsul;
	  private String libResul;
	  private String libConclu;
	  
	  
	  /**
	   * Valeur à l'erreur
	   */
	  private static String ERROR_VALUE = "";

	  public SrlEtatCpteRenduExamElt() {

	  }
	  
	  public SrlEtatCpteRenduExamElt(TabCpteRenduExam cpterendu){

		  try {
			  this.codCpteRenduExam = cpterendu.getCodCpteRenduExam();
		  }catch (Exception e) {
			  this.codCpteRenduExam=ERROR_VALUE ;
		  }
		  try {
			  this.datCpteRenduExam = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(cpterendu.getDat()));
		  } catch (Exception e) {
			  this.datCpteRenduExam = ERROR_VALUE;
		  }
		  try {
			  this.codExam = cpterendu.getTabExam().getCodExam();
		  }catch (Exception e) {
			  this.codExam=ERROR_VALUE ;
		  }
		  try {
			  this.libExam = cpterendu.getTabExam().getLibExam();
		  }catch (Exception e) {
			  this.libExam=ERROR_VALUE ;
		  }
		  try {
			  this.setLibCatExam(cpterendu.getTabExam().getTabTypExam().getTabCatExam().getLibCatExam());
		  }catch (Exception e) {
			  this.setLibCatExam(ERROR_VALUE) ;
		  }
		  try {
			  this.codPat = cpterendu.getTabExam().getTabPat().getCodPat();
		  }catch (Exception e) {
			  this.codPat=ERROR_VALUE ;
		  }
		  try {
			  this.libTit = cpterendu.getTabExam().getTabPat().getLibTit();
		  }catch (Exception e) {
			  this.libTit=ERROR_VALUE ;
		  }
		  try {
			  this.libMat = cpterendu.getTabExam().getTabPat().getLibMat();
		  }catch (Exception e) {
			  this.libMat=ERROR_VALUE ;
		  }
		  try {
			  this.libNom = cpterendu.getTabExam().getTabPat().getLibNom()+" "+cpterendu.getTabExam().getTabPat().getLibPre();
		  }catch (Exception e) {
			  this.libNom=ERROR_VALUE ;
		  }
		  try {
			  this.libSex = cpterendu.getTabExam().getTabPat().getLibSex();
		  }catch (Exception e) {
			  this.libSex=ERROR_VALUE ;
		  }
		  try {
			  this.libSoc = cpterendu.getTabExam().getTabPat().getTabSoc().getLibSoc();
		  }catch (Exception e) {
			  this.libSoc=ERROR_VALUE ;
		  }
		  try {
			  this.libNumTel = cpterendu.getTabExam().getTabPat().getLibNumTel();
		  }catch (Exception e) {
			  this.libNumTel=ERROR_VALUE ;
		  }
		  try {
			  this.libMedTrait = cpterendu.getTabExam().getTabPat().getLibMed();
		  }catch (Exception e) {
			  this.libMedTrait=ERROR_VALUE ;
		  }
		  try {
			  this.libTechExam = cpterendu.getTabExam().getTabPat().getLibMed();
		  }catch (Exception e) {
			  this.libTechExam=ERROR_VALUE ;
		  }
		  try {
			  this.libResul = cpterendu.getLibResul();
		  }catch (Exception e) {
			  this.libResul=ERROR_VALUE ;
		  }
		  try {
			  this.libConclu = cpterendu.getLibConclu();
		  }catch (Exception e) {
			  this.libConclu=ERROR_VALUE ;
		  }
		  try {
			  this.datNais = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(cpterendu.getTabExam().getTabPat().getDatNais()));
		  } catch (Exception e) {
			  this.datNais = ERROR_VALUE;
		  }
		  		 
	  }
	  
	public String getCodCpteRenduExam() {
		return codCpteRenduExam;
	}
	public void setCodCpteRenduExam(String codCpteRenduExam) {
		this.codCpteRenduExam = codCpteRenduExam;
	}
	public String getDatCpteRenduExam() {
		return datCpteRenduExam;
	}
	public void setDatCpteRenduExam(String datCpteRenduExam) {
		this.datCpteRenduExam = datCpteRenduExam;
	}
	public String getCodExam() {
		return codExam;
	}
	public void setCodExam(String codExam) {
		this.codExam = codExam;
	}
	public String getLibExam() {
		return libExam;
	}
	public void setLibExam(String libExam) {
		this.libExam = libExam;
	}
	public String getCodPat() {
		return codPat;
	}
	public void setCodPat(String codPat) {
		this.codPat = codPat;
	}
	public String getLibTit() {
		return libTit;
	}
	public void setLibTit(String libTit) {
		this.libTit = libTit;
	}
	public String getLibMat() {
		return libMat;
	}
	public void setLibMat(String libMat) {
		this.libMat = libMat;
	}
	public String getLibNom() {
		return libNom;
	}
	public void setLibNom(String libNom) {
		this.libNom = libNom;
	}
	public String getDatNais() {
		return datNais;
	}
	public void setDatNais(String datNais) {
		this.datNais = datNais;
	}
	public String getLibSex() {
		return libSex;
	}
	public void setLibSex(String libSex) {
		this.libSex = libSex;
	}
	public String getLibSoc() {
		return libSoc;
	}
	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}
	public String getLibNumTel() {
		return libNumTel;
	}
	public void setLibNumTel(String libNumTel) {
		this.libNumTel = libNumTel;
	}
	public String getLibProf() {
		return libProf;
	}
	public void setLibProf(String libProf) {
		this.libProf = libProf;
	}
	public String getLibMedTrait() {
		return libMedTrait;
	}
	public void setLibMedTrait(String libMedTrait) {
		this.libMedTrait = libMedTrait;
	}
	public String getLibTechExam() {
		return libTechExam;
	}
	public void setLibTechExam(String libTechExam) {
		this.libTechExam = libTechExam;
	}
	public String getLibMedConsul() {
		return libMedConsul;
	}
	public void setLibMedConsul(String libMedConsul) {
		this.libMedConsul = libMedConsul;
	}
	public String getLibResul() {
		return libResul;
	}
	public void setLibResul(String libResul) {
		this.libResul = libResul;
	}
	public String getLibConclu() {
		return libConclu;
	}
	public void setLibConclu(String libConclu) {
		this.libConclu = libConclu;
	}

	/**
	 * @param libCatExam the libCatExam to set
	 */
	public void setLibCatExam(String libCatExam) {
		this.libCatExam = libCatExam;
	}

	/**
	 * @return the libCatExam
	 */
	public String getLibCatExam() {
		return libCatExam;
	}
	

}
