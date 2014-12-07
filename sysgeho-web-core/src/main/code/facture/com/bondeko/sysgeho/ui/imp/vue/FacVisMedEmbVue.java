/**
 * 
 */
package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;
import com.bondeko.sysgeho.be.util.TabPceJte;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;


public class FacVisMedEmbVue extends SysGehoVue<TabFacVisMedEmb> {
	
	/*=========================================================== ~ Debut Region ~ =================================================================*/
	/**	~ Propriétés ~ 	**/    
	/*=============================================================================================================================================*/
	
	private static BaseLogger logger = BaseLogger.getLogger(FacVisMedEmbVue.class);
	
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
	
	
	public FacVisMedEmbVue() {	
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
	public static TabFacVisMedEmb getTabFacVisMedEmb(){		
		TabFacVisMedEmb v$facConv = new TabFacVisMedEmb();
		v$facConv.setInfoUser(getInfoUser());
		v$facConv.initData();
		return v$facConv ;	
	}

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFacVisMedEmb getTabFacVisMedEmbForSearch(){		
		TabFacVisMedEmb v$facConv = getTabFacVisMedEmb();
		return v$facConv ;	
	}	

	@Override
	public TabFacVisMedEmb getNewEntity() {		
		return getTabFacVisMedEmb();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	@Override
	public TabFacVisMedEmb getEntityForSearch() {	
		return getTabFacVisMedEmbForSearch();
	}	

}
