package com.bondeko.sysgeho.ui.ref.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class ChrHospiVue extends SysGehoVue<TabChrHospi>{
	
	public ChrHospiVue(){
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
	public static TabChrHospi getTabChrHospi (){		
		
		TabChrHospi v$ChrHospi = new TabChrHospi();
		v$ChrHospi.setInfoUser(getInfoUser());
		v$ChrHospi.initData();
		return v$ChrHospi ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabChrHospi getTabChrHospiForSearch (){		
		TabChrHospi v$ChrHospi = getTabChrHospi();
		return v$ChrHospi ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ChrHospiVue.class);
	}
	
	
	public TabChrHospi getNewEntity(){
		return getTabChrHospi();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabChrHospi getEntityForSearch() {	
		return getTabChrHospiForSearch();
	}	
}
