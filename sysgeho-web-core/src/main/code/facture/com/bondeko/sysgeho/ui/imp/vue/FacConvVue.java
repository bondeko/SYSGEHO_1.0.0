/**
 * 
 */
package com.bondeko.sysgeho.ui.imp.vue;

import java.util.Date;
import java.util.Map;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.enums.EnuMois;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;


public class FacConvVue extends SysGehoVue<TabFacConv> {
	
	/*=========================================================== ~ Debut Region ~ =================================================================*/
	/**	~ Propriétés ~ 	**/    
	/*=============================================================================================================================================*/
	
	private static BaseLogger logger = BaseLogger.getLogger(FacConvVue.class);
	
	private  Map<String, Object> listeMois;
	
	private String anneeEnCour;
	
	public FacConvVue() {	
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
	public static TabFacConv getTabFacConv(){		
		TabFacConv v$facConv = new TabFacConv();
		v$facConv.setInfoUser(getInfoUser());
		v$facConv.initData();
		return v$facConv ;	
	}

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFacConv getTabFacConvForSearch(){		
		TabFacConv v$facConv = getTabFacConv();
		return v$facConv ;	
	}	

	@Override
	public TabFacConv getNewEntity() {		
		return getTabFacConv();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	@Override
	public TabFacConv getEntityForSearch() {	
		return getTabFacConvForSearch();
	}	
	
	public Map<String, Object> getListeMois() {
		if(listeMois == null){
			listeMois = SysGehoToolBox.getComboData(EnuMois.getMaps());
			listeMois.put("", "");
		}
		return listeMois;
	}
	
	public String getAnneeEnCour(){
		return DateTools.getYear(DateTools.formatDate(new Date()));
	}
	
	public void setAnneeEnCour(String anneeEnCour) {
		this.anneeEnCour = anneeEnCour;
	}

}
