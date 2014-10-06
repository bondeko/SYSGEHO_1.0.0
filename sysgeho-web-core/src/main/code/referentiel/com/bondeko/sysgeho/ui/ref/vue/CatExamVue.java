package com.bondeko.sysgeho.ui.ref.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabCatExam;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class CatExamVue extends SysGehoVue<TabCatExam>{
	
	private List<SelectItem> listeSpec;
	
	public CatExamVue(){
		super();
		// Instance des propri�t�s g�n�riques h�rit�es  
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}
	
	/**
	 * Retourne une nouvelle Instance de l'entit�  
	 * 
	 * @return
	 */	
	public static TabCatExam getTabCatExam (){		
		
		TabCatExam v$CatExam = new TabCatExam();
		v$CatExam.setInfoUser(getInfoUser());
		v$CatExam.initData();
		return v$CatExam ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabCatExam getTabCatExamForSearch (){		
		TabCatExam v$CatExam = getTabCatExam();
		return v$CatExam ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(CatExamVue.class);
	}
	
	
	public TabCatExam getNewEntity(){
		return getTabCatExam();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabCatExam getEntityForSearch() {	
		return getTabCatExamForSearch();
	}	
	
	public List<SelectItem> getListeSpec() {
		listeSpec = null;
		if(listeSpec == null){
			
			listeSpec = new ArrayList<SelectItem>();
			
			List<TabSpec> v$Specs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabSpec v$critere = new TabSpec();	
			
			// Recherche des comptes en BD 			
			try {
				v$Specs = RefSvcoDeleguate.getSvcoSpec().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Specs = (v$Specs != null)? v$Specs : new ArrayList<TabSpec>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabSpec v$Spec: v$Specs){
				SelectItem v$item = new SelectItem(v$Spec.getCodSpec(),v$Spec.getLibSpec());
				listeSpec.add(v$item);
			}
		}
		return listeSpec;
	}
	
}
