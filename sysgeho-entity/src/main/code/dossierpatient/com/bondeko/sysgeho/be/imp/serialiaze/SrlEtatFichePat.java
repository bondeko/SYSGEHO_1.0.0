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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatFichePatElt> SrlEtatFichePat;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatFichePatElt> getSrlEtatFichePat() {
		return SrlEtatFichePat;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatFichePat(ArrayList<SrlEtatFichePatElt> SrlEtatFichePat) {
		this.SrlEtatFichePat = SrlEtatFichePat;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatFichePatElt p$elt) {

		if (SrlEtatFichePat == null)
			SrlEtatFichePat = new ArrayList<SrlEtatFichePatElt>();
			SrlEtatFichePat.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatFichePat = new ArrayList<SrlEtatFichePatElt>();
	}

}
