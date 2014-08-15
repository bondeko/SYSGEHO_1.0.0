package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuStatutMat;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.ref.entity.TabAss;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class PatVue extends SysGehoVue<TabPat>{
	
	private  Map<String, Object> listeStaMat;
	
	private List<SelectItem> listeSoc;
	
	private List<SelectItem> listeAss;
	
	private Map<String, TabSoc> mapSoc = new HashMap<String, TabSoc>();
	
	private Map<String, TabAss> mapAss = new HashMap<String, TabAss>();
	
	public PatVue(){
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
	public static TabPat getTabPat (){		
		
		TabPat v$Pat = new TabPat();
		v$Pat.setInfoUser(getInfoUser());
		v$Pat.initData();
		return v$Pat ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabPat getTabPatForSearch (){		
		TabPat v$Pat = getTabPat();
		return v$Pat ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(PatVue.class);
	}
	
	
	public TabPat getNewEntity(){
		return getTabPat();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabPat getEntityForSearch() {	
		return getTabPatForSearch();
	}	
	
	public void setListeStaMat(Map<String, Object> listeStaMat) {
		this.listeStaMat = listeStaMat;
	}

	public Map<String, Object> getListeStaMat() {
		if(listeStaMat == null){
			listeStaMat = SysGehoToolBox.getComboData(EnuStatutMat.getMaps());
			listeStaMat.put("", "");
		}
		return listeStaMat;
	}
	
	public List<SelectItem> getListeSoc() {

		if(listeSoc == null){
			
			listeSoc = new ArrayList<SelectItem>();
			
			List<TabSoc> v$Socs = null;
						
			// Critères de recherche des comptes de dépôt	
			TabSoc v$critere = new TabSoc();	
			
			// Recherche des comptes en BD 			
			try {
				v$Socs = RefSvcoDeleguate.getSvcoSoc().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Socs = (v$Socs != null)? v$Socs : new ArrayList<TabSoc>();
			
			// Création de la liste des élements pour le comboBox
			for(TabSoc v$Soc: v$Socs){
				SelectItem v$item = new SelectItem(v$Soc.getCodSoc(),v$Soc.getCodSoc());
				listeSoc.add(v$item);
				mapSoc.put(v$Soc.getCodSoc(), v$Soc);
			}
		}
		return listeSoc;
	}
	
	public void updateLibSoc(ActionEvent evt){
		getEntiteCourante().setLibSoc(mapSoc.get(getEntiteCourante().getCodSoc()).getLibSoc());
	}
	
	public List<SelectItem> getListeAss() {

		if(listeAss == null){
			
			listeAss = new ArrayList<SelectItem>();
			
			List<TabAss> v$Asss = null;
						
			// Critères de recherche des comptes de dépôt	
			TabAss v$critere = new TabAss();	
			
			// Recherche des comptes en BD 			
			try {
				v$Asss = RefSvcoDeleguate.getSvcoAss().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Asss = (v$Asss != null)? v$Asss : new ArrayList<TabAss>();
			
			// Création de la liste des élements pour le comboBox
			for(TabAss v$Ass: v$Asss){
				SelectItem v$item = new SelectItem(v$Ass.getCodAss(),v$Ass.getCodAss());
				listeAss.add(v$item);
				mapAss.put(v$Ass.getCodAss(), v$Ass);
			}
		}
		return listeAss;
	}
	
	public void updateLibAss(ActionEvent evt){
		getEntiteCourante().setLibAss(mapAss.get(getEntiteCourante().getCodAss()).getLibAss());
	}

}
