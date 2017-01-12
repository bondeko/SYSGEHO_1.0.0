package com.bondeko.sysgeho.ui.phar.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.entity.TabDepart;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class DepartVue extends SysGehoVue<TabDepart>{
	
	public DepartVue(){
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
	public static TabDepart getTabDepart (){		
		TabDepart v$depart = new TabDepart();
		v$depart.setInfoUser(getInfoUser());
		v$depart.initData();
		return v$depart ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabDepart getTabDepartdForSearch (){		
		TabDepart v$Depart = getTabDepart();
		return v$Depart ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(DepartVue.class);
	}
	
	
	public TabDepart getNewEntity(){
		return getTabDepart();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabDepart getEntityForSearch() {	
		return getTabDepart();
	}	

}
