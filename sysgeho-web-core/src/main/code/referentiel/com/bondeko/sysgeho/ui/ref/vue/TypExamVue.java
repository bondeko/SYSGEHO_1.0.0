package com.bondeko.sysgeho.ui.ref.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabCatExam;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class TypExamVue extends SysGehoVue<TabTypExam>{
	
	
	private List<SelectItem> listeCatExam;
	//mapSitr
	private Map<String, TabCatExam> mapCatExam = new HashMap<String, TabCatExam>();
	
	public TypExamVue(){
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
	public static TabTypExam getTabTypExam (){		
		
		TabTypExam v$TypExam = new TabTypExam();
		v$TypExam.setInfoUser(getInfoUser());
		v$TypExam.initData();
		return v$TypExam ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabTypExam getTabTypExamForSearch (){		
		TabTypExam v$TypExam = getTabTypExam();
		return v$TypExam ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(TypExamVue.class);
	}
	
	
	public TabTypExam getNewEntity(){
		return getTabTypExam();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabTypExam getEntityForSearch() {	
		return getTabTypExamForSearch();
	}	
	
	public List<SelectItem> getListeCatExam() {

		if(listeCatExam == null){
			
			listeCatExam = new ArrayList<SelectItem>();
			
			List<TabCatExam> v$CatExams = null;
						
			// Critères de recherche des comptes de dépôt	
			TabCatExam v$critere = new TabCatExam();	
			
			// Recherche des comptes en BD 			
			try {
				v$CatExams = RefSvcoDeleguate.getSvcoCatExam().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$CatExams = (v$CatExams != null)? v$CatExams : new ArrayList<TabCatExam>();
			
			// Création de la liste des élements pour le comboBox
			for(TabCatExam v$Cat: v$CatExams){
				SelectItem v$item = new SelectItem(v$Cat.getCodCatExam(),v$Cat.getCodCatExam());
				listeCatExam.add(v$item);
				mapCatExam.put(v$Cat.getCodCatExam(), v$Cat);
			}
		}
		return listeCatExam;
	}
	
	public void updateLibCatExam(ActionEvent evt){
		getEntiteCourante().setLibCatExam(mapCatExam.get(getEntiteCourante().getCodCatExam()).getLibCatExam());
		getEntiteCourante().setLibSpec(mapCatExam.get(getEntiteCourante().getCodCatExam()).getLibSpec());
	}

}
