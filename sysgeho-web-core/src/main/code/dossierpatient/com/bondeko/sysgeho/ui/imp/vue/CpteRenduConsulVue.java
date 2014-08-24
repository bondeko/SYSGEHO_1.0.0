package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class CpteRenduConsulVue extends SysGehoVue<TabCpteRenduConsul>{
	
	public CpteRenduConsulVue(){
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
	public static TabCpteRenduConsul getTabCpteRenduConsul (){		
		
		TabCpteRenduConsul v$CpteRenduConsul = new TabCpteRenduConsul();
		v$CpteRenduConsul.setInfoUser(getInfoUser());
		v$CpteRenduConsul.initData();
		return v$CpteRenduConsul ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabCpteRenduConsul getTabCpteRenduConsulForSearch (){		
		TabCpteRenduConsul v$CpteRenduConsul = getTabCpteRenduConsul();
		return v$CpteRenduConsul ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(CpteRenduConsulVue.class);
	}
	
	
	public TabCpteRenduConsul getNewEntity(){
		return getTabCpteRenduConsul();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabCpteRenduConsul getEntityForSearch() {	
		return getTabCpteRenduConsulForSearch();
	}	
	
}
