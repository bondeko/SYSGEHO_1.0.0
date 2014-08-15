package com.bondeko.sysgeho.be.admin.entity.utilisateur;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_USR")
public class TabUsr extends SysGehoBaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public TabUsr(){
		
	}
	
	public TabUsr(InfoUser infoUser){
		
	}
	
	//code de l'utilisateur
	@Id
	@Column(name = "COD_USR")
	private String codUsr;

	//Sexe
	@Column(name = "BOO_SEX")
	private String booSex;

	//mot de passe
	@Column(name = "COD_PWD")
	private String codPwd;

	//Date d'expiration du mot de passe
	@Column(name = "DAT_EXP_PWD")
	private String datExpPwd;

	//date d'embauche
	@Column(name = "DAT_EMBCH")
	private String datEmbch;

	//L'adresse
	@Column(name = "LIB_ADR")
	private String libAdr;
	
	//nom de l'utilisateur
	@Column(name = "LIB_NOM")
	private String libNom;
	
	//Prenom
	@Column(name = "LIB_PRE")
	private String libPre;
	
	//Fonction
	@Column(name = "LIB_FON")
	private String libFon;
	
	@Column(name = "COD_SVC")
	private String codSvc;
	
	@Column(name = "LIB_SVC")
	private String libSvc;
	
	@Column(name = "COD_ROL")
	private String codRol;
	
	@Column(name = "LIB_ROL")
	private String libRol;
	

	public String getCodUsr() {
		return codUsr;
	}

	public void setCodUsr(String codUsr) {
		this.codUsr = codUsr;
	}

	public String getBooSex() {
		return booSex;
	}

	public void setBooSex(String booSex) {
		this.booSex = booSex;
	}

	public String getCodPwd() {
		return codPwd;
	}

	public void setCodPwd(String codPwd) {
		this.codPwd = codPwd;
	}

	public String getDatExpPwd() {
		return datExpPwd;
	}

	public void setDatExpPwd(String datExpPwd) {
		this.datExpPwd = datExpPwd;
	}

	public String getDatEmbch() {
		return datEmbch;
	}

	public void setDatEmbch(String datEmbch) {
		this.datEmbch = datEmbch;
	}

	public String getLibAdr() {
		return libAdr;
	}

	public void setLibAdr(String libAdr) {
		this.libAdr = libAdr;
	}

	public String getLibNom() {
		return libNom;
	}

	public void setLibNom(String libNom) {
		this.libNom = libNom;
	}

	public String getLibPre() {
		return libPre;
	}

	public void setLibPre(String libPre) {
		this.libPre = libPre;
	}

	@Override
	public Serializable getId() {
		return getCodUsr();
	}

	@Override
	public void setId(Serializable id) {
		setCodUsr((String) id);
		
	}

	@Override
	public void validateData() {
	}

	@Override
	public void initData() {
	}
	
	public Date getDateEmbauche() {
		try {
			if (this.datEmbch != null && !this.datEmbch.isEmpty()) {
				return DateTools.getDateValue(this.datEmbch);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public Date getDateExpPwd() {
		if (this.datExpPwd == null || this.datExpPwd.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datExpPwd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateEmbauche(Date dateEmbauche) {
		if (dateEmbauche == null)
			this.datEmbch = null;
		else
			this.datEmbch = DateTools.formatDate(dateEmbauche);
	}
	
	

	/***
	 * 
	 * @return Retourne true si la date d'expiration du mot de passe est
	 *         atteinte et false sinon
	 */
	public boolean getPwdExpire() {
		if (this.datExpPwd != null && !this.datExpPwd.trim().isEmpty()) {
			String todayDate = DateTools.formatDate(new Date());
			int nbre = todayDate.compareTo(this.datExpPwd);
			return (nbre > 0);
		}
		return false;
	}
	
	public void setDateExpPwd(Date date) {
		if (date == null)
			this.datExpPwd = null;
		else
			this.datExpPwd = DateTools.formatDate(date);
	}

	@Override
	public String getEntityCode() {
		return "Usr";
	}

	public void setLibFon(String libFon) {
		this.libFon = libFon;
	}

	public String getLibFon() {
		return libFon;
	}

	public void setLibSvc(String libSvc) {
		this.libSvc = libSvc;
	}

	public String getLibSvc() {
		return libSvc;
	}

	public void setCodSvc(String codSvc) {
		this.codSvc = codSvc;
	}

	public String getCodSvc() {
		return codSvc;
	}

	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public String getCodRol() {
		return codRol;
	}

	public void setLibRol(String libRol) {
		this.libRol = libRol;
	}

	public String getLibRol() {
		return libRol;
	}

}
