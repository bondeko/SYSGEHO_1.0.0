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
public class SrlEtatCpteRenduExam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatCpteRenduExam() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatCpteRenduExamElt> srlEtatCpteRenduExam;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatCpteRenduExamElt> getSrlEtatCpteRenduExam() {
		return srlEtatCpteRenduExam;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatCpteRenduExam(ArrayList<SrlEtatCpteRenduExamElt> SrlEtatCpteRenduExam) {
		this.srlEtatCpteRenduExam = SrlEtatCpteRenduExam;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatCpteRenduExamElt p$elt) {

		if (srlEtatCpteRenduExam == null)
			srlEtatCpteRenduExam = new ArrayList<SrlEtatCpteRenduExamElt>();
			srlEtatCpteRenduExam.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		srlEtatCpteRenduExam = new ArrayList<SrlEtatCpteRenduExamElt>();
	}

}
