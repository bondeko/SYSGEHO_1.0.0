/**
 * 
 */
package com.bondeko.sysgeho.ui.fac.controleur;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedPerio;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ModalManager;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.fac.util.FactureSvcoDeleguate;
import com.bondeko.sysgeho.ui.fac.util.FactureTrt;
import com.bondeko.sysgeho.ui.imp.vue.FacVisMedPerioVue;


public class FacVisMedPerioCtrl extends SysGehoCtrl<TabFacVisMedPerio, TabFacVisMedPerio> {


	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "facVisMedPerioCtrl";	

	public FacVisMedPerioCtrl() {
		defaultVue = new FacVisMedPerioVue();					
	}

	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public static String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabFacVisMedPerio> getEntitySvco() throws ServiceLocatorException{	
		return FactureSvcoDeleguate.getSvcoFacVisMedPerio();
	}
	
	public Class<FacVisMedPerioCtrl> getMyClass() {
		return FacVisMedPerioCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "FacConvDetails";
	}
	
	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "FacVisMedPerio";

		System.out.println("FacVisMedPerioCtrl.getListeTraitements() ici il vaut : " + v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				FactureTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(FactureTrt.VALIDER_FACTURE_VM_PERIO.getKey(), new Traitement(FactureTrt.VALIDER_FACTURE_VM_PERIO));
		
		v$mapTrt.put(FactureTrt.PAYER_FACTURE_VM_PERIO.getKey(), new Traitement(FactureTrt.PAYER_FACTURE_VM_PERIO));
		
		v$mapTrt.put(FactureTrt.FAC_VM_AJOUT_PCE.getKey(), new Traitement(FactureTrt.FAC_VM_AJOUT_PCE));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(FactureTrt.getTrtStandards("FacVisMedPerio")) ;
		}
	}
	
	@Override
	public List<TabFacVisMedPerio> rechercherParCritere(TabFacVisMedPerio p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return FactureSvcoDeleguate.getSvcoFacConv().rechercherParCritere(p$entity);
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
		String v$msgDetails = "La Facture Référence n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabFacVisMedPerio entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'exécuter le traitement Valider sur cette facture");
				return null;
			}
			
			if(entity.getBooPaie() != null && entity.getBooPaie().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Impossible de valider une facture déjà payée");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(FactureSvcoDeleguate.getSvcoFacVisMedPerio()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getRefFacVisMedPerio()+" a été validé";

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
	
	@SuppressWarnings("finally")
	public String payer() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "La Facture Référence n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(FactureSvcoDeleguate.getSvcoFacVisMedPerio()
					.payer(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getRefFacVisMedPerio()+" a été payé";

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
	
	@Override
	public void coherenceIHM() {
		
		FacVisMedPerioVue v$vue = (FacVisMedPerioVue) defaultVue;
		
				
		/*
		 * MISE A JOUR DE LA LISTE DES PIECES JOINTES
		 */
		TabFacVisMedPerio v$facture = v$vue.getEntiteCourante();		
		try{	
			// Recherche Par ID pour récupérer le lot Documentaire à jour contenant les Pièces jointes
			v$facture = FactureSvcoDeleguate.getSvcoFacVisMedPerio().rechercher(FacVisMedPerioVue.getTabFacVisMedPerioForSearch(),v$vue.getEntiteCourante().getId());			
			v$facture = (v$facture == null)? v$vue.getEntiteCourante() : v$facture ;
		}
		
		catch(Exception ex){
			// Si Exception alors ne rien faire 
			getLogger().error(ex.getMessage(),ex);			
		}	
		finally{
			
			TabLotDoc v$lotDoc = v$facture.getTabLotDoc(); 			
			if(v$lotDoc != null){
				if(v$lotDoc.getTabPceJtes() != null){
					v$vue.getPieceMgr().setListeRecherche(new ArrayList<TabPceJte>(v$lotDoc.getTabPceJtes()));	
				}
				else{
					v$vue.getPieceMgr().setListeRecherche(new ArrayList<TabPceJte>());
				}
			}
			else{
				v$vue.getPieceMgr().setListeRecherche(new ArrayList<TabPceJte>());
			}									
		}
			
	}
	
	@SuppressWarnings("finally")
	public String ajouterPceJte(){
				
		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;
			
		// Message d'information
		String v$msgDetails = "La facture ";
				
		try{
			
			// Mise à jour de l'entité courante selon le contexte du Formulaire 
			if(defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr().getEntiteSelectionne());
			
			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
						
			// Ajout de la pièce jointe
			//defaultVue.getEntiteCourante().addNewPiece(((BdgVue)defaultVue).getPiece());
			defaultVue.getEntiteCourante().addNewPiece(ModalManager.getManagedBeanInstance().getPceJte());
								
			// Consommation du service distant							
			defaultVue.setEntiteCourante(FactureSvcoDeleguate.getSvcoFacVisMedPerio().ajouterPieceJte(defaultVue.getEntiteCourante()));	
														
			//v$msgDetails = "Une nouvelle pièce jointe  [De Référence : " + ((BdgVue)defaultVue).getPiece().getLRefPce()+ " ] a été ajoutée";
			v$msgDetails = "Une nouvelle pièce jointe  [De Référence : " + ModalManager.getManagedBeanInstance().getPceJte().getLRefPce()+ " ] a été ajoutée";	
			
			// L'on remplace l'ancienne entité de la liste par la nouvelle issue du résultat du traitement spécifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(), defaultVue.getEntiteCourante());

			// Si nous sommes en Consultation ==> sur le formulaire Details
			if(defaultVue.getNavigationMgr().isFromDetails()){
				// Traitements particuliers													
			}
			
			// Par contre si nous sommes sur le formulaire Liste 
			else if(defaultVue.getNavigationMgr().isFromListe()){							
				// Traitements particuliers		
			}	
			
			FacesUtil.addInfoMessage("", v$msgDetails);			
			
		}
		catch (Exception e) {
			// Aucune navigation possible
			v$navigation = null;
			
			//Message utilisateur
			FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC", "MSG_TRT_ALL_ECHEC_INCONNU");		
			e.printStackTrace();
			getLogger().error(e.getMessage(), e);	
		}			
		finally {						
			// Retour à la page adéquate	
			return v$navigation;
		}				
	}		
	
	/**
	 * Pré-traitements effectués avant l'affichage du Modal Panel
	 * Utile pour faire les configurations préalables au niveau du gestionnaire de Modal Panel
	 * 
	 * @return
	 */
	public String ajouterPceJtePreModal(){
				
		
		// Référence du gestionnaire de modal Panel
		ModalManager v$modalMgr = ModalManager.getManagedBeanInstance();
		
		/*
		 * Initialisation des informations
		 */		
		v$modalMgr.setTitre("Ajouter une nouvelle pièce jointe");	// Titre du modal panel
		v$modalMgr.setClientCtrlName(getNomManagedBean());		// Nom du controleur utilisant le gestionnaire de modal panel
		v$modalMgr.setMethode("ajouterPceJte");	// Méthode a exécuter par le gestionnaire de modal panel
		Map<String, String> v$typePieces = new TreeMap<String, String>();
		v$typePieces.put("Justificative", "10801");	// Type des pièce jointes à afficher
		v$modalMgr.setTypesFichier(v$typePieces);
		
		return null;					
	}	


}
