package com.bondeko.sysgeho.ui.admin.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabRol;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class UsrVue extends SysGehoVue<TabUsr>{
	
	
	/**
	 * Propriété permant de gérer l'exactitude du mot de passe saisi par l'utilisateur 
	 */
	String password;
	
	private List<SelectItem> listeSvc;
	
	private List<SelectItem> listeRol;
	
	//mapSitr
	private Map<String, TabSvc> mapSvc = new HashMap<String, TabSvc>();
	
	private Map<String, TabRol> mapRol = new HashMap<String, TabRol>();
	
	public UsrVue(){
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
	public static TabUsr getTabUsr (){		
		
		TabUsr v$user = new TabUsr();
		// Mise des info de l'utilisateur
		v$user.setInfoUser(getInfoUser());
		v$user.initData();
		return v$user ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabUsr getTabUsrForSearch (){		
		
		TabUsr v$user = getTabUsr();
		return v$user ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(UsrVue.class);
	}
	
	
	public TabUsr getNewEntity(){
		return getTabUsr();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabUsr getEntityForSearch() {	
		return getTabUsrForSearch();
	}	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password2 the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	public List<SelectItem> getListeRol() {

		if(listeRol == null){
			
			listeRol = new ArrayList<SelectItem>();
			
			List<TabRol> v$Rols = null;
						
			// Critères de recherche des comptes de dépôt	
			TabRol v$critere = new TabRol();	
			
			// Recherche des comptes en BD 			
			try {
				v$Rols = AdminSvcoDeleguate.getSvcoRol().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Rols = (v$Rols != null)? v$Rols : new ArrayList<TabRol>();
			
			// Création de la liste des élements pour le comboBox
			for(TabRol v$Rol: v$Rols){
				SelectItem v$item = new SelectItem(v$Rol.getCodRol(),v$Rol.getCodRol());
				listeRol.add(v$item);
				mapRol.put(v$Rol.getCodRol(), v$Rol);
			}
		}
		return listeRol;
	}
	
	public void updateLibRol(ActionEvent evt){
		getEntiteCourante().setLibRol(mapRol.get(getEntiteCourante().getCodRol()).getLibRol());
	}
	
}
