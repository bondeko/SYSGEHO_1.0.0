package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class HospiVue extends SysGehoVue<TabHospi>{
	
	private List<SelectItem> listeMed;
	
	private List<SelectItem> listeSvc;
	
	public HospiVue(){
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
	public static TabHospi getTabHospi (){		
		
		TabHospi v$Hospi = new TabHospi();
		v$Hospi.setInfoUser(getInfoUser());
		v$Hospi.initData();
		return v$Hospi ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabHospi getTabHospiForSearch (){		
		TabHospi v$Hospi = getTabHospi();
		return v$Hospi ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(HospiVue.class);
	}
	
	
	public TabHospi getNewEntity(){
		return getTabHospi();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabHospi getEntityForSearch() {	
		return getTabHospiForSearch();
	}	
	
	public List<SelectItem> getListeMed() {

		if(listeMed == null){
			
			listeMed = new ArrayList<SelectItem>();
			
			List<TabUsr> v$Usrs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabUsr v$critere = new TabUsr();	
			
			// Recherche des comptes en BD 			
			try {
				v$Usrs = AdminSvcoDeleguate.getSvcoUsr().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Usrs = (v$Usrs != null)? v$Usrs : new ArrayList<TabUsr>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabUsr v$Usr: v$Usrs){
				SelectItem v$item = new SelectItem(v$Usr.getCodUsr(),v$Usr.getLibNom()+" "+v$Usr.getLibPre());
				listeMed.add(v$item);
			}
		}
		return listeMed;
	}
	
	public List<SelectItem> getListeSvc() {

		if(listeSvc == null){
			
			listeSvc = new ArrayList<SelectItem>();
			
			List<TabSvc> v$Svcs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabSvc v$critere = new TabSvc();	
			
			// Recherche des comptes en BD 			
			try {
				v$Svcs = AdminSvcoDeleguate.getSvcoSvc().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Svcs = (v$Svcs != null)? v$Svcs : new ArrayList<TabSvc>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabSvc v$Svc: v$Svcs){
				SelectItem v$item = new SelectItem(v$Svc.getCodSvc(),v$Svc.getLibSvc());
				listeSvc.add(v$item);
			}
		}
		return listeSvc;
	}
	
}
