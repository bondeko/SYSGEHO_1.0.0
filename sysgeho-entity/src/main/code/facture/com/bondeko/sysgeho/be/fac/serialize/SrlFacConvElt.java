/**
 * 
 */
package com.bondeko.sysgeho.be.fac.serialize;

import java.math.BigDecimal;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.sidere.convert.ConvertNumberToWords;

/**
 * @author STEPH
 *
 */
public class SrlFacConvElt {
	private String codFact;
	private String datFact;
	private String libRefFact;
	private String libObjet;
	private String libMois;
	private BigDecimal valEffectif;
	private BigDecimal valPrixUnitaire;
	private BigDecimal valFixeMens;
	private BigDecimal valTotal;
	private String libSoc;
	private String libMntLettre;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";
	
	/**
	 * Valeur à l'erreur
	 */
	private static BigDecimal ERROR_BIG_DEC = null;

	public SrlFacConvElt() {

	}

	public SrlFacConvElt(TabFacConv facConv){
		 
		try {
			this.codFact = facConv.getRefFacConv();
		}catch (Exception e) {
			this.codFact=ERROR_VALUE ;
		}

		try {
			this.libRefFact = facConv.getRefFacConv();
		}catch (Exception e) {
			this.libRefFact=ERROR_VALUE ;
		}

		try {
			this.libObjet = facConv.getLibObj();
		}catch (Exception e) {
			this.libObjet=ERROR_VALUE ;
		}

		try {
			this.datFact = DateTools.formatDate("dd/MM/yyyy", DateTools
					.getDateValue(facConv.getDatFac()));
		} catch (Exception e) {
			this.datFact = ERROR_VALUE;
		}

		try {
			this.libMois = facConv.getLEnuMoisFac();
		}catch (Exception e) {
			this.libMois=ERROR_VALUE ;
		}
		
		try {
			this.valEffectif = facConv.getValEff();
		}catch (Exception e) {
			this.valEffectif=ERROR_BIG_DEC ;
		}
		
		try {
			this.valPrixUnitaire = facConv.getValPrixUni();
		}catch (Exception e) {
			this.valPrixUnitaire=ERROR_BIG_DEC ;
		}

		try {
			this.valFixeMens = facConv.getValTrfFixMsuel();
		}catch (Exception e) {
			this.valFixeMens=ERROR_BIG_DEC ;
		}

		try {
			this.valTotal = facConv.getValMntTotal();
		}catch (Exception e) {
			this.valTotal=ERROR_BIG_DEC ;
		}
		
		try {
			this.libSoc = facConv.getTabSoc().getLibSoc();
		}catch (Exception e) {
			this.libSoc=ERROR_VALUE ;
		}
		
		try {
			this.libMntLettre = ConvertNumberToWords.convert(facConv.getValMntTotal().longValue());
		}catch (Exception e) {
			this.libMntLettre=ERROR_VALUE ;
		}
		
	}

	public String getCodFact() {
		return codFact;
	}

	public void setCodFact(String codFact) {
		this.codFact = codFact;
	}

	public String getDatFact() {
		return datFact;
	}

	public void setDatFact(String datFact) {
		this.datFact = datFact;
	}

	public String getLibRefFact() {
		return libRefFact;
	}

	public void setLibRefFact(String libRefFact) {
		this.libRefFact = libRefFact;
	}

	public String getLibObjet() {
		return libObjet;
	}

	public void setLibObjet(String libObjet) {
		this.libObjet = libObjet;
	}

	public String getLibMois() {
		return libMois;
	}

	public void setLibMois(String libMois) {
		this.libMois = libMois;
	}

	public BigDecimal getValEffectif() {
		return valEffectif;
	}

	public void setValEffectif(BigDecimal valEffectif) {
		this.valEffectif = valEffectif;
	}

	public BigDecimal getValPrixUnitaire() {
		return valPrixUnitaire;
	}

	public void setValPrixUnitaire(BigDecimal valPrixUnitaire) {
		this.valPrixUnitaire = valPrixUnitaire;
	}

	public BigDecimal getValFixeMens() {
		return valFixeMens;
	}

	public void setValFixeMens(BigDecimal valFixeMens) {
		this.valFixeMens = valFixeMens;
	}

	public BigDecimal getValTotal() {
		return valTotal;
	}

	public void setValTotal(BigDecimal valTotal) {
		this.valTotal = valTotal;
	}

	public String getLibSoc() {
		return libSoc;
	}

	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}

	public String getLibMntLettre() {
		return libMntLettre;
	}

	public void setLibMntLettre(String libMntLettre) {
		this.libMntLettre = libMntLettre;
	}

	

}
