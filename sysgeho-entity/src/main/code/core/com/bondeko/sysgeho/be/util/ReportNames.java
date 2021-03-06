package com.bondeko.sysgeho.be.util;

public enum ReportNames {

	ETAT_LIST_PAT("ETAT_LISTE_PATIENT", "ETAT_LISTE_PATIENT",
			"ETAT_LISTE_PATIENT", "ETAT LISTE DES PATIENTS", " AND (1=1)",
			" AND (1=1)"),

	ETAT_FICHE_PAT("FichePatient", "FichePatient", "FichePatient",
			"FICHE PATIENT", " AND (1=1)", " AND (1=1)"),

	ETAT_CPTE_RENDU_CON("ETAT_CPTE_RENDU_CON", "ETAT_CPTE_RENDU_CON",
			"ETAT_CPTE_RENDU_CON", "COMPTE RENDU CONSULTATION", " AND (1=1)",
			" AND (1=1)"),

	ETAT_CPTE_RENDU_EXAM("ETAT_CPTE_RENDU_EXAM", "ETAT_CPTE_RENDU_EXAM",
			"ETAT_CPTE_RENDU_EXAM", "COMPTE RENDU EXAMEN", " AND (1=1)",
			" AND (1=1)"),
			ETAT_CPTE_RENDU_EXAM_LIST("ETAT_CPTE_RENDU_EXAM_LIST", "ETAT_CPTE_RENDU_EXAM_LIST",
					"ETAT_CPTE_RENDU_EXAM_LIST", "LISTE COMPTE RENDU EXAMEN", " AND (1=1)",
					" AND (1=1)"),
	
			ETAT_CERT_MED("ETAT_CERT_MED", "ETAT_CERT_MED",
					"ETAT_CERT_MED", "CERTIFICAT MEDICAL", " AND (1=1)",
					" AND (1=1)"),

	ETAT_FAC_COUR("FacCour", "FacCour", "FacCour", "FACTURE COURANTE",
			" AND (1=1)", " AND (1=1)"), ETAT_FAC_CONV("ETAT_FACT_CONV",
			"ETAT_FACT_CONV", "ETAT_FACT_CONV", "FACTURE CONVENTIONNELLE",
			" AND (1=1)", " AND (1=1)"), ETAT_LIST_FAC_CONV2(
			"ETAT_LIST_FAC_CONV2", "ETAT_LIST_FAC_CONV2",
			"ETAT_LIST_FAC_CONV2", "LISTE FACTURE CONVENTIONNELLE",
			" AND (1=1)", " AND (1=1)"), ETAT_LIST_SOC("ETAT_LIST_SOC",
			"ETAT_LIST_SOC", "ETAT_LIST_SOC", "LISTE DES SOCIETES",
			" AND (1=1)", " AND (1=1)"), ETAT_RAP_VM("ETAT_RAP_VM",
			"ETAT_RAP_VM", "ETAT_RAP_VM", "RAPPORT DE VISITE MEDICAL",
			" AND (1=1)", " AND (1=1)"), ETAT_DOSSIER_PAT("ETAT_DOSSIER_PAT",
			"ETAT_DOSSIER_PAT", "ETAT_DOSSIER_PAT", "DOSSIER PATIENT",
			" AND (1=1)", " AND (1=1)"), ETAT_CMPT_PREST("ETAT_CMPT_PREST",
			"ETAT_CMPT_PREST", "ETAT_CMPT_PREST", "ETAT COMPTABLE PRESTATION",
			" AND (1=1)", " AND (1=1)"), ETAT_LIST_EXAM("ETAT_LIST_EXAM",
			"ETAT_LIST_EXAM", "ETAT_LIST_EXAM", "ETAT FICHIER DES EXAMENS",
			" AND (1=1)", " AND (1=1)"), ETAT_CMPT_CONSUL("ETAT_CMPT_CONSUL",
			"ETAT_CMPT_CONSUL", "ETAT_CMPT_CONSUL",
			"ETAT COMPTABLE CONSULTATION", " AND (1=1)", " AND (1=1)")

	;

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
