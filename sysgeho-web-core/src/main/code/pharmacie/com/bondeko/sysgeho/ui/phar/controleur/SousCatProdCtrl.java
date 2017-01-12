package com.bondeko.sysgeho.ui.phar.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabCatProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;
import com.bondeko.sysgeho.ui.phar.util.PharTrt;
import com.bondeko.sysgeho.ui.phar.vue.SousCatProdVue;

public class SousCatProdCtrl extends SysGehoCtrl<TabSousCatProd, TabSousCatProd>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "sousCatProdCtrl";
	
	public SousCatProdCtrl(){		
		defaultVue = new SousCatProdVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabSousCatProd> getEntitySvco() throws ServiceLocatorException{	
		return PharSvcoDeleguate.getSvcoSousCatProd();
	}
	
	public Class<SousCatProdCtrl> getMyClass() {
		return SousCatProdCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "SousCatProdDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "SousCatProd";

		System.out.println("SousCatProdCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				PharTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("SousCatProd")) ;
		}
	}
	
	@Override
	public List<TabSousCatProd> rechercherParCritere(TabSousCatProd p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return PharSvcoDeleguate.getSvcoSousCatProd().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String gotoRelatedEntity() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = super.gotoRelatedEntity();
		
		/*
		 * Recuperation du controleur 
		 * NB: 
		 * 	1-Cette méthode suppose que le controleur est bel et bien dans le Scope Session
		 * 	2-Par ailleurs il devrait normalement déja existé du fait du passage de paramètres dans la page web
		 */
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  
	        (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));

		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabCatProd")) {
			TabCatProd v$entite = (TabCatProd) p$entite;
			defaultVue.getEntiteCourante().setTabCatProd(v$entite);
		}
	}
}
