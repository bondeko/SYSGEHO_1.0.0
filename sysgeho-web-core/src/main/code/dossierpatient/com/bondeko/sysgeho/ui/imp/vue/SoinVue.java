package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.ref.entity.TabTypSoin;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class SoinVue extends SysGehoVue<TabSoin>{
	
	private ArrayList<SelectItem> listeTypSoin; 
	
	private  Map<String, Object> listeModPchg;

	public SoinVue(){
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
	public static TabSoin getTabSoin (){		
		
		TabSoin v$Soin = new TabSoin();
		v$Soin.setInfoUser(getInfoUser());
		v$Soin.initData();
		return v$Soin ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabSoin getTabSoinForSearch (){		
		TabSoin v$Soin = getTabSoin();
		return v$Soin ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(SoinVue.class);
	}
	
	
	public TabSoin getNewEntity(){
		return getTabSoin();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabSoin getEntityForSearch() {	
		return getTabSoinForSearch();
	}	
	
	public List<SelectItem> getListeTypSoin() {

		if(listeTypSoin == null){
			
			listeTypSoin = new ArrayList<SelectItem>();
			
			List<TabTypSoin> v$TypSoins = null;
						
			// Critères de recherche des comptes de dépôt	
			TabTypSoin v$critere = new TabTypSoin();	
			
			// Recherche des comptes en BD 			
			try {
				v$TypSoins = RefSvcoDeleguate.getSvcoTypSoin().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$TypSoins = (v$TypSoins != null)? v$TypSoins : new ArrayList<TabTypSoin>();
			
			// Création de la liste des élements pour le comboBox
			for(TabTypSoin v$TypSoin: v$TypSoins){
				SelectItem v$item = new SelectItem(v$TypSoin.getCodTypSoin(),v$TypSoin.getLibTypSoin());
				listeTypSoin.add(v$item);
			}
		}
		return listeTypSoin;
	}
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}
	
}
