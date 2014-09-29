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
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
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
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_EXAM
	 */
	public static Traitement VALIDER_EXAM;	
	static{
		
		VALIDER_EXAM = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Exam" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider Examen ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
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
	 * GENERER_CPTE_RENDU_CONSUL
	 */
	public static Traitement GENERER_CPTE_RENDU_CONSUL;	
	static{
		
		GENERER_CPTE_RENDU_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Cpte_Rdu_Con" , /* Libellé */ "Generer Compte Rendu" , /* Commentaire */ "" , /* Méthode */ "genererCpteRenduCon",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Générer le compte rendu ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
}
