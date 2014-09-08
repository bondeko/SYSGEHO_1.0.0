package com.bondeko.sysgeho.be.core.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum EnuTitre {
	
	ENF("2000", "Enf."),
	
	MR("2001", "Mr."),
	
	MME("2002", "Mme."),
	
	MLLE("2003", "Mlle."),
	
	PROF("2004", "Prof."),
	
	DR("2005", "Dr."),
	
	ING("2006", "Ing."),
	
	MTRE("2007", "Mtre.");
	
	/**
	 * Valeur de l'�num�ration
	 */
	private final String value;
	/**
	 * libell� de la valeur
	 */
	private final String libelle;
	
	/**
	 * Construit un objet �tant donn�e une valeur et un libell�
	 * @param value : la valeur
	 * @param libelle : le libell�
	 */
	private EnuTitre(String value, String libelle) {
		this.value = value;
		this.libelle = libelle;

	}
	/**
	 * Retourne la valeur de l'�num�ration
	 * @return value : la valeur retourn�e
	 */
	public String getValue() {
		return this.value;
	}
	/**
	 * Retourne le libell� de l'�num�ration
	 * @return libelle : le libell�
	 */
	public String getLibelle() {
		return this.libelle;
	}
	/**
	 * retourne une �num�ration en fonction de sa valeur
	 * @param enumValue
	 * @return
	 */
	public static EnuTitre getByValue(String enumValue) {
		for (EnuTitre enm : EnuTitre.class
				.getEnumConstants()) {
			if (enm.getValue().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}

	private static List<EnuTitre> myList;
	private static Map<String, String> myMap;

	/***
	 * Retourne la liste des valeurs de l'�num dans un map (Map<Code,Libelle>)
	 * 
	 * @return
	 */
	public static Map<String, String> getMaps() {
		return myMap;
	}

	public static List<EnuTitre> getListe() {
		return myList;
	}

	static {
		myList = new ArrayList<EnuTitre>();
		myMap = new TreeMap<String, String>();
		myMap.put("", "");
		for (EnuTitre enm : EnuTitre.class
				.getEnumConstants()) {
			myList.add(enm);
			myMap.put(enm.getValue(), enm.getLibelle());
		}
	}

}
