package com.bondeko.sysgeho.ui.admin.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSite;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class UsrVue extends SysGehoVue<TabUsr>{
	
	
	/**
	 * Propri�t� permant de g�rer l'exactitude du mot de passe saisi par l'utilisateur 
	 */
	String password;
	
	private List<SelectItem> listeSite;
	
	//mapSitr
	private Map<String, TabSite> mapSite = new HashMap<String, TabSite>();
	
	public UsrVue(){
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
	public static TabUsr getTabUsr (){		
		
		TabUsr v$user = new TabUsr();
		// Mise des info de l'utilisateur
		v$user.setInfoUser(getInfoUser());
		v$user.initData();
		return v$user ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
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
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
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
	
	public List<SelectItem> getListeSite() {

		if(listeSite == null){
			
			listeSite = new ArrayList<SelectItem>();
			
			List<TabSite> v$sites = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabSite v$critere = new TabSite();	
			
			// Recherche des comptes en BD 			
			try {
				v$sites = AdminSvcoDeleguate.getSvcoSite().rechercherTout(v$critere);
				System.out.println(">>>>>>>>>>>>>>>>>> " + v$sites);
			} 
			catch (Exception e) {
				System.out.println(">>>>>>>>>>>>>>>>>> exception >>>>>>>>>>>>>>");
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$sites = (v$sites != null)? v$sites : new ArrayList<TabSite>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabSite v$site: v$sites){
				SelectItem v$item = new SelectItem(v$site.getCodSite(),v$site.getCodSite());
				listeSite.add(v$item);
				mapSite.put(v$site.getCodSite(), v$site);
			}
		}
		return listeSite;
	}
	
	public void updateLibSite(ActionEvent evt){
		getEntiteCourante().setLibSite(mapSite.get(getEntiteCourante().getCodSite()).getLibSite());
	}
	
}
