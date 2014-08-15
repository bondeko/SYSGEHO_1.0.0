package com.bondeko.sysgeho.ui.admin.vue;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabRol;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class RolVue extends SysGehoVue<TabRol>{
	
	public RolVue(){
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
	public static TabRol getTabRol (){		
		
		TabRol v$Rol = new TabRol();
		v$Rol.setInfoUser(getInfoUser());
		v$Rol.initData();
		return v$Rol ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabRol getTabRolForSearch (){		
		TabRol v$Rol = getTabRol();
		return v$Rol ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(RolVue.class);
	}
	
	
	public TabRol getNewEntity(){
		return getTabRol();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabRol getEntityForSearch() {	
		return getTabRolForSearch();
	}	

}
