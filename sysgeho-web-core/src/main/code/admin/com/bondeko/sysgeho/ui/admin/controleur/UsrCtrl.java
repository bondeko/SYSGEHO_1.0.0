package com.bondeko.sysgeho.ui.admin.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabRol;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.admin.util.AdminTrt;
import com.bondeko.sysgeho.ui.admin.vue.UsrVue;
import com.bondeko.sysgeho.ui.core.base.CoreConstants;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class UsrCtrl extends SysGehoCtrl<TabUsr, TabUsr>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "usrCtrl";
	
	public UsrCtrl(){		
		defaultVue = new UsrVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabUsr> getEntitySvco() throws ServiceLocatorException{	
		return AdminSvcoDeleguate.getSvcoUsr();
	}
	
	public Class<UsrCtrl> getMyClass() {
		return UsrCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "UsrDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Usr";

		System.out.println("usrCtrl.getListeTraitements() ici il vaut : "
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
			setMapTraitements(AdminTrt.getTrtStandards("Usr")) ;
		}	
	}

	@Override
	public List<TabUsr> rechercherParCritere(TabUsr p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return AdminSvcoDeleguate.getSvcoUsr().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	@Override
	public void preEnregistrer() throws DataValidationException {
				
		String v$password  =  ((UsrVue)defaultVue).getPassword();
		
		// Si ns sommes en Création
		if(! defaultVue.getNavigationMgr().getEnModification()){
			// Vérification obligatoire 
			if(! defaultVue.getEntiteCourante().getCodPwd().equals(v$password)){				
				// Pas de traitement de création possible
				throw new DataValidationException("Echec de la vérification du mot de passe saisi");
			}
		}
		// Si par contre nous sommes en Modification 
		else {
			// Si le mot de passe a été  changé 
			if(! defaultVue.getEntiteTemporaire().getCodPwd().equals(defaultVue.getEntiteCourante().getCodPwd())){
				// Alors vérification de l'égalité 
				if (! defaultVue.getEntiteCourante().getCodPwd().equals(v$password)){					
					// Pas de traitement de modification possible
					throw new DataValidationException("Echec de la vérification du mot de passe saisi");
				}					
			}
		}	
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
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));

		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabSvc")) {
			TabSvc v$entite = (TabSvc) p$entite;
			defaultVue.getEntiteCourante().setTabSvc(v$entite);
		}

		if (v$propriete.equals("tabRol")) {
			TabRol v$entite = (TabRol) p$entite;
			defaultVue.getEntiteCourante().setTabRol(v$entite);
		}
	}
	
	public String afficher(){
		
		String v$navigation = null;
		// L'entité selectionné devient l'objet courant; Cela suppose que le Contexte de page est Liste
		defaultVue.setEntiteCourante(defaultVue.getTableMgr().getEntiteSelectionne());
		
		
		// Par simple Prudence, on dira si l'entite existe
		if(defaultVue.getEntiteCourante() != null){
			
			// Mise à jour de la navigation : Vers le formulaire de Details
			v$navigation =  getMemoEntite().concat(CoreConstants.SUFFIXE_NVGT_DETAILS);
			
			// MAJ de l'ID à display
			setIdEntityToDisplay(defaultVue.getEntiteCourante().getId());
		}
		// Mise en cohérence des IMH
		coherenceIHM();
		// Retour à la page adéquate
		return v$navigation;
	}
	
}
