package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;
import com.bondeko.sysgeho.be.ref.entity.TabTypRdv;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class RdvVue extends SysGehoVue<TabRdv>{
	
	private List<SelectItem> listeSvc;
	
	private List<SelectItem> listeTypRdv;
	
	private Map<String, TabSvc> mapSvc = new HashMap<String, TabSvc>();
	
	private Map<String, TabTypRdv> mapTypRdv = new HashMap<String, TabTypRdv>();
	
	public RdvVue(){
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
	public static TabRdv getTabRdv (){		
		
		TabRdv v$Rdv = new TabRdv();
		v$Rdv.setInfoUser(getInfoUser());
		v$Rdv.initData();
		return v$Rdv ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabRdv getTabRdvForSearch (){		
		TabRdv v$Rdv = getTabRdv();
		return v$Rdv ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(RdvVue.class);
	}
	
	
	public TabRdv getNewEntity(){
		return getTabRdv();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabRdv getEntityForSearch() {	
		return getTabRdvForSearch();
	}	
	
	public List<SelectItem> getListeSvc() {

		if(listeSvc == null){
			
			listeSvc = new ArrayList<SelectItem>();
			
			List<TabSvc> v$Svcs = null;
						
			// Critères de recherche des comptes de dépôt	
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
			
			// Création de la liste des élements pour le comboBox
			for(TabSvc v$Svc: v$Svcs){
				SelectItem v$item = new SelectItem(v$Svc.getCodSvc(),v$Svc.getCodSvc());
				listeSvc.add(v$item);
				mapSvc.put(v$Svc.getCodSvc(), v$Svc);
			}
		}
		return listeSvc;
	}
	
	public void updateLibSvc(ActionEvent evt){
		getEntiteCourante().setLibSvc(mapSvc.get(getEntiteCourante().getCodSvc()).getLibSvc());
	}
	
	public List<SelectItem> getListeTypRdv() {

		if(listeTypRdv == null){
			
			listeTypRdv = new ArrayList<SelectItem>();
			
			List<TabTypRdv> v$TypRdvs = null;
						
			// Critères de recherche des comptes de dépôt	
			TabTypRdv v$critere = new TabTypRdv();	
			
			// Recherche des comptes en BD 			
			try {
				v$TypRdvs = RefSvcoDeleguate.getSvcoTypRdv().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$TypRdvs = (v$TypRdvs != null)? v$TypRdvs : new ArrayList<TabTypRdv>();
			
			// Création de la liste des élements pour le comboBox
			for(TabTypRdv v$TypRdv: v$TypRdvs){
				SelectItem v$item = new SelectItem(v$TypRdv.getCodTypRdv(),v$TypRdv.getCodTypRdv());
				listeTypRdv.add(v$item);
				mapTypRdv.put(v$TypRdv.getCodTypRdv(), v$TypRdv);
			}
		}
		return listeTypRdv;
	}
	
	public void updateLibTypRdv(ActionEvent evt){
		getEntiteCourante().setLibTypRdv(mapTypRdv.get(getEntiteCourante().getCodTypRdv()).getLibTypRdv());
	}

}
