package com.bondeko.sysgeho.ui.phar.controleur;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.enums.EnuTypMouv;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.phar.entity.TabMouvStock;
import com.bondeko.sysgeho.be.phar.entity.TabProd;
import com.bondeko.sysgeho.ui.core.base.CoreConstants;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.phar.util.PharSvcoDeleguate;
import com.bondeko.sysgeho.ui.phar.util.PharTrt;
import com.bondeko.sysgeho.ui.phar.vue.MouvStockVue;
import com.bondeko.sysgeho.ui.ref.util.RefTrt;

public class MouvStockCtrl extends SysGehoCtrl<TabMouvStock, TabMouvStock>{
	
	/**
	 * Nom du Bean manag� par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "mouvStockCtrl";
	
	public MouvStockCtrl(){		
		defaultVue = new MouvStockVue();		
	}
	
	/**
	 * Retourne le nom du Bean Manag� par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabMouvStock> getEntitySvco() throws ServiceLocatorException{	
		return PharSvcoDeleguate.getSvcoMouvStock();
	}
	
	public Class<MouvStockCtrl> getMyClass() {
		return MouvStockCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "MouvStockDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "MouvStock";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				PharTrt.getTrtStandards(v$codeEntite));
		v$mapTrt.put(PharTrt.VALIDER_MOUV.getKey(), new Traitement(PharTrt.VALIDER_MOUV));
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}
	

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(RefTrt.getTrtStandards("MouvStock")) ;
		}	
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {
		// Nom de la propri�t� � mettre � jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();
		if (v$propriete.equals("tabProd")) {
			TabProd v$entite = (TabProd) p$entite;
			defaultVue.getEntiteCourante().setTabProd(v$entite);
		}
	}

	@Override
	public List<TabMouvStock> rechercherParCritere(TabMouvStock p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return PharSvcoDeleguate.getSvcoMouvStock().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	@SuppressWarnings("finally")
	public String valider() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "Le Mouvement de stock n� ";

		try {

			// Mise � jour de l'entit� courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entit� avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			TabMouvStock entity = defaultVue.getEntiteCourante();
			if(entity.getBooVal() != null && entity.getBooVal().equals(BigDecimal.ONE)){
				FacesUtil.addWarnMessage("", "Warning : Vous n'avez plus le droit d'ex�cuter le traitement Valider pour ce mouvement");
				return null;
			}

			// Consommation de l'EJB distant selon l'operation sp�cifique car
			// l'entite courante est connue
			defaultVue.setEntiteCourante(PharSvcoDeleguate.getSvcoMouvStock()
				.valider(defaultVue.getEntiteCourante()));

			v$msgDetails += defaultVue.getEntiteCourante().getCodMouvStock()+" a �t� valid�";

			// L'on remplace l'ancienne entit� de la liste par la nouvelle issue
			// du r�sultat du traitement sp�cifiques
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
			FacesUtil.addWarnMessage("", "Warning : Quantit� demand�e insuffisante");
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
		
		if(defaultVue.getEntiteCourante().getEnuTypMouv().equals(EnuTypMouv.ENTREE.getValue()))
		{
			if(defaultVue.getEntiteCourante().getQteMouv().compareTo(BigDecimal.ZERO)<0)
			{
				throw new DataValidationException("Warning : Pour un mouvement d'entr�e, la Quantit� doit etre positive");
			}
		}
		else {
			if(defaultVue.getEntiteCourante().getQteMouv().compareTo(BigDecimal.ZERO)>0)
			{
				throw new DataValidationException("Warning : Pour un mouvement de sortie, la Quantit� doit etre negative");
			}
		}
	}
}
