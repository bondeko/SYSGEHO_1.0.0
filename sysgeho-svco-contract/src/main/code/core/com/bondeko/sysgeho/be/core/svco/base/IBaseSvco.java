package com.bondeko.sysgeho.be.core.svco.base;

import java.io.Serializable;
import java.util.List;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoAppException;

public interface IBaseSvco<T extends BaseEntity> {
	
	<X extends BaseEntity> X creer(X p$entite) throws BaseException ;
	
	<X extends BaseEntity> X modifier(X p$entite) throws SysGehoAppException;
	
	<X extends BaseEntity> boolean supprimer(X p$entite) throws SysGehoAppException;
	
	<X extends BaseEntity> void retirer(X p$entite) throws SysGehoAppException;
	
	<X extends BaseEntity> X rechercher(X entity, Serializable p$valeur) throws SysGehoAppException;
	
	<X extends BaseEntity> List<X> rechercherTout(X entity) throws SysGehoAppException;

	<X extends BaseEntity> List<X> rechercherParCritere(X entity) throws SysGehoAppException;

}
