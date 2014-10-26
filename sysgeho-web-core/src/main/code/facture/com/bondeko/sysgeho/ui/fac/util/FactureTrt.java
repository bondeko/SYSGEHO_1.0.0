package com.bondeko.sysgeho.ui.fac.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class FactureTrt extends SysGehoTrt{
	
	
	/***
	 * VALIDER_FACTURE_COURANTE
	 */
	public static Traitement VALIDER_FACTURE_COURANTE;	
	static{
		
		VALIDER_FACTURE_COURANTE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_FacCour" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * PAYER_FACTURE_COURANTE
	 */
	public static Traitement PAYER_FACTURE_COURANTE;	
	static{
		
		PAYER_FACTURE_COURANTE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Pay_FacCour" , /* Libell� */ "Payer" , /* Commentaire */ "" , /* M�thode */ "payer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Payer la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_FACTURE_CONVENTIONNELLE
	 */
	public static Traitement VALIDER_FACTURE_CONVENTIONNELLE;	
	static{
		
		VALIDER_FACTURE_CONVENTIONNELLE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_FacConv" , /* Libell� */ "Valider" , /* Commentaire */ "" , /* M�thode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * PAYER_FACTURE_CONVENTIONNELLE
	 */
	public static Traitement PAYER_FACTURE_CONVENTIONNELLE;	
	static{
		
		PAYER_FACTURE_CONVENTIONNELLE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Pay_FacConv" , /* Libell� */ "Payer" , /* Commentaire */ "" , /* M�thode */ "payer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Payer la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * GEN_FAC_COUR
	 */
	public static Traitement GEN_FAC_COUR;	
	static{
		
		GEN_FAC_COUR = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "FacCour" , /* Libell� */ "G�n�rer la facture" , /* Commentaire */ "" , /* M�thode */ "genererFacCour",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilit� */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la g�n�ration ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "", /* index */ "18", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	
}
