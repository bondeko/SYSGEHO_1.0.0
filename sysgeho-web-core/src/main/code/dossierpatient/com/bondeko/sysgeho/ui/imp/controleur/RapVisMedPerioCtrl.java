package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
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
import com.bondeko.sysgeho.ui.imp.vue.RapVisMedPerioVue;

public class RapVisMedPerioCtrl extends SysGehoCtrl<TabRapVisMedPerio, TabRapVisMedPerio>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "rapVisMedPerioCtrl";
	
	public RapVisMedPerioCtrl(){		
		defaultVue = new RapVisMedPerioVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabRapVisMedPerio> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoRapVisMedPerio();
	}
	
	public Class<RapVisMedPerioCtrl> getMyClass() {
		return RapVisMedPerioCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "RapVisMedPerioDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "RapVisMedPerio";

		System.out.println("RapVisMedPerioCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_RAP_VIS_MED_PERIO.getKey(), new Traitement(DossierPatientTrt.VALIDER_RAP_VIS_MED_PERIO));
		
		v$mapTrt.put(DossierPatientTrt.GENERER_RAP_VIS_MED_PERIO.getKey(), new Traitement(DossierPatientTrt.GENERER_RAP_VIS_MED_PERIO));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("RapVisMedPerio")) ;
		}
	}
	
	@Override
	public List<TabRapVisMedPerio> rechercherParCritere(TabRapVisMedPerio p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoRapVisMedPerio().rechercherParCritere(p$entity);
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

		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propri�t� � mettre � jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabVisMedPerio")) {
			TabVisMedPerio v$entite = (TabVisMedPerio) p$entite;
			defaultVue.getEntiteCourante().setTabVisMedPerio(v$entite);
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
		String v$msgDetails = "Le rapport de la visite m�dicale n� ";

		try {

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabRapVisMedPerio entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'ex�cuter le traitement Valider pour ce rapport de visite m�dicale");
				return null;
			}
			// Consommation de l'EJB distant selon l'operation sp�cifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoRapVisMedPerio()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getTabVisMedPerio().getCodVisMedPerio()+" a �t� valid�";

			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
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
			// Retour � la page ad�quate
			return v$navigation;
		}
	}
	
	/**
	 * G�n�re un rapport de VM
	 * 
	 * @return un message  sur l'�tat de l'op�ration
	 */
	@SuppressWarnings("finally")
	public String genererRapportVM() {
	// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			RapVisMedPerioVue v$vue = (RapVisMedPerioVue) defaultVue;

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Sp�cification du type de g�n�ration du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabRapVisMedPerio rapport = defaultVue.getEntiteCourante();
			
			
			EntFichier v$fichier = DossierPatientSvcoDeleguate.getSvcoRapVisMedPerio().genererRapportVM(rapport);

			// cr�ation de dossier et fichiers temporaires et affichage de
			// l'�tat g�n�r�
			v$navigation = preview(v$fichier, outputType.getExtension());
			
			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
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
			// Retour � la page ad�quate
			return v$navigation;
		}

	}
	
}
