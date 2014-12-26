package com.bondeko.sysgeho.be.imp.serialiaze;

import java.io.Serializable;
import java.util.ArrayList;

public class SrlRapVisMedEmb implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlRapVisMedEmb() {
		
	}
	/**
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlRapVisMedEmbElt> SrlRapVisMedEmb;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlRapVisMedEmbElt> getSrlRapVisMedEmb() {
		return SrlRapVisMedEmb;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlRapVisMedEmb(ArrayList<SrlRapVisMedEmbElt> SrlRapVisMedEmb) {
		this.SrlRapVisMedEmb = SrlRapVisMedEmb;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlRapVisMedEmbElt p$elt) {

		if (SrlRapVisMedEmb == null)
			SrlRapVisMedEmb = new ArrayList<SrlRapVisMedEmbElt>();
			SrlRapVisMedEmb.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlRapVisMedEmb = new ArrayList<SrlRapVisMedEmbElt>();
	}

}

