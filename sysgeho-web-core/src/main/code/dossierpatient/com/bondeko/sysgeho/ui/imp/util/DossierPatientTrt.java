package com.bondeko.sysgeho.ui.imp.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class DossierPatientTrt extends SysGehoTrt{
	
	public static Traitement EXP_ETA_PAT;	
	static{
		
		EXP_ETA_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Exp_Pat" , /* Libell� */ "Exporter le fichier des patients" , /* Commentaire */ "" , /* M�thode */ "exporterPatients",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_RDV;	
	static{
		
		ENREG_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_rdv" , /* Libell� */ "Enregistrer un rendez-vous" , /* Commentaire */ "" , /* M�thode */ "enregistrerRdv",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_HOSPI;	
	static{
		
		ENREG_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Hospi" , /* Libell� */ "Admettre en Hospitalisation" , /* Commentaire */ "" , /* M�thode */ "hospitaliserPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Hospitalisation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F5", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_RDV;
	static{	
		NAVIGUER_RDV = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Rdv" , /* Libell� */ "Naviguer vers les Rendez-vous" + SEPERATEUR_2 + "Naviguer vers les Rendez-vous" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rdvCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement NAVIGUER_HOSPI;
	static{	
		NAVIGUER_HOSPI = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Hospi" , /* Libell� */ "Naviguer vers les Hospitalisations" + SEPERATEUR_2 + "Naviguer vers les Hospitalisations" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "hospiCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "14");
	}	
	
	public static Traitement ANNULER_RDV;	
	static{
		
		ANNULER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Dem_dep" , /* Libell� */ "Annuler le Rendez-vous" , /* Commentaire */ "" , /* M�thode */ "annuler",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Annulation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * CONFIRMER_RDV
	 */
	public static Traitement CONFIRMER_RDV;	
	static{
		
		CONFIRMER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Conf_Rdv" , /* Libell� */ "Confirmer" , /* Commentaire */ "" , /* M�thode */ "confirmer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer le Rendez-vous ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_CONSUL
	 */
	public static Traitement VALIDER_CONSUL;	
	static{
		
		VALIDER_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Consul" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la consultation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_CPTE_RENDU;	
	static{
		
		ENREG_CPTE_RENDU = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_CpteRendu" , /* Libell� */ "Enregistrer le compe rendu" , /* Commentaire */ "" , /* M�thode */ "enregistrerCpteRendu",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_CPTE_RENDU;
	static{	
		NAVIGUER_CPTE_RENDU = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "CpteRenduConsul" , /* Libell� */ "Naviguer vers le conpte rendu" + SEPERATEUR_2 + "Naviguer vers le conpte rendu" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "cpteRenduConsulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	/***
	 * ETA_LIST_PAT
	 */
	public static Traitement ETA_LIST_PAT;	
	static{
		
		ETA_LIST_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "List_Pat" , /* Libell� */ "G�nerer liste des patients" , /* Commentaire */ "" , /* M�thode */ "genEtatListPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	public static Traitement SORTIE_HOSPI;	
	static{
		
		SORTIE_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Sortie_Hospi" , /* Libell� */ "Sortie d'hospitalisation" , /* Commentaire */ "" , /* M�thode */ "sortieHospiPreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la sortie ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ "mpnl_sortie_hospi", /* image */ "" );
	}
	
	/***
	 * VALIDER_CPTE_RENDU_CONSUL
	 */
	public static Traitement VALIDER_CPTE_RENDU_CONSUL;	
	static{
		
		VALIDER_CPTE_RENDU_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Cpte_Rdu" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_CPTE_RENDU_EXAM;
	static{	
		NAVIGUER_CPTE_RENDU_EXAM = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "CpteRenduExam" , /* Libell� */ "Naviguer vers le conpte rendu" + SEPERATEUR_2 + "Naviguer vers le conpte rendu" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "cpteRenduExamCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement ENREG_CPTE_RENDU_EXAM;	
	static{
		
		ENREG_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_CpteRendu" , /* Libell� */ "Enregistrer le compe rendu" , /* Commentaire */ "" , /* M�thode */ "enregistrerCpteRendu",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_CPTE_RENDU_CONSUL
	 */
	public static Traitement VALIDER_CPTE_RENDU_EXAM;	
	static{
		
		VALIDER_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Cpte_Rdu_Exam" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation du compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_EXAM
	 */
	public static Traitement VALIDER_EXAM;	
	static{
		
		VALIDER_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Exam" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la Validation de l Examen ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_EXAMEN;
	static{	
		NAVIGUER_EXAMEN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Exam" , /* Libell� */ "Naviguer vers les Examens" + SEPERATEUR_2 + "Naviguer vers les Examens" , /* Commentaire */ "" , /* M�thode */ "navigerExam",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "examCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "15");
	}
	
	public static Traitement NAVIGUER_CONSULTATION;
	static{	
		NAVIGUER_CONSULTATION = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Consul" , /* Libell� */ "Naviguer vers les Consultations" + SEPERATEUR_2 + "Naviguer vers les Consultations" , /* Commentaire */ "" , /* M�thode */ "naviguerConsul",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "consulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement ENREG_CONSUL;	
	static{
		
		ENREG_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Consul" , /* Libell� */ "Enregistrer une Consultation" , /* Commentaire */ "" , /* M�thode */ "consulter",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F6", /* index */ "01", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_EXAM;	
	static{
		
		ENREG_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Exam" , /* Libell� */ "Enregistrer un Examen" , /* Commentaire */ "" , /* M�thode */ "examiner",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F7", /* index */ "02", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_EXAM
	 */
	public static Traitement VALIDER_SOIN;	
	static{
		
		VALIDER_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Soin" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider Soin ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_SOIN;
	static{	
		NAVIGUER_VERS_SOIN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Soin" , /* Libell� */ "Naviguer vers les Soins" + SEPERATEUR_2 + "Naviguer vers les Soins" , /* Commentaire */ "" , /* M�thode */ "naviguerSoin",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "soinCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement ENREG_SOIN;	
	static{
		
		ENREG_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Soin" , /* Libell� */ "Enregistrer un soin" , /* Commentaire */ "" , /* M�thode */ "enregistrerSoin",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F8", /* index */ "08", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_VIS_MED_EMB
	 */
	public static Traitement VALIDER_VIS_MED_EMB;	
	static{
		
		VALIDER_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_VisMedEmb" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation de la visite m�dicale ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_VIS_MED_PERIO
	 */
	public static Traitement VALIDER_VIS_MED_PERIO;	
	static{
		
		VALIDER_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_VisMedPerio" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation de la visite m�dicale ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETA_LIST_PAT
	 */
	public static Traitement ETA_FICHE_PAT;	
	static{
		
		ETA_FICHE_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Fiche_Pat" , /* Libell� */ "G�n�rer la fiche du patient" , /* Commentaire */ "" , /* M�thode */ "genEtatFichePat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CPTE_RENDU_CONSUL
	 */
	public static Traitement GENERER_CPTE_RENDU_CONSUL;	
	static{
		
		GENERER_CPTE_RENDU_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cpte_Rdu_Con" , /* Libell� */ "Generer Compte Rendu" , /* Commentaire */ "" , /* M�thode */ "genererCpteRenduCon",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "G�n�rer le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CPTE_RENDU_EXAM
	 */
	public static Traitement GENERER_CPTE_RENDU_EXAM;	
	static{
		
		GENERER_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cpte_Rdu_Exam" , /* Libell� */ "Generer Compte Rendu" , /* Commentaire */ "" , /* M�thode */ "genererCpteRenduExam",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "G�n�rer le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_CONSULTATION;
	static{	
		NAVIGUER_DE_VM_VERS_CONSULTATION = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Consul" , /* Libell� */ "Naviguer vers les Consultations" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "consulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_HOSPI;
	static{	
		NAVIGUER_DE_VM_VERS_HOSPI = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Hospi" , /* Libell� */ "Naviguer vers les Hospitalisations" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "hospiCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_EXAMEN;
	static{	
		NAVIGUER_DE_VM_VERS_EXAMEN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Exam" , /* Libell� */ "Naviguer vers les Examens" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "examCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "14");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_SOIN;
	static{	
		NAVIGUER_DE_VM_VERS_SOIN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Soin" , /* Libell� */ "Naviguer vers les Soins" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "soinCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "15");
	}
	
	/***
	 * VALIDER_RAP_VIS_MED_EMB
	 */
	public static Traitement VALIDER_RAP_VIS_MED_EMB;	
	static{
		
		VALIDER_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Rap_Vis_Med_Emb" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_RAP_VIS_MED_EMB
	 */
	public static Traitement GENERER_RAP_VIS_MED_EMB;	
	static{
		
		GENERER_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Rap_Vis_Med_Emb" , /* Libell� */ "Generer le rapport" , /* Commentaire */ "" , /* M�thode */ "genererRapportVM",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous g�nerez le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_RAP_VIS_MED_PERIO
	 */
	public static Traitement VALIDER_RAP_VIS_MED_PERIO;	
	static{
		
		VALIDER_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Rap_Vis_Med_Perio" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_RAP_VIS_MED_EMB;	
	static{
		
		ENREG_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_RapVisMedEmb" , /* Libell� */ "Enregistrer le rapport" , /* Commentaire */ "" , /* M�thode */ "enregistrerRapport",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_RAP_VIS_MED_EMB;
	static{	
		NAVIGUER_VERS_RAP_VIS_MED_EMB = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "RapVisMedEmb" , /* Libell� */ "Naviguer vers le rapport de la visite" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rapVisMedEmbCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement ENREG_RAP_VIS_MED_PERIO;	
	static{
		
		ENREG_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_RapVisMedPerio" , /* Libell� */ "Enregistrer le rapport" , /* Commentaire */ "" , /* M�thode */ "enregistrerRapport",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_RAP_VIS_MED_PERIO;
	static{	
		NAVIGUER_VERS_RAP_VIS_MED_PERIO = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "RapVisMedPerio" , /* Libell� */ "Naviguer vers le rapport de la visite" + SEPERATEUR_2 + "Naviguer vers le rapport de la visite" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rapVisMedPerioCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	/***
	 * GENERER_RAP_VIS_MED_PERIO
	 */
	public static Traitement GENERER_RAP_VIS_MED_PERIO;	
	static{
		
		GENERER_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "gEN_Rap_Vis_Med_Perio" , /* Libell� */ "Generer le rapport" , /* Commentaire */ "" , /* M�thode */ "genererRapportVM",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous g�nerez le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F5", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETA_DOS_PAT
	 */
	public static Traitement ETA_DOS_PAT;	
	static{
		
		ETA_DOS_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Dossier_Pat" , /* Libell� */ "G�n�rer le dossier du patient" , /* Commentaire */ "" , /* M�thode */ "genDossierPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_PREST
	 */
	public static Traitement ETAT_CMPT_PREST;	
	static{
		
		ETAT_CMPT_PREST = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Prest" , /* Libell� */ "Etat comptable de toutes les prestations" , /* Commentaire */ "" , /* M�thode */ "selectionCriterePreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ "mpnl_critere_selection", /* image */ "" );
	}
	
	
	/***
	 * ETAT_CMPT_CONSUL
	 */
	public static Traitement ETAT_CMPT_CONSUL;	
	static{
		
		ETAT_CMPT_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Consul" , /* Libell� */ "Etat comptable des consultations" , /* Commentaire */ "" , /* M�thode */ "genererCmptConsul",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_EXAM
	 */
	public static Traitement ETAT_CMPT_EXAM;	
	static{
		
		ETAT_CMPT_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Exam" , /* Libell� */ "Etat comptable des examens" , /* Commentaire */ "" , /* M�thode */ "genererCmptExam",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_SOIN
	 */
	public static Traitement ETAT_CMPT_SOIN;	
	static{
		
		ETAT_CMPT_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Soin" , /* Libell� */ "Etat comptable des soins" , /* Commentaire */ "" , /* M�thode */ "genererCmptSoin",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_HOSPI
	 */
	public static Traitement ETAT_CMPT_HOSPI;	
	static{
		
		ETAT_CMPT_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Hospi" , /* Libell� */ "Etat comptable des hospitalisation" , /* Commentaire */ "" , /* M�thode */ "genererCmptHospi",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CERT_MED
	 */
	public static Traitement GENERER_CERT_MED;	
	static{
		
		GENERER_CERT_MED = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cert_Med" , /* Libell� */ "Generer le Certificat Medical" , /* Commentaire */ "" , /* M�thode */ "genererCertMed",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous g�nerez le certificat ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_LIST_CREXAM
	 */
	public static Traitement GENERER_LIST_CREXAM;	
	static{
		
		GENERER_LIST_CREXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_List_Med" , /* Libell� */ "G�n�rer la liste des comptes rendus examen" , /* Commentaire */ "" , /* M�thode */ "selectionCriterePreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ "mpnl_critere_selection_exam", /* image */ "" );
	}
	
}
