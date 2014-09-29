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
import com.bondeko.sysgeho.be.imp.dao.IDaoConsul;
import com.bondeko.sysgeho.be.imp.dao.IDaoCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabConsul;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.entity.TabPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduConsul;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduConsulElt;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatListPat;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatListPatElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvCpteRenduConsul extends BaseSisv<TabCpteRenduConsul, String> implements ISisvCpteRenduConsul{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvCpteRenduConsul.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoCpteRenduConsul daoCpteRenduConsul; 
	
	@EJB
	IDaoConsul daoConsul; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabCpteRenduConsul, String> getBaseDao() {
		return daoCpteRenduConsul;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoCpteRenduConsul.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoCpteRenduConsul.findAll(entity);
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
			return daoCpteRenduConsul.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabCpteRenduConsul cpteRenduCree = (TabCpteRenduConsul) p$entite; 
		//Teste si la consultation n'a pas deja un compte rendu
		if(cpteRenduCree.getTabConsul().getBooCpteRendu().equals(BigDecimal.ONE))
			throw new BaseException("Erreur : Il existe déjà un compte rendu pour la consultation "+ cpteRenduCree.getTabConsul().getCodConsul());
		cpteRenduCree = initialiserDonnees(cpteRenduCree);
		//genere le code du compte rendu
		((TabCpteRenduConsul)p$entite).setCodCpteRenduConsul(genererCodeCpteRenduConsulient(cpteRenduCree));
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		//Met à jour la consultation Boo_Cpte_Rendu = 1
		TabConsul consul = cpteRenduCree.getTabConsul();
		consul.setBooCpteRendu(BigDecimal.ONE);
		daoConsul.update(consul);
		
		return getBaseDao().save(p$entite);
	}
	
	private String genererCodeCpteRenduConsulient(TabCpteRenduConsul tabCpteRenduConsul) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabCpteRenduConsul).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabCpteRenduConsul initialiserDonnees(TabCpteRenduConsul cpteRendu){
		cpteRendu.setBooVal(BigDecimal.ZERO);
		return cpteRendu;
	}
	
	@Override
	public TabCpteRenduConsul valider(TabCpteRenduConsul $pCpteRduConsul) throws SysGehoSystemException  {
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
	
		
	private SrlEtatCpteRenduConsul getCpteRenduCon(TabCpteRenduConsul cpterendu) throws SysGehoSystemException {
		SrlEtatCpteRenduConsul srlEtatCpteRenduConsul = new SrlEtatCpteRenduConsul();
		try {
			//Recherche tous les mouvements de ce conteneurs
			List<TabCpteRenduConsul> listcpterendu = daoCpteRenduConsul.findByExample(cpterendu);
			if(listcpterendu != null && listcpterendu.size() > 0){
				//On parcour la liste des mouvement obtenus et on construit la sérialization  
				for(TabCpteRenduConsul pat : listcpterendu){
					srlEtatCpteRenduConsul.addElement(new SrlEtatCpteRenduConsulElt(pat));
				}
			}
//			else{
//				srlMouvCon.addElement(new SrlMouvConElt(conCour, null));
//			}
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatCpteRenduConsul;
	}
	
	@Override
	public EntFichier genererEtatCpteRenduCon(TabCpteRenduConsul cpterendu) throws SysGehoSystemException{
		
		try{
			SrlEtatCpteRenduConsul etatCpteRenCon = getCpteRenduCon(cpterendu);
			getLogger().debug("SisvPat.genererEtatListPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatCpteRenCon,
					ResourceLocator.getReportModel(ReportNames.ETAT_CPTE_RENDU_CON),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par défaut du fichier
			String str = (ReportNames.ETAT_CPTE_RENDU_CON).getDefaulFileName() + "."
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
