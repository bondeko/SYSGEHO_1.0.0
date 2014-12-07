/**
 * 
 */
package com.bondeko.sysgeho.be.core.dao.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.Stateless;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.util.EntFichier;


@SuppressWarnings("finally")
@Stateless
public class DaoEntFichier implements IDaoEntFichier {
	
	private static BaseLogger logger = BaseLogger.getLogger(DaoEntFichier.class);
	
	public BaseLogger getLogger() {
		return logger;
	}

	private static String BASE_PATH_NAME = "file.store.location";
	private static String BUNDLE_PATH_NAME = "com.bondeko.sysgeho.Config";

	public DaoEntFichier() {
		 
	}

	@Override
	public List<EntFichier> findByCriteria(EntFichier fichier) {
		 
		return null;
	}

	@Override
	public List<EntFichier> findByLotDoc(String codeLot) {
		 
		return null;
	}

	@Override
	public EntFichier findByPath(String path) throws SysGehoPersistenceException {
		String filePath = this.getSdsBasePath() + File.separator + path;
		File toGet = new File(filePath);
		EntFichier myfichier = null;
		FileInputStream fin;
		try {
			fin = new FileInputStream(toGet);
			byte[] data = new byte[(int) toGet.length()];
			fin.read(data);
			myfichier = new EntFichier(filePath, path, data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (myfichier == null)
				myfichier = new EntFichier(filePath, path, null);
			return myfichier;
		}
	}

	@Override
	public EntFichier findByCodePce(String codePiece)
			throws SysGehoPersistenceException {

		EntFichier fichier = new EntFichier();
		fichier.setCodePiece(codePiece);

		String filePath = this.getSdsBasePath() + File.separator
				+ fichier.getStoragePath();
		System.out.println("Chemin complet : " + filePath);
		File toGet = new File(filePath);
		EntFichier myfichier = null;
		FileInputStream fin;
		try {
			fin = new FileInputStream(toGet);
			byte[] data = new byte[(int) toGet.length()];
			fin.read(data);
			myfichier = new EntFichier(filePath, null, data);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (myfichier == null)
				myfichier = new EntFichier(filePath, null, null);
			
			myfichier.setCodePiece(codePiece);
			return myfichier;
		}
	}

	@Override
	public EntFichier save(EntFichier fichier)
			throws SysGehoPersistenceException {
		
		logger.debug("[save] Sauvegarde du fichier " + fichier.getName());
		logger.debug("[save] Racine de la base documentaire  : " + this.getSdsBasePath());
		logger.debug("[save] Chemin relatif de stockage  : " + fichier.getStoragePath());
		
		String filePath = this.getSdsBasePath() + File.separator
				+ fichier.getStoragePath();
		
		try{
			logger.debug("[save] Vérification de l'existance du fichier dans la base : " + filePath);
			File file = new File(filePath);
			File dir = new File(file.getParent());
			if(!dir.exists()){
				logger.debug("[save] Le repertoire cible n'existe pas. Création de ce dernier : " + dir);
				dir.mkdirs();
			}
		}catch(Exception e){			
		}
		
		File toSave = new File(filePath);
		try {
			logger.debug("[save] Sauvegarde effective du fichier dans la base documentaire");
			toSave.createNewFile();
			FileOutputStream fout = new FileOutputStream(toSave);
			logger.debug("[save] Ecriture dans la base documentaire");
			fout.write(fichier.getData());
			fout.close();

			fichier.setUri(filePath);
			return fichier;

		} catch (IOException e) {
			throw new SysGehoPersistenceException(
					"Erreur lors de l'enrégistrement du fichier "
							+ fichier.getName()
							+ " dans la base documentaire : Base documentaire introuvable",
					e);
		}catch (Exception e) {
			throw new SysGehoPersistenceException("Erreur lors de la seuvegarde du fichier dans la base documentaire");
		}

	}

	@Override
	public EntFichier update(EntFichier fichier)
			throws SysGehoPersistenceException {
		String filePath = this.getSdsBasePath() + File.separator
				+ fichier.getStoragePath();
		File toSave = new File(filePath);
		try {

			if (!toSave.exists())
				toSave.createNewFile();
			FileOutputStream fout = new FileOutputStream(toSave);
			fout.write(fichier.getData());
			fout.close();

			fichier.setUri(filePath);
			return fichier;

		} catch (IOException e) {
			throw new SysGehoPersistenceException(
					"Erreur lors de l'enrégistrement du fichier "
							+ fichier.getName()
							+ " dans la base documentaireBase documentaire introuvable",
					e);
		}
	}

	@Override
	public boolean delete(EntFichier fichier) throws BaseException {
		try{
			//Construction du chemin du fichier
			String filePath = this.getSdsBasePath() + File.separator + fichier.getStoragePath();
			logger.debug("Fichier à supprimer : <" + filePath + ">");
			//Récupération du fichier
			File toGet = new File(filePath);
			
			//Vérification de l'existence du fichier
			if(toGet.exists() && toGet.isFile())
			{
				//Suppression du fichier dans la base documentaire
				return toGet.delete();
			}
			else if(toGet.exists()){
				throw new SysGehoPersistenceException("Fichier invalide!");
			}
			
			return false;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new SysGehoPersistenceException("Erreur d'accès au fichier : " + e.getMessage() + " !", e);
		} 
	}
	
	@Override
	public boolean delete(String codePiece) throws BaseException {
		try{
			EntFichier fichier = new EntFichier();
			fichier.setCodePiece(codePiece);

			return this.delete(fichier);
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new SysGehoPersistenceException("Erreur d'accès au fichier : " + e.getMessage() + " !", e);
		} 
	}
	
	String sdsBasePath = null;

	public String getSdsBasePath() throws SysGehoPersistenceException {
		try {
			if (sdsBasePath == null) {
				// charge le fichier SdsConfig qui doit se trouver dans un Path
				// = com/sysgeho
				ResourceBundle rb = ResourceBundle
						.getBundle(BUNDLE_PATH_NAME);
				sdsBasePath = rb.getString(BASE_PATH_NAME);
			}

			return sdsBasePath;
		} catch (Exception e) {
			throw new SysGehoPersistenceException(
					"Base documentaire introuvable", e);
		}
	}

	public void setSdsBasePath(String sdsBasePath) {
		this.sdsBasePath = sdsBasePath;
	}

}
