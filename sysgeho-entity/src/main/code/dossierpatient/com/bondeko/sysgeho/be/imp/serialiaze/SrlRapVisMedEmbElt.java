/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;

/**
 * @author DECO
 *
 */
public class SrlRapVisMedEmbElt {
	
	private String codRapVisMed;
	private String codVisMed;
    private String datVisMed;
    private String datEdi;
	  private String libVisMedEmb;
	  private String libSoc;
	  private String libTit;
	  private String libMat;
	  private String libNom;
	  private String datNais;
	  private String libNumTel;
	  private String libObj;
	  private String libRapExamCli;
	  private String libRapExamNor;
	  private String libRapExamAnor;
	  private String libConcl;
	  private String libRecomPart;
	  
	  /**
	   * Valeur à l'erreur
	   */
	  private static String ERROR_VALUE = "";

	  public SrlRapVisMedEmbElt() {

	  }
	  
	  public SrlRapVisMedEmbElt(TabRapVisMedEmb rapport){

		  try {
			  this.codRapVisMed= rapport.getCodRapVisMedEmb();
		  }catch (Exception e) {
			  this.codRapVisMed=ERROR_VALUE ;
		  }
		  try {
			  this.codVisMed= rapport.getTabVisMedEmb().getCodVisMedEmb();
		  }catch (Exception e) {
			  this.codVisMed=ERROR_VALUE ;
		  }
		  try {
			  this.datVisMed = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(rapport.getTabVisMedEmb().getDatVisMed()));
		  } catch (Exception e) {
			  this.datVisMed = ERROR_VALUE;
		  }
		  try {
			  this.datVisMed = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(rapport.getTabVisMedEmb().getDatVisMed()));
		  } catch (Exception e) {
			  this.datVisMed = ERROR_VALUE;
		  }
		  try {
			  this.datEdi = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(rapport.getDatEdi()));
		  } catch (Exception e) {
			  this.datEdi = ERROR_VALUE;
		  }
		  try {
			  this.libVisMedEmb= rapport.getCodRapVisMedEmb();
		  }catch (Exception e) {
			  this.libVisMedEmb=ERROR_VALUE ;
		  }
		  try {
			  this.libSoc= rapport.getTabVisMedEmb().getTabPat().getTabSoc().getLibSoc();
		  }catch (Exception e) {
			  this.libSoc=ERROR_VALUE ;
		  }
		  try {
			  this.libTit= rapport.getTabVisMedEmb().getTabPat().getLibTit();
		  }catch (Exception e) {
			  this.libTit=ERROR_VALUE ;
		  }
		  try {
			  this.libMat= rapport.getTabVisMedEmb().getTabPat().getLibMat();
		  }catch (Exception e) {
			  this.libMat=ERROR_VALUE ;
		  }
		  try {
			  this.libNom= rapport.getTabVisMedEmb().getTabPat().getLibTit()+ ". " + rapport.getTabVisMedEmb().getTabPat().getLibNom()+ " " + rapport.getTabVisMedEmb().getTabPat().getLibPre();
		  }catch (Exception e) {
			  this.libMat=ERROR_VALUE ;
		  }
		  try {
			  this.datNais = DateTools.formatDate("dd/MM/yyyy", DateTools
					  .getDateValue(rapport.getTabVisMedEmb().getTabPat().getDatNais()));
		  } catch (Exception e) {
			  this.datNais = ERROR_VALUE;
		  }
		  try {
			  this.libNumTel= rapport.getTabVisMedEmb().getTabPat().getLibNumTel();
		  }catch (Exception e) {
			  this.libNumTel=ERROR_VALUE ;
		  }
		  try {
			  this.libObj= rapport.getLibObj();
		  }catch (Exception e) {
			  this.libObj=ERROR_VALUE ;
		  }
		  try {
			  this.libRapExamCli= rapport.getLibRapExamCli();
		  }catch (Exception e) {
			  this.libRapExamCli=ERROR_VALUE ;
		  }
		  try {
			  this.libRapExamNor= rapport.getLibRapExamNor();
		  }catch (Exception e) {
			  this.libRapExamNor=ERROR_VALUE ;
		  }
		  try {
			  this.libRapExamAnor= rapport.getLibRapExamAnor();
		  }catch (Exception e) {
			  this.libRapExamAnor=ERROR_VALUE ;
		  }
		  try {
			  this.libConcl= rapport.getLibRapExamAnor();
		  }catch (Exception e) {
			  this.libConcl=ERROR_VALUE ;
		  } 
		  try {
			  this.libRecomPart= rapport.getLibRecomPart();
		  }catch (Exception e) {
			  this.libRecomPart=ERROR_VALUE ;
		  } 
		  		 
	  }

	/**
	 * @return the codRapVisMed
	 */
	public String getCodRapVisMed() {
		return codRapVisMed;
	}

	/**
	 * @param codRapVisMed the codRapVisMed to set
	 */
	public void setCodRapVisMed(String codRapVisMed) {
		this.codRapVisMed = codRapVisMed;
	}

	/**
	 * @return the codVisMed
	 */
	public String getCodVisMed() {
		return codVisMed;
	}

	/**
	 * @param codVisMed the codVisMed to set
	 */
	public void setCodVisMed(String codVisMed) {
		this.codVisMed = codVisMed;
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
	 * @return the datEdi
	 */
	public String getDatEdi() {
		return datEdi;
	}

	/**
	 * @param datEdi the datEdi to set
	 */
	public void setDatEdi(String datEdi) {
		this.datEdi = datEdi;
	}

	/**
	 * @return the libVisMedEmb
	 */
	public String getLibVisMedEmb() {
		return libVisMedEmb;
	}

	/**
	 * @param libVisMedEmb the libVisMedEmb to set
	 */
	public void setLibVisMedEmb(String libVisMedEmb) {
		this.libVisMedEmb = libVisMedEmb;
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
	 * @return the libTit
	 */
	public String getLibTit() {
		return libTit;
	}

	/**
	 * @param libTit the libTit to set
	 */
	public void setLibTit(String libTit) {
		this.libTit = libTit;
	}

	/**
	 * @return the libMat
	 */
	public String getLibMat() {
		return libMat;
	}

	/**
	 * @param libMat the libMat to set
	 */
	public void setLibMat(String libMat) {
		this.libMat = libMat;
	}

	/**
	 * @return the libNom
	 */
	public String getLibNom() {
		return libNom;
	}

	/**
	 * @param libNom the libNom to set
	 */
	public void setLibNom(String libNom) {
		this.libNom = libNom;
	}

	/**
	 * @return the datNais
	 */
	public String getDatNais() {
		return datNais;
	}

	/**
	 * @param datNais the datNais to set
	 */
	public void setDatNais(String datNais) {
		this.datNais = datNais;
	}

	/**
	 * @return the libNumTel
	 */
	public String getLibNumTel() {
		return libNumTel;
	}

	/**
	 * @param libNumTel the libNumTel to set
	 */
	public void setLibNumTel(String libNumTel) {
		this.libNumTel = libNumTel;
	}

	/**
	 * @return the libObj
	 */
	public String getLibObj() {
		return libObj;
	}

	/**
	 * @param libObj the libObj to set
	 */
	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	/**
	 * @return the libRapExamCli
	 */
	public String getLibRapExamCli() {
		return libRapExamCli;
	}

	/**
	 * @param libRapExamCli the libRapExamCli to set
	 */
	public void setLibRapExamCli(String libRapExamCli) {
		this.libRapExamCli = libRapExamCli;
	}

	/**
	 * @return the libRapExamNor
	 */
	public String getLibRapExamNor() {
		return libRapExamNor;
	}

	/**
	 * @param libRapExamNor the libRapExamNor to set
	 */
	public void setLibRapExamNor(String libRapExamNor) {
		this.libRapExamNor = libRapExamNor;
	}

	/**
	 * @return the libRapExamAnor
	 */
	public String getLibRapExamAnor() {
		return libRapExamAnor;
	}

	/**
	 * @param libRapExamAnor the libRapExamAnor to set
	 */
	public void setLibRapExamAnor(String libRapExamAnor) {
		this.libRapExamAnor = libRapExamAnor;
	}

	/**
	 * @return the libConcl
	 */
	public String getLibConcl() {
		return libConcl;
	}

	/**
	 * @param libConcl the libConcl to set
	 */
	public void setLibConcl(String libConcl) {
		this.libConcl = libConcl;
	}

	/**
	 * @return the libRecomPart
	 */
	public String getLibRecomPart() {
		return libRecomPart;
	}

	/**
	 * @param libRecomPart the libRecomPart to set
	 */
	public void setLibRecomPart(String libRecomPart) {
		this.libRecomPart = libRecomPart;
	}
	  
	  

}
