package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCertMed;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.OutputType;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.CertMedVue;
import com.bondeko.sysgeho.ui.imp.vue.PatVue;

public class CertMedCtrl extends SysGehoCtrl<TabCertMed, TabCertMed>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "certMedCtrl";
	
	
	
	public CertMedCtrl(){		
		defaultVue = new CertMedVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabCertMed> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoCertMed();
	}
	
	public Class<CertMedCtrl> getMyClass() {
		return CertMedCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "CertMedDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "CertMed";

		System.out.println("CertMedCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.GENERER_CERT_MED.getKey(), new Traitement(DossierPatientTrt.GENERER_CERT_MED));
//		
//		v$mapTrt.put(DossierPatientTrt.ENREG_CPTE_RENDU.getKey(), new Traitement(DossierPatientTrt.ENREG_CPTE_RENDU));
//		
//		Traitement v$traitement = new Traitement(
//				DossierPatientTrt.NAVIGUER_CPTE_RENDU.naviguerVersFormulaireDetails(),
//				DossierPatientTrt.NAVIGUER_CPTE_RENDU);
//		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("CertMed")) ;
		}
	}
	
	@Override
	public List<TabCertMed> rechercherParCritere(TabCertMed p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoCertMed().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

//		if (v$propriete.equals("tabUsr")) {
//			TabUsr v$entite = (TabUsr) p$entite;
//			defaultVue.getEntiteCourante().setTabUsr(v$entite);
//		}

		if (v$propriete.equals("tabPat")) {
			TabPat v$entite = (TabPat) p$entite;
			defaultVue.getEntiteCourante().setTabPat(v$entite);
		}
		
		if (v$propriete.equals("tabUsr")) {
			TabUsr v$entite = (TabUsr) p$entite;
			defaultVue.getEntiteCourante().setTabUsr(v$entite);
		}
		
		if (v$propriete.equals("tabVisMedEmb")) {
			TabVisMedEmb v$entite = (TabVisMedEmb) p$entite;
			defaultVue.getEntiteCourante().setTabVisMedEmb(v$entite);
		}
		
		if (v$propriete.equals("tabVisMedPerio")) {
			TabVisMedPerio v$entite = (TabVisMedPerio) p$entite;
			defaultVue.getEntiteCourante().setTabVisMedPerio(v$entite);
		}

	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "Le Certificat Medical n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabCertMed entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'exécuter le traitement Valider pour ce certificat");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoCertMed()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodCertMed()+" a été validé";

			// L'on remplace l'ancienne entité de la liste par la nouvelle issue
			// du résultat du traitement spécifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en CertMedtation ==> sur le formulaire Details
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
	 * @return un message  sur l'état de l'opération
	 */
	@SuppressWarnings("finally")
	public String genererCertMed() {
	// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			CertMedVue v$vue = (CertMedVue) defaultVue;

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Spécification du type de génération du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabCertMed certMed = defaultVue.getEntiteCourante();
			
			
			EntFichier v$fichier = DossierPatientSvcoDeleguate.getSvcoCertMed().genererEtatCertMed(certMed);

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
