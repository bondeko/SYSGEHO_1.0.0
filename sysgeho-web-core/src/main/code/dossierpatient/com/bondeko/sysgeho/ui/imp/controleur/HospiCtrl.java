package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabSvc;
import com.bondeko.sysgeho.be.admin.entity.utilisateur.TabUsr;
import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabChrHospi;
import com.bondeko.sysgeho.be.ref.entity.TabLit;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.ConsulVue;
import com.bondeko.sysgeho.ui.imp.vue.HospiVue;

public class HospiCtrl extends SysGehoCtrl<TabHospi, TabHospi>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "hospiCtrl";
	
	boolean sortie;
	
	public HospiCtrl(){		
		defaultVue = new HospiVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabHospi> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoHospi();
	}
	
	public Class<HospiCtrl> getMyClass() {
		return HospiCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "HospiDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Hospi";

		System.out.println("HospiCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		Traitement v$traitement = new Traitement(DossierPatientTrt.SORTIE_HOSPI);
		v$traitement.setModalPanel("mpnl_sortie_hospi");	// Id du modal panel			
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Hospi")) ;
		}
	}
	
	@Override
	public List<TabHospi> rechercherParCritere(TabHospi p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoHospi().rechercherParCritere(p$entity);
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

		if (v$propriete.equals("tabUsr")) {
			TabUsr v$entite = (TabUsr) p$entite;
			defaultVue.getEntiteCourante().setTabUsr(v$entite);
		}
		if (v$propriete.equals("tabPat")) {
			TabPat v$entite = (TabPat) p$entite;
			defaultVue.getEntiteCourante().setTabPat(v$entite);
		}
		if (v$propriete.equals("tabSvc")) {
			TabSvc v$entite = (TabSvc) p$entite;
			defaultVue.getEntiteCourante().setTabSvc(v$entite);
		}
		if (v$propriete.equals("tabChrHospi")) {
			TabChrHospi v$entite = (TabChrHospi) p$entite;
			defaultVue.getEntiteCourante().setTabChrHospi(v$entite);
		}
		if (v$propriete.equals("tabLit")) {
			TabLit v$entite = (TabLit) p$entite;
			defaultVue.getEntiteCourante().setTabLit(v$entite);
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
	
	public String sortieHospiPreModal(){
		return null;
	}
	
	@SuppressWarnings("finally")
	public String sortirHospitalisation() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "L'hospitalisation du patient :  ";
		Date date = defaultVue.getEntiteCourante().getDateSortie();
		String prescri = defaultVue.getEntiteCourante().getLibPrescri();
		try {

			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			defaultVue.getEntiteCourante().setDateSortie(date);
			defaultVue.getEntiteCourante().setLibPrescri(prescri);
			
			// Consommation de l'EJB distant selon l'operation spécifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoHospi()
					.sortirHospitalisation(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getTabPat().getLibNom()+" est terminée";

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
	public boolean isSortie() {
		sortie = false;
		TabHospi hospi = defaultVue.getEntiteCourante();
		if(hospi != null && hospi.getBooSor() != null && hospi.getBooSor().equals(BigDecimal.ONE)) sortie = true;
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}
	
	public void preEnregistrer() throws DataValidationException {
		HospiVue vue = (HospiVue)defaultVue;
		TabHospi hospi= defaultVue.getEntiteCourante();
		if(vue.isVisEmb() && hospi.getTabPat()!=null && hospi.getTabVisMedEmb()!= null 
				&& hospi.getTabVisMedEmb().getTabPat() != null 
				&& !hospi.getTabVisMedEmb().getTabPat().getCodPat().equals(hospi.getTabPat().getCodPat())){
			throw new DataValidationException("Données invalides : La visite médicale source n'est pas celui du patient sélectionné");
		}
		if(vue.isVisPerio() && hospi.getTabPat()!= null && hospi.getTabVisMedPerio()!= null 
				&& hospi.getTabVisMedPerio().getTabSoc() != null && hospi.getTabPat().getTabSoc() != null 
				&& !hospi.getTabVisMedPerio().getTabSoc().getCodSoc().equals(hospi.getTabPat().getTabSoc().getCodSoc())){
			throw new DataValidationException("Données invalides : La société de la visite médicale source ne correspond pas à celui du patient sélectionné");
		}
	}

	
}
