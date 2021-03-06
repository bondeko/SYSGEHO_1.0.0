package com.bondeko.sysgeho.ui.imp.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedEmb;
import com.bondeko.sysgeho.be.imp.entity.TabVisMedPerio;
import com.bondeko.sysgeho.be.ref.entity.TabTypSoin;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.SoinVue;

public class SoinCtrl extends SysGehoCtrl<TabSoin, TabSoin>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "soinCtrl";
	
	public SoinCtrl(){		
		defaultVue = new SoinVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabSoin> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoSoin();
	}
	
	public Class<SoinCtrl> getMyClass() {
		return SoinCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "SoinDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Soin";

		System.out.println("SoinCtrl.getListeTraitements() ici il vaut : "
				+ v$codeEntite);
		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.VALIDER_EXAM.getKey(), new Traitement(DossierPatientTrt.VALIDER_EXAM));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}


	@Override
	public void buildListeTraitement() {
		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Soin")) ;
		}
	}
	
	@Override
	public List<TabSoin> rechercherParCritere(TabSoin p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoSoin().rechercherParCritere(p$entity);
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

		if (v$propriete.equals("tabTypSoin")) {
			TabTypSoin v$entite = (TabTypSoin) p$entite;
			defaultVue.getEntiteCourante().setTabTypSoin(v$entite);
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

	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "Le Soin n� ";

		try {

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabSoin entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'ex�cuter le traitement Valider pour ce soin");
				return null;
			}
			
			if(entity.getBooPaie() != null && entity.getBooPaie().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Impossible de valider un soin d�j� pay�");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation sp�cifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(DossierPatientSvcoDeleguate.getSvcoSoin()
					.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodSoin()+" a �t� valid�";

			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
			defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					defaultVue.getEntiteCourante());

			// Si nous sommes en Sointation ==> sur le formulaire Details
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
	
	public void preEnregistrer() throws DataValidationException {
		SoinVue vue = (SoinVue)defaultVue;
		TabSoin soin= defaultVue.getEntiteCourante();
		if(vue.isVisEmb() && soin.getTabPat()!=null && soin.getTabVisMedEmb()!= null 
				&& soin.getTabVisMedEmb().getTabPat() != null 
				&& !soin.getTabVisMedEmb().getTabPat().getCodPat().equals(soin.getTabPat().getCodPat())){
			throw new DataValidationException("Donn�es invalides : La visite m�dicale source n'est pas celui du patient s�lectionn�");
		}
		if(vue.isVisPerio() && soin.getTabPat()!= null && soin.getTabVisMedPerio()!= null 
				&& soin.getTabVisMedPerio().getTabSoc() != null && soin.getTabPat().getTabSoc() != null 
				&& !soin.getTabVisMedPerio().getTabSoc().getCodSoc().equals(soin.getTabPat().getTabSoc().getCodSoc())){
			throw new DataValidationException("Donn�es invalides : La soci�t� de la visite m�dicale source ne correspond pas � celui du patient s�lectionn�");
		}
	}
}
