package com.bondeko.sysgeho.be.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;

@Entity
@Table(name = "TAB_LOT_DOC")
public class TabLotDoc extends SysGehoBaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "LotDoc";
	}
	
	public TabLotDoc(){
		
	}
	
	public TabLotDoc(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}


	@Id
	@Column(name = "C_LOT_DOC")
	private String cLotDoc;

	@Column(name = "Z_PCE")
	private BigDecimal zPce;

	@Column(name = "L_INF_LOT")
	private String lInfLot;

	@Column(name = "L_LOT_DOC")
	private String lLotDoc;

	// bi-directional many-to-one association to TabPceJte
	@OneToMany(mappedBy = "tabLotDoc", fetch = FetchType.EAGER/*
															 * , cascade = {
															 * CascadeType
															 * .MERGE,
															 * CascadeType
															 * .PERSIST,
															 * CascadeType
															 * .REFRESH }
															 */)
	// @Transient
	private Set<TabPceJte> tabPceJtes;


	public String getCLotDoc() {
		return this.cLotDoc;
	}

	public void setCLotDoc(String cLotDoc) {
		this.cLotDoc = formatString(cLotDoc);
	}

	public String getLInfLot() {
		return this.lInfLot;
	}

	public void setLInfLot(String lInfLot) {
		this.lInfLot = formatString(lInfLot);
	}

	public String getLLotDoc() {
		return this.lLotDoc;
	}

	public void setLLotDoc(String lLotDoc) {
		this.lLotDoc = formatString(lLotDoc);
	}

	public Set<TabPceJte> getTabPceJtes() {
		// retourne seulement les pièce jointes qui sont actives
		if (this.tabPceJtes != null) {
			Set<TabPceJte> v$PceJtes = new HashSet<TabPceJte>();

			for (TabPceJte tabPceJte : this.tabPceJtes) {
					v$PceJtes.add(tabPceJte);
			}
			return v$PceJtes;
		} else {
			return null;
		}

	}

	public void setTabPceJtes(Set<TabPceJte> tabPceJtes) {
		this.tabPceJtes = tabPceJtes;
	}

	public void setZPce(BigDecimal zPce) {
		this.zPce = zPce;
	}

	public BigDecimal getZPce() {
		return zPce;
	}

	@Override
	public Serializable getId() {
		return getCLotDoc();
	}

	@Override
	public void setId(Serializable id) {
		this.setCLotDoc((String) id);
	}


	@Override
	public void validateData() {

	}

	@Override
	public void initData() {
	}


	@Transient
	private List<TabPceJte> listPce = new ArrayList<TabPceJte>();

	public List<TabPceJte> getListNewPce() {
		return listPce;
	}

	public void AddPce(TabPceJte listPce) {
		this.listPce.add(listPce);
	}


}