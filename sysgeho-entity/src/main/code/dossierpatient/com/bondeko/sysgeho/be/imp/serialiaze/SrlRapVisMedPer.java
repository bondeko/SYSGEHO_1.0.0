/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author STEPH
 *
 */
public class SrlRapVisMedPer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlRapVisMedPer() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlRapVisMedPerElt> SrlRapVisMedPer;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlRapVisMedPerElt> getSrlRapVisMedPer() {
		return SrlRapVisMedPer;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlRapVisMedPer(ArrayList<SrlRapVisMedPerElt> SrlRapVisMedPer) {
		this.SrlRapVisMedPer = SrlRapVisMedPer;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlRapVisMedPerElt p$elt) {

		if (SrlRapVisMedPer == null)
			SrlRapVisMedPer = new ArrayList<SrlRapVisMedPerElt>();
			SrlRapVisMedPer.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlRapVisMedPer = new ArrayList<SrlRapVisMedPerElt>();
	}

}

