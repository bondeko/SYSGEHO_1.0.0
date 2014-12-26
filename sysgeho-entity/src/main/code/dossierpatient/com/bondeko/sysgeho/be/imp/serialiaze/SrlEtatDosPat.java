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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatDosPatElt> SrlEtatDosPat;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatDosPatElt> getSrlEtatDosPat() {
		return SrlEtatDosPat;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatDosPat(ArrayList<SrlEtatDosPatElt> SrlEtatDosPat) {
		this.SrlEtatDosPat = SrlEtatDosPat;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatDosPatElt p$elt) {

		if (SrlEtatDosPat == null)
			SrlEtatDosPat = new ArrayList<SrlEtatDosPatElt>();
			SrlEtatDosPat.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatDosPat = new ArrayList<SrlEtatDosPatElt>();
	}

}
