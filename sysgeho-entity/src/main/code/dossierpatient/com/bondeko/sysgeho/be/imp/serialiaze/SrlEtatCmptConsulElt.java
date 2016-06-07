/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;

/**
 * @author DECO
 *
 */
public class SrlEtatCmptConsulElt {
	
	private String codPrestation;
	private String catPrestation;
	private String libPrestation;
	private String datPrestation;
	private String enuModPchg;
	private String isFacture;
	private String isPaye;
	private String libNom;
	private BigDecimal vMtnPres;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	private static BigDecimal ERROR_NUM = null;

	public SrlEtatCmptConsulElt() {

	}
	
	public SrlEtatCmptConsulElt(TabConsul consul) {

		try {
			if (consul != null)
				this.codPrestation = consul.getCodConsul();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.catPrestation = "Consultations";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.libPrestation = "Consultation en " + consul.getTabSpec().getLibSpec();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(consul.getDatConsul()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (consul != null)
					this.enuModPchg = EnuModPchg.getByValue(consul.getEnuModPchg()).getLibelle();
		} catch (Exception e) {
			this.enuModPchg = ERROR_VALUE;
		}
		try {
			if (consul.getBEstFact()){
				this.isFacture = "OUI";
			} else
			this.isFacture = "NON";
		} catch (Exception e) {
			this.isFacture = ERROR_VALUE;
		}
		
		try {
			if (consul.getBEstPaie()){
				this.isPaye = "OUI";
			} else
			this.isPaye = "NON";
		} catch (Exception e) {
			this.isPaye = ERROR_VALUE;
		}
		
		try {
			if (consul != null)
				this.vMtnPres = consul.getValMntTtc();
		} catch (Exception e) {
			this.vMtnPres = ERROR_NUM;
		}
		
		try {
			if (consul != null)
				this.libNom = consul.getTabPat().getLibNom() + " " + consul.getTabPat().getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		
	}
	

	/**
	 * @return the codPrestation
	 */
	public String getCodPrestation() {
		return codPrestation;
	}

	/**
	 * @param codPrestation the codPrestation to set
	 */
	public void setCodPrestation(String codPrestation) {
		this.codPrestation = codPrestation;
	}

	/**
	 * @return the catPrestation
	 */
	public String getCatPrestation() {
		return catPrestation;
	}

	/**
	 * @param catPrestation the catPrestation to set
	 */
	public void setCatPrestation(String catPrestation) {
		this.catPrestation = catPrestation;
	}

	/**
	 * @return the libPrestation
	 */
	public String getLibPrestation() {
		return libPrestation;
	}

	/**
	 * @param libPrestation the libPrestation to set
	 */
	public void setLibPrestation(String libPrestation) {
		this.libPrestation = libPrestation;
	}

	/**
	 * @return the datPrestation
	 */
	public String getDatPrestation() {
		return datPrestation;
	}

	/**
	 * @param datPrestation the datPrestation to set
	 */
	public void setDatPrestation(String datPrestation) {
		this.datPrestation = datPrestation;
	}

	/**
	 * @return the enuModPchg
	 */
	public String getEnuModPchg() {
		return enuModPchg;
	}

	/**
	 * @param enuModPchg the enuModPchg to set
	 */
	public void setEnuModPchg(String enuModPchg) {
		this.enuModPchg = enuModPchg;
	}

	/**
	 * @return the isFacture
	 */
	public String getIsFacture() {
		return isFacture;
	}

	/**
	 * @param isFacture the isFacture to set
	 */
	public void setIsFacture(String isFacture) {
		this.isFacture = isFacture;
	}

	/**
	 * @return the isPaye
	 */
	public String getIsPaye() {
		return isPaye;
	}

	/**
	 * @param isPaye the isPaye to set
	 */
	public void setIsPaye(String isPaye) {
		this.isPaye = isPaye;
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
	 * @return the vMtnPres
	 */
	public BigDecimal getvMtnPres() {
		return vMtnPres;
	}

	/**
	 * @param vMtnPres the vMtnPres to set
	 */
	public void setvMtnPres(BigDecimal vMtnPres) {
		this.vMtnPres = vMtnPres;
	}

}
