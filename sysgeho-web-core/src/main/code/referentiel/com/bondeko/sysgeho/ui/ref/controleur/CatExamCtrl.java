package com.bondeko.sysgeho.ui.ref.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.ref.entity.TabCatExam;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;
import com.bondeko.sysgeho.ui.ref.vue.CatExamVue;

public class CatExamCtrl extends SysGehoCtrl<TabCatExam, TabCatExam>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "catExamCtrl";
	
	public CatExamCtrl(){		
		defaultVue = new CatExamVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabCatExam> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoCatExam();
	}
	
	public Class<CatExamCtrl> getMyClass() {
		return CatExamCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "CatExamDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "CatExam";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				RefTrt.getTrtStandards(v$codeEntite));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("CatExam")) ;
		}	
	}

	@Override
	public List<TabCatExam> rechercherParCritere(TabCatExam p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoCatExam().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}

}
