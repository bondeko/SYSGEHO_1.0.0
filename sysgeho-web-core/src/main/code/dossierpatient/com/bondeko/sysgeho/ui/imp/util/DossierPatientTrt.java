package com.bondeko.sysgeho.ui.imp.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class DossierPatientTrt extends SysGehoTrt{
	
	public static Traitement EXP_ETA_PAT;	
	static{
		
		EXP_ETA_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Exp_Pat" , /* Libellé */ "Exporter le fichier des patients" , /* Commentaire */ "" , /* Méthode */ "exporterPatients",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_RDV;	
	static{
		
		ENREG_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_rdv" , /* Libellé */ "Enregistrer un rendez-vous" , /* Commentaire */ "" , /* Méthode */ "enregistrerRdv",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_HOSPI;	
	static{
		
		ENREG_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Hospi" , /* Libellé */ "Admettre en Hospitalisation" , /* Commentaire */ "" , /* Méthode */ "hospitaliserPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Hospitalisation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F5", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_RDV;
	static{	
		NAVIGUER_RDV = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Rdv" , /* Libellé */ "Naviguer vers les Rendez-vous" + SEPERATEUR_2 + "Naviguer vers les Rendez-vous" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rdvCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement NAVIGUER_HOSPI;
	static{	
		NAVIGUER_HOSPI = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Hospi" , /* Libellé */ "Naviguer vers les Hospitalisations" + SEPERATEUR_2 + "Naviguer vers les Hospitalisations" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "hospiCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "14");
	}	
	
	public static Traitement ANNULER_RDV;	
	static{
		
		ANNULER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Dem_dep" , /* Libellé */ "Annuler le Rendez-vous" , /* Commentaire */ "" , /* Méthode */ "annuler",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Annulation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * CONFIRMER_RDV
	 */
	public static Traitement CONFIRMER_RDV;	
	static{
		
		CONFIRMER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Conf_Rdv" , /* Libellé */ "Confirmer" , /* Commentaire */ "" , /* Méthode */ "confirmer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer le Rendez-vous ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_CONSUL
	 */
	public static Traitement VALIDER_CONSUL;	
	static{
		
		VALIDER_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Consul" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la consultation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_CPTE_RENDU;	
	static{
		
		ENREG_CPTE_RENDU = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_CpteRendu" , /* Libellé */ "Enregistrer le compe rendu" , /* Commentaire */ "" , /* Méthode */ "enregistrerCpteRendu",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_CPTE_RENDU;
	static{	
		NAVIGUER_CPTE_RENDU = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "CpteRenduConsul" , /* Libellé */ "Naviguer vers le conpte rendu" + SEPERATEUR_2 + "Naviguer vers le conpte rendu" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "cpteRenduConsulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	/***
	 * ETA_LIST_PAT
	 */
	public static Traitement ETA_LIST_PAT;	
	static{
		
		ETA_LIST_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "List_Pat" , /* Libellé */ "Génerer liste des patients" , /* Commentaire */ "" , /* Méthode */ "genEtatListPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	public static Traitement SORTIE_HOSPI;	
	static{
		
		SORTIE_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Sortie_Hospi" , /* Libellé */ "Sortie d'hospitalisation" , /* Commentaire */ "" , /* Méthode */ "sortieHospiPreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la sortie ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ "mpnl_sortie_hospi", /* image */ "" );
	}
	
	/***
	 * VALIDER_CPTE_RENDU_CONSUL
	 */
	public static Traitement VALIDER_CPTE_RENDU_CONSUL;	
	static{
		
		VALIDER_CPTE_RENDU_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Cpte_Rdu" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_CPTE_RENDU_EXAM;
	static{	
		NAVIGUER_CPTE_RENDU_EXAM = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "CpteRenduExam" , /* Libellé */ "Naviguer vers le conpte rendu" + SEPERATEUR_2 + "Naviguer vers le conpte rendu" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "cpteRenduExamCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement ENREG_CPTE_RENDU_EXAM;	
	static{
		
		ENREG_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_CpteRendu" , /* Libellé */ "Enregistrer le compe rendu" , /* Commentaire */ "" , /* Méthode */ "enregistrerCpteRendu",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_CPTE_RENDU_CONSUL
	 */
	public static Traitement VALIDER_CPTE_RENDU_EXAM;	
	static{
		
		VALIDER_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Cpte_Rdu_Exam" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation du compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_EXAM
	 */
	public static Traitement VALIDER_EXAM;	
	static{
		
		VALIDER_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Exam" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la Validation de l Examen ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_EXAMEN;
	static{	
		NAVIGUER_EXAMEN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Exam" , /* Libellé */ "Naviguer vers les Examens" + SEPERATEUR_2 + "Naviguer vers les Examens" , /* Commentaire */ "" , /* Méthode */ "navigerExam",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "examCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "15");
	}
	
	public static Traitement NAVIGUER_CONSULTATION;
	static{	
		NAVIGUER_CONSULTATION = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Consul" , /* Libellé */ "Naviguer vers les Consultations" + SEPERATEUR_2 + "Naviguer vers les Consultations" , /* Commentaire */ "" , /* Méthode */ "naviguerConsul",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "consulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement ENREG_CONSUL;	
	static{
		
		ENREG_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Consul" , /* Libellé */ "Enregistrer une Consultation" , /* Commentaire */ "" , /* Méthode */ "consulter",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F6", /* index */ "01", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_EXAM;	
	static{
		
		ENREG_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Exam" , /* Libellé */ "Enregistrer un Examen" , /* Commentaire */ "" , /* Méthode */ "examiner",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F7", /* index */ "02", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_EXAM
	 */
	public static Traitement VALIDER_SOIN;	
	static{
		
		VALIDER_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Soin" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider Soin ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_SOIN;
	static{	
		NAVIGUER_VERS_SOIN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Soin" , /* Libellé */ "Naviguer vers les Soins" + SEPERATEUR_2 + "Naviguer vers les Soins" , /* Commentaire */ "" , /* Méthode */ "naviguerSoin",
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "soinCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement ENREG_SOIN;	
	static{
		
		ENREG_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Soin" , /* Libellé */ "Enregistrer un soin" , /* Commentaire */ "" , /* Méthode */ "enregistrerSoin",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F8", /* index */ "08", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_VIS_MED_EMB
	 */
	public static Traitement VALIDER_VIS_MED_EMB;	
	static{
		
		VALIDER_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_VisMedEmb" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation de la visite médicale ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_VIS_MED_PERIO
	 */
	public static Traitement VALIDER_VIS_MED_PERIO;	
	static{
		
		VALIDER_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_VisMedPerio" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la validation de la visite médicale ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETA_LIST_PAT
	 */
	public static Traitement ETA_FICHE_PAT;	
	static{
		
		ETA_FICHE_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Fiche_Pat" , /* Libellé */ "Générer la fiche du patient" , /* Commentaire */ "" , /* Méthode */ "genEtatFichePat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CPTE_RENDU_CONSUL
	 */
	public static Traitement GENERER_CPTE_RENDU_CONSUL;	
	static{
		
		GENERER_CPTE_RENDU_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cpte_Rdu_Con" , /* Libellé */ "Generer Compte Rendu" , /* Commentaire */ "" , /* Méthode */ "genererCpteRenduCon",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Générer le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CPTE_RENDU_EXAM
	 */
	public static Traitement GENERER_CPTE_RENDU_EXAM;	
	static{
		
		GENERER_CPTE_RENDU_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cpte_Rdu_Exam" , /* Libellé */ "Generer Compte Rendu" , /* Commentaire */ "" , /* Méthode */ "genererCpteRenduExam",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Générer le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_CONSULTATION;
	static{	
		NAVIGUER_DE_VM_VERS_CONSULTATION = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Consul" , /* Libellé */ "Naviguer vers les Consultations" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "consulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_HOSPI;
	static{	
		NAVIGUER_DE_VM_VERS_HOSPI = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Hospi" , /* Libellé */ "Naviguer vers les Hospitalisations" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "hospiCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_EXAMEN;
	static{	
		NAVIGUER_DE_VM_VERS_EXAMEN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Exam" , /* Libellé */ "Naviguer vers les Examens" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "examCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "14");
	}
	
	public static Traitement NAVIGUER_DE_VM_VERS_SOIN;
	static{	
		NAVIGUER_DE_VM_VERS_SOIN = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Soin" , /* Libellé */ "Naviguer vers les Soins" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "soinCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "15");
	}
	
	/***
	 * VALIDER_RAP_VIS_MED_EMB
	 */
	public static Traitement VALIDER_RAP_VIS_MED_EMB;	
	static{
		
		VALIDER_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Rap_Vis_Med_Emb" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_RAP_VIS_MED_EMB
	 */
	public static Traitement GENERER_RAP_VIS_MED_EMB;	
	static{
		
		GENERER_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Rap_Vis_Med_Emb" , /* Libellé */ "Generer le rapport" , /* Commentaire */ "" , /* Méthode */ "genererRapportVM",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous génerez le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_RAP_VIS_MED_PERIO
	 */
	public static Traitement VALIDER_RAP_VIS_MED_PERIO;	
	static{
		
		VALIDER_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Rap_Vis_Med_Perio" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_RAP_VIS_MED_EMB;	
	static{
		
		ENREG_RAP_VIS_MED_EMB = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_RapVisMedEmb" , /* Libellé */ "Enregistrer le rapport" , /* Commentaire */ "" , /* Méthode */ "enregistrerRapport",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_RAP_VIS_MED_EMB;
	static{	
		NAVIGUER_VERS_RAP_VIS_MED_EMB = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "RapVisMedEmb" , /* Libellé */ "Naviguer vers le rapport de la visite" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rapVisMedEmbCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	public static Traitement ENREG_RAP_VIS_MED_PERIO;	
	static{
		
		ENREG_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_RapVisMedPerio" , /* Libellé */ "Enregistrer le rapport" , /* Commentaire */ "" , /* Méthode */ "enregistrerRapport",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "000",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_RAP_VIS_MED_PERIO;
	static{	
		NAVIGUER_VERS_RAP_VIS_MED_PERIO = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "RapVisMedPerio" , /* Libellé */ "Naviguer vers le rapport de la visite" + SEPERATEUR_2 + "Naviguer vers le rapport de la visite" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rapVisMedPerioCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	/***
	 * GENERER_RAP_VIS_MED_PERIO
	 */
	public static Traitement GENERER_RAP_VIS_MED_PERIO;	
	static{
		
		GENERER_RAP_VIS_MED_PERIO = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "gEN_Rap_Vis_Med_Perio" , /* Libellé */ "Generer le rapport" , /* Commentaire */ "" , /* Méthode */ "genererRapportVM",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous génerez le rapport ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F5", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETA_DOS_PAT
	 */
	public static Traitement ETA_DOS_PAT;	
	static{
		
		ETA_DOS_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Dossier_Pat" , /* Libellé */ "Générer le dossier du patient" , /* Commentaire */ "" , /* Méthode */ "genDossierPat",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_PREST
	 */
	public static Traitement ETAT_CMPT_PREST;	
	static{
		
		ETAT_CMPT_PREST = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Prest" , /* Libellé */ "Etat comptable de toutes les prestations" , /* Commentaire */ "" , /* Méthode */ "selectionCriterePreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ "mpnl_critere_selection", /* image */ "" );
	}
	
	
	/***
	 * ETAT_CMPT_CONSUL
	 */
	public static Traitement ETAT_CMPT_CONSUL;	
	static{
		
		ETAT_CMPT_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Consul" , /* Libellé */ "Etat comptable des consultations" , /* Commentaire */ "" , /* Méthode */ "genererCmptConsul",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_EXAM
	 */
	public static Traitement ETAT_CMPT_EXAM;	
	static{
		
		ETAT_CMPT_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Exam" , /* Libellé */ "Etat comptable des examens" , /* Commentaire */ "" , /* Méthode */ "genererCmptExam",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_SOIN
	 */
	public static Traitement ETAT_CMPT_SOIN;	
	static{
		
		ETAT_CMPT_SOIN = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Soin" , /* Libellé */ "Etat comptable des soins" , /* Commentaire */ "" , /* Méthode */ "genererCmptSoin",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * ETAT_CMPT_HOSPI
	 */
	public static Traitement ETAT_CMPT_HOSPI;	
	static{
		
		ETAT_CMPT_HOSPI = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "CMP_Hospi" , /* Libellé */ "Etat comptable des hospitalisation" , /* Commentaire */ "" , /* Méthode */ "genererCmptHospi",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_CERT_MED
	 */
	public static Traitement GENERER_CERT_MED;	
	static{
		
		GENERER_CERT_MED = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cert_Med" , /* Libellé */ "Generer le Certificat Medical" , /* Commentaire */ "" , /* Méthode */ "genererCertMed",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Voulez vous génerez le certificat ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GENERER_LIST_CREXAM
	 */
	public static Traitement GENERER_LIST_CREXAM;	
	static{
		
		GENERER_LIST_CREXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_List_Med" , /* Libellé */ "Générer la liste des comptes rendus examen" , /* Commentaire */ "" , /* Méthode */ "selectionCriterePreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la génération ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ "mpnl_critere_selection_exam", /* image */ "" );
	}
	
}
