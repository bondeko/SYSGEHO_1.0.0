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
		// Instance des propri�t�s g�n�riques h�rit�es  
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}
	
	/**
	 * Retourne une nouvelle Instance de l'entit�  
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
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
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
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
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
						
			// Crit�res de recherche des comptes de d�p�t	
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
			
			// Cr�ation de la liste des �lements pour le comboBox
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
	
	public List<SelectItem> getlisteFour() {

		if(listeFour == null){
			
			listeFour = new ArrayList<SelectItem>();
			
			List<TabFour> v$Four = null;
						
			// Crit�res de recherche des comptes de d�p�t	
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
			
			// Cr�ation de la liste des �lements pour le comboBox
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
						
			// Crit�res de recherche des comptes de d�p�t	
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
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabDepart v$depart: v$Depart){
				SelectItem v$item = new SelectItem(v$depart.getCodDepart(),v$depart.getLibDepart());
				listeDepart.add(v$item);
			}
		}
		return listeDepart;
	}
	
}
