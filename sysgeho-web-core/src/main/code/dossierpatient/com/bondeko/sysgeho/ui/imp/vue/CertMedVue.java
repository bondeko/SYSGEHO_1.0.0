package com.bondeko.sysgeho.ui.imp.vue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.enums.EnuModPchg;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class CertMedVue extends SysGehoVue<TabCertMed>{

	private  Map<String, Object> listeModPchg;
	
	private boolean visEmb;
	private boolean visPerio;

	public CertMedVue(){
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
	public static TabCertMed getTabCertMed (){		

		TabCertMed v$Consul = new TabCertMed();
		v$Consul.setInfoUser(getInfoUser());
		v$Consul.initData();
		return v$Consul ;	
	}	

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabCertMed getTabCertMedForSearch (){		
		TabCertMed v$Consul = getTabCertMed();
		return v$Consul ;	
	}	
	/**
	 * Retourne un Logger pour la Classe
	 * 
	 * @return
	 */
	public BaseLogger getLogger() {
		return BaseLogger.getLogger(CertMedVue.class);
	}


	public TabCertMed getNewEntity(){
		return getTabCertMed();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	public TabCertMed getEntityForSearch() {	
		return getTabCertMedForSearch();
	}	

	
	
	public Map<String, Object> getListeModPchg() {
		if(listeModPchg == null){
			listeModPchg = SysGehoToolBox.getComboData(EnuModPchg.getMaps());
			listeModPchg.put("", "");
		}
		return listeModPchg;
	}
	
	public boolean isVisEmb() {
		boolean isEmb = false;
		TabCertMed consul= getEntiteCourante();
		if(consul != null && consul.getTypVisMedSrc() !=null ){
			if(consul.getTypVisMedSrc().equals("VM_EMB")){
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
		TabCertMed consul= getEntiteCourante();
		if(consul != null && consul.getTypVisMedSrc() !=null ){
			if(consul.getTypVisMedSrc().equals("VM_PERIO")){
				isPerio = true;
			}
		}
		return isPerio;
	}

	public void setVisPerio(boolean visPerio) {
		this.visPerio = visPerio;
	}
	
}
