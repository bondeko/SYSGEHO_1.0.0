/**
 * 
 */
package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;
import com.bondeko.sysgeho.be.util.TabPceJte;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;


public class FacVisMedPerioVue extends SysGehoVue<TabFacVisMedPerio> {
	
	/*=========================================================== ~ Debut Region ~ =================================================================*/
	/**	~ Propriétés ~ 	**/    
	/*=============================================================================================================================================*/
	
	private static BaseLogger logger = BaseLogger.getLogger(FacVisMedPerioVue.class);
	
	private TableManager<TabPceJte> pieceMgr = new TableManager<TabPceJte>();
	
	@Override
	public TableManager<TabPceJte> getPieceMgr() {
		return this.pieceMgr;
	}

	/**
	 * @param pieceMgr the pieceMgr to set
	 */
	@Override
	public void setPieceMgr(TableManager<TabPceJte> pieceMgr) {
		this.pieceMgr = pieceMgr;
	}	
	
	
	public FacVisMedPerioVue() {	
		super();
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();
	}

	public BaseLogger getLogger(){
		return logger;
	}
	
	
	/**
	 * Retourne une nouvelle Instance de l'entité  
	 * 
	 * @return
	 */	
	public static TabFacVisMedPerio getTabFacVisMedPerio(){		
		TabFacVisMedPerio v$facConv = new TabFacVisMedPerio();
		v$facConv.setInfoUser(getInfoUser());
		v$facConv.initData();
		return v$facConv ;	
	}

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFacVisMedPerio getTabFacVisMedPerioForSearch(){		
		TabFacVisMedPerio v$facConv = getTabFacVisMedPerio();
		return v$facConv ;	
	}	

	@Override
	public TabFacVisMedPerio getNewEntity() {		
		return getTabFacVisMedPerio();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	@Override
	public TabFacVisMedPerio getEntityForSearch() {	
		return getTabFacVisMedPerioForSearch();
	}	

}
