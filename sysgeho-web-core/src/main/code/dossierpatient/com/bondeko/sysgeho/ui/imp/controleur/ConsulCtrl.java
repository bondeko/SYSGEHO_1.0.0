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
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.ref.entity.TabSpec;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.ConsulVue;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;

public class ConsulCtrl extends SysGehoCtrl<TabConsul, TabConsul>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "consulCtrl";
	
	public ConsulCtrl(){		
		defaultVue = new ConsulVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabConsul> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoConsul();
	}
	
	public Class<ConsulCtrl> getMyClass() {
		return ConsulCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "ConsulDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Consul";

		System.out.println("ConsulCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_CONSUL.getKey(), new Traitement(DossierPatientTrt.VALIDER_CONSUL));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_CPTE_RENDU.getKey(), new Traitement(DossierPatientTrt.ENREG_CPTE_RENDU));
		
		Traitement v$traitement = new Traitement(
				DossierPatientTrt.NAVIGUER_CPTE_RENDU.naviguerVersFormulaireDetails(),
				DossierPatientTrt.NAVIGUER_CPTE_RENDU);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Consul")) ;
		}
	}
	
	@Override
	public List<TabConsul> rechercherParCritere(TabConsul p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoConsul().rechercherParCritere(p$entity);
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
		
		System.out.println(">>>>>>>>>>>< v$navigation ==" + v$navigation);
		/*
		 * Recuperation du controleur 
		 * NB: 
		 * 	1-Cette méthode suppose que le controleur est bel et bien dans le Scope Session
		 * 	2-Par ailleurs il devrait normalement déja existé du fait du passage de paramètres dans la page web
		 */
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));

		// Si la navigation s'effectue vers le compte rendu
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_CPTE_RENDU
				.naviguerVersFormulaireDetails())) {
			
			TabCpteRenduConsul cpteRenduConsul = new TabCpteRenduConsul();
			cpteRenduConsul.initData();
			cpteRenduConsul.setTabConsul(defaultVue.getEntiteCourante());

			try {
				System.out.println(">>>>>>>>>>> " + v$controleur);
				v$navigation = v$controleur.naviguerVersDetailsOuListe(cpteRenduConsul);
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
		String v$msgDetails = "La Consultation n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoConsul()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodConsul()+" a été validé";

			// L'on remplace l'ancienne entité de la liste par la nouvelle issue
			// du résultat du traitement spécifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en Consultation ==> sur le formulaire Details
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
	public String enregistrerCpteRendu() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			if(defaultVue.getEntiteCourante().getBooVal().equals(BigDecimal.ZERO)){
				FacesUtil.addWarnMessage("", "Impossible d'enregistrer le compte rendu, Bien vouloir valider cette consultation");
				return null;
			}
			
			CpteRenduConsulCtrl cpteRenduConsulCtrl = (CpteRenduConsulCtrl) FacesUtil
			.getSessionMapValue(new CpteRenduConsulCtrl().getNomManagedBean2());

			if (cpteRenduConsulCtrl == null) {
				cpteRenduConsulCtrl = new CpteRenduConsulCtrl();
				
				FacesUtil.setSessionMapValue(cpteRenduConsulCtrl.getNomManagedBean2(), cpteRenduConsulCtrl);
			}
			
			TabConsul consul = getDefaultVue().getEntiteCourante();
			
			TabCpteRenduConsul cpteRenduConsul = new TabCpteRenduConsul(consul.getInfoUser());
			cpteRenduConsul.setTabConsul(consul);		
			cpteRenduConsulCtrl.getDefaultVue().setEntiteCourante(cpteRenduConsul);
			cpteRenduConsulCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "CpteRenduConsulEdition";
//		finally {
//			// Retour à la page adéquate
//			return v$navigation;
//		}
	}
	
	public void coherenceIHM(){
		
		try {
				TabConsul consul= defaultVue.getEntiteCourante();
				if(consul != null && consul.getCodSpec()!=null){
					TabSpec spec = RefSvcoDeleguate.getSvcoSpec().rechercher(new TabSpec(), consul.getCodSpec());
				}
			} catch (SysGehoAppException e) {
				e.printStackTrace();
			} catch (ServiceLocatorException e) { 
				e.printStackTrace();
			}
	}
	
}
