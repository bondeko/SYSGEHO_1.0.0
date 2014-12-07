package com.bondeko.sysgeho.be.admin.sisv.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.dao.base.IBaseDao;
import com.bondeko.sysgeho.be.core.dao.base.IDaoEntFichier;
import com.bondeko.sysgeho.be.core.dao.base.IDaoLotDoc;
import com.bondeko.sysgeho.be.core.dao.base.IDaoPceJte;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;
import com.bondeko.sysgeho.be.core.sisv.base.BaseSisv;
import com.bondeko.sysgeho.be.util.EntFichier;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;

/**
 * Session Bean implementation class SisvPceJte
 */

@Stateless
public class SisvPceJte extends BaseSisv<TabPceJte, String> implements
		ISisvPceJte {

	private static BaseLogger logger = BaseLogger.getLogger(SisvPceJte.class);
	
	@Override
	public BaseLogger getLogger() {
		return logger;
	}
	
	@EJB
	IDaoPceJte daoPce;

	@EJB
	IDaoEntFichier daoEntFichier;

	@EJB
	IDaoLotDoc daoLotDoc;
	
	@Override
	public IBaseDao<TabPceJte, String> getBaseDao() {
		return daoPce;
	}

	@Override
	public <X extends BaseEntity> X creer(X entity) throws BaseException {
		try {
			TabPceJte p$entite = (TabPceJte) entity;
			
			EntFichier fichier = p$entite.getFichier();
			
			if(fichier!= null && (p$entite.getLRefFch()==null || p$entite.getLRefFch().trim().isEmpty()))
					p$entite.setLRefFch(fichier.getName());
			
			TabPceJte piece = daoPce.save(p$entite);

			if (fichier != null) {
				fichier.setCodePiece(piece.getCPce());
				fichier = daoEntFichier.save(fichier);
			}
			
			//Mise à jour du nombre de pièce dans le lot documentaire
			TabLotDoc lot = piece.getTabLotDoc();
			lot.setInfoUser(entity.getInfoUser());
			lot.setZPce(lot.getZPce()==null ? DateTools.getBigDecimalValue(1) : lot.getZPce().add(DateTools.getBigDecimalValue(1)));
			lot = daoLotDoc.update(lot);

			piece.setTabLotDoc(lot);
			piece.setFichier(fichier);
			return (X) piece;
		} catch (BaseException sdr) {
			throw sdr;
		} catch (Exception e) {
			throw new BaseException("Erreur de sauvegarde de la pièce!", e);
		}
	}

	@Override
	public <X extends BaseEntity> X rechercher(X entity, Serializable p$valeur)
			throws SysGehoSystemException {
		try {
			X piece = daoPce.findById(entity, (String) p$valeur);
			if (piece != null) {
				EntFichier fichier = daoEntFichier.findByCodePce(((TabPceJte)piece).getCPce());
				fichier.setName(((TabPceJte)piece).getLRefFch());
				((TabPceJte)piece).setFichier(fichier);
			}

			return piece;
		} catch (Exception e) {
			throw new SysGehoSystemException("Erreur de récupération de données!",
					e);
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherParCritere(X p$critere)
			throws SysGehoSystemException {
		try {
			return daoPce.findByExample(p$critere);
		} catch (Exception e) {
			throw new SysGehoSystemException("Erreur de récupération de données!",
					e);
		}
	}

	@Override
	public <X extends BaseEntity> List<X> rechercherTout(X entity)
			throws SysGehoSystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
