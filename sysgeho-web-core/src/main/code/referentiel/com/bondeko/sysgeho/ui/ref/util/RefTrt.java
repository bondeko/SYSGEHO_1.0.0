package com.bondeko.sysgeho.ui.ref.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class RefTrt extends SysGehoTrt{
	
	public static Traitement GENERER_FACTURE_CONV;	
	static{
		
		GENERER_FACTURE_CONV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Gen_Fac_Conv" , /* Libell� */ "G�n�rer la facture conventionnelle" , /* Commentaire */ "" , /* M�thode */ "genererFacConvPreModal",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SPECIAL, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "10", /* reRender */ "mpnl_gen_facconv", /* image */ "" );
	}
	
	/***
	 * GEN_LIST_SOC
	 */
	public static Traitement GEN_LIST_SOC;	
	static{
		
		GEN_LIST_SOC = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "FacCour" , /* Libell� */ "G�n�rer la liste des soci�t�s" , /* Commentaire */ "" , /* M�thode */ "genererListSoc",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_VERS_FAC_CONV;
	static{	
		NAVIGUER_VERS_FAC_CONV = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "FacConv" , /* Libell� */ "Naviguer vers les factures conventionnelles" + SEPERATEUR_2 + "Naviguer vers les factures conventionnelles" , /* Commentaire */ "" , /* M�thode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "facConvCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "12");
	}	
	
}
