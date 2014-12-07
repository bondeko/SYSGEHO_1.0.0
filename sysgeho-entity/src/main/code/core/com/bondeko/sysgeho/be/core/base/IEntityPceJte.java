package com.bondeko.sysgeho.be.core.base;

import java.io.Serializable;
import java.util.List;

import com.bondeko.sysgeho.be.util.InfoUser;
import com.bondeko.sysgeho.be.util.TabLotDoc;
import com.bondeko.sysgeho.be.util.TabPceJte;

public interface IEntityPceJte {
	
	public <X extends TabPceJte> void addNewPiece(X piece);
	
	List<TabPceJte> getListNewPce();
	
	public TabLotDoc getTabLotDoc();
	
	public void setTabLotDoc(TabLotDoc lotDoc);
	
	public Serializable getId();
	
	/****
	 * Retourne le ticket associé à l’entité
	 * 
	 * @return
	 */
	public InfoUser getInfoUser();
	
	
}
