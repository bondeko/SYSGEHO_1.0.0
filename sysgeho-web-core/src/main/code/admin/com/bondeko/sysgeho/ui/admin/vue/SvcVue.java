package com.bondeko.sysgeho.ui.admin.vue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class SvcVue extends SysGehoVue<TabSvc>{
	
	private List<SelectItem> listeSvc;
	
	//mapSitr
	private Map<String, TabSvc> mapSvc = new HashMap<String, TabSvc>();
	
	public SvcVue(){
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
	public static TabSvc getTabSvc (){		
		
		TabSvc v$Svc = new TabSvc();
		v$Svc.setInfoUser(getInfoUser());
		v$Svc.initData();
		return v$Svc ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabSvc getTabSvcForSearch (){		
		TabSvc v$Svc = getTabSvc();
		return v$Svc ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SvcVue.class);
	}
	
	
	public TabSvc getNewEntity(){
		return getTabSvc();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabSvc getEntityForSearch() {	
		return getTabSvcForSearch();
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
				SelectItem v$item = new SelectItem(v$Svc.getCodSvc(),v$Svc.getCodSvc());
				listeSvc.add(v$item);
				mapSvc.put(v$Svc.getCodSvc(), v$Svc);
			}
		}
		return listeSvc;
	}
	
	public void updateLibSvc(ActionEvent evt){
		getEntiteCourante().setLibSvcPar(mapSvc.get(getEntiteCourante().getCodSvcPar()).getLibSvc());
	}
}
