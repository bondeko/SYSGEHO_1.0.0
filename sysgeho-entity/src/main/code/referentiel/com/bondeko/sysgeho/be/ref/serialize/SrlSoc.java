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
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlSocElt> SrlSoc;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlSocElt> getSrlSoc() {
		return SrlSoc;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlSoc(ArrayList<SrlSocElt> SrlSoc) {
		this.SrlSoc = SrlSoc;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlSocElt p$elt) {

		if (SrlSoc == null)
			SrlSoc = new ArrayList<SrlSocElt>();
			SrlSoc.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlSoc = new ArrayList<SrlSocElt>();
	}

}


