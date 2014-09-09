package com.bondeko.sysgeho.be.util;


public enum ReportNames {

	ETAT_LIST_PAT("ETAT_LISTE_PATIENT", "ETAT_LISTE_PATIENT", "ETAT_LISTE_PATIENT",
			"ETAT LISTE DES PATIENTS",
			" AND (1=1)", " AND (1=1)"),
	
	ETAT_DEC_IMP("ETAT_DECLARATION_IMPORT", "ETAT_DECLARATION_IMPORT", "ETAT_DECLARATION_IMPORT",
			"ETAT DECLARATION D'IMPORTATION",
			" AND (1=1)", " AND (1=1)"),

	ETAT_AUT_SPE_IMP("ETAT_AUTORISATION_SPEC_IMPORT", "ETAT_AUTORISATION_SPEC_IMPORT", "ETAT_AUTORISATION_SPEC_IMPORT",
			"ETAT AUTORISATION SPECIALE D'IMPORTATION",
			" AND (1=1)", " AND (1=1)");



	private final String reportName;
	private final String defaulFileName;
	private final String description;
	private final String jpqlWhereClause;
	private final String sqlWhereClause;
	private final String libelle;

	// private TblLgnBdg lgn;
	private ReportNames(String libbele, String reportName, String fileName,
			String description, String jpqlwhereClause, String sqlwhereClause) {
		this.reportName = reportName;
		this.description = description;
		this.defaulFileName = fileName;
		this.jpqlWhereClause = jpqlwhereClause;
		this.libelle = libbele;
		this.sqlWhereClause = sqlwhereClause;
	}

	private ReportNames(String libbele, String reportName) {
		this.reportName = reportName;
		this.description = "";
		this.defaulFileName = "";
		this.jpqlWhereClause = "";
		this.libelle = libbele;
		this.sqlWhereClause = "";
	}

	public static ReportNames getByName(String rptName) {
		for (ReportNames rpt : ReportNames.class.getEnumConstants()) {
			if (rpt.name().equalsIgnoreCase(rptName))
				return rpt;
		}
		return null;
	}

	public String getJpqlWhereClause(String valeurCategorie) {
		return this.jpqlWhereClause.replaceAll("cat", valeurCategorie);
	}

	public String getSqlWhereClause(String valeurCategorie) {
		return this.sqlWhereClause.replaceAll("cat", valeurCategorie);
	}

	public String getLibelle() {
		return this.libelle;
	}

	public String getReportName() {
		return reportName;
	}

	public String getDescription() {
		return description;
	}

	public String getDefaulFileName() {
		return defaulFileName;
	}

}
