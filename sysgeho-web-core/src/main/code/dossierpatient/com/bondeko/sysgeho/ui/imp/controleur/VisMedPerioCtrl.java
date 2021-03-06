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
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.VisMedPerioVue;

public class VisMedPerioCtrl extends SysGehoCtrl<TabVisMedPerio, TabVisMedPerio>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "visMedPerioCtrl";
	
	public VisMedPerioCtrl(){		
		defaultVue = new VisMedPerioVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabVisMedPerio> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoVisMedPerio();
	}
	
	public Class<VisMedPerioCtrl> getMyClass() {
		return VisMedPerioCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "VisMedPerioDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "VisMedPerio";

		System.out.println("VisMedPerioCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_VIS_MED_PERIO.getKey(), new Traitement(DossierPatientTrt.VALIDER_VIS_MED_PERIO));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_RAP_VIS_MED_PERIO.getKey(), new Traitement(DossierPatientTrt.ENREG_RAP_VIS_MED_PERIO));
		
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
		
		Traitement v$traitement = new Traitement(
				DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_PERIO.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_PERIO);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("VisMedPerio")) ;
		}
	}
	
	@Override
	public List<TabVisMedPerio> rechercherParCritere(TabVisMedPerio p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoVisMedPerio().rechercherParCritere(p$entity);
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
		 * 	1-Cette m�thode suppose que le controleur est bel et bien dans le Scope Session
		 * 	2-Par ailleurs il devrait normalement d�ja exist� du fait du passage de param�tres dans la page web
		 */
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));

		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_CONSULTATION
				.naviguerVersFormulaireListe())) {
			
			TabConsul consul = new TabConsul();
			consul.initData();
			consul.setTabVisMedPerio(defaultVue.getEntiteCourante());

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
			hospi.setTabVisMedPerio(defaultVue.getEntiteCourante());

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
			exam.setTabVisMedPerio(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(exam);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_DE_VM_VERS_SOIN
				.naviguerVersFormulaireListe())) {
			
			TabSoin soin = new TabSoin();
			soin.initData();
			soin.setTabVisMedPerio(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(soin);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (v$navigation.equals(DossierPatientTrt.NAVIGUER_VERS_RAP_VIS_MED_PERIO
				.naviguerVersFormulaireListe())) {
			
			TabRapVisMedPerio rapVisMed = new TabRapVisMedPerio();
			rapVisMed.initData();
			rapVisMed.setTabVisMedPerio(defaultVue.getEntiteCourante());

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

		// Nom de la propri�t� � mettre � jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabUsr")) {
			TabUsr v$entite = (TabUsr) p$entite;
			defaultVue.getEntiteCourante().setTabUsr(v$entite);
		}

		if (v$propriete.equals("tabSoc")) {
			TabSoc v$entite = (TabSoc) p$entite;
			defaultVue.getEntiteCourante().setTabSoc(v$entite);
		}

	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "La Visite m�dicale p�riodique n� ";

		try {

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabVisMedPerio entity = defaultVue.getEntiteCourante();
			if(entity.getBooEstVal() != null && entity.getBooEstVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'ex�cuter le traitement Valider pour cette visite m�dicale");
				return null;
			}
			
			// Consommation de l'EJB distant selon l'operation sp�cifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoVisMedPerio()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodVisMedPerio()+" a �t� valid�";

			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en VisMedPeriotation ==> sur le formulaire Details
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
			// Retour � la page ad�quate
			return v$navigation;
		}
	}
	
	@SuppressWarnings({ "finally", "unchecked" })
	public String enregistrerRapport() {
		
		String v$navigation = null;
		
		try {
			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			if(defaultVue.getEntiteCourante().getBooEstVal().equals(BigDecimal.ZERO)){
				FacesUtil.addWarnMessage("", "Impossible d'enregistrer le rapport de cette visite m�dicale, Bien vouloir valider cette visite ");
				return null;
			}
			
			RapVisMedPerioCtrl rapVisMedPerioCtrl = (RapVisMedPerioCtrl) FacesUtil
			.getSessionMapValue(new RapVisMedPerioCtrl().getNomManagedBean2());

			if (rapVisMedPerioCtrl == null) {
				rapVisMedPerioCtrl = new RapVisMedPerioCtrl();
				
				FacesUtil.setSessionMapValue(rapVisMedPerioCtrl.getNomManagedBean2(), rapVisMedPerioCtrl);
			}
			
			TabVisMedPerio visMedPerio = getDefaultVue().getEntiteCourante();
			
			TabRapVisMedPerio rapVisMedPerio = new TabRapVisMedPerio(visMedPerio.getInfoUser());
			rapVisMedPerio.setTabVisMedPerio(visMedPerio);		
			rapVisMedPerioCtrl.getDefaultVue().setEntiteCourante(rapVisMedPerio);
			rapVisMedPerioCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "RapVisMedPerioEdition";
//		finally {
//			// Retour � la page ad�quate
//			return v$navigation;
//		}
	}
	
}
