package com.bondeko.sysgeho.ui.phar.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.entity.TabCatProd;
import com.bondeko.sysgeho.be.phar.entity.TabDepart;
import com.bondeko.sysgeho.be.phar.entity.TabFour;
import com.bondeko.sysgeho.be.phar.entity.TabProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;

public class ProdVue extends SysGehoVue<TabProd>{
	
	private ArrayList<SelectItem> listeSousCatProd; 
	private ArrayList<SelectItem> listeCatProd; 
	private ArrayList<SelectItem> listeFour; 
	private ArrayList<SelectItem> listeDepart; 

	public ProdVue(){
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
	public static TabProd getTabProd (){		
		
		TabProd v$Prod = new TabProd();
		v$Prod.setInfoUser(getInfoUser());
		v$Prod.initData();
		return v$Prod ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabProd getTabProdForSearch (){		
		TabProd v$Prod = getTabProd();
		return v$Prod ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ProdVue.class);
	}
	
	
	public TabProd getNewEntity(){
		return getTabProd();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabProd getEntityForSearch() {	
		return getTabProdForSearch();
	}	
	
	public List<SelectItem> getlisteSousCatProd() {

		if(listeSousCatProd == null){
			
			listeSousCatProd = new ArrayList<SelectItem>();
			
			List<TabSousCatProd> v$SousCatProds = null;
						
			// Critères de recherche des comptes de dépôt	
			TabSousCatProd v$critere = new TabSousCatProd();	
			
			// Recherche des comptes en BD 			
			try {
				v$SousCatProds = PharSvcoDeleguate.getSvcoSousCatProd().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$SousCatProds = (v$SousCatProds != null)? v$SousCatProds : new ArrayList<TabSousCatProd>();
			
			// Création de la liste des élements pour le comboBox
			for(TabSousCatProd v$CatSousProd: v$SousCatProds){
				SelectItem v$item = new SelectItem(v$CatSousProd.getCodSousCatProd(),v$CatSousProd.getLibSousCatProd());
				listeSousCatProd.add(v$item);
			}
		}
		return listeSousCatProd;
	}
	
	public List<SelectItem> getlisteCatProd() {

		if(listeCatProd == null){
			
			listeCatProd = new ArrayList<SelectItem>();
			
			List<TabCatProd> v$CatProds = null;
						
			// Critères de recherche des comptes de dépôt	
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
			
			// Création de la liste des élements pour le comboBox
			for(TabCatProd v$CatProd: v$CatProds){
				SelectItem v$item = new SelectItem(v$CatProd.getCodCatProd(),v$CatProd.getLibCatProd());
				listeCatProd.add(v$item);
			}
		}
		return listeCatProd;
	}
	
	public List<SelectItem> getlisteFour() {

		if(listeFour == null){
			
			listeFour = new ArrayList<SelectItem>();
			
			List<TabFour> v$Four = null;
						
			// Critères de recherche des comptes de dépôt	
			TabFour v$critere = new TabFour();	
			
			// Recherche des comptes en BD 			
			try {
				v$Four = PharSvcoDeleguate.getSvcoFour().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Four = (v$Four != null)? v$Four : new ArrayList<TabFour>();
			
			// Création de la liste des élements pour le comboBox
			for(TabFour v$four: v$Four){
				SelectItem v$item = new SelectItem(v$four.getCodFour(),v$four.getLibFour());
				listeFour.add(v$item);
			}
		}
		return listeFour;
	}
	
	public List<SelectItem> getlisteDepart() {

		if(listeDepart == null){
			
			listeDepart = new ArrayList<SelectItem>();
			
			List<TabDepart> v$Depart = null;
						
			// Critères de recherche des comptes de dépôt	
			TabDepart v$critere = new TabDepart();	
			
			// Recherche des comptes en BD 			
			try {
				v$Depart = PharSvcoDeleguate.getSvcoDepart().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Depart = (v$Depart != null)? v$Depart : new ArrayList<TabDepart>();
			
			// Création de la liste des élements pour le comboBox
			for(TabDepart v$depart: v$Depart){
				SelectItem v$item = new SelectItem(v$depart.getCodDepart(),v$depart.getLibDepart());
				listeDepart.add(v$item);
			}
		}
		return listeDepart;
	}
	
}
