CREATE TABLE TAB_INC_COD (
  COD_INC_COD varchar(45) ,
  LIB_DESC varchar(45) ,
  VAL_INC_COD decimal(10,0),
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_INC_COD)
);

DROP TABLE IF EXISTS `tab_usr`;
CREATE TABLE `tab_usr` (
  `COD_USR` varchar(32) NOT NULL DEFAULT '',
  `BOO_SEX` varchar(32) DEFAULT NULL,
  `COD_PWD` varchar(255) DEFAULT NULL,
  `DAT_EMBCH` varchar(32) DEFAULT NULL,
  `DAT_EXP_PWD` varchar(32) DEFAULT NULL,
  `LIB_ADR` varchar(255) DEFAULT NULL,
  `LIB_FON` varchar(255) DEFAULT NULL,
  `LIB_NOM` varchar(255) DEFAULT NULL,
  `LIB_PRE` varchar(255) DEFAULT NULL,
  `COD_SVC` varchar(32) DEFAULT NULL,
  `LIB_SVC` varchar(255) DEFAULT NULL,
  `COD_ROL` varchar(32) DEFAULT NULL,
  `LIB_ROL` varchar(255) DEFAULT NULL,
  `BOO_ACT` decimal(19,2) DEFAULT NULL,
  `COD_EXE_FIS` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(32) DEFAULT NULL,
  `DAT_MOD` varchar(32) DEFAULT NULL,
  `DAT_CRT` varchar(32) DEFAULT NULL,
  `COD_USR_MOD` varchar(32) DEFAULT NULL,
  `COD_USR_CRT` varchar(32) DEFAULT NULL,
   PRIMARY KEY (`COD_USR`)
) 

CREATE TABLE TAB_SVC (
  COD_SVC varchar(32) ,
  LIB_SVC varchar(255) ,
  LIB_DESC varchar(255) ,
  COD_SVC_PAR varchar(32) ,
  LIB_SVC_PAR varchar(255) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_SVC)
);

CREATE TABLE TAB_ROL (
  COD_ROL varchar(32) ,
  LIB_ROL varchar(255) ,
  LIB_DESC varchar(255) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_ROL)
);

CREATE TABLE TAB_SOC (
  COD_SOC varchar(32) ,
  LIB_SOC varchar(255) ,
  LIB_RESP varchar(255) ,
  LIB_BP varchar(32) ,
  LIB_VIL varchar(32) ,
  LIB_TEL varchar(32) ,
  LIB_NUM_CONTRIB varchar(32) ,
  LIB_SIEGE varchar(255) ,
  LIB_ADR_COM varchar(32) ,
  BOO_EST_AFF	 NUMERIC(1,0) DEFAULT 0,
  DAT_AFF varchar(32) ,
  VAL_EFF decimal(20,2),
  VAL_PRI_UNI decimal(20,2),
  DAT_CRE varchar(32) ,
  LIB_MAIL varchar(32) ,
  LIB_FAX varchar(32) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_SOC)
);

CREATE TABLE TAB_PAT (
  COD_PAT varchar(32) ,
  LIB_MAT varchar(255) ,
  LIB_TIT varchar(255) ,
  LIB_NOM varchar(255) ,
  LIB_PRE varchar(255) ,
  ENU_STA_MAT varchar(32) ,
  DAT_NAIS varchar(32) ,
  LIB_SEX varchar(32) ,
  LIB_ADR varchar(255) ,
  LIB_NUM_TEL varchar(32) ,
  LIB_PROF varchar(255) ,
  LIB_FON varchar(255) ,
  COD_SOC varchar(32) ,
  LIB_SOC varchar(255) ,
  BOO_EST_ASS	 NUMERIC(1,0) DEFAULT 0,
  BOO_EST_AFF	 NUMERIC(1,0) DEFAULT 0,
  LIB_PER_CON varchar(255) ,
  LIB_NUM_TEL_PER_CON varchar(32) ,
  COD_ASS varchar(32) ,
  LIB_ASS varchar(255) ,
  DAT_ENREG varchar(32) ,
  BOO_EST_ARCH	 NUMERIC(1,0) DEFAULT 0,
  LIB_MED varchar(255) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_PAT)
);

CREATE TABLE TAB_ASS (
  COD_ASS varchar(32) ,
  LIB_ASS varchar(255) ,
  LIB_DESC varchar(255) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_ASS)
);

CREATE TABLE TAB_CAT_EXAM (
  COD_CAT_EXAM varchar(32) ,
  LIB_CAT_EXAM varchar(255) ,
  COD_SPEC varchar(32) ,
  LIB_SPEC varchar(255) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_CAT_EXAM)
);

CREATE TABLE TAB_TYP_EXAM (
  COD_TYP_EXAM varchar(32) ,
  LIB_TYP_EXAM varchar(255) ,
  LIB_DESC varchar(255) ,
  COD_CAT_EXAM varchar(32) ,
  LIB_CAT_EXAM varchar(255) ,
  
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_TYP_EXAM)
);

CREATE TABLE TAB_TYP_SOIN (
  COD_TYP_SOIN varchar(32) ,
  LIB_TYP_SOIN varchar(255) ,
  LIB_DESC varchar(255) ,
  
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_TYP_SOIN)
);

CREATE TABLE TAB_SPEC(
  COD_SPEC varchar(32) ,
  LIB_SPEC varchar(255) ,
  LIB_DESC varchar(255) ,
  
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_SPEC)
);


CREATE TABLE TAB_TYP_RDV (
  COD_TYP_RDV varchar(32) ,
  LIB_TYP_RDV varchar(255) ,
  LIB_DESC varchar(255) ,
  
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_TYP_RDV)
);

CREATE TABLE TAB_RDV (
  COD_RDV varchar(32) ,
  COD_PAT varchar(32) ,
  COD_USR varchar(32) ,
  COD_TYP_RDV varchar(32) ,
  LIB_TYP_RDV varchar(255) ,
  COD_SVC varchar(32) ,
  LIB_SVC varchar(255) ,
  DAT_DEM varchar(32) ,
  DAT_RDV varchar(32) ,
  VAL_NUM_ORDRE decimal(20,0),
  LIB_OBS varchar(255) ,
  BOO_EST_ANN	 NUMERIC(1,0) DEFAULT 0,
  BOO_EST_CONF	 NUMERIC(1,0) DEFAULT 0, 
   
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_RDV)
);

CREATE TABLE TAB_CONSUL (
  COD_CONSUL varchar(32) ,
  COD_PAT varchar(32) ,
  COD_USR varchar(32) ,
  COD_SPEC varchar(32) ,
  VAL_POIDS varchar(32) ,
  VAL_TENSION varchar(10) ,
  VAL_POU varchar(10) ,
  VAL_TAILLE varchar(10) ,
  DAT_CONSUL varchar(32) ,
  LIB_STATUT varchar(255) ,
  VAL_MNT_TTC decimal(20,2) ,
  BOO_VAL NUMERIC(1,0) DEFAULT 0,
  BOO_CPTE_RENDU NUMERIC(1,0) DEFAULT 0,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_CONSUL)
);

CREATE TABLE TAB_CPTE_RENDU_CONSUL (
  COD_CPTE_RENDU_CONSUL varchar(32) ,
  COD_CONSUL varchar(32) ,
  LIB_MOTIF_CONSUL varchar(1024) ,
  LIB_HIS_MAL varchar(1024) ,
  LIB_DIAG_PRIN varchar(1024) ,
  LIB_DIAG_SENC varchar(1024) ,
  LIB_EXAM_BIO varchar(1024) ,
  LIB_EXPLO_FONC varchar(1024) ,
  LIB_EXAM_IMAG varchar(1024) ,
  LIB_TRAIT_PRES varchar(1024) ,
  LIB_CONCL varchar(1024) ,
  DAT varchar(32) ,
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  PRIMARY KEY (COD_CPTE_RENDU_CONSUL)
);

