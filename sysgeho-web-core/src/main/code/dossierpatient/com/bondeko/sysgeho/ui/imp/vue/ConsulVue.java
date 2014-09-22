package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class ConsulVue extends SysGehoVue<TabConsul>{

	private List<SelectItem> listeSpec;
	private  Map<String, Object> listeModPchg;

	public ConsulVue(){
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
	public static TabConsul getTabConsul (){		

		TabConsul v$Consul = new TabConsul();
		v$Consul.setInfoUser(getInfoUser());
		v$Consul.initData();
		return v$Consul ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabConsul getTabConsulForSearch (){		
		TabConsul v$Consul = getTabConsul();
		return v$Consul ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(ConsulVue.class);
	}


	public TabConsul getNewEntity(){
		return getTabConsul();
	}

	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabConsul getEntityForSearch() {	
		return getTabConsulForSearch();
	}	

	public List<SelectItem> getListeSpec() {

		if(listeSpec == null){

			listeSpec = new ArrayList<SelectItem>();

			List<TabSpec> v$Specs = null;

			// Crit�res de recherche des comptes de d�p�t	
			TabSpec v$critere = new TabSpec();	

			// Recherche des comptes en BD 			
			try {
				v$Specs = RefSvcoDeleguate.getSvcoSpec().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 

			v$Specs = (v$Specs != null)? v$Specs : new ArrayList<TabSpec>();

			// Cr�ation de la liste des �lements pour le comboBox
			for(TabSpec v$Spec: v$Specs){
				SelectItem v$item = new SelectItem(v$Spec.getCodSpec(),v$Spec.getLibSpec());
				listeSpec.add(v$item);
			}
		}
		return listeSpec;
	}
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}

}
