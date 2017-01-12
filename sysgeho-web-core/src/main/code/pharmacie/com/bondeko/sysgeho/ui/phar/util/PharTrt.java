package com.bondeko.sysgeho.ui.phar.util;

import com.bondeko.sysgeho.ui.core.base.SysGehoTrt;
import com.bondeko.sysgeho.ui.core.base.Traitement;

public class PharTrt extends SysGehoTrt{
	
	public static Traitement ENREG_QTE;	
	static{
		ENREG_QTE = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Enreg_Qte" , /* Libellé */ "Enregistrer quantite" , /* Commentaire */ "" , /* Méthode */ "enregistrerQte",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer Enregistrement ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F1", /* index */ "11", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	/***
	 * VALIDER_MOUV
	 */
	public static Traitement VALIDER_MOUV;	
	static{
		
		VALIDER_MOUV = new Traitement(/* Type */Traitement.SPECIFIQUE , /* Code */ "Val_Mouv" , /* Libellé */ "Valider" , /* Commentaire */ "" , /* Méthode */ "valider",
				/* Config IHM */ new boolean[]{true,true,true,false} , /* Config Visibilité */ "112",
				/* Type de modal panel */ Traitement.MODAL_SIMPLE, /* Message du modal panel */ "Confirmer la Validation du mouvement de stock ?", /* Type de progress bar */ Traitement.PROGRESS_SIMPLE, 
				/* Raccourci clavier */ "Shift+F2", /* index */ "12", /* reRender */ Traitement.RERENDER_MAIN_PANEL, /* image */ "" );
	}
	
	public static Traitement NAVIGUER_MOUV;
	static{	
		NAVIGUER_MOUV = new Traitement  (/* Type */Traitement.NAVIGATION , /* Code */ "MouvStock" , /* Libellé */ "Naviguer vers les mouvemets de stock" + SEPERATEUR_2 + "Naviguer vers les mouvemets de stock" , /* Commentaire */ "" , /* Méthode */ Traitement.METHODE_NAVIGATION,
			/* Config IHM */ new boolean[]{true,true,true,false} , 
			/* Controleur de la destination */ "mouvStockCtrl", /* Type de progress bar */ Traitement.PROGRESS_NO, 
			/* Raccourci clavier */ "", /* index */ "13");
	}
	
}
