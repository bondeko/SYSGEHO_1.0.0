package com.bondeko.sysgeho.be.core.base;


import java.io.Serializable;

import com.bondeko.sysgeho.be.util.InfoUser;


public abstract class BaseEntity implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	protected boolean applyFilter = false;
	
	private InfoUser infoUser;
	
	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
		setId(getId());
	}

	public InfoUser getInfoUser() {
		return infoUser;
	}

	
	/**
	 * Constructeur par d�faut
	 */
	public BaseEntity(){
		
	}
	
	public BaseEntity(InfoUser infoUser){
		this.infoUser = infoUser;
	}
	
	/****
	 * Retourne le code r�el de l'entit�; Correspond au code entit� dans le cas d'une entit� simple
	 * <br> Dans le cas d'une entit� compos�e, retourne le code de l'entit� concr�te repr�sent� par cette instance
	 * @return
	 */
	public abstract String getEntityCode();

	/*****
	 * Retourne le code de l'entit�
	 * <br> Si l'entit� est une entit� compos�e , retourne la liste des code des entit�s composantes 
	 * @return
	 */
	public String getRealEntityCode(){
		return getEntityCode();
	}
	
	public abstract Serializable getId();
	
	public abstract void setId(Serializable id);
	
	public abstract void validateData();
	
	public abstract void initData();

	/***
	 * R�alise une copie de l'entit� en r�initialisant les champs qu'il faut
	 * @return
	 */
	public BaseEntity copie(){
		return null;		
	}
	
	/***
	 * Utilis� pour la pagination : position de d�but de s�lection de donn�es
	 */
	protected int offset;
	
	/***
	 * Utilis� pour la pagination : position de fin de s�lection de donn�es
	 */
	protected int maxRow;

	/**** 
	 * @return Retourne la position de d�but de s�lection de donn�es dans le m�canisme de pagination
	 */
	public int getOffset() {
		return offset;
	}
	
	/***
	 * D�finit la position de d�but de s�lection de donn�es dans le m�canisme de pagination
	 * @param maxRow : Position de fin de s�lection de donn�es
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	/**** 
	 * @return Retourne la position de fin de s�lection de donn�es dans le m�canisme de pagination
	 */
	public int getMaxRow() {
		return maxRow;
	}

	/***
	 * D�finit la position de fin de s�lection de donn�esdans le m�canisme de pagination
	 * @param maxRow : Position de fin de s�lection de donn�es
	 */
	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}

	public boolean getApplyFilter() {
		return applyFilter;
	}
	
	public void setApplyFilter(boolean applyFilter) {
		this.applyFilter = applyFilter;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	public static BaseEntity getBaseEntity(Object p$entity){
		if(p$entity instanceof BaseEntity)
			return (BaseEntity)p$entity;
		return null;
	}
	
	public static InfoUser getInfoUser(Object p$entity){
		BaseEntity base = getBaseEntity(p$entity);
		if(base!=null)
			return base.getInfoUser();
		return null;
	}
	
	public String getSpecialId(){
		return (this.getId()==null ? "null" : this.getId().toString()) + "-null-null";
	}
	
	
}
