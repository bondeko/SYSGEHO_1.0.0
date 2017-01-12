package com.bondeko.sysgeho.ui.phar.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.entity.TabCatProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;

public class SousCatProdVue extends SysGehoVue<TabSousCatProd>{
	
	private ArrayList<SelectItem> listeCatProd; 

	public SousCatProdVue(){
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
	public static TabSousCatProd getTabSousCatProd (){		
		
		TabSousCatProd v$SousCatProd = new TabSousCatProd();
		v$SousCatProd.setInfoUser(getInfoUser());
		v$SousCatProd.initData();
		return v$SousCatProd ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabSousCatProd getTabSousCatProdForSearch (){		
		TabSousCatProd v$Exam = getTabSousCatProd();
		return v$Exam ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SousCatProdVue.class);
	}
	
	
	public TabSousCatProd getNewEntity(){
		return getTabSousCatProd();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabSousCatProd getEntityForSearch() {	
		return getTabSousCatProdForSearch();
	}	
	
	public List<SelectItem> getlisteCatProd() {

		if(listeCatProd == null){
			
			listeCatProd = new ArrayList<SelectItem>();
			
			List<TabCatProd> v$CatProds = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabCatProd v$critere = new TabCatProd();	
			
			// Recherche des comptes en BD 			
			try {
				v$CatProds = PharSvcoDeleguate.getSvcoCatProd().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$CatProds = (v$CatProds != null)? v$CatProds : new ArrayList<TabCatProd>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabCatProd v$CatProd: v$CatProds){
				SelectItem v$item = new SelectItem(v$CatProd.getCodCatProd(),v$CatProd.getLibCatProd());
				listeCatProd.add(v$item);
			}
		}
		return listeCatProd;
	}
}
