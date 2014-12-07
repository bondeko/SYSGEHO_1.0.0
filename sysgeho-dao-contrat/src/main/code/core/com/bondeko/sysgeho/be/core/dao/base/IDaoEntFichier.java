package com.bondeko.sysgeho.be.core.dao.base;

import java.util.List;

import javax.ejb.Local;

import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.util.EntFichier;

@Local
public interface IDaoEntFichier {
	
	EntFichier save(EntFichier fichier) throws SysGehoPersistenceException;
	
	EntFichier update(EntFichier fichier) throws SysGehoPersistenceException;
	
	EntFichier findByPath(String path) throws SysGehoPersistenceException;
	
	List<EntFichier> findByCriteria(EntFichier fichier) throws SysGehoPersistenceException;
	
	List<EntFichier> findByLotDoc(String codeLot) throws SysGehoPersistenceException;

	EntFichier findByCodePce(String codePiece) throws SysGehoPersistenceException;

	boolean delete(String codePiece) throws BaseException;

	boolean delete(EntFichier fichier) throws BaseException;

}
