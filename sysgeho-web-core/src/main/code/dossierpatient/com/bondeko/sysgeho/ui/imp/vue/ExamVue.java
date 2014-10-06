package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class ExamVue extends SysGehoVue<TabExam>{
	
	private ArrayList<SelectItem> listeTypExam; 
	
	private  Map<String, Object> listeModPchg;
	
	private boolean visEmb;
	private boolean visPerio;

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
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}
	
	public void updateCodVis(ActionEvent evt){
		if(getEntiteCourante() != null && getEntiteCourante().getTypVisMedSrc() !=null ){
			if(getEntiteCourante().getTypVisMedSrc().equals("VM_EMB")){
				getEntiteCourante().setTabVisMedPerio(new TabVisMedPerio());
//				getEntiteCourante().getTabVisMedPerio().setCodVisMedPerio(null);
//				getEntiteCourante().getTabVisMedPerio().setLibMotif(null);
			}else if(getEntiteCourante().getTypVisMedSrc().equals("VM_PERIO")){
				getEntiteCourante().setTabVisMedEmb(new TabVisMedEmb());
//				getEntiteCourante().getTabVisMedEmb().setCodVisMedEmb(null);
//				getEntiteCourante().getTabVisMedEmb().setLibMotif(null);
			}
		}
	}
	
	public boolean isVisEmb() {
		boolean isEmb = false;
		TabExam exam= getEntiteCourante();
		if(exam != null && exam.getTypVisMedSrc() !=null ){
			if(exam.getTypVisMedSrc().equals("VM_EMB")){
				isEmb = true;
			}
		}
		return isEmb;
	}

	public void setVisEmb(boolean visEmb) {
		this.visEmb = visEmb;
	}
	
	public boolean isVisPerio() {
		boolean isPerio = false;
		TabExam eaxm= getEntiteCourante();
		if(eaxm != null && eaxm.getTypVisMedSrc() !=null ){
			if(eaxm.getTypVisMedSrc().equals("VM_PERIO")){
				isPerio = true;
			}
		}
		return isPerio;
	}

	public void setVisPerio(boolean visPerio) {
		this.visPerio = visPerio;
	}
	
}
