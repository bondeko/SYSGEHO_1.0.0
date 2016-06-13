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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlListFacConvElt> SrlFacConv;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlListFacConvElt> getSrlFacConv() {
		return SrlFacConv;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlFacConv(ArrayList<SrlListFacConvElt> SrlFacConv) {
		this.SrlFacConv = SrlFacConv;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlListFacConvElt p$elt) {

		if (SrlFacConv == null)
			SrlFacConv = new ArrayList<SrlListFacConvElt>();
			SrlFacConv.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlFacConv = new ArrayList<SrlListFacConvElt>();
	}

}


