/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

/**
 * @author DECO
 *
 */
public class SrlEtatCmptPresElt {
	
	private String codPrestation;
	private String catPrestation;
	private String libPrestation;
	private String datPrestation;
	private String enuModPchg;
	private String isFacture;
	private String isPaye;
	private String libNom;
	private BigDecimal vMtnPres;
	private BigDecimal vSousTotal;
	private BigDecimal vMntTotal;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	private static BigDecimal ERROR_NUM = null;

	public SrlEtatCmptPresElt() {

	}
	
	public SrlEtatCmptPresElt(TabConsul consul) {

		try {
			if (consul != null)
				this.codPrestation = consul.getCodConsul();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.catPrestation = "Consultation";
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
			if (consul != null)
				this.isFacture = (consul.getRefFac() == null? "NON" : "OUI");
		} catch (Exception e) {
			this.isFacture = ERROR_VALUE;
		}
		try {
			if (consul != null)
				this.isPaye = (consul.getBooPaie() == BigDecimal.ONE ? "OUI" : "NON");
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
	
	public SrlEtatCmptPresElt(TabExam exam) {

		try {
			if (exam != null)
				this.codPrestation = exam.getCodExam();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.catPrestation = "Examen";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.libPrestation = exam.getLibExam();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(exam.getDatExam()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (exam != null)
					this.enuModPchg = EnuModPchg.getByValue(exam.getEnuModPchg()).getLibelle();
		} catch (Exception e) {
			this.enuModPchg = ERROR_VALUE;
		}
		try {
			if (exam != null)
				this.isFacture = (exam.getRefFac() == null? "NON" : "OUI");
		} catch (Exception e) {
			this.isFacture = ERROR_VALUE;
		}
		try {
			if (exam != null)
				this.isPaye = (exam.getBooPaie() == BigDecimal.ONE ? "OUI" : "NON");
		} catch (Exception e) {
			this.isPaye = ERROR_VALUE;
		}
		try {
			if (exam != null)
				this.vMtnPres = exam.getValMntTtc();
		} catch (Exception e) {
			this.vMtnPres = ERROR_NUM;
		}
		
		try {
			if (exam != null)
				this.libNom = exam.getTabPat().getLibNom() + " " + exam.getTabPat().getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		
	}
	
	public SrlEtatCmptPresElt(TabSoin soin) {

		try {
			if (soin != null)
				this.codPrestation = soin.getCodSoin();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.catPrestation = "Soin";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.libPrestation = soin.getLibSoin();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(soin.getDatSoin()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (soin != null)
					this.enuModPchg = EnuModPchg.getByValue(soin.getEnuModPchg()).getLibelle();
		} catch (Exception e) {
			this.enuModPchg = ERROR_VALUE;
		}
		try {
			if (soin != null)
				this.isFacture = (soin.getRefFac() == null? "NON" : "OUI");
		} catch (Exception e) {
			this.isFacture = ERROR_VALUE;
		}
		try {
			if (soin != null)
				this.isPaye = (soin.getBooPaie() == BigDecimal.ONE ? "OUI" : "NON");
		} catch (Exception e) {
			this.isPaye = ERROR_VALUE;
		}
		try {
			if (soin != null)
				this.vMtnPres = soin.getValMntTtc();
		} catch (Exception e) {
			this.vMtnPres = ERROR_NUM;
		}
		
		try {
			if (soin != null)
				this.libNom = soin.getTabPat().getLibNom() + " " + soin.getTabPat().getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		
	}

	public SrlEtatCmptPresElt(TabHospi hospi) {

		try {
			if (hospi != null)
				this.codPrestation = hospi.getCodHospi();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.catPrestation = "Hospitalisation";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.libPrestation = hospi.getLibMotif();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(hospi.getDatAdmi()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (hospi != null)
					this.enuModPchg = EnuModPchg.getByValue(hospi.getEnuModPchg()).getLibelle();
		} catch (Exception e) {
			this.enuModPchg = ERROR_VALUE;
		}
		try {
			if (hospi != null)
				this.isFacture = (hospi.getRefFac() == null? "NON" : "OUI");
		} catch (Exception e) {
			this.isFacture = ERROR_VALUE;
		}
		try {
			if (hospi != null)
				this.isPaye = (hospi.getBooPaie() == BigDecimal.ONE ? "OUI" : "NON");
		} catch (Exception e) {
			this.isPaye = ERROR_VALUE;
		}
		try {
			if (hospi != null)
				this.vMtnPres = hospi.getValMnt();
		} catch (Exception e) {
			this.vMtnPres = ERROR_NUM;
		}
		
		try {
			if (hospi != null)
				this.libNom = hospi.getTabPat().getLibNom() + " " + hospi.getTabPat().getLibPre();
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

	/**
	 * @return the vSousTotal
	 */
	public BigDecimal getvSousTotal() {
		return vSousTotal;
	}

	/**
	 * @param vSousTotal the vSousTotal to set
	 */
	public void setvSousTotal(BigDecimal vSousTotal) {
		this.vSousTotal = vSousTotal;
	}

	/**
	 * @return the vMntTotal
	 */
	public BigDecimal getvMntTotal() {
		return vMntTotal;
	}

	/**
	 * @param vMntTotal the vMntTotal to set
	 */
	public void setvMntTotal(BigDecimal vMntTotal) {
		this.vMntTotal = vMntTotal;
	}
	
	

}
