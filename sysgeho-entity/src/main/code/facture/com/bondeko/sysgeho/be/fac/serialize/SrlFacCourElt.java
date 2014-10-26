/**
 * 
 */
package com.bondeko.sysgeho.be.fac.serialize;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.sidere.convert.ConvertNumberToWords;

/**
 * @author Deco
 *
 */
public class SrlFacCourElt {

	private String nomPatient;
	private String refFac;
	private String objFac;
	private String datFac;
	private String codPres;
	private String libPres;
	private String codPresDtl;
	private String datPresDtl;
	private BigDecimal mntPresDtl;
	private BigDecimal mntTotal;
	private String mntTotalLettre;

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}
	
	public String getLibPres() {
		return libPres;
	}

	public void setLibPres(String libPres) {
		this.libPres = libPres;
	}

	public String getRefFac() {
		return refFac;
	}

	public void setRefFac(String refFac) {
		this.refFac = refFac;
	}

	public String getObjFac() {
		return objFac;
	}

	public void setObjFac(String objFac) {
		this.objFac = objFac;
	}

	public String getDatFac() {
		return datFac;
	}

	public void setDatFac(String datFac) {
		this.datFac = datFac;
	}

	public String getCodPres() {
		return codPres;
	}

	public void setCodPres(String codPres) {
		this.codPres = codPres;
	}

	public String getCodPresDtl() {
		return codPresDtl;
	}

	public void setCodPresDtl(String codPresDtl) {
		this.codPresDtl = codPresDtl;
	}

	public String getDatPresDtl() {
		return datPresDtl;
	}

	public void setDatPresDtl(String datPresDtl) {
		this.datPresDtl = datPresDtl;
	}

	public BigDecimal getMntPresDtl() {
		return mntPresDtl;
	}

	public void setMntPresDtl(BigDecimal mntPresDtl) {
		this.mntPresDtl = mntPresDtl;
	}

	public BigDecimal getMntTotal() {
		return mntTotal;
	}

	public void setMntTotal(BigDecimal mntTotal) {
		this.mntTotal = mntTotal;
	}

	public String getMntTotalLettre() {
		return mntTotalLettre;
	}

	public void setMntTotalLettre(String mntTotalLettre) {
		this.mntTotalLettre = mntTotalLettre;
	}

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	
	/**
	 * Valeur à l'erreur
	 */
	private static BigDecimal ERROR_BIG_DEC = null;

	public SrlFacCourElt() {

	}

	public SrlFacCourElt(TabPat pat, TabFacCour facCour, String codPres, String libPres,
			String codPresDtl, String datPresDtl, BigDecimal mntPresDtl){
		 
		try {
			this.nomPatient = pat.getLibNom()+" "+pat.getLibPre();
		}catch (Exception e) {
			this.nomPatient=ERROR_VALUE ;
		}

		try {
			this.refFac = facCour.getRefFacCour();
		}catch (Exception e) {
			this.refFac=ERROR_VALUE ;
		}

		try {
			this.objFac = facCour.getLibObj();
		}catch (Exception e) {
			this.objFac=ERROR_VALUE ;
		}

		try {
			this.datFac = DateTools.formatDate("dd/MM/yyyy", DateTools
					.getDateValue(facCour.getDatFac()));
		} catch (Exception e) {
			this.datFac = ERROR_VALUE;
		}

		try {
			this.codPres = codPres;
		}catch (Exception e) {
			this.codPres=ERROR_VALUE ;
		}
		
		try {
			this.libPres = libPres;
		}catch (Exception e) {
			this.libPres=ERROR_VALUE ;
		}
		
		try {
			this.codPresDtl = codPresDtl;
		}catch (Exception e) {
			this.codPresDtl=ERROR_VALUE ;
		}

		try {
			this.datPresDtl = DateTools.formatDate("dd/MM/yyyy", DateTools
					.getDateValue(datPresDtl));
		} catch (Exception e) {
			this.datPresDtl = ERROR_VALUE;
		}

		try {
			this.mntPresDtl = mntPresDtl;
		}catch (Exception e) {
			this.mntPresDtl=ERROR_BIG_DEC ;
		}
		
		try {
			this.mntTotal = facCour.getValMntTotal();
		}catch (Exception e) {
			this.mntPresDtl=ERROR_BIG_DEC ;
		}
		
		try {
			this.mntTotalLettre = ConvertNumberToWords.convert(facCour.getValMntTotal().longValue());
		}catch (Exception e) {
			this.mntTotalLettre=ERROR_VALUE ;
		}
		
	}



}
