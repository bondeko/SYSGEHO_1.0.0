package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.be.ref.entity.TabTypRdv;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class RdvVue extends SysGehoVue<TabRdv>{
	
	private List<SelectItem> listeSvc;
	
	private List<SelectItem> listeTypRdv;
	
	private List<SelectItem> listeSpec;
	
	public RdvVue(){
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
	public static TabRdv getTabRdv (){		
		
		TabRdv v$Rdv = new TabRdv();
		v$Rdv.setInfoUser(getInfoUser());
		v$Rdv.initData();
		return v$Rdv ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 * 
	 * @return
	 */
	public static TabRdv getTabRdvForSearch (){		
		TabRdv v$Rdv = getTabRdv();
		return v$Rdv ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(RdvVue.class);
	}
	
	
	public TabRdv getNewEntity(){
		return getTabRdv();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entit� utile pour la recherche des donn�es;  
	 *  
	 * @return
	 */	
	public TabRdv getEntityForSearch() {	
		return getTabRdvForSearch();
	}	
	
	public List<SelectItem> getListeSvc() {

		if(listeSvc == null){
			
			listeSvc = new ArrayList<SelectItem>();
			
			List<TabSvc> v$Svcs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabSvc v$critere = new TabSvc();	
			
			// Recherche des comptes en BD 			
			try {
				v$Svcs = AdminSvcoDeleguate.getSvcoSvc().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Svcs = (v$Svcs != null)? v$Svcs : new ArrayList<TabSvc>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabSvc v$Svc: v$Svcs){
				SelectItem v$item = new SelectItem(v$Svc.getCodSvc(),v$Svc.getLibSvc());
				listeSvc.add(v$item);
			}
		}
		return listeSvc;
	}
	
	
	public List<SelectItem> getListeTypRdv() {

		if(listeTypRdv == null){
			
			listeTypRdv = new ArrayList<SelectItem>();
			
			List<TabTypRdv> v$TypRdvs = null;
						
			// Crit�res de recherche des comptes de d�p�t	
			TabTypRdv v$critere = new TabTypRdv();	
			
			// Recherche des comptes en BD 			
			try {
				v$TypRdvs = RefSvcoDeleguate.getSvcoTypRdv().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$TypRdvs = (v$TypRdvs != null)? v$TypRdvs : new ArrayList<TabTypRdv>();
			
			// Cr�ation de la liste des �lements pour le comboBox
			for(TabTypRdv v$TypRdv: v$TypRdvs){
				SelectItem v$item = new SelectItem(v$TypRdv.getCodTypRdv(),v$TypRdv.getLibTypRdv());
				listeTypRdv.add(v$item);
			}
		}
		return listeTypRdv;
	}
	
	public List<SelectItem> getListeSpec() {
		listeSpec = null;
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

}
