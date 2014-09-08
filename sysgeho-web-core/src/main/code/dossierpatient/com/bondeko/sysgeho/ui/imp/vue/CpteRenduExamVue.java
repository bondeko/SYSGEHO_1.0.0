package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class CpteRenduExamVue extends SysGehoVue<TabCpteRenduExam>{
	
	public CpteRenduExamVue(){
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
	public static TabCpteRenduExam getTabCpteRenduExam (){		
		
		TabCpteRenduExam v$CpteRenduExam = new TabCpteRenduExam();
		v$CpteRenduExam.setInfoUser(getInfoUser());
		v$CpteRenduExam.initData();
		return v$CpteRenduExam ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabCpteRenduExam getTabCpteRenduExamForSearch (){		
		TabCpteRenduExam v$CpteRenduExam = getTabCpteRenduExam();
		return v$CpteRenduExam ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(CpteRenduExamVue.class);
	}
	
	
	public TabCpteRenduExam getNewEntity(){
		return getTabCpteRenduExam();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabCpteRenduExam getEntityForSearch() {	
		return getTabCpteRenduExamForSearch();
	}	
	
}
