package com.bondeko.sysgeho.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;
import com.bondeko.sysgeho.ui.ref.vue.SocVue;

public class SocCtrl extends SysGehoCtrl<TabSoc, TabSoc>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "socCtrl";
	
	public SocCtrl(){		
		defaultVue = new SocVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabSoc> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoSoc();
	}
	
	public Class<SocCtrl> getMyClass() {
		return SocCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "SocDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Soc";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				RefTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("Soc")) ;
		}	
	}

	@Override
	public List<TabSoc> rechercherParCritere(TabSoc p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoSoc().rechercherParCritere(p$entity);
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
		if(defaultVue.getEntiteCourante() != null  && defaultVue.getEntiteCourante().getBEstAff()==false){
			defaultVue.getEntiteCourante().setDatAff(null);
		}
	}

}
