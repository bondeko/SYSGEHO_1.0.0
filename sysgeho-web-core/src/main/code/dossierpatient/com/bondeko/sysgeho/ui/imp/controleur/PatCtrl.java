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
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.entity.TabRdv;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.ui.core.base.DataValidationException;
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
		
		Traitement v$traitementExp = new Traitement( DossierPatientTrt.EXP_ETA_PAT);
		v$traitementExp.setModalType(Traitement.MODAL_SPECIAL);
		v$traitementExp.setMethode("exporterPatients");
		v$mapTrt.put(v$traitementExp.getKey(), v$traitementExp);
		
		Traitement v$traitement = new Traitement(
				DossierPatientTrt.NAVIGUER_RDV.naviguerVersFormulaireListe(),
				DossierPatientTrt.NAVIGUER_RDV);
		v$mapTrt.put(v$traitement.getKey(), v$traitement);
		
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
		
		return v$navigation;
	}
	
	@Override
	public void preEnregistrer() throws DataValidationException {
		if(defaultVue.getEntiteCourante() != null  && defaultVue.getEntiteCourante().getCodAss()==null){
			defaultVue.getEntiteCourante().setLibAss(null);
		}
		if(defaultVue.getEntiteCourante() != null  && defaultVue.getEntiteCourante().getCodSoc()==null){
			defaultVue.getEntiteCourante().setLibSoc(null);
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
					val = patient.getLibSoc();
					label = new Label(11, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					val = patient.getBEstAss() ? "OUI" : "NON" ;
					label = new Label(12, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					val = patient.getLibAss();
					label = new Label(13, i + 2, val);
					sheet.addCell(label);
				} catch (Exception e) {
					e.printStackTrace();
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

}
