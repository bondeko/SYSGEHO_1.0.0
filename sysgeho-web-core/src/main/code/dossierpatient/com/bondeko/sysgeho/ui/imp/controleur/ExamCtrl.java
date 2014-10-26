package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabTypExam;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.ExamVue;

public class ExamCtrl extends SysGehoCtrl<TabExam, TabExam>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "examCtrl";
	
	public ExamCtrl(){		
		defaultVue = new ExamVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabExam> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoExam();
	}
	
	public Class<ExamCtrl> getMyClass() {
		return ExamCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "ExamDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Exam";

		System.out.println("ExamCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		v$mapTrt.put(DossierPatientTrt.VALIDER_EXAM.getKey(), new Traitement(DossierPatientTrt.VALIDER_EXAM));
		v$mapTrt.put(DossierPatientTrt.ENREG_CPTE_RENDU_EXAM.getKey(), new Traitement(DossierPatientTrt.ENREG_CPTE_RENDU_EXAM));
		
		Traitement v$traitement = new Traitement(
				DossierPatientTrt.NAVIGUER_CPTE_RENDU_EXAM.naviguerVersFormulaireDetails(),
				DossierPatientTrt.NAVIGUER_CPTE_RENDU_EXAM);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Exam")) ;
		}
	}
	
	@Override
	public List<TabExam> rechercherParCritere(TabExam p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoExam().rechercherParCritere(p$entity);
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

		// Si la navigation s'effectue vers le compte rendu
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_CPTE_RENDU_EXAM
				.naviguerVersFormulaireDetails())) {
			
			TabCpteRenduExam cpteRenduExam = new TabCpteRenduExam();
			cpteRenduExam.initData();
			cpteRenduExam.setTabExam(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(cpteRenduExam);
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

		if (v$propriete.equals("tabTypExam")) {
			TabTypExam v$entite = (TabTypExam) p$entite;
			defaultVue.getEntiteCourante().setTabTypExam(v$entite);
			defaultVue.getEntiteCourante().setValMntTtc(v$entite.getValCout());
		}

		if (v$propriete.equals("tabPat")) {
			TabPat v$entite = (TabPat) p$entite;
			defaultVue.getEntiteCourante().setTabPat(v$entite);
		}
		
		if (v$propriete.equals("tabVisMedEmb")) {
			TabVisMedEmb v$entite = (TabVisMedEmb) p$entite;
			defaultVue.getEntiteCourante().setTabVisMedEmb(v$entite);
		}
		
		if (v$propriete.equals("tabVisMedPerio")) {
			TabVisMedPerio v$entite = (TabVisMedPerio) p$entite;
			defaultVue.getEntiteCourante().setTabVisMedPerio(v$entite);
		}
		
		if (v$propriete.equals("tabUsr")) {
			TabUsr v$entite = (TabUsr) p$entite;
			defaultVue.getEntiteCourante().setTabUsr(v$entite);
		}

	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "L'Examen n° ";

		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabExam entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'exécuter le traitement Valider pour cet examen");
				return null;
			}
			
			if(entity.getBooPaie() != null && entity.getBooPaie().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Impossible de valider un examen déjà payé");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoExam()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodExam()+" a été validé";

			// L'on remplace l'ancienne entité de la liste par la nouvelle issue
			// du résultat du traitement spécifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en Examtation ==> sur le formulaire Details
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
			
			if(defaultVue.getEntiteCourante().getBooCpteRendu().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Il existe déjà un compte rendu pour l'Examen "+ defaultVue.getEntiteCourante().getCodExam());
				return null;
			}
			
			if(defaultVue.getEntiteCourante().getBooVal().equals(BigDecimal.ZERO)){
				FacesUtil.addWarnMessage("", "Impossible d'enregistrer le compte rendu, Bien vouloir valider cet examen");
				return null;
			}
			
			CpteRenduExamCtrl cpteRenduExamCtrl = (CpteRenduExamCtrl) FacesUtil
			.getSessionMapValue(new CpteRenduExamCtrl().getNomManagedBean2());

			if (cpteRenduExamCtrl == null) {
				cpteRenduExamCtrl = new CpteRenduExamCtrl();
				
				FacesUtil.setSessionMapValue(cpteRenduExamCtrl.getNomManagedBean2(), cpteRenduExamCtrl);
			}
			
			TabExam exam = getDefaultVue().getEntiteCourante();
			
			TabCpteRenduExam cpteRenduExam = new TabCpteRenduExam(exam.getInfoUser());
			cpteRenduExam.setTabExam(exam);		
			cpteRenduExamCtrl.getDefaultVue().setEntiteCourante(cpteRenduExam);
			cpteRenduExamCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "CpteRenduExamEdition";
	}
	
	public void preEnregistrer() throws DataValidationException {
		ExamVue vue = (ExamVue)defaultVue;
		TabExam exam= defaultVue.getEntiteCourante();
		if(vue.isVisEmb() && exam.getTabPat()!=null && exam.getTabVisMedEmb()!= null 
				&& exam.getTabVisMedEmb().getTabPat() != null 
				&& !exam.getTabVisMedEmb().getTabPat().getCodPat().equals(exam.getTabPat().getCodPat())){
			throw new DataValidationException("Données invalides : La visite médicale source n'est pas celui du patient sélectionné");
		}
		if(vue.isVisPerio() && exam.getTabPat()!= null && exam.getTabVisMedPerio()!= null 
				&& exam.getTabVisMedPerio().getTabSoc() != null && exam.getTabPat().getTabSoc() != null 
				&& !exam.getTabVisMedPerio().getTabSoc().getCodSoc().equals(exam.getTabPat().getTabSoc().getCodSoc())){
			throw new DataValidationException("Données invalides : La société de la visite médicale source ne correspond pas à celui du patient sélectionné");
		}
	}
	
}
