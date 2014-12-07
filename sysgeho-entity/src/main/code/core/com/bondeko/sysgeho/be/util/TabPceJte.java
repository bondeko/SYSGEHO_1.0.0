package com.bondeko.sysgeho.be.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bondeko.sysgeho.be.core.base.BaseLogger;
import com.bondeko.sysgeho.be.core.base.DateTools;
import com.bondeko.sysgeho.be.core.base.SysGehoBaseEntity;

@Entity
@Table(name = "TAB_PCE_JTE")
public class TabPceJte extends SysGehoBaseEntity implements Serializable{

	private static BaseLogger logger = BaseLogger.getLogger(TabPceJte.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getEntityCode() {
		return "PceJte";
	}
	
	public TabPceJte(){
		
	}
	
	public TabPceJte(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}

	@Id
	@Column(name = "C_PCE")
	private String cPce;

	@Column(name = "D_PCE")
	private String dPce;

	@Column(name = "L_INF_PCE")
	private String lInfPce;

	@Column(name = "L_REF_FCH")
	private String lRefFch;
	
	@Column(name = "L_REF_PCE")
	private String lRefPce;

	@Column(name = "V_VAL_PCE")
	private BigDecimal vValPce;

	@Transient
	private EntFichier fichier;

	@ManyToOne
	@JoinColumn(name = "C_LOT_DOC")
	private TabLotDoc tabLotDoc;


	@Column(name="C_TYP_PCE")
	private String cTypPce;
	

	public Date getDatePce() {
		try {
			if (this.dPce != null && !this.dPce.isEmpty())
				return DateTools.getDateValue(this.dPce);
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	public void setDatePce(Date date) {
		if(date == null)
			this.dPce = null;
		else
			this.dPce = DateTools.formatDate(date);
	}

	public String getCPce() {
		return this.cPce;
	}

	public void setCPce(String cPce) {
		this.cPce = formatString(cPce);
	}

	public String getDPce() {
		return this.dPce;
	}

	public void setDPce(String dPce) {
		this.dPce = formatString(dPce);
	}

	public String getLInfPce() {
		return this.lInfPce;
	}

	public void setLInfPce(String lInfPce) {
		this.lInfPce = formatString(lInfPce);
	}

	public String getLRefFch() {
		return this.lRefFch;
	}

	public void setLRefFch(String lRefFch) {
		this.lRefFch = formatString(lRefFch);
	}

	public String getLRefPce() {
		return this.lRefPce;
	}

	public void setLRefPce(String lRefPce) {
		this.lRefPce = formatString(lRefPce);
	}

	public TabLotDoc getTabLotDoc() {
		return this.tabLotDoc;
	}

	public void setTabLotDoc(TabLotDoc tabLotDoc) {
		this.tabLotDoc = tabLotDoc;
	}

	public void setCTypPce(String cTypPce) {
		this.cTypPce = cTypPce;
	}

	public String getCTypPce() {
		return cTypPce;
	}

	public void setFichier(EntFichier fichier) {
		this.fichier = fichier;
	}

	public EntFichier getFichier() {
		return fichier;
	}

	@Override
	public Serializable getId() {
		return getCPce();
	}

	@Override
	public void setId(Serializable id) {
		this.setCPce((String) id);
	}

	@Override
	public void validateData() {
		try {
			if (this.getTabLotDoc() != null
					&& (this.getTabLotDoc().getCLotDoc() == null || this
							.getTabLotDoc().getCLotDoc().trim().isEmpty()))
				this.setTabLotDoc(null);
		} catch (Exception e) {
		}

	}

	@Override
	public void initData() {
		this.tabLotDoc = (this.tabLotDoc == null) ? new TabLotDoc()
				: this.tabLotDoc;
	}

	public void setGeneratedCode() {
//		this.setDPce(DateTools.formatDate(new Date()));
		logger.debug("Génération du code de la pièce <" + this.getLRefFch()
				+ ">:::<" + this.getLRefPce() + ">");
		String code = "";
		String str = "";
		try {
			str = this.getTabLotDoc().getCLotDoc();
			code += (str == null || str.isEmpty()) ? "" : str
					+ "_";
		} catch (Exception e) {// 14
			logger.warn("Erreur sur de génération du code de la pièce jointe<"
					+ this.getLRefFch() + ">:::<" + this.getLRefPce()
					+ "> : Erreur de récupération du code du lot documentaire!!!!!");
			code += "DEFAULT" + "_";
		}
		
		try {
			str = "10801";//Corresponds au type de la piece jointe : justificatif
			code += (str == null || str.isEmpty()) ? "" : str
					+ "_";
		} catch (Exception e) {// 20
			logger.warn("Erreur sur de génération du code de la pièce jointe<"
					+ this.getLRefFch() + ">:::<" + this.getLRefPce()
					+ "> : Erreur de récupération de la nature de la pièce !!!!");
			code += "10801" + "_";
		}

		try {
			str = "Fac";
			int nbre = this.getTabLotDoc().getZPce() == null ? 1 : this
					.getTabLotDoc().getZPce().intValue() + 1;
			logger.debug("Numéro de la pièce <" + this.getLRefFch() + ">:::<"
					+ this.getLRefPce() + "> : " + nbre);
			str += DateTools.padRigth(String.valueOf(nbre), 6, '0');
			
			str = str.substring(0, 9);

			code += (str == null || str.isEmpty()) ? "" : str
					+ "_";
		} catch (Exception e) {// 29
		}

		try {
			code += this.getFichier().getMime().getMimeCode();
		} catch (Exception e) {
			code += MimeType.UNKNOWN.getMimeCode();
		}// 34
		
		logger.warn("Code de la pièce jointe généré <" + code + ">");
		
		this.setCPce(code);
	}

	public String getFileExtention() {
		String v$name = this.lRefFch;
		if (v$name != null && !v$name.isEmpty()) {
			try {
				int extDot = v$name.lastIndexOf('.');
				String extension = "";
				if (extDot > 0) {
					extension = v$name.substring(extDot + 1);
				}
				return extension;
			} catch (Exception e) {
				return "";
			}
		} else if (this.fichier != null) {
			try {
				return fichier.getExtention();
			} catch (Exception e) {
				return "";
			}
		}
		return "";
	}

	// ###############################################################//

	/***
	 * Détermine si la recher par interval sur la date est activée
	 */
	public boolean getIsDateIntervalSearchEnabled() {
		return this.getIsMaxDateIntervalSearchEnabled()
				|| this.getIsMinDateIntervalSearchEnabled();
	}

	/***
	 * Détermine si la borde supérieure de recherche sur la date de création est
	 * définie
	 * 
	 * @return
	 */
	public boolean getIsMaxDateIntervalSearchEnabled() {
		return (this.itvMaxDate == null || this.itvMaxDate.isEmpty()) ? false
				: true;
	}

	/***
	 * Détermine si la borde inférieure de recherche sur la date de création est
	 * définie
	 * 
	 * @return
	 */
	public boolean getIsMinDateIntervalSearchEnabled() {
		return (this.itvMinDate == null || this.itvMinDate.isEmpty()) ? false
				: true;
	}

	/***
	 * Définie la borne inférieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @param itvMinDate
	 */
	public void setItvMinDate(String itvMinDate) {
		this.itvMinDate = itvMinDate;
	}

	/***
	 * Définie la bore inférieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @param dateVal
	 */
	public void setItvMinDateVal(Date dateVal) {
		if (dateVal == null)
			this.itvMinDate = null;
		else
			this.itvMinDate = DateTools.formatDate(dateVal);
	}

	/***
	 * Retourne la boorne inférieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @return
	 */
	public String getItvMinDate() {
		return itvMinDate;
	}

	/***
	 * Retourne la boorne inférieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @return
	 */
	public Date getItvMinDateVal() {
		if (this.itvMinDate == null || this.itvMinDate.trim().isEmpty())
			return null;
		else
			try {
				return DateTools.getDateValue(this.itvMinDate);
			} catch (Exception e) {
				return null;
			}
	}

	/***
	 * Définie la bore supérieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @param dateVal
	 */
	public void setItvMaxDate(String itvMaxDate) {
		this.itvMaxDate = itvMaxDate;
	}

	/***
	 * Définie la bore supérieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @param dateVal
	 */

	public void setItvMaxDateVal(Date dateVal) {
		if (dateVal == null)
			this.itvMaxDate = null;
		else
			this.itvMaxDate = DateTools.formatDate(dateVal);
	}

	/***
	 * Retourne la boorne supérieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @return
	 */
	public String getItvMaxDate() {
		return itvMaxDate;
	}

	/***
	 * Retourne la boorne maxérieure de recherche sur la date de création d'une
	 * entité
	 * 
	 * @return
	 */
	public Date getItvMaxDateVal() {
		if (this.itvMaxDate == null || this.itvMaxDate.trim().isEmpty())
			return null;
		else
			try {
				return DateTools.getDateValue(this.itvMaxDate);
			} catch (Exception e) {
				return null;
			}
	}

	@Transient
	private String itvMinDate;

	@Transient
	private String itvMaxDate;

	public String getItvDateField() {
		return "dPce";
	}

	public void setVValPce(BigDecimal vValPce) {
		this.vValPce = vValPce;
	}

	public BigDecimal getVValPce() {
		return vValPce;
	}

}