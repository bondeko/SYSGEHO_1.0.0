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
public class SrlEtatFichierExam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur par defaut
	 */
	public SrlEtatFichierExam() {
		
	}
	/**
	 * Liste des éléments de l'état
	 */
	ArrayList<SrlEtatFichierExamElt> SrlEtatFichierExam;
	
	/**
	 * Accesseur en lecture de la liste des éléments de l'état
	 */
	public ArrayList<SrlEtatFichierExamElt> getSrlEtatFichierExam() {
		return SrlEtatFichierExam;
	}

	/**
	 * Accesseur en modification de la liste des éléments de l'état
	 */
	public void setSrlEtatFichierExam(ArrayList<SrlEtatFichierExamElt> SrlEtatFichierExam) {
		this.SrlEtatFichierExam = SrlEtatFichierExam;
	}
	
	/**
	 * Ajoute un élément dans la liste des éléments de l'état
	 */
	public void addElement(SrlEtatFichierExamElt p$elt) {

		if (SrlEtatFichierExam == null)
			SrlEtatFichierExam = new ArrayList<SrlEtatFichierExamElt>();
			SrlEtatFichierExam.add(p$elt);
		}
	
	/**
	 * Initialise les données de l'objet
	 */
	public void initData() {
		SrlEtatFichierExam = new ArrayList<SrlEtatFichierExamElt>();
	}

}
