package com.bondeko.sysgeho.ui.phar.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabFour;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;
import com.bondeko.sysgeho.be.phar.entity.TabProd;
import com.bondeko.sysgeho.be.phar.entity.TabSousCatProd;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;
import com.bondeko.sysgeho.ui.phar.util.PharTrt;
import com.bondeko.sysgeho.ui.phar.vue.ProdVue;

public class ProdCtrl extends SysGehoCtrl<TabProd, TabProd>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "prodCtrl";
	
	public ProdCtrl(){		
		defaultVue = new ProdVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabProd> getEntitySvco() throws ServiceLocatorException{	
		return PharSvcoDeleguate.getSvcoProd();
	}
	
	public Class<ProdCtrl> getMyClass() {
		return ProdCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "ProdDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Prod";

		System.out.println("ProdCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				PharTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(PharTrt.ENREG_QTE.getKey(), new Traitement(PharTrt.ENREG_QTE));
		
		Traitement v$traitement = new Traitement(
			PharTrt.NAVIGUER_MOUV.naviguerVersFormulaireListe(),
			PharTrt.NAVIGUER_MOUV);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}
	
	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Prod")) ;
		}
	}
	
	@Override
	public List<TabProd> rechercherParCritere(TabProd p$entity)
		throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return PharSvcoDeleguate.getSvcoProd().rechercherParCritere(p$entity);
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
		System.out.println("v$navigation == "+v$navigation);
		// Si la navigation s'effectue vers le compte rendu
		if (v$navigation.equals(PharTrt.NAVIGUER_MOUV
				.naviguerVersFormulaireListe())) {
			
			TabMouvStock mouvStock = new TabMouvStock();
			mouvStock.initData();
			mouvStock.setTabProd(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(mouvStock);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabSousCatProd")) {
			TabSousCatProd v$entite = (TabSousCatProd) p$entite;
			defaultVue.getEntiteCourante().setTabSousCatProd(v$entite);
		}
		if (v$propriete.equals("tabFour")) {
			TabFour v$entite = (TabFour) p$entite;
			defaultVue.getEntiteCourante().setTabFour(v$entite);
		}
	}
	
	@SuppressWarnings({ "finally", "unchecked" })
	public String enregistrerQte() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			MouvStockCtrl mouvStockCtrl = (MouvStockCtrl) FacesUtil
			.getSessionMapValue(new MouvStockCtrl().getNomManagedBean2());

			if (mouvStockCtrl == null) {
				mouvStockCtrl = new MouvStockCtrl();
				
				FacesUtil.setSessionMapValue(mouvStockCtrl.getNomManagedBean2(),
						mouvStockCtrl);
			}
			
			TabProd prod = getDefaultVue().getEntiteCourante();
			
			TabMouvStock mouvStock = new TabMouvStock(prod.getInfoUser());
			mouvStock.setTabProd(prod);		
			mouvStockCtrl.getDefaultVue().setEntiteCourante(mouvStock);
			mouvStockCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "MouvStockEdition";
//		finally {
//			// Retour à la page adéquate
//			return v$navigation;
//		}
	}
}
