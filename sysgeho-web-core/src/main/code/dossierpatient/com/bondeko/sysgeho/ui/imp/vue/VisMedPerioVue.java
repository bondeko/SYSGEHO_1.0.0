package com.bondeko.sysgeho.ui.imp.vue;

import java.util.Map;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class VisMedPerioVue extends SysGehoVue<TabVisMedPerio>{

	private  Map<String, Object> listeModPchg;

	public VisMedPerioVue(){
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
	public static TabVisMedPerio getTabVisMedPerio (){		

		TabVisMedPerio v$VisMedPerio = new TabVisMedPerio();
		v$VisMedPerio.setInfoUser(getInfoUser());
		v$VisMedPerio.initData();
		return v$VisMedPerio ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabVisMedPerio getTabVisMedPerioForSearch (){		
		TabVisMedPerio v$VisMedPerio = getTabVisMedPerio();
		return v$VisMedPerio ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(VisMedPerioVue.class);
	}


	public TabVisMedPerio getNewEntity(){
		return getTabVisMedPerio();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabVisMedPerio getEntityForSearch() {	
		return getTabVisMedPerioForSearch();
	}	

	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}

}
