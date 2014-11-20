package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class RapVisMedEmbVue extends SysGehoVue<TabRapVisMedEmb>{

	public RapVisMedEmbVue(){
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
	public static TabRapVisMedEmb getTabRapVisMedEmb (){		

		TabRapVisMedEmb v$RapVisMedEmb = new TabRapVisMedEmb();
		v$RapVisMedEmb.setInfoUser(getInfoUser());
		v$RapVisMedEmb.initData();
		return v$RapVisMedEmb ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabRapVisMedEmb getTabRapVisMedEmbForSearch (){		
		TabRapVisMedEmb v$RapVisMedEmb = getTabRapVisMedEmb();
		return v$RapVisMedEmb ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(RapVisMedEmbVue.class);
	}


	public TabRapVisMedEmb getNewEntity(){
		return getTabRapVisMedEmb();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabRapVisMedEmb getEntityForSearch() {	
		return getTabRapVisMedEmbForSearch();
	}	

}
