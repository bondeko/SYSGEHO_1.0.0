package com.bondeko.sysgeho.ui.admin.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.admin.util.AdminTrt;
import com.bondeko.sysgeho.ui.admin.vue.SvcVue;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class SvcCtrl extends SysGehoCtrl<TabSvc, TabSvc>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "svcCtrl";
	
	public SvcCtrl(){		
		defaultVue = new SvcVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabSvc> getEntitySvco() throws ServiceLocatorException{	
		return AdminSvcoDeleguate.getSvcoSvc();
	}
	
	public Class<SvcCtrl> getMyClass() {
		return SvcCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "SvcDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Svc";

		System.out.println("SvcCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				AdminTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(AdminTrt.getTrtStandards("Svc")) ;
		}	
	}

	@Override
	public List<TabSvc> rechercherParCritere(TabSvc p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return AdminSvcoDeleguate.getSvcoSvc().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	
}
