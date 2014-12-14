package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabEtaStat;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class EtaStatVue extends SysGehoVue<TabEtaStat>{
	
	
	public EtaStatVue(){
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
	public static TabEtaStat getTabEtaStat (){		
		
		TabEtaStat v$EtaStat = new TabEtaStat();
		v$EtaStat.setInfoUser(getInfoUser());
		v$EtaStat.initData();
		return v$EtaStat ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabEtaStat getTabEtaStatForSearch (){		
		TabEtaStat v$EtaStat = getTabEtaStat();
		return v$EtaStat ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(EtaStatVue.class);
	}
	
	
	public TabEtaStat getNewEntity(){
		return getTabEtaStat();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabEtaStat getEntityForSearch() {	
		return getTabEtaStatForSearch();
	}	
	
	
}
