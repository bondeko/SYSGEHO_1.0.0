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
	 * Liste des �l�ments de l'�tat
	 */
	ArrayList<SrlEtatFichierExamElt> SrlEtatFichierExam;
	
	/**
	 * Accesseur en lecture de la liste des �l�ments de l'�tat
	 */
	public ArrayList<SrlEtatFichierExamElt> getSrlEtatFichierExam() {
		return SrlEtatFichierExam;
	}

	/**
	 * Accesseur en modification de la liste des �l�ments de l'�tat
	 */
	public void setSrlEtatFichierExam(ArrayList<SrlEtatFichierExamElt> SrlEtatFichierExam) {
		this.SrlEtatFichierExam = SrlEtatFichierExam;
	}
	
	/**
	 * Ajoute un �l�ment dans la liste des �l�ments de l'�tat
	 */
	public void addElement(SrlEtatFichierExamElt p$elt) {

		if (SrlEtatFichierExam == null)
			SrlEtatFichierExam = new ArrayList<SrlEtatFichierExamElt>();
			SrlEtatFichierExam.add(p$elt);
		}
	
	/**
	 * Initialise les donn�es de l'objet
	 */
	public void initData() {
		SrlEtatFichierExam = new ArrayList<SrlEtatFichierExamElt>();
	}

}
