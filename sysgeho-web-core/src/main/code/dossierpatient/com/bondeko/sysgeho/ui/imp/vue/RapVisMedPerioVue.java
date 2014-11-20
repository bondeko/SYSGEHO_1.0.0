package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class RapVisMedPerioVue extends SysGehoVue<TabRapVisMedPerio>{

	public RapVisMedPerioVue(){
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
	public static TabRapVisMedPerio getTabRapVisMedPerio (){		

		TabRapVisMedPerio v$RapVisMedPerio = new TabRapVisMedPerio();
		v$RapVisMedPerio.setInfoUser(getInfoUser());
		v$RapVisMedPerio.initData();
		return v$RapVisMedPerio ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabRapVisMedPerio getTabRapVisMedPerioForSearch (){		
		TabRapVisMedPerio v$RapVisMedPerio = getTabRapVisMedPerio();
		return v$RapVisMedPerio ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(RapVisMedPerioVue.class);
	}


	public TabRapVisMedPerio getNewEntity(){
		return getTabRapVisMedPerio();
	}

	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabRapVisMedPerio getEntityForSearch() {	
		return getTabRapVisMedPerioForSearch();
	}	

}
