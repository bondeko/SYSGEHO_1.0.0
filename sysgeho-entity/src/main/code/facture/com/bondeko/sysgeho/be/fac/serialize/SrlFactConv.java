/**
 * 
 */
package com.bondeko.sysgeho.be.fac.serialize;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author STEPH
 *
 */
public class SrlFactConv implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlFactConv() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlFacConvElt> SrlFacConv;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlFacConvElt> getSrlFacConv() {
		return SrlFacConv;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlFacConv(ArrayList<SrlFacConvElt> SrlFacConv) {
		this.SrlFacConv = SrlFacConv;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlFacConvElt p$elt) {

		if (SrlFacConv == null)
			SrlFacConv = new ArrayList<SrlFacConvElt>();
			SrlFacConv.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlFacConv = new ArrayList<SrlFacConvElt>();
	}

}

