package com.bondeko.sysgeho.ui.ref.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabTypSoin;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class TypSoinVue extends SysGehoVue<TabTypSoin>{
	
	
	public TypSoinVue(){
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
	public static TabTypSoin getTabTypSoin (){		
		
		TabTypSoin v$TypSoin = new TabTypSoin();
		v$TypSoin.setInfoUser(getInfoUser());
		v$TypSoin.initData();
		return v$TypSoin ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabTypSoin getTabTypSoinForSearch (){		
		TabTypSoin v$TypSoin = getTabTypSoin();
		return v$TypSoin ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(TypSoinVue.class);
	}
	
	
	public TabTypSoin getNewEntity(){
		return getTabTypSoin();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabTypSoin getEntityForSearch() {	
		return getTabTypSoinForSearch();
	}	
	
	
}
