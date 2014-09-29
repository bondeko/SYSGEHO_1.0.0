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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatListPatElt> SrlEtatListPat;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatListPatElt> getSrlEtatListPat() {
		return SrlEtatListPat;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatListPat(ArrayList<SrlEtatListPatElt> SrlEtatListPat) {
		this.SrlEtatListPat = SrlEtatListPat;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatListPatElt p$elt) {

		if (SrlEtatListPat == null)
			SrlEtatListPat = new ArrayList<SrlEtatListPatElt>();
			SrlEtatListPat.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatListPat = new ArrayList<SrlEtatListPatElt>();
	}

}
