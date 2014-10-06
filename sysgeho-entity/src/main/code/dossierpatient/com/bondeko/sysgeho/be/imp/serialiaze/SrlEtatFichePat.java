/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlEtatFichePat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatFichePat() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatFichePatElt> SrlEtatFichePat;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatFichePatElt> getSrlEtatFichePat() {
		return SrlEtatFichePat;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatFichePat(ArrayList<SrlEtatFichePatElt> SrlEtatFichePat) {
		this.SrlEtatFichePat = SrlEtatFichePat;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatFichePatElt p$elt) {

		if (SrlEtatFichePat == null)
			SrlEtatFichePat = new ArrayList<SrlEtatFichePatElt>();
			SrlEtatFichePat.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatFichePat = new ArrayList<SrlEtatFichePatElt>();
	}

}
