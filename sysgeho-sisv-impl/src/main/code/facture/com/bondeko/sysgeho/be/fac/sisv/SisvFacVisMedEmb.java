package com.bondeko.sysgeho.be.fac.sisv;

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
import com.bondeko.sysgeho.be.core.dao.base.IDaoEntFichier;
import com.bondeko.sysgeho.be.core.dao.base.IDaoIncCod;
import com.bondeko.sysgeho.be.core.dao.base.IDaoLotDoc;
import com.bondeko.sysgeho.be.core.dao.base.IDaoPceJte;
import com.bondeko.sysgeho.be.core.enums.EnuEtat;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.fac.dao.IDaoFacVisMedEmb;
import com.bondeko.sysgeho.be.fac.entity.TabFacVisMedEmb;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;

@Stateless
public class SisvFacVisMedEmb extends BaseSisv<TabFacVisMedEmb, String> implements ISisvFacVisMedEmb{
	
	private static BaseLogger logger = BaseLogger.getLogger(SisvFacVisMedEmb.class);

	@Override
	public BaseLogger getLogger() {
		return logger;
	} 
	@EJB
	IDaoFacVisMedEmb daoFacVisMedEmb; 
	
	@EJB
	IDaoLotDoc daoLotDoc;

	@EJB
	IDaoPceJte daoPceJte;
	
	@EJB
	IDaoEntFichier daoEntFichier;
	
	@EJB
	IDaoIncCod daoIncCod;
	
	@Override
	public IBaseDao<TabFacVisMedEmb, String> getBaseDao() {
		return daoFacVisMedEmb;
	}
	
	public <X extends BaseEntity> X creer(X p$entite) throws BaseException  {
		
		//fais un teste si l'entité existe déjà
		X entRech = getBaseDao().findById(p$entite, p$entite.getId());
		if(entRech != null){
			throw new BaseException("Erreur : Cette entité existe déjà");
		}
		initialiserDonnees((TabFacVisMedEmb)p$entite);
		p$entite.validateData();
		return getBaseDao().save(p$entite);
	}

	public <X extends BaseEntity> X rechercher(X entity, Serializable id) throws SysGehoSystemException {
		try {
			return daoFacVisMedEmb.findById(entity, id);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}

	public <X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException {
			
		try {
			return daoFacVisMedEmb.findAll(entity);
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
			return daoFacVisMedEmb.findByExample(entity);
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	private TabFacVisMedEmb initialiserDonnees(TabFacVisMedEmb visMed){
		visMed.setBooVal(BigDecimal.ZERO);
		visMed.setBooPaie(BigDecimal.ZERO);
		return visMed;
	}
	
	@Override
	public TabFacVisMedEmb valider(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoSystemException  {
		try {
			$pFacVisMedEmb.setBooVal(BigDecimal.ONE);
			$pFacVisMedEmb.setEtatEnt(EnuEtat.VALIDE.getValue());
			return getBaseDao().update($pFacVisMedEmb);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de validation de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabFacVisMedEmb payer(TabFacVisMedEmb $pFacVisMedEmb) throws SysGehoSystemException  {
		try {
			$pFacVisMedEmb.setBooPaie(BigDecimal.ONE);
			$pFacVisMedEmb.setEtatEnt(EnuEtat.PAYE.getValue());
			return getBaseDao().update($pFacVisMedEmb);
		} catch (SysGehoPersistenceException e) {
			logger.debug("Erreur de paiement de la facture");
			e.printStackTrace();
			SysGehoSystemException sbr = new SysGehoSystemException(e);
			throw sbr;
		}
	}
	
	@Override
	public TabFacVisMedEmb ajouterPieceJte(TabFacVisMedEmb p$entite) throws BaseException {
		try {
			this.saveLotDoc(p$entite);
			return daoFacVisMedEmb.update(p$entite);
		} catch (BaseException sdr) {
			throw sdr;
		} catch (Exception e) {
			throw new SysGehoAppException("Erreur de mise à jour de la facture!", e);
		}
	}
	
	@Override
	public void saveLotDoc(TabFacVisMedEmb facVM) {
		try {
			// On vérifie l'existence de nouvelles pieces jointes
			if (facVM.getListNewPce().size() > 0) {
				TabLotDoc lot = null;
				// On vérifie si un lot documentaire a déjà été associé au
				// budget
				if (facVM.getTabLotDoc() == null
						|| facVM.getTabLotDoc().getCLotDoc() == null
						|| facVM.getTabLotDoc().getCLotDoc().isEmpty()) {
					// On crée un lot documentaire 
					lot = new TabLotDoc(facVM.getInfoUser());
					lot.setLLotDoc("Lot documentaire de la facture " + facVM.getRefFacVisMedEmb());
					lot.setZPce(new BigDecimal(0));
					lot.setCLotDoc(genererCodeLotDoc(lot)); 
					// On sauvegarde le lot documentaire en base de données
					lot = daoLotDoc.save(lot);
					facVM.setTabLotDoc(lot);
				}

				lot = facVM.getTabLotDoc();
				lot.setInfoUser(facVM.getInfoUser());
				// Ici on récupère le lot documentaire associé au budget
				lot = daoLotDoc.findById(lot, facVM.getTabLotDoc().getCLotDoc()); // ;

				logger.debug("Nombre de piece avant <" + lot.getCLotDoc()
						+ "> " + lot.getZPce().intValue());

				// On parcours la liste de pièces jointes pour la sauvegarde
				for (TabPceJte pce : facVM.getListNewPce()) {
					try {
						//MAJ du code de la pièce jointe si elle est nulle ou vide
						pce.setCTypPce("FACTURE");
						
						// On définit le code du lot documentaire associé à la
						// pièce jointe
						pce.setTabLotDoc(lot);

						// On récupère le fichier associé à la pièce jointe
						EntFichier fichier = pce.getFichier();

						// Si le fichier n'est pas null
						if (fichier != null
								&& (pce.getLRefFch() == null || pce
										.getLRefFch().trim().isEmpty()))
							pce.setLRefFch(fichier.getName()); // On stock le
						// nom du
						// fichier dans
						// la pièce
						// jointe

						// On sauvegarde la pièce jointe
						pce = daoPceJte.save(pce);

						// Si le fichier associé à la pièce jointe n'est pas
						// null
						if (fichier != null) {
							// On définie le code de la pièce jointe dans le
							// fichier
							fichier.setCodePiece(pce.getCPce());
							// On sauvegarde la pièce jointe dans la base
							// documentaire
							fichier = daoEntFichier.save(fichier);
						}

						lot.setZPce(lot.getZPce().add(new BigDecimal(1)));
						lot.setInfoUser(facVM.getInfoUser());
						// if(!lot.getTabPceJtes().contains(pce))
						// lot.getTabPceJtes().add(pce);
						logger.debug("Mise à jour du lot : <"
								+ lot.getCLotDoc() + " :: " + pce.getLRefFch()
								+ " :: " + pce.getLRefPce() + ">");
						lot = daoLotDoc.update(lot);
						logger.debug("Nombre de piece après <"
								+ lot.getCLotDoc() + " :: " + pce.getLRefFch()
								+ " :: " + pce.getLRefPce() + "> :"
								+ lot.getZPce().intValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				facVM.getListNewPce().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String genererCodeLotDoc(TabLotDoc lotDoc) throws SysGehoSystemException{
		BigDecimal v$inc;
		try {
			v$inc = daoIncCod.findNextIncCod(lotDoc).getValIncCod();
		} catch (SysGehoPersistenceException e) {
			e.printStackTrace();
			throw new SysGehoSystemException(e.getMessage(), e);
		}
		String numero = DateTools.padRigth(String.valueOf(v$inc), 8, '0');
		
		 numero = DateTools.getYear(DateTools.formatDate(new Date()))+ "L"+numero;
		return numero;
	}
	
}
