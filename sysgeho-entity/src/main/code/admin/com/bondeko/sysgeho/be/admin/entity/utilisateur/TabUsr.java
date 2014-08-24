package com.bondeko.sysgeho.be.admin.entity.utilisateur;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		this.setInfoUser(infoUser);
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
	
	@ManyToOne
	@JoinColumn(name = "COD_SVC")
	private TabSvc tabSvc;
	
	@ManyToOne
	@JoinColumn(name = "COD_ROL")
	private TabRol tabRol;
	
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
		
		tabSvc = (tabSvc != null && 
				(tabSvc.getCodSvc() == null || tabSvc.getCodSvc().trim().isEmpty())
				? null : tabSvc);
		
		tabRol = (tabRol != null && 
				(tabRol.getCodRol() == null || tabRol.getCodRol().trim().isEmpty())
				? null : tabRol);
	}

	@Override
	public void initData() {
		tabSvc = (tabSvc == null ? new TabSvc() : tabSvc);
		tabRol = (tabRol == null ? new TabRol() : tabRol);
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

	public void setTabSvc(TabSvc tabSvc) {
		this.tabSvc = tabSvc;
	}

	public TabSvc getTabSvc() {
		return tabSvc;
	}

	public void setTabRol(TabRol tabRol) {
		this.tabRol = tabRol;
	}

	public TabRol getTabRol() {
		return tabRol;
	}

}
