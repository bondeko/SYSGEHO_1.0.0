package com.bondeko.sysgeho.ui.admin.vue;


import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSite;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class SiteVue extends SysGehoVue<TabSite>{
	
	
	
	public SiteVue(){
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
	public static TabSite getTabSite (){		
		
		TabSite v$Site = new TabSite();
		v$Site.setInfoUser(getInfoUser());
		v$Site.initData();
		return v$Site ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabSite getTabSiteForSearch (){		
		TabSite v$Site = getTabSite();
		return v$Site ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SiteVue.class);
	}
	
	
	public TabSite getNewEntity(){
		return getTabSite();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabSite getEntityForSearch() {	
		return getTabSiteForSearch();
	}	
}
