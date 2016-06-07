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
public class SrlEtatCmptConsul implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCmptConsul() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatCmptConsulElt> SrlEtatCmptConsul;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatCmptConsulElt> getSrlEtatCmptConsul() {
		return SrlEtatCmptConsul;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatCmptConsul(ArrayList<SrlEtatCmptConsulElt> SrlEtatCmptConsul) {
		this.SrlEtatCmptConsul = SrlEtatCmptConsul;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatCmptConsulElt p$elt) {

		if (SrlEtatCmptConsul == null)
			SrlEtatCmptConsul = new ArrayList<SrlEtatCmptConsulElt>();
			SrlEtatCmptConsul.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatCmptConsul = new ArrayList<SrlEtatCmptConsulElt>();
	}

}
