package com.bondeko.sysgeho.ui.ref.vue;

import java.util.Date;
import java.util.Map;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.enums.EnuMois;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class SocVue extends SysGehoVue<TabSoc>{
	
	private  Map<String, Object> listeMois;
	
	private String anneeEnCour;
	
	public SocVue(){
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
	public static TabSoc getTabSoc (){		
		
		TabSoc v$Soc = new TabSoc();
		v$Soc.setInfoUser(getInfoUser());
		v$Soc.initData();
		return v$Soc ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabSoc getTabSocForSearch (){		
		TabSoc v$Soc = getTabSoc();
		return v$Soc ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SocVue.class);
	}
	
	
	public TabSoc getNewEntity(){
		return getTabSoc();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabSoc getEntityForSearch() {	
		return getTabSocForSearch();
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
