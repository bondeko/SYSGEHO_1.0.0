-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.56-community 


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sysgeho
--

CREATE DATABASE IF NOT EXISTS sysgeho;
USE sysgeho;

--
-- Definition of table `tab_ass`
--

DROP TABLE IF EXISTS `tab_ass`;
CREATE TABLE `tab_ass` (
  `COD_ASS` varchar(32) NOT NULL DEFAULT '',
  `LIB_ASS` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_ASS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_ass`
--

/*!40000 ALTER TABLE `tab_ass` DISABLE KEYS */;
INSERT INTO `tab_ass` (`COD_ASS`,`LIB_ASS`,`LIB_DESC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('ACTIVA','Activa assurance et reassurance',NULL,'2000','2014','1','admin',NULL,'20140811115338000770',NULL),
 ('AXA','AXA Assurance Cameroun ',NULL,'2000','2014','1','admin',NULL,'20140810224220000627',NULL);
/*!40000 ALTER TABLE `tab_ass` ENABLE KEYS */;


--
-- Definition of table `tab_cat_exam`
--

DROP TABLE IF EXISTS `tab_cat_exam`;
CREATE TABLE `tab_cat_exam` (
  `COD_CAT_EXAM` varchar(32) NOT NULL DEFAULT '',
  `LIB_CAT_EXAM` varchar(255) DEFAULT NULL,
  `LIB_SPEC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `COD_SPEC` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`COD_CAT_EXAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_cat_exam`
--

/*!40000 ALTER TABLE `tab_cat_exam` DISABLE KEYS */;
INSERT INTO `tab_cat_exam` (`COD_CAT_EXAM`,`LIB_CAT_EXAM`,`LIB_SPEC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`,`COD_SPEC`) VALUES 
 ('CAR_LOG','Cardiologie','Anti coeur','2000','2014','1','admin',NULL,'20140812195206000927',NULL,NULL),
 ('CAT_A','Categorie n°1','Spécialité n°2','2000','2014','1','admin','admin','20140813131453000603','20140813131949000833','SPEC_B'),
 ('CAT_B','Categorie n°2','Spécialité n°2','2000','2014','1','admin',NULL,'20140813132014000111',NULL,'SPEC_B'),
 ('VIR','Virale','Spécialité n°1','2000','2014','1','admin','admin','20140812195245000037','20140813131928000965','SPEC_A');
/*!40000 ALTER TABLE `tab_cat_exam` ENABLE KEYS */;


--
-- Definition of table `tab_inc_cod`
--

DROP TABLE IF EXISTS `tab_inc_cod`;
CREATE TABLE `tab_inc_cod` (
  `COD_INC_COD` varchar(45) NOT NULL DEFAULT '',
  `LIB_DESC` varchar(45) DEFAULT NULL,
  `VAL_INC_COD` decimal(10,0) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_INC_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_inc_cod`
--

/*!40000 ALTER TABLE `tab_inc_cod` DISABLE KEYS */;
INSERT INTO `tab_inc_cod` (`COD_INC_COD`,`LIB_DESC`,`VAL_INC_COD`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('2014TabPat','compteur patient','3',NULL,NULL,'0','admin','admin','20140809150354000617','20140811213038000551'),
 ('2014TabRdv','compteur RDV','4',NULL,NULL,'0','admin','admin','20140809150354000617','20140815202447000244');
/*!40000 ALTER TABLE `tab_inc_cod` ENABLE KEYS */;


--
-- Definition of table `tab_pat`
--

DROP TABLE IF EXISTS `tab_pat`;
CREATE TABLE `tab_pat` (
  `COD_PAT` varchar(32) NOT NULL DEFAULT '',
  `LIB_MAT` varchar(255) DEFAULT NULL,
  `LIB_TIT` varchar(255) DEFAULT NULL,
  `LIB_NOM` varchar(255) DEFAULT NULL,
  `LIB_PRE` varchar(255) DEFAULT NULL,
  `ENU_STA_MAT` varchar(32) DEFAULT NULL,
  `DAT_NAIS` varchar(32) DEFAULT NULL,
  `LIB_SEX` varchar(32) DEFAULT NULL,
  `LIB_ADR` varchar(255) DEFAULT NULL,
  `LIB_NUM_TEL` varchar(32) DEFAULT NULL,
  `LIB_PROF` varchar(255) DEFAULT NULL,
  `LIB_FON` varchar(255) DEFAULT NULL,
  `COD_SOC` varchar(32) DEFAULT NULL,
  `BOO_EST_ASS` decimal(1,0) DEFAULT '0',
  `BOO_EST_AFF` decimal(1,0) DEFAULT '0',
  `LIB_PER_CON` varchar(255) DEFAULT NULL,
  `LIB_NUM_TEL_PER_CON` varchar(32) DEFAULT NULL,
  `COD_ASS` varchar(32) DEFAULT NULL,
  `DAT_ENREG` varchar(32) DEFAULT NULL,
  `BOO_EST_ARCH` decimal(1,0) DEFAULT '0',
  `LIB_MED` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `LIB_ASS` varchar(255) DEFAULT NULL,
  `LIB_SOC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COD_PAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_pat`
--

/*!40000 ALTER TABLE `tab_pat` DISABLE KEYS */;
INSERT INTO `tab_pat` (`COD_PAT`,`LIB_MAT`,`LIB_TIT`,`LIB_NOM`,`LIB_PRE`,`ENU_STA_MAT`,`DAT_NAIS`,`LIB_SEX`,`LIB_ADR`,`LIB_NUM_TEL`,`LIB_PROF`,`LIB_FON`,`COD_SOC`,`BOO_EST_ASS`,`BOO_EST_AFF`,`LIB_PER_CON`,`LIB_NUM_TEL_PER_CON`,`COD_ASS`,`DAT_ENREG`,`BOO_EST_ARCH`,`LIB_MED`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`,`LIB_ASS`,`LIB_SOC`) VALUES 
 ('2014000001','05S024','ING','NANFACK ','Beauclair','2003','20101117000000000000','M','Douala-Bepanda','77010470','Developpeur','Devellopeur sénior','OCI','1','1','Mme Cristine','5847965','AXA','20140811000000000000',NULL,'0','2000','2014','1','admin','admin','20140811132159000704','20140811134630000894',NULL,NULL),
 ('2014000002','05S025','Network ','Ngouana','Brice','2000','20110914000000000000','M','RAS','95 87 25 69','IOS system','Admin','ERICSON','1','1','Mr soufo','589664','ACTIVA','20140811000000000000',NULL,'Mr House','2000','2014','1','admin','admin','20140811140343000363','20140813192547000587','Activa assurance et reassurance',NULL),
 ('2014000003','MT4145','trh','moihth','htrh','2002','20140814000000000000','F','8686','5686','sgg','sgf','MEGATIM','1','1','gsrhgh','868','ACTIVA','20140811000000000000',NULL,'sgg','2000','2014','1','admin',NULL,'20140811213038000556',NULL,'Activa assurance et reassurance','Mega tim work');
/*!40000 ALTER TABLE `tab_pat` ENABLE KEYS */;


--
-- Definition of table `tab_rdv`
--

DROP TABLE IF EXISTS `tab_rdv`;
CREATE TABLE `tab_rdv` (
  `COD_RDV` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `COD_TYP_RDV` varchar(32) DEFAULT NULL,
  `LIB_TYP_RDV` varchar(255) DEFAULT NULL,
  `COD_SVC` varchar(32) DEFAULT NULL,
  `LIB_SVC` varchar(255) DEFAULT NULL,
  `DAT_DEM` varchar(32) DEFAULT NULL,
  `DAT_RDV` varchar(32) DEFAULT NULL,
  `VAL_NUM_ORDRE` decimal(20,0) DEFAULT NULL,
  `LIB_OBS` varchar(255) DEFAULT NULL,
  `BOO_EST_ANN` decimal(1,0) DEFAULT '0',
  `BOO_EST_CONF` decimal(1,0) DEFAULT '0',
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_rdv`
--

/*!40000 ALTER TABLE `tab_rdv` DISABLE KEYS */;
INSERT INTO `tab_rdv` (`COD_RDV`,`COD_PAT`,`COD_USR`,`COD_TYP_RDV`,`LIB_TYP_RDV`,`COD_SVC`,`LIB_SVC`,`DAT_DEM`,`DAT_RDV`,`VAL_NUM_ORDRE`,`LIB_OBS`,`BOO_EST_ANN`,`BOO_EST_CONF`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('2014000001','2014000001','house','CONS_10','Consultation','D_G','Direction générale','20140815000000000000','20140830143000000000','1','RAS','1','1','2007','2014','1','admin','admin','20140815110754000252','20140815115739000320'),
 ('2014000002','2014000002','house','HOSTI_11','Hospitalisation','CHIR_DENT','Chirugie dentaire','20140815000000000000','20141106120000000000','2','RAS',NULL,NULL,'2000','2014','1','admin',NULL,'20140815115858000664',NULL),
 ('2014000003','2014000001','house','HOSTI_11','Hospitalisation','CHIR_DENT','Chirugie dentaire','20140807000000000000','20140816120000000000','5','RAS',NULL,NULL,'2000','2014','1','admin',NULL,'20140815201146000855',NULL),
 ('2014000004','2014000002','house','HOSTI_11','Hospitalisation','CHIR_DENT','Chirugie dentaire','20140808000000000000','20140810120000000000','45','ZAS',NULL,'1','2008','2014','1','admin','admin','20140815202447000249','20140815202454000438');
/*!40000 ALTER TABLE `tab_rdv` ENABLE KEYS */;


--
-- Definition of table `tab_rol`
--

DROP TABLE IF EXISTS `tab_rol`;
CREATE TABLE `tab_rol` (
  `COD_ROL` varchar(32) NOT NULL DEFAULT '',
  `LIB_ROL` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_ROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_rol`
--

/*!40000 ALTER TABLE `tab_rol` DISABLE KEYS */;
INSERT INTO `tab_rol` (`COD_ROL`,`LIB_ROL`,`LIB_DESC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('MED_CHEF','Medecin chef','ras ras ras','2000','2014','1','admin',NULL,'20140808185604000204',NULL);
/*!40000 ALTER TABLE `tab_rol` ENABLE KEYS */;


--
-- Definition of table `tab_soc`
--

DROP TABLE IF EXISTS `tab_soc`;
CREATE TABLE `tab_soc` (
  `COD_SOC` varchar(32) NOT NULL DEFAULT '',
  `LIB_SOC` varchar(255) DEFAULT NULL,
  `LIB_RESP` varchar(255) DEFAULT NULL,
  `LIB_BP` varchar(32) DEFAULT NULL,
  `LIB_VIL` varchar(32) DEFAULT NULL,
  `LIB_TEL` varchar(32) DEFAULT NULL,
  `LIB_NUM_CONTRIB` varchar(32) DEFAULT NULL,
  `LIB_SIEGE` varchar(255) DEFAULT NULL,
  `LIB_ADR_COM` varchar(32) DEFAULT NULL,
  `BOO_EST_AFF` decimal(1,0) DEFAULT '0',
  `DAT_AFF` varchar(32) DEFAULT NULL,
  `VAL_EFF` decimal(20,2) DEFAULT NULL,
  `VAL_PRI_UNI` decimal(20,2) DEFAULT NULL,
  `DAT_CRE` varchar(32) DEFAULT NULL,
  `LIB_MAIL` varchar(32) DEFAULT NULL,
  `LIB_FAX` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_SOC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_soc`
--

/*!40000 ALTER TABLE `tab_soc` DISABLE KEYS */;
INSERT INTO `tab_soc` (`COD_SOC`,`LIB_SOC`,`LIB_RESP`,`LIB_BP`,`LIB_VIL`,`LIB_TEL`,`LIB_NUM_CONTRIB`,`LIB_SIEGE`,`LIB_ADR_COM`,`BOO_EST_AFF`,`DAT_AFF`,`VAL_EFF`,`VAL_PRI_UNI`,`DAT_CRE`,`LIB_MAIL`,`LIB_FAX`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('CITECH','Communication and Information Technology','Zakiatou','3360','Douala','77 01 04 70','M2001015487965','Bonapriso','Rue njo-njo immeuble carrée d\'or','1','20110317000000000000','30.00','15000.00','20090617000000000000',NULL,NULL,'2000','2014','1','admin',NULL,'20140810215336000886',NULL),
 ('ERICSON','Sony and Eric sono','Mr Jean boss','5896','Douala','58 665 ','M57855','Bonadjo','RAS','1','20130815000000000000','254.00','96200.00','20071010000000000000',NULL,NULL,'2000','2014','1','admin',NULL,'20140811135711000229',NULL),
 ('MEGATIM','Mega tim work','ALain','89652','Yaoundé','22 36 58 94','M2015000014578','Poste centrale','RAS','0','20140810000000000000','89.00','25000.00','20110511000000000000',NULL,NULL,'2000','2014','1','admin',NULL,'20140810215926000595',NULL),
 ('OCI','Office congolais d\'informatique','Tanguy','8544','BZV','7894512266','HJ1245789330','Mpilla','RAS','0',NULL,'59.00','89522.00','19930615000000000000',NULL,NULL,'2000','2014','1','admin','admin','20140810222851000113','20140811115134000463');
/*!40000 ALTER TABLE `tab_soc` ENABLE KEYS */;


--
-- Definition of table `tab_spec`
--

DROP TABLE IF EXISTS `tab_spec`;
CREATE TABLE `tab_spec` (
  `COD_SPEC` varchar(32) NOT NULL DEFAULT '',
  `LIB_SPEC` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_SPEC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_spec`
--

/*!40000 ALTER TABLE `tab_spec` DISABLE KEYS */;
INSERT INTO `tab_spec` (`COD_SPEC`,`LIB_SPEC`,`LIB_DESC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('SPEC_A','Spécialité n°1','RAS','2000','2014','1','admin',NULL,'20140813130821000635',NULL),
 ('SPEC_B','Spécialité n°2','RAS','2000','2014','1','admin',NULL,'20140813131108000920',NULL);
/*!40000 ALTER TABLE `tab_spec` ENABLE KEYS */;


--
-- Definition of table `tab_svc`
--

DROP TABLE IF EXISTS `tab_svc`;
CREATE TABLE `tab_svc` (
  `COD_SVC` varchar(32) NOT NULL DEFAULT '',
  `LIB_SVC` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `COD_SVC_PAR` varchar(32) DEFAULT NULL,
  `LIB_SVC_PAR` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_SVC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_svc`
--

/*!40000 ALTER TABLE `tab_svc` DISABLE KEYS */;
INSERT INTO `tab_svc` (`COD_SVC`,`LIB_SVC`,`LIB_DESC`,`COD_SVC_PAR`,`LIB_SVC_PAR`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('CHIR_DENT','Chirugie dentaire','bla bla bla','D_G','Direction générale','2000','2014','1','admin','admin','20140808184646000958','20140809123244000822'),
 ('D_G','Direction générale','RAS','PED','Pédiatrie','2000','2014','1','admin','admin','20140808190806000022','20140809123201000837'),
 ('PED','Pédiatrie','RAS','CHIR_DENT',NULL,'2000','2014','1','admin',NULL,'20140808190837000342',NULL);
/*!40000 ALTER TABLE `tab_svc` ENABLE KEYS */;


--
-- Definition of table `tab_typ_exam`
--

DROP TABLE IF EXISTS `tab_typ_exam`;
CREATE TABLE `tab_typ_exam` (
  `COD_TYP_EXAM` varchar(32) NOT NULL DEFAULT '',
  `LIB_TYP_EXAM` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `COD_CAT_EXAM` varchar(32) DEFAULT NULL,
  `LIB_CAT_EXAM` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_EXAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_typ_exam`
--

/*!40000 ALTER TABLE `tab_typ_exam` DISABLE KEYS */;
INSERT INTO `tab_typ_exam` (`COD_TYP_EXAM`,`LIB_TYP_EXAM`,`LIB_DESC`,`COD_CAT_EXAM`,`LIB_CAT_EXAM`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('ELECTRO_FOR','Electrophorese','RAS','CAR_LOG','Cardiologie','2000','2014','1','admin',NULL,'20140812200719000589',NULL),
 ('TYP_EXAM_1','Type Examen n°1','RAS','CAT_A','Categorie n°1','2000','2014','1','admin',NULL,'20140813133034000029',NULL),
 ('TYP_EXAM_2','Type Exam n°2','Exam spécialisé pour visas','CAT_B','Categorie n°2','2000','2014','1','admin',NULL,'20140813133232000620',NULL),
 ('VIH','SIDA','Examen pour contrôle la sérologie du patient','VIR','Virale','2000','2014','1','admin','admin','20140812195837000157','20140812200623000413');
/*!40000 ALTER TABLE `tab_typ_exam` ENABLE KEYS */;


--
-- Definition of table `tab_typ_rdv`
--

DROP TABLE IF EXISTS `tab_typ_rdv`;
CREATE TABLE `tab_typ_rdv` (
  `COD_TYP_RDV` varchar(32) NOT NULL DEFAULT '',
  `LIB_TYP_RDV` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_typ_rdv`
--

/*!40000 ALTER TABLE `tab_typ_rdv` DISABLE KEYS */;
INSERT INTO `tab_typ_rdv` (`COD_TYP_RDV`,`LIB_TYP_RDV`,`LIB_DESC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('CONS_10','Consultation','RDV pour les consultations','2000','2014','1','admin',NULL,'20140813172604000965',NULL),
 ('HOSTI_11','Hospitalisation','Rendez-vous pour hospitalisation','2000','2014','1','admin',NULL,'20140813172859000658',NULL);
/*!40000 ALTER TABLE `tab_typ_rdv` ENABLE KEYS */;


--
-- Definition of table `tab_typ_soin`
--

DROP TABLE IF EXISTS `tab_typ_soin`;
CREATE TABLE `tab_typ_soin` (
  `COD_TYP_SOIN` varchar(32) NOT NULL DEFAULT '',
  `LIB_TYP_SOIN` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_SOIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_typ_soin`
--

/*!40000 ALTER TABLE `tab_typ_soin` DISABLE KEYS */;
INSERT INTO `tab_typ_soin` (`COD_TYP_SOIN`,`LIB_TYP_SOIN`,`LIB_DESC`,`ETAT_ENT`,`COD_EXE_FIS`,`BOO_ACT`,`COD_USR_CRT`,`COD_USR_MOD`,`DAT_CRT`,`DAT_MOD`) VALUES 
 ('SOIN_A','Soin n°1','RAS','2000','2014','1','admin',NULL,'20140813130938000245',NULL),
 ('SOIN_B','Soin n°2','RAS','2000','2014','1','admin',NULL,'20140813131008000102',NULL);
/*!40000 ALTER TABLE `tab_typ_soin` ENABLE KEYS */;


--
-- Definition of table `tab_usr`
--

DROP TABLE IF EXISTS `tab_usr`;
CREATE TABLE `tab_usr` (
  `COD_USR` varchar(255) NOT NULL DEFAULT '',
  `BOO_ACT` decimal(19,2) DEFAULT NULL,
  `COD_EXE_FIS` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(255) DEFAULT NULL,
  `BOO_SEX` varchar(255) DEFAULT NULL,
  `COD_PWD` varchar(255) DEFAULT NULL,
  `DAT_EMBCH` varchar(255) DEFAULT NULL,
  `DAT_EXP_PWD` varchar(255) DEFAULT NULL,
  `LIB_ADR` varchar(255) DEFAULT NULL,
  `LIB_FON` varchar(255) DEFAULT NULL,
  `LIB_NOM` varchar(255) DEFAULT NULL,
  `LIB_PRE` varchar(255) DEFAULT NULL,
  `COD_SVC` varchar(255) DEFAULT NULL,
  `LIB_SVC` varchar(255) DEFAULT NULL,
  `COD_ROL` varchar(255) DEFAULT NULL,
  `LIB_ROL` varchar(255) DEFAULT NULL,
  `DAT_MOD` varchar(255) DEFAULT NULL,
  `DAT_CRT` varchar(255) DEFAULT NULL,
  `COD_USR_MOD` varchar(255) DEFAULT NULL,
  `COD_USR_CRT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COD_USR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tab_usr`
--

/*!40000 ALTER TABLE `tab_usr` DISABLE KEYS */;
INSERT INTO `tab_usr` (`COD_USR`,`BOO_ACT`,`COD_EXE_FIS`,`ETAT_ENT`,`BOO_SEX`,`COD_PWD`,`DAT_EMBCH`,`DAT_EXP_PWD`,`LIB_ADR`,`LIB_FON`,`LIB_NOM`,`LIB_PRE`,`COD_SVC`,`LIB_SVC`,`COD_ROL`,`LIB_ROL`,`DAT_MOD`,`DAT_CRT`,`COD_USR_MOD`,`COD_USR_CRT`) VALUES 
 ('admin','0.00','2014','2000','M','sysgeho','20111221000000000000','20141221000000000000','20141221000000000000','RH','Beauclair','MEGO','ADMIN','Administrateur SI','INF','Informaticien','20141221000000000000','20141221000000000000',NULL,NULL),
 ('house','1.00','2014','2000','M','house','20090805000000000000','20160825000000000000','Douala-bonandjo 75 85 89 63','Généraliste','Dr House','Blanchard','PED','Pédiatrie','MED_CHEF','Medecin chef',NULL,'20140815110312000436',NULL,'admin');
/*!40000 ALTER TABLE `tab_usr` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
