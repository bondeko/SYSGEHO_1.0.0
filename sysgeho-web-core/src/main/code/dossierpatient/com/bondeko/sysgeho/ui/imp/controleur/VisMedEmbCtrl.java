package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.VisMedEmbVue;

public class VisMedEmbCtrl extends SysGehoCtrl<TabVisMedEmb, TabVisMedEmb>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "visMedEmbCtrl";
	
	public VisMedEmbCtrl(){		
		defaultVue = new VisMedEmbVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabVisMedEmb> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoVisMedEmb();
	}
	
	public Class<VisMedEmbCtrl> getMyClass() {
		return VisMedEmbCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "VisMedEmbDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "VisMedEmb";

		System.out.println("VisMedEmbCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_VIS_MED_EMB.getKey(), new Traitement(DossierPatientTrt.VALIDER_VIS_MED_EMB));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_RAP_VIS_MED_EMB.getKey(), new Traitement(DossierPatientTrt.ENREG_RAP_VIS_MED_EMB));
		
		Traitement v$traitement2 = new Traitement(
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_CONSULTATION.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_CONSULTATION);
		v$mapTrt.put(v$traitement2.getKey(), v$traitement2);
		
		Traitement v$traitement3 = new Traitement(
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_HOSPI.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_HOSPI);
		v$mapTrt.put(v$traitement3.getKey(), v$traitement3);
		
		Traitement v$traitement4 = new Traitement(
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_EXAMEN.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_EXAMEN);
		v$mapTrt.put(v$traitement4.getKey(), v$traitement4);
		
		Traitement v$traitement5 = new Traitement(
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_SOIN.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_DE_VM_VERS_SOIN);
		v$mapTrt.put(v$traitement5.getKey(), v$traitement5);
		
		Traitement v$traitement6 = new Traitement(
				DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_EMB.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_EMB);
		v$mapTrt.put(v$traitement6.getKey(), v$traitement6);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("VisMedEmb")) ;
		}
	}
	
	@Override
	public List<TabVisMedEmb> rechercherParCritere(TabVisMedEmb p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoVisMedEmb().rechercherParCritere(p$entity);
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
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));
		
		System.out.println("v$controleur>>>>>>> "+v$controleur);
		System.out.println("v$v$navigation>>>>>>> "+v$navigation);
		
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_CONSULTATION
				.naviguerVersFormulaireListe())) {
			
			TabConsul consul = new TabConsul();
			consul.initData();
			consul.setTabVisMedEmb(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(consul);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_HOSPI
				.naviguerVersFormulaireListe())) {
			
			TabHospi hospi = new TabHospi();
			hospi.initData();
			hospi.setTabVisMedEmb(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(hospi);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_EXAMEN
				.naviguerVersFormulaireListe())) {
			
			TabExam exam = new TabExam();
			exam.initData();
			exam.setTabVisMedEmb(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(exam);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_SOIN
				.naviguerVersFormulaireListe())) {
			
			TabSoin soin = new TabSoin();
			soin.initData();
			soin.setTabVisMedEmb(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(soin);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_EMB
				.naviguerVersFormulaireListe())) {
			
			TabRapVisMedEmb rapVisMed = new TabRapVisMedEmb();
			rapVisMed.initData();
			rapVisMed.setTabVisMedEmb(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(rapVisMed);
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

		if (v$propriete.equals("tabUsr")) {
			TabUsr v$entite = (TabUsr) p$entite;
			defaultVue.getEntiteCourante().setTabUsr(v$entite);
		}

		if (v$propriete.equals("tabPat")) {
			TabPat v$entite = (TabPat) p$entite;
			defaultVue.getEntiteCourante().setTabPat(v$entite);
		}

	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "La Visite médicale d'embauche n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabVisMedEmb entity = defaultVue.getEntiteCourante();
			if(entity.getBooEstVal() != null && entity.getBooEstVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'exécuter le traitement Valider pour cette visite médicale");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoVisMedEmb()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodVisMedEmb()+" a été validé";

			// L'on remplace l'ancienne entité de la liste par la nouvelle issue
			// du résultat du traitement spécifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en VisMedEmbtation ==> sur le formulaire Details
			if (defaultVue.getNavigationMgr().isFromDetails()) {
				// Traitements particuliers
			}

			// Par contre si nous sommes sur le formulaire Liste
			else if (defaultVue.getNavigationMgr().isFromListe()) {
				// Traitements particuliers
			}
			defaultVue.getTableMgr().updateDataModel();
			FacesUtil.addInfoMessage("", v$msgDetails);

		} catch (Exception e) {
			e.printStackTrace();
			// Aucune navigation possible
			v$navigation = null;
			getLogger().error(e.getMessage(), e);
		} finally {
			// Retour à la page adéquate
			return v$navigation;
		}
	}
	
	@SuppressWarnings({ "finally", "unchecked" })
	public String enregistrerRapport() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			if(defaultVue.getEntiteCourante().getBooRapVisMed().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Il existe déjà un rapport pour la visite médicale n° "+ defaultVue.getEntiteCourante().getCodVisMedEmb());
				return null;
			}
			
			if(defaultVue.getEntiteCourante().getBooEstVal().equals(BigDecimal.ZERO)){
				FacesUtil.addWarnMessage("", "Impossible d'enregistrer le rapport de cette visite médicale, Bien vouloir valider cette visite ");
				return null;
			}
			
			RapVisMedEmbCtrl rapVisMedEmbCtrl = (RapVisMedEmbCtrl) FacesUtil
			.getSessionMapValue(new RapVisMedEmbCtrl().getNomManagedBean2());

			if (rapVisMedEmbCtrl == null) {
				rapVisMedEmbCtrl = new RapVisMedEmbCtrl();
				
				FacesUtil.setSessionMapValue(rapVisMedEmbCtrl.getNomManagedBean2(), rapVisMedEmbCtrl);
			}
			
			TabVisMedEmb visMedEmb = getDefaultVue().getEntiteCourante();
			
			TabRapVisMedEmb rapVisMedEmb = new TabRapVisMedEmb(visMedEmb.getInfoUser());
			rapVisMedEmb.setTabVisMedEmb(visMedEmb);		
			rapVisMedEmbCtrl.getDefaultVue().setEntiteCourante(rapVisMedEmb);
			rapVisMedEmbCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "RapVisMedEmbEdition";
//		finally {
//			// Retour à la page adéquate
//			return v$navigation;
//		}
	}
	
	public String navigerVersVisMedEmb(){
		
		String v$navigation = super.gotoRelatedEntity();
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));
		
		return v$navigation;
	}
	
}
