/**
 * 
 */
package com.bondeko.sysgeho.be.imp.serialiaze;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.enums.EnuTitre;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;

/**
 * @author STEPH
 * 
 */
public class SrlEtatDosPatElt {

	private String codPrestation;
	private String catPrestation;
	private String libPrestation;
	private String datPrestation;
	private String libDiagnostic;
	private String libResultat;
	private String libConcl;
	private String libSoc;
	private String libMat;
	private String libNom;
	private String datNais;
	private String libProf;
	private String libNumTel;

	/**
	 * Valeur à l'erreur
	 */
	private static String ERROR_VALUE = "";

	public SrlEtatDosPatElt() {

	}

	public SrlEtatDosPatElt(TabPat patient, TabConsul consul,
			TabCpteRenduConsul cpterenducon, TabExam exam,
			TabCpteRenduExam cpterenduexam, TabSoin soin, TabHospi hospi) {

		try {
			if (consul != null)
				this.codPrestation = consul.getCodConsul();
			if (exam != null)
				this.codPrestation = exam.getCodExam();
			if (soin != null)
				this.codPrestation = soin.getCodSoin();
			if (hospi != null)
				this.codPrestation = hospi.getCodHospi();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.catPrestation = "Consultation";
			if (exam != null)
				this.catPrestation = "Examen";
			if (soin != null)
				this.catPrestation = "Soin";
			if (hospi != null)
				this.catPrestation = "Hospitalisation";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.libPrestation = "Consultation en " + consul.getTabSpec().getLibSpec();
			if (exam != null)
				this.libPrestation = exam.getLibExam();
			if (soin != null)
				this.libPrestation = soin.getLibSoin();
			if (hospi != null)
				this.libPrestation = hospi.getLibMotif();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(consul.getDatConsul()));
			if (exam != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(exam.getDatExam()));
			if (soin != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(soin.getDatSoin()));
			if (hospi != null)
				this.datPrestation = "De "
						+ DateTools.formatDate("dd/MM/yyyy",
								DateTools.getDateValue(hospi.getDatAdmi()))
						+ " à " + DateTools.getDateValue(hospi.getDatSortie());
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (consul != null)
					if (cpterenducon != null)
						this.libDiagnostic = cpterenducon.getLibDiagPrin();
				if (exam != null)
					this.libDiagnostic = "";
				if (soin != null)
					this.libDiagnostic = soin.getLibMotif();
				if (hospi != null)
					this.libDiagnostic = hospi.getLibPrescri();
		} catch (Exception e) {
			this.libDiagnostic = ERROR_VALUE;
		}
		try {
			if (consul != null)
				if (cpterenducon != null)
					this.libResultat = cpterenducon.getLibTraitPres();
			if (exam != null)
				if (cpterenduexam != null)
					this.libResultat = cpterenduexam.getLibResul();
			if (soin != null)
				this.libResultat = soin.getLibObs();
			if (hospi != null)
				this.libResultat = hospi.getLibObs();
		} catch (Exception e) {
			this.libResultat = ERROR_VALUE;
		}
		try {
			if (consul != null)
				if (cpterenducon != null)
					this.libConcl = cpterenducon.getLibConcl();
			if (exam != null)
				if (cpterenduexam != null)
					this.libConcl = cpterenduexam.getLibConclu();
			if (soin != null)
				this.libConcl = " ";
			if (hospi != null)
				this.libConcl = " ";
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libSoc = patient.getTabSoc().getLibSoc();
		} catch (Exception e) {
			this.libSoc = ERROR_VALUE;
		}
		try {
			this.libMat = patient.getLibMat();
		} catch (Exception e) {
			this.libMat = ERROR_VALUE;
		}
		try {
			this.libNom = patient.getLibTit() + ". " + patient.getLibNom() + " " + patient.getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		try {
			this.datNais = DateTools.formatDate("dd/MM/yyyy",
					DateTools.getDateValue(patient.getDatNais()));
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libProf = patient.getLibProf();
		} catch (Exception e) {
			this.libProf = ERROR_VALUE;
		}
		try {
			this.libNumTel = patient.getLibNumTel();
		} catch (Exception e) {
			this.libNumTel = ERROR_VALUE;
		}
	}
	
	public SrlEtatDosPatElt(TabPat patient, TabConsul consul, TabCpteRenduConsul cpterenducon) {

		try {
			if (consul != null)
				this.codPrestation = consul.getCodConsul();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.catPrestation = "Consultation";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.libPrestation = "Consultation en " + consul.getTabSpec().getCodSpec();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (consul != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(consul.getDatConsul()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (consul != null)
					if (cpterenducon != null)
						this.libDiagnostic = cpterenducon.getLibDiagPrin();
		} catch (Exception e) {
			this.libDiagnostic = ERROR_VALUE;
		}
		try {
			if (consul != null)
				if (cpterenducon != null)
					this.libResultat = cpterenducon.getLibTraitPres();
		} catch (Exception e) {
			this.libResultat = ERROR_VALUE;
		}
		try {
			if (consul != null)
				if (cpterenducon != null)
					this.libConcl = cpterenducon.getLibConcl();
		} catch (Exception e) {
			this.libConcl = ERROR_VALUE;
		}
		try {
			this.libSoc = patient.getTabSoc().getLibSoc();
		} catch (Exception e) {
			this.libSoc = ERROR_VALUE;
		}
		try {
			this.libMat = patient.getLibMat();
		} catch (Exception e) {
			this.libMat = ERROR_VALUE;
		}
		try {
			this.libNom = EnuTitre.getByValue(patient.getLibTit()) + ". " + patient.getLibNom() + " " + patient.getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		try {
			this.datNais = DateTools.formatDate("dd/MM/yyyy",
					DateTools.getDateValue(patient.getDatNais()));
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libProf = patient.getLibProf();
		} catch (Exception e) {
			this.libProf = ERROR_VALUE;
		}
		try {
			this.libNumTel = patient.getLibNumTel();
		} catch (Exception e) {
			this.libNumTel = ERROR_VALUE;
		}
	}
	
	public SrlEtatDosPatElt(TabPat patient, TabExam exam, TabCpteRenduExam cpterenduexam) {

		try {
			if (exam != null)
				this.codPrestation = exam.getCodExam();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.catPrestation = "Examen";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.libPrestation = exam.getLibExam();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (exam != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(exam.getDatExam()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (exam != null)
					if (cpterenduexam != null)
						this.libDiagnostic = " ";
		} catch (Exception e) {
			this.libDiagnostic = ERROR_VALUE;
		}
		try {
			if (exam != null)
				if (cpterenduexam != null)
					this.libResultat = cpterenduexam.getLibResul();
		} catch (Exception e) {
			this.libResultat = ERROR_VALUE;
		}
		try {
			if (exam != null)
				if (cpterenduexam != null)
					this.libConcl = cpterenduexam.getLibConclu();
		} catch (Exception e) {
			this.libConcl = ERROR_VALUE;
		}
		try {
			this.libSoc = patient.getTabSoc().getLibSoc();
		} catch (Exception e) {
			this.libSoc = ERROR_VALUE;
		}
		try {
			this.libMat = patient.getLibMat();
		} catch (Exception e) {
			this.libMat = ERROR_VALUE;
		}
		try {
			this.libNom = EnuTitre.getByValue(patient.getLibTit()) + ". " + patient.getLibNom() + " " + patient.getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		try {
			this.datNais = DateTools.formatDate("dd/MM/yyyy",
					DateTools.getDateValue(patient.getDatNais()));
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libProf = patient.getLibProf();
		} catch (Exception e) {
			this.libProf = ERROR_VALUE;
		}
		try {
			this.libNumTel = patient.getLibNumTel();
		} catch (Exception e) {
			this.libNumTel = ERROR_VALUE;
		}
	}
	
	public SrlEtatDosPatElt(TabPat patient, TabSoin soin) {

		try {
			if (soin != null)
				this.codPrestation = soin.getCodSoin();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.catPrestation = "Soin";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.libPrestation = soin.getLibSoin();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (soin != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(soin.getDatSoin()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (soin != null)
					this.libDiagnostic = soin.getLibMotif();
		} catch (Exception e) {
			this.libDiagnostic = ERROR_VALUE;
		}
		try {
			if (soin != null)
				this.libResultat = soin.getLibObs();
		} catch (Exception e) {
			this.libResultat = ERROR_VALUE;
		}
		try {
			if (soin != null)
				this.libConcl = " ";
		} catch (Exception e) {
			this.libConcl = ERROR_VALUE;
		}
		try {
			this.libSoc = patient.getTabSoc().getLibSoc();
		} catch (Exception e) {
			this.libSoc = ERROR_VALUE;
		}
		try {
			this.libMat = patient.getLibMat();
		} catch (Exception e) {
			this.libMat = ERROR_VALUE;
		}
		try {
			this.libNom = EnuTitre.getByValue(patient.getLibTit()) + ". " + patient.getLibNom() + " " + patient.getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		try {
			this.datNais = DateTools.formatDate("dd/MM/yyyy",
					DateTools.getDateValue(patient.getDatNais()));
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libProf = patient.getLibProf();
		} catch (Exception e) {
			this.libProf = ERROR_VALUE;
		}
		try {
			this.libNumTel = patient.getLibNumTel();
		} catch (Exception e) {
			this.libNumTel = ERROR_VALUE;
		}
	}
	
	public SrlEtatDosPatElt(TabPat patient, TabHospi hospi) {

		try {
			if (hospi != null)
				this.codPrestation = hospi.getCodHospi();
		} catch (Exception e) {
			this.codPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.catPrestation = "Hospitalisation";
		} catch (Exception e) {
			this.catPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.libPrestation = hospi.getLibMotif();
		} catch (Exception e) {
			this.libPrestation = ERROR_VALUE;
		}

		try {
			if (hospi != null)
				this.datPrestation = DateTools.formatDate("dd/MM/yyyy",
						DateTools.getDateValue(hospi.getDatAdmi()));
		} catch (Exception e) {
			this.datPrestation = ERROR_VALUE;
		}
		try {
				if (hospi != null)
					this.libDiagnostic = hospi.getLibObs();
		} catch (Exception e) {
			this.libDiagnostic = ERROR_VALUE;
		}
		try {
			if (hospi != null)
				this.libResultat = hospi.getLibPrescri();
		} catch (Exception e) {
			this.libResultat = ERROR_VALUE;
		}
		try {
			if (hospi != null)
				this.libConcl = " ";
		} catch (Exception e) {
			this.libConcl = ERROR_VALUE;
		}
		try {
			this.libSoc = patient.getTabSoc().getLibSoc();
		} catch (Exception e) {
			this.libSoc = ERROR_VALUE;
		}
		try {
			this.libMat = patient.getLibMat();
		} catch (Exception e) {
			this.libMat = ERROR_VALUE;
		}
		try {
			this.libNom = EnuTitre.getByValue(patient.getLibTit()) + ". " + patient.getLibNom() + " " + patient.getLibPre();
		} catch (Exception e) {
			this.libNom = ERROR_VALUE;
		}
		try {
			this.datNais = DateTools.formatDate("dd/MM/yyyy",
					DateTools.getDateValue(patient.getDatNais()));
		} catch (Exception e) {
			this.datNais = ERROR_VALUE;
		}
		try {
			this.libProf = patient.getLibProf();
		} catch (Exception e) {
			this.libProf = ERROR_VALUE;
		}
		try {
			this.libNumTel = patient.getLibNumTel();
		} catch (Exception e) {
			this.libNumTel = ERROR_VALUE;
		}
	}


	/**
	 * @return the codPrestation
	 */
	public String getCodPrestation() {
		return codPrestation;
	}

	/**
	 * @param codPrestation the codPrestation to set
	 */
	public void setCodPrestation(String codPrestation) {
		this.codPrestation = codPrestation;
	}

	/**
	 * @return the catPrestation
	 */
	public String getCatPrestation() {
		return catPrestation;
	}

	/**
	 * @param catPrestation the catPrestation to set
	 */
	public void setCatPrestation(String catPrestation) {
		this.catPrestation = catPrestation;
	}

	/**
	 * @return the libPrestation
	 */
	public String getLibPrestation() {
		return libPrestation;
	}

	/**
	 * @param libPrestation the libPrestation to set
	 */
	public void setLibPrestation(String libPrestation) {
		this.libPrestation = libPrestation;
	}

	/**
	 * @return the datPrestation
	 */
	public String getDatPrestation() {
		return datPrestation;
	}

	/**
	 * @param datPrestation the datPrestation to set
	 */
	public void setDatPrestation(String datPrestation) {
		this.datPrestation = datPrestation;
	}

	/**
	 * @return the libDiagnostic
	 */
	public String getLibDiagnostic() {
		return libDiagnostic;
	}

	/**
	 * @param libDiagnostic the libDiagnostic to set
	 */
	public void setLibDiagnostic(String libDiagnostic) {
		this.libDiagnostic = libDiagnostic;
	}

	/**
	 * @return the libResultat
	 */
	public String getLibResultat() {
		return libResultat;
	}

	/**
	 * @param libResultat the libResultat to set
	 */
	public void setLibResultat(String libResultat) {
		this.libResultat = libResultat;
	}

	/**
	 * @return the libConcl
	 */
	public String getLibConcl() {
		return libConcl;
	}

	/**
	 * @param libConcl the libConcl to set
	 */
	public void setLibConcl(String libConcl) {
		this.libConcl = libConcl;
	}

	/**
	 * @return the libSoc
	 */
	public String getLibSoc() {
		return libSoc;
	}

	/**
	 * @param libSoc the libSoc to set
	 */
	public void setLibSoc(String libSoc) {
		this.libSoc = libSoc;
	}

	/**
	 * @return the libMat
	 */
	public String getLibMat() {
		return libMat;
	}

	/**
	 * @param libMat the libMat to set
	 */
	public void setLibMat(String libMat) {
		this.libMat = libMat;
	}

	/**
	 * @return the libNom
	 */
	public String getLibNom() {
		return libNom;
	}

	/**
	 * @param libNom the libNom to set
	 */
	public void setLibNom(String libNom) {
		this.libNom = libNom;
	}

	/**
	 * @return the datNais
	 */
	public String getDatNais() {
		return datNais;
	}

	/**
	 * @param datNais the datNais to set
	 */
	public void setDatNais(String datNais) {
		this.datNais = datNais;
	}

	/**
	 * @return the libProf
	 */
	public String getLibProf() {
		return libProf;
	}

	/**
	 * @param libProf the libProf to set
	 */
	public void setLibProf(String libProf) {
		this.libProf = libProf;
	}

	/**
	 * @return the libNumTel
	 */
	public String getLibNumTel() {
		return libNumTel;
	}

	/**
	 * @param libNumTel the libNumTel to set
	 */
	public void setLibNumTel(String libNumTel) {
		this.libNumTel = libNumTel;
	}
	
	

}
