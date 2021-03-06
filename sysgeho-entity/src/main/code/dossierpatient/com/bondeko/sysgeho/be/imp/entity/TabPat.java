package com.bondeko.sysgeho.be.imp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.bondeko.sysgeho.be.core.enums.EnuStatutMat;
import com.bondeko.sysgeho.be.core.enums.EnuTitre;
import com.bondeko.sysgeho.be.ref.entity.TabAss;
import com.bondeko.sysgeho.be.ref.entity.TabSoc;
import com.bondeko.sysgeho.be.util.InfoUser;

@Entity
@Table(name="TAB_PAT")
public class TabPat extends SysGehoBaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getEntityCode() {
		return "Pat";
	}
	
	public TabPat(){
		
	}
	
	public TabPat(InfoUser infoUser){
		this.setInfoUser(infoUser);
	}
	
	@Id
	@Column(name = "COD_PAT")
	private String codPat;
	
	@Column(name = "LIB_MAT")
	private String libMat;
	
	@Column(name = "LIB_TIT")
	private String libTit;
	
	//nom 
	@Column(name = "LIB_NOM")
	private String libNom;
	
	//Prenom
	@Column(name = "LIB_PRE")
	private String libPre;
	
	//Prenom
	@Column(name = "ENU_STA_MAT")
	private String enuStaMat;
	
	@Column(name = "DAT_NAIS")
	private String datNais;
	
	//Sexe
	@Column(name = "LIB_SEX")
	private String libSex;
	
	@Column(name = "LIB_ADR")
	private String libAdr;
	
	@Column(name = "LIB_NUM_TEL")
	private String libNumTel;
	
	@Column(name = "LIB_NUM_CNI")
	private String libNumCni;
	
	@Column(name = "LIB_PROF")
	private String libProf;
	
	@Column(name = "LIB_FON")
	private String libFon;
	
	@Column(name = "BOO_EST_ASS")
	private BigDecimal booEstAss; 
	
	@Column(name = "BOO_EST_AFF")
	private BigDecimal booEstAff; 
	
	@Column(name = "LIB_PER_CON")
	private String libPerCon;
	
	@Column(name = "LIB_NUM_TEL_PER_CON")
	private String libNumTelPerCon;
	
	@Column(name = "LIB_NUM_CNPS")
	private String libNumCnps;
	
	@ManyToOne
	@JoinColumn(name = "COD_ASS")
	private TabAss tabAss;
	
	@ManyToOne
	@JoinColumn(name = "COD_SOC")
	private TabSoc tabSoc;
	
	@Column(name = "DAT_ENREG")
	private String datEnreg;
	
	@Column(name = "BOO_EST_ARCH")
	private BigDecimal booEstArch; 
	
	@Column(name = "LIB_MED")
	private String libMed;
	
	//utilis� pour les �tats
	@Column(name = "DAT_DEB")
	private String datDebut;
	//utilis� pour les �tats
	@Column(name = "DAT_FIN")
	private String datFin;

	public String getCodPat() {
		return codPat;
	}

	public void setCodPat(String codPat) {
		this.codPat = codPat;
	}

	public String getLibMat() {
		return libMat;
	}

	public void setLibMat(String libMat) {
		this.libMat = libMat;
	}

	public String getLibTit() {
		return libTit;
	}

	public void setLibTit(String libTit) {
		this.libTit = libTit;
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

	public String getEnuStaMat() {
		return enuStaMat;
	}

	public void setEnuStaMat(String enuStaMat) {
		this.enuStaMat = enuStaMat;
	}

	public String getDatNais() {
		return datNais;
	}

	public void setDatNais(String datNais) {
		this.datNais = datNais;
	}
	
	public Date getDateNais() {
		if (this.datNais == null || this.datNais.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datNais);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateNais(Date date) {
		if (date == null)
			this.datNais = null;
		else
			this.datNais = DateTools.formatDate(date);
	}
	
	public String getLibSex() {
		return libSex;
	}

	public void setLibSex(String libSex) {
		this.libSex = libSex;
	}

	public String getLibAdr() {
		return libAdr;
	}

	public void setLibAdr(String libAdr) {
		this.libAdr = libAdr;
	}

	public String getLibNumTel() {
		return libNumTel;
	}

	public void setLibNumTel(String libNumTel) {
		this.libNumTel = libNumTel;
	}

	public String getLibProf() {
		return libProf;
	}

	public void setLibProf(String libProf) {
		this.libProf = libProf;
	}

	public String getLibFon() {
		return libFon;
	}

	public void setLibFon(String libFon) {
		this.libFon = libFon;
	}

	public BigDecimal getBooEstAss() {
		return booEstAss;
	}

	public void setBooEstAss(BigDecimal booEstAss) {
		this.booEstAss = booEstAss;
	}
	
	public boolean getBEstAss() {
		return (booEstAss != null && booEstAss.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstAss(boolean bEstAss) {
		this.booEstAss = (bEstAss ? BigDecimal.ONE : BigDecimal.ZERO);
	}

	public BigDecimal getBooEstAff() {
		return booEstAff;
	}

	public void setBooEstAff(BigDecimal booEstAff) {
		this.booEstAff = booEstAff;
	}
	
	public boolean getBEstAff() {
		return (booEstAff != null && booEstAff.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstAff(boolean bEstAff) {
		this.booEstAff = (bEstAff ? BigDecimal.ONE : BigDecimal.ZERO);
	}

	public String getLibPerCon() {
		return libPerCon;
	}

	public void setLibPerCon(String libPerCon) {
		this.libPerCon = libPerCon;
	}

	public String getLibNumTelPerCon() {
		return libNumTelPerCon;
	}

	public void setLibNumTelPerCon(String libNumTelPerCon) {
		this.libNumTelPerCon = libNumTelPerCon;
	}

	public String getDatEnreg() {
		return datEnreg;
	}

	public void setDatEnreg(String datEnreg) {
		this.datEnreg = datEnreg;
	}

	public BigDecimal getBooEstArch() {
		return booEstArch;
	}
	
	public Date getDateEnreg() {
		if (this.datEnreg == null || this.datEnreg.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datEnreg);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateEnreg(Date date) {
		if (date == null)
			this.datEnreg = null;
		else
			this.datEnreg = DateTools.formatDate(date);
	}

	public void setBooEstArch(BigDecimal booEstArch) {
		this.booEstArch = booEstArch;
	}
	
	public boolean getBEstArch() {
		return (booEstArch != null && booEstArch.compareTo(BigDecimal.ONE) == 0);
	}

	public void setBEstArch(boolean bEstArch) {
		this.booEstArch = (bEstArch ? BigDecimal.ONE : BigDecimal.ZERO);
	}

	public String getLibMed() {
		return libMed;
	}

	public void setLibMed(String libMed) {
		this.libMed = libMed;
	} 
	
	@Override
	public Serializable getId() {
		return getCodPat();
	}
	
	@Override
	public void setId(Serializable id) {
		setCodPat((String) id);
		
	}

	@Override
	public void validateData() {
		
		tabAss = (tabAss != null && 
				(tabAss.getCodAss() == null || tabAss.getCodAss().trim().isEmpty()) 
				? null : tabAss);
		
		tabSoc = (tabSoc != null && 
				(tabSoc.getCodSoc() == null || tabSoc.getCodSoc().trim().isEmpty()) 
				? null : tabSoc);
	}

	@Override
	public void initData() {
		tabAss = (tabAss == null ? new TabAss() : tabAss);
		tabSoc = (tabSoc == null ? new TabSoc() : tabSoc);
		tabAss.initData();
		tabSoc.initData();
	}
	
	public TabAss getTabAss() {
		return tabAss;
	}

	public void setTabAss(TabAss tabAss) {
		this.tabAss = tabAss;
	}

	public TabSoc getTabSoc() {
		return tabSoc;
	}

	public void setTabSoc(TabSoc tabSoc) {
		this.tabSoc = tabSoc;
	}

	public String getLEnuStaMat() {
		EnuStatutMat v$enum = EnuStatutMat.getByValue(this.enuStaMat); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}
	
	public String getLEnuTitre() {
		EnuTitre v$enum = EnuTitre.getByValue(this.libTit); 
		return (v$enum == null)? null: v$enum.getLibelle();
	}

	public void setLibNumCni(String libNumCni) {
		this.libNumCni = libNumCni;
	}

	public String getLibNumCni() {
		return libNumCni;
	}

	public void setLibNumCnps(String libNumCnps) {
		this.libNumCnps = libNumCnps;
	}

	public String getLibNumCnps() {
		return libNumCnps;
	}
	
	public boolean getBEstAffi() {
		return (booEstAff != null && booEstAff.compareTo(BigDecimal.ONE) == 0);
	}

	/**
	 * @param datDebut the datDebut to set
	 */
	public void setDatDebut(String datDebut) {
		this.datDebut = datDebut;
	}

	/**
	 * @return the datDebut
	 */
	public String getDatDebut() {
		return datDebut;
	}

	/**
	 * @param datFin the datFin to set
	 */
	public void setDatFin(String datFin) {
		this.datFin = datFin;
	}

	/**
	 * @return the datFin
	 */
	public String getDatFin() {
		return datFin;
	}
	
	public void setDateDebut(Date date) {
		if (date == null)
			this.datDebut = null;
		else
			this.datDebut = DateTools.formatDate(date);
	}
	
	public Date getDateDebut() {
		if (this.datDebut == null || this.datDebut.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datDebut);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setDateFin(Date date) {
		if (date == null)
			this.datFin = null;
		else
			this.datFin = DateTools.formatDate(date);
	}
	
	public Date getDateFin() {
		if (this.datFin == null || this.datFin.trim().isEmpty())
			return null;

		try {
			return DateTools.getDateValue(this.datFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
