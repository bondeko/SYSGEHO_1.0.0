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
import com.bondeko.sysgeho.be.imp.dao.IDaoCpteRenduExam;
import com.bondeko.sysgeho.be.imp.dao.IDaoExam;
import com.bondeko.sysgeho.be.imp.entity.TabCpteRenduExam;
import com.bondeko.sysgeho.be.imp.entity.TabExam;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduExam;
import com.bondeko.sysgeho.be.imp.serialiaze.SrlEtatCpteRenduExamElt;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.ReportNames;
import com.bondeko.sysgeho.be.util.SysGehoOutput;
import com.bondeko.sysgeho.be.util.SysGehoPrinterExportEnum;

@Stateless
public class SisvCpteRenduExam extends BaseSisv<TabCpteRenduExam, String> implements ISisvCpteRenduExam{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvCpteRenduExam.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoCpteRenduExam daoCpteRenduExam; 
	
	@EJB
	IDaoExam daoExam; 
	
	@EJB
	IDaoIncCod daoIncCod;


	@Override
	public IBaseDao<TabCpteRenduExam, String> getBaseDao() {
		return daoCpteRenduExam;
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoCpteRenduExam.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoCpteRenduExam.findAll(entity);
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
			return daoCpteRenduExam.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		TabCpteRenduExam cpteRenduCree = (TabCpteRenduExam) p$entite; 
		//Teste si la examtation n'a pas deja un compte rendu
		if(cpteRenduCree.getTabExam().getBooCpteRendu().equals(BigDecimal.ONE))
			throw new BaseException("Erreur : Il existe d�j� un compte rendu pour l'examen "+ cpteRenduCree.getTabExam().getCodExam());
		cpteRenduCree = initialiserDonnees(cpteRenduCree);
		//genere le code du compte rendu
		((TabCpteRenduExam)p$entite).setCodCpteRenduExam(genererCodeCpteRenduExamient(cpteRenduCree));
		//fais un teste si l'entit� existe d�j�
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entit� existe d�j�");
		}
		p$entite.validateData();
		//Met � jour la examtation Boo_Cpte_Rendu = 1
		TabExam exam = cpteRenduCree.getTabExam();
		exam.setBooCpteRendu(BigDecimal.ONE);
		daoExam.update(exam);
		
		return getBaseDao().save(p$entite);
	}
	
	private String genererCodeCpteRenduExamient(TabCpteRenduExam tabCpteRenduExam) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(tabCpteRenduExam).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 6, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ numero;
		return numero;
	}
	
	private TabCpteRenduExam initialiserDonnees(TabCpteRenduExam cpteRendu){
		cpteRendu.setBooVal(BigDecimal.ZERO);
		return cpteRendu;
	}
	
	@Override
	public TabCpteRenduExam valider(TabCpteRenduExam $pCpteRduExam) throws SysGehoSystemException  {
		try {
			$pCpteRduExam.setBooVal(BigDecimal.ONE);
			$pCpteRduExam.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pCpteRduExam);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de l'exam");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private SrlEtatCpteRenduExam getCpteRenduExam(TabCpteRenduExam cpterendu) throws SysGehoSystemException {
		SrlEtatCpteRenduExam srlEtatCpteRenduExam = new SrlEtatCpteRenduExam();
		try {
			//Recherche tous les mouvements de ce conteneurs
			List<TabCpteRenduExam> listcpterendu = daoCpteRenduExam.findByExample(cpterendu);
			if(listcpterendu != null && listcpterendu.size() > 0){
				//On parcour la liste des mouvement obtenus et on construit la s�rialization  
				for(TabCpteRenduExam pat : listcpterendu){
					srlEtatCpteRenduExam.addElement(new SrlEtatCpteRenduExamElt(pat));
				}
			}
//			else{
//				srlMouvCon.addElement(new SrlMouvConElt(conCour, null));
//			}
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage());
		}
		return srlEtatCpteRenduExam;
	}
	
	@Override
	public EntFichier genererEtatCpteRenduExam(TabCpteRenduExam cpterendu) throws SysGehoSystemException{
		
		try{
			SrlEtatCpteRenduExam etatCpteRenCon = getCpteRenduExam(cpterendu);
			getLogger().debug("SisvPat.genererEtatListPatient Serialisation ...");
			SysGehoOutput result = fillAndExport(etatCpteRenCon,
					ResourceLocator.getReportModel(ReportNames.ETAT_CPTE_RENDU_EXAM),
					SysGehoPrinterExportEnum.PDF, null, null, null);
			
			// Construction du nom par d�faut du fichier
			String str = (ReportNames.ETAT_CPTE_RENDU_EXAM).getDefaulFileName() + "."
					+ result.getFileExtention();
			
			// Cr�ation de l'entit� fichier
			getLogger().debug("SisvCon.genererEtatMouvCon Creation de l'entite fichier ..."+result.getUri());
			EntFichier v$fichier = new EntFichier(result.getUri(), str,
					result.getFileStream());
			
			logger.debug("Fichier g�n�r� " + str + " >> avec "
					+ v$fichier.getLength() + "Ko.");
			return v$fichier;
			
		}catch(Exception e){
			throw new SysGehoSystemException(e.getMessage());
		}
		
	}
	
}
