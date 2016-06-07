/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlEtatCertMed implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCertMed() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatCertMedElt> SrlEtatCertificat;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatCertMedElt> getSrlEtatCertificat() {
		return SrlEtatCertificat;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatCertificat(ArrayList<SrlEtatCertMedElt> SrlEtatCertificat) {
		this.SrlEtatCertificat = SrlEtatCertificat;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatCertMedElt p$elt) {

		if (SrlEtatCertificat == null)
			SrlEtatCertificat = new ArrayList<SrlEtatCertMedElt>();
			SrlEtatCertificat.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatCertificat = new ArrayList<SrlEtatCertMedElt>();
	}

}
