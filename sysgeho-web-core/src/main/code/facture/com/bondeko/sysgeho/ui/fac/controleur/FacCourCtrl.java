/**
 * 
 */
package com.bondeko.sysgeho.ui.fac.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.event.ActionEvent;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.fac.util.FactureSvcoDeleguate;
import com.bondeko.sysgeho.ui.fac.util.FactureTrt;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.vue.ConsulVue;
import com.bondeko.sysgeho.ui.imp.vue.ExamVue;
import com.bondeko.sysgeho.ui.imp.vue.FacCourVue;
import com.bondeko.sysgeho.ui.imp.vue.HospiVue;
import com.bondeko.sysgeho.ui.imp.vue.SoinVue;


public class FacCourCtrl extends SysGehoCtrl<TabFacCour, TabFacCour> {


	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "facCourCtrl";	

	public FacCourCtrl() {
		defaultVue = new FacCourVue();					
	}

	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public static String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabFacCour> getEntitySvco() throws ServiceLocatorException{	
		return FactureSvcoDeleguate.getSvcoFacCour();
	}
	
	public Class<FacCourCtrl> getMyClass() {
		return FacCourCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "FacCourDetails";
	}
	
	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "FacCour";

		System.out.println("FacCourCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				FactureTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(FactureTrt.VALIDER_FACTURE_COURANTE.getKey(), new Traitement(FactureTrt.VALIDER_FACTURE_COURANTE));
		
		v$mapTrt.put(FactureTrt.PAYER_FACTURE_COURANTE.getKey(), new Traitement(FactureTrt.PAYER_FACTURE_COURANTE));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(FactureTrt.getTrtStandards("FacCour")) ;
		}
	}
	
	@Override
	public List<TabFacCour> rechercherParCritere(TabFacCour p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return FactureSvcoDeleguate.getSvcoFacCour().rechercherParCritere(p$entity);
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

		if (v$propriete.equals("tabPat")) {
			TabPat v$entite = (TabPat) p$entite;
			defaultVue.getEntiteCourante().setTabPat(v$entite);
		}

	}

	@Override
	public void coherenceIHM() {

		super.coherenceIHM();

		FacCourVue v$vue = (FacCourVue) defaultVue;		


		/**
		 * Mise à jour de la liste  des titres de paiement pris en charge
		 */
		TabFacCour v$facCour = v$vue.getEntiteCourante();

		TabConsul v$tabConsul = ConsulVue.getTabConsulForSearch();
		TabHospi v$tabHospi = HospiVue.getTabHospiForSearch();
		TabExam v$tabExam = ExamVue.getTabExamForSearch();
		TabSoin v$tabSoin = SoinVue.getTabSoinForSearch();

		try{
			getLogger().debug("coherenceIHM()");
			if(v$facCour.getRefFacCour()!=null && !v$facCour.getRefFacCour().trim().isEmpty()){
				getLogger().debug("coherenceIHM()"+v$facCour.getRefFacCour());
				//Consultation
				List<TabConsul> v$listTabConsul = DossierPatientSvcoDeleguate.getSvcoConsul().rechercherParRefFac(v$facCour.getRefFacCour());
				if(v$listTabConsul.size()!=0){
					getLogger().debug("v$v$listTabConsul"+v$listTabConsul.size());
					v$vue.getConsulRechercheMgr().setListeRecherche(v$listTabConsul);
				}else{
					v$vue.getConsulRechercheMgr().setListeRecherche(new ArrayList<TabConsul>());
				}
				//Hospitalisation
				List<TabHospi> v$listTabHospi = DossierPatientSvcoDeleguate.getSvcoHospi().rechercherParRefFac(v$facCour.getRefFacCour());
				if(v$listTabHospi.size()!=0){
					getLogger().debug("v$v$v$listTabHospi"+v$listTabHospi.size());
					v$vue.getHospiRechercheMgr().setListeRecherche(v$listTabHospi);
				}else{
					v$vue.getHospiRechercheMgr().setListeRecherche(new ArrayList<TabHospi>());
				}
				//Examen
				List<TabExam> v$listTabExam = DossierPatientSvcoDeleguate.getSvcoExam().rechercherParRefFac(v$facCour.getRefFacCour());
				if(v$listTabExam.size()!=0){
					getLogger().debug("v$v$v$v$listTabExam"+v$listTabExam.size());
					v$vue.getExamRechercheMgr().setListeRecherche(v$listTabExam);
				}else{
					v$vue.getExamRechercheMgr().setListeRecherche(new ArrayList<TabExam>());
				}
				//Soin
				List<TabSoin> v$listTabSoin = DossierPatientSvcoDeleguate.getSvcoSoin().rechercherParRefFac(v$facCour.getRefFacCour());
				if(v$listTabSoin.size()!=0){
					getLogger().debug("v$v$v$v$listTabSoin"+v$listTabSoin.size());
					v$vue.getSoinRechercheMgr().setListeRecherche(v$listTabSoin);
				}else{
					v$vue.getSoinRechercheMgr().setListeRecherche(new ArrayList<TabSoin>());
				}
			}else{
				v$vue.getConsulRechercheMgr().setListeRecherche(new ArrayList<TabConsul>());
				v$vue.getHospiRechercheMgr().setListeRecherche(new ArrayList<TabHospi>());
				v$vue.getExamRechercheMgr().setListeRecherche(new ArrayList<TabExam>());
				v$vue.getSoinRechercheMgr().setListeRecherche(new ArrayList<TabSoin>());
				
				v$vue.getConsulAPayerMgr().setListeRecherche(new ArrayList<TabConsul>());
				v$vue.getHospiAPayerMgr().setListeRecherche(new ArrayList<TabHospi>());
				v$vue.getExamAPayerMgr().setListeRecherche(new ArrayList<TabExam>());
				v$vue.getSoinAPayerMgr().setListeRecherche(new ArrayList<TabSoin>());

			}
		}	
		catch(Exception ex){
			// Si Exception alors ne rien faire 
			getLogger().error(ex.getMessage(),ex);			
		}	

	}

	@Override
	public void preEnregistrer() throws DataValidationException {

		super.preEnregistrer();
		FacCourVue v$vue = (FacCourVue) defaultVue;		

		// MAJ de la liste des prestations pris pour facturation
		//Consultation
		List<TabConsul> v$ConsulPrisPourPaie = new ArrayList<TabConsul>();
		v$ConsulPrisPourPaie = v$vue.getConsulAPayerMgr().getListeRecherche();
		//Hospitalisation
		List<TabHospi> v$HospiPrisPourPaie = new ArrayList<TabHospi>();
		v$HospiPrisPourPaie = v$vue.getHospiAPayerMgr().getListeRecherche();
		//Examen
		List<TabExam> v$ExamPrisPourPaie = new ArrayList<TabExam>();
		v$ExamPrisPourPaie = v$vue.getExamAPayerMgr().getListeRecherche();
		//Soin
		List<TabSoin> v$SoinPrisPourPaie = new ArrayList<TabSoin>();
		v$SoinPrisPourPaie = v$vue.getSoinAPayerMgr().getListeRecherche();
		
		v$vue.getEntiteCourante().setListConsulFac(v$ConsulPrisPourPaie);
		v$vue.getEntiteCourante().setListHospiFac(v$HospiPrisPourPaie);
		v$vue.getEntiteCourante().setListExamFac(v$ExamPrisPourPaie);
		v$vue.getEntiteCourante().setListSoinFac(v$SoinPrisPourPaie);

	}

	/**
	 * Recherche des consultations non payer pour facturation dans le Formulaire d'Edition 
	 * Recherche intégrant la pagination
	 * @param evt : Evènement envoyé par le l'objet graphique (Bouton, lien)
	 */
	public void  rechercherConsul(ActionEvent evt){

		FacCourVue v$vue = (FacCourVue)defaultVue;
		try{		

			TabConsul v$consul = ConsulVue.getTabConsulForSearch();

			// Désactivation de la pagination
			v$consul.setOffset(-1);
			v$consul.setMaxRow(-1);

			// Nombre total d'éléménts de la requete de Recherche
			long v$total = DossierPatientSvcoDeleguate.getSvcoConsul().rechercherTout(v$consul).size();


			// Définition de la plage pour la pagination
			v$consul.setOffset(1);
			v$consul.setMaxRow(200);
//			v$consul.setMaxRow(getPasPagination());

			// Recherche des consultations
			List<TabConsul> v$consulRecherche = DossierPatientSvcoDeleguate.getSvcoConsul().rechercherConsulNonPaieParPatient(v$vue.getEntiteCourante().getTabPat().getCodPat());

			// MAJ du gestionnaire des consultationsrecherches
			v$vue.getConsulRechercheMgr().setListeRecherche(v$consulRecherche);	

			// Si la liste de recherche est vide, précisez que la recherche n'a retourné aucun résultat
			if(v$consulRecherche == null || v$consulRecherche.size() == 0){
				FacesUtil.addWarnMessage("", "Aucun élément trouvé");
			}

			// Mise  à jour des informations de pagination
			v$vue.getConsulRechercheMgr().setTotalRecherche(v$total);
			v$vue.getConsulRechercheMgr().setListePagination(getListePagination(v$total, 200));

		}
		catch (Exception e) {							
			//Message utilisateur
			FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC","MSG_TRT_ALL_ECHEC_INCONNU");			
			getLogger().error(e.getMessage(), e);
		}		
	}
	
	public void  rechercherHospi(ActionEvent evt){

		FacCourVue v$vue = (FacCourVue)defaultVue;
		try{		

			TabHospi v$hospi = HospiVue.getTabHospiForSearch();

			// Désactivation de la pagination
			v$hospi.setOffset(-1);
			v$hospi.setMaxRow(-1);

			// Nombre total d'éléménts de la requete de Recherche
			long v$total = DossierPatientSvcoDeleguate.getSvcoHospi().rechercherTout(v$hospi).size();


			// Définition de la plage pour la pagination
			v$hospi.setOffset(1);
			v$hospi.setMaxRow(200);
//			v$consul.setMaxRow(getPasPagination());

			// Recherche des consultations
			List<TabHospi> v$hospiRecherche = DossierPatientSvcoDeleguate.getSvcoHospi().rechercherHospiNonPaieParPatient(v$vue.getEntiteCourante().getTabPat().getCodPat());

			// MAJ du gestionnaire des consultationsrecherches
			v$vue.getHospiRechercheMgr().setListeRecherche(v$hospiRecherche);	

			// Si la liste de recherche est vide, précisez que la recherche n'a retourné aucun résultat
			if(v$hospiRecherche == null || v$hospiRecherche.size() == 0){
				FacesUtil.addWarnMessage("", "Aucun élément trouvé");
			}

			// Mise  à jour des informations de pagination
			v$vue.getHospiRechercheMgr().setTotalRecherche(v$total);
			v$vue.getHospiRechercheMgr().setListePagination(getListePagination(v$total, 200));

		}
		catch (Exception e) {							
			//Message utilisateur
			FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC","MSG_TRT_ALL_ECHEC_INCONNU");			
			getLogger().error(e.getMessage(), e);
		}		
	}
	
	public void  rechercherExam(ActionEvent evt){

		FacCourVue v$vue = (FacCourVue)defaultVue;
		try{		

			TabExam v$exam = ExamVue.getTabExamForSearch();

			// Désactivation de la pagination
			v$exam.setOffset(-1);
			v$exam.setMaxRow(-1);

			// Nombre total d'éléménts de la requete de Recherche
			long v$total = DossierPatientSvcoDeleguate.getSvcoExam().rechercherTout(v$exam).size();


			// Définition de la plage pour la pagination
			v$exam.setOffset(1);
			v$exam.setMaxRow(200);
//			v$consul.setMaxRow(getPasPagination());

			// Recherche des consultations
			List<TabExam> v$examRecherche = DossierPatientSvcoDeleguate.getSvcoExam().rechercherExamNonPaieParPatient(v$vue.getEntiteCourante().getTabPat().getCodPat());

			// MAJ du gestionnaire des consultationsrecherches
			v$vue.getExamRechercheMgr().setListeRecherche(v$examRecherche);	

			// Si la liste de recherche est vide, précisez que la recherche n'a retourné aucun résultat
			if(v$examRecherche == null || v$examRecherche.size() == 0){
				FacesUtil.addWarnMessage("", "Aucun élément trouvé");
			}

			// Mise  à jour des informations de pagination
			v$vue.getExamRechercheMgr().setTotalRecherche(v$total);
			v$vue.getExamRechercheMgr().setListePagination(getListePagination(v$total, 200));

		}
		catch (Exception e) {							
			//Message utilisateur
			FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC","MSG_TRT_ALL_ECHEC_INCONNU");			
			getLogger().error(e.getMessage(), e);
		}		
	}
	
	public void  rechercherSoin(ActionEvent evt){

		FacCourVue v$vue = (FacCourVue)defaultVue;
		try{		

			TabSoin v$soin = SoinVue.getTabSoinForSearch();

			// Désactivation de la pagination
			v$soin.setOffset(-1);
			v$soin.setMaxRow(-1);

			// Nombre total d'éléménts de la requete de Recherche
			long v$total = DossierPatientSvcoDeleguate.getSvcoSoin().rechercherTout(v$soin).size();


			// Définition de la plage pour la pagination
			v$soin.setOffset(1);
			v$soin.setMaxRow(200);
//			v$consul.setMaxRow(getPasPagination());

			// Recherche des consultations
			List<TabSoin> v$soinRecherche = DossierPatientSvcoDeleguate.getSvcoSoin().rechercherSoinNonPaieParPatient(v$vue.getEntiteCourante().getTabPat().getCodPat());

			// MAJ du gestionnaire des consultationsrecherches
			v$vue.getSoinRechercheMgr().setListeRecherche(v$soinRecherche);	

			// Si la liste de recherche est vide, précisez que la recherche n'a retourné aucun résultat
			if(v$soinRecherche == null || v$soinRecherche.size() == 0){
				FacesUtil.addWarnMessage("", "Aucun élément trouvé");
			}

			// Mise  à jour des informations de pagination
			v$vue.getSoinRechercheMgr().setTotalRecherche(v$total);
			v$vue.getSoinRechercheMgr().setListePagination(getListePagination(v$total, 200));

		}
		catch (Exception e) {							
			//Message utilisateur
			FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC","MSG_TRT_ALL_ECHEC_INCONNU");			
			getLogger().error(e.getMessage(), e);
		}		
	}

	public String selectionnerConsul(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabConsul v$detail  = v$vue.getConsulRechercheMgr().getSelectedEntity();
		// Ajouter dans la liste des consul a payer
		v$vue.getConsulAPayerMgr().add(v$detail);	
		// Supression
		v$vue.getConsulRechercheMgr().remove(v$detail);			
		return null;
	}
	
	public String selectionnerHospi(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabHospi v$detail  = v$vue.getHospiRechercheMgr().getSelectedEntity();
		// Ajouter dans la liste des consul a payer
		v$vue.getHospiAPayerMgr().add(v$detail);	
		// Supression
		v$vue.getHospiRechercheMgr().remove(v$detail);			
		return null;
	}
	
	public String selectionnerExam(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabExam v$detail  = v$vue.getExamRechercheMgr().getSelectedEntity();
		// Ajouter dans la liste des consul a payer
		v$vue.getExamAPayerMgr().add(v$detail);	
		// Supression
		v$vue.getExamRechercheMgr().remove(v$detail);			
		return null;
	}
	
	public String selectionnerSoin(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabSoin v$detail  = v$vue.getSoinRechercheMgr().getSelectedEntity();
		// Ajouter dans la liste des consul a payer
		v$vue.getSoinAPayerMgr().add(v$detail);	
		// Supression
		v$vue.getSoinRechercheMgr().remove(v$detail);			
		return null;
	}

	/**
	 * Supprimer une consultation susceptible d'être payé
	 * @param evt
	 */
	public String  supprimerConsul(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabConsul v$consul  = v$vue.getConsulAPayerMgr().getSelectedEntity();
		v$vue.getConsulAPayerMgr().remove(v$consul);
		return null;
	}
	
	public String  supprimerHospi(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabHospi v$hospi  = v$vue.getHospiAPayerMgr().getSelectedEntity();
		v$vue.getHospiAPayerMgr().remove(v$hospi);
		return null;
	}
	
	public String  supprimerExam(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabExam v$exam  = v$vue.getExamAPayerMgr().getSelectedEntity();
		v$vue.getExamAPayerMgr().remove(v$exam);
		return null;
	}
	
	public String  supprimerSoin(){
		FacCourVue v$vue = (FacCourVue)defaultVue;
		TabSoin v$soin  = v$vue.getSoinAPayerMgr().getSelectedEntity();
		v$vue.getSoinAPayerMgr().remove(v$soin);
		return null;
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

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(FactureSvcoDeleguate.getSvcoFacCour()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getRefFacCour()+" a été validé";

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
			defaultVue.setEntiteCourante(FactureSvcoDeleguate.getSvcoFacCour()
					.payer(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getRefFacCour()+" a été payé";

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


}
