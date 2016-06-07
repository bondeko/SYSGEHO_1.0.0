/**
 * 
 */
package com.bondeko.sysgeho.be.ref.serialize;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;

/**
 * @author DECO
 *
 */
public class SrlSocElt {
	private String codSoc;
	private String libSoc;
	private String libNumCont;
	private String libTel;
	private String booAffi;
	private String datAffi;
	private BigDecimal valEffectif;
	private BigDecimal valPrixUnit;
	private BigDecimal valMntFixeMens;
	private String libAdresse;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	
	/**
	 * Valeur à l'erreur
	 */
	private static BigDecimal ERROR_BIG_DEC = null;

	public SrlSocElt() {

	}

	public SrlSocElt(TabSoc soc){
		 
		try {
			this.codSoc = soc.getCodSoc();
		}catch (Exception e) {
			this.codSoc = ERROR_VALUE ;
		}

		try {
			this.libSoc = soc.getLibSoc();
		}catch (Exception e) {
			this.libSoc = ERROR_VALUE ;
		}

		try {
			this.libNumCont = soc.getLibObj();
		}catch (Exception e) {
			this.libNumCont = ERROR_VALUE ;
		}

		try {
			this.datAffi = DateTools.formatDate("dd/MM/yyyy", DateTools
					.getDateValue(soc.getDatAff()));
		} catch (Exception e) {
			this.datAffi = ERROR_VALUE;
		}

		try {
			this.valPrixUnit = soc.getValPriUni();
		}catch (Exception e) {
			this.valPrixUnit= ERROR_BIG_DEC ;
		}
		
		try {
			this.valMntFixeMens = soc.getValTarifFixMen();
		}catch (Exception e) {
			this.valMntFixeMens=ERROR_BIG_DEC ;
		}
		
		try {
			this.valEffectif = soc.getValEff();
		}catch (Exception e) {
			this.valEffectif=ERROR_BIG_DEC ;
		}
		
		try {
			if (soc.getBEstAff()){
				this.booAffi = "OUI";
			} else
			this.booAffi = "NON";
			
		}catch (Exception e) {
			this.valMntFixeMens=ERROR_BIG_DEC ;
		}
		
		try {
			this.libAdresse = "BP. " + soc.getLibBP() + "-"+ soc.getLibVil();
		}catch (Exception e) {
			this.libAdresse=ERROR_VALUE ;
		}
		try {
			this.libTel = soc.getLibTel();
		}catch (Exception e) {
			this.libTel=ERROR_VALUE ;
		}
		
		try {
			this.libNumCont = soc.getLibNumContrib();
		}catch (Exception e) {
			this.libNumCont=ERROR_VALUE ;
		}
		
	}

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

	public String getLibNumCont() {
		return libNumCont;
	}

	public void setLibNumCont(String libNumCont) {
		this.libNumCont = libNumCont;
	}

	public String getLibTel() {
		return libTel;
	}

	public void setLibTel(String libTel) {
		this.libTel = libTel;
	}

	public String getBooAffi() {
		return booAffi;
	}

	public void setBooAffi(String booAffi) {
		this.booAffi = booAffi;
	}

	public String getDatAffi() {
		return datAffi;
	}

	public void setDatAffi(String datAffi) {
		this.datAffi = datAffi;
	}

	public BigDecimal getValPrixUnit() {
		return valPrixUnit;
	}

	public void setValPrixUnit(BigDecimal valPrixUnit) {
		this.valPrixUnit = valPrixUnit;
	}

	public BigDecimal getValMntFixeMens() {
		return valMntFixeMens;
	}

	public void setValMntFixeMens(BigDecimal valMntFixeMens) {
		this.valMntFixeMens = valMntFixeMens;
	}

	public String getLibAdresse() {
		return libAdresse;
	}

	public void setLibAdresse(String libAdresse) {
		this.libAdresse = libAdresse;
	}

	/**
	 * @param valEffectif the valEffectif to set
	 */
	public void setValEffectif(BigDecimal valEffectif) {
		this.valEffectif = valEffectif;
	}

	/**
	 * @return the valEffectif
	 */
	public BigDecimal getValEffectif() {
		return valEffectif;
	}
	
	

}
