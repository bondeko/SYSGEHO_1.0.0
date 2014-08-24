package com.bondeko.sysgeho.ui.imp.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class DossierPatientTrt extends SysGehoTrt{
	
	/***
	 * EXP_ETA_PAT
	 */
	public static Traitement EXP_ETA_PAT;	
	static{
		
		EXP_ETA_PAT = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Exp_Etat_Pat" , /* Libell� */ "Exporter le fichier des patients" , /* Commentaire */ "" , /* M�thode */ "exporterPatients",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer l'export ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F5", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ANNULER_RDV;	
	static{
		
		ANNULER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Dem_dep" , /* Libell� */ "Annuler le Rendez-vous" , /* Commentaire */ "" , /* M�thode */ "annuler",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer l'annulation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	
	/***
	 * CONFIRMER_RDV
	 */
	public static Traitement CONFIRMER_RDV;	
	static{
		
		CONFIRMER_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Conf_Rdv" , /* Libell� */ "Confirmer" , /* Commentaire */ "" , /* M�thode */ "confirmer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer le Rendez-vous ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_RDV;	
	static{
		
		ENREG_RDV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_rdv" , /* Libell� */ "Enregistrer un rendez-vous" , /* Commentaire */ "" , /* M�thode */ "enregistrerRdv",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer l'enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_RDV;
	static{	
		NAVIGUER_RDV = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "Rdv" , /* Libell� */ "Consulter les Rendez-vous" + SEPERATEUR_2 + "Consulter les Rendez-vous" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "rdvCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
	/***
	 * VALIDER_CONSUL
	 */
	public static Traitement VALIDER_CONSUL;	
	static{
		
		VALIDER_CONSUL = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Consul" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la consultation ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "14", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement ENREG_CPTE_RENDU;	
	static{
		
		ENREG_CPTE_RENDU = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_CpteRendu" , /* Libell� */ "Enregistrer le compe rendu" , /* Commentaire */ "" , /* M�thode */ "enregistrerCpteRendu",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "000",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer l'enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F4", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_CPTE_RENDU;
	static{	
		NAVIGUER_CPTE_RENDU = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "CpteRenduConsul" , /* Libell� */ "Naviguer vers le conpte rendu" + SEPERATEUR_2 + "Naviguer vers le conpte rendu" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "cpteRenduConsulCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
}
