package com.bondeko.sysgeho.ui.phar.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.phar.entity.TabCatProd;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class CatProdVue extends SysGehoVue<TabCatProd>{
	
	public CatProdVue(){
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
	public static TabCatProd getTabCatProd (){		
		TabCatProd v$CatProd = new TabCatProd();
		v$CatProd.setInfoUser(getInfoUser());
		v$CatProd.initData();
		return v$CatProd ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabCatProd getTabCatProdForSearch (){		
		TabCatProd v$Ass = getTabCatProd();
		return v$Ass ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(CatProdVue.class);
	}
	
	
	public TabCatProd getNewEntity(){
		return getTabCatProd();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabCatProd getEntityForSearch() {	
		return getTabCatProdForSearch();
	}	

}
