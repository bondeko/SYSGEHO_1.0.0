package com.bondeko.sysgeho.be.imp.sisv;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.dao.base.IDaoIncCod;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.core.util.locator.ResourceLocator;
import com.bondeko.sysgeho.be.imp.dao.IDaoRapVisMedPerio;
import com.bondeko.sysgeho.be.imp.dao.IDaoVisMedPerio;
import com.bondeko.sysgeho.be.imp.entity.TabRapVisMedPerio;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlRapVisMedPer;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlRapVisMedPerElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvRapVisMedPerio extends BaseSisv<TabRapVisMedPerio, String> implements ISisvRapVisMedPerio{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvRapVisMedPerio.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoRapVisMedPerio daoRapVisMedPerio; 
	
	@EJB
	IDaoVisMedPerio daoVisMedPerio; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabRapVisMedPerio, String> getBaseDao() {
		return daoRapVisMedPerio;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoRapVisMedPerio.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoRapVisMedPerio.findAll(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X entity)
			throws SysGehoSystemException {
		try {
			return daoRapVisMedPerio.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabRapVisMedPerio rapVisMedCree = (TabRapVisMedPerio) p$entite; 
		rapVisMedCree = initialiserDonnees(rapVisMedCree);
		//genere le code du compte rendu
		((TabRapVisMedPerio)p$entite).setCodRapVisMedPerio(genererCodeRapVisMed(rapVisMedCree));
		//On compare les sociétés du patient et de la visite médicale
		String codSocVM = rapVisMedCree.getTabVisMedPerio().getTabSoc().getCodSoc();
		String codSocPat = rapVisMedCree.getTabPat().getTabSoc()!=null ?rapVisMedCree.getTabPat().getTabSoc().getCodSoc() : "";
		if(!codSocPat.equals("") && !codSocPat.equals(codSocVM)) throw new BaseException("Erreur : Le patient selectionné ne fais pas partir de la société donc la visite médicale périodique a été réalisé");
		if(codSocPat.equals(""))throw new BaseException("Erreur : Le patient selectionné n'a pas de société");
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		p$entite.validateData();
		return getBaseDao().save(p$entite);
	}
	
	private String genererCodeRapVisMed(TabRapVisMedPerio tabRapVisMedPerio) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabRapVisMedPerio).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabRapVisMedPerio initialiserDonnees(TabRapVisMedPerio visMed){
		visMed.setBooVal(BigDecimal.ZERO);
		return visMed;
	}
	
	@Override
	public TabRapVisMedPerio valider(TabRapVisMedPerio $pCpteRduConsul) throws SysGehoSystemException  {
		try {
			$pCpteRduConsul.setBooVal(BigDecimal.ONE);
			$pCpteRduConsul.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pCpteRduConsul);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la consultation");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	/**
	 * Rechercher les informaton sur le rapport
	 */

	private SrlRapVisMedPer getVisteMedical(TabRapVisMedPerio cpterendu) throws SysGehoSystemException {
		SrlRapVisMedPer srlRapVisMedPer = new SrlRapVisMedPer();
		try {
			//Recherche tous les mouvements de ce conteneurs
			List<TabRapVisMedPerio> listcpterendu = daoRapVisMedPerio.findByExample(cpterendu);
			if(listcpterendu != null && listcpterendu.size() > 0){
				//On parcour la liste des mouvement obtenus et on construit la sérialization  
				for(TabRapVisMedPerio pat : listcpterendu){
					srlRapVisMedPer.addElement(new SrlRapVisMedPerElt(pat));
				}
			}
//			else{
//				srlMouvCon.addElement(new SrlMouvConElt(conCour, null));
//			}
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlRapVisMedPer;
	}
	
	/**
	 * Generer le rapport de visite médical
	 */
	@Override
	public EntFichier genererRapportVM(TabRapVisMedPerio rapport) throws SysGehoSystemException{
		
		try{
			SrlRapVisMedPer etatRapportVM = getVisteMedical(rapport);
			getLogger().debug("SisvPat.genererEtatListPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatRapportVM,
					ResourceLocator.getReportModel(ReportNames.ETAT_RAP_VM),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_RAP_VM).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Création de l'entité fichier
			getLogger().debug("SisvCon.genererEtatMouvCon Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier généré " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
}
