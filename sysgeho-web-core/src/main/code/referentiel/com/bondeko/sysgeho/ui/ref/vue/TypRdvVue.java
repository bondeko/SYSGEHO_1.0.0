package com.bondeko.sysgeho.ui.ref.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.ref.entity.TabTypRdv;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class TypRdvVue extends SysGehoVue<TabTypRdv>{
	
	
	public TypRdvVue(){
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
	public static TabTypRdv getTabTypRdv (){		
		
		TabTypRdv v$TypRdv = new TabTypRdv();
		v$TypRdv.setInfoUser(getInfoUser());
		v$TypRdv.initData();
		return v$TypRdv ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabTypRdv getTabTypRdvForSearch (){		
		TabTypRdv v$TypRdv = getTabTypRdv();
		return v$TypRdv ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(TypRdvVue.class);
	}
	
	
	public TabTypRdv getNewEntity(){
		return getTabTypRdv();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabTypRdv getEntityForSearch() {	
		return getTabTypRdvForSearch();
	}	
	
	
}
