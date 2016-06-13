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
public class SrlListFactConv implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlListFactConv() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlListFacConvElt> SrlFacConv;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlListFacConvElt> getSrlFacConv() {
		return SrlFacConv;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlFacConv(ArrayList<SrlListFacConvElt> SrlFacConv) {
		this.SrlFacConv = SrlFacConv;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlListFacConvElt p$elt) {

		if (SrlFacConv == null)
			SrlFacConv = new ArrayList<SrlListFacConvElt>();
			SrlFacConv.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlFacConv = new ArrayList<SrlListFacConvElt>();
	}

}


