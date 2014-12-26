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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatCmptPresElt> SrlEtatCmptPres;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatCmptPresElt> getSrlEtatCmptPres() {
		return SrlEtatCmptPres;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatCmptPres(ArrayList<SrlEtatCmptPresElt> SrlEtatCmptPres) {
		this.SrlEtatCmptPres = SrlEtatCmptPres;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatCmptPresElt p$elt) {

		if (SrlEtatCmptPres == null)
			SrlEtatCmptPres = new ArrayList<SrlEtatCmptPresElt>();
			SrlEtatCmptPres.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatCmptPres = new ArrayList<SrlEtatCmptPresElt>();
	}

}
