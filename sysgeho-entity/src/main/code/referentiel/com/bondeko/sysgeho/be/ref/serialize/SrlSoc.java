/**
 * 
 */
package com.bondeko.sysgeho.be.ref.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author STEPH
 *
 */
public class SrlSoc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlSoc() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlSocElt> SrlSoc;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlSocElt> getSrlSoc() {
		return SrlSoc;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlSoc(ArrayList<SrlSocElt> SrlSoc) {
		this.SrlSoc = SrlSoc;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlSocElt p$elt) {

		if (SrlSoc == null)
			SrlSoc = new ArrayList<SrlSocElt>();
			SrlSoc.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlSoc = new ArrayList<SrlSocElt>();
	}

}


