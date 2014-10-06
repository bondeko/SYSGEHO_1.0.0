/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.imp.entity.TabPat;

public class SrlEtatFichePatElt {

	private String codPat;
	private String libMat;
	private String libTit;
	private String libNom;
	private String libPre;
	private String libStaMat;
	private String datNais;
	private String libSex;
	private String libAdd;
	private String libTel;
	private String libCni;
	private String libProf;
	private String libFonc;
	private String booAff;
	private String booAss;
	private String libPerCon;
	private String libNumTelPerCon;
	private String libNumCnps;
	private String libAss;
	private String libSoc;
	private String siegeSoc;
	private String villeSoc;
	private String telSoc;
	private String respoSoc;
	private String addSoc;
	private String datEnreg;
	private String libMed;

	/**
	 * Valeur à l'erreur
	 */
	 private static String ERROR_VALUE = "";

	 public SrlEtatFichePatElt() {

	 }

	 public SrlEtatFichePatElt(TabPat patient){

		 try {
			 this.codPat = patient.getCodPat();
		 }catch (Exception e) {
			 this.codPat=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libMat = patient.getLibMat();
		 }catch (Exception e) {
			 this.libMat=ERROR_VALUE ;
		 }
		 
		 try {
			 this.libTit = patient.getLEnuTitre();
		 }catch (Exception e) {
			 this.libTit=ERROR_VALUE ;
		 }

		 try {
			 this.libNom = patient.getLibNom();
		 }catch (Exception e) {
			 this.libNom=ERROR_VALUE ;
		 }
		 try {
			 this.libPre = patient.getLibPre();
		 }catch (Exception e) {
			 this.libPre=ERROR_VALUE ;
		 }
		 try {
			 this.libStaMat = patient.getLEnuStaMat();
		 }catch (Exception e) {
			 this.libPre=ERROR_VALUE ;
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
			 this.libAdd = patient.getLibAdr();
		 }catch (Exception e) {
			 this.libAdd=ERROR_VALUE ;
		 }
		 try {
			 this.libTel = patient.getLibNumTel();
		 }catch (Exception e) {
			 this.libTel=ERROR_VALUE ;
		 }
		 try {
			 this.libCni = patient.getLibNumCni();
		 }catch (Exception e) {
			 this.libCni=ERROR_VALUE ;
		 }
		 try {
			 this.libProf = patient.getLibProf();
		 }catch (Exception e) {
			 this.libProf=ERROR_VALUE ;
		 }
		 try {
			 this.libFonc = patient.getLibFon();
		 }catch (Exception e) {
			 this.libFonc=ERROR_VALUE ;
		 }
		 try {
			 this.booAff = (patient.getBooEstAff()==BigDecimal.ONE ? "OUI":"NON");
		 }catch (Exception e) {
			 this.booAff=ERROR_VALUE ;
		 }
		 try {
			 this.booAss = (patient.getBooEstAss()==BigDecimal.ONE ? "OUI":"NON");
		 }catch (Exception e) {
			 this.booAss=ERROR_VALUE ;
		 }
		 try {
			 this.libPerCon = patient.getLibPerCon();
		 }catch (Exception e) {
			 this.libPerCon=ERROR_VALUE ;
		 }
		 try {
			 this.libNumTelPerCon = patient.getLibNumTelPerCon();
		 }catch (Exception e) {
			 this.libNumTelPerCon=ERROR_VALUE ;
		 }
		 try {
			 this.libNumCnps = patient.getLibNumCnps();
		 }catch (Exception e) {
			 this.libNumCnps=ERROR_VALUE ;
		 }
		 if(patient.getTabAss() != null){
			 try {
				 this.libAss = patient.getTabAss().getLibAss();
			 }catch (Exception e) {
				 this.libAss=ERROR_VALUE ;
			 }
		 }
		 if(patient.getTabSoc() != null){
			 try {
				 this.libSoc = patient.getTabSoc().getLibSoc();
			 }catch (Exception e) {
				 this.libSoc=ERROR_VALUE ;
			 }
			 try {
				 this.siegeSoc = patient.getTabSoc().getLibSiege();
			 }catch (Exception e) {
				 this.siegeSoc=ERROR_VALUE ;
			 }
			 try {
				 this.villeSoc = patient.getTabSoc().getLibVil();
			 }catch (Exception e) {
				 this.villeSoc=ERROR_VALUE ;
			 }
			 try {
				 this.telSoc = patient.getTabSoc().getLibTel();
			 }catch (Exception e) {
				 this.telSoc=ERROR_VALUE ;
			 }
			 try {
				 this.respoSoc = patient.getTabSoc().getLibResp();
			 }catch (Exception e) {
				 this.respoSoc=ERROR_VALUE ;
			 }
			 try {
				 this.addSoc = patient.getTabSoc().getLibAdrCom();
			 }catch (Exception e) {
				 this.addSoc=ERROR_VALUE ;
			 }
		 }
		 try {
			 this.datEnreg = DateTools.formatDate("dd/MM/yyyy", DateTools
					 .getDateValue(patient.getDatEnreg()));
		 } catch (Exception e) {
			 this.datEnreg = ERROR_VALUE;
		 }
		 try {
			 this.libMed = patient.getLibMed();
		 }catch (Exception e) {
			 this.libMed=ERROR_VALUE ;
		 }
		 
	 }

	public String getCodPat() {
		return codPat;
	}

	public void setCodPat(String codPat) {
		this.codPat = codPat;
	}

	public String getLibMat() {
		return libMat;
	}

	public void setLibMat(String libMat) {
		this.libMat = libMat;
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

	public String getLibPre() {
		return libPre;
	}

	public void setLibPre(String libPre) {
		this.libPre = libPre;
	}

	public String getLibStaMat() {
		return libStaMat;
	}

	public void setLibStaMat(String libStaMat) {
		this.libStaMat = libStaMat;
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

	public String getLibAdd() {
		return libAdd;
	}

	public void setLibAdd(String libAdd) {
		this.libAdd = libAdd;
	}

	public String getLibTel() {
		return libTel;
	}

	public void setLibTel(String libTel) {
		this.libTel = libTel;
	}

	public String getLibCni() {
		return libCni;
	}

	public void setLibCni(String libCni) {
		this.libCni = libCni;
	}

	public String getLibProf() {
		return libProf;
	}

	public void setLibProf(String libProf) {
		this.libProf = libProf;
	}

	public String getLibFonc() {
		return libFonc;
	}

	public void setLibFonc(String libFonc) {
		this.libFonc = libFonc;
	}

	public String getBooAff() {
		return booAff;
	}

	public void setBooAff(String booAff) {
		this.booAff = booAff;
	}

	public String getBooAss() {
		return booAss;
	}

	public void setBooAss(String booAss) {
		this.booAss = booAss;
	}

	public String getLibPerCon() {
		return libPerCon;
	}

	public void setLibPerCon(String libPerCon) {
		this.libPerCon = libPerCon;
	}

	public String getLibNumTelPerCon() {
		return libNumTelPerCon;
	}

	public void setLibNumTelPerCon(String libNumTelPerCon) {
		this.libNumTelPerCon = libNumTelPerCon;
	}

	public String getLibNumCnps() {
		return libNumCnps;
	}

	public void setLibNumCnps(String libNumCnps) {
		this.libNumCnps = libNumCnps;
	}

	public String getLibAss() {
		return libAss;
	}

	public void setLibAss(String libAss) {
		this.libAss = libAss;
	}

	public String getLibSoc() {
		return libSoc;
	}

	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}

	public String getSiegeSoc() {
		return siegeSoc;
	}

	public void setSiegeSoc(String siegeSoc) {
		this.siegeSoc = siegeSoc;
	}

	public String getVilleSoc() {
		return villeSoc;
	}

	public void setVilleSoc(String villeSoc) {
		this.villeSoc = villeSoc;
	}

	public String getTelSoc() {
		return telSoc;
	}

	public void setTelSoc(String telSoc) {
		this.telSoc = telSoc;
	}

	public String getRespoSoc() {
		return respoSoc;
	}

	public void setRespoSoc(String respoSoc) {
		this.respoSoc = respoSoc;
	}

	public String getAddSoc() {
		return addSoc;
	}

	public void setAddSoc(String addSoc) {
		this.addSoc = addSoc;
	}

	public String getDatEnreg() {
		return datEnreg;
	}

	public void setDatEnreg(String datEnreg) {
		this.datEnreg = datEnreg;
	}

	public String getLibMed() {
		return libMed;
	}

	public void setLibMed(String libMed) {
		this.libMed = libMed;
	}
}
