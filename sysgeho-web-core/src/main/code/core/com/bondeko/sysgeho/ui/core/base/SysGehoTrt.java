package com.bondeko.sysgeho.ui.core.base;

import java.util.Map;
import java.util.TreeMap;

public class SysGehoTrt extends BasicTrt{
	
	/**
	 * Retourne la liste des traitements standards 
	 * 
	 * @param p$codeEntite	: Code de l'entité
	 * @return
	 */
	public static Map<String, Traitement> getTrtStandards() {
		return 	getTrtStandards("");
	}
	
	/**
	 * Retourne la liste des traitements standards pour une entité donnée
	 * 
	 * @param p$codeEntite	: Code de l'entité
	 * @return
	 */
	public static Map<String, Traitement> getTrtStandards(String p$codeEntite) {
		
		Traitement v$traitement;
		Map<String,Traitement> trtStandards = new TreeMap<String, Traitement>();
		
		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, SysGehoTrt.AJOUTER.getCode()), SysGehoTrt.AJOUTER);
		trtStandards.put(v$traitement.getKey(), v$traitement);
		
		
		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, SysGehoTrt.AFFICHER.getCode()), SysGehoTrt.AFFICHER);		
		trtStandards.put(v$traitement.getKey(), v$traitement);
	

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, SysGehoTrt.MODIFIER.getCode()), SysGehoTrt.MODIFIER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, SysGehoTrt.SELECTIONNER.getCode()), SysGehoTrt.SELECTIONNER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);

		v$traitement = new Traitement(Traitement.getCodeTrt(p$codeEntite, SysGehoTrt.SUPPRIMER.getCode()), SysGehoTrt.SUPPRIMER);				
		trtStandards.put(v$traitement.getKey(), v$traitement);
		
		
		
		return trtStandards;
		
	}

}
