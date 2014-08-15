package com.bondeko.sysgeho.be.admin.entity.utilisateur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;


@Entity
@Table(name="TAB_SVC")
public class TabSvc extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public TabSvc(){
		
	}
	
	public TabSvc(InfoUser infoUser){
		
	}
	
	@Id
	@Column(name = "COD_SVC")
	private String codSvc;

	@Column(name = "LIB_SVC")
	private String libSvc;
	
	//Description
	@Column(name = "LIB_DESC")
	private String libDesc;
	
	@Column(name = "COD_SVC_PAR")
	private String codSvcPar;
	
	@Column(name = "LIB_SVC_PAR")
	private String libSvcPar;
	
//	@ManyToOne
//	@JoinColumn(name = "COD_STR_PAR")
//	private TabSvc tabSvcPar;

	@Override
	public String getEntityCode() {
		return "Svc";
	}

	@Override
	public Serializable getId() {
		return getCodSvc();
	}

	@Override
	public void setId(Serializable id) {
		setCodSvc((String) id);
	}


	@Override
	public void validateData() {
		
//		tabSvcPar = (tabSvcPar != null && (tabSvcPar.getCodSvc() == null || tabSvcPar.getCodSvc().trim().isEmpty()) 
//				? null : tabSvcPar);
	}

	@Override
	public void initData() {
//		tabSvcPar = (tabSvcPar == null ? new TabSvc() : tabSvcPar);
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setCodSvc(String codSvc) {
		this.codSvc = codSvc;
	}

	public String getCodSvc() {
		return codSvc;
	}

	public void setLibSvc(String libSvc) {
		this.libSvc = libSvc;
	}

	public String getLibSvc() {
		return libSvc;
	}

	public void setCodSvcPar(String codSvcPar) {
		this.codSvcPar = codSvcPar;
	}

	public String getCodSvcPar() {
		return codSvcPar;
	}

	public void setLibSvcPar(String libSvcPar) {
		this.libSvcPar = libSvcPar;
	}

	public String getLibSvcPar() {
		return libSvcPar;
	}

//	public void setTabSvcPar(TabSvc tabSvcPar) {
//		this.tabSvcPar = tabSvcPar;
//	}
//
//	public TabSvc getTabSvcPar() {
//		return tabSvcPar;
//	}


}
