package com.bondeko.sysgeho.ui.admin.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.ui.admin.util.AdminSvcoDeleguate;
import com.bondeko.sysgeho.ui.admin.util.AdminTrt;
import com.bondeko.sysgeho.ui.admin.vue.UsrVue;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class UsrCtrl extends SysGehoCtrl<TabUsr, TabUsr>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "usrCtrl";
	
	public UsrCtrl(){		
		defaultVue = new UsrVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
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
		
		// Si ns sommes en Cr�ation
		if(! defaultVue.getNavigationMgr().getEnModification()){
			// V�rification obligatoire 
			if(! defaultVue.getEntiteCourante().getCodPwd().equals(v$password)){				
				// Pas de traitement de cr�ation possible
				throw new DataValidationException("Echec de la v�rification du mot de passe saisi");
			}
		}
		// Si par contre nous sommes en Modification 
		else {
			// Si le mot de passe a �t�  chang� 
			if(! defaultVue.getEntiteTemporaire().getCodPwd().equals(defaultVue.getEntiteCourante().getCodPwd())){
				// Alors v�rification de l'�galit� 
				if (! defaultVue.getEntiteCourante().getCodPwd().equals(v$password)){					
					// Pas de traitement de modification possible
					throw new DataValidationException("Echec de la v�rification du mot de passe saisi");
				}					
			}
		}	
	}
	
}
