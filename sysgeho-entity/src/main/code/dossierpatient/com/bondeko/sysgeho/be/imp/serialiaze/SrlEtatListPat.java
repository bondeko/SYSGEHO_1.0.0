/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Deco
 *
 */
public class SrlEtatListPat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatListPat() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatListPatElt> SrlEtatListPat;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatListPatElt> getSrlEtatListPat() {
		return SrlEtatListPat;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatListPat(ArrayList<SrlEtatListPatElt> SrlEtatListPat) {
		this.SrlEtatListPat = SrlEtatListPat;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatListPatElt p$elt) {

		if (SrlEtatListPat == null)
			SrlEtatListPat = new ArrayList<SrlEtatListPatElt>();
			SrlEtatListPat.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatListPat = new ArrayList<SrlEtatListPatElt>();
	}

}
