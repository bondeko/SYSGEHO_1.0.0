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
public class SrlEtatCmptPres implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCmptPres() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatCmptPresElt> SrlEtatCmptPres;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatCmptPresElt> getSrlEtatCmptPres() {
		return SrlEtatCmptPres;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatCmptPres(ArrayList<SrlEtatCmptPresElt> SrlEtatCmptPres) {
		this.SrlEtatCmptPres = SrlEtatCmptPres;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatCmptPresElt p$elt) {

		if (SrlEtatCmptPres == null)
			SrlEtatCmptPres = new ArrayList<SrlEtatCmptPresElt>();
			SrlEtatCmptPres.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatCmptPres = new ArrayList<SrlEtatCmptPresElt>();
	}

}
