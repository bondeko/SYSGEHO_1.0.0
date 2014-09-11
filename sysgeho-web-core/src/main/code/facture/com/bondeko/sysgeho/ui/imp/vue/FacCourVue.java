/**
 * 
 */
package com.bondeko.sysgeho.ui.imp.vue;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.fac.entity.TabFacCour;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.ui.core.base.AbstractNavigationManager;
import com.bondeko.sysgeho.ui.core.base.SysGehoVue;
import com.bondeko.sysgeho.ui.core.base.TableManager;


public class FacCourVue extends SysGehoVue<TabFacCour> {
	
	/*=========================================================== ~ Debut Region ~ =================================================================*/
	/**	~ Propriétés ~ 	**/    
	/*=============================================================================================================================================*/
	
	private static BaseLogger logger = BaseLogger.getLogger(FacCourVue.class);
	
	
	/**
	 * Gestionnaire (de la liste)des consultation de la recherche
	 */
	private TableManager<TabConsul> consulRechercheMgr = new TableManager<TabConsul>();
	private TableManager<TabHospi> hospiRechercheMgr = new TableManager<TabHospi>();
	private TableManager<TabExam> examRechercheMgr = new TableManager<TabExam>();
	private TableManager<TabSoin> soinRechercheMgr = new TableManager<TabSoin>();

	/**
	 * Gestionnaire (de la liste)des consultation sélectionnés pour facturer 
	 */
	private TableManager<TabConsul> consulPrisPourFacMgr = new TableManager<TabConsul>();
	private TableManager<TabHospi> hospiPrisPourFacMgr = new TableManager<TabHospi>();
	private TableManager<TabExam> examPrisPourFacMgr = new TableManager<TabExam>();
	private TableManager<TabSoin> soinPrisPourFacMgr = new TableManager<TabSoin>();

	/**
	 * Gestionnaire de recherche des titres en attente de virement
	 */
	private TabConsul consulRecherche = ConsulVue.getTabConsulForSearch();
	private TabHospi hospiRecherche = HospiVue.getTabHospiForSearch();
	private TabExam examRecherche = ExamVue.getTabExamForSearch();
	private TabSoin soinRecherche = SoinVue.getTabSoinForSearch();
	
	/**
	 * Gestionnaire (de la liste)des consultation de en attente de virement
	 */
	TableManager<TabConsul> consulAPayerMgr  = new TableManager<TabConsul>();
	TableManager<TabHospi> hospiAPayerMgr  = new TableManager<TabHospi>();
	TableManager<TabExam> examAPayerMgr  = new TableManager<TabExam>();
	TableManager<TabSoin> soinAPayerMgr  = new TableManager<TabSoin>();
	
	
	public FacCourVue() {	
		super();
		this.tableMgr = new TableManager();
		this.navigationMgr = new AbstractNavigationManager();

		consulAPayerMgr = new TableManager<TabConsul>();
		hospiAPayerMgr = new TableManager<TabHospi>();
		examAPayerMgr = new TableManager<TabExam>();
		soinAPayerMgr = new TableManager<TabSoin>();
		
		consulRechercheMgr = new TableManager<TabConsul>();
		hospiRechercheMgr = new TableManager<TabHospi>();
		examRechercheMgr = new TableManager<TabExam>();
		soinRechercheMgr = new TableManager<TabSoin>();
	}

			
	public TableManager<TabConsul> getConsulAPayerMgr() {
		return consulAPayerMgr;
	}

	public void setConsulAPayerMgr(TableManager<TabConsul> consulAPayerMgr) {
		this.consulAPayerMgr = consulAPayerMgr;
	}

	public TableManager<TabHospi> getHospiAPayerMgr() {
		return hospiAPayerMgr;
	}

	public void setHospiAPayerMgr(TableManager<TabHospi> hospiAPayerMgr) {
		this.hospiAPayerMgr = hospiAPayerMgr;
	}

	public TableManager<TabExam> getExamAPayerMgr() {
		return examAPayerMgr;
	}

	public void setExamAPayerMgr(TableManager<TabExam> examAPayerMgr) {
		this.examAPayerMgr = examAPayerMgr;
	}

	public TableManager<TabSoin> getSoinAPayerMgr() {
		return soinAPayerMgr;
	}

	public void setSoinAPayerMgr(TableManager<TabSoin> soinAPayerMgr) {
		this.soinAPayerMgr = soinAPayerMgr;
	}


	public TableManager<TabConsul> getConsulRechercheMgr() {
		return consulRechercheMgr;
	}

	public void setConsulRechercheMgr(TableManager<TabConsul> consulRechercheMgr) {
		this.consulRechercheMgr = consulRechercheMgr;
	}

	public TableManager<TabHospi> getHospiRechercheMgr() {
		return hospiRechercheMgr;
	}

	public void setHospiRechercheMgr(TableManager<TabHospi> hospiRechercheMgr) {
		this.hospiRechercheMgr = hospiRechercheMgr;
	}

	public TableManager<TabExam> getExamRechercheMgr() {
		return examRechercheMgr;
	}

	public void setExamRechercheMgr(TableManager<TabExam> examRechercheMgr) {
		this.examRechercheMgr = examRechercheMgr;
	}

	public TableManager<TabSoin> getSoinRechercheMgr() {
		return soinRechercheMgr;
	}

	public void setSoinRechercheMgr(TableManager<TabSoin> soinRechercheMgr) {
		this.soinRechercheMgr = soinRechercheMgr;
	}
	
	public TableManager<TabConsul> getConsulPrisPourFacMgr() {
		return consulPrisPourFacMgr;
	}

	public void setConsulPrisPourFacMgr(TableManager<TabConsul> consulPrisPourFacMgr) {
		this.consulPrisPourFacMgr = consulPrisPourFacMgr;
	}

	public TableManager<TabHospi> getHospiPrisPourFacMgr() {
		return hospiPrisPourFacMgr;
	}

	public void setHospiPrisPourFacMgr(TableManager<TabHospi> hospiPrisPourFacMgr) {
		this.hospiPrisPourFacMgr = hospiPrisPourFacMgr;
	}

	public TableManager<TabExam> getExamPrisPourFacMgr() {
		return examPrisPourFacMgr;
	}

	public void setExamPrisPourFacMgr(TableManager<TabExam> examPrisPourFacMgr) {
		this.examPrisPourFacMgr = examPrisPourFacMgr;
	}

	public TableManager<TabSoin> getSoinPrisPourFacMgr() {
		return soinPrisPourFacMgr;
	}

	public void setSoinPrisPourFacMgr(TableManager<TabSoin> soinPrisPourFacMgr) {
		this.soinPrisPourFacMgr = soinPrisPourFacMgr;
	}
	
	public TabConsul getConsulRecherche() {
		return consulRecherche;
	}

	public void setConsulRecherche(TabConsul consulRecherche) {
		this.consulRecherche = consulRecherche;
	}

	public TabHospi getHospiRecherche() {
		return hospiRecherche;
	}

	public void setHospiRecherche(TabHospi hospiRecherche) {
		this.hospiRecherche = hospiRecherche;
	}

	public TabExam getExamRecherche() {
		return examRecherche;
	}

	public void setExamRecherche(TabExam examRecherche) {
		this.examRecherche = examRecherche;
	}

	public TabSoin getSoinRecherche() {
		return soinRecherche;
	}

	public void setSoinRecherche(TabSoin soinRecherche) {
		this.soinRecherche = soinRecherche;
	}

	public BaseLogger getLogger(){
		return logger;
	}
	
	
	/**
	 * Retourne une nouvelle Instance de l'entité  
	 * 
	 * @return
	 */	
	public static TabFacCour getTabFacCour(){		
		TabFacCour v$facCour = new TabFacCour();
		v$facCour.setInfoUser(getInfoUser());
		v$facCour.initData();
		return v$facCour ;	
	}

	/**
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 * 
	 * @return
	 */
	public static TabFacCour getTabFacCourForSearch(){		
		TabFacCour v$facCour = getTabFacCour();
		return v$facCour ;	
	}	

	@Override
	public TabFacCour getNewEntity() {		
		return getTabFacCour();
	}

	/***
	 * Retourne une nouvelle instance d'une entité utile pour la recherche des données;  
	 *  
	 * @return
	 */	
	@Override
	public TabFacCour getEntityForSearch() {	
		return getTabFacCourForSearch();
	}	

}
