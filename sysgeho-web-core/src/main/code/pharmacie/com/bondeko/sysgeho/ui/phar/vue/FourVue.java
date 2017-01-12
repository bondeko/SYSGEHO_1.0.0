package com.bondeko.sysgeho.ui.phar.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.entity.TabFour;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class FourVue extends SysGehoVue<TabFour>{
	
	public FourVue(){
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
	public static TabFour getTabFour (){		
		TabFour v$four = new TabFour();
		v$four.setInfoUser(getInfoUser());
		v$four.initData();
		return v$four ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFour getTabFourdForSearch (){		
		TabFour v$Four = getTabFour();
		return v$Four ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(FourVue.class);
	}
	
	
	public TabFour getNewEntity(){
		return getTabFour();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabFour getEntityForSearch() {	
		return getTabFour();
	}	

}
