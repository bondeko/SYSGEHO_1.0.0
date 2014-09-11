package com.bondeko.sysgeho.ui.fac.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class FactureTrt extends SysGehoTrt{
	
	
	/***
	 * VALIDER_FACTURE_COURANTE
	 */
	public static Traitement VALIDER_FACTURE_COURANTE;	
	static{
		
		VALIDER_FACTURE_COURANTE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_FacCour" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Valider la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * PAYER_FACTURE_COURANTE
	 */
	public static Traitement PAYER_FACTURE_COURANTE;	
	static{
		
		PAYER_FACTURE_COURANTE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Pay_FacCour" , /* Libellé */ "Payer" , /* Commentaire */ "" , /* Méthode */ "payer",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Payer la facture ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F3", /* index */ "13", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	
}
