package com.bondeko.sysgeho.ui.ref.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabCatExam;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.be.ref.entity.TabLit;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class LitVue extends SysGehoVue<TabLit>{
	
	private List<SelectItem> listeChr;
	
	public LitVue(){
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
	public static TabLit getTabLit (){		
		
		TabLit v$Lit = new TabLit();
		v$Lit.setInfoUser(getInfoUser());
		v$Lit.initData();
		return v$Lit ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabLit getTabLitForSearch (){		
		TabLit v$Lit = getTabLit();
		return v$Lit ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(LitVue.class);
	}
	
	
	public TabLit getNewEntity(){
		return getTabLit();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabLit getEntityForSearch() {	
		return getTabLitForSearch();
	}	
	
	public List<SelectItem> getListeChr() {

		if(listeChr == null){
			
			listeChr = new ArrayList<SelectItem>();
			
			List<TabChrHospi> v$Chrs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabChrHospi v$critere = new TabChrHospi();	
			
			// Recherche des comptes en BD 			
			try {
				v$Chrs = RefSvcoDeleguate.getSvcoChrHospi().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Chrs = (v$Chrs != null)? v$Chrs : new ArrayList<TabChrHospi>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabChrHospi v$chr: v$Chrs){
				SelectItem v$item = new SelectItem(v$chr.getNumChrHospi(),v$chr.getNumChrHospi()+" - "+v$chr.getLibChrHospi());
				listeChr.add(v$item);
			}
		}
		return listeChr;
	}
}
