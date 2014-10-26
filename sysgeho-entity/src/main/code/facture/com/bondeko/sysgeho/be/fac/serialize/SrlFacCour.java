/**
 * 
 */
package com.bondeko.sysgeho.be.fac.serialize;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlFacCour implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlFacCour() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlFacCourElt> SrlFacCour;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlFacCourElt> getSrlFacCour() {
		return SrlFacCour;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlFacCour(ArrayList<SrlFacCourElt> SrlFacCour) {
		this.SrlFacCour = SrlFacCour;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlFacCourElt p$elt) {

		if (SrlFacCour == null)
			SrlFacCour = new ArrayList<SrlFacCourElt>();
			SrlFacCour.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlFacCour = new ArrayList<SrlFacCourElt>();
	}

}
