package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class ExamVue extends SysGehoVue<TabExam>{
	
	private ArrayList<SelectItem> listeTypExam; 

	public ExamVue(){
		super();
		// Instance des propriétés génériques héritées  
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}
	
	/**
	 * Retourne une nouvelle Instance de l'entité  
	 * 
	 * @return
	 */	
	public static TabExam getTabExam (){		
		
		TabExam v$Exam = new TabExam();
		v$Exam.setInfoUser(getInfoUser());
		v$Exam.initData();
		return v$Exam ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabExam getTabExamForSearch (){		
		TabExam v$Exam = getTabExam();
		return v$Exam ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ExamVue.class);
	}
	
	
	public TabExam getNewEntity(){
		return getTabExam();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabExam getEntityForSearch() {	
		return getTabExamForSearch();
	}	
	
	public List<SelectItem> getListeTypExam() {

		if(listeTypExam == null){
			
			listeTypExam = new ArrayList<SelectItem>();
			
			List<TabTypExam> v$TypExams = null;
						
			// Critères de recherche des comptes de dépôt	
			TabTypExam v$critere = new TabTypExam();	
			
			// Recherche des comptes en BD 			
			try {
				v$TypExams = RefSvcoDeleguate.getSvcoTypExam().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$TypExams = (v$TypExams != null)? v$TypExams : new ArrayList<TabTypExam>();
			
			// Création de la liste des élements pour le comboBox
			for(TabTypExam v$TypExam: v$TypExams){
				SelectItem v$item = new SelectItem(v$TypExam.getCodTypExam(),v$TypExam.getLibTypExam());
				listeTypExam.add(v$item);
			}
		}
		return listeTypExam;
	}
	
}
