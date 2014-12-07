/**
 * 
 */
package com.bondeko.sysgeho.ui.core.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlFileUpload;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.OutputType;
import com.bondeko.sysgeho.be.util.TabPceJte;


public class ModalManager {
	
	
	/**
	 * Code du modal panel de gestion des motifs des traitements
	 */
	public static final String MODAL_PANEL_MOTIF = "mpnl_motif";
	
	/**
	 * Code du modal panel d'ajout de pièces jointes
	 */
	public static final String MODAL_PANEL_PIECE_JOINTE = "";

	/**
	 * Nom du Bean managé par JSF dans le fichier de Configuration 
	 */
	private static String nomManagedBean = "modalCtrl";
	
	/**
	 * Titre du modal Panel
	 */
	private String titre = "";
	
	/**
	 * Nom de la méthode d'un controleur à executer
	 */
	private String methode = "";
	
	/**
	 * Référence de la pièce jointe
	 */
	private String reference="";
	
	/**
	 * Description supplementaire
	 */
	private String description;
	
	/**
	 * Date de l'opération
	 */
	private Date date;
	
	/**
	 * Type de Fichier (Utile principalement pour les pièces jointes)
	 */
	private String type;
	
	/**
	 * Pièce jointe 
	 */
	private TabPceJte pceJte;
	
	/**
	 * Obligation de renseigner une donnée
	 * Exemple : Pièces jointes
	 */
	private boolean pieceRequise = true;
	
	
	private  Map<String, String> typesFichier = new TreeMap<String, String>();
	
	/**
	 * Motif du Traitement
	 */
	private String motif = "";

	/**
	 * Alias de l'Imprimante sur laquelle effectuer l'impression
	 */
	private String printerAlias;
		
	/**
	 * Type de format de l'export de donnéess
	 */
	private OutputType outputFormat;
		
	/**
	 * Liste des Fichiers uploadés
	 */
	private ArrayList<Fichier> files = new ArrayList<Fichier>();
	
	/**
	 * Nombre de fichier(s) a uploader simultanement
	 */
    private int uploadsAvailable = 1;
    
    /**
     * L'upload de fichier est-il automatique après sélection !?
     */
    private boolean autoUpload = false;
    
    /**
     * Utilisation du composant flash ou pas !?
     * Utile pour afficher le type de fichier à uploader , ainsi que la progression de l'upload
     */
    private boolean useFlash = true;
    
    /**
     * Type de fichiers à uploader
     * Valeur par défaut (pdf, doc, txt)
     */
    private String  acceptedTypes = "pdf, doc, txt";
    
    /**
     * Nom du controleur pour ayant sollicité la 
     */
    private String clientCtrlName;
    
    /**
     * Zones d'informations à mettre à jour après validation du modal panel
     */
    private String reRender;

    /**
     * Module de l'application sélectionné
     */
    private String module;
    
    /**
     * Composant d'uplaod de Fichier
     * TODO Voir dans quel mesure tu peux faire directement un biding de ce composant sur la page en fixant toutes les propriétés
     */
    HtmlFileUpload fileUpload;
    
    
    /**
     * ID de l'etat intégré a généré
     */
    private String reporId;
    
 
	public ModalManager() {
		   
	}
	
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
		
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}	

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param typeFichier the typeFichier to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the typesFichier
	 */
	public Map<String, String> getTypesFichier() {
		return typesFichier;
	}

	/**
	 * @param typesFichier the typesFichier to set
	 */
	public void setTypesFichier(Map<String, String> typesFichier) {
		this.typesFichier = typesFichier;
	}

	/**
	 * @return the methode
	 */
	public String getMethode() {
		return methode;
	}

	/**
	 * @param methode the methode to set
	 */
	public void setMethode(String methode) {		
		this.methode = methode;
	}	
	    
    /**
	 * @return the fileUpload
	 */
	public HtmlFileUpload getFileUpload() {
		return fileUpload;
	}

	/**
	 * @param fileUpload the fileUpload to set
	 */
	public void setFileUpload(HtmlFileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	/**
	 * @return the acceptedTypes
	 */
	public String getAcceptedTypes() {
		return acceptedTypes;
	}

	/**
	 * @param acceptedTypes the acceptedTypes to set
	 */
	public void setAcceptedTypes(String acceptedTypes) {
		this.acceptedTypes = acceptedTypes;
	}

    /**
	 * @return the files
	 */
	public ArrayList<Fichier> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(ArrayList<Fichier> files) {
		this.files = files;
	}

    /**
	 * @return the uploadsAvailable
	 */
	public int getUploadsAvailable() {
		return uploadsAvailable;
	}

	/**
	 * @param uploadsAvailable the uploadsAvailable to set
	 */
	public void setUploadsAvailable(int uploadsAvailable) {
		this.uploadsAvailable = uploadsAvailable;
	}

    /**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the autoUpload
	 */
	public boolean isAutoUpload() {
		return autoUpload;
	}

	/**
	 * @param autoUpload the autoUpload to set
	 */
	public void setAutoUpload(boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	/**
	 * @return the useFlash
	 */
	public boolean isUseFlash() {
		return useFlash;
	}

	/**
	 * @param useFlash the useFlash to set
	 */
	public void setUseFlash(boolean useFlash) {
		this.useFlash = useFlash;
	}

	/**
	 * @return the clientCtrlName
	 */
	public String getClientCtrlName() {
		return clientCtrlName;
	}

	/**
	 * @param clientCtrlName the clientCtrlName to set
	 */
	public void setClientCtrlName(String clientCtrlName) {
		this.clientCtrlName = clientCtrlName;
		
		/*
		 * Traitements d'initialisation particuliers devant être réalisé par le client toujours
		 * 
		 */
		clearDataByClient();
	}
	
	/**
	 * @return the printerAlias
	 */
	public String getPrinterAlias() {
		return printerAlias;
	}

	/**
	 * @param printerAlias the printerAlias to set
	 */
	public void setPrinterAlias(String printerAlias) {
		this.printerAlias = printerAlias;
	}

	/**
	 * @return the outputFormat
	 */
	public OutputType getOutputFormat() {
		return outputFormat;
	}

	/**
	 * @param outputFormat the outputFormat to set
	 */
	public void setOutputFormat(OutputType outputFormat) {
		this.outputFormat = outputFormat;
	}	
	
    public long getTimeStamp(){
        return System.currentTimeMillis();
    }	
   
	/**
	 * Nombre de fichiers téléchargés
	 */
    public int getSize() {
    	        
        try{
        	return getFiles().size();
        }
        catch(Exception e){
        	return 0;
        }
    }	    
   
	/**
	 * Gestionnaire d'evènements d'upload du composant d'upload de fichiers
	 */
	public void listener(UploadEvent event) throws Exception{
    	
        UploadItem item = event.getUploadItem();        
        Fichier file = new Fichier();
        file.setLength(item.getData().length);
        file.setName(item.getFileName());
        file.setData(item.getData());
        getFiles().add(file);
        uploadsAvailable--;
    } 	
	
	/**
     * Ré-initialisation des données du Modal Panel
     * 
     * @return
     */
    private void clearData() {
    	
    	if(getSize() > 0){
    		getFiles().clear();
            setUploadsAvailable(1);
    	}
        
    	setTitre("");
    	setReference("");
    	setDescription("");
    	setDate(null);
    	setType(null);
    	setTypesFichier(new TreeMap<String, String>());
    	setMotif("");
    	setPceJte(null);
    	setPieceRequise(true);
    }
    
    /**
     * Ré-initialisation des données du Modal Panel Par le controleur client
     * 
     * @return
     */
    private void clearDataByClient(){
    	setReRender(null);
    }
    
    
	/**
	 * Retourne l'instance (Bean Managé) du ModalManager
	 * 
	 * @return
	 */
	public static ModalManager getManagedBeanInstance(){
				
		ModalManager v$instance = (ModalManager) FacesUtil.getSessionMapValue(nomManagedBean);
				
		if(v$instance == null){
			v$instance = new ModalManager();
			FacesUtil.setSessionMapValue(nomManagedBean, v$instance);
		}
				
		return v$instance;
	}
	
	/**
	 * Annule un traitement
	 * 
	 * @return
	 */
	public String annuler(){
							
		clearData();
		clearDataByClient();
		
		return null;
	}	
	
	/**
	 * Execution de la méthode du  Controleur(Client) du Gestionnaire de Modal Panel
	 * @return
	 */
	public String valider(){
		
		// Determine vers quelle page ou Formulaire l'on doit se diriger
		String v$navigation = null;
		
						
		// Récupération du Controlleur Client du Modal
			// Cette méthode suppose que le controleur est dans le scope session			
		Object v$objectControlleur = FacesUtil.getSessionMapValue(getClientCtrlName());	// Utile pour conserver la véritable classe du Controlleur
		
		// On recherche la méthode du controlleur à invoker
		Method v$methode = SysGehoToolBox.findMethod(v$objectControlleur.getClass(), getMethode(),	new Class[] {});
	
		if(v$methode != null){
			try {
				Object v$result = v$methode.invoke(v$objectControlleur, new Object[] {});
				v$navigation = (String) v$result;
			} 
			catch (Exception e) {					
				//e.printStackTrace();
				FacesUtil.addWarnMessage("MSG_TRT_ALL_ECHEC", "MSG_TRT_ALL_ECHEC_INCONNU");
			} 
		}
		
		// Réinitialisation des données
		clearData();
		
		
		return v$navigation;
	}		
	
	/**
	 * Retourne le Fichier uploadé
	 * @return
	 */
	public Fichier getFichier(){
		
		Fichier v$fichier = null;
		
		if(getSize() > 0){
			v$fichier = getFiles().get(0);		
		}		
		return v$fichier;
	}
	
	/**
	 * Retourne la pièce jointe uploadée
	 * 
	 * @return
	 */
	public TabPceJte getPceJte(){
		
		TabPceJte v$piece = (pceJte == null)? new TabPceJte(): pceJte;
			
		v$piece.setLRefPce(getReference());
		v$piece.setLInfPce(getDescription());
		v$piece.setDPce(DateTools.formatDate(getDate()));
		
		Fichier v$fichier = getFichier();	
		if( v$fichier != null){		
			v$piece.setFichier(new EntFichier(null,v$fichier.getName(),v$fichier.getData()));
		}
		
		return v$piece;
	}	
	
	/**
	 * @param pceJte the pceJte to set
	 */
	public void setPceJte(TabPceJte pceJte) {
		this.pceJte = pceJte;
	}


	/**
	 * @param pieceRequise the pieceRequise to set
	 */
	public void setPieceRequise(boolean pieceRequise) {
		this.pieceRequise = pieceRequise;
	}

	/**
	 * @return the pieceRequise
	 */
	public boolean isPieceRequise() {
		return pieceRequise;
	}

	/**
	 * @param reRender the reRender to set
	 */
	public void setReRender(String reRender) {
		this.reRender = reRender;
	}

	/**
	 * @return the reRender
	 */
	public String getReRender() {
		
		// Si la zone à mettre à jour n'est pas renseigné, l'on met à jour le Formulaire Central
		reRender = (reRender == null)? Traitement.RERENDER_MAIN_PANEL:reRender;
				
		return reRender;
	}

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Configuration de l'affichage du Modal Panel à partir de son type
	 */
	public  void configureModalPanel(String typeModal){
		
		if(MODAL_PANEL_MOTIF.equals(typeModal)){
			
		}
		
		if(MODAL_PANEL_PIECE_JOINTE.equals(typeModal)){
			
		}
		
	}
	
	public void setReporId(String reporId) {
		this.reporId = reporId;
	}

	public String getReporId() {
		return reporId;
	}

}
