package com.bondeko.sysgeho.ui.core.base;

import java.util.ArrayList;

import com.bondeko.sysgeho.be.core.base.BaseEntity;
import com.bondeko.sysgeho.be.util.TabLotDoc;

public class TableManager <T extends BaseEntity> extends AbstractTableManager<T>{
	
	/**
	 * Constructeur par défaut
	 */
	public TableManager() {
		super();
		//  Auto-generated constructor stub
	}	
	
	/**
	 * @param lotDoc the lotDoc to set
	 */
	public void setLotDoc(TabLotDoc lotDoc) {
		
		// Mise à jour de la listes pièces jointes	
		if(lotDoc != null ){
			setListeRecherche(new ArrayList(lotDoc.getTabPceJtes()));
		}
		else {
			setListeRecherche(new ArrayList());
		}	
	}	
	
}
