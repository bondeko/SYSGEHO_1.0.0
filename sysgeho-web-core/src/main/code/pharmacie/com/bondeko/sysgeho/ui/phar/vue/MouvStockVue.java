package com.bondeko.sysgeho.ui.phar.vue;

import java.util.Map;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuTypMouv;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class MouvStockVue extends SysGehoVue<TabMouvStock>{
	
	private  Map<String, Object> listeTypMouv;
	private boolean entreeMouv;
	
	public MouvStockVue(){
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
	public static TabMouvStock getTabMouvStock (){		
		TabMouvStock v$mouvStock = new TabMouvStock();
		v$mouvStock.setInfoUser(getInfoUser());
		v$mouvStock.initData();
		return v$mouvStock ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabMouvStock getTabFourdForSearch (){		
		TabMouvStock v$MouvStock = getTabMouvStock();
		return v$MouvStock ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(MouvStockVue.class);
	}
	
	
	public TabMouvStock getNewEntity(){
		return getTabMouvStock();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabMouvStock getEntityForSearch() {	
		return getTabMouvStock();
	}	
	
	public Map<String, Object> getListeTypMouv() {
		if(listeTypMouv == null){
			listeTypMouv = SysGehoToolBox.getComboData(EnuTypMouv.getMaps());
			listeTypMouv.put("", "");
		}
		return listeTypMouv;
	}
	
	public boolean isEntreeMouv() {
		boolean isEntreeMouv = false;
		TabMouvStock mouv = getEntiteCourante();
		if(mouv != null && mouv.getEnuTypMouv() !=null ){
			if(mouv.getEnuTypMouv().equalsIgnoreCase(EnuTypMouv.ENTREE.getValue())){
				isEntreeMouv = true;
			}
		}
		return isEntreeMouv;
	}

	public void setEntreeMouv(boolean entreeMouv) {
		System.out.println("setEntreeMouv");
		this.entreeMouv = entreeMouv;
	}
}
