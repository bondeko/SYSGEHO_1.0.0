package com.bondeko.sysgeho.ui.phar.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabDepart;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;
import com.bondeko.sysgeho.ui.phar.util.PharTrt;
import com.bondeko.sysgeho.ui.phar.vue.DepartVue;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;

public class DepartCtrl extends SysGehoCtrl<TabDepart, TabDepart>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "departCtrl";
	
	public DepartCtrl(){		
		defaultVue = new DepartVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabDepart> getEntitySvco() throws ServiceLocatorException{	
		return PharSvcoDeleguate.getSvcoDepart();
	}
	
	public Class<DepartCtrl> getMyClass() {
		return DepartCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "DepartDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Depart";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				PharTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("Depart")) ;
		}	
	}

	@Override
	public List<TabDepart> rechercherParCritere(TabDepart p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return PharSvcoDeleguate.getSvcoDepart().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}

}
