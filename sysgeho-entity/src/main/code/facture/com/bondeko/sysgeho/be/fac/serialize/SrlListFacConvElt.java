/**
 * 
 */
package com.bondeko.sysgeho.be.fac.serialize;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;

/**
 * @author STEPH
 *
 */
public class SrlListFacConvElt {
	
	private String codRef;
	private String datFact;
	private String libMois;
	private BigDecimal valFact;
	private String libSoc;
	private String booPaie;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	
	/**
	 * Valeur à l'erreur
	 */
	private static BigDecimal ERROR_BIG_DEC = null;

	public SrlListFacConvElt() {

	}

	public SrlListFacConvElt(TabFacConv facConv){
		 
		try {
			this.codRef = facConv.getRefFacConv();
		}catch (Exception e) {
			this.codRef=ERROR_VALUE ;
		}

		try {
			if (facConv.getBEstPaie()){
				this.booPaie = "OUI";
			} else
			this.booPaie = "NON";
		}catch (Exception e) {
			this.booPaie=ERROR_VALUE ;
		}

		try {
			this.datFact = DateTools.formatDate("dd/MM/yyyy", DateTools
					.getDateValue(facConv.getDatFac()));
		} catch (Exception e) {
			this.datFact = ERROR_VALUE;
		}

		try {
			this.libMois = facConv.getLEnuMoisFac() +" "+ facConv.getCodExeFis();
		}catch (Exception e) {
			this.libMois=ERROR_VALUE ;
		}


		try {
			this.valFact = facConv.getValMntTotal();
		}catch (Exception e) {
			this.valFact=ERROR_BIG_DEC ;
		}
		
		try {
			this.libSoc = facConv.getTabSoc().getLibSoc();
		}catch (Exception e) {
			this.libSoc=ERROR_VALUE ;
		}
		
		
	}

	public String getcodRef() {
		return codRef;
	}

	public void setcodRef(String codRef) {
		this.codRef = codRef;
	}

	public String getDatFact() {
		return datFact;
	}

	public void setDatFact(String datFact) {
		this.datFact = datFact;
	}

	public String getbooPaie() {
		return booPaie;
	}

	public void setbooPaie(String booPaie) {
		this.booPaie = booPaie;
	}

	public String getLibMois() {
		return libMois;
	}

	public void setLibMois(String libMois) {
		this.libMois = libMois;
	}

	public BigDecimal getvalFact() {
		return valFact;
	}

	public void setvalFact(BigDecimal valFact) {
		this.valFact = valFact;
	}

	public String getLibSoc() {
		return libSoc;
	}

	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}
	

}
