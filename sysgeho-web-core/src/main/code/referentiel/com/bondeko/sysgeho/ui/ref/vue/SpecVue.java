package com.bondeko.sysgeho.ui.ref.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class SpecVue extends SysGehoVue<TabSpec>{
	
	
	public SpecVue(){
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
	public static TabSpec getTabSpec (){		
		
		TabSpec v$Spec = new TabSpec();
		v$Spec.setInfoUser(getInfoUser());
		v$Spec.initData();
		return v$Spec ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabSpec getTabSpecForSearch (){		
		TabSpec v$Spec = getTabSpec();
		return v$Spec ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SpecVue.class);
	}
	
	
	public TabSpec getNewEntity(){
		return getTabSpec();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabSpec getEntityForSearch() {	
		return getTabSpecForSearch();
	}	
	
	
}
