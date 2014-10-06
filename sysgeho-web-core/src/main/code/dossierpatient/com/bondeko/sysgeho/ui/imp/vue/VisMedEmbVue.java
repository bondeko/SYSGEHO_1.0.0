package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;

public class VisMedEmbVue extends SysGehoVue<TabVisMedEmb>{

	private List<SelectItem> listeMed;
	private  Map<String, Object> listeModPchg;

	public VisMedEmbVue(){
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
	public static TabVisMedEmb getTabVisMedEmb (){		

		TabVisMedEmb v$VisMedEmb = new TabVisMedEmb();
		v$VisMedEmb.setInfoUser(getInfoUser());
		v$VisMedEmb.initData();
		return v$VisMedEmb ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabVisMedEmb getTabVisMedEmbForSearch (){		
		TabVisMedEmb v$VisMedEmb = getTabVisMedEmb();
		return v$VisMedEmb ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(VisMedEmbVue.class);
	}


	public TabVisMedEmb getNewEntity(){
		return getTabVisMedEmb();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabVisMedEmb getEntityForSearch() {	
		return getTabVisMedEmbForSearch();
	}	

	public List<SelectItem> getListeMed() {

		if(listeMed == null){

			listeMed = new ArrayList<SelectItem>();

			List<TabUsr> v$Meds = null;

			// Critères de recherche des comptes de dépôt	
			TabUsr v$critere = new TabUsr();	

			// Recherche des comptes en BD 			
			try {
				v$Meds = AdminSvcoDeleguate.getSvcoUsr().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 

			v$Meds = (v$Meds != null)? v$Meds : new ArrayList<TabUsr>();

			// Création de la liste des élements pour le comboBox
			for(TabUsr v$med: v$Meds){
				SelectItem v$item = new SelectItem(v$med.getCodUsr(),v$med.getLibNom()+" "+v$med.getLibPre());
				listeMed.add(v$item);
			}
		}
		return listeMed;
	}
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}

}
