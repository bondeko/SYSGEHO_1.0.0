package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.be.ref.entity.TabLit;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class HospiVue extends SysGehoVue<TabHospi>{
	
	private List<SelectItem> listeMed;
	
	private List<SelectItem> listeSvc;
	
	private List<SelectItem> listeChr;
	
	private List<SelectItem> listeLit;
	
	private  Map<String, Object> listeModPchg;
	
	private boolean visEmb;
	private boolean visPerio;
	
	public HospiVue(){
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
	public static TabHospi getTabHospi (){		
		
		TabHospi v$Hospi = new TabHospi();
		v$Hospi.setInfoUser(getInfoUser());
		v$Hospi.initData();
		return v$Hospi ;	
	}	
	
	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabHospi getTabHospiForSearch (){		
		TabHospi v$Hospi = getTabHospi();
		return v$Hospi ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(HospiVue.class);
	}
	
	
	public TabHospi getNewEntity(){
		return getTabHospi();
	}
	
	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabHospi getEntityForSearch() {	
		return getTabHospiForSearch();
	}	
	
	public List<SelectItem> getListeMed() {

		if(listeMed == null){
			
			listeMed = new ArrayList<SelectItem>();
			
			List<TabUsr> v$Usrs = null;
						
			// Critères de recherche des comptes de dépôt	
			TabUsr v$critere = new TabUsr();	
			
			// Recherche des comptes en BD 			
			try {
				v$Usrs = AdminSvcoDeleguate.getSvcoUsr().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Usrs = (v$Usrs != null)? v$Usrs : new ArrayList<TabUsr>();
			
			// Création de la liste des élements pour le comboBox
			for(TabUsr v$Usr: v$Usrs){
				SelectItem v$item = new SelectItem(v$Usr.getCodUsr(),v$Usr.getLibNom()+" "+v$Usr.getLibPre());
				listeMed.add(v$item);
			}
		}
		return listeMed;
	}
	
	public List<SelectItem> getListeSvc() {

		if(listeSvc == null){
			
			listeSvc = new ArrayList<SelectItem>();
			
			List<TabSvc> v$Svcs = null;
						
			// Critères de recherche des comptes de dépôt	
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
			
			// Création de la liste des élements pour le comboBox
			for(TabSvc v$Svc: v$Svcs){
				SelectItem v$item = new SelectItem(v$Svc.getCodSvc(),v$Svc.getLibSvc());
				listeSvc.add(v$item);
			}
		}
		return listeSvc;
	}
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}
	
	public List<SelectItem> getListeChr() {

		if(listeChr == null){
			
			listeChr = new ArrayList<SelectItem>();
			
			List<TabChrHospi> v$Chrs = null;
						
			// Critères de recherche des comptes de dépôt	
			TabChrHospi v$critere = new TabChrHospi();	
			
			// Recherche des comptes en BD 			
			try {
				v$Chrs = RefSvcoDeleguate.getSvcoChrHospi().rechercherTout(v$critere);
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Chrs = (v$Chrs != null)? v$Chrs : new ArrayList<TabChrHospi>();
			
			// Création de la liste des élements pour le comboBox
			for(TabChrHospi v$chr: v$Chrs){
				SelectItem v$item = new SelectItem(v$chr.getNumChrHospi(),v$chr.getNumChrHospi()+" - "+v$chr.getLibChrHospi());
				listeChr.add(v$item);
			}
		}
		return listeChr;
	}
	
	public List<SelectItem> getListeLit() {

		if(listeLit == null){
			
			listeLit = new ArrayList<SelectItem>();
			
			List<TabLit> v$Lits = null;
						
			// Critères de recherche des comptes de dépôt	
			TabLit v$critere = new TabLit();	
			
			// Recherche des comptes en BD 			
			try {
				v$Lits = RefSvcoDeleguate.getSvcoLit().rechercherLitByNumChr(getEntiteCourante().getTabChrHospi().getNumChrHospi());
			} 
			catch (Exception e) {
				getLogger().error(e.getMessage(), e);
				e.printStackTrace();
			} 
			
			v$Lits = (v$Lits != null)? v$Lits : new ArrayList<TabLit>();
			
			// Création de la liste des élements pour le comboBox
			for(TabLit v$lit: v$Lits){
				SelectItem v$item = new SelectItem(v$lit.getCodLit(),v$lit.getNumLit()+" - "+v$lit.getLibLit());
				listeLit.add(v$item);
			}
		}
		return listeLit;
	}
	
	public void updateListLit(ActionEvent evt){
		List<TabLit> v$Lits = null;
		try {
			 v$Lits = RefSvcoDeleguate.getSvcoLit().rechercherLitByNumChr(getEntiteCourante().getTabChrHospi().getNumChrHospi());
			
		} 
		catch (Exception e) {
			getLogger().error(e.getMessage(), e);
			e.printStackTrace();
		} 
		v$Lits = (v$Lits != null)? v$Lits : new ArrayList<TabLit>();
		
		// Création de la liste des élements pour le comboBox
		listeLit = new ArrayList<SelectItem>();
		for(TabLit v$lit: v$Lits){
			SelectItem v$item = new SelectItem(v$lit.getCodLit(),v$lit.getNumLit()+" - "+v$lit.getLibLit());
			listeLit.add(v$item);
		}
	}
	
	public void updateCodVis(ActionEvent evt){
		if(getEntiteCourante() != null && getEntiteCourante().getTypVisMedSrc() !=null ){
			if(getEntiteCourante().getTypVisMedSrc().equals("VM_EMB")){
				getEntiteCourante().setTabVisMedPerio(new TabVisMedPerio());
//				getEntiteCourante().getTabVisMedPerio().setCodVisMedPerio(null);
//				getEntiteCourante().getTabVisMedPerio().setLibMotif(null);
			}else if(getEntiteCourante().getTypVisMedSrc().equals("VM_PERIO")){
				getEntiteCourante().setTabVisMedEmb(new TabVisMedEmb());
//				getEntiteCourante().getTabVisMedEmb().setCodVisMedEmb(null);
//				getEntiteCourante().getTabVisMedEmb().setLibMotif(null);
			}
		}
	}
	
	public boolean isVisEmb() {
		boolean isEmb = false;
		TabHospi hospi= getEntiteCourante();
		if(hospi != null && hospi.getTypVisMedSrc() !=null ){
			if(hospi.getTypVisMedSrc().equals("VM_EMB")){
				isEmb = true;
			}
		}
		return isEmb;
	}

	public void setVisEmb(boolean visEmb) {
		this.visEmb = visEmb;
	}
	
	public boolean isVisPerio() {
		boolean isPerio = false;
		TabHospi hospi= getEntiteCourante();
		if(hospi != null && hospi.getTypVisMedSrc() !=null ){
			if(hospi.getTypVisMedSrc().equals("VM_PERIO")){
				isPerio = true;
			}
		}
		return isPerio;
	}

	public void setVisPerio(boolean visPerio) {
		this.visPerio = visPerio;
	}
	
}
