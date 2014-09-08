package com.bondeko.sysgeho.ui.imp.controleur;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.svco.base.IBaseSvco;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.entity.TabHospi;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;
import com.bondeko.sysgeho.be.imp.entity.TabSoin;
import com.bondeko.sysgeho.be.ref.entity.TabAss;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.EntFichier;
<<<<<<< .mine
import com.bondeko.sysgeho.be.util.OutputType;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
=======
>>>>>>> .r53
import com.bondeko.sysgeho.ui.core.base.ExportFormatElt;
import com.bondeko.sysgeho.ui.core.base.FacesUtil;
import com.bondeko.sysgeho.ui.core.base.ServiceLocatorException;
import com.bondeko.sysgeho.ui.core.base.SysGehoCtrl;
import com.bondeko.sysgeho.ui.core.base.SysGehoToolBox;
import com.bondeko.sysgeho.ui.core.base.Traitement;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientSvcoDeleguate;
import com.bondeko.sysgeho.ui.imp.util.DossierPatientTrt;
import com.bondeko.sysgeho.ui.imp.vue.PatVue;

public class PatCtrl extends SysGehoCtrl<TabPat, TabPat>{
	
	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "patCtrl";
	
	protected List<ExportFormatElt> exportFormatElts = new ArrayList<ExportFormatElt>();
	
	public PatCtrl(){		
		defaultVue = new PatVue();		
	}
	
	/**
	 * Retourne le nom du Bean Managé par JSF dans le Fichier de Configuration
	 * Utilile pour ne pas avoir a ecrire le nom des Beans en dur dans le Code
	 * @return
	 */
	public String getNomManagedBean(){
		return nomManagedBean;
	}	
	
	public IBaseSvco<TabPat> getEntitySvco() throws ServiceLocatorException{	
		return DossierPatientSvcoDeleguate.getSvcoPat();
	}
	
	public Class<PatCtrl> getMyClass() {
		return PatCtrl.class;
	}
	
	public String enregistrerModification(){
		try {
			getEntitySvco().modifier(defaultVue.getEntiteCourante());
		} catch (SysGehoAppException e) {
			e.printStackTrace();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
		return "PatDetails";
	}

	@Override
	public List<Traitement> getListeTraitements() {
		String v$codeEntite = "Pat";

		// Ensemble des traitements standards
		Map<String, Traitement> v$mapTrt = new TreeMap<String, Traitement>(
				DossierPatientTrt.getTrtStandards(v$codeEntite));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_RDV.getKey(), new Traitement(DossierPatientTrt.ENREG_RDV));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_HOSPI.getKey(), new Traitement(DossierPatientTrt.ENREG_HOSPI));
		
<<<<<<< .mine
		// Générer l'état des mouvements du conteneur
		Traitement v$traitementGenListPat = new Traitement(
				DossierPatientTrt.ETA_LIST_PAT);
		v$traitementGenListPat.setModalType(Traitement.MODAL_SPECIAL);
		//v$traitementGenMouv.setModalPanel("mpnl_date_gen_mouv_con"); 
		v$traitementGenListPat.setMethode("genEtatListPat");
		v$mapTrt.put(v$traitementGenListPat.getKey(), v$traitementGenListPat);
		
=======
		v$mapTrt.put(DossierPatientTrt.ENREG_CONSUL.getKey(), new Traitement(DossierPatientTrt.ENREG_CONSUL));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_EXAM.getKey(), new Traitement(DossierPatientTrt.ENREG_EXAM));
		
		v$mapTrt.put(DossierPatientTrt.ENREG_SOIN.getKey(), new Traitement(DossierPatientTrt.ENREG_SOIN));
		
		v$mapTrt.put(DossierPatientTrt.EXP_ETA_PAT.getKey(), new Traitement(DossierPatientTrt.EXP_ETA_PAT));
		
>>>>>>> .r53
		Traitement v$traitement = new Traitement(
				DossierPatientTrt.NAVIGUER_RDV.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_RDV);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
		Traitement v$traitement2 = new Traitement(
				DossierPatientTrt.NAVIGUER_HOSPI.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_HOSPI);
		v$mapTrt.put(v$traitement2.getKey(), v$traitement2);
		
		Traitement v$traitement3 = new Traitement(
				DossierPatientTrt.NAVIGUER_EXAMEN.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_EXAMEN);
		v$mapTrt.put(v$traitement3.getKey(), v$traitement3);
		
		Traitement v$traitement4 = new Traitement(
				DossierPatientTrt.NAVIGUER_CONSULTATION.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_CONSULTATION);
		v$mapTrt.put(v$traitement4.getKey(), v$traitement4);
		
		Traitement v$traitement5 = new Traitement(
				DossierPatientTrt.NAVIGUER_VERS_SOIN.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_VERS_SOIN);
		v$mapTrt.put(v$traitement5.getKey(), v$traitement5);
		
		listeTraitements = Traitement.getOrderedTrt(v$mapTrt);
		return listeTraitements;
	}

	@Override
	public  void  buildListeTraitement(){

		if(getMapTraitements() == null){
			setMapTraitements(DossierPatientTrt.getTrtStandards("Pat")) ;
		}	
	}

	@Override
	public List<TabPat> rechercherParCritere(TabPat p$entity)
			throws SysGehoAppException {
		try {
			super.setTimeOfLastSearch();
			return DossierPatientSvcoDeleguate.getSvcoPat().rechercherParCritere(p$entity);
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}catch (SysGehoAppException e) {
			SysGehoAppException sdr = new SysGehoAppException(e.getMessage());
			throw sdr;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String gotoRelatedEntity() {

		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = super.gotoRelatedEntity();
		/*
		 * Recuperation du controleur 
		 * NB: 
		 * 	1-Cette méthode suppose que le controleur est bel et bien dans le Scope Session
		 * 	2-Par ailleurs il devrait normalement déja existé du fait du passage de paramètres dans la page web
		 */
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));

		// Si la navigation s'effectue vers les rendez vous
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_RDV
				.naviguerVersFormulaireListe())) {
			
			TabRdv rdv = new TabRdv();
			rdv.initData();
			rdv.setTabPat(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(rdv);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_HOSPI
				.naviguerVersFormulaireListe())) {
			
			TabHospi hospi = new TabHospi();
			hospi.initData();
			hospi.setTabPat(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(hospi);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return v$navigation;
	}
	
	public String navigerExam(){
		
		String v$navigation = super.gotoRelatedEntity();
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_EXAMEN
				.naviguerVersFormulaireListe())) {
			
			TabExam exam = new TabExam();
			exam.initData();
			exam.setTabPat(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(exam);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return v$navigation;
	}
	
	public String naviguerConsul(){
		
		String v$navigation = super.gotoRelatedEntity();
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_CONSULTATION
				.naviguerVersFormulaireListe())) {
			
			TabConsul consul = new TabConsul();
			consul.initData();
			consul.setTabPat(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(consul);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return v$navigation;
	}
	
	public String naviguerSoin(){
		
		String v$navigation = super.gotoRelatedEntity();
		SysGehoCtrl<BaseEntity, BaseEntity> v$controleur  =  (SysGehoCtrl<BaseEntity, BaseEntity>) FacesUtil.getSessionMapValue(SysGehoToolBox.getManagedBeanName(v$navigation));
		if (v$navigation.equals(DossierPatientTrt.NAVIGUER_VERS_SOIN
				.naviguerVersFormulaireListe())) {
			
			TabSoin soin = new TabSoin();
			soin.initData();
			soin.setTabPat(defaultVue.getEntiteCourante());

			try {
				v$navigation = v$controleur.naviguerVersDetailsOuListe(soin);
			} catch (Exception e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return v$navigation;
	}
	
	public void setSelectedEntity(BaseEntity p$entite) {

		// Nom de la propriété à mettre à jour pour
		String v$propriete = defaultVue.getNavigationMgr().getSelectionPropertyName();

		if (v$propriete.equals("tabSoc")) {
			TabSoc v$entite = (TabSoc) p$entite;
			defaultVue.getEntiteCourante().setTabSoc(v$entite);
		}

		if (v$propriete.equals("tabAss")) {
			TabAss v$entite = (TabAss) p$entite;
			defaultVue.getEntiteCourante().setTabAss(v$entite);
		}
	}
	
	public String exporterPatients() {

		String v$navigation = null;
		String sheetname = "Etat général des patients";
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		Label label = null;
		WritableFont font = null;
		WritableCellFormat format = null;
		Colour colour = null;
		File file = null;
		File dir = null;
		int ligne = 0;
		int colonne = 0;
		int finish = 0;
		int index = 0;

		String filename = "Patiens";
		// Début de l'exportation
		getLogger().debug("Début de l' exportation ...");


		// /On crée le fichier excell
		// /avec le format approprié
		try {

			//recherche tous les mouvements en BD
			List<TabPat> allPat = DossierPatientSvcoDeleguate.getSvcoPat().rechercherTout(new TabPat());
			getLogger().debug("Nombre d'éléments à exporter: " + allPat.size());

			file = new File(filename);
			dir = new File("E:/");
			file = File.createTempFile(filename, ".xls", null);

			sheetname = filename;
			workbook = Workbook.createWorkbook(file);
			sheet = workbook.createSheet(sheetname, 0);

			// Create a cell format for Times 16, bold and italic
			font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false);
			format = new WritableCellFormat(font);

			List<ExportFormatElt> elts = new ArrayList<ExportFormatElt>();
			elts.addAll(getExportFormatElts());
			ExportFormatElt eof = new ExportFormatElt();
			
			for (ExportFormatElt elt : elts) {

				label = new Label(colonne, 0, elt.getColumnName());
				if (label.getContents().equals("-1")) {
					font = new WritableFont(WritableFont.ARIAL, 11,
							WritableFont.BOLD, false);
					colour = Colour.WHITE;
					font.setColour(colour);
					format = new WritableCellFormat(font);
					format.setBackground(Colour.BRIGHT_GREEN);
					label.setCellFormat(format);
				} else {
					font = new WritableFont(WritableFont.ARIAL, 11,
							WritableFont.BOLD, false);
					colour = Colour.BLACK;
					font.setColour(colour);
					format = new WritableCellFormat(font);
					format.setBackground(Colour.BRIGHT_GREEN);
					label.setCellFormat(format);
				}
				
				sheet.setColumnView(colonne, elt.getColumnName().length()+10);
				sheet.addCell(label);
				++colonne;
			}

			ligne = 0;

			// /On fabrique les données du tableau
			// /en parcourant les éléments sélectionnés
			// /à exporter
			colonne = 0;
			TabPat patient;
			String val = null;
			elts.remove(eof);
			for (int i = 0; i < allPat.size(); ++i) {
				patient = allPat.get(i);

				try {
					val = patient.getCodPat();
					label = new Label(0, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibMat();
					label = new Label(1, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibNom();
					label = new Label(2, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibPre();
					label = new Label(3, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = DateTools.formatDate("dd/MM/yyyy", DateTools.getDateValue(patient.getDatNais()));
					label = new Label(4, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibTit();
					label = new Label(5, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLEnuStaMat();
					label = new Label(6, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibSex();
					label = new Label(7, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getLibAdr();
					label = new Label(8, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}


				try {
					val = patient.getLibNumTel();
					label = new Label(9, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					val = patient.getBEstAff() ? "OUI" : "NON" ;
					label = new Label(10, i + 2, val);
					sheet.addCell(label);
				}catch (Exception e) {
					val = "" ;
				}

				try {
					if(patient.getTabSoc()!=null) val = patient.getTabSoc().getLibSoc();
					label = new Label(11, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
					val = "" ;
				}
				
				try {
					val = patient.getBEstAss() ? "OUI" : "NON" ;
					label = new Label(12, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
					val = "" ;
				}
				
				try {
					if(patient.getTabAss() != null) val = patient.getTabAss().getLibAss();
					label = new Label(13, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
					val = "" ;
				}

				try {
					val = patient.getLibMed();
					label = new Label(14, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
				}

				finish = i + 2;
				++finish;
			}

			// /Marquer la fin du fichier
			// /en terme de lignes
			for (ExportFormatElt elt : elts) {
				index = elt.getColumnIndex();
				label = new Label(index, finish, "-1");

				font = new WritableFont(WritableFont.TIMES, 10,
						WritableFont.BOLD, false);
				colour = Colour.WHITE;
				font.setColour(colour);
				format = new WritableCellFormat(font);
				label.setCellFormat(format);

				sheet.addCell(label);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getLogger().debug("Problème lors de la creation du fichier !");
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getLogger().debug("Problème de dépassement de lignes !");
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getLogger().debug("Problème d'écriture dans une cellule !");
		} catch (SysGehoAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceLocatorException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// /Release resources
			if (workbook != null) {
				try {
					workbook.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					workbook.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

		// /Enfin on download le fichier
		// /via le navigateur
		// Download du Fichier Joint
		BufferedInputStream in = null;
		ServletOutputStream out = null;
		if (file != null) {
			try {
			 v$navigation = preview(EntFichier.readFile(file.getAbsolutePath()) , "xls");
//		      InputStream fis = new FileInputStream(file);
//		      byte[] buf = new byte[1024];
//		      int offset = 0;
//		      int numRead = 0;
//		      while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length -offset)) >= 0)) 
//		      {
//		        offset += numRead;
//		      }
//		      fis.close();
//		      HttpServletResponse response =
//		         (HttpServletResponse) FacesContext.getCurrentInstance()
//		        .getExternalContext().getResponse();
//
//		     response.setContentType("application/octet-stream");
//		     response.addHeader("Content-Disposition", "attachment; filename=\""	+ file.getAbsolutePath() + "\"");
//		     
//				response.getOutputStream().write(buf);
//				 response.getOutputStream().flush();
//			     response.getOutputStream().close();
//			     FacesContext.getCurrentInstance().responseComplete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		exportFormatElts = new ArrayList<ExportFormatElt>();
		return v$navigation;
	}
	
	//On construit la liste des colonnes
	public List<ExportFormatElt> getExportFormatElts(){

		ExportFormatElt eltCodPat = new ExportFormatElt();
		eltCodPat.setColumnName("Code Patient");
		exportFormatElts.add(eltCodPat);

		ExportFormatElt eltMat = new ExportFormatElt();
		eltMat.setColumnName("Matricule patient");
		exportFormatElts.add(eltMat);

		ExportFormatElt eltNom = new ExportFormatElt();
		eltNom.setColumnName("Nom");
		exportFormatElts.add(eltNom);
		
		ExportFormatElt eltPreNom = new ExportFormatElt();
		eltPreNom.setColumnName("Prénom");
		exportFormatElts.add(eltPreNom);
		
		ExportFormatElt eltDatNais = new ExportFormatElt();
		eltDatNais.setColumnName("Date Naissance");
		exportFormatElts.add(eltDatNais);
		
		ExportFormatElt eltTitre = new ExportFormatElt();
		eltTitre.setColumnName("Titre");
		exportFormatElts.add(eltTitre);
		
		ExportFormatElt eltStaMat = new ExportFormatElt();
		eltStaMat.setColumnName("Statut Matrimonial");
		exportFormatElts.add(eltStaMat);

		ExportFormatElt eltSex = new ExportFormatElt();
		eltSex.setColumnName("Sexe");
		exportFormatElts.add(eltSex);

		ExportFormatElt eltAdd = new ExportFormatElt();
		eltAdd.setColumnName("Adresse");
		exportFormatElts.add(eltAdd);

		ExportFormatElt eltNumTel = new ExportFormatElt();
		eltNumTel.setColumnName("N° Téléphone");
		exportFormatElts.add(eltNumTel);
		
		ExportFormatElt eltAff = new ExportFormatElt();
		eltAff.setColumnName("Est Affilié");
		exportFormatElts.add(eltAff);
		
		ExportFormatElt eltSoc = new ExportFormatElt();
		eltSoc.setColumnName("Société");
		exportFormatElts.add(eltSoc);
		
		ExportFormatElt eltAAss = new ExportFormatElt();
		eltAAss.setColumnName("Est Assuré");
		exportFormatElts.add(eltAAss);
		
		ExportFormatElt eltAssur = new ExportFormatElt();
		eltAssur.setColumnName("Assureur");
		exportFormatElts.add(eltAssur);

		ExportFormatElt eltMed = new ExportFormatElt();
		eltMed.setColumnName("Médecin traitant");
		exportFormatElts.add(eltMed);


		return  exportFormatElts;

	}
	
	@SuppressWarnings({ "finally", "unchecked" })
	public String enregistrerRdv() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			RdvCtrl rdvCtrl = (RdvCtrl) FacesUtil
			.getSessionMapValue(new RdvCtrl().getNomManagedBean2());

			if (rdvCtrl == null) {
				rdvCtrl = new RdvCtrl();
				
				FacesUtil.setSessionMapValue(rdvCtrl.getNomManagedBean2(),
						rdvCtrl);
			}
			
			TabPat pat = getDefaultVue().getEntiteCourante();
			
			TabRdv rdv = new TabRdv(pat.getInfoUser());
			rdv.setTabPat(pat);		
			rdvCtrl.getDefaultVue().setEntiteCourante(rdv);
			rdvCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "RdvEdition";
//		finally {
//			// Retour à la page adéquate
//			return v$navigation;
//		}
	}
	
	/**
	 * Génére un ordre de transport
	 * 
	 * @return un message  sur l'état de l'opération
	 */
	@SuppressWarnings("finally")
	public String genEtatListPat() {
	// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;

		// Message d'information
		String v$msgDetails = "GENERATION_SUCCES";

		try {
			PatVue v$vue = (PatVue) defaultVue;

//			String choix = defaultVue.getEntiteCourante().getChoix();
//			String enuTypMouv = defaultVue.getEntiteCourante().getEnuTypMouv() ;
//			String datDeb = defaultVue.getEntiteCourante().getDatDeb();
//			String datFin = defaultVue.getEntiteCourante().getDatFin();
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			defaultVue.setEntiteCouranteOfPageContext();

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());

			// Spécification du type de génération du fichier
			OutputType outputType = OutputType.PDF;

			// Consommation du service distant
			TabPat patient = defaultVue.getEntiteCourante();
			
			
			EntFichier v$fichier = DossierPatientSvcoDeleguate.getSvcoPat().genererEtatListPat(patient);

			// création de dossier et fichiers temporaires et affichage de
			// l'état généré
			v$navigation = preview(v$fichier, outputType.getExtension());
			
			// L'on remplace l'ancienne entité de la liste par la nouvelle issue
			// du résultat du traitement spécifiques
			 defaultVue.getTableMgr().replace(defaultVue.getEntiteTemporaire(),
					 defaultVue.getEntiteCourante());

			// Si nous sommes en Consultation ==> sur le formulaire Details
			if (defaultVue.getNavigationMgr().isFromDetails()) {
				// Traitements particuliers
			}

			// Par contre si nous sommes sur le formulaire Liste
			else if (defaultVue.getNavigationMgr().isFromListe()) {
				// Traitements particuliers
			}
			FacesUtil.addInfoMessage("GENERATION_SUCCES", v$msgDetails);

		} catch (SysGehoAppException e) {
			// Aucune navigation possible
			v$navigation = null;

			// Message utilisateur
			FacesUtil
					.addWarnMessage("TRAITEMENT_ALL_ECHEC", e.getMessage());
			getLogger().error(e.getMessage(), e);
		} catch (Exception e) {
			// Aucune navigation possible
			e.printStackTrace();
			v$navigation = null;
			// Message utilisateur
			FacesUtil
					.addWarnMessage(
							"TRAITEMENT_ALL_ECHEC","TRAITEMENT_ALL_ECHEC_INCONNU");
			getLogger().error(e.getMessage(), e);
		} finally {
			// Retour à la page adéquate
			return v$navigation;
		}

	}

	
	@SuppressWarnings({ "finally", "unchecked" })
	public String hospitaliserPat() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			HospiCtrl hospiCtrl = (HospiCtrl) FacesUtil
			.getSessionMapValue(new HospiCtrl().getNomManagedBean2());

			if (hospiCtrl == null) {
				hospiCtrl = new HospiCtrl();
				
				FacesUtil.setSessionMapValue(hospiCtrl.getNomManagedBean2(),
						hospiCtrl);
			}
			
			TabPat pat = getDefaultVue().getEntiteCourante();
			
			// On recherche si le patient n'a pas une hospitalisation en cours
			TabHospi hospiRech = DossierPatientSvcoDeleguate.getSvcoHospi().rechercherParCodPat(pat.getCodPat());
			if(hospiRech != null){
				FacesUtil.addWarnMessage("", "Il existe déjà une hospitalisation en cours pour le patient "+ pat.getLibNom());
				return null;
			}
			
			TabHospi hospi = new TabHospi(pat.getInfoUser());
			hospi.initData();
			hospi.setTabPat(pat);	
			hospiCtrl.getDefaultVue().setEntiteCourante(hospi);
			hospiCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "HospiEdition";
	}
	
	public String consulter() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			ConsulCtrl consulCtrl = (ConsulCtrl) FacesUtil
			.getSessionMapValue(new ConsulCtrl().getNomManagedBean2());

			if (consulCtrl == null) {
				consulCtrl = new ConsulCtrl();
				
				FacesUtil.setSessionMapValue(consulCtrl.getNomManagedBean2(),
						consulCtrl);
			}
			
			TabPat pat = getDefaultVue().getEntiteCourante();
			
			TabConsul consul = new TabConsul(pat.getInfoUser());
			consul.initData();
			consul.setTabPat(pat);	
			consulCtrl.getDefaultVue().setEntiteCourante(consul);
			consulCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "ConsulEdition";
	}
	
	public String examiner() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			ExamCtrl examCtrl = (ExamCtrl) FacesUtil
			.getSessionMapValue(new ExamCtrl().getNomManagedBean2());

			if (examCtrl == null) {
				examCtrl = new ExamCtrl();
				
				FacesUtil.setSessionMapValue(examCtrl.getNomManagedBean2(),
						examCtrl);
			}
			
			TabPat pat = getDefaultVue().getEntiteCourante();
			
			TabExam exam = new TabExam(pat.getInfoUser());
			exam.initData();
			exam.setTabPat(pat);	
			examCtrl.getDefaultVue().setEntiteCourante(exam);
			examCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "ExamEdition";
	}
	
	public String enregistrerSoin() {
		
		String v$navigation = null;
		
		try {
			// Mise à jour de l'entité courante selon le contexte du Formulaire
			if (defaultVue.getNavigationMgr().isFromListe())
				defaultVue.setEntiteCourante(defaultVue.getTableMgr()
						.getEntiteSelectionne());

			// Sauvegarde de l'entité avant traitement specifique
			defaultVue.setEntiteTemporaire(defaultVue.getEntiteCourante());
			
			SoinCtrl soinCtrl = (SoinCtrl) FacesUtil
			.getSessionMapValue(new SoinCtrl().getNomManagedBean2());

			if (soinCtrl == null) {
				soinCtrl = new SoinCtrl();
				
				FacesUtil.setSessionMapValue(soinCtrl.getNomManagedBean2(),
						soinCtrl);
			}
			
			TabPat pat = getDefaultVue().getEntiteCourante();
			
			TabSoin soin = new TabSoin(pat.getInfoUser());
			soin.initData();
			soin.setTabPat(pat);	
			soinCtrl.getDefaultVue().setEntiteCourante(soin);
			soinCtrl.getDefaultVue().getNavigationMgr().setEnModification(false);
			
		} catch (Exception e) {
			v$navigation = null;
			e.printStackTrace();
		}
		return "SoinEdition";
	}
	
>>>>>>> .r53
}
