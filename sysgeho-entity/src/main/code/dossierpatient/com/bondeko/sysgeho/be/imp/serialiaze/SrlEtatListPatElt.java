/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabPat;

/**
 * @author STEPH
 *
 */
public class SrlEtatListPatElt {
	 private String codPat;
     private String libTit;
	  private String libNom;
	  private String datNais;
	  private String libSex;
	  private String libSoc;
	  private String libNumTel;
	  private String datEnreg;
	  private String booEstAff;
	  
	  /**
	   * Valeur à l'erreur
	   */
	  private static String ERROR_VALUE = "";

	  public SrlEtatListPatElt() {

	  }
	  
	  public SrlEtatListPatElt(TabPat patient){

		  try {
			  this.codPat = patient.getCodPat();
		  }catch (Exception e) {
			  this.codPat=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libNom = patient.getLibNom() +" "+patient.getLibPre();
		  }catch (Exception e) {
			  this.libNom=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libTit = patient.getLibTit();
		  }catch (Exception e) {
			  this.libTit=ERROR_VALUE ;
		  }
		  
		  try {
			  this.datNais = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(patient.getDatNais()));
		  } catch (Exception e) {
			  this.datNais = ERROR_VALUE;
		  }
		  
		  
		  try {
			  this.libSex = patient.getLibSex();
		  }catch (Exception e) {
			  this.libSex=ERROR_VALUE ;
		  }
		  
		  try {
			  this.datEnreg = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(patient.getDatEnreg()));
		  } catch (Exception e) {
			  this.datEnreg = ERROR_VALUE;
		  }
		  
		  try {
			  this.libSoc = patient.getTabSoc().getLibSoc();
		  }catch (Exception e) {
			  this.libSoc=ERROR_VALUE ;
		  }
		  
		  try {
			  this.libNumTel = patient.getLibNumTel();
		  }catch (Exception e) {
			  this.libNumTel=ERROR_VALUE ;
		  }
		  
		  try {
			  this.booEstAff = (patient.getBooEstAff()==BigDecimal.ONE ? "OUI":"NON");
		  }catch (Exception e) {
			  this.booEstAff=ERROR_VALUE ;
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

	public String getDatEnreg() {
		return datEnreg;
	}

	public void setDatEnreg(String datEnreg) {
		this.datEnreg = datEnreg;
	}

	public String getBooEstAff() {
		return booEstAff;
	}

	public void setBooEstAff(String booEstAff) {
		this.booEstAff = booEstAff;
	}
	  
	  


}
