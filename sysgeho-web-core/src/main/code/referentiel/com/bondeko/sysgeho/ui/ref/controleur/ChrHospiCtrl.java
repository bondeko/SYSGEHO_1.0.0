package com.bondeko.sysgeho.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;
import com.bondeko.sysgeho.ui.ref.vue.ChrHospiVue;

public class ChrHospiCtrl extends SysGehoCtrl<TabChrHospi, TabChrHospi>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "chrHospiCtrl";
	
	public ChrHospiCtrl(){		
		defaultVue = new ChrHospiVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabChrHospi> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoChrHospi();
	}
	
	public Class<ChrHospiCtrl> getMyClass() {
		return ChrHospiCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "ChrHospiDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "ChrHospi";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				RefTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("ChrHospi")) ;
		}	
	}

	@Override
	public List<TabChrHospi> rechercherParCritere(TabChrHospi p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoChrHospi().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	

}
