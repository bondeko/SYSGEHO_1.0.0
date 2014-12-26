/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author DECO
 *
 */
public class SrlEtatDosPat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatDosPat() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatDosPatElt> SrlEtatDosPat;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatDosPatElt> getSrlEtatDosPat() {
		return SrlEtatDosPat;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatDosPat(ArrayList<SrlEtatDosPatElt> SrlEtatDosPat) {
		this.SrlEtatDosPat = SrlEtatDosPat;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatDosPatElt p$elt) {

		if (SrlEtatDosPat == null)
			SrlEtatDosPat = new ArrayList<SrlEtatDosPatElt>();
			SrlEtatDosPat.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatDosPat = new ArrayList<SrlEtatDosPatElt>();
	}

}
