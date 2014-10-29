package com.bondeko.sysgeho.ui.ref.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.fac.entity.TabFacConv;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.OutputType;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.fac.util.FactureSvcoDeleguate;
import com.bondeko.sysgeho.ui.ref.util.RefSvcoDeleguate;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;
import com.bondeko.sysgeho.ui.ref.vue.SocVue;

public class SocCtrl extends SysGehoCtrl<TabSoc, TabSoc>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "socCtrl";
	
	public SocCtrl(){		
		defaultVue = new SocVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabSoc> getEntitySvco() throws ServiceLocatorException{	
		return RefSvcoDeleguate.getSvcoSoc();
	}
	
	public Class<SocCtrl> getMyClass() {
		return SocCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "SocDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Soc";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				RefTrt.getTrtStandards(v$codeEntite));
		
		Traitement v$traitement = new Traitement(RefTrt.GENERER_FACTURE_CONV);
		v$traitement.setModalPanel("mpnl_gen_facconv");	// Id du modal panel			
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		Traitement v$traitement2 = new Traitement(
				RefTrt.NAVIGUER_VERS_FAC_CONV.naviguerVersFormulaireListe(),
				RefTrt.NAVIGUER_VERS_FAC_CONV);
		v$mapTrt.put(v$traitement2.getKey(), v$traitement2);
		
		v$mapTrt.put(RefTrt.GEN_LIST_SOC.getKey(), new Traitement(RefTrt.GEN_LIST_SOC));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("Soc")) ;
		}	
	}

	@Override
	public List<TabSoc> rechercherParCritere(TabSoc p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return RefSvcoDeleguate.getSvcoSoc().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	@Override
	public void preEnregistrer() throws DataValidationException {
		if(defaultVue.getEntiteCourante() != null  && defaultVue.getEntiteCourante().getBEstAff()==false){
			defaultVue.getEntiteCourante().setDatAff(null);
			defaultVue.getEntiteCourante().setValPriUni(null);
			defaultVue.getEntiteCourante().setValTarifFixMen(null);
		}
	}
	
	public String genererFacConvPreModal(){
		return null;
	}
	
	@SuppressWarnings("finally")
	public String genererFacConv() {
		
		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "La facture conventionnelle du mois de "+defaultVue.getEntiteCourante().getLEnuMoisFac();
		String enuFacMois = defaultVue.getEntiteCourante().getEnuMoisFac();
		String refFac = defaultVue.getEntiteCourante().getRefFacConv();
		String libObj = defaultVue.getEntiteCourante().getLibObj();
		String libInfoCmpl = defaultVue.getEntiteCourante().getLibInfCompl();
		try {

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			defaultVue.getEntiteCourante().setEnuMoisFac(enuFacMois);
			defaultVue.getEntiteCourante().setRefFacConv(refFac);
			defaultVue.getEntiteCourante().setLibObj(libObj);
			defaultVue.getEntiteCourante().setLibInfCompl(libInfoCmpl);
			
			TabSoc tabSoc = defaultVue.getEntiteCourante();
			if(tabSoc.getBooEstAff()== null || tabSoc.getBooEstAff().equals(BigDecimal.ZERO)){
				FacesUtil.addWarnMessage("", "Erreur : La soci�t� " +  tabSoc.getLibSoc() + " n'est pas affili�e");
				return null;
			}
//				throw new BaseException("Erreur : La soci�t� " +  tabSoc.getLibSoc() + " n'est pas affili�e");
			
			List<TabFacConv> facConvs = FactureSvcoDeleguate.getSvcoFacConv().rechercherConsulNonPaieParPatient(tabSoc.getCodSoc(), tabSoc.getEnuMoisFac(), tabSoc.getCodExeFis());
			if(facConvs != null && facConvs.size() > 0){
				FacesUtil.addWarnMessage("", "Erreur : La facture conventionnelle du mois de " + tabSoc.getLEnuMoisFac() +" a d�j� �t� g�n�r� pour la soci�t� "+tabSoc.getLibSoc());
				return null;
			}
//				throw new BaseException("Erreur : La facture conventionnelle du mois de " + tabSoc.getLEnuMoisFac() +"a d�j� �t� g�n�r� pour la soci�t� :"+tabSoc.getLibSoc());
			
			
			// Consommation de l'EJB distant selon l'operation sp�cifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(RefSvcoDeleguate.getSvcoSoc()
					.genererFacConv(defaultVue.getEntiteCourante()));

			v$msgDetails += " a �t� g�n�r� pour la soci�t� " +defaultVue.getEntiteCourante().getLibSoc();

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

		// Si la navigation s'effectue vers les rendez vous
		if (v$navigation.equals(RefTrt.NAVIGUER_VERS_FAC_CONV
				.naviguerVersFormulaireListe())) {
			
			TabFacConv facConv = new TabFacConv();
			facConv.initData();
			facConv.setTabSoc(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(facConv);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return v$navigation;
	}
	
	/**
	 * @return un message  sur l'�tat de l'op�ration
	 */
	@SuppressWarnings("finally")
	public String genererListSoc() {
	// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			SocVue v$vue = (SocVue) defaultVue;

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Sp�cification du type de g�n�ration du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabSoc facConv = defaultVue.getEntiteCourante();
			
			
			EntFichier v$fichier = RefSvcoDeleguate.getSvcoSoc().genererListSoc(facConv);

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
