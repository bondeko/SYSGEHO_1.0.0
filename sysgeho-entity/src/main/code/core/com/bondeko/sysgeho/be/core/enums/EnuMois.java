package com.bondeko.sysgeho.be.core.enums;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum EnuMois {


	JAN("2000", "Janvier"),
	
	FEV("2002", "Février"),
	
	MARS("2003", "Mars"),
	
	AVRIL("2004", "Avril"),
	
	MAI("2005", "Mai"),
	
	JUIN("2006", "Juin"),
	
	JUIL("2007", "Juillet"),
	
	AOUT("2008", "Août"),
	
	SEPT("2009", "Septembre"),
	
	OCT("2010", "Octobre"),
	
	NOV("2011", "Novembre"),
	
	DEC("2012", "Décembre");
	
	/**
	 * Valeur de l'énumération
	 */
	private final String value;
	/**
	 * libellé de la valeur
	 */
	private final String libelle;
	
	/**
	 * Construit un objet étant donnée une valeur et un libellé
	 * @param value : la valeur
	 * @param libelle : le libellé
	 */
	private EnuMois(String value, String libelle) {
		this.value = value;
		this.libelle = libelle;

	}
	/**
	 * Retourne la valeur de l'énumération
	 * @return value : la valeur retournée
	 */
	public String getValue() {
		return this.value;
	}
	/**
	 * Retourne le libellé de l'énumération
	 * @return libelle : le libellé
	 */
	public String getLibelle() {
		return this.libelle;
	}
	/**
	 * retourne une énumération en fonction de sa valeur
	 * @param enumValue
	 * @return
	 */
	public static EnuMois getByValue(String enumValue) {
		for (EnuMois enm : EnuMois.class
				.getEnumConstants()) {
			if (enm.getValue().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}

	private static List<EnuMois> myList;
	private static Map<String, String> myMap;

	/***
	 * Retourne la liste des valeurs de l'énum dans un map (Map<Code,Libelle>)
	 * 
	 * @return
	 */
	public static Map<String, String> getMaps() {
		return myMap;
	}

	public static List<EnuMois> getListe() {
		return myList;
	}

	static {
		myList = new ArrayList<EnuMois>();
		myMap = new TreeMap<String, String>();
		myMap.put("", "");
		for (EnuMois enm : EnuMois.class
				.getEnumConstants()) {
			myList.add(enm);
			myMap.put(enm.getValue(), enm.getLibelle());
		}
	}
	
}
