package com.bondeko.sysgeho.ui.ref.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class SocVue extends SysGehoVue<TabSoc>{
	
	public SocVue(){
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
	public static TabSoc getTabSoc (){		
		
		TabSoc v$Soc = new TabSoc();
		v$Soc.setInfoUser(getInfoUser());
		v$Soc.initData();
		return v$Soc ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabSoc getTabSocForSearch (){		
		TabSoc v$Soc = getTabSoc();
		return v$Soc ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SocVue.class);
	}
	
	
	public TabSoc getNewEntity(){
		return getTabSoc();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabSoc getEntityForSearch() {	
		return getTabSocForSearch();
	}	

}
