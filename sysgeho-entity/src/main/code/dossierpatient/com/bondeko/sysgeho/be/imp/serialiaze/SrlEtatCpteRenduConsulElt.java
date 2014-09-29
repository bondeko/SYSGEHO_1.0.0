/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;

/**
 * @author STEPH
 *
 */
public class SrlEtatCpteRenduConsulElt {
	  private String codCpteRenduConsul;
      private String datCpteRenduConsul;
	  private String codConsul;
	  private String codPat;
	  private String libTit;
	  private String libMat;
	  private String libNom;
	  private String datNais;
	  private String libSoc;
	  private String libNumTel;
	  private String libProf;
	  private String libMedTrait;
	  private String libMedConsul;
	  private String libMotifConsul;
	  private String libHisMal;
	  private String libAntProf;
	  private String libAntPers;
	  private String libAntFami;
	  private String libDiagSenc;
	  private String libDiagPrin;
	  private String libExamPhy;
	  private String libExamBio;
	  private String libExploFonc;
	  private String libExamImag;
	  private String libTraitPres;
	  private String libConcl;
	  
	  
	  
	  /**
	   * Valeur à l'erreur
	   */
	  private static String ERROR_VALUE = "";

	  public SrlEtatCpteRenduConsulElt() {

	  }
	  
	  public SrlEtatCpteRenduConsulElt(TabCpteRenduConsul cpterendu){

		  try {
			  this.codCpteRenduConsul = cpterendu.getCodCpteRenduConsul();
		  }catch (Exception e) {
			  this.codCpteRenduConsul=ERROR_VALUE ;
		  }
		  try {
			  this.datCpteRenduConsul = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(cpterendu.getDat()));
		  } catch (Exception e) {
			  this.datCpteRenduConsul = ERROR_VALUE;
		  }
		  try {
			  this.codConsul = cpterendu.getTabConsul().getCodConsul();
		  }catch (Exception e) {
			  this.codConsul=ERROR_VALUE ;
		  }
		  try {
			  this.libMat = cpterendu.getTabConsul().getTabPat().getLibMat();
		  }catch (Exception e) {
			  this.libMat=ERROR_VALUE ;
		  }
		  try {
			  this.libSoc = cpterendu.getTabConsul().getTabPat().getTabSoc().getLibSoc();
		  }catch (Exception e) {
			  this.libSoc=ERROR_VALUE ;
		  }
		  try {
			  this.libNumTel = cpterendu.getTabConsul().getTabPat().getLibNumTel();
		  }catch (Exception e) {
			  this.libNumTel=ERROR_VALUE ;
		  }
		  try {
			  this.libProf = cpterendu.getTabConsul().getTabPat().getLibProf();
		  }catch (Exception e) {
			  this.libProf=ERROR_VALUE ;
		  }
		  try {
			  this.libMedTrait = cpterendu.getTabConsul().getTabPat().getLibMed();
		  }catch (Exception e) {
			  this.libMedTrait=ERROR_VALUE ;
		  }
		  try {
			  this.libMedConsul = cpterendu.getTabConsul().getTabUsr().getLibNom()+ " " 
			  					  + cpterendu.getTabConsul().getTabUsr().getLibPre();
		  }catch (Exception e) {
			  this.libMedConsul=ERROR_VALUE ;
		  }
		  try {
			  this.libMotifConsul = cpterendu.getLibMotifConsul();
		  }catch (Exception e) {
			  this.libMotifConsul=ERROR_VALUE ;
		  }
		  try {
			  this.libHisMal = cpterendu.getLibHisMal();
		  }catch (Exception e) {
			  this.libHisMal=ERROR_VALUE ;
		  }
		  try {
			  this.libAntFami = "pas de champs en BD";
		  }catch (Exception e) {
			  this.libAntFami=ERROR_VALUE ;
		  }
		  try {
			  this.libAntProf = "pas de champs en BD";
		  }catch (Exception e) {
			  this.libAntProf=ERROR_VALUE ;
		  }
		  try {
			  this.libAntPers = "pas de champs en BD";
		  }catch (Exception e) {
			  this.libAntPers=ERROR_VALUE ;
		  }
		  try {
			  this.libDiagPrin = cpterendu.getLibDiagPrin();
		  }catch (Exception e) {
			  this.libDiagPrin=ERROR_VALUE ;
		  }
		  try {
			  this.libDiagSenc = cpterendu.getLibDiagSenc();
		  }catch (Exception e) {
			  this.libDiagSenc=ERROR_VALUE ;
		  }
		  try {
			  this.libExamBio = cpterendu.getLibExamBio();
		  }catch (Exception e) {
			  this.libExamBio=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libExamPhy = "Pas de champs en BD";
		  }catch (Exception e) {
			  this.libExamPhy=ERROR_VALUE ;
		  }
		  try {
			  this.libExamImag = cpterendu.getLibExamImag();
		  }catch (Exception e) {
			  this.libExamImag=ERROR_VALUE ;
		  }
		  try {
			  this.libExploFonc = cpterendu.getLibExploFonc();
		  }catch (Exception e) {
			  this.libExploFonc=ERROR_VALUE ;
		  }
		  try {
			  this.libTraitPres = cpterendu.getLibTraitPres();
		  }catch (Exception e) {
			  this.libTraitPres=ERROR_VALUE ;
		  }
		  try {
			  this.libConcl = cpterendu.getLibConcl();
		  }catch (Exception e) {
			  this.libConcl=ERROR_VALUE ;
		  }  
		  try {
			  this.codPat = cpterendu.getTabConsul().getTabPat().getCodPat();
		  }catch (Exception e) {
			  this.codPat=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libNom = cpterendu.getTabConsul().getTabPat().getLibNom() +" "+cpterendu.getTabConsul().getTabPat().getLibPre();
		  }catch (Exception e) {
			  this.libNom=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libTit = cpterendu.getTabConsul().getTabPat().getLibTit();
		  }catch (Exception e) {
			  this.libTit=ERROR_VALUE ;
		  }
		  
		  try {
			  this.datNais = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(cpterendu.getTabConsul().getTabPat().getDatNais()));
		  } catch (Exception e) {
			  this.datNais = ERROR_VALUE;
		  }
		  		 
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

	/**
	 * @param codCpteRenduConsul the codCpteRenduConsul to set
	 */
	public void setCodCpteRenduConsul(String codCpteRenduConsul) {
		this.codCpteRenduConsul = codCpteRenduConsul;
	}

	/**
	 * @return the codCpteRenduConsul
	 */
	public String getCodCpteRenduConsul() {
		return codCpteRenduConsul;
	}

	/**
	 * @param datCpteRenduConsul the datCpteRenduConsul to set
	 */
	public void setDatCpteRenduConsul(String datCpteRenduConsul) {
		this.datCpteRenduConsul = datCpteRenduConsul;
	}

	/**
	 * @return the datCpteRenduConsul
	 */
	public String getDatCpteRenduConsul() {
		return datCpteRenduConsul;
	}

	/**
	 * @param codConsul the codConsul to set
	 */
	public void setCodConsul(String codConsul) {
		this.codConsul = codConsul;
	}

	/**
	 * @return the codConsul
	 */
	public String getCodConsul() {
		return codConsul;
	}

	/**
	 * @param libMat the libMat to set
	 */
	public void setLibMat(String libMat) {
		this.libMat = libMat;
	}

	/**
	 * @return the libMat
	 */
	public String getLibMat() {
		return libMat;
	}

	/**
	 * @param libProf the libProf to set
	 */
	public void setLibProf(String libProf) {
		this.libProf = libProf;
	}

	/**
	 * @return the libProf
	 */
	public String getLibProf() {
		return libProf;
	}

	/**
	 * @param libMedTrait the libMedTrait to set
	 */
	public void setLibMedTrait(String libMedTrait) {
		this.libMedTrait = libMedTrait;
	}

	/**
	 * @return the libMedTrait
	 */
	public String getLibMedTrait() {
		return libMedTrait;
	}

	/**
	 * @param libMedConsul the libMedConsul to set
	 */
	public void setLibMedConsul(String libMedConsul) {
		this.libMedConsul = libMedConsul;
	}

	/**
	 * @return the libMedConsul
	 */
	public String getLibMedConsul() {
		return libMedConsul;
	}

	/**
	 * @param libMotifConsul the libMotifConsul to set
	 */
	public void setLibMotifConsul(String libMotifConsul) {
		this.libMotifConsul = libMotifConsul;
	}

	/**
	 * @return the libMotifConsul
	 */
	public String getLibMotifConsul() {
		return libMotifConsul;
	}

	/**
	 * @param libHisMal the libHisMal to set
	 */
	public void setLibHisMal(String libHisMal) {
		this.libHisMal = libHisMal;
	}

	/**
	 * @return the libHisMal
	 */
	public String getLibHisMal() {
		return libHisMal;
	}

	/**
	 * @param libAntProf the libAntProf to set
	 */
	public void setLibAntProf(String libAntProf) {
		this.libAntProf = libAntProf;
	}

	/**
	 * @return the libAntProf
	 */
	public String getLibAntProf() {
		return libAntProf;
	}

	/**
	 * @param libAntPers the libAntPers to set
	 */
	public void setLibAntPers(String libAntPers) {
		this.libAntPers = libAntPers;
	}

	/**
	 * @return the libAntPers
	 */
	public String getLibAntPers() {
		return libAntPers;
	}

	/**
	 * @param libAntFami the libAntFami to set
	 */
	public void setLibAntFami(String libAntFami) {
		this.libAntFami = libAntFami;
	}

	/**
	 * @return the libAntFami
	 */
	public String getLibAntFami() {
		return libAntFami;
	}

	/**
	 * @param libDiagSenc the libDiagSenc to set
	 */
	public void setLibDiagSenc(String libDiagSenc) {
		this.libDiagSenc = libDiagSenc;
	}

	/**
	 * @return the libDiagSenc
	 */
	public String getLibDiagSenc() {
		return libDiagSenc;
	}

	/**
	 * @param libDiagPrin the libDiagPrin to set
	 */
	public void setLibDiagPrin(String libDiagPrin) {
		this.libDiagPrin = libDiagPrin;
	}

	/**
	 * @return the libDiagPrin
	 */
	public String getLibDiagPrin() {
		return libDiagPrin;
	}

	/**
	 * @param libExamPhy the libExamPhy to set
	 */
	public void setLibExamPhy(String libExamPhy) {
		this.libExamPhy = libExamPhy;
	}

	/**
	 * @return the libExamPhy
	 */
	public String getLibExamPhy() {
		return libExamPhy;
	}

	/**
	 * @param libExamBio the libExamBio to set
	 */
	public void setLibExamBio(String libExamBio) {
		this.libExamBio = libExamBio;
	}

	/**
	 * @return the libExamBio
	 */
	public String getLibExamBio() {
		return libExamBio;
	}

	/**
	 * @param libExploFonc the libExploFonc to set
	 */
	public void setLibExploFonc(String libExploFonc) {
		this.libExploFonc = libExploFonc;
	}

	/**
	 * @return the libExploFonc
	 */
	public String getLibExploFonc() {
		return libExploFonc;
	}

	/**
	 * @param libExamImag the libExamImag to set
	 */
	public void setLibExamImag(String libExamImag) {
		this.libExamImag = libExamImag;
	}

	/**
	 * @return the libExamImag
	 */
	public String getLibExamImag() {
		return libExamImag;
	}

	/**
	 * @param libTraitPres the libTraitPres to set
	 */
	public void setLibTraitPres(String libTraitPres) {
		this.libTraitPres = libTraitPres;
	}

	/**
	 * @return the libTraitPres
	 */
	public String getLibTraitPres() {
		return libTraitPres;
	}

	/**
	 * @param libConcl the libConcl to set
	 */
	public void setLibConcl(String libConcl) {
		this.libConcl = libConcl;
	}

	/**
	 * @return the libConcl
	 */
	public String getLibConcl() {
		return libConcl;
	}

	
	  


}
