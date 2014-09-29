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
public class SrlEtatCpteRenduConsul implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCpteRenduConsul() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatCpteRenduConsulElt> SrlEtatCpteRenduConsul;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatCpteRenduConsulElt> getSrlEtatCpteRenduConsul() {
		return SrlEtatCpteRenduConsul;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatCpteRenduConsul(ArrayList<SrlEtatCpteRenduConsulElt> SrlEtatCpteRenduConsul) {
		this.SrlEtatCpteRenduConsul = SrlEtatCpteRenduConsul;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatCpteRenduConsulElt p$elt) {

		if (SrlEtatCpteRenduConsul == null)
			SrlEtatCpteRenduConsul = new ArrayList<SrlEtatCpteRenduConsulElt>();
			SrlEtatCpteRenduConsul.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatCpteRenduConsul = new ArrayList<SrlEtatCpteRenduConsulElt>();
	}

}
