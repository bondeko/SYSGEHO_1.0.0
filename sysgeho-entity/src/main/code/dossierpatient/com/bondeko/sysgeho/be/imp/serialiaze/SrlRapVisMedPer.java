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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlRapVisMedPerElt> SrlRapVisMedPer;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlRapVisMedPerElt> getSrlRapVisMedPer() {
		return SrlRapVisMedPer;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlRapVisMedPer(ArrayList<SrlRapVisMedPerElt> SrlRapVisMedPer) {
		this.SrlRapVisMedPer = SrlRapVisMedPer;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlRapVisMedPerElt p$elt) {

		if (SrlRapVisMedPer == null)
			SrlRapVisMedPer = new ArrayList<SrlRapVisMedPerElt>();
			SrlRapVisMedPer.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlRapVisMedPer = new ArrayList<SrlRapVisMedPerElt>();
	}

}

