package com.bondeko.sysgeho.ui.imp.controleur;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.OutputType;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.CpteRenduConsulVue;
import com.bondeko.sysgeho.ui.imp.vue.PatVue;

public class CpteRenduConsulCtrl extends SysGehoCtrl<TabCpteRenduConsul, TabCpteRenduConsul>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "cpteRenduConsulCtrl";
	
	public CpteRenduConsulCtrl(){		
		defaultVue = new CpteRenduConsulVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabCpteRenduConsul> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoCpteRenduConsul();
	}
	
	public Class<CpteRenduConsulCtrl> getMyClass() {
		return CpteRenduConsulCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "CpteRenduConsulDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "CpteRenduConsul";

		System.out.println("CpteRenduConsulCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_CPTE_RENDU_CONSUL.getKey(), new Traitement(DossierPatientTrt.VALIDER_CPTE_RENDU_CONSUL));
		
		v$mapTrt.put(DossierPatientTrt.GENERER_CPTE_RENDU_CONSUL.getKey(), new Traitement(DossierPatientTrt.GENERER_CPTE_RENDU_CONSUL));

		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("CpteRenduConsul")) ;
		}
	}
	
	@Override
	public List<TabCpteRenduConsul> rechercherParCritere(TabCpteRenduConsul p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoCpteRenduConsul().rechercherParCritere(p$entity);
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

		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabConsul")) {
			TabConsul v$entite = (TabConsul) p$entite;
			defaultVue.getEntiteCourante().setTabConsul(v$entite);
		}
	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "La Compte rendu de la Consultation n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoCpteRenduConsul()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getTabConsul().getCodConsul()+" a été validé";

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
	
	/**
	 * Génére un compte rendu consultation
	 * 
	 * @return un message  sur l'état de l'opération
	 */
	@SuppressWarnings("finally")
	public String genererCpteRenduCon() {
	// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			CpteRenduConsulVue v$vue = (CpteRenduConsulVue) defaultVue;

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Spécification du type de génération du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabCpteRenduConsul cpterendu = defaultVue.getEntiteCourante();
			
			
			EntFichier v$fichier = DossierPatientSvcoDeleguate.getSvcoCpteRenduConsul().genererEtatCpteRenduCon(cpterendu);

			// création de dossier et fichiers temporaires et affichage de
			// l'état généré
			v$navigation = preview(v$fichier, outputType.getExtension());
			
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
			FacesUtil.addInfoMessage("GENERATION_SUCCES", v$msgDetails);

		} catch (SysGehoAppException e) {
			// Aucune navigation possible
			v$navigation = null;

			// Message utilisateur
			FacesUtil
					.addWarnMessage("TRAITEMENT_ALL_ECHEC", e.getMessage());
			getLogger().error(e.getMessage(), e);
		} catch (Exception e) {
			// Aucune navigation possible
			e.printStackTrace();
			v$navigation = null;
			// Message utilisateur
			FacesUtil
					.addWarnMessage(
							"TRAITEMENT_ALL_ECHEC","TRAITEMENT_ALL_ECHEC_INCONNU");
			getLogger().error(e.getMessage(), e);
		} finally {
			// Retour à la page adéquate
			return v$navigation;
		}

	}


}
