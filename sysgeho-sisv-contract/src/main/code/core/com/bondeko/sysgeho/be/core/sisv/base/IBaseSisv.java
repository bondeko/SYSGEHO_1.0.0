package com.bondeko.sysgeho.be.core.sisv.base;

import java.io.Serializable;
import java.util.List;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;
import com.bondeko.sysgeho.be.core.exception.SysGehoSystemException;

public interface IBaseSisv<T extends BaseEntity, ID extends Serializable> {
	
	<X extends BaseEntity> X creer(X p$entite) throws BaseException ;
	
	<X extends BaseEntity> X modifier(X p$entite) throws SysGehoPersistenceException;
	
	<X extends BaseEntity> boolean supprimer(X p$entite) throws SysGehoPersistenceException;
	
	<X extends BaseEntity> void retirer(X p$entite) throws SysGehoSystemException, SysGehoPersistenceException;
	
	<X extends BaseEntity> X rechercher(X entity, Serializable p$valeur) throws SysGehoSystemException;
	
	<X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoSystemException;

	<X extends BaseEntity> List<X> rechercherParCritere(X entity) throws SysGehoSystemException;
}
