package com.bondeko.sysgeho.be.core.dao.base;

import java.io.Serializable;
import java.util.List;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.core.exception.BaseException;
import com.bondeko.sysgeho.be.core.exception.SysGehoPersistenceException;



public interface IBaseDao <T extends BaseEntity, ID extends Serializable>{

	public <X extends BaseEntity> X save(X entity) throws BaseException;
	
	public <X extends BaseEntity> X update(X entity) throws SysGehoPersistenceException;
	
	public <X extends BaseEntity> boolean delete(X entity) throws SysGehoPersistenceException;
	
	<X extends BaseEntity> void remove(X entity) throws SysGehoPersistenceException;
	
	<X extends BaseEntity> X findById(X entity, Serializable id) throws SysGehoPersistenceException;

	<X extends BaseEntity> List<X> findAll(X entity) throws SysGehoPersistenceException;

	<X extends BaseEntity> List<X> findByExample(X entity) throws SysGehoPersistenceException;
	
}
