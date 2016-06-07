/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlEtatCertMed implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCertMed() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatCertMedElt> SrlEtatCertificat;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatCertMedElt> getSrlEtatCertificat() {
		return SrlEtatCertificat;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatCertificat(ArrayList<SrlEtatCertMedElt> SrlEtatCertificat) {
		this.SrlEtatCertificat = SrlEtatCertificat;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatCertMedElt p$elt) {

		if (SrlEtatCertificat == null)
			SrlEtatCertificat = new ArrayList<SrlEtatCertMedElt>();
			SrlEtatCertificat.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatCertificat = new ArrayList<SrlEtatCertMedElt>();
	}

}
