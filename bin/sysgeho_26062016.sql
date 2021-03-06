-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 26 Juin 2016 à 01:50
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `sysgeho`
--

-- --------------------------------------------------------

--
-- Structure de la table `tab_ass`
--

CREATE TABLE IF NOT EXISTS `tab_ass` (
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
-- Contenu de la table `tab_ass`
--

INSERT INTO `tab_ass` (`COD_ASS`, `LIB_ASS`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('ACTIVA', 'Activa assurance et reassurance', NULL, '2000', '2014', '1', 'admin', NULL, '20140811115338000770', NULL),
('ALLIANZ', 'ALLIANZ Assurances', NULL, '2000', '2015', '1', 'admin', NULL, '20150810160646000514', NULL),
('ASCOMA', 'ASCOMA Assurances', NULL, '2000', '2015', '1', 'admin', NULL, '20150810160842000916', NULL),
('AXA', 'AXA Assurance Cameroun ', NULL, '2000', '2014', '1', 'admin', NULL, '20140810224220000627', NULL),
('BENEFICIAL', 'BENEFICIAL Insurance', NULL, '2000', '2015', '1', 'admin', NULL, '20150810161301000121', NULL),
('CHANAS', 'CHANAS Assurances', NULL, '2000', '2015', '1', 'admin', NULL, '20150810161212000021', NULL),
('GRASSAVOYE', 'GRAS SAVOYE Assurances', NULL, '2000', '2015', '1', 'admin', NULL, '20150810161038000292', NULL),
('SAAR', 'SAAR Assurances', NULL, '2000', '2014', '1', 'admin', NULL, '20141014124843000265', NULL),
('SAHAM', 'SAHAM Assurances', NULL, '2000', '2015', '1', 'admin', NULL, '20150810160710000019', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_cat_exam`
--

CREATE TABLE IF NOT EXISTS `tab_cat_exam` (
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
-- Contenu de la table `tab_cat_exam`
--

INSERT INTO `tab_cat_exam` (`COD_CAT_EXAM`, `LIB_CAT_EXAM`, `LIB_SPEC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `COD_SPEC`) VALUES
('BACTO', 'BACTERIOLOGIE', NULL, '2000', '2015', '1', 'admin', NULL, '20150814215049000538', NULL, 'SPEC_A'),
('CAT1', 'HEMATHOLOGIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20140922055707000945', 'SPEC_A'),
('CAT2', 'PARASITOLOGIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20140922055825000524', 'SPEC_A'),
('CAT3', 'SEROLOGIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20140922055914000737', 'SPEC_A'),
('CAT4', 'BIOCHIMIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20140922060335000442', 'SPEC_A'),
('CAT5', 'RADIOLOGIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20140922060052000668', 'SPEC_B'),
('HEMA', 'HEMATHOLOGIE', NULL, '2000', '2014', '1', 'admin', 'admin', '20140812195206000927', '20150814215145000692', 'SPEC_A'),
('WI', 'WIDAL', NULL, '2000', '2015', '1', 'kviviane', NULL, '20150915105008000752', NULL, 'S11');

-- --------------------------------------------------------

--
-- Structure de la table `tab_cert_med`
--

CREATE TABLE IF NOT EXISTS `tab_cert_med` (
  `COD_CERT_MED` varchar(32) NOT NULL DEFAULT '',
  `REF_CERT_MED` varchar(32) NOT NULL DEFAULT '',
  `COD_SOC` varchar(32) DEFAULT NULL,
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `VAL_AGE` decimal(10,0) DEFAULT NULL,
  `DAT_CERT` varchar(32) DEFAULT NULL,
  `ENU_CAT_CERT` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `LIB_NOM_PAT` varchar(254) DEFAULT NULL,
  `LIB_NOM_MED` varchar(254) DEFAULT NULL,
  `LIB_SOC` varchar(254) DEFAULT NULL,
  `LIB_POST` varchar(254) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COD_CERT_MED`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_cert_med`
--

INSERT INTO `tab_cert_med` (`COD_CERT_MED`, `REF_CERT_MED`, `COD_SOC`, `COD_PAT`, `COD_USR`, `COD_VIS_MED_EMB`, `COD_VIS_MED_PERIO`, `VAL_AGE`, `DAT_CERT`, `ENU_CAT_CERT`, `BOO_VAL`, `LIB_NOM_PAT`, `LIB_NOM_MED`, `LIB_SOC`, `LIB_POST`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `TYP_VIS_MED_SRC`) VALUES
('2016000002', '888888', NULL, '20160071', 'kjoseph', NULL, NULL, NULL, '20160416000000000000', NULL, '0', NULL, NULL, NULL, NULL, '2000', '2016', '1', 'admin', 'admin', '20160416212147000196', '20160418090820000122', 'VM_PERIO'),
('2016000003', '2015/552/77', NULL, '20160641', 'kjoseph', '2015000006', NULL, '25', '20160417000000000000', NULL, '0', NULL, NULL, NULL, NULL, '2000', '2016', '1', 'admin', 'admin', '20160416214805000866', '20160505085627000711', 'VM_EMB'),
('2016000004', '2015/04/GDD22', NULL, '20150023', 'kjoseph', '2015000008', NULL, '23', '20160505000000000000', NULL, '0', 'ESSIMA ABEGA ', 'Dr KAPTUE  Joseph Sylvere', NULL, NULL, '2000', '2016', '1', 'admin', NULL, '20160505134724000099', NULL, 'VM_EMB');

-- --------------------------------------------------------

--
-- Structure de la table `tab_chr_hospi`
--

CREATE TABLE IF NOT EXISTS `tab_chr_hospi` (
  `NUM_CHR_HOSPI` varchar(32) NOT NULL DEFAULT '',
  `LIB_CHR_HOSPI` varchar(254) DEFAULT NULL,
  `VAL_NBR_LIT` decimal(20,0) DEFAULT NULL,
  `LIB_NOM_RESPO` varchar(254) DEFAULT NULL,
  `LIB_OBS` varchar(1024) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`NUM_CHR_HOSPI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_chr_hospi`
--

INSERT INTO `tab_chr_hospi` (`NUM_CHR_HOSPI`, `LIB_CHR_HOSPI`, `VAL_NBR_LIT`, `LIB_NOM_RESPO`, `LIB_OBS`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('101', 'Chambre 101', '2', '', '', '2000', '2014', '1', 'admin', NULL, '20140924233344000969', NULL),
('102', 'Chambre 102', '2', '', '', '2000', '2014', '1', 'admin', NULL, '20141014125147000290', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_consul`
--

CREATE TABLE IF NOT EXISTS `tab_consul` (
  `COD_CONSUL` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) NOT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `COD_SPEC` varchar(32) DEFAULT 'S00',
  `VAL_POIDS` varchar(32) DEFAULT NULL,
  `VAL_TENSION` varchar(10) DEFAULT NULL,
  `VAL_POU` varchar(10) DEFAULT NULL,
  `VAL_TAILLE` varchar(10) DEFAULT NULL,
  `DAT_CONSUL` varchar(32) DEFAULT NULL,
  `LIB_STATUT` varchar(255) DEFAULT NULL,
  `VAL_MNT_TTC` decimal(20,0) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `BOO_CPTE_RENDU` decimal(1,0) DEFAULT '0',
  `BOO_PAIE` decimal(1,0) DEFAULT NULL,
  `REF_FAC` varchar(32) DEFAULT NULL,
  `ENU_MOD_PCHG` varchar(30) DEFAULT NULL,
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(10) DEFAULT NULL,
  `VAL_TMP` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`COD_CONSUL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_consul`
--

INSERT INTO `tab_consul` (`COD_CONSUL`, `COD_PAT`, `COD_USR`, `COD_SPEC`, `VAL_POIDS`, `VAL_TENSION`, `VAL_POU`, `VAL_TAILLE`, `DAT_CONSUL`, `LIB_STATUT`, `VAL_MNT_TTC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_VAL`, `BOO_CPTE_RENDU`, `BOO_PAIE`, `REF_FAC`, `ENU_MOD_PCHG`, `COD_VIS_MED_EMB`, `COD_VIS_MED_PERIO`, `TYP_VIS_MED_SRC`, `VAL_TMP`) VALUES
('2015000011', '20150014', 'fpatrick', 'S8', '', '', '', '', NULL, '', '0', '2000', '2015', '1', 'fpatrick', NULL, '20150914143715000393', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', NULL),
('2015000012', '20150018', 'cepenza', 'S00', '75kg', '14/8', '91', '', '20150914000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150914150941000492', '20150914152346000981', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000015', '20150011', 'cepenza', 'S00', '75kg', '11/5', '76', '', '20150914000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150914154205000109', '20150914155146000293', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000016', '20150021', 'fpatrick', 'S00', '80kg', '138/84', '86', '', '20150914000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150914154323000783', '20150914154953000304', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000018', '20150014', 'fpatrick', 'S00', '59kg', '13/8', '73', '', '20150914000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150914155834000241', '20150914161200000309', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000019', '20150019', 'fpatrick', 'S00', '62', '14/7', '71', '', NULL, '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150914163453000198', '20150914164507000203', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000020', '20150024', 'fpatrick', 'S00', '', '133/70', '67', '', NULL, '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915080932000857', '20150915080941000702', '1', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', NULL),
('2015000021', '20150025', 'cepenza', 'SPEC_3', '75kg', '134/75mmHg', '67bpm', '', '20150915000000000000', '', '0', '2000', '2015', '1', 'fewane', 'fewane', '20150915081502000626', '20150915082924000220', '0', '1', '0', NULL, '', '2015000009', NULL, 'VM_EMB', NULL),
('2015000022', '20150024', 'fpatrick', 'S00', '', '133/70', '67', '', '20150915000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915081513000093', '20150915081726000277', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', NULL),
('2015000025', '20150026', 'fpatrick', 'S00', '94kg', '132/69', '92', '', NULL, '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915083048000803', '20150915085113000126', '1', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2015000026', '20150029', 'fpatrick', 'S00', '75kg', '124/78', '77', '1.78', NULL, '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915110717000981', '20150915111011000765', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', NULL),
('2015000028', '20150037', NULL, NULL, '87kg', '140/88', '89', '', '20150921000000000000', '', '0', '2000', '2015', '1', 'fpatrick', NULL, '20150921075813000990', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', '37,8c'),
('2015000029', '20150037', 'fpatrick', NULL, '87kg', '140/88', '87', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921081727000409', '20150921084346000276', '1', '1', '0', NULL, '', NULL, NULL, '', '37,8c'),
('2015000030', '20150039', 'fpatrick', NULL, '55kg', '114/63', '86', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921094100000183', '20150921095045000183', '1', '1', '0', NULL, '', NULL, NULL, '', '37.6c'),
('2015000031', '20150040', 'fpatrick', NULL, '88kg', '154/87', '72', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921101148000537', '20150921101626000508', '1', '1', '0', NULL, '', NULL, NULL, '', '37.4c'),
('2015000032', '20150041', 'cepenza', NULL, '103kg', '114/64mmHg', '84bpm', '', '20150921000000000000', '', '0', '2000', '2015', '1', 'fewane', 'fewane', '20150921104301000173', '20150921104735000671', '0', '1', '0', NULL, '', NULL, NULL, '', '37.1'),
('2015000033', '20150035', 'cepenza', 'S00', '', '', '', '', '20150917000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150921105031000466', '20150921110537000374', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2015000034', '20150042', 'fpatrick', NULL, '80KG', '135/74', '63', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921111812000039', '20150921112653000315', '1', '1', '0', NULL, '', NULL, NULL, '', '37.é'),
('2015000035', '20150043', 'fpatrick', NULL, '58kg', '114/66', '79', '', NULL, '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921113724000171', '20150921113737000749', '1', '0', '0', NULL, '', NULL, NULL, '', '36.2c'),
('2015000036', '20150043', 'fpatrick', NULL, '58kg', '114/66', '79', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921124859000567', '20150921125353000248', '1', '1', '0', NULL, '', NULL, NULL, '', '36.2c'),
('2015000037', '20150044', 'fpatrick', NULL, '71 kg', '125/60', '82', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921150343000992', '20150921151306000546', '1', '1', '0', NULL, '', NULL, NULL, '', '37.5c'),
('2015000038', '20150018', 'fpatrick', NULL, '79kg', '125/70', '82', '', '20150921000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921153812000846', '20150921154430000096', '1', '1', '0', NULL, '', NULL, NULL, '', '38c'),
('2015000039', '20150046', 'cepenza', NULL, '65kg', '130/72', '92bpm', '', '20150921000000000000', '', '0', '2000', '2015', '1', 'fewane', NULL, '20150922083457000660', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', '36.5'),
('2015000040', '20150047', 'fpatrick', NULL, '67kg', '126/69', '54', '1.62m', '20150922000000000000', '', '0', '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150922084441000975', '20150922084620000630', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2015000041', '20150046', 'cepenza', 'S00', '65kg', '130/72mmHg', '92bpm', '', NULL, '', '0', '2000', '2015', '1', 'fewane', 'fewane', '20150922084604000234', '20150922085000000980', '0', '1', '0', NULL, '', NULL, NULL, '', '36.5'),
('2015000042', '20150049', 'cepenza', 'S00', '59kg', '133/71mmHg', '88bpm', '', '20150922000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150922085552000044', '20150922085603000240', '1', '0', '0', NULL, '', NULL, NULL, '', '37.8'),
('2015000043', '20150049', 'cepenza', NULL, '59kg', '133/71mmHg', '88bpm', '', '20150922000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150922091846000468', '20150922093822000342', '1', '1', '0', NULL, '', NULL, NULL, '', '37.8'),
('2015000044', '20150051', 'cepenza', 'S00', '89kg', '119/73mmHg', '69bpm', '', '20150922000000000000', '', '0', '2002', '2015', '1', 'fewane', 'fewane', '20150922113142000974', '20150922115747000718', '1', '1', '0', NULL, '', NULL, NULL, '', '37.3'),
('2016000003', '20160010', NULL, NULL, '70kg', '13:8', '85', '', NULL, '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104141055000304', '20160104141104000040', '1', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', '37.2'),
('2016000004', '20160007', 'cepenza', 'S00', '64', '108/61', '61', '', '20160104000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160104143718000772', '20160104145204000278', '1', '1', '0', NULL, '', NULL, NULL, '', '38.5'),
('2016000005', '20160009', 'cepenza', 'S00', '59kg', '135/77mmHg', '55bpm', '', '20160104000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160104150407000237', '20160104150941000694', '1', '1', '0', NULL, '', NULL, NULL, '', '36,8'),
('2016000006', '20160013', 'cepenza', 'S00', '71kg', '140/68', '74bpm', '1,68m', '20160104000000000000', '', '0', '2000', '2016', '1', 'fewane', NULL, '20160104152455000098', NULL, '0', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000007', '20160013', 'cepenza', 'S00', '71kg', '140/68', '74bpm', '1,68m', '20160104000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160104152507000625', '20160104152809000204', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000008', '20160008', 'fpatrick', NULL, '102kg', '122/85mmhg', '76pls', '', '20160104000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104153237000015', '20160104153813000876', '1', '1', '0', NULL, '2000', NULL, NULL, '', '36.2c'),
('2016000009', '20160006', 'fpatrick', NULL, '88kg', '138/78mmhg', '82pls', '', '20160104000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104154544000250', '20160104155646000151', '1', '1', '0', NULL, '2000', NULL, NULL, '', '37.8c'),
('2016000010', '20160016', 'fpatrick', NULL, '', '', '', '', NULL, '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104160205000881', '20160104160445000361', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000011', '20160015', 'cepenza', 'S00', '93kg', '142/75mmHg', '79bpm', '1,62m', '20160104000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160104161055000681', '20160104162409000129', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000012', '20160016', 'fpatrick', NULL, '', '', '', '', NULL, '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104161418000826', '20160104161555000346', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000013', '20160018', 'fpatrick', NULL, '85kgs', '147/81mmhg', '97pls/min', '', NULL, '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105083810000869', '20160105084302000440', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9c'),
('2016000014', '20160019', 'fpatrick', NULL, '77kg', '125/75mmhg', '83pls/min', '1.78m', NULL, '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105090014000884', '20160105091021000598', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000015', '20160020', 'cepenza', 'S00', '78kg', '152/90mmHg', '66', '1.80', '20160105000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160105091112000032', '20160105091653000897', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000016', '20160021', 'fpatrick', NULL, '87kg', '107/60mmhg', '78pls/min', '1.66m', '20160105000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105091450000775', '20160105092815000583', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000017', '20160022', 'cepenza', NULL, '75Kg', '131/71mmHg', '54bpm', '1.72m', '20160105000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160105091935000870', '20160105094228000346', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000018', '20160023', 'cepenza', 'S00', '88kg', '133/87', '57bpm', '1.77m', '20160105000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160105094503000863', '20160105095751000192', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000019', '20160024', 'fpatrick', NULL, '95kg', '103/75', '93pls/min', '', '20160105000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105100138000611', '20160105101816000685', '1', '1', '0', NULL, '', NULL, NULL, '', '36.5'),
('2016000020', '20160025', 'fpatrick', NULL, '65kg', '123/67mmhg', '78pls/miin', '', '20160105000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105111720000875', '20160105112857000657', '1', '1', '0', NULL, '', NULL, NULL, '', '37.6c'),
('2016000021', '20160026', 'fpatrick', NULL, '85kgs', '127/67mmhg', '88pls/min', '1.72m', '20160105000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105140515000169', '20160105140943000301', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000022', '20160027', 'fpatrick', NULL, '99kg', '218/140', '93pls/min', '1.76m', '20160106000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106094025000039', '20160106095151000173', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000023', '20160029', 'fpatrick', NULL, '93kg', '121/69mmhg', '70pls/min', ':', '20160106000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106100806000051', '20160106101419000982', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000024', '20160028', 'fpatrick', NULL, '72kg', '135/72mmhg', '91pls/min', '', '20160106000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106101651000487', '20160106102542000342', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000025', '20160032', 'fpatrick', NULL, '125kg', '124/80mmhg', '69pls/min', '1.78m', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107084245000851', '20160107085519000857', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000026', '20160033', 'fpatrick', NULL, '86kg', '108/60mmhg', '70pls/min', '1.80m', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107085832000440', '20160107090823000554', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000027', '20160034', 'fpatrick', NULL, '77kg', '124/75mmhg', '69pls/min', '1.74m', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107091221000840', '20160107093559000057', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000028', '20160036', 'fpatrick', NULL, '60kg', '106/53mmhg', '66pls/min', ':1.60m', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107101655000123', '20160107102355000178', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000029', '20160037', 'fpatrick', NULL, '81kg', '128/76mmhg', '74pls/min', '36.5c', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107102822000563', '20160107104323000750', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000030', '20160038', 'fpatrick', NULL, '60kg', '1.69m', '84pls/min', '1.69m', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107104611000686', '20160107105704000620', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000031', '20160039', 'fpatrick', NULL, '81kg', '128/76mmhg', '74pls/min', '36.5c', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107110422000145', '20160107111049000577', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000032', '20160040', 'fpatrick', NULL, '77kg', '106/59mmhg', '77pls/min', '', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107111540000746', '20160107113656000019', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000033', '20160041', 'fpatrick', NULL, '74kg', '107/59mmhg', '97pls/min', '', '20160107000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107145837000443', '20160107150609000795', '1', '1', '0', NULL, '', NULL, NULL, '', '36.3c'),
('2016000034', '20160042', NULL, NULL, '86kg', '116/78mmhg', '69pls/min', '1.56m', '20160108000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108081406000571', '20160108082341000308', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000035', '20160044', 'cepenza', 'S00', '80kg', '130/53mmHg', '65bpm', '1.75m', '20160108000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160108082703000792', '20160108083221000795', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000036', '20160043', 'fpatrick', NULL, '121kg', '146/92mmhg', '69pls/min', '1.73m', '20160108000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108083249000719', '20160108084759000535', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000037', '20160045', 'fpatrick', NULL, '74kg', '109/64mmhg', '64pls/min', '1.69m', '20160108000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108085056000754', '20160108085703000399', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000038', '20160046', 'fpatrick', NULL, '89kg', '152/95mmhg', '66pls/min', '', '20160108000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108094326000393', '20160108094330000830', '1', '0', '0', NULL, '', NULL, NULL, '', '37.2c'),
('2016000039', '20160048', 'fpatrick', NULL, '69kg', '99/59mmhg', '69pls/min', '', '20160108000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108103500000482', '20160108105724000227', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000040', '20160057', 'fpatrick', NULL, '68kg', '138/76mmhg', '63pls/min', '1.70m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111083122000089', '20160111084357000467', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000041', '20160058', 'fpatrick', NULL, '66kg', '136/80mmhg', '69pls/min', '1.67m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111085128000255', '20160111085835000327', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000042', '20160059', NULL, NULL, '96kg', '', '', '1.74m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160111090401000444', '20160111090721000474', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000043', '20160063', 'fpatrick', NULL, '70kg', '15/8cmhg', '52pls/min', '1.65m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111093101000842', '20160111093622000104', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000044', '20160061', 'cepenza', 'S00', '69kg', '116/59mmHg', '55bpm', '', '20160111000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160111093742000070', '20160111095624000712', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000045', '20160065', 'fpatrick', NULL, '60kg', '137/85mmhg', '81pls/min', '1.75m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111115933000872', '20160111120646000808', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000046', '20160066', 'cepenza', 'S00', '79kg', '143/81mmHg', '97bpm', '1.64m', '20160111000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160111132541000286', '20160111132939000015', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000047', '20160064', 'cepenza', 'S00', '84kg', '140/84mmHg', '93bpm', '', '20160111000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160111133219000781', '20160111133851000999', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000048', '20160070', NULL, NULL, '', '', '', '', NULL, '', '0', '2000', '2016', '1', 'fewane', NULL, '20160111162101000987', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', ''),
('2016000049', '20160069', 'fpatrick', NULL, '90pls/min', '129/68mmhg', '90pls/min', '', '20160111000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112082650000276', '20160112083242000120', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000050', '20160071', 'fpatrick', NULL, '71kg', '127/61mmhg', '71pls/min', '', '20160112000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112083430000056', '20160112084103000708', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9c'),
('2016000051', '20160074', 'fpatrick', NULL, '67kg', '113/69mmhg', '69pls/min', '', '20160112000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112105257000476', '20160112113236000601', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9'),
('2016000052', '20160075', 'cepenza', 'S00', '104kg', '136/79mmHg', '75bpm', '1.80m', '20160112000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160112115601000616', '20160112120751000527', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000053', '20160076', 'fpatrick', NULL, '102kg', '124/78mmhg', '62pls/min', '1.82m', '20160112000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112115835000654', '20160112120830000889', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000054', '20160077', 'fpatrick', NULL, '66kg', '123/68mmhg', '105pls/min', '1.68m', '20160112000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112150942000439', '20160112151921000058', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000055', '20160079', 'fpatrick', NULL, '75kg', '97/69cmhg', '80pls/min', '36.3C', '20160113000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113081329000606', '20160113081722000125', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000056', '20160080', 'fpatrick', NULL, '89kg', '127/77mmhg', '78pls/min', '1.63m', '20160113000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113084712000662', '20160113090721000239', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.6c'),
('2016000057', '20160081', 'fpatrick', NULL, '71kg', '132/70mmhg', '70pls/min', '', '20160113000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113091136000393', '20160113092006000774', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.6c'),
('2016000058', '20160082', 'fpatrick', NULL, '80kg', '95/57mmhg', '65pls/min', '1.65m', '20160113000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113100809000835', '20160113101723000637', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000059', '20160083', 'fpatrick', NULL, '66kg', '130/79mmhg', '69pls/min', '36.1c', '20160113000000000000', '', '0', '2000', '2016', '1', 'fpatrick', NULL, '20160113104353000470', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', ''),
('2016000060', '20160083', 'fpatrick', NULL, '66kg', '130/79mmhg', '69pls/min', '', '20160113000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113104632000700', '20160113105642000461', '1', '1', '0', NULL, '', NULL, NULL, '', '36.1c'),
('2016000061', '20160084', 'cepenza', 'S00', '80kg', '126/64mmHg', '63bpm', '', '20160113000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160113141546000901', '20160113142114000771', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000062', '20160087', 'fpatrick', NULL, '84kg', '132/66mmhg', '66pls/min', '', '20160114000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160114100219000696', '20160114103150000122', '1', '1', '0', NULL, '', NULL, NULL, '', '36.8c'),
('2016000063', '20160088', 'fpatrick', NULL, '72kg', '131/61mmhg', '86pls/min', '', '20160114000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160114140308000723', '20160114141140000419', '1', '1', '0', NULL, '', NULL, NULL, '', '37c'),
('2016000064', '20160092', 'fpatrick', NULL, '93kg', '93/59cmhg', '79pls/min', '', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115081037000086', '20160115082155000261', '1', '1', '0', NULL, '', NULL, NULL, '', '36.2c'),
('2016000065', '20160094', 'fpatrick', NULL, '69kg', '12169/mmhg', '62PLS/min', '', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115090407000916', '20160115091215000667', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.4c'),
('2016000066', '20160095', 'fpatrick', NULL, '75kg', '132/59mmhg', '66pls/min', '1.65m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115091632000070', '20160115092314000384', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000067', '20160097', 'fpatrick', NULL, '70kg', '116/77mmhg', '75pl/min', '1.68m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115162301000667', '20160115162800000198', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000068', '20160100', 'fpatrick', NULL, '72kg', '133/71mmhg', '80pls/min', '1.76m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115163316000956', '20160115164146000938', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000069', '20160101', 'fpatrick', NULL, '65kg', '14781MMHG', '95PLS:MIN', '1.69m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115164340000664', '20160115164820000937', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000070', '20160099', 'fpatrick', NULL, '66kg', '163/68mmhg', '92pls/min', '1.62m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115165555000819', '20160115165855000895', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000071', '20160098', 'fpatrick', NULL, '68kg', '113/68mmhg', '65pls/min', '1.86m', '20160115000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115170410000406', '20160115170615000488', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000072', '20160106', 'fpatrick', NULL, '73kg', '14/7cmhg', '112pls/min', '', '20160118000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118110408000877', '20160118112345000737', '1', '1', '0', NULL, '', NULL, NULL, '', '37.7c'),
('2016000073', '20160108', 'fpatrick', NULL, '107kg', '114/54mmhg', '63pls/min', '1.82', '20160118000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118112836000752', '20160118113602000094', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000074', '20160112', 'cepenza', 'S00', '96kg', '139/67mmhg', '73bpm', '', '20160118000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160118134219000987', '20160118135932000424', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9'),
('2016000075', '20160113', 'fpatrick', NULL, '80kg', '112/58mmhg', '74pls/min', '1.68m', '20160118000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118134321000873', '20160118134702000833', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000076', '20160114', 'fpatrick', NULL, '64Kg', '113/67mmhg', '82pls/min', '', '20160118000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118140820000083', '20160118141552000779', '1', '1', '0', NULL, '', NULL, NULL, '', '36.8C'),
('2016000077', '20160111', 'cepenza', 'S00', '85kg', '125/74mmHg', '72bpm', '', '20160118000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160118141124000513', '20160118144411000716', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9'),
('2016000078', '20160115', 'fpatrick', NULL, '110kg', '138/82mmhg', '65pls/min', '1.80', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119082911000368', '20160119083714000719', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000079', '20160116', NULL, NULL, '74kgs', '122/67mmhg', '63pls/min', '1.81m', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119090236000574', '20160119091206000030', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000080', '20160120', 'fpatrick', NULL, '75kg', '136/70mmhg', '61pls/min', '1.70m', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119101221000585', '20160119101420000707', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000081', '20160119', 'fpatrick', NULL, '65kgs', '124/63mmhg', '65pls/min', '1.72m', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119101627000352', '20160119102326000541', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000082', '20160123', 'fpatrick', NULL, '78kg', '118/49mmhg', '61pls/min', '1.82m', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119102851000007', '20160119104529000558', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000083', '20160126', 'fpatrick', NULL, '62kg', '126/59mmhg', '79plsMIN', '', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119105829000034', '20160119110039000028', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.6c'),
('2016000084', '20160129', 'fpatrick', NULL, '82kg', '135/61MMHG', '58pls/min', '1.80m', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119115511000050', '20160119120752000313', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000085', '20160132', 'fpatrick', NULL, '78KG', '132/75MMHG', '60PLS/MIN', '1.78MMHG', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119130212000495', '20160119131026000002', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000086', '20160135', 'fpatrick', NULL, '70KG', '139/82MMHG', '73PLS/MIN', '1.75M', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119132601000556', '20160119134607000267', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000087', '20160134', 'fpatrick', NULL, '58KG', '126/68MMHG', '62PLS/MIN', '1.60M', '20160119000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119134818000603', '20160119135450000805', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000088', '20160133', 'cepenza', 'S00', '80kg', '208/123', '86', '', '20160119000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160119143345000073', '20160119145045000370', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000089', '20160141', 'fpatrick', NULL, '75kg', '120/63mmhg', '59pls/min', '1.73m', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120082929000157', '20160120083331000082', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000090', '20160142', NULL, NULL, '82kg', '121/72mmhg', '76pls/min', '', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120084002000924', '20160120084607000081', '1', '1', '0', NULL, '', NULL, NULL, '', '36.8c'),
('2016000091', '20160143', 'fpatrick', NULL, '70kg', '142/65mmhg', '48pls/min', '', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120095116000482', '20160120095410000477', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.8c'),
('2016000092', '20160144', 'fpatrick', NULL, '72kg', '132/65mmhg', '64pls/min', '', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120112834000816', '20160120113455000554', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.7c'),
('2016000093', '20160145', 'fpatrick', NULL, '71kg', '144/76mmhg', '66pls/min', '1.69m', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120113802000492', '20160120114103000451', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000094', '20160146', 'fpatrick', NULL, '68kg', '122/53mmhg', '64pls/min', '1.70m', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120115333000393', '20160120115633000402', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000095', '20160148', 'fpatrick', NULL, '79kg', '131/60mmhg', '81pls''', '', '20160120000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120121448000816', '20160120121730000644', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '37.1c'),
('2016000096', '20160139', 'cepenza', 'S00', '80kg', '142/79mmHg', '90bpm', '', '20160119000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160120140100000419', '20160120141207000123', '1', '1', '0', NULL, '', NULL, NULL, '', '32,2'),
('2016000097', '20160154', 'fpatrick', NULL, '84kg', '130/89mmhg', '71pls/min', '', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121094634000377', '20160121095634000536', '1', '1', '0', NULL, '', NULL, NULL, '', '36.5c'),
('2016000098', '20160155', 'fpatrick', NULL, '70kg', '102/54mmhg', '82pls''', '', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121100326000299', '20160121101415000084', '1', '1', '0', NULL, '', NULL, NULL, '', '36.1c'),
('2016000099', '20160156', 'fpatrick', NULL, '65kg', '134/77mmhg', '56pls/min', '', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121102100000544', '20160121102901000666', '1', '1', '0', NULL, '', NULL, NULL, '', '36.4c'),
('2016000100', '20160157', 'fpatrick', NULL, '70kg', '130/83mmhg', '68pls''', '36.2c', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121111728000725', '20160121112228000698', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000101', '20160158', 'fpatrick', NULL, '76kg', '96/61mmhg', '84pls''', '1.74m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121113402000448', '20160121114122000337', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000102', '20160161', 'fpatrick', NULL, '60kg', '129/83mmhg', '69pls''', '1.79m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121170505000434', '20160121170843000835', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000103', '20160164', 'fpatrick', NULL, '69kg', '135/82mmhg', '57pls''', '1.67m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122082256000775', '20160122082418000800', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000104', '20160159', 'fpatrick', NULL, '79kg', '13069', '71pls''', '1.91m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122083007000866', '20160122083227000471', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000105', '20160160', 'fpatrick', NULL, '83kg', '140/66', '70pls''', '1.89m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122083435000859', '20160122083617000443', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000106', '20160161', 'fpatrick', NULL, '60kg', '129/83mmhg', '69pls''', '1.79m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122083906000399', '20160122084217000063', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000107', '20160150', 'fpatrick', NULL, '83kg', '118/74mmhg', '60pls''', '1.79m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122084359000602', '20160122084524000030', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000108', '20160149', 'fpatrick', NULL, '59KG', '146/75mmhg', '65pls''', '1.67m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122084800000249', '20160122085222000688', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000109', '20160151', 'fpatrick', NULL, '73kg', '124/72mmhg', '80pls''', '1.77m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122085538000453', '20160122085733000628', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000110', '20160158', 'fpatrick', NULL, '76kg', '96/61mmhg', '84pls''', '1.74m', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122085935000027', '20160122090139000771', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000111', '20160166', 'fpatrick', NULL, '92KG', '137/63mmhg', '63pls''', '1.74m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122090423000052', '20160122090920000083', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000112', '20160169', 'fpatrick', NULL, '80KG', '125/82mmhg', '78pls''', '1.77m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122103904000572', '20160122104309000498', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000113', '20160171', 'fpatrick', NULL, '70kg', '132/64mmhg', '64pls''', '', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122104647000884', '20160122105116000198', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9c'),
('2016000114', '20160170', 'fpatrick', NULL, '60kg', '126/73mmhg', '78pls''', '', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122105641000557', '20160122110536000270', '1', '1', '0', NULL, '', NULL, NULL, '', '36.7c'),
('2016000115', '20160173', 'fpatrick', NULL, '65kg', '136/83mmhg', '76pls''', '1.74m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122111302000731', '20160122111808000097', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000116', '20160172', 'fpatrick', NULL, '80kg', '130/79mmhg', '74pls''', '1.74m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122112151000134', '20160122112459000336', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000117', '20160174', 'fpatrick', NULL, '83KG', '133/79MMHG', '81PLS''', '1.69M', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122112902000462', '20160122113534000278', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000118', '20160175', 'fpatrick', NULL, '65KG', '123/64MMHG', '65PLS/MIN', '1.70M', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122113811000095', '20160122114210000291', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000119', '20160176', NULL, NULL, '75KG', '120/68MMHG', '72PLS/MIN', '', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122124426000586', '20160122124848000519', '1', '1', '0', NULL, '', NULL, NULL, '', '37C'),
('2016000120', '20160177', 'fpatrick', NULL, '70kg', '107/84mmhg', '74pls''', '1.79m', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122131703000929', '20160122131936000552', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000121', '20160152', 'fpatrick', NULL, '72kg', '156/77mmhg', '62pls''', '', '20160121000000000000', '', '0', '2000', '2016', '1', 'fpatrick', NULL, '20160122132419000151', NULL, '0', '0', '0', NULL, '', NULL, NULL, '', '36.4c'),
('2016000122', '20160152', 'fpatrick', NULL, '72kg', '156/77mmhg', '62pls''', '', '20160121000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122132613000248', '20160122132853000677', '1', '1', '0', NULL, '', NULL, NULL, '', '36.4c'),
('2016000123', '20160178', 'fpatrick', NULL, '63kg', '106/65mmhg', '94pls''', '', '20160122000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122152349000555', '20160122152841000795', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.8c'),
('2016000124', '20160184', 'cepenza', 'S00', '94', '158/93', '55', '1.76', '20160123000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160123093515000429', '20160123094104000105', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000125', '20160185', 'cepenza', 'S00', '70', '117/58', '64', '1.66', '20160123000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160123094751000437', '20160123095026000158', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000126', '20160183', 'cepenza', 'S00', '70', '128/82', '74', '', '20160123000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160123102426000766', '20160123103156000956', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000127', '20160193', 'fpatrick', NULL, '66kgs', '113/62mmhg', '72pls''', '1.63m', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125073428000586', '20160125073824000942', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000128', '20160194', 'fpatrick', NULL, '65kg', '120/78mmhg', '57pls''', '1.68m', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125074335000856', '20160125075005000748', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000129', '20160192', 'fpatrick', NULL, '71kg', '144/75mmhg', '49pls/min', '1.59m', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125075910000190', '20160125081718000565', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000130', '20160195', 'fpatrick', NULL, '68kg', '114/60mmhg', '76pls''', '', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125083659000691', '20160125084345000276', '1', '1', '0', NULL, '', NULL, NULL, '', '36.4c'),
('2016000131', '20160196', 'fpatrick', NULL, '70kg', '109/60mmhg', '70pls''', '', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125085421000614', '20160125090641000758', '1', '1', '0', NULL, '', NULL, NULL, '', '36.3c'),
('2016000132', '20160197', 'fpatrick', NULL, '105kg', '127/76mmhg', '65pls''', '1.78m', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125103751000550', '20160125104619000247', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000133', '20160199', 'fpatrick', NULL, '75kg', '144/72mmhg', '70pls''', '1.80m', '20160125000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125110716000394', '20160125111226000251', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000134', '20160202', 'fpatrick', NULL, '65kg', '123/70mmhg', '74pls''', '1.70m', '20160125000000000000', '', '0', '2000', '2016', '1', 'fpatrick', NULL, '20160125115140000232', NULL, '0', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000135', '20160206', 'fpatrick', NULL, '80kg', '17/11cmhg', '68pls''', '1.64m', '20160126000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126095220000359', '20160126095753000700', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000136', '20160205', 'fpatrick', NULL, '80kg', '11/6 cmhg', '74pls''', '1.59m', '20160126000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126100004000971', '20160126100624000194', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000137', '20160211', 'fpatrick', NULL, '85kg', '97/58cmhg', '62pls''', '1.70m', '20160126000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126100853000502', '20160126101943000954', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000138', '20160212', NULL, NULL, '89kg', '118/74mmhg', '63pls''', '', '20160126000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126102229000724', '20160126102612000783', '1', '1', '0', NULL, '', NULL, NULL, '', '36.9c'),
('2016000139', '20160215', 'fpatrick', NULL, '75kg', '10/5mmhg', '54pls''', '1.74m', '20160126000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126104441000271', '20160126104612000198', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000140', '20160230', 'fpatrick', NULL, '65kg', '115/63mmhg', '75pls''', '1.62m', '20160127000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127164419000854', '20160127164534000500', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000141', '20160231', 'fpatrick', NULL, '93kg', '144/82mmhg', '57pls''', '1.77m', '20160127000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127164732000655', '20160127165033000928', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000142', '20160229', 'fpatrick', NULL, '79kg', '153/94mmhg', '66pls''', '1.7ém', '20160127000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127165233000983', '20160127165647000311', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000143', '20160227', 'fpatrick', NULL, '67kg', '107/58mmhg', '65pls''', '1.55m', '20160127000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127165856000557', '20160127170133000993', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000144', '20160228', 'fpatrick', NULL, '72kg', '96/56mmhg', '66pls''', '1.63m', '20160127000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127170352000693', '20160127170709000253', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000145', '20160233', 'fpatrick', NULL, '90kg', '127/84mmhg', '92pls''', '1.66m', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128085648000566', '20160128090415000806', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000146', '20160234', 'cepenza', 'S00', '90', '163/104', '65', '1.70', '20160128000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160128091317000115', '20160128093219000957', '1', '1', '0', NULL, '', NULL, NULL, '', ''),
('2016000147', '20160235', 'fpatrick', NULL, '74kg', '11/6cmhg', '78pls''', '1.61m', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128100440000334', '20160128102310000916', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000148', '20160237', 'fpatrick', NULL, '73kg', '11/7cmhg', '80pls''', '1.64m', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128102519000986', '20160128103400000697', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000149', '20160238', 'fpatrick', NULL, '101kg', '15/9cmhg', '59pls''', '', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128103609000907', '20160128104710000485', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000150', '20160236', 'fpatrick', NULL, '100kg', '13/8mmhg', '59pls''', '1.65m', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128104958000706', '20160128110406000501', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000151', '20160239', 'fpatrick', NULL, '70kg', '110/66mmhg', '91pls''', '', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128120826000832', '20160128121437000000', '1', '1', '0', NULL, '', NULL, NULL, '', '36.7c'),
('2016000152', '20160240', 'fpatrick', NULL, '97kg', '131/63mmhg', '97pls''', '', '20160128000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128130639000524', '20160128130945000313', '1', '1', '0', NULL, '', NULL, NULL, '', '38.9c'),
('2016000153', '20160255', 'fpatrick', NULL, '109KG', '141/81mmhg', '70pls''', '1.80m', '20160201000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201151912000570', '20160201152717000581', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000154', '20160257', 'fpatrick', NULL, '72kg', '130/59mmhg', '64pls''', '1.77m', '20160201000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201153146000081', '20160201153735000993', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000155', '20160256', 'fpatrick', NULL, '67kg', '161/90mmhg', '79pls''', '', '20160201000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201154703000682', '20160201155218000303', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000156', '20160258', 'fpatrick', NULL, '66kg', '134/61mmhg', '93pls''', '', '20160201000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201155834000957', '20160201160535000006', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.8c'),
('2016000157', '20160259', 'fpatrick', NULL, '82kg', '131/71mmhg', '55pls''', '', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202080810000186', '20160202081042000489', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.3c'),
('2016000158', '20160262', 'fpatrick', NULL, '108kg', '128/70mmhg', '68pls''', '1.84m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202090326000924', '20160202091257000276', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000159', '20160263', 'fpatrick', NULL, '70kg', '135/72mmhg', '73pls''', '1.73m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202091741000213', '20160202092836000746', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000160', '20160267', 'fpatrick', NULL, '76kg', '128/79mmhg', '62pls''', '1.75m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202094124000079', '20160202094657000610', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000161', '20160268', 'fpatrick', NULL, '80kg', '140/71mmhg', '89pls''', '', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202100821000516', '20160202101253000492', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36.4c'),
('2016000162', '20160272', 'fpatrick', NULL, '76kg', '149/82MMHG', '73PLS4', '1.58M', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202111101000607', '20160202111454000608', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000163', '20160274', 'fpatrick', NULL, '78kg', '128/67mmhg', '59pls''', '1.77m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202112304000767', '20160202113018000429', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000164', '20160276', 'fpatrick', NULL, '61kg', '115/65mmhg', '75pls''', '1.77m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202113512000343', '20160202114338000707', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000165', '20160278', 'fpatrick', NULL, '62kg', '105/48mmhg', '62pls''', '1.70m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202114531000790', '20160202115113000921', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000166', '20160280', 'fpatrick', NULL, '72kg', '126/74mmhg', '72pls''', '1.70m', '20160202000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202115321000320', '20160202115617000918', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000167', '20160368', 'fpatrick', NULL, '96kg', '123/72mmhg', '71pls''', '1.75m', '20160206000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160206090552000114', '20160206091143000006', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000168', '20160373', 'fpatrick', NULL, '65kg', '102/62mmhg', '84pls''', '1.58m', '20160206000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160206094619000122', '20160206094751000552', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '');
INSERT INTO `tab_consul` (`COD_CONSUL`, `COD_PAT`, `COD_USR`, `COD_SPEC`, `VAL_POIDS`, `VAL_TENSION`, `VAL_POU`, `VAL_TAILLE`, `DAT_CONSUL`, `LIB_STATUT`, `VAL_MNT_TTC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_VAL`, `BOO_CPTE_RENDU`, `BOO_PAIE`, `REF_FAC`, `ENU_MOD_PCHG`, `COD_VIS_MED_EMB`, `COD_VIS_MED_PERIO`, `TYP_VIS_MED_SRC`, `VAL_TMP`) VALUES
('2016000169', '20160375', 'fpatrick', NULL, '85kg', '129/64mmhg', '71pls''', '1.83m', '20160206000000000000', '', '0', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160206100622000976', '20160206101518000459', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000170', '20160420', 'cepenza', NULL, '62kg', '117/73mmhg', '71pls''', '1,67m', '20160212000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160212080450000810', '20160212080635000845', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000171', '20160559', NULL, NULL, '76kg', '133/62mmhg', '62ppm', '170', '20160222000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222093545000432', '20160222093558000723', '1', '0', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000172', '20160557', NULL, NULL, '60kg', '108/63mmhg', '69ppm', '165', '20160222000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222094225000928', '20160222094232000464', '1', '0', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000173', '20160558', NULL, NULL, '65kg', '119/74mmhg', '93ppm', '175', '20160222000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222094621000814', '20160222094637000430', '1', '0', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000174', '20160555', NULL, NULL, '77kg', '141/73mmhg', '73ppm', '177', '20160222000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222095028000770', '20160222095033000013', '1', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000175', '20160556', NULL, NULL, '83kg', '120/71mmhg', '77ppm', '185', '20160222000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222095307000875', '20160222095313000678', '1', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000176', '20160560', NULL, NULL, '57kg', '142/83mmhg', '66ppm', '165', '20160222000000000000', 'marié', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222100659000255', '20160222100704000263', '1', '0', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000177', '20160260', NULL, NULL, '72kg', '108/83mmhg', '83ppm', '', '20160202000000000000', 'célibataire', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222103648000792', '20160222105341000000', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '36,4°C'),
('2016000178', '20160260', NULL, NULL, '72kg', '108/83mmhg', '83ppm', '', NULL, 'Célibataire', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222111445000490', '20160222112004000160', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '36,4°C'),
('2016000179', '20160264', NULL, NULL, '72kg', '134/78mmhg', '65ppm', '179', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222112451000821', '20160222112636000254', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000180', '20160265', NULL, NULL, '73kg', '123/57mmhg', '57ppm', '182', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222112958000302', '20160222113127000861', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000181', '20160269', NULL, NULL, '67kg', '191/85mmhg', '87ppm', '167', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222114240000090', '20160222114615000706', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '36,4°C'),
('2016000182', '20160270', NULL, NULL, '63kg', '128/68mmhg', '65ppm', '174', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222114940000113', '20160222115126000257', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000183', '20160271', NULL, NULL, '72kg', '169/99mmhg', '64ppm', '173', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222120250000976', '20160222120533000219', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000184', '20160275', NULL, NULL, '63kg', '114/62mmhg', '52ppm', '162', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160222120831000575', '20160222120939000216', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000185', '20160273', NULL, NULL, '88kg', '131/83mmhg', '93ppm', '173', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160223103830000312', '20160223104311000931', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000186', '20160277', NULL, NULL, '70kg', '139/83mmhg', '96ppm', '173', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160223104827000722', '20160223105005000940', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000187', '20160281', NULL, NULL, '61kg', '144/83mmhg', '65ppm', '', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160223111249000688', '20160223111514000066', '1', '1', '0', NULL, '', NULL, NULL, '', '36,4°C'),
('2016000188', '20160279', NULL, NULL, '59kg', '116/73mmhg', '87ppm', '158', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224082143000540', '20160224082301000259', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000189', '20160284', NULL, NULL, '84kg', '164/102', '80ppm', '160', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224092312000100', '20160224092701000170', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000190', '20160285', NULL, NULL, '87kg', '146/77mmhg', '74ppm', '172', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224094552000144', '20160224094704000372', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000191', '20160290', NULL, NULL, '86kg', '114/85mmhg', '89ppm', '170', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224095005000052', '20160224095148000653', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000192', '20160291', NULL, NULL, '80kg', '127/76mmhg', '59ppm', '165', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224095744000687', '20160224095933000373', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000193', '20160363', NULL, NULL, '70kg', '128/67mmhg', '57ppm', '176', '20160202000000000000', '', '0', '2001', '2016', '0', 'fewane', 'fewane', '20160224102723000696', '20160224105149000367', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000194', '20160295', NULL, NULL, '71kg', '128/80mmhg', '62ppm', '', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224105735000883', '20160224105900000392', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36,8°C'),
('2016000195', '20160266', NULL, NULL, '90kg', '129/79mmhg', '90ppm', '163', '20160202000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224110315000313', '20160224110732000564', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '37,4°C'),
('2016000196', '20160293', NULL, NULL, '105kg', '126/67mmhg', '77ppm', '', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224112601000526', '20160224113636000791', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '36,9°C'),
('2016000197', '20160296', NULL, NULL, '68kg', '110/59mmhg', '61ppm', '171', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224114921000339', '20160224115027000343', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000198', '20160297', NULL, NULL, '82kg', '136/87mmhg', '81ppm', '170', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224115306000728', '20160224115517000768', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000199', '20160298', NULL, NULL, '100kg', '158/90', '77ppm', '', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160224115855000997', '20160224120045000618', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', '37,1°C'),
('2016000200', '20160324', NULL, NULL, '75kg', '136/76mmhg', '61ppm', '165', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225081053000178', '20160225081208000211', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000201', '20160321', NULL, NULL, '74kg', '151/81mmhg', '75ppm', '', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225081447000549', '20160225081544000356', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36,9°C'),
('2016000202', '20160320', NULL, NULL, '65kg', '129/63mmhg', '79ppm', '', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225081805000802', '20160225081902000627', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36,8°C'),
('2016000203', '20160605', NULL, NULL, '78kg', '406/62mmhg', '83ppm', '166', '20160225000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225082316000685', '20160225082414000823', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000204', '20160594', NULL, NULL, '55kg', '124/71mmhg', '68ppm', '180', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225084126000966', '20160225084218000045', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000205', '20160588', NULL, NULL, '67kg', '127/63mmhg', '74ppm', '184', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225084359000893', '20160225084507000680', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000206', '20160590', NULL, NULL, '65kg', '133/75mmhg', '91ppm', '162', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225101054000623', '20160225101218000351', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000207', '20160595', NULL, NULL, '83kg', '162/87mmhg', '84ppm', '180', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225101421000280', '20160225101536000263', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000208', '20160585', NULL, NULL, '118kg', '166/78mmhg', '82ppm', '187', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225101903000556', '20160225102048000277', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', '36,6°C'),
('2016000209', '20160593', NULL, NULL, '77kg', '133/78mmhg', '103ppm', '172', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225112415000069', '20160225112528000548', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000210', '20160591', NULL, NULL, '74kg', '152/83mmhg', '79ppm', '188', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225112731000985', '20160225112838000028', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000211', '20160584', NULL, NULL, '67kg', '127/83mmhg', '66pmm', '172', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225113218000048', '20160225113707000517', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000212', '20160073', NULL, NULL, '72kg', '127/65mmhg', '74ppm', '171', '20160223000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225114212000075', '20160225114357000897', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000213', '20160581', NULL, NULL, '73kg', '137/70mmhg', '66ppm', '170', '20160223000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225114953000044', '20160225115134000155', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000214', '20160592', NULL, NULL, '94kg', '142/76mmhg', '87ppm', '185', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225121050000292', '20160225121143000119', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000215', '20160602', NULL, NULL, '74kg', '118/68mmhg', '91ppm', '180', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225121349000639', '20160225121455000878', '1', '1', '0', NULL, '', NULL, NULL, 'VM_EMB', ''),
('2016000216', '20160582', NULL, NULL, '90kg', '122/79mmhg', '66ppm', '166', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225122034000838', '20160225122320000318', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000217', '20160583', NULL, NULL, '84kg', '125/87mmhg', '82ppm', '180', '20160224000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225122521000815', '20160225122610000335', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000218', '20160580', NULL, NULL, '70kg', '127/63mmhg', '71ppm', '180', '20160223000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225123046000700', '20160225123212000344', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000219', '20160571', NULL, NULL, '75kg', '119/64mmhg', '61ppm', '176', '20160223000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160225123441000532', '20160225123540000411', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000220', '20160289', NULL, NULL, '90kg', '111/68mmhg', '82ppm', '169', '20160302000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301085457000936', '20160301085634000784', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000221', '20160299', NULL, NULL, '100kg', '127/78mmhg', '86ppm', '176', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301090325000830', '20160301090558000680', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000222', '20160300', NULL, NULL, '70kg', '109/59mmhg', '64ppm', '166', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301090906000130', '20160301091102000760', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000223', '20160301', NULL, NULL, '87kg', '120/70mmhg', '78ppm', '175ppm', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'admin', '20160301091415000654', '20160416090100000586', '1', '1', '0', '777', '', NULL, NULL, 'VM_PERIO', ''),
('2016000224', '20160304', NULL, NULL, '79kg', '130/80mmhg', '86ppm', '169', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301100251000473', '20160301100412000961', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000225', '20160303', NULL, NULL, '71kg', '140/70mmhg', '74ppm', '162', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301100732000467', '20160301100931000959', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000226', '20160305', NULL, NULL, '93kg', '100/60mmhg', '77ppm', '152', '20160203000000000000', '', '0', '2002', '2016', '1', 'fewane', 'fewane', '20160301101316000544', '20160301101501000333', '1', '1', '0', NULL, '', NULL, NULL, 'VM_PERIO', ''),
('2016000227', '20160669', 'admin', 'S00', '55', '12', '11', '160', '20160603000000000000', '', '10000', '2011', '2016', '1', 'admin', 'admin', '20160603151204000879', '20160603152854000729', '1', '1', '1', 'REF/2016/0001', '2000', NULL, NULL, 'VM_PERIO', '37');

-- --------------------------------------------------------

--
-- Structure de la table `tab_cpte_rendu_consul`
--

CREATE TABLE IF NOT EXISTS `tab_cpte_rendu_consul` (
  `COD_CPTE_RENDU_CONSUL` varchar(32) NOT NULL DEFAULT '',
  `COD_CONSUL` varchar(32) DEFAULT NULL,
  `LIB_MOTIF_CONSUL` varchar(1024) DEFAULT NULL,
  `LIB_HIS_MAL` varchar(1024) DEFAULT NULL,
  `LIB_DIAG_PRIN` varchar(1024) DEFAULT NULL,
  `LIB_DIAG_SENC` varchar(1024) DEFAULT NULL,
  `LIB_EXAM_BIO` varchar(1024) DEFAULT NULL,
  `LIB_EXPLO_FONC` varchar(1024) DEFAULT NULL,
  `LIB_EXAM_IMAG` varchar(1024) DEFAULT NULL,
  `LIB_TRAIT_PRES` varchar(1024) DEFAULT NULL,
  `LIB_CONCL` varchar(1024) DEFAULT NULL,
  `DAT` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) NOT NULL DEFAULT '0',
  `LIB_ANTE_PRO` varchar(1024) DEFAULT NULL,
  `LIB_ANTE_PERSO` varchar(1024) DEFAULT NULL,
  `LIB_ANTE_FAMI` varchar(1024) DEFAULT NULL,
  `LIB_EXAM_PHY` varchar(1024) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`COD_CPTE_RENDU_CONSUL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_cpte_rendu_consul`
--

INSERT INTO `tab_cpte_rendu_consul` (`COD_CPTE_RENDU_CONSUL`, `COD_CONSUL`, `LIB_MOTIF_CONSUL`, `LIB_HIS_MAL`, `LIB_DIAG_PRIN`, `LIB_DIAG_SENC`, `LIB_EXAM_BIO`, `LIB_EXPLO_FONC`, `LIB_EXAM_IMAG`, `LIB_TRAIT_PRES`, `LIB_CONCL`, `DAT`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_VAL`, `LIB_ANTE_PRO`, `LIB_ANTE_PERSO`, `LIB_ANTE_FAMI`, `LIB_EXAM_PHY`, `TYP_VIS_MED_SRC`) VALUES
('2015000005', '2015000012', 'Douleur lombaire', 'évoluant depuis 1semaine \nautomedication:antiinflamatoire', 'lombarthrose', NULL, '', '', '', 'NATECAL D,ANTALGEX-T', '', NULL, '2002', '2015', '1', 'fewane', 'fewane', '20150914152346000997', '20150914152418000573', '1', '', 'intervention chirurgicale au niveau du duodénum il ya 20ans', '', 'sensibilité en regard de L4-L5', NULL),
('2015000006', '2015000016', 'douleurs articulaires,rhinorrhée,douleurs thoraciques', 'évolution 1 semaine', 'accès palustre simple? grippe?  ', NULL, 'aucun', '', 'aucun', 'bimalaril,ospamox fervex ', '', NULL, '2000', '2015', '1', 'fpatrick', NULL, '20150914154953000304', NULL, '0', 'non contributif', 'ras', 'ras', 'sans particularités', NULL),
('2015000007', '2015000015', 'tuméfaction douloureuse de la jambe dte', 'évoluant depuis un mois\nextraction d''un corps étranger??dans un centre de la place.\nttt:BECLAV,CATAFLAM,FUCIDINE', '', NULL, '', '', '', 'CEFUROXIME,TRAMADOL,\ncontinuer BECLAV\nfaire pansement quotidien', 'plaie infectée de la jambe drte', NULL, '2002', '2015', '1', 'fewane', 'fewane', '20150914155146000293', '20150914163910000055', '1', '', 'RAS', '', 'plaie profonde au niveau du 1/3inf de la jambe drte laissant sourdre du pus', NULL),
('2015000008', '2015000018', 'toux,notion de perte de poids', 'evolution 1 mois ', 'pneumopathie? syndromme grippal?', NULL, 'glycemie a jeun,baar ', '', '', 'biakof , clamoxyl 1g ', 'attente des resultats du labo', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150914161200000319', '20150914161224000943', '1', '', '', '', '', NULL),
('2015000009', '2015000019', 'tumefaction multiples non douloureuse dans la ceinture lombaire', 'évoluant depuis plus d ''1mois ', 'lipome ?', NULL, '', '', 'échographie des tuméfactions', 'aucun', 'attente des résultats d échographie confirmant la nature des tuméfactions', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150914164507000203', '20150914164517000243', '1', 'AUCUN', 'aucun', 'ras', 'palpation indolores des masses fermes ,immobiles  situées dans le flanc droit et la fosse lombaire droite\n', NULL),
('2015000010', '2015000022', 'visite médicale d ''embauche', 'ras', 'ras', NULL, 'cf labo', 'ras', 'ras', 'ras', '', NULL, '2000', '2015', '1', 'fpatrick', NULL, '20150915081726000277', NULL, '0', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2015000011', '2015000021', 'VME', '', 'pas d''anomalies ce jour', NULL, '', '', '', '', 'pas d''anomalies ce jour', '20150915000000000000', '2000', '2015', '1', 'fewane', NULL, '20150915082924000235', NULL, '0', 'RAS', 'RAS', 'RAS', 'sans particularités', NULL),
('2015000012', '2015000025', 'douleur de l ''epaule gauche', 'apparition progressive de la douleur après un match de football le 12-09-2015.sans médication et face à la persistance de la douleur le patient décide de se faire consulter', 'luxation scapulo-humérale?', NULL, 'aucun', '', 'ras', 'DICLAC 75MG,klipal 600/50,leorub gel', 'rendez vous pour évolution', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915085113000126', '20150915085125000076', '1', 'ras', 'ras', 'ras', 'palpation non douloureuse de l’épaule gauche\nmobilisation active,absence de déformation', NULL),
('2015000013', '2015000026', 'visite médicale systématique', 'ras', 'aucun', NULL, '', 'ras', 'radio du thorax face,visiotest', 'ras', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150915111011000781', '20150915111022000747', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2015000014', '2015000029', 'abcès fesse gauche,adenopathie inguinale gauche,fébricule evolution 3jours', 'non contributive', 'infections cutanées', NULL, 'ras', '', 'ras', 'biodroxil 1000mg\nklipal codeine 600/50mg\npansement', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921084346000286', '20150921084353000337', '1', 'ras', 'ras', 'ras', '', NULL),
('2015000015', '2015000030', 'céphalées asthenie physique,notion de vomissements,notion de diarrhées', 'automédication: efferalgan\névolution 3 jours', 'A.P.S/ salmonellose ?', NULL, 'GE VS NFS widal,taux d''HB \nexamen parasitologique des selles', '', '', 'bimalaril \nefferalgan\nhelmintox\nalfer', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921095045000186', '20150921095051000723', '1', 'ras', 'ras', 'ras', 'téguments et conjonctives hypocolorés\ncavité buccale propre ,dentition complète\nabdomen souple sans viscéromegalie palpable\nsensibilité algique à la palpation du flanc gauche\nreste de l ''examen sans particularités', NULL),
('2015000016', '2015000031', 'V.M.S', 'RAS', 'ULCERE GASTRO DUODENALE ?GASTRITE ?', NULL, 'DOSAGE HELICOBACTER PYLORI', '', 'RX DU THORAX(F)', '', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921101626000512', '20150921101633000066', '1', '', 'HTA DEPUIS 2012 SOUS TENORETIC', '', 'SENSIBILITE ALGIQUE A LA PALPATION DE L EPIGASTRE\nABDOMEN SOUPLE SANS ORGANOMEGALIE PALPABLE', NULL),
('2015000017', '2015000032', 'douleur abdominale, selles liquides', 'évoluant depuis 24h', 'toxiinfection alimentaire', NULL, '', '', '', 'FLAGYL 500 cp , SMECTA sachet', 'toxi infection alimentaire', '20150921000000000000', '2000', '2015', '1', 'fewane', NULL, '20150921104735000676', NULL, '0', 'RAS', 'RAS', '', 'sensibilité algique à la palpation diffuse de l''abdomen', NULL),
('2015000018', '2015000033', 'fièvre, céphalées, courbatures,pelvialgie, vomissement, vertiges', 'évoluant depuis 1semaine, \nTTT reçu: paracétamol 500', 'palusdisme sur aménorrhée gravidique probable de7semaines', NULL, 'G-test,GE,NFS', '', 'écho pelvienne', 'SG5%+Quinine 600mg+HPV 1amp, Buscopan 2amp/8h, Analgin 1amp/8h, vogalène 1amp/12h, surveillance', 'palusdisme sur aménorrhée gravidique probable de7semaines', NULL, '2002', '2015', '1', 'fewane', 'fewane', '20150921110537000380', '20150921110550000284', '1', '', 'DDR 01/08/15', 'RAS', 'conj rosées,coeur-poumons RAS,\nTV:vulve propre,sensibilité algique à la mobilisation de l''utérus, doigtiers ramenant du sang rouge', NULL),
('2015000019', '2015000034', 'douleur dans le dos ', 'évolution 2heure\naucune médication', 'traumatisme fermé du dos post AT', NULL, 'RAS', '', 'RAS', 'klipal codeine 600/50\ndiclac 75mg', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921112653000319', '20150921112658000827', '1', 'RAS', 'RAS', 'RAS', ' dos rouge tumefié \ndouleur à la palpation du dos', NULL),
('2015000020', '2015000036', 'douleur de l ''avant bras', 'evolution 2jours\nsous traitement (amoxicilline,ibuprofène)', 'fracture de l ''avant bras ?', NULL, 'ras', 'ras', 'Rx de l ''avant bras montrant l ''articulation du coude', 'tramadol 50\ndiclac  75mg\nmaxillase cp\n', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921125353000252', '20150921125400000163', '1', 'ras', 'ras', 'ras', 'coude tumefié douloureux\nimpotence fonctionnelle de l ''avant bras', NULL),
('2015000021', '2015000037', 'gonflement  de la main gauche,prurit main gauche', 'evolution 3 semaines\ntraitement à base d ''ibuprofène,phosphore', 'fracture des os de la main?', NULL, 'CRP NFS VS ASLO', '', 'RX de l''avant bras gauche f/p (partie distale plus main gauche)', 'lysoflam gel \ndiclac 75mg\nmaxillase ', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921151306000550', '20150921151313000475', '1', 'ras', 'ras', 'ras', 'tumefactios douloureuses de la main gauche \nabsence de lésions nerveuses', NULL),
('2015000022', '2015000038', 'sensations de chaleur,asthénie physique,céphalées', 'évolution 1semaine\nsans prise médicamenteuse', 'accès palustre simple ?', NULL, '', '', '', 'bimalaril 80/480\nefferalgan 1000\nacti 5 ampoule buvable', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150921154430000104', '20150921154435000485', '1', 'ras', 'ras', 'ras', 'bon état géneral\ntéguments et conjonctives normocolorés\nexamen physaique sans particularités', NULL),
('2015000023', '2015000040', 'V.M.S', 'ras', 'ras', NULL, '', '', 'RX du thorax', 'ras', '', NULL, '2002', '2015', '1', 'fpatrick', 'fpatrick', '20150922084620000630', '20150922084627000478', '1', 'ras', 'ras', 'ras', 'sans partcularités', NULL),
('2015000024', '2015000041', 'céphaléés,fièvre', 'depuis 3jrs\nTTT reçu: paracétamol', 'paludisme simple', NULL, '', '', '', 'D-ARTEPP,APRAMOL', 'paludisme simple', '20150921000000000000', '2000', '2015', '1', 'fewane', NULL, '20150922085000000980', NULL, '0', 'RAS', 'RAS', 'RAS', 'sans particularité', NULL),
('2015000025', '2015000043', 'douleur au niveau du site d''ablation d''une dent ', 'ablation faite il ya 10jrs\nTTT en cours:spiramycine+métronidazole, tramadol,klipal', '', NULL, '', '', '', 'continuer TTT en cours', 'revoir dentiste', NULL, '2000', '2015', '1', 'fewane', NULL, '20150922093822000347', NULL, '0', '', '', '', 'tuméfaction douloureuse de la gencive', NULL),
('2015000026', '2015000044', 'douleur  dans l''oeil gche', 'depuis 3jrs post traumatique(corps étranger)', 'oeil rouge douloureux post traumatique', NULL, '', '', '', 'RAMIDEX collyre', 'oeil rouge douloureux post traumatique', '20150922000000000000', '2000', '2015', '1', 'fewane', NULL, '20150922115747000724', NULL, '0', 'RAS', 'RAS', '', 'oeil gauche rouge,pas de baisse de l''acuité visuelle', NULL),
('2016000003', '2016000004', 'douleur abdominale, 7 episodes de selles liquides', 'evoluant depuis 24h\nrhéhydratation en cours', '', NULL, 'coprologie, GE, NFS, WIDAL,', '', '', 'LOOBID 1cpx2/jr pdt 07jrs, \nSRO france lait: 1sachet dans 250ml d''eau X3/jr à boire à volonté', 'dysenterie??/ Shiguellose, amibiase?', '20160104000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160104145204000278', '20160104145213000030', '1', 'RAS', 'RAS', '', 'douleur à la palpation diffuse de l''abdomen\npas de signes de déshydratation', NULL),
('2016000004', '2016000005', 'céphalées, asthénie, polyarthralgies, fièvre', 'évoluant depuis 3jrs', '', NULL, 'GE,NFS,CRP', '', '', 'RIDMAL: 3cp en prise unique /jr pdt 03jrs\nAPRAMOL: 2cpx2/jr \nHELMINTHOX 1sachet en PU à renouveller apres 1semaine', 'paludisme simple', NULL, '2002', '2016', '1', 'fewane', 'fewane', '20160104150941000710', '20160104150948000106', '1', 'RAS', 'intolérance à la quinine(prurit)', '', 'sans particularités', NULL),
('2016000005', '2016000007', 'VME', '', 'pas d''anomalies ce jours', NULL, '', '', 'Rx du thorax', '', 'pas d''anomalies ce jours', '20160104000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160104152809000220', '20160104152815000694', '1', 'RAS', 'RAS', 'RAS', 'sans particularités ce jour', NULL),
('2016000006', '2016000008', 'tumefaction de la joue gauche.douleur joue gauche', 'evolution 3jours\nautomedicatio:gebedol cp,1cp x 3/jr', 'carrie dentaire', NULL, 'aucun', '', '', 'soclav 1g cp.1cp x3\nmaxillase cp 2cp x 2\ncotinuer gebedol', '', '20160104000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104153813000892', '20160104153831000146', '1', '', '', '', 'sensibilté algique palpation joue gauche\ndentition carriée par endroit', NULL),
('2016000007', '2016000009', 'asthénie physique,nausées', 'hospitaliser il y''a 1 semaine au centre de santé soins polyvalent du stade \ntraitement reçue; glucosé5%b complexe vit c pendant 3jours', 'salmonellose??\nparasitose digestive??', NULL, 'coprologie', 'ras', 'ras', 'acti 5 ampoule buvable\nhelmintox sachet \n\n', '', '20160104000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104155646000151', '20160104155655000054', '1', '', 'paludisme', '', '', NULL),
('2016000008', '2016000010', 'abcès collecté de l aisselle gauche', '', '', NULL, '', '', '', 'incision/pansement \ncloxapen 500mg gel\nbrufen 400mg cp\nmaxillase cp\n', '', '20160104000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104160445000361', '20160104160458000402', '1', '', '', '', '', NULL),
('2016000009', '2016000012', 'visite médicale d embauche', 'RAS', 'RAS', NULL, '', '', '', 'RAS', '', '20160104000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160104161555000361', '20160104161600000665', '1', 'RAS', 'RAS', 'RAS', 'RAS', NULL),
('2016000010', '2016000011', 'VME', '', 'obésité IMC:35,44', NULL, '', '', 'Rx du thorax', 'mesures hygiéno-diététiques', 'obésité IMC:35,44', '20160104000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160104162409000129', '20160104162417000335', '1', 'RAS', 'alcool occasionnellement', 'RAS', 'abdomen distendu par un pannicule adipeux important ', NULL),
('2016000011', '2016000013', 'douleur auriculaire droite,baisse de l acuité auditive', 'evolution 1jour\n', 'otite externe???', NULL, '', '', '', 'soclav\ngebedol', '', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105084302000440', '20160105114109000304', '1', '', '', '', 'sensibilité algique à la palpation de l hemiface droit', NULL),
('2016000012', '2016000014', 'visite médicale d ''embauche', '', '', NULL, '', '', 'radiographie du thorax(f)', 'aucun', '', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105091021000598', '20160105091025000981', '1', '', ' toxicologique:alcool occasionnellement', '', 'examen appareil par appareils sans particularités', NULL),
('2016000013', '2016000015', 'VME', '', 'plaie suturée au niveau de la base de l''index drt ', NULL, '', '', 'Rx du thorax', 'pansement fait ce jour\ncontinuer traitement en cours', 'favorable', '20160105000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160105091653000897', '20160105091659000544', '1', 'RAS', 'plaie par arme blanche suturée au niveau de la base de l''index drt survenue il ya 5jrs\nttt en cours: Diclofenac, Ampicilline+cloxacilline', '', 'douleur au niveau de l''index drt', NULL),
('2016000014', '2016000016', 'visite medicale d ''embauche', '', '', NULL, '', '', 'radiographie du thorax(f)', 'aucun', '', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105092815000599', '20160105092821000059', '1', '', 'ddr;15-12-2015\nG2P1A1D1\n', '', 'examen physique appareil par appareil sans particularités', NULL),
('2016000015', '2016000017', 'VME', '', 'hernie inguinale drte?? faire échographie pelvienne\ntoux grasse', NULL, '', '', 'Rx du thorax', 'Broxol sirop: 10mlx3/jr pdt 5jrs', 'A revoir après échographie pelvienne', '20160105000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160105094228000361', '20160105094233000665', '1', 'RAS', 'alcool: occasionnelllement\nSd grippal il ya 4jrs:Mixagip', 'RAS', 'légère tuméfaction inguinale drte ,expulsive à la toux et réductible', NULL),
('2016000016', '2016000018', 'VME', '', 'obesité IMC:28.09 ', NULL, '', '', 'Rx du thorax\nvisiotest\nECG', 'mesures hygiénodiététiques', 'favorable', '20160105000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160105095751000192', '20160105095756000839', '1', 'RAS', 'alcool: occasionnellement\ntabac: sevré il ya 2ans', 'RAS', 'abdomen distendu par un pannicule adipeux important', NULL),
('2016000017', '2016000019', 'douleur lombaire ,céphalees', 'evolution 2jours\n', '', NULL, 'NFS VS GE WIDAL EXAMEN PARASITOLOGIQUE DES SELLES CRP', '', '', 'efferalgan 1g cp', '', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105101816000701', '20160105101820000476', '1', '', 'ddr 07-12-2014\nG4P3V3A1\nfemme allaitante enfant de 3mois', '', 'examen physique sans particularités', NULL),
('2016000018', '2016000020', 'toux sèche ,sensation de fièvre,céphalées notion de vomissements', 'evolution 2 jours\nautomédiction:paracetamol,cotrimoxazole', 'accès palustre simple??\ngrippe??\nsalmonellose??', NULL, 'nfs vs GE widal examen parasitologigue des selles', '', 'rx du thorax face/profil', 'coartem 80/480\nefferalgan 500cp\nlitacold cp\n', '', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105112857000664', '20160105112904000359', '1', '', 'hemoptysie(soudeur)\n  ', '', 'paleur conjoctivale,reste de l ''examen sans particularités', NULL),
('2016000019', '2016000021', 'VISITE MEDICALE D EMBAUCHE', '', '', NULL, '', '', 'RAS', 'RAS', 'ATTENTE RESULTATS EXAMENS PARACLINIQUES', '20160105000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160105140943000309', '20160105140953000613', '1', 'RAS', 'RAS', 'RAS', 'SANS PARTICULARITES', NULL),
('2016000020', '2016000022', 'visite médicale d embauche', '', 'hta grade 3???\n', NULL, 'nfs vs urée/creat,bilan lipidique,protidémie,glycémie à jeun;ionograme sanguin,bandelettes urinaires', 'fond d oeil', 'rx du thorax(f) ,electrocardiogramme', '', '', '20160106000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106095151000173', '20160106095157000429', '1', '', 'rhinite allergique', 'mère diabétique \npère :victime d ''accident vasculaire cerabral il ya 15ans', 'sans particularités aucunes', NULL),
('2016000021', '2016000023', 'visiite médicale d ''embauche', '', '', NULL, '', '', '', '', '', '20160106000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106101419000989', '20160106101424000881', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000022', '2016000024', 'plaies du visage,céphalées  ', 'evolution 2heures \naccident de la voie publique \nnotion de pertes de connaissance', 'traumatisme ouvert de l hémiface gauche post avp', NULL, '', '', '', 'pansement,pose de 4 points de suture\ndiclofenac 75mg cp\nparacetamol 500mg\ncloxacilline gel', 'pansement tous les 2jours\nrepos médical 05jours', '20160106000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160106102542000347', '20160106102548000261', '1', 'ras', 'ras', 'ras', 'plaies au niveau de la joue,du menton et de la tempe gauche\nsensibilité algique à la palpation de l hémiface gauche', NULL),
('2016000023', '2016000025', 'visite médicale systématique', '', '', NULL, '', '', 'mammographie', 'aucun', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107085519000870', '20160107085524000871', '1', '', 'gynécomastie droite\nobésité:IMC=41', 'obésité', 'sans particilarités', NULL),
('2016000024', '2016000026', 'visite médicale d ''embauche', '', '', NULL, '', '', 'rx du thorax(f)', '', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107090823000557', '20160107090829000166', '1', 'ras', 'ras', 'mère diabétique', 'sans particularités', NULL),
('2016000025', '2016000027', 'visite médicale d ''embauche,maux d''estomac,', 'maux d estomac sous traitement à l indigénat', 'gastrite??', NULL, '', '', 'rx du thorax( f)', 'sensodyne soins complet\nozapral cp', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107093559000062', '20160107093604000320', '1', '', 'maux d''estomac,carie dentaire,paludisme\n1 ou 2 bières par jour', 'mère hypertendu victime d ''AVC il y''a 3ans', 'dentition incomplète ,dents cariées par  endroits\n\n', NULL),
('2016000026', '2016000028', 'visite médicale systématique', '', '', NULL, '', '', '', 'ras', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107102355000182', '20160107102359000300', '1', 'ras', 'alcool occasionnellement\n', 'ras', 'ras', NULL),
('2016000027', '2016000029', 'sention de fièvre,plaies du membre inferieur droit,lombalgies', 'chute de sa hauteur il  ya 1 mois \nautomédication à base d ''ibuprofène', 'traumatisme ouvert du membre inferieur droit post AT\nsyndrome infectueux à porte d éntrée cutanée??\n', NULL, 'nfs ,vs ,ge,crp,glyvemie a jeun', '', 'rx lombaire (f/p)', 'pansements,diclofenac injectable\nrelais:diclofenac cp,cloxalline gellule,metronidazole 500mg', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107104323000754', '20160107104327000592', '1', '', 'paludisme', '', 'plaies du membre inferieur droit\nle reste sans particularités', NULL),
('2016000028', '2016000030', 'visite médicale d ''embauche', '', '', NULL, '', '', 'rx du thorax(F)', 'aucun', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107105704000624', '20160107105710000872', '1', '', '1P.A cigarettes depuis plus de 7ans\nalcool occasionnellement', 'ras', 'dentition incomplète,dents cariées par endroit', NULL),
('2016000029', '2016000031', 'tumefaction de la joue droite,céphalées', 'evolution  4jours\nautomédication ibuprofène', 'abcès sous mentonnier non collecté???', NULL, 'ras', '', 'ras', 'pansement alcolisé\ndiclofenac \nsoclav 1g', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107111049000583', '20160107111054000017', '1', 'ras', 'ras', 'ras', 'palpation douloureuse du menton', NULL),
('2016000030', '2016000032', 'congestion nasale,céphalées,toux', 'évolution 2jours \nautomédication bactérie', 'syndrome grippal???\naccès palustre simple????', NULL, 'nfs,vs,ge,widal,crp', 'ras', 'ras', 'litacold cp\nvit c sandoz', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107113656000023', '20160107113704000482', '1', 'ras', 'gastrite,fièvre typhoïde,paludisme', 'ras', 'ras', NULL),
('2016000031', '2016000033', 'douleurs abdominales,diarrhées,notions de vomissements,asthénie physique', 'evolution 7jours,automédication malox cp', 'toxi infection alimentaire??', NULL, 'widal,examen parasitologique des selles,nfs vs crp', '', '', 'spasmo apotel \nhelmintox 750mg cp\nloobid\nsro', '', '20160107000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160107150609000800', '20160107150614000883', '1', 'ras', 'hemorroides', 'ras', 'palpation peri ombilicale douloureuse\nreste de l examen sans particularités', NULL),
('2016000032', '2016000034', 'visite médicale systématique,larmoiement,photophobie', 'évolution plusieurs années', 'IMC=37 obésité', NULL, '', '', '', 'aucun', 'consultation ophtalmologique\nmesures hygiéno-diététique', '20160108000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108082341000308', '20160108082926000859', '1', 'ras', 'DDR;22-12-2015  G4P3v3A1\ncésarienne en 2008 et 2010', 'ras', 'sans particularités', NULL),
('2016000033', '2016000035', 'VMS', '', 'pas d''anomalies ce jour', NULL, '', '', 'visiotest', '', 'pas d''anomalies ce jour', '20160108000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160108083221000795', '20160108083227000365', '1', 'RAS', 'alcool: occasionnellement', 'RAS', 'sans particularité ce jour', NULL),
('2016000034', '2016000036', 'visite médicale systématique', '', 'IMC=43 obésité sévère', NULL, '', '', '', 'ozapral 30mg', '', '20160108000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108084759000535', '20160108084804000246', '1', 'ras', 'gastrite non suivi\nalcool occasionnellement', 'père diabétique et hypertendu', 'sans particularités', NULL),
('2016000035', '2016000037', 'visite médicale systématique ', '', '', NULL, '', '', '', 'aucun', 'pas d''anomalies', '20160108000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160108085703000415', '20160108085708000220', '1', 'ras', 'herniorraphie inguinale droite depuis 2001\nalcool occasionnellement', 'ras', 'sans particularités', NULL),
('2016000036', '2016000039', 'visite médicale d''embauche', '', '', NULL, '', '', '', 'aucun', '', '20160108000000000000', '2000', '2016', '1', 'fpatrick', NULL, '20160108105724000237', NULL, '0', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000037', '2016000040', 'visite médicale d''embauche', '', '', NULL, '', 'ras', 'rx du thorax(f)', 'ras', '', '20160111000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111084357000467', '20160111084406000356', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000038', '2016000041', 'visite médicale d''embauche', '', '', NULL, '', 'ras', 'radio du thorax(f)', 'aucun', 'pas d anomalies', '20160111000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111085835000327', '20160111085844000157', '1', 'ras', 'paludisme', 'ras', 'sans particularités', NULL),
('2016000039', '2016000042', 'VMS', '', 'obésité IMC:31.71', NULL, '', '', 'visiotest', 'mesures hygiénodiététiques', 'obésité IMC:31.71', '20160111000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160111090721000474', '20160111090818000898', '1', 'RAS', 'alcool: occasionnellement', 'RAS', 'pannicule adipeux important \nle reste sans particularité', NULL),
('2016000040', '2016000043', 'visite médicale d ''embauche', '', '', NULL, '', 'ras', 'rx du thorax(f)', 'aucun', 'pas d''anomalies', '20160111000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111093622000104', '20160111093628000032', '1', 'ras', 'alcool occasionnellement', 'ras', 'sans particularités', NULL),
('2016000041', '2016000044', 'traumatisme au niveau du visage', 'survenue ce jour lorsque le patient en plein travail s''est vu projeté au visage une substance corrosive ', 'brulure du 1er degré allant de la joue drte à la lèvre supérieure ', NULL, '', '', '', 'cloxacilline, métronidazole, ibuprofène, paracétamol\npansement à faire \nrepos médical de 2jrs', 'brulure du 1er degré allant de la joue drte à la lèvre supérieure post accident de travail', '20160111000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160111095624000712', '20160111095629000658', '1', 'RAS', 'allaergie au sulfamides', 'RAS', 'plaie superficielle oblique allant de la joue drte à la lèvre supérieure laissant sourdre un liquide clair', NULL),
('2016000042', '2016000045', 'viisite médicale d''embauche', '', '', NULL, '', 'ras', 'rx du thorax(f)', 'aucun', 'pas d''anomalies', '20160111000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160111120646000816', '20160111120652000146', '1', 'ras', 'rhumatisme\nalcool occasionnellement', 'ras', 'sans particularités', NULL),
('2016000043', '2016000046', 'VMS', '', 'obésité IMC 29.37', NULL, '', '', 'ECG\nVISIOTEST\nRx du thorax', 'mesures hygiénodiététiques', 'favorable', '20160111000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160111132939000021', '20160111132944000081', '1', 'RAS', 'alcool:occasionnellement', 'HTA chez le père', 'pannicule adipeux important\npar ailleurs RAS', NULL),
('2016000044', '2016000047', 'pyrosis,douleur lombaire, polyarthralgies', 'évoluant depuis 2mois \nttt reçu:Maalox', 'RGO\nLOMBARTHROSE??', NULL, '', '', '', 'Arcoxia\nVit Bdenk\nEsomed 40mg\nrdv dans 03jours', 'RGO\nLOMBARTHROSE??', '20160111000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160111133852000005', '20160111133900000592', '1', 'RAS', 'épigastralgie', 'RAS', 'BEG, signe de la sonnette entre L4-L5', NULL),
('2016000045', '2016000049', 'plaies de l ''auriculaire main droite post AT', 'evolution 2heures', '', NULL, 'ras', 'ras', 'traumatisme ouvert de la phalange p1 de l auriculaire de la main droite post AT', 'pansements ,pose de 2 points de suture,\nSAT,diclofenac 50mg cp,cloxacilline 500mg gel', '', '20160111000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112083242000135', '20160112083246000503', '1', 'ras', 'ras', 'ras', 'plaies et palpation douloureuse de l auriculaire de la main droite \n', NULL),
('2016000046', '2016000050', 'douleur de la main droite,toux,ecoulement nasal', 'évolution 1semaine\ntraiter à l ''indigénat', 'tuméfaction douloureuse du médius de la main droite\ngrippe?', NULL, 'ras', 'ras', 'ras', 'lysoflam cp,lysoflam gel,litacold cp', 'mise au repos main droite pendant 05jours', '20160112000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112084103000715', '20160112084108000463', '1', 'ras', 'ras', 'ras', 'palpation douloureuse et impotence fonctionnelle relative du médius de la main droite', NULL),
('2016000047', '2016000051', 'sensation d''etouffement,douleur thoracique', 'évolution 1 semaine', 'colique hépatique??\nulcère gastro-duodénale??', NULL, 'nfs, vs,crp', 'ras', 'échographie abdominale,radio du thorax(f/p),électrocardiogramme', 'tramadol denk 50MG', '', '20160112000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112113236000608', '20160112113241000107', '1', 'ras', 'fièvre typhoïde,sensation d’étouffement? \ngastrite depuis 2mois sous malox\nDDR:05-12-2015,G3P2V2A1', 'ras', 'douleur inhibant l ''inspiration profonde,sensibilité algique à la palpation de l''hypochondre droit,', NULL),
('2016000048', '2016000052', 'VME', '', 'obesité IMC 32.1', NULL, '', '', 'RX du thorax', 'activité physique régulière, boire 3l d''eau/jr, consommer fruits et légumes, éviter de manger gras', 'favorable', '20160112000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160112120751000533', '20160112120756000156', '1', 'RAS', 'Alcool:occasionnellement', 'diabète chez la mère', 'pannicule adipeux important\nsifflement expiratoire', NULL),
('2016000049', '2016000053', 'visite médicale d''embauche', 'IMC=32', 'obésité', NULL, '', '', 'radio du thorax face\nECG\nVisiotest', 'mesures hygiéno diététiques', 'obésité', '20160112000000000000', '2000', '2016', '1', 'fpatrick', NULL, '20160112120830000894', NULL, '0', 'ras', 'alcool occasionnellement\npatient obèse', 'ras', 'sans particularités', NULL),
('2016000050', '2016000054', 'visite médicale d''embauche', 'ras', '', NULL, 'ras', '', 'rx du thorx(f)\nvisiotest', 'ras', '', '20160112000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160112151921000063', '20160112151925000572', '1', 'RAS', 'RAS', 'pere hypertendu', 'sans particularités', NULL),
('2016000051', '2016000055', 'visite médicale d''embauche', 'ras', '', NULL, 'ras', 'ras', 'ras', 'aucun', 'examen physique sans particularités.attente résultats examens paracliniques', '20160113000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113081722000140', '20160113081726000571', '1', 'ras', 'difficultés à la lecture (port de verres correcteurs)', 'père hypertendu', 'dentition incomplète,dents cariées par endroit', NULL),
('2016000052', '2016000056', 'visite médicale d''embauche', '', '', NULL, '', 'ras', 'ras', 'dermobacter solution\ncinet cp', '', '20160113000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113090721000254', '20160113090726000511', '1', 'ras', 'ddr:05-01-2016 G5P4V4A1\nalcool occasionnellement\n', 'mère hypertendu', 'ballonnement abdominal\ndermatose superficielle', NULL),
('2016000053', '2016000057', 'visite médicale d ''embauche', '', 'ras', NULL, '', 'ras', 'ras', 'ras', 'pas d''anomalies', '20160113000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113092006000774', '20160113092011000220', '1', '', 'rhinite allergiques', 'ras', 'ras', NULL),
('2016000054', '2016000058', 'visite médicale systématique,difficultés à la vision de près', 'évolution 1ans', 'ras', NULL, '', 'ras', 'ras', 'pevaryl poudre', 'avis ophtalmologie', '20160113000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113101723000647', '20160113101727000767', '1', 'ras', 'prurit plantaire\nIMC=35obésité gastrite connu depuis de 20ans sous anti H2', 'mère hypertendu', 'intertrigo inter digitaux', NULL),
('2016000055', '2016000060', 'polyarthralgies,sensation de fièvre vespérale', 'évoluant depuis 1 semaine', 'accès palustre simple???\nrhumatisme???', NULL, 'NFS,VS,CRP,GE.WIDAL?ASLO,ionograme sanguin', 'ras', 'ras', 'coartem,efferalgan,helmintox,magnoral', '', '20160113000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160113105642000471', '20160113105646000741', '1', 'ras', 'paludisme,fièvre typhoïde', 'ras', 'conjonctives hypocolorés\nlangue saburrales\ndentition cariées par endroit', NULL),
('2016000056', '2016000061', 'douleur épaule drt ', 'évoluant depuis 2mois sans notion de traumatisme', 'entorse de l''épaule drte?\nartrose? Fx de la clavicule drte??', NULL, '', '', 'Rx épaule drte f/p 3/4 ', 'Melonax 7.5', 'entorse de l''épaule drte?\nartrose? Fx de la clavicule drte??', '20160113000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160113142114000780', '20160113142120000008', '1', 'RAS', 'RAS', '', 'sensibilié algique à la mobilisation de l''épaule drte, motricité conservée', NULL),
('2016000057', '2016000062', 'douleur colonne vertébrale,douleur lombaire', 'évolution 1 semaine\nEVA:6/10', 'infections urinaires à investiguer', NULL, 'nfs,vs,crp,pcv+ATB', '', 'échographie pelvienne', 'diclac 75mg, gastro-resistant,oflocet 200mg', '', '20160114000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160114103150000122', '20160114103159000404', '1', 'ras', 'flou visuel,port de lunettes depuis plus de 2 ans\nDDR:11-01-2016,G1P1V1? accouchement par césarienne il y''a 1ans,gastrite ', 'ras', 'conjonctives hypocolorés\nsensibilité algique à la palpation de la région pelvienne', NULL),
('2016000058', '2016000063', 'douleurs dentaires,céphalées,frissons', 'évolution 1 semaines\n', 'syndrome infectieux à porte d''entrée dentaire??\net/ou accès palustre simple', NULL, 'ras', 'ras', 'ras', 'diclac gastro résistant,coartem80/480,clamoxyl 1gcp,métronidazole 500mg cp.', 'avis odonto', '20160114000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160114141140000419', '20160114141147000299', '1', 'ras', 'gastrite traitée à l indigénat,\nDDR:02-01-2016,G0P0V0', 'père diabétique et hypertendu', 'dent cariées par endroit', NULL),
('2016000059', '2016000064', 'nausées,ballonnements abdominales', 'évolution 2jours', 'parasitose digestive??', NULL, 'nfs,vs,crp,glycémie à jeun,examen parasitologique des selles', 'ras', 'ras', '', '', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115082155000261', '20160115082159000099', '1', 'ras', 'hémorroïde depuis l ''enfance,', 'mère diabétique', 'conjonctives pales\nreste de l examen sans particularités', NULL),
('2016000060', '2016000065', 'visite médicale d''embauche', 'ras', '', NULL, 'bilan visite médicale d''embauche', 'ras', 'ras', 'aucun', '', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115091215000667', '20160115091220000191', '1', 'ras', 'alcool occasionnellement\nmarié père de 2 enfants tous vivants', 'père diabétique et hypertendu', 'examen physique sans particularités', NULL),
('2016000061', '2016000066', 'visite médicale systématique', 'ras', '', NULL, '', 'ras', 'ras', 'helmintox 750mg ,oflocet 200mg', '', NULL, '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115092314000388', '20160115092318000796', '1', 'ras', 'hémorroïde', 'père hypertendu', 'sans particularités', NULL),
('2016000062', '2016000067', 'V.M.E', 'RAS', '', NULL, 'bilan V.M.E', 'ras', 'radio du thorax (f)', 'aucun', '', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115162800000206', '20160115162804000055', '1', 'ras', 'gastrique connu depuis plus de 5ans', 'ras', 'sans particularités', NULL),
('2016000063', '2016000068', 'V.M.E', 'ras', 'ras', NULL, 'ras', 'ras', 'rx du thorax(f)', 'ras', 'ras', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115164146000943', '20160115164151000424', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000064', '2016000069', 'V.M.E', 'ras', 'ras', NULL, 'bilanVME', '', 'RADIO DU THORAX (f)\néchographie testiculaire', 'aucun', '', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115164820000946', '20160115164825000683', '1', 'ras', 'ras', 'ras', 'hernie scrotal évoluant depuis l''enfance', NULL),
('2016000065', '2016000070', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', 'ras', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115165855000900', '20160115165901000089', '1', 'ras', 'paludisme\nalcool occasionnellement', 'ras', 'ras', NULL),
('2016000066', '2016000071', 'VME', 'ras', '', NULL, 'bilan VME', '', 'radio du thorax (f)', 'ras', '', '20160115000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160115170615000495', '20160115170620000994', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000067', '2016000072', 'émission de selles liquides glairo-sanguinolantes,douleurs abdominales', 'évolution 1 jour\nsous efferalgan cp\n', 'toxi infection alimentaire???\ndysenterie amibienne???', NULL, 'nfs, vs, GE,examen parasitologue des selles,\nwidal,glycémie à jeun', '', '', 'metro,ciprodyne,spasfon,sro', '', '20160118000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118112345000752', '20160118112349000387', '1', 'ras', 'lombalgie depuis plus 2 ans sous AINS\nréchauffement plantaire,\npyrosis', 'ras', 'faciès pale,', NULL),
('2016000068', '2016000073', 'visite médicale systématique', '', '', NULL, 'bilan VME', 'visiotest', 'ras', 'ras', '', '20160118000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118113602000100', '20160118113605000596', '1', 'ras', 'ras\nIMC35 obésité', 'ras\n', 'sans particularités', NULL),
('2016000069', '2016000075', 'V.M.E', '', '', NULL, '', 'ras', 'radio du thorax (f)', 'ras', '', '20160118000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118134702000849', '20160118134707000903', '1', 'ras', 'ras', 'ras', 'examen physique sans particularités', NULL),
('2016000070', '2016000074', 'douleur au niveau du rachis dorsal', 'évoluant depuis 2semaines post traumatique(port de charge lourde lors du déménagement', 'traumatisme fermé du rachis dorsal', NULL, '', '', 'Rx du rachis dorsal', '-en start: diclo inj 1amp IM, analgin 1amp IVDL\n-melonax 7.5\n-tramadol denk', 'traumatisme fermé du rachis dorsal', NULL, '2002', '2016', '1', 'fewane', 'fewane', '20160118135932000429', '20160118135939000395', '1', '', 'RAS', 'diabète(père)', 'sensibilité algique à la palpation de tout le rachis dorsal,limitation des mouvements de la colonne vertébrale', NULL),
('2016000071', '2016000076', 'douleurs abdominales,vomissements,anorexie', 'évolution 1 jour,\n', 'gastro-entérite??', NULL, 'nfs,vs, crp, examen parasitologique des selles,widal goutte des épaisse', 'ras', 'ras', 'spasfon, sro adulte', 'attente résultats examens paracliniques', '20160118000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160118141552000783', '20160118141558000694', '1', 'ras', 'paludisme\njamais déparasité', 'ras', 'sans particularités', NULL),
('2016000072', '2016000077', 'douleur au niveau du dos de la main gche', 'depuis une semaine suite à une plaie au niveau de la base du pouce gche par une brisure de verre', 'traumatisme fermé du pouce post AT il ya une semaine', NULL, '', '', '', 'attèle mise en place \nibuprofène\nprévoir avis du traumatologue', 'traumatisme fermé du pouce post AT il ya une semaine', '20160118000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160118144411000722', '20160118144417000306', '1', 'RAS', 'RAS', '', '', NULL),
('2016000073', '2016000078', 'VME', 'ras', 'ras', NULL, 'ras', 'ras', 'radio du thorax(f)', 'ras', 'patient obèse,mésure hygiéno-diététque', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119083714000719', '20160119083718000744', '1', 'ras', 'ras', 'ras', 'IMC=35 obésité', NULL),
('2016000074', '2016000079', 'V.M.S', 'ras', '', NULL, 'bilan V.M.S', 'ras', 'ras', 'ras', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119091206000034', '20160119091210000397', '1', '', 'myopie(port de lunettes depuis 2ans)\nalcool occasionnellement\n', 'père hypertendu', 'sans particularités', NULL),
('2016000075', '2016000080', 'V.M.E', 'ras', 'ras', NULL, 'bilan V.M.E', 'ras', 'radio du thorax(f)', 'ras', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119101420000707', '20160119101424000185', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000076', '2016000081', 'V.M.E', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax (f)', 'ras', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119102326000541', '20160119102331000143', '1', 'ras', 'gastrite sous traitement non documenté\nalcool occasionnellement', 'ras', 'sans particularités', NULL),
('2016000077', '2016000082', 'VME', 'ras', 'ras', NULL, 'bilan V.M.E', 'ras', 'radio du thorax(f)\nvisiotest', 'ras', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119104529000558', '20160119104534000846', '1', 'ras', 'ras', 'ras', 'examen physique sans particularités', NULL),
('2016000078', '2016000083', 'V.M.E', 'ras', 'ras', NULL, 'bilan V.M.E', 'ras', 'ras', 'ras', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119110039000032', '20160119110044000189', '1', 'ras', 'fièvre typhoïde', 'ras', 'sans ^particularités', NULL),
('2016000079', '2016000084', 'VME', 'RAS', 'RAS', NULL, 'BILAN VME', 'RAS', 'RADIO DU THORAX(F)', 'RAS', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119120752000318', '20160119120755000892', '1', 'IMPOTENCE FONCTIONNELLE BRAS GAUCHE POST A.T DEPUIS 2008', 'SCOLIOSE DORSALE\nALCOOL OCCASIONNELLEMENT', 'RAS', 'EXAMEN PHYSIQUE SANS PARTICULARITÉS', NULL),
('2016000080', '2016000085', 'VME', 'RAS', 'RAS', NULL, 'BILAN V.M.E', 'RAS', 'RADIO DU THORAX(F)', 'RAS', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119131026000006', '20160119131030000207', '1', 'RAS', '\n3 BIÈRES PAR JOUR', 'MÈRE DIABÉTIQUE', 'SANS PARTICULARITÉS', NULL),
('2016000081', '2016000086', 'VME', 'RAS', 'RAS', NULL, 'BILAN VME', 'RAS', 'RADIO DU THORAX(F)', 'REFUS PANSEMENT,CLOXACILLINE GEL', 'RAS', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119134607000272', '20160119134612000424', '1', 'RAS', 'RAS', 'RAS', 'PLAIES DU GLAND DU PÉNIS\nAUTOMÉDICATION NON DOCUMENTÉE ÉVOLUANT DEPUIS 2 JOURS', NULL),
('2016000082', '2016000087', 'V.M.E', 'RAS', 'RAS', NULL, 'BILAN V.M.E', 'RAS', 'RADIO DU THORAX(F)', 'RAS', '', '20160119000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160119135450000812', '20160119135455000442', '1', 'RAS', 'ALCOOL OCCASIONNELLEMENT', 'RAS', 'SANS PARTICULARITÉS', NULL),
('2016000083', '2016000088', 'VME', '', 'surpoids IMC:28.34\nHTA de Novo grade 2', NULL, '', '', 'RX du thorax', 'mesures hygieno-diététiques\nrégime hypododé\nLOPINE 5mg\nbilan:ECG,ionogramme sanguin(Na,K,Cl), urée/créat, profil lipidique', 'RDV le 20/01/16 pour suivi', '20160119000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160119145045000375', '20160119145050000589', '1', '', 'alcool:3bières/semaine', '', 'pannicule adipeux important ', NULL),
('2016000084', '2016000089', 'visite médicale systématique', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'ras', 'ras', '', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120083331000082', '20160120083334000826', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000085', '2016000090', 'tumefaction douloureuse sous le menton', 'évolution plus de 3 jours', 'abcès non collecté??', NULL, 'ras', 'ras', 'ras', 'soclav 1g\nvoltfast', '', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120084607000081', '20160120084625000817', '1', 'ras', 'ras', 'ras', 'masse ferme palpable douloureuse sous le menton', NULL),
('2016000086', '2016000091', 'V.M.E', 'ras', 'ras', NULL, 'bilan V.M.E', 'ras', 'Ras', 'ras', 'ras', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120095410000482', '20160120095417000099', '1', 'ras', 'alcool occasionnellement\ncélibataire père d''un enfant vivant', 'ras', 'sans particularités', NULL),
('2016000087', '2016000092', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ketum gel', 'ras', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120113455000558', '20160120113459000281', '1', 'ras', 'fumeur 1PA depuis  2 ans\ncélibataire père de 2 enfants tous vivants\nlombalgie posturale', 'ras', 'sans particularités', NULL),
('2016000088', '2016000093', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', 'ras', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120114103000455', '20160120114107000023', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000089', '2016000094', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax\nvisiotest', 'ras', '', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120115633000410', '20160120115637000000', '1', 'ras', 'gastrite sous phosphalugel\ncélibataire père d''un enfant\nalcool occasionnellement', 'ras', 'ras', NULL),
('2016000090', '2016000095', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', '', '20160120000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160120121730000651', '20160120121734000663', '1', 'ras', 'alcool occasionnellement\ncélibataire sans enfants', 'ras', 'ras', NULL),
('2016000091', '2016000096', 'céphalées, cervicalgies', 'le patient aurait reçu des coups de poing d''un collègue sur la nuque et le scalp au cours d''une dispute ce jour aux environs de 12h30 à l''extérieur de l''entreprise', 'contusion cervicale post traumatique ', NULL, '', '', '', 'RALDOL 1cpx3/jr si douleur', 'contusion cervicale post traumatique ', NULL, '2002', '2016', '1', 'fewane', 'fewane', '20160120141207000128', '20160120141212000102', '1', 'RAS', 'RAS', 'RAS', 'BEG chez patient conscient\ntuméfaction discrète au niveau de la nuque associée à une sensibilité algique à la palpation\nlimitation des mouvements du cou', NULL),
('2016000092', '2016000097', 'plaies du membre superieur gauche et inferieur droit post AVP', 'évolution 3 heures', 'traumatisme du membre sup post AVP', NULL, 'nfs, vs,crp', 'ras', 'radio du du bras droit (f/p)', 'diclofenac injectable,diclofenac cp,ketum gel,miorel ', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121095634000536', '20160121095638000514', '1', 'ras', 'ras', 'ras', 'multiples écorchures membre superieur gauche et inférieur droit\nimpotence fonctionnelle relative bras droit\nfm cotée à 2/5\nsensibilité coservée au bras droit', NULL),
('2016000093', '2016000098', 'sensation de froid,douleurs articulaires', 'évolution 3 jours', 'accès palustre simple???\nsalmonellose??', NULL, 'nfs vs ,crp,GE,widal', 'ras', 'ras', 'doliprane 1000cp,zoflox 750cp,', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121101415000084', '20160121101420000060', '1', 'ras', 'paludisme', 'ras', 'sans particularités', NULL),
('2016000094', '2016000099', 'asthénie physique,anorexie ,douleurs abdominales,sensation d froid', 'évolution 3jours\nautomédication:efferalgan,bactrim,zentel', 'sepsis à porte d ''entrée urinaire??\naccès palustre simple???', NULL, 'nfs vs GE ecbu+atb ,serologie clamydiae,widal,coprologie', 'ras', 'ras', 'efferalgan 1000 cp', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121102901000666', '20160121102905000659', '1', 'ras', 'fièvre thyphoide\n', 'ras', 'sans particularités', NULL),
('2016000095', '2016000100', 'douleur dans le dos,douleurs articulaires,céphalées', 'évolution plus d''1 semaine\nautomédication non documentée', 'lombalgo\naccès palustre simple', NULL, 'nfs,vs, crp GE', 'ras', 'ras', 'cofantrine\nozapral\nmagnoral\ngebedol', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121112228000698', '20160121112233000581', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000096', '2016000101', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121114122000337', '20160121114126000019', '1', 'ras', 'gastrite\nalcool: 3 bières/jours', 'ras', 'ras', NULL),
('2016000097', '2016000102', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160121170843000843', '20160121170846000740', '1', 'ras', 'impotence fonctionnelle relative main gauce:électrocution dans l enfance', 'ras', 'sans particularités', NULL),
('2016000098', '2016000103', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax\nvisiotest', 'ras', 'ras', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122082418000800', '20160122082423000449', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000099', '2016000104', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122083227000471', '20160122083231000371', '1', 'ras', 'alcool:occasionnellement\ntabac:1 PA pendant 8ans,arret il ya 1ans', 'ras', 'sans particularités', NULL),
('2016000100', '2016000105', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax ', 'ras', 'ras', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122083617000443', '20160122083621000343', '1', 'ras', 'alcool:occasionnellement', 'ras', 'sans particularités', NULL),
('2016000101', '2016000106', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122084217000078', '20160122084221000275', '1', '', 'handicap main gauche ,impotence fonctionnelle relative main gauche suite à une électrocution dans l enfance', 'ras', 'sans particularités', NULL),
('2016000102', '2016000107', 'VME', 'RAS', 'RAS', NULL, 'BILAN VME', 'RAS', 'RADIO DU THORAX', 'RAS', 'RAS', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122084524000046', '20160122084528000055', '1', 'RAS', 'RAS', 'RAS', 'DENTS CARIEES PAR ENDROIT', NULL);
INSERT INTO `tab_cpte_rendu_consul` (`COD_CPTE_RENDU_CONSUL`, `COD_CONSUL`, `LIB_MOTIF_CONSUL`, `LIB_HIS_MAL`, `LIB_DIAG_PRIN`, `LIB_DIAG_SENC`, `LIB_EXAM_BIO`, `LIB_EXPLO_FONC`, `LIB_EXAM_IMAG`, `LIB_TRAIT_PRES`, `LIB_CONCL`, `DAT`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_VAL`, `LIB_ANTE_PRO`, `LIB_ANTE_PERSO`, `LIB_ANTE_FAMI`, `LIB_EXAM_PHY`, `TYP_VIS_MED_SRC`) VALUES
('2016000103', '2016000108', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'sekisan sirop', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122085222000688', '20160122085226000339', '1', 'lombalgie mécanique depuis plus de 2 ans post AT.sous traitement non documenté', 'tabac: 1PAdepuis 34 ans \nalcool: 2-3 bières par jour\ntoux grasse évoluant depuis plus d ''1 semaine', 'ras', 'sans particularités', NULL),
('2016000104', '2016000109', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'ras', 'ras', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122085733000628', '20160122085736000873', '1', 'ras', 'alcool:occasionnellement', 'ras', 'ras', NULL),
('2016000105', '2016000110', 'VMS', 'ras', 'RAS', NULL, 'bilan VMS', 'RAS', 'RADIO DU THORAX', 'OZAPRAL 30MG', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122090139000775', '20160122090216000808', '1', 'RAS', 'GASTRITE,AUTOMEDICATION NON DOCUMENTEE', 'RAS', 'RAS', NULL),
('2016000106', '2016000111', 'VME', 'RAS', 'RAS', NULL, 'RAS', 'RAS', 'RADIO DU THORAX', 'RAS', 'RAS', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122090920000087', '20160122090924000952', '1', 'RAS', 'RAS', 'RAS', 'SANS PARTICULARITES', NULL),
('2016000107', '2016000112', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122104309000505', '20160122104313000742', '1', 'ras', 'alccol:oocasionnellement', 'père diabétique', 'sans particularités', NULL),
('2016000108', '2016000113', 'céphalées,sensation de froid', 'évolution 3jours\nautomédication à l indigenat', 'accès palustre simple', NULL, 'nfs,vs,crp,GE,widal,coprologie', 'ras', 'ras', 'coartem,efferalgan 1000,helmintox ', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122105116000203', '20160122105120000356', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000109', '2016000114', 'douleur thoracique à l inspiration,plaies au niveau u poignet', 'évolution 3 mois\n', 'pneumopathie d ''inhalation???', NULL, 'nfs vs crp', 'ras', 'radio du thorax(f/p)', 'sovlav 1g,diclofenac 75mg', 'ras', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122110536000274', '20160122110540000604', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000110', '2016000115', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122111808000103', '20160122111812000244', '1', 'ras', 'alcool:occasionnellemnt', 'ras', 'sans particularités', NULL),
('2016000111', '2016000116', 'VME', '', 'RAS', NULL, 'RAS', 'RAS', 'RADIOO DU THORAX ', 'RAS', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122112459000342', '20160122112502000887', '1', 'RAS', 'ALCOOL OCCASIONNELLEMENT', 'RAS', 'SANS PARTICULARITES', NULL),
('2016000112', '2016000117', 'VME', 'RAS', 'RAS', NULL, 'BILAN VME', 'RAS', 'RADIO DU THORAX', 'RAS', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122113534000284', '20160122113539000040', '1', 'RAS', 'HERNIE OMBILICALE ET APPENDICECTOMIE IL Y''A PLUS D 20ANS', 'RAS', 'SANS PARTICULARITés', NULL),
('2016000113', '2016000118', 'VME', 'RAS', 'RAS', NULL, 'BILAN VME', 'RAS', 'RADIO DU THORAX', 'RAS', 'RAS', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122114210000295', '20160122114214000558', '1', 'RAS', 'ALCOOL:OCCASIONNELLEMENT', 'RAS', 'SANS PARTICULARITÉS', NULL),
('2016000114', '2016000119', 'PLAIES DES DOIGTS DE LA MAIN GAUCHE', 'EVOLUTION 1 HEURE', 'TRAUMATISME OUVERT DES 3 DERNIERS DOIGTS DE LA MAIN GAUCHE POST AT', NULL, 'RAS', 'RAS', 'RAS', 'PANSEMENT,SUTURE DE L AURICULAIRE ;SAT INJECTABLE,CLOXACILLINE GELLULE,DICLOFENAC 50MG', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122124848000522', '20160122124852000903', '1', 'RAS', 'RAS', 'RAS', 'PLAIES DE L AURICULAIRE,DU MAJEUR ET DE L ANNULAIRE GAUCHE', NULL),
('2016000115', '2016000120', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'visiotest', 'sovlav,voltfast', '', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122131936000556', '20160122131942000537', '1', 'ras', 'ras', 'ras', 'abcès au niveau du pubis,évoluant dépuis 2jours', NULL),
('2016000116', '2016000122', 'céphalées,sensation de froid', 'évolution 2jours sans auto médication', 'accès palustre simple?', NULL, 'ras', 'ras', 'ras', 'cofantrine,helmintox,doliprane', '', '20160121000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122132853000682', '20160122132858000472', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000117', '2016000123', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'RAS', 'RADIO DU THORAX,ECG', 'pevaryl pourdre', 'avis cardio', '20160122000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160122152841000799', '20160122152845000731', '1', 'ras', 'DDR:29-12-2015 G1P1V1A0\ncélibataires mère d"1b enfant d ''un an 10mois\npalpitations avec sensation d''essouflement depuis plus d''un ans', 'ras', 'dentition incomplète,dents cariées par endroit\nvergétures visibles sur l ''abdomen\nintertrigo interdigitaux', NULL),
('2016000118', '2016000124', 'VMS', '', 'obésité IMC 30.35\nHTA grade 1', NULL, '', '', 'visiotest', 'mesures hygiénodiététiques\nrégime hyposodé', 'obésité IMC 30.35\nHTA grade 1\nRDV le 05/02/16 pour suivi\n', '20160123000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160123094104000105', '20160123094108000988', '1', 'traumatisme fermé du poignet gche post AT platre en place depuis le 21/12/15', 'RAS', 'RAS', 'panicule adipeux important\nle reste sans particularité', NULL),
('2016000119', '2016000125', 'VMS', '', 'sd grippal', NULL, '', '', 'visiotest', 'litacold 2cpx2/jr', 'sd grippal', '20160123000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160123095026000158', '20160123095030000433', '1', 'RAS', 'hemorroides depuis 2ans traitement non documenté', 'RAS', 'sans particularité ce jour', NULL),
('2016000120', '2016000126', 'morsure par un chien', 'ce jour aux environs de 08h dans la cour de l''entreprise', 'griffure par un chien dont le statut vaccinal est inconnu', NULL, '', '', '', 'asepsie à la bétadine jaune\nSAT à faire\nvaccin rabique à faire', 'griffure par un chien dont le statut vaccinal est inconnu', '20160123000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160123103156000961', '20160123103209000101', '1', 'RAS', 'DDR 13/01/16', '', 'trace de griffure au niveau du flanc gche et de la face antérieur de la jambe drte ', NULL),
('2016000121', '2016000127', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', '', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125073825000004', '20160125073830000012', '1', 'ras', 'gastrite sous cimétidine\nalcool occasionnellement', 'ras', 'sans particularités', NULL),
('2016000122', '2016000128', 'VME', 'RAS', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', '', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125075005000763', '20160125075013000220', '1', 'ras', 'rhinite allergique\nherniorraphie inguinale bilatérale le 26-03-2014', 'ras', 'ras', NULL),
('2016000123', '2016000129', 'VMS', 'RAS', 'ras', NULL, 'bilan VMS', 'ras', 'ras', 'daflon cp\nozapral', '', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125081718000565', '20160125081722000200', '1', 'ras', '1PA cigarettes pendant plus de 10 ans,arrét il y''a 10 ans\nalcool occasionnellement\nhémorroide sous traitement non documenté\ngastrite\ndifficulté à la lecture \ndifficultés érectile', 'ras', 'ras', NULL),
('2016000124', '2016000130', 'douleurs abdominales,diarrhées', 'évolution 3jours,après ingestion de la viande de porc pimentée,\nautomédication métronidazole 3cp par 3 par jour', 'toxi infection alimentaire', NULL, 'ras', 'ras', 'ras', 'zofox cp\ncontinuer metro 1cp matin et soir\nnealgyl cp ', '', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125084345000282', '20160125084349000351', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000125', '2016000131', 'douleurs abdominales,notion émission de selles glairo- sanguinolentes,céphalées', 'évolution 4jours\nrémission incomplètes des symptômes sous flagyl cp en automédication', 'dysentérie amibienne???', NULL, 'ras', 'ras', 'ras', 'continuer flagyl\ndoliprane\nescodyne', '', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125090641000764', '20160125090646000221', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000126', '2016000132', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax(f)', 'ras', 'councellings', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125104619000250', '20160125104625000340', '1', 'ras', 'herniorraphie inguinale droite il ya plus de 20ans\ntabac:1 PA depuis 4 ans\nIMC=36 obésité\n', 'ras', 'ras', NULL),
('2016000127', '2016000133', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'visiotest', 'ras', 'ras', '20160125000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160125111226000256', '20160125111230000202', '1', 'ras', 'tabac:1PA pendant plus de 7ans\nalcool:1 casier/semaine\ngastrite', 'ras', 'sans particularités', NULL),
('2016000128', '2016000135', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'visiotest', 'dermobacter solution\nozapral cp\n', 'avis chirurgie pour hemorroidectomie', '20160126000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126095753000716', '20160126095757000366', '1', 'ras', 'HTA connu depuis plus de 5 ans sous aldamet\nhemorroides externes \ngastrite non suivi\nbaisse de l acuité visuelle \nIMC=31 \ndermatose superficielle', 'ras', 'bourrelet hémorroïdaire visible au niveau de la marge anale\n\n', NULL),
('2016000129', '2016000136', 'VMS', 'ras', 'ras', NULL, 'bilan VMS,nfs crp,bilan lipidique, glycémie à jeun,ionogramme sanguin ,uréé creat,transaminases', 'ras', 'visiotest', 'ozapral\nclamoxyl\nclarithromycine', '', '20160126000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126100624000198', '20160126100627000796', '1', 'ras', 'G4P3V3A1  DDR:12 01 2016\nIMC =31 obésité\nnotion de chute de sa hauteur avec perte de connaissances il y''a environ 2 semaines\n', 'ras', 'sensibilité algique à la palpation de l''épigastre', NULL),
('2016000130', '2016000137', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'visiotest', 'ras', '', '20160126000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126101943000961', '20160126101947000459', '1', 'ras', 'douleur lombaire,gastrite sous almax,\nhemorroides externes\nconstipation chronique', 'ras', 'ras', NULL),
('2016000131', '2016000138', 'douleur lombaire', 'évolution 1 semaine', 'lombalgo??', NULL, 'nfs vs crp ', 'ras', 'ras', 'diclofenac injectable\ndiclofenac cp\nlysoflam gel', '', '20160126000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126102612000788', '20160126102616000111', '1', 'ras', 'ras', 'ras', 'examen physique sans particularités', NULL),
('2016000132', '2016000139', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'RAS', 'visiotest', 'ozapral', '', '20160126000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160126104612000202', '20160126104615000809', '1', 'ras', 'gastrite non suivi\nalcool occasionnellement', 'ras', 'ras', NULL),
('2016000133', '2016000140', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax', 'ras', '', '20160127000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127164534000500', '20160127164538000525', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000134', '2016000141', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax\nvisiotest\nelectrocardiogramme', 'ras', 'mesures hygiéno diététique', '20160127000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127165033000928', '20160127165037000790', '1', 'ras', 'IMC=31 obésité\nostéosynthèse pied gauche en 1999', 'ras', 'cicatrise visible pieds gauche\nreste de l''examen sans particularités', NULL),
('2016000135', '2016000142', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax\nECG\nvisiotest', 'sous traitement à base d''amoxicilline et de métronidazole', 'continuer traitement en cours plus pansement alcoolisé', '20160127000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127165647000311', '20160127165651000024', '1', 'ras', 'asthmatique sous ventoline\n\n', 'ras', 'abcès non collecté pli du coude droit et cuir chevelu,', NULL),
('2016000136', '2016000143', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', 'mésures hygiéno diététiques', '20160127000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127170134000008', '20160127170137000768', '1', 'ras', 'DDR=25-01-2016   G1P1V1A0\ngastrite\nIMC=28', 'ras', 'sans particulmarités', NULL),
('2016000137', '2016000144', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ozapral', '', NULL, '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160127170709000253', '20160127170712000794', '1', 'ras', 'colopathie fonctionnelle non documentée\nDDR=01-01-2016 G5P4V4A1\ngastrite non suivi', '\nras', 'sensibilité algique à la palpation du flanc gauche', NULL),
('2016000138', '2016000145', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'visiotest', 'ras', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128090415000813', '20160128090420000502', '1', 'ras', 'alcool occasionnellement\nport de lunettes(difficulté à la lecture)\n', 'ras', 'sans anomalies', NULL),
('2016000139', '2016000146', 'VMS', '', 'HTA grade 2??', NULL, '', '', 'visiotest\nECG\nRx du thorax', 'mesures hygienodiététiques\nrégime hyposodé\nbilan:profil lipidique,uréé/créat, ASAT/ALAT, ionogramme sanguin(Na,Cl,K)\nRDV le 05/02/16', '', '20160128000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160128093219000962', '20160128093224000528', '1', 'RAS', 'alcool: occasionnellement\nhypermetropie??port de lunette depuis 1an', 'HTA chez le petit frère DCD', 'obésité IMC 31.14\n', NULL),
('2016000140', '2016000147', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax ,échographie pelvienne', 'ras', 'consultation cardio', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128102310000921', '20160128102316000459', '1', 'ras', 'gastrite sous maalox\nDDR+20-01-2016,G0PO\nnotion d ''OMI,IMC=29 surpoids', 'ras', 'sensibilité algique à la palpation de l hypogastre', NULL),
('2016000141', '2016000148', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax', 'ras', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128103400000702', '20160128103406000900', '1', 'ras', 'DDR 13-01-16,G0P0\nalcool occasionnellement\n', 'ras', 'dentition incomplète dents cariées par endroits', NULL),
('2016000142', '2016000149', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax\nelectrocardiogramme\nvisiotest', 'ras', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128104710000489', '20160128104714000415', '1', 'ras', 'port de lunettes(vision double)\ngastrite sous maalox\nport de lunettes (vertiges,vision double)', 'ras', 'sans anomalies', NULL),
('2016000143', '2016000150', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'RAS', 'RADIO DU THORAX', 'escodyne cp', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128110406000507', '20160128110410000308', '1', 'ras', 'DDR=(1er jour 24-01-16) G3P3V2A1\nIMC=39 Obésité', 'ras', 'sans anomalies', NULL),
('2016000144', '2016000151', 'notion de vomissements,céphalées,polyarthralgies lombalgies', 'évolution 2 jours²', 'APS = salmonellose?? \n ', NULL, 'nfs,vs,crp, GE, widal,glycémie a\nà jeun ,coprologie', 'ras', 'ras', 'duo cotexin\nefferalgan ', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128121437000004', '20160128121442000077', '1', 'RAS', 'alcool occasionnellement\n', 'ras', 'sans particularités', NULL),
('2016000145', '2016000152', 'céphalées, frissons', 'évoluant depuis quelques heures', 'accès palustre simple', NULL, 'nfs, vs,GE,WIDAL,glycémie à jeun,examen des selles', 'ras', 'ras', 'coartem\nefferalgan \nhelmintox', '', '20160128000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160128130945000317', '20160128130949000569', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000146', '2016000153', 'VME', 'RAS', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', 'patient âgé de sexe masculin et obèse\navis cardiologie\ncouncelling', '20160201000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201152717000591', '20160201152724000001', '1', 'ras', 'IMC=35 obésité\n', 'mère diabétique et hypertendu', 'ras', NULL),
('2016000147', '2016000154', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio du thorax', 'ras', '', '20160201000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201153736000003', '20160201153739000753', '1', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000148', '2016000155', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'RAS', 'RADIO DU THORAX\nvisiotest\nECG', 'ras', 'HTA grade 1??', '20160201000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201155218000307', '20160201155221000905', '1', 'ras', 'tabac 1PA pendant 7ans,arrêt il y''a 4 ans\n', 'ras', 'ras', NULL),
('2016000149', '2016000156', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', 'pas d''anomalies', '20160201000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160201160535000011', '20160201160538000300', '1', 'ras', 'alcool occasionnellement', 'ras', 'ras', NULL),
('2016000150', '2016000157', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', 'pas d''anomalies', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202081042000505', '20160202081049000041', '1', 'ras', 'alcool occasionnellement', 'ras', 'ras', NULL),
('2016000151', '2016000158', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', 'IMC =33 obésité', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202091257000276', '20160202091302000487', '1', 'ras', 'tabac 1PA depuis plus de 10ans\nalcool 3 bières /semaine\nrhinites allergiques\nmyopie(port de lunettes)', 'ras', 'examen physique sans particularités', NULL),
('2016000152', '2016000159', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'RAS', 'radio du thorax (f)', 'ras', '', NULL, '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202092836000762', '20160202092840000490', '1', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000153', '2016000160', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax', 'ras', 'pas d''anomalies', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202094657000610', '20160202094701000323', '1', 'ras', 'alcool occasionnellement\n', 'mère diabétique', 'sans particularités', NULL),
('2016000154', '2016000161', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', '', NULL, '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202101253000496', '20160202101257000577', '1', 'ras', 'alcool occasionnellement', 'mère diabétique', 'ras', NULL),
('2016000155', '2016000162', 'VMS', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'radio thorax', 'ras', '', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202111454000612', '20160202111500000310', '1', 'ras', 'alcool occasionnellement\ntabac 1PA depuis plus d''un an', 'ras', 'ras', NULL),
('2016000156', '2016000163', 'VMS', 'ras', '', NULL, 'bilan VMS', 'eas', 'radio du thorax\nvisiotest\nECG', 'ras', '', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202113018000433', '20160202113021000981', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000157', '2016000164', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax(f)', 'ras', '', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202114338000710', '20160202114342000949', '1', 'ras', 'ras', 'ras', 'sans particularités', NULL),
('2016000158', '2016000165', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax ', 'ras', '', '20160202000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160202115113000926', '20160202115118000495', '1', 'ras', 'fracture de la jambe droite il y''a plusieurs années', 'ras', 'cicatrice post osteosynthèse visible sur la face antérieure de la jambe droite ', NULL),
('2016000159', '2016000166', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax ', 'ras', '', '20160202000000000000', '2000', '2016', '1', 'fpatrick', NULL, '20160202115617000922', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000160', '2016000167', 'VME²', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', '', '20160206000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160206091143000006', '20160206091146000781', '1', 'ras', 'tabac arret il ya 1 ans,1 PA pendant plus de 10ans\nalcool occasionnellement', 'ras', 'ras', NULL),
('2016000161', '2016000168', 'VME', 'ras', 'ras', NULL, 'bilan VME', 'ras', 'ras', 'ras', '', '20160206000000000000', '2002', '2016', '1', 'fpatrick', 'fpatrick', '20160206094751000552', '20160206094755000780', '1', 'ras', 'DDR 07-01-2016 GOPOVO', 'ras', 'ras', NULL),
('2016000162', '2016000169', 'VME', 'ras', 'ras', NULL, 'bilan VME²', 'ras', 'ras', 'ras', 'ras', '20160206000000000000', '2000', '2016', '1', 'fpatrick', NULL, '20160206101518000459', NULL, '0', 'ras', 'alcool 1 biere par semaine', 'ras', 'ras', NULL),
('2016000163', '2016000170', 'VMS', 'ras', 'ras', NULL, 'bilan VMS', 'ras', 'radio du thorax', 'raqs', '', '20160212000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160212080635000861', '20160212080640000853', '1', '', 'ras', 'ras', 'normal', NULL),
('2016000164', '2016000177', 'douleur abdominale ', 'Début survenu il y''a un jour après ingestion d''aliments associé à des vomissements alimentaires', '', NULL, 'selles, NFS', '', '', 'flagyl 500mg cp et metro 500mg cp', 'Intoxication alimentaire ', '20160222000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222105341000000', '20160222105346000366', '1', 'ras', 'Dypepsie', 'ras', 'sensibilté épigastrique, dicrète sensibilité à la région ombilicale et à la FID', NULL),
('2016000165', '2016000178', 'douleur abdominale ', 'Douleur épigastrique survenue depuis deux semaines non  améliorée après traitement', 'UGD', NULL, '', '', '', 'Phosphalugel sachets,  gaspral 20mg cp', 'UGD', NULL, '2002', '2016', '1', 'fewane', 'fewane', '20160222112004000176', '20160222112008000919', '1', 'ras', 'Alcool,  épigastralgie, G1P000  DDR= 18/11/2015,   Age gestationnel= 10SA+5j', 'ras', 'sensibilité épigastrique', NULL),
('2016000166', '2016000179', 'VMS', '', '', NULL, '', '', '', '', 'Examen physique normal', '20160202000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222112636000254', '20160222112647000956', '1', '', 'lombalgie', 'ras', 'normal', NULL),
('2016000167', '2016000180', 'VMS', '', '', NULL, '', '', '', '', 'Examen physique noormal', '20160222000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222113127000861', '20160222113132000931', '1', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000168', '2016000181', 'pollakyurie, nycturie', 'depuis plusieurs jours', 'cystite probable', NULL, 'B.U, NFS', '', '', '', 'Examen physique normal', '20160222000000000000', '2000', '2016', '1', 'fewane', NULL, '20160222114615000706', NULL, '0', 'ras', 'Alcool,  Hemmoroides', 'ras', 'normal', NULL),
('2016000169', '2016000182', 'douleur dentaire', '', 'Carrie dentaire', NULL, '', '', '', '', 'Apte', '20160222000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222115126000257', '20160222115130000843', '1', 'ras', 'ras', 'ras', 'normal', NULL),
('2016000170', '2016000183', 'VMS', 'aucun', '', NULL, '', '', '', 'ras', 'HTA modérée', '20160222000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222120533000219', '20160222120536000978', '1', 'ras', 'HTA connu depuis un an , lombalgie chronique', 'HTA, Diabète', 'Assourdissements des bruits du coeur', NULL),
('2016000171', '2016000184', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160222000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160222120939000232', '20160222120945000238', '1', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000172', '2016000185', 'VMS', 'douleur épigastrique depuis 3 jours', '', NULL, '', '', '', '', ' UGD et Valvulopathie probable', '20160202000000000000', '2002', '2016', '1', 'fewane', 'fewane', '20160223104311000931', '20160223104444000985', '1', 'ras', 'Epigastralgie depuis 3 ans', 'ras', 'souffle systolique au foyer pulmonaire', NULL),
('2016000173', '2016000186', 'vms', 'ras', '', NULL, '', '', '', '', 'Examen physique Normal', '20160202000000000000', '2000', '2016', '1', 'fewane', 'fewane', '20160223105005000956', '20160223105026000111', '0', 'ras', 'Alcool, Tabac', 'ras', 'ras', NULL),
('2016000174', '2016000187', 'VMS', 'ras', '', NULL, '', '', '', '', 'pityriasis versicolor', '20160202000000000000', '2000', '2016', '1', 'fewane', NULL, '20160223111514000066', NULL, '0', 'ras', 'ras', 'ras', 'macules squameuses et jaunâtres', NULL),
('2016000175', '2016000188', 'VMS', '', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160202000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224082301000259', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000176', '2016000189', 'VMS', 'ras', 'Hypertension modérée chez patient Obèse', NULL, '', '', '', '', 'Consultation cardiologie', '20160202000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224092701000170', NULL, '0', 'ras', 'Epigastralgie,  Lombalgie, Alcool, ', 'HTA et diabète ', 'Obésité androide', NULL),
('2016000177', '2016000190', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160202000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224094704000388', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000178', '2016000191', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160202000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224095148000653', NULL, '0', '', 'Douleur à l''épaule droit depuis 3 mois, Alcool', 'ras', 'ras', NULL),
('2016000179', '2016000192', 'VMS', 'ras', 'Examen physique  normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224095933000388', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000180', '2016000193', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224102838000920', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000181', '2016000193', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224105149000367', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000182', '2016000194', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224105900000392', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000183', '2016000195', 'palpitation  et cervicalgie', 'Début il y''a une semaine associés à des vertiges rotatoires', 'Névralgie cervico-faciale probable', NULL, '', '', '', 'Tanganil 500mg, Magnésium B6, Dynapar 50/500 mg', '', '20160224000000000000', '2000', '2016', '1', 'fewane', 'fewane', '20160224110607000109', '20160224111833000993', '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000184', '2016000196', 'Oeil rouge douleureux', 'depuis 2 jours associé à un écoulement de sérosité', 'Conjonctivite bactérienne', NULL, '', '', '', 'Sterdex, Indocollyre et repos de 02 jours', '', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224113636000806', NULL, '0', 'ras', 'ras', 'Père  diabétique', 'ras', NULL),
('2016000185', '2016000197', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224115027000343', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000186', '2016000198', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224115517000768', NULL, '0', 'ras', 'Epigastralgie, Alcool', 'ras', 'ras', NULL),
('2016000187', '2016000199', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160224000000000000', '2000', '2016', '1', 'fewane', NULL, '20160224120045000634', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000188', '2016000200', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225081208000217', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000189', '2016000201', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225081544000360', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000190', '2016000202', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225081902000629', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000191', '2016000203', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225082414000827', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000192', '2016000204', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', NULL, '2000', '2016', '1', 'fewane', NULL, '20160225084218000049', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000193', '2016000205', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225084507000685', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000194', '2016000206', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225101218000354', NULL, '0', 'ras', 'Alcool, sinusite frontale ', 'ras', 'ras', NULL),
('2016000195', '2016000207', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225101536000265', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000196', '2016000208', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225102048000280', NULL, '0', 'ras', 'ras', 'Obésité, Hypertension artérielle', 'ras', NULL),
('2016000197', '2016000209', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225112528000550', NULL, '0', 'ras', 'Alcool', 'Père hypertendu', 'ras', NULL),
('2016000198', '2016000210', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225112838000030', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000199', '2016000211', 'VMS', 'ras', 'UGD associé une oxyurose probable', NULL, '', '', '', 'Gaspral 20mg cp, Amoxy 500mg cp, metro 500mg cp, helminthox cp', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225113707000519', NULL, '0', 'ras', 'Epigastralgie, Démangeaisons anales, lombalgie, Alcool', 'ras', 'Sensibilité épigastrique', NULL),
('2016000200', '2016000212', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', 'fewane', '20160225114357000899', '20160225114623000111', '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000201', '2016000213', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225115134000158', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000202', '2016000214', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225121143000121', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000203', '2016000215', 'VME', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225121455000880', NULL, '0', 'ras', 'Alcool , tabac', 'ras', 'ras', NULL),
('2016000204', '2016000216', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225122320000322', NULL, '0', 'ras', 'Epigastralgie, Herniorraphie en 2000 pour HID', 'Diabète, HTA', 'ras', NULL),
('2016000205', '2016000217', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225122610000339', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000206', '2016000218', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160223000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225123212000347', NULL, '0', 'ras', 'Alcool, Epigastralgie', 'ras', 'ras', NULL),
('2016000207', '2016000219', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160225000000000000', '2000', '2016', '1', 'fewane', NULL, '20160225123540000413', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000208', '2016000220', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301085634000789', NULL, '0', 'ras', 'Alcool,, Lombalgie', 'ras', 'ras', NULL),
('2016000209', '2016000221', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301090558000690', NULL, '0', 'ras', 'goutte sous Allopurinol, Calcul rénaux, Gastrite,  ', 'ras', 'Nodule goutteux', NULL),
('2016000210', '2016000222', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301091102000760', NULL, '0', 'ras', 'Dépressive post-natal sous Tégrétol, Asthme sous Ventoline et Célestène, Myope depuis l''enfance', 'ras', 'ras', NULL),
('2016000211', '2016000223', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160203000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301093544000880', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000212', '2016000224', 'VMS', 'ras', 'Examen physique', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301100412000964', NULL, '0', 'ras', 'Tabac,  Alcool', 'ras', 'ras', NULL),
('2016000213', '2016000225', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301100931000963', NULL, '0', 'ras', 'Alcool', 'ras', 'ras', NULL),
('2016000214', '2016000226', 'VMS', 'ras', 'Examen physique normal', NULL, '', '', '', '', 'Apte', '20160301000000000000', '2000', '2016', '1', 'fewane', NULL, '20160301101501000337', NULL, '0', 'ras', 'ras', 'ras', 'ras', NULL),
('2016000215', '2016000227', 'Mal de tete', 'RAS', 'Manque de repos', NULL, 'RAS', 'RAS', '', '- Paracetamol 02/jr \n- Massage', 'Repos maladie', '20160603000000000000', '2002', '2016', '1', 'admin', 'admin', '20160603151503000967', '20160603151531000390', '1', 'RAS', 'RAS', 'ras', '', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_cpte_rendu_exam`
--

CREATE TABLE IF NOT EXISTS `tab_cpte_rendu_exam` (
  `COD_CPTE_RENDU_EXAM` varchar(32) NOT NULL DEFAULT '',
  `COD_EXAM` varchar(32) DEFAULT NULL,
  `LIB_RESUL` varchar(1024) DEFAULT NULL,
  `LIB_CONCLU` varchar(1024) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `DAT` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_CPTE_RENDU_EXAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_cpte_rendu_exam`
--

INSERT INTO `tab_cpte_rendu_exam` (`COD_CPTE_RENDU_EXAM`, `COD_EXAM`, `LIB_RESUL`, `LIB_CONCLU`, `BOO_VAL`, `DAT`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('2015000005', '2015000008', 'O+', 'GROUPE SANGUIN  "O" RHESUS POSITIF', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150914105525000280', NULL),
('2015000006', '2015000009', 'NEGATIF', 'Absence d''Anticorps ANTI-Tuberculinique', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150914125029000230', NULL),
('2015000007', '2015000010', '103 mg/dl', 'TAUX DE GLYCEMIE NORMAL', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150914132416000428', NULL),
('2015000008', '2015000011', 'Alb -S -Ph:6,5', 'Urine Normal', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150914133509000174', NULL),
('2015000009', '2015000012', 'NEGATIF', 'Absence d''ANTICORPS ANTI-TUBERCULINIQUE', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150914165046000742', NULL),
('2015000010', '2015000014', '108MG/DL  VN:70-110mg/dl ou 0.70-1.10g/l', 'taux de glycemie normal', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915103153000052', NULL),
('2015000011', '2015000015', 'Alb - S - ', 'URINE  NORMAL', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915104016000590', NULL),
('2015000012', '2015000016', 'TH + :1/160,TO +:1/80,AH +/1/80,co +:1/80', 'Presence d''Anticorps salmonelle TIPHY:TO,TH ET PARA-TIPHY:AH ET CO .', '0', '20150914000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915114759000261', NULL),
('2015000013', '2015000017', '119mg/dl VN:70-110mg/dl ou 0.70-1.10mg/dl', 'TAUX DE GLYCEMIE NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915120339000164', NULL),
('2015000014', '2015000018', 'Alb - S -', 'URINE NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915120921000180', NULL),
('2015000015', '2015000019', 'NEGATIF', 'ABSENCE D''ANTICORPS ANTI-TUBERCULINIQUE', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915122319000385', NULL),
('2015000016', '2015000020', '106mg/dl VN:70-110mg/dl ou 0.70-1.10mg/dl', 'TAUX DE GLYCEMIE  NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915123746000814', NULL),
('2015000017', '2015000021', 'NEGATIF', 'ABSENCE D''ANTICORPS ANTI-TUBERCULINIQUE', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915124531000953', NULL),
('2015000018', '2015000022', 'Alb - S -', 'URINE  NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915125038000589', NULL),
('2015000019', '2015000023', '99mg/dl  VN:70-110mg/dl  ou 0.70-1.10mg/dl', 'TAUX DE GLYCEMIE  NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915125740000669', NULL),
('2015000020', '2015000024', 'NEGATIF', 'ABSENCE D''ANTICORPS ANTI-TUBERCULINIQUE', '1', '20150915000000000000', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915130644000088', '20150915130652000389'),
('2015000021', '2015000025', 'ALB-  S -', 'URINE  NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915131719000091', NULL),
('2015000022', '2015000026', '95mg/dl VN:70 -110mg/dl ou 0.70-1.10mg/dl', 'TAUX DE GLYCEMIE NORMAL', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915133534000896', NULL),
('2015000023', '2015000027', 'NEGATIF', 'ABSENCE D''ANTICORPS ANTI-TUBERCULINIQUE', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915134101000095', NULL),
('2015000024', '2015000028', 'ALB - S -', 'URINE NORME', '0', '20150915000000000000', '2000', '2015', '1', 'kviviane', NULL, '20150915134613000556', NULL),
('2015000025', '2015000029', '130 MG/DL  (VN: 70-110mg/dl)', 'TAUX DE GLYCEMIE ELEVE', '0', '20151021000000000000', '2000', '2015', '1', 'kviviane', NULL, '20151023141429000680', NULL),
('2016000002', '2016000004', '110 mg/dl  post prandial VN:70-110mg/dl', 'normale', '0', '20160104000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160105092058000259', NULL),
('2016000003', '2016000005', '119Mg/dl\nVN:70-110Mg/dl', 'Taux anormal ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108141753000026', '20160108141814000616'),
('2016000004', '2016000006', 'NEGATIF', 'Sérologie SM négative sur détermine\nà confirmer dans 03 mois', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108142620000916', '20160108142740000460'),
('2016000005', '2016000007', 'Ab:-        S:-          PH:8\n\nPH de l''urine:6.5', 'urine basique ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108143847000754', '20160108143855000086'),
('2016000006', '2016000008', '126Mg/dl\n\nVN:70-110Mg-dl', 'Hyperglycémie  ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108144605000635', '20160108144733000752'),
('2016000007', '2016000009', 'Négatif', 'Sérologie SM Négative sur cet échantillon ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108145230000512', '20160108145242000546'),
('2016000008', '2016000010', 'Ab:-               S:-             PH:6.5\n\nPH de l''urine:6.5', 'URINE NORMAL', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108145727000647', '20160108145739000253'),
('2016000009', '2016000011', '131mg/dl\n\nVN:70-110 mg/dl', 'Hyperglycémie ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108152814000122', '20160108152822000962'),
('2016000010', '2016000012', 'Négatif', 'sérologie SM négative sur cet échantillon', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108153653000216', '20160108153700000451'),
('2016000011', '2016000013', 'Albumine:-\nsucre:-\nPH:7         VN:6.5', 'PH neutre ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108154328000521', '20160108154333000751'),
('2016000012', '2016000014', '99 mg/dl\n\nVN: 70-110 mg/dl', 'Glycémie normal ', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108154845000723', '20160108154851000721'),
('2016000013', '2016000015', 'Négatif ', 'Sérologie SM négative sur cet échantillon', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108155210000956', '20160108155216000335'),
('2016000014', '2016000016', 'Albumine: -\nSucre: -\nPH: 7                      VN: 6.5\n', 'PH neutre', '1', '20160108000000000000', '2002', '2016', '1', 'admin', 'admin', '20160108155654000345', '20160108155659000671'),
('2016000015', '2016000018', '117mg/dL                 VN:70-110mg/dL', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111093942000439', '20160111093949000257'),
('2016000016', '2016000019', 'TO: + 1/80                        TH: +1/80\nAO: -                             AH: -\nBO: -                             BH: -\nCO: -                             CH: -\n', 'PRÉSENCE D''ANTICORPRS ANTI SALMONELLA TYPHI ', '0', '20160111000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160111095555000291', NULL),
('2016000017', '2016000020', '119mg/dl          VN: 70-110 mg/dl', '', '0', '20160111000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160111101838000891', NULL),
('2016000018', '2016000021', 'TO:- AO:- BO:-    CO:-\nTH:- AH:- BH:-    CH:-\n\n\n\n\n\n\n\n\n\n\n\n', 'ABSENCE D ANTICORPS ANTI SAMONELLA PARATHYPHI ET TYHPHI', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111102735000095', '20160111102743000660'),
('2016000019', '2016000022', 'ALBUMINE: NEGATIF\nSUCRE:NEGATIF\nPH:8', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111103214000937', '20160111103225000513'),
('2016000020', '2016000023', ' "A" RHESUS: recherche D.U', '', '0', '20160111000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160111103839000852', NULL),
('2016000021', '2016000024', '"A" rhesus:POSITIF', '', '0', '20160111000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160111104337000500', NULL),
('2016000022', '2016000025', '95mg/dl   VN:70-110mg/dl', 'normale', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111104919000752', '20160111104927000630'),
('2016000023', '2016000028', '95mg/dl VN:70-110mg/dl', 'normale', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111105503000462', '20160111105511000059'),
('2016000024', '2016000030', '124mg/dl   VN:70-110mg/dl', 'HYPERGLYCEMIE', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111110346000999', '20160111110356000547'),
('2016000025', '2016000031', '139mg/dl        VN:70-110mg/dl', 'HYPERGLYCEMIE', '0', NULL, '2000', '2016', '1', 'sysgeho', NULL, '20160111110609000529', NULL),
('2016000026', '2016000032', '139mg/dl    VN: 70-110mg/dl', 'HYPERGLYCEMIE', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111110810000762', '20160111110815000832'),
('2016000027', '2016000033', '121 mg/dl     VN:70-110mg/dl', 'hyperglycemie', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111111759000353', '20160111111803000752'),
('2016000028', '2016000035', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111114301000198', '20160111114308000515'),
('2016000029', '2016000036', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111114535000656', '20160111114544000956'),
('2016000030', '2016000037', 'TO:-  AO:- BO:-  CO:-\nTH:-  AH:- BH:-  CO:-', 'ABSENCE D ANTICORPS ANTI SAMONELLA PARATYPHI ET TYPHI', '0', '20160111000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160111115609000658', NULL),
('2016000031', '2016000039', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111164220000130', '20160111164231000324'),
('2016000032', '2016000040', '124mg/dl           VN:70-110mg/dl', '', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111164535000030', '20160111164539000508'),
('2016000033', '2016000041', '99mg/dl            VN:70-110mg/dl', 'normale', '1', '20160111000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111165201000734', '20160111165207000224'),
('2016000034', '2016000042', '101mg/dl               VN:70-110mg/dl', 'normale', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113081915000225', '20160113081922000120'),
('2016000035', '2016000043', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5\n', '', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113082758000618', '20160113082805000030'),
('2016000036', '2016000044', 'ALBUMINE:POSITIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160112000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113083120000311', '20160113083127000035'),
('2016000037', '2016000046', '103mg/dl    VN:70-110mg/dl', 'normale', '0', '20160113000000000000', '2000', '2016', '1', 'sysgeho', NULL, '20160113092027000990', NULL),
('2016000038', '2016000047', '103mg/dl       VN:70-110mg/dl', 'normale', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113092306000642', '20160113092311000010'),
('2016000039', '2016000048', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113092833000755', '20160113092841000274'),
('2016000040', '2016000049', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:7', '', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113141240000103', '20160113141247000867'),
('2016000041', '2016000050', '104mg/dl          VN:70-110mg/dl', 'normale', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113141643000579', '20160113141651000425'),
('2016000042', '2016000051', '86mg/dl        VN:70-110mg/dl', 'normale', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142110000593', '20160113142114000046'),
('2016000043', '2016000052', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142307000408', '20160113142311000332'),
('2016000044', '2016000053', 'NEGATIF', 'ABSENCE D IMMUNITE', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142718000478', '20160113142721000994'),
('2016000045', '2016000054', 'NEGATIF', 'ABSENCE D IMMUNITE', '1', '20160113000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142920000136', '20160113142923000802'),
('2016000046', '2016000055', '103mg/dL       VN: 70-110 mg/dL', 'NORMAL', '1', '20160119000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160119143734000697', '20160119143743000486'),
('2016000047', '2016000056', '110mg/dl                VN:70-110mg/dl\n', 'normale', '1', '20160105000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121150534000609', '20160121150541000216'),
('2016000048', '2016000057', ' TO:1/80 AO:-  BO:-  CO:1/80\nTH:- AH:-  BH:-   CH:1/80 ', 'Presence d’anticorps Salmonella Paratyphi et Typhi', '1', '20160105000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121151354000138', '20160121151359000099'),
('2016000049', '2016000058', 'ALBUMINE:NEGATIF\nSUCRE:NEGATIF\nPH:6.5', '', '1', '20160105000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121151633000370', '20160121151637000500'),
('2016000050', '2016000059', '"B" RHESUS:POSITIF', '', '1', '20160105000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121151835000921', '20160121151841000580'),
('2016000051', '2016000060', '124 mg/dl          VN:70-110mg/dl', 'giycemie elevée', '1', '20160105000000000000', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121152344000588', '20160121152353000126'),
('2016000052', '2016000061', '6,2 \nPN : 6-12', 'Taux de glycemie élevé', '1', '20160603000000000000', '2002', '2016', '1', 'admin', 'admin', '20160603152323000654', '20160603152348000862');

-- --------------------------------------------------------

--
-- Structure de la table `tab_eta_stat`
--

CREATE TABLE IF NOT EXISTS `tab_eta_stat` (
  `COD_ETA_STAT` varchar(32) NOT NULL DEFAULT '',
  `LIB_ETA_STAT` varchar(255) DEFAULT NULL,
  `LIB_DESC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `DAT_DEB` varchar(254) DEFAULT NULL,
  `DAT_FIN` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`COD_ETA_STAT`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_eta_stat`
--

INSERT INTO `tab_eta_stat` (`COD_ETA_STAT`, `LIB_ETA_STAT`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `DAT_DEB`, `DAT_FIN`) VALUES
('C001', 'Etat Pilotage', '', '2000', '2014', '1', 'admin', NULL, '20141219165736000536', NULL, NULL, NULL),
('21/12/2015', 'RIGO PARAMEDICA', 'BANDE DYNACAST 03 x 8500 (25500)\nJERSEY (1rouleau) (10 000)\nGEL ECG 63 x 20 (04 x 2500 = 10000)\nPAPIER ECG (04 x 5000= 20 000)\n\n', '2000', '2015', '1', 'tsonia', 'tsonia', '20151221110832000213', '20151221111124000099', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_exam`
--

CREATE TABLE IF NOT EXISTS `tab_exam` (
  `COD_EXAM` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_TYP_EXAM` varchar(32) DEFAULT NULL,
  `LIB_EXAM` varchar(45) DEFAULT NULL,
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `VAL_MNT_TTC` decimal(20,2) DEFAULT NULL,
  `DAT_EXAM` varchar(32) DEFAULT NULL,
  `LIB_STATUT` varchar(1024) DEFAULT NULL,
  `LIB_PRES` varchar(255) DEFAULT NULL,
  `BOO_CPTE_RENDU` decimal(1,0) DEFAULT '0',
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT NULL,
  `BOO_PAIE` decimal(1,0) DEFAULT NULL,
  `REF_FAC` varchar(32) DEFAULT NULL,
  `ENU_MOD_PCHG` varchar(30) DEFAULT NULL,
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(10) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`COD_EXAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_exam`
--

INSERT INTO `tab_exam` (`COD_EXAM`, `COD_PAT`, `COD_TYP_EXAM`, `LIB_EXAM`, `LIB_OBJ`, `VAL_MNT_TTC`, `DAT_EXAM`, `LIB_STATUT`, `LIB_PRES`, `BOO_CPTE_RENDU`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_VAL`, `BOO_PAIE`, `REF_FAC`, `ENU_MOD_PCHG`, `COD_VIS_MED_EMB`, `COD_VIS_MED_PERIO`, `TYP_VIS_MED_SRC`, `COD_USR`) VALUES
('2015000008', '20150010', 'GSR', 'Groupe Sanguin et rhesus', '', '5000.00', '20150914000000000000', '', '', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150914104918000539', '20150914105525000265', '1', '0', NULL, '', NULL, NULL, '', 'kjoseph'),
('2015000009', '20150013', 'TBC', ',TEST DE TUBERCULOSE ,', '', '10000.00', '20150914000000000000', '', '', '1', '2011', '2015', '1', 'kviviane', 'tsonia', '20150914123128000406', '20150914164808000106', '1', '1', '140915/FMB/MNS', '', '2015000005', NULL, 'VM_EMB', NULL),
('2015000010', '20150013', 'GLY', 'Glycemie', '', '3000.00', '20150914000000000000', '', 'DR  FOSSOUO', '1', '2011', '2015', '1', 'kviviane', 'tsonia', '20150914130714000352', '20150914164808000106', '1', '1', '140915/FMB/MNS', '2000', '2015000005', NULL, 'VM_EMB', 'kviviane'),
('2015000011', '20150013', 'BU', 'Biochimie  urinaire', '', '6000.00', '20150914000000000000', '', '', '1', '2011', '2015', '1', 'kviviane', 'tsonia', '20150914133049000025', '20150914164808000106', '1', '1', '140915/FMB/MNS', '2000', '2015000005', NULL, 'VM_EMB', 'kviviane'),
('2015000012', '20150017', 'TBC', 'Test de tuberculose', '', '10000.00', '20150914000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150914164544000545', '20150914165046000730', '1', '0', NULL, '2000', '2015000006', NULL, 'VM_EMB', 'kviviane'),
('2015000013', '20150017', 'GLY', 'GLYCEMIE', '', '3000.00', '20150914000000000000', '', 'DR  EWANE', '0', '2002', '2015', '1', 'kviviane', 'kviviane', '20150914170455000915', '20150914170505000524', '1', '0', NULL, '2000', '2015000006', NULL, 'VM_EMB', 'kviviane'),
('2015000014', '20150017', 'GLY', 'GLYCEMIE', '', '3000.00', '20150914000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915102804000483', '20150915103153000037', '1', '0', NULL, '2000', '2015000006', NULL, 'VM_EMB', 'kviviane'),
('2015000015', '20150017', 'BU', 'Biochimie  Urinaire', '', '6000.00', '20150914000000000000', '', 'DR EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915103801000790', '20150915104016000574', '1', '0', NULL, '2000', '2015000006', NULL, 'VM_EMB', 'kviviane'),
('2015000016', '20150022', 'WI', 'WIDAL', '', '7500.00', '20150914000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915113945000520', '20150915114759000246', '1', '0', NULL, '2000', NULL, NULL, 'VM_EMB', 'kviviane'),
('2015000017', '20150024', 'GLY', 'GLYCEMIE', '', '3000.00', '20150915000000000000', '', 'DR EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915120003000400', '20150915120339000164', '1', '0', NULL, '2000', '2015000010', NULL, 'VM_EMB', 'kviviane'),
('2015000018', '20150024', 'BU', 'BIOCHIMIE  URINAIRE', '', '6000.00', '20150915000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915120701000824', '20150915120921000164', '1', '0', NULL, '2000', '2015000010', NULL, 'VM_EMB', 'kviviane'),
('2015000019', '20150024', 'TBC', 'TEST TUBERCULOSE', '', '10000.00', '20150915000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915122019000517', '20150915122319000369', '1', '0', NULL, '2000', '2015000010', NULL, 'VM_EMB', 'kviviane'),
('2015000020', '20150025', 'GLY', 'GLYCEMIE', '', '3000.00', '20150915000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915123424000090', '20150915123746000798', '1', '0', NULL, '', '2015000009', NULL, 'VM_EMB', 'kviviane'),
('2015000021', '20150025', 'TBC', 'TEST DE TUBERCULOSE', '', '10000.00', '20150915000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915124029000178', '20150915124531000939', '1', '0', NULL, '2000', '2015000009', NULL, 'VM_EMB', 'kviviane'),
('2015000022', '20150025', 'BU', 'BIOCHIMIE URINAIRE', '', '6000.00', '20150915000000000000', '', '', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915124919000052', '20150915125038000580', '1', '0', NULL, '', '2015000009', NULL, 'VM_EMB', 'kviviane'),
('2015000023', '20150027', 'GLY', 'GLYCEMIE', '', '3000.00', '20150915000000000000', '', 'DR  FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915125528000633', '20150915125740000664', '1', '0', NULL, '2000', NULL, NULL, 'VM_EMB', 'kviviane'),
('2015000024', '20150027', 'TBC', 'TEST DE TUBERCULOSE', '', '10000.00', '20150915000000000000', '', 'DR  FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915130145000169', '20150915130644000078', '1', '0', NULL, '2000', NULL, NULL, 'VM_EMB', 'kviviane'),
('2015000025', '20150027', 'BU', 'BIOCHIMIE  URINAIRE', '', '6000.00', '20150915000000000000', '', 'DR  EWANE', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915131513000333', '20150915131719000082', '1', '0', NULL, '2000', NULL, NULL, '', 'kviviane'),
('2015000026', '20150028', 'GLY', 'GLYCEMIE', '', '3000.00', '20150915000000000000', '', 'DR  FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915133158000363', '20150915133534000888', '1', '0', NULL, '2000', NULL, NULL, 'VM_EMB', 'kviviane'),
('2015000027', '20150028', 'TBC', 'TEST DE TUBERCULOSE', '', '10000.00', NULL, '', 'DR  FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915133847000545', '20150915134101000089', '1', '0', NULL, '2000', NULL, NULL, '', 'kviviane'),
('2015000028', '20150028', 'BU', 'BIOCHIMIE URINAIRE', '', '6000.00', '20150915000000000000', '', 'DR FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20150915134321000065', '20150915134613000551', '1', '0', NULL, '2000', NULL, NULL, '', 'kviviane'),
('2015000029', '20150080', 'GLY', 'GLYCEMIE A JEUN', '', '3000.00', '20151021000000000000', '', 'DR FOSSOUO', '1', '2002', '2015', '1', 'kviviane', 'kviviane', '20151023140909000184', '20151023141429000674', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2015000030', '20150078', 'WI', 'WIDAL', '', '7500.00', NULL, '', '', '0', '2002', '2015', '1', 'kviviane', 'kviviane', '20151023141954000499', '20151023142446000268', '1', '0', NULL, '', NULL, NULL, '', 'fpatrick'),
('2016000004', '20160017', NULL, 'GLYCEMIE', '', '3000.00', '20160104000000000000', '', 'FEUSSOUO', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160105090438000525', '20160105092058000256', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000005', '20160042', 'GLY', 'GLYCEMIE A JEUN', '', '3000.00', NULL, '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108141429000087', '20160108141752000995', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000006', '20160042', 'SM', 'SM', '', '10000.00', NULL, '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108142253000326', '20160108142620000916', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000007', '20160042', 'URINE', 'URINE', '', '6000.00', NULL, '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108143230000621', '20160108143847000754', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000008', '20160043', 'GLY', 'GLYCEMIE', '', '3000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108144332000032', '20160108144605000629', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000009', '20160043', 'SM', 'SM', '', '10000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108145007000497', '20160108145230000507', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000010', '20160043', 'URINE', 'URINE', '', '6000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108145445000680', '20160108145727000629', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000011', '20160044', 'GLY', 'GLYCEMIE', '', '3000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108152526000657', '20160108152814000117', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000012', '20160044', 'SM', 'SM', '', '10000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108153454000122', '20160108153653000211', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000013', '20160044', 'URINE', 'URINE', '', '6000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108153959000225', '20160108154328000515', '1', '0', NULL, '', NULL, NULL, '', 'cepenza'),
('2016000014', '20160045', 'GLY', 'GLYCEMIE', '', '3000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108154618000173', '20160108154845000718', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000015', '20160045', 'SM', 'SM', '', '10000.00', '20160108000000000000', '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108155026000785', '20160108155210000945', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000016', '20160045', 'URINE', 'URINE', '', '6000.00', NULL, '', '', '1', '2002', '2016', '1', 'admin', 'admin', '20160108155429000829', '20160108155654000338', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000017', '20160016', 'GLY', 'GLYCEMIE', '', '3000.00', '20160104000000000000', '', '', '0', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111093244000958', '20160111093253000055', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000018', '20160016', 'GLY', 'GLYCEMIE POST PRANDIAL', '', '3000.00', NULL, '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111093626000784', '20160111093942000439', '1', '0', NULL, '', NULL, NULL, '', 'cepenza'),
('2016000019', '20160016', 'WI', 'WIDAL', '', '7500.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111094923000798', '20160111095555000275', '1', '0', NULL, '2002', NULL, NULL, 'VM_EMB', 'cepenza'),
('2016000020', '20160014', 'GLY', 'GLY', '', '3000.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111101647000569', '20160111101838000891', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2016000021', '20160014', 'WI', 'WIDAL', '', '7500.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111102031000429', '20160111102735000095', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2016000022', '20160014', 'BU', 'BU', '', '6000.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111103002000273', '20160111103214000921', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000023', '20160014', 'GSR', 'GSR', '', '5000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111103603000071', '20160111103839000836', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000024', '20160015', 'GSR', 'GSR', '', '5000.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111104220000218', '20160111104337000500', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000025', '20160015', 'GLY', 'GLY', '', '3000.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111104547000885', '20160111104919000736', '1', '0', NULL, '', NULL, NULL, '', NULL),
('2016000026', '20160015', 'GLY', 'GLY', '', '3000.00', '20160104000000000000', '', '', '0', '2000', '2016', '1', 'sysgeho', 'sysgeho', '20160111105138000499', '20160111104557000089', '0', '0', NULL, '', NULL, NULL, '', NULL),
('2016000027', '20160015', 'GLY', 'GLY', '', '3000.00', '20160104000000000000', '', '', '0', '2000', '2016', '1', 'sysgeho', 'sysgeho', '20160111105320000588', '20160111104557000089', '0', '0', NULL, '', NULL, NULL, '', 'fpatrick'),
('2016000028', '20160015', 'GLY', 'GLY', '', '3000.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111105404000159', '20160111105503000462', '1', '0', NULL, '', NULL, NULL, '', 'fpatrick'),
('2016000029', NULL, 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '0', '2000', '2016', '1', 'sysgeho', NULL, '20160111110109000909', NULL, '0', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000030', NULL, 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111110213000682', '20160111110346000999', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000031', NULL, 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111110459000108', '20160111110609000529', '1', '0', NULL, '2002', NULL, NULL, '', 'cepenza'),
('2016000032', '20160057', NULL, 'GLY', '', '0.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111110707000129', '20160111110810000762', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000033', NULL, 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111111645000175', '20160111111759000338', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000034', NULL, 'BU', 'BU', '', '6000.00', '20160111000000000000', '', '', '0', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111111927000946', '20160111111933000562', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000035', NULL, 'BU', 'BU', '', '6000.00', NULL, '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111114136000507', '20160111114301000189', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000036', NULL, 'BU', 'BU', '', '6000.00', NULL, '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111114427000663', '20160111114535000649', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000037', NULL, 'WI', 'WI', '', '7500.00', '20160104000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111115137000396', '20160111115609000653', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000038', '20160066', 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '0', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111163631000259', '20160111163641000184', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000039', '20160066', 'BU', 'BU', '', '6000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111164107000400', '20160111164220000124', '1', '0', NULL, '2002', NULL, NULL, '', 'fewane'),
('2016000040', '20160066', 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111164443000577', '20160111164535000025', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000041', NULL, 'GLY', 'GLY', '', '3000.00', '20160111000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160111165052000579', '20160111165201000727', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000042', NULL, 'GLY', 'GLY', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113081758000972', '20160113081915000225', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000043', NULL, 'BU', 'BU', '', '6000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113082053000833', '20160113082758000603', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000044', NULL, 'BU', 'BU', '', '6000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113083018000301', '20160113083120000295', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000045', NULL, 'GLY', 'BU', '', '3000.00', '20160113000000000000', '', '', '0', '2000', '2016', '1', 'sysgeho', 'sysgeho', '20160113083306000875', '20160113083025000103', '0', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000046', '20160080', 'GLY', 'GLY', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113091633000458', '20160113092027000990', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000047', '20160080', 'GLY', 'GLY', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113092218000719', '20160113092306000626', '1', '0', NULL, '2000', NULL, NULL, '', 'fpatrick'),
('2016000048', '20160080', 'GLY', 'BU', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113092730000064', '20160113092833000755', '1', '0', NULL, '2000', NULL, NULL, '', 'fpatrick'),
('2016000049', NULL, 'BU', 'BU', '', '6000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113141121000175', '20160113141240000093', '1', '0', NULL, '2000', NULL, NULL, '', 'fpatrick'),
('2016000050', '20160081', 'GLY', 'GLY', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113141537000697', '20160113141643000573', '1', '0', NULL, '2000', NULL, NULL, '', 'fpatrick'),
('2016000051', '20160082', 'GLY', 'GLY', '', '3000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113141946000328', '20160113142110000588', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000052', '20160082', 'BU', 'BU', '', '6000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142214000467', '20160113142307000398', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000053', '20160082', 'SM', 'SM', '', '10000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142543000888', '20160113142718000467', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000054', '20160079', 'SM', 'SM', '', '10000.00', '20160113000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160113142847000669', '20160113142920000132', '1', '0', NULL, '2002', NULL, NULL, '', 'fpatrick'),
('2016000055', '20160113', 'GLY', 'GLY', '', '3000.00', '20160119000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160119143141000759', '20160119143734000687', '1', '0', NULL, '2002', NULL, NULL, 'VM_EMB', 'cepenza'),
('2016000056', '20160020', 'GLY', 'GLY', '', '3000.00', '20160105000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121150355000547', '20160121150534000604', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000057', '20160020', 'WI', 'WI', '', '7500.00', '20160105000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121150709000965', '20160121151354000133', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000058', '20160020', 'BU', 'BU', '', '6000.00', '20160105000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121151520000437', '20160121151633000366', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000059', '20160020', 'GSR', 'GS', '', '5000.00', '20160105000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121151736000866', '20160121151835000917', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000060', '20160019', 'GLY', 'GLY', '', '3000.00', '20160105000000000000', '', '', '1', '2002', '2016', '1', 'sysgeho', 'sysgeho', '20160121152104000029', '20160121152344000583', '1', '0', NULL, '2002', NULL, NULL, '', NULL),
('2016000061', '20160669', 'GLY', 'Glycemie a jeun', '', '3000.00', '20160603000000000000', '', '', '1', '2011', '2016', '1', 'admin', 'admin', '20160603152130000703', '20160603152854000729', '1', '1', 'REF/2016/0001', '2000', NULL, NULL, '', 'fewane');

-- --------------------------------------------------------

--
-- Structure de la table `tab_fac_conv`
--

CREATE TABLE IF NOT EXISTS `tab_fac_conv` (
  `REF_FAC_CONV` varchar(32) NOT NULL DEFAULT '',
  `COD_SOC` varchar(32) DEFAULT NULL,
  `VAL_EFF` decimal(20,2) DEFAULT NULL,
  `VAL_TRF_FIX_MSUEL` decimal(20,2) DEFAULT NULL,
  `VAL_PRIX_UNI` decimal(20,2) DEFAULT NULL,
  `VAL_MNT_TOTAL` decimal(20,0) DEFAULT NULL,
  `DAT_FAC` varchar(32) DEFAULT NULL,
  `ENU_MOIS_FAC` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `BOO_PAIE` decimal(1,0) DEFAULT '0',
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_INF_COMPL` varchar(1024) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `VAL_TARIF_FIX_MEN` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`REF_FAC_CONV`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_fac_conv`
--

INSERT INTO `tab_fac_conv` (`REF_FAC_CONV`, `COD_SOC`, `VAL_EFF`, `VAL_TRF_FIX_MSUEL`, `VAL_PRIX_UNI`, `VAL_MNT_TOTAL`, `DAT_FAC`, `ENU_MOIS_FAC`, `BOO_VAL`, `BOO_PAIE`, `LIB_OBJ`, `LIB_INF_COMPL`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `VAL_TARIF_FIX_MEN`) VALUES
('NHMT N° 048/MN/FMB/2016', 'COMETAL', '330.00', '0.00', '600.00', '198000', '20160305121010000198', '2000', '1', '0', 'Note d’honoraire de Médecine de Travail Janvier  2016\n', '', '2002', '2016', '1', 'tsonia', 'tsonia', '20160305121010000208', '20160305121105000802', NULL),
('NHMT N°126/MNS/FMB/2015', 'ESICO', '50.00', '40000.00', '1000.00', '90000', '20150808135003000563', '2005', '0', '0', 'Note d''honoraire de Médecine de Travail Mai 2015', '', '2000', '2015', '1', 'admin', NULL, '20150808135003000569', NULL, NULL),
('NHMT N°90/MNS/FMB/15', '3TC', '90.00', '0.00', '600.00', '54000', '20150911000000000000', '2006', '1', '1', 'NHMT DU MOIS JUIN', '', '2011', '2015', '1', 'tsonia', 'tsonia', '20150911150356000929', '20160104163021000338', NULL),
('NHMT N°91/MNS/FMB/15', 'SSBMD', '231.00', '50000.00', '850.00', '246350', '20150911151241000393', '2007', '0', '0', 'NHMT DU MOIS JUILLET', '', '2000', '2015', '1', 'tsonia', NULL, '20150911151241000398', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_fac_cour`
--

CREATE TABLE IF NOT EXISTS `tab_fac_cour` (
  `REF_FAC_COUR` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `VAL_MNT_TOTAL` decimal(20,0) DEFAULT NULL,
  `DAT_FAC` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `BOO_PAIE` decimal(1,0) DEFAULT '0',
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_INF_COMPL` varchar(1024) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`REF_FAC_COUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_fac_cour`
--

INSERT INTO `tab_fac_cour` (`REF_FAC_COUR`, `COD_PAT`, `VAL_MNT_TOTAL`, `DAT_FAC`, `BOO_VAL`, `BOO_PAIE`, `LIB_OBJ`, `LIB_INF_COMPL`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('777', '20160301', '0', NULL, '0', '0', '', '', '2000', '2016', '1', 'admin', NULL, '20160416090100000601', NULL),
('REF/2016/0001', '20160669', '13000', '20160603000000000000', '1', '1', '', '', '2011', '2016', '1', 'admin', 'admin', '20160603152653000677', '20160603152854000745');

-- --------------------------------------------------------

--
-- Structure de la table `tab_fac_vis_med_emb`
--

CREATE TABLE IF NOT EXISTS `tab_fac_vis_med_emb` (
  `REF_FAC_VIS_MED_EMB` varchar(32) NOT NULL DEFAULT '',
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `C_LOT_DOC` varchar(32) DEFAULT NULL,
  `VAL_MNT_TOTAL` decimal(20,0) DEFAULT NULL,
  `DAT_FAC` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `BOO_PAIE` decimal(1,0) DEFAULT '0',
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_INF_COMPL` varchar(1024) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`REF_FAC_VIS_MED_EMB`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_fac_vis_med_perio`
--

CREATE TABLE IF NOT EXISTS `tab_fac_vis_med_perio` (
  `REF_FAC_VIS_MED_PERIO` varchar(32) NOT NULL DEFAULT '',
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `C_LOT_DOC` varchar(32) DEFAULT NULL,
  `VAL_MNT_TOTAL` decimal(20,0) DEFAULT NULL,
  `DAT_FAC` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `BOO_PAIE` decimal(1,0) DEFAULT '0',
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_INF_COMPL` varchar(1024) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`REF_FAC_VIS_MED_PERIO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_four`
--

CREATE TABLE IF NOT EXISTS `tab_four` (
  `COD_FOUR` varchar(32) NOT NULL DEFAULT '',
  `LIB_FOUR` varchar(32) NOT NULL DEFAULT '',
  `LIB_BP` varchar(32) DEFAULT NULL,
  `LIB_TEL` varchar(32) DEFAULT NULL,
  `LIB_ADRESSE` varchar(32) DEFAULT NULL,
  `LIB_RESP` decimal(10,0) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_FOUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_hospi`
--

CREATE TABLE IF NOT EXISTS `tab_hospi` (
  `COD_HOSPI` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `COD_SVC` varchar(32) DEFAULT NULL,
  `DAT_ADMI` varchar(32) DEFAULT NULL,
  `LIB_MOTIF` varchar(255) DEFAULT NULL,
  `LIB_NUM_CARNET` varchar(255) DEFAULT NULL,
  `LIB_OBS` varchar(1024) DEFAULT NULL,
  `LIB_NUM_CHBRE` varchar(255) DEFAULT NULL,
  `LIB_NUM_LIT` varchar(255) DEFAULT NULL,
  `VAL_MNT` decimal(20,2) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_SOR` decimal(1,0) DEFAULT NULL,
  `LIB_PRESCRI` varchar(1024) DEFAULT NULL,
  `DAT_SORTIE` varchar(32) DEFAULT NULL,
  `BOO_PAIE` decimal(1,0) DEFAULT NULL,
  `REF_FAC` varchar(32) DEFAULT NULL,
  `ENU_MOD_PCHG` varchar(30) DEFAULT NULL,
  `NUM_CHR_HOSPI` varchar(255) DEFAULT NULL,
  `COD_LIT` varchar(255) DEFAULT NULL,
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(10) DEFAULT NULL,
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`COD_HOSPI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_hospi`
--

INSERT INTO `tab_hospi` (`COD_HOSPI`, `COD_PAT`, `COD_USR`, `COD_SVC`, `DAT_ADMI`, `LIB_MOTIF`, `LIB_NUM_CARNET`, `LIB_OBS`, `LIB_NUM_CHBRE`, `LIB_NUM_LIT`, `VAL_MNT`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_SOR`, `LIB_PRESCRI`, `DAT_SORTIE`, `BOO_PAIE`, `REF_FAC`, `ENU_MOD_PCHG`, `NUM_CHR_HOSPI`, `COD_LIT`, `COD_VIS_MED_EMB`, `TYP_VIS_MED_SRC`, `COD_VIS_MED_PERIO`) VALUES
('2016000008', '20160012', 'fewane', 'INF', '20160104000000000000', 'SYNDROME INFECTUEUX', '', '', NULL, NULL, '0.00', '2009', '2016', '1', 'tsonia', 'tsonia', '20160104152026000340', '20160104152101000572', '0', NULL, NULL, '0', NULL, '2000', '102', NULL, NULL, '', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_inc_cod`
--

CREATE TABLE IF NOT EXISTS `tab_inc_cod` (
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
-- Contenu de la table `tab_inc_cod`
--

INSERT INTO `tab_inc_cod` (`COD_INC_COD`, `LIB_DESC`, `VAL_INC_COD`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('2014TabConsul', 'compteur consultation', '6', NULL, NULL, '0', 'admin', 'admin', NULL, '20141225092312000561'),
('2014TabCpteRenduConsul', 'compteur compte rendu consultation', '4', NULL, NULL, '0', 'admin', 'admin', NULL, '20141014203208000438'),
('2014TabCpteRenduExam', 'compteur compte rendu exam', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20141015215238000683'),
('2014TabExam', 'compteur exam', '5', NULL, NULL, '0', 'admin', 'admin', '20140809150354000617', '20141014220119000113'),
('2014TabHospi', 'compteur hospitalisation', '9', NULL, NULL, '0', 'admin', 'admin', '20140809150354000617', '20141014235001000094'),
('2014TabPat', 'compteur patient', '9', NULL, NULL, '0', 'admin', 'admin', '20140809150354000617', '20141114122300000702'),
('2014TabRapVisMedEmb', 'compteur compte rendu VM Emb', '2', NULL, NULL, '0', NULL, 'admin', 'admin', '20141216192251000661'),
('2014TabRapVisMedPerio', 'compteur compte rendu VM Perio', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20141216191532000892'),
('2014TabRdv', 'compteur RDV', '7', NULL, NULL, '0', 'admin', 'admin', '20140809150354000617', '20141014105232000778'),
('2014TabSoin', 'compteur soin', '9', NULL, NULL, '0', 'admin', 'admin', '20140809150354000617', '20141014134235000671'),
('2014TabVisMedEmb', 'compteur visite medical embauche', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20141014100818000039'),
('2014TabVisMedPerio', 'compteur visite medical embauche', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20141014095956000162'),
('2015TabConsul', 'compteur consultation', '44', NULL, NULL, '0', 'admin', 'fewane', NULL, '20150922113142000967'),
('2015TabCpteRenduConsul', 'compteur compte rendu consultation', '26', NULL, NULL, '0', 'admin', 'fewane', NULL, '20150922115747000710'),
('2015TabCpteRenduExam', 'compteur compte rendu exam', '25', NULL, NULL, '0', 'admin', 'kviviane', NULL, '20151023141429000667'),
('2015TabExam', 'compteur exam', '30', NULL, NULL, '0', 'admin', 'kviviane', '20150809150354000617', '20151023141954000487'),
('2015TabHospi', 'compteur hospitalisation', '9', NULL, NULL, '0', 'admin', 'admin', '20150809150354000617', '20151014235001000094'),
('2015TabPat', 'compteur patient', '85', NULL, NULL, '0', 'admin', 'tsonia', '20150809150354000617', '20151214095622000982'),
('2015TabRapVisMedEmb', 'compteur compte rendu VM Emb', '3', NULL, NULL, '0', NULL, 'admin', 'admin', '20150905232759000827'),
('2015TabRapVisMedPerio', 'compteur compte rendu VM Perio', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20151216191532000892'),
('2015TabRdv', 'compteur RDV', '7', NULL, NULL, '0', 'admin', 'admin', '20150809150354000617', '20151014105232000778'),
('2015TabSoin', 'compteur soin', '10', NULL, NULL, '0', 'admin', 'admin', '20150809150354000617', '20150905235620000798'),
('2015TabVisMedEmb', 'compteur visite medical embauche', '10', NULL, NULL, '0', 'admin', 'tsonia', NULL, '20150915075925000905'),
('2015TabVisMedPerio', 'compteur visite medical embauche', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20151014095956000162'),
('2016TabCertMed', 'compteur certificat', '4', NULL, NULL, '0', 'admin', 'admin', NULL, '20160505134724000099'),
('2016TabConsul', 'compteur consultation', '227', NULL, NULL, '0', 'admin', 'admin', NULL, '20160603151204000723'),
('2016TabCpteRenduConsul', 'compteur compte rendu consultation', '215', NULL, NULL, '0', 'admin', 'admin', NULL, '20160603151503000795'),
('2016TabCpteRenduExam', 'compteur compte rendu exam', '52', NULL, NULL, '0', 'admin', 'admin', NULL, '20160603152323000545'),
('2016TabExam', 'compteur exam', '61', NULL, NULL, '0', 'admin', 'admin', '20160809150354000617', '20160603152130000575'),
('2016TabHospi', 'compteur hospitalisation', '8', NULL, NULL, '0', 'admin', 'tsonia', '20160809150354000617', '20160104152026000340'),
('2016TabPat', 'compteur patient', '669', NULL, NULL, '0', 'admin', 'admin', '20160809150354000617', '20160603150935000786'),
('2016TabRapVisMedEmb', 'compteur compte rendu VM Emb', '2', NULL, NULL, '0', NULL, 'admin', 'admin', '20161216192251000661'),
('2016TabRapVisMedPerio', 'compteur compte rendu VM Perio', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20161216191532000892'),
('2016TabRdv', 'compteur RDV', '5', NULL, NULL, '0', 'admin', 'admin', '20160809150354000617', '20160907080111000183'),
('2016TabSoin', 'compteur soin', '6', NULL, NULL, '0', 'admin', 'admin', '20160809150354000617', '20160911135940000636'),
('2016TabVisMedEmb', 'compteur visite medical embauche', '14', NULL, NULL, '0', 'admin', 'fewane', NULL, '20160218094850000605'),
('2016TabVisMedPerio', 'compteur visite medical embauche', '3', NULL, NULL, '0', 'admin', 'admin', NULL, '20161014095956000162');

-- --------------------------------------------------------

--
-- Structure de la table `tab_lit`
--

CREATE TABLE IF NOT EXISTS `tab_lit` (
  `COD_LIT` varchar(32) NOT NULL DEFAULT '',
  `NUM_LIT` varchar(32) DEFAULT NULL,
  `LIB_LIT` varchar(254) DEFAULT NULL,
  `NUM_CHR_HOSPI` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_OQP` decimal(1,0) DEFAULT NULL,
  PRIMARY KEY (`COD_LIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_lit`
--

INSERT INTO `tab_lit` (`COD_LIT`, `NUM_LIT`, `LIB_LIT`, `NUM_CHR_HOSPI`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_OQP`) VALUES
('101/101-1', '101-1', 'Lit 1 - 101 ', '101', '2013', '2014', '1', 'admin', 'admin', '20140924233512000132', '20141015225514000445', '0');

-- --------------------------------------------------------

--
-- Structure de la table `tab_lot_doc`
--

CREATE TABLE IF NOT EXISTS `tab_lot_doc` (
  `C_LOT_DOC` varchar(255) NOT NULL DEFAULT '',
  `Z_PCE` decimal(20,2) DEFAULT '0.00',
  `L_INF_LOT` varchar(255) DEFAULT NULL,
  `L_LOT_DOC` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`C_LOT_DOC`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_medi`
--

CREATE TABLE IF NOT EXISTS `tab_medi` (
  `COD_MEDI` varchar(32) NOT NULL DEFAULT '',
  `REF_MEDI` varchar(32) NOT NULL DEFAULT '',
  `COD_FOUR` varchar(32) DEFAULT NULL,
  `LIB_MEDI` varchar(32) DEFAULT NULL,
  `LIB_UNITE` varchar(32) DEFAULT NULL,
  `VAL_PRI_UNI` decimal(10,0) DEFAULT NULL,
  `VAL_QTE` decimal(10,0) DEFAULT NULL,
  `COD_CAT_MEDI` varchar(32) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_MEDI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_pat`
--

CREATE TABLE IF NOT EXISTS `tab_pat` (
  `COD_PAT` varchar(32) NOT NULL DEFAULT '',
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
  `LIB_NUM_CNI` varchar(32) DEFAULT NULL,
  `LIB_NUM_CNPS` varchar(32) DEFAULT NULL,
  `LIB_MAT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COD_PAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_pat`
--

INSERT INTO `tab_pat` (`COD_PAT`, `LIB_TIT`, `LIB_NOM`, `LIB_PRE`, `ENU_STA_MAT`, `DAT_NAIS`, `LIB_SEX`, `LIB_ADR`, `LIB_NUM_TEL`, `LIB_PROF`, `LIB_FON`, `COD_SOC`, `BOO_EST_ASS`, `BOO_EST_AFF`, `LIB_PER_CON`, `LIB_NUM_TEL_PER_CON`, `COD_ASS`, `DAT_ENREG`, `BOO_EST_ARCH`, `LIB_MED`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `LIB_ASS`, `LIB_SOC`, `LIB_NUM_CNI`, `LIB_NUM_CNPS`, `LIB_MAT`) VALUES
('2014000007', '2006', 'TEGUO ', 'Romaric', '2003', '20001018000000000000', 'M', '', '77777887', 'Ingénieur Informatique', 'Chef de projet', 'GT', '0', '0', 'TEGUO Robert', '9996666', NULL, '20141014000000000000', NULL, '', '2000', '2014', '1', 'admin', 'admin', '20141014133333000684', '20141114125054000435', NULL, NULL, '', '', NULL),
('20150010', '2001', 'KENFACK', 'SERGE', '2003', '19260101000000000000', 'M', '', '', '', '', 'FMEGAZ', '1', '0', '', '', 'ASCOMA', '20150911000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150911143958000568', NULL, NULL, NULL, '', '', NULL),
('20150011', '2001', 'ABISSI MOTCHELA ', 'INNOCENT', '2003', '19841114000000000000', 'M', '', '6 75 40 44 15', 'ELECTRICIEN', '', 'CMC', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', 'fewane', '20150914093511000451', '20150914155333000566', NULL, NULL, '107254822', '', NULL),
('20150012', '2001', 'NJINANG DJOMOU', 'LOUDOVIC', '2003', '19880723000000000000', 'M', '', '', 'SOUDEUR ', '', 'EMEM', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914094420000038', NULL, NULL, NULL, '', '114777867', NULL),
('20150013', '2001', 'FOKA KAYIM ', 'DANIEL CLOVIS', '2003', '19940123000000000000', 'M', '', '671 61 04 38', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914094931000767', NULL, NULL, NULL, '109996132', '', NULL),
('20150014', '2001', 'KAMENI ', 'ISIDORE NARCISSE', '2000', '19760406000000000000', 'M', '', '', '', '', 'EMEM', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914095226000784', NULL, NULL, NULL, '117377181', '', NULL),
('20150015', '2001', 'MBOPOUO ', 'BRIS FRANCHERI', '2003', '19920415000000000000', 'M', '', '6 76 70 52 89', 'MECANICIEN', '', 'EMEM', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914095517000235', NULL, NULL, NULL, '118527293', '', NULL),
('20150016', '2002', 'TAKGO ', 'MAURINE', '2003', '19870702000000000000', 'F', '', '679 29 07 68', 'HOTESSE DE CAREAUX', '', 'SOREPCO', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914095759000759', NULL, NULL, NULL, '116118746', '', NULL),
('20150017', '2001', 'CHAMKO NGOUNDJO ', 'FRIDOLIN', '2003', '19870703000000000000', 'M', '', '678 18 15 47', 'COMPTABLE', '', 'SOREPCO', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914100047000147', NULL, NULL, NULL, '1184076415', '', NULL),
('20150018', '2001', 'OUAMBO ', 'EMMANUEL', '2000', '19560317000000000000', 'M', '', '6 99 97 55 04', 'COMPTABLE', '', 'SAVES', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914100345000003', NULL, NULL, NULL, '108019071', '', NULL),
('20150019', '2001', 'TIMA MBAKOP', 'APOLONE', '2000', '19710614000000000000', 'M', '', '', 'MACHINISTE', '', 'CMC', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914100907000799', NULL, NULL, NULL, '117742946', '', NULL),
('20150020', '2001', 'TCHAPON ', 'ARISTIDE VERLAIN', '2000', '19850405000000000000', 'M', '', '699 54 67 37', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914102355000123', NULL, NULL, NULL, '115691428', '', NULL),
('20150021', '2001', 'WETHE ', 'EMMANUEL', '2003', '19730329000000000000', 'M', '', '699 74 66 47', 'RECEPTIONNISTE', '', 'ACMS ', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914111917000178', NULL, NULL, NULL, '107246900', '', NULL),
('20150022', '2002', 'CHEDI BOUET KABANI EPSE KAMGA', 'DORETTE', '2000', '19760421000000000000', 'F', '', '696 94 79 20', 'SECRETAIRE DE DIRECTION', '', 'TAC', '0', '1', '', '', NULL, '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914113450000654', NULL, NULL, NULL, '1168572772', '', NULL),
('20150023', '2001', 'ESSIMA ABEGA', '', '2003', '20150914000000000000', 'M', '', '677944693', '', 'Grutier', 'SSBMD', '0', '1', '', '', 'ASCOMA', '20150914000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150914161028000533', NULL, NULL, NULL, '109765581', '', NULL),
('20150024', '2001', 'NEGNO TAMO ', 'MERVEIL BERTRAND', '2003', '19871210000000000000', 'M', '', '651702289', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150915074637000136', NULL, NULL, NULL, '117513778', '', NULL),
('20150025', '2001', 'TEUKAM KAMDEM ', 'VALERY LANVIN ', '2003', '19870107000000000000', 'M', '', '674680314', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150915074925000616', NULL, NULL, NULL, '115813220', '', NULL),
('20150026', '2001', 'GOUDJOU', 'SADATE PATRICK', '2000', '19830105000000000000', 'M', '', '695128304', 'MECANICIEN', '', 'GSIP', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150915081219000621', NULL, NULL, NULL, '116383802', '', NULL),
('20150027', '2001', 'TATOUM  FOPOUSSI ', 'BRUNO', '2000', '19800625000000000000', 'M', '', '696 34 65 44', 'COMMERCIAL', '', 'SOREPCO', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150915093406000509', NULL, NULL, NULL, '107138667', '', NULL),
('20150028', '2001', 'FOTSO TCHUENTE ', 'CEDRIC', '2003', '19900502000000000000', 'M', '', '696 36 30 05', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', 'fewane', '20150915094116000399', '20150915102201000766', NULL, NULL, '', '112314872', NULL),
('20150029', '2001', 'ETEKI ETEKI ', 'ABEL AIME', '2000', NULL, 'M', '', '696 23 28 96', 'DRIVER', '', 'OLAM', '0', '1', '', '', NULL, '20150915000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150915095005000428', NULL, NULL, NULL, '108343640', '', NULL),
('20150030', '2001', 'LONANG PAWA ', 'BRUNO', '2000', '19791110000000000000', 'M', '', '650 56 78 05', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150916000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150916100703000058', NULL, NULL, NULL, '116416339', '', NULL),
('20150031', '2001', 'NGOSSO ZOA ', 'ELIE PATRICK', '2003', '19830418000000000000', 'M', '', '696 52 42 52', 'AIDE CONDUCTEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20150916000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150916112649000494', NULL, NULL, NULL, '1178307392', '', NULL),
('20150032', '2001', 'MVOA ', 'OLIVIER', '2000', '19730724000000000000', 'M', '', '699 18 55 66', 'SOUDEUR ', '', 'SSW', '0', '1', '', '', NULL, '20150916000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150916123653000867', NULL, NULL, NULL, '113226772', '', NULL),
('20150033', '2001', 'BEDOUKA KINGUE ', 'EMMANUEL ', '2003', '19770616000000000000', 'M', '', '696 56 34 24', 'SOUDEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20150916000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150916143939000049', NULL, NULL, NULL, '114070355', '', NULL),
('20150034', '2001', 'TCHOUAMEN KETCHATCHOUM', 'ROMEO', '2003', '19820408000000000000', 'M', '', '671620234', 'COMMERCANT', '', NULL, '0', '0', '', '', NULL, '20150917000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150917073807000982', NULL, NULL, NULL, '116327080', '', NULL),
('20150035', '2002', 'TCHOUASSI BENJAMAINE ', 'ROSETTE', '2000', '19801108000000000000', 'M', '', '695 85 13 58', 'CUISINIERE', '', 'SOPROICAM', '0', '1', '', '', NULL, '20150917000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150917075226000635', NULL, NULL, NULL, '107359964', '', NULL),
('20150037', '2001', 'MOYOPO ', 'DONATIEN', '2000', '19770616000000000000', 'M', '', '678 82 92 21', 'MAGASINIER', '', 'SOREPCO', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921072307000850', NULL, NULL, NULL, '109305895', '', ''),
('20150038', '2002', 'NOLACK KOPEGHOTSOU', 'AHISSATOU', '2003', '19830822000000000000', 'F', '', '673 37 75 42', 'OUVRIERE', '', 'SUM', '0', '1', '', '', NULL, '20150921000000000000', NULL, 'DR FEUSSOUO', '2000', '2015', '1', 'tsonia', NULL, '20150921073834000055', NULL, NULL, NULL, '117890758', '', ''),
('20150039', '2000', 'DASSI NGUEKAM ', 'FRANK', '2003', '19980531000000000000', 'M', '', '6 77 01 25 48', '', '', NULL, '0', '0', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921085323000610', NULL, NULL, NULL, '', '', ''),
('20150040', '2001', 'MOSES MBOZIEKEH TAMBA', '', '2000', '19750718000000000000', 'M', '', '677 72 16 16', 'COMPTABLE', '', 'OLAM', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921093330000288', NULL, NULL, NULL, '1174177453', '', ''),
('20150041', '2001', 'BELKASSEH MEHDI', '', '2003', '19861113000000000000', 'M', '', '679905186', 'PRODUCTION', '', 'OLAMBEKOKO', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921093635000838', NULL, NULL, NULL, '1176583624', '', ''),
('20150042', '2001', 'TAMO FOTSO ', 'GUY FABRICE', '2003', '19970503000000000000', 'M', '', '651 14 13 63', 'MECANICIEN', '', 'BR', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921100316000968', NULL, NULL, NULL, '117481036', '', ''),
('20150043', '2001', 'FOMI NDJEUTANG ', 'ALAIN', '2000', '19781115000000000000', 'M', '', '', '', '', 'CONG', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921102656000776', NULL, NULL, NULL, '116268769', '', ''),
('20150044', '2001', 'TAMPOULAH NDE', 'FRANCOIS PEROL', '2003', '19870511000000000000', 'M', '', '672 97 52 64', 'FRIGORISTE', '', 'CONG', '0', '0', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921144506000002', NULL, NULL, NULL, '108831620', '', ''),
('20150045', '2001', 'WAMBO ', 'GHISLAIN', '2003', '19900417000000000000', 'M', '', '697 55 98 66', 'COMPTABLE', '', 'SOREPCO', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921152156000598', NULL, NULL, NULL, '116258248', '', ''),
('20150046', '2001', 'MBILA PONDI ', 'ANDRE', '2003', '19720426000000000000', 'M', '', '697 95 17 48', 'DECLARANT EN DOUANE', '', 'CAT', '0', '1', '', '', NULL, '20150921000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150921164321000440', NULL, NULL, NULL, '1130510703', '', ''),
('20150047', '2001', 'ALOSA ', 'JOSEPH DESIRE', '2003', '19860517000000000000', 'M', '', '694341668', 'MACHINISTE', '', 'BATI PLUS', '0', '1', '', '', NULL, '20150922000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150922081016000811', NULL, NULL, NULL, '108667853', '', ''),
('20150048', '2001', 'NIGUIEU MAGAPTCHE ', 'DIDIER GAEL', '2003', '19920701000000000000', 'M', '', '699 71 34 99', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20150922000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150922081254000028', NULL, NULL, NULL, '', '', ''),
('20150049', '2001', 'DJEUMBA YOUTCHOU ', 'ESTELLE MELISSA', '2003', '19900331000000000000', 'M', '', '696 72 20 80', 'HOTESSE', '', 'MENO', '0', '1', '', '', NULL, '20150922000000000000', NULL, '', '2000', '2015', '1', 'tsonia', 'fewane', '20150922082250000854', '20150922090141000790', NULL, NULL, '110856774', '', ''),
('20150050', '2001', 'FOGANG ', 'GISCAR DESTAING', '2003', '19860625000000000000', 'M', '', '699436345', 'MAINTENANCIER', '', 'OLAM', '0', '1', '', '', NULL, '20150922000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150922105121000848', NULL, NULL, NULL, '109159048', '', ''),
('20150051', '2001', 'NDJEBA', 'SIMON', '2000', '19660512000000000000', 'M', '', '696 08 45 52', 'SOUDEUR', '', 'CMC', '0', '1', '', '', NULL, '20150922000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150922105706000112', NULL, NULL, NULL, '108449985', '', ''),
('20150052', '2001', 'FOGUEN ', 'JACOB', '2000', '19540701000000000000', 'M', '', '675 13 91 52', 'CHAUFFEUR', '', 'SOREPCO', '0', '0', '', '', NULL, '20150923000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150923093600000095', NULL, NULL, NULL, '115706122', '', ''),
('20150053', '2001', 'KONDJI ELANGUI ', 'NARCISSE', '2003', '19890201000000000000', 'M', '', '', '', '', 'CMC', '0', '0', '', '', NULL, '20150923000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150923111747000536', NULL, NULL, NULL, '111761430', '', ''),
('20150054', '2001', 'NINPA ', 'NOEL BABILA', '2000', '19830721000000000000', 'M', '', '', 'COMMERCANT', '', NULL, '0', '0', '', '', NULL, '20150924000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150924093110000091', NULL, NULL, NULL, '', '', ''),
('20150055', '2001', 'TAGNE ', 'SILVAIN ORLIEN', '2000', '19780801000000000000', 'M', '', '699 49 20 94', 'TOURNEUR AJUSTEUR', '', 'COMETAL', '0', '1', '', '', NULL, '20150925000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150925084023000037', NULL, NULL, NULL, '117921003', '', ''),
('20150056', '2002', 'MAFFO SIMO ', 'HELENE JOSIANE', '2003', '19850422000000000000', 'M', '', '677 88 77 69', 'COMPTABLE', '', 'GE', '0', '0', '', '', NULL, '20150925000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150925091836000695', NULL, NULL, NULL, '117620744', '', ''),
('20150057', '2001', 'NDJEMENG ', 'YSSOFA', '2003', '19780826000000000000', 'M', '', '696 655 522', 'AIDE LABO', '', 'SSBMD', '0', '1', '', '', NULL, '20150926000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150926111254000997', NULL, NULL, NULL, '110567815', '', ''),
('20150058', '2001', 'DYUMDJO ', 'FREDERIC', '2000', '19680911000000000000', 'M', '', '696 85 59 64', 'MENUISIER', '', 'SSBMD', '0', '0', '', '', NULL, '20150928000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150928104845000375', NULL, NULL, NULL, '107342831', '', ''),
('20150059', '2001', 'LEKONO ', 'REGINE', '2003', '19870212000000000000', 'F', '', '674772334', 'VENDEUSE', '', 'SAVES', '0', '0', '', '', NULL, '20150928000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150928105157000312', NULL, NULL, NULL, '109804135', '', ''),
('20150060', '2001', 'DIKANG ', 'GILBERT', '2000', '19780112000000000000', 'M', '', '696830293', 'AIDE VENDEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20150930000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150930093123000774', NULL, NULL, NULL, '114387176', '', ''),
('20150061', '2002', 'ONGMANDAK EPSE BEKOTO ', 'REGINE', '2000', '19531110000000000000', 'F', '', '698 91 56 79', 'MENAGERE', '', NULL, '0', '0', '', '', NULL, '20150930000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20150930115116000440', NULL, NULL, NULL, '115786302', '', ''),
('20150062', '2001', 'TATCHUM  TCHUENTE ', 'ARNAUD JOEL', '2003', '19920731000000000000', 'M', '', '690 81 97 26', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20151001000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151001085237000543', NULL, NULL, NULL, '116907276', '', ''),
('20150063', '2001', 'MAOBO TENDA', 'ROSTAN', '2003', '20151026000000000000', 'M', '', '', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20151001000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151001085616000676', NULL, NULL, NULL, '116264928', '', ''),
('20150064', '2001', 'TAMEKONG ', 'ERIC', '2000', '19751018000000000000', 'M', '', '678 24 19 25', 'CHAUFFEUR', '', 'SUM', '0', '0', '', '', NULL, '20151001000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151001090101000961', NULL, NULL, NULL, '114676027', '', ''),
('20150065', '2001', 'DJOMAHA NGOUNOU ', 'JOEL', '2003', '19880620000000000000', 'M', '', '', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20151001000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151001094325000969', NULL, NULL, NULL, '108522709', '', ''),
('20150066', '2001', 'TAKON NGESSE ', 'PIERRE', '2000', '19820629000000000000', 'M', '', '693 28 37 08', 'SOUDEUR', '', 'SATOMWOURI', '0', '1', '', '', NULL, '20151001000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151001104018000668', NULL, NULL, NULL, '117787643', '', ''),
('20150067', '2002', 'SANDJO ', 'LECADIE', '2003', '19720108000000000000', 'F', '', '694616229', 'OUVRIERE', '', 'SUM', '0', '1', '', '', NULL, '20151005000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151005081856000082', NULL, NULL, NULL, '109503697', '', ''),
('20150068', '2002', 'KAMMOGNE ', 'HORTANCE APPORTINE', '2000', '19700218000000000000', 'F', '', '696484667', 'MENAGERE', '', 'SOREPCO', '0', '1', '', '', NULL, '20151005000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151005083359000372', NULL, NULL, NULL, '116164453', '', ''),
('20150069', '2001', 'DTAPCHOM TEKAM', 'BERTRAND ALPHONSE', '2000', '19750122000000000000', 'M', '', '675 34 0404', 'GESTIONNAIRE', '', 'SOREPCO', '0', '1', '', '', NULL, '20151005000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151005083625000653', NULL, NULL, NULL, '110735886', '', ''),
('20150070', '2001', ' DOGMO', 'COLINCE MARTIAL', '2003', '19840702000000000000', 'M', '', '', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20151005000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151005100551000995', NULL, NULL, NULL, '112241454', '', ''),
('20150071', '2002', 'MANEWA ', 'JULIENNE', '2000', '19541001000000000000', 'F', '', '', 'COMMERCANTE', '', 'SOPLASCAM', '0', '1', '', '', NULL, '20151005000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151005102014000311', NULL, NULL, NULL, '113857958', '', ''),
('20150072', '2001', 'CHAWE PIECHELE', 'HERMANN MICHAEL', '2003', '19881003000000000000', 'M', '', '650955137', 'FICHISTE', '', 'SOREPCO', '0', '0', '', '', NULL, '20151006000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151006094921000901', NULL, NULL, NULL, '108332352', '', ''),
('20150073', '2001', 'BATANDE ', 'JOSEPH', '2000', '19690817000000000000', 'M', '', '677 43 81 33', 'ELECTRICIEN', '', 'FS', '0', '1', '', '', NULL, '20151012000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151012083349000521', NULL, NULL, NULL, '114352296', '', ''),
('20150074', '2001', 'MAWAH KWEMAYE ', 'DESIRE', '2000', '19840514000000000000', 'M', '', '', 'MACHINISTE', '', 'CMC', '0', '1', '', '', NULL, '20151013000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151013085851000786', NULL, NULL, NULL, '109977534', '', ''),
('20150075', '2001', 'BANOBE ', 'MOISE', '2000', '19730413000000000000', 'M', '', '675 57 35 53', 'OUVRIER', '', 'SUM', '0', '1', '', '', NULL, '20151020000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151020090342000549', NULL, NULL, NULL, '1054330046', '', ''),
('20150076', '2001', 'ESSOME NDJIEMO ', 'PIERRE CAMEL', '2000', '19711122000000000000', 'M', '', '675609152', 'SOUDEUR', '', 'TIG', '0', '1', '', '', NULL, '20151023000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151023093935000544', NULL, NULL, NULL, '110441819', '', ''),
('20150077', '2001', 'NGONDI ETAME MBE', 'ACHYL', '2000', '20151015000000000000', 'M', '', '677844308', '', '', 'CONG', '0', '1', '', '', NULL, '20151023000000000000', NULL, '', '2000', '2015', '1', 'tsonia', 'tsonia', '20151023110447000952', '20151023110542000098', NULL, NULL, '112027233', '', ''),
('20150078', '2002', 'METACHOMG ', 'SYLVIE BERNADETTE', '2000', '19771218000000000000', 'F', '', '665311340', 'SECRETAIRE', '', NULL, '0', '0', '', '', NULL, '20151023000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151023114619000741', NULL, NULL, NULL, '108979323', '', ''),
('20150079', '2001', 'KAMGA TCHOUAKE ', 'ELDAD SERED', '2000', '19891016000000000000', 'M', '', '690 935 901', 'MECANICIEN', '', '3TC', '0', '0', '', '', NULL, '20151023000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151023114917000101', NULL, NULL, NULL, '114888808', '', ''),
('20150080', '2001', 'TCHINDA', 'JOSEPH', '', NULL, 'M', '', '', 'CHAUFFEUR', '', 'STHYC', '0', '0', '', '', NULL, '20151021000000000000', NULL, '', '2000', '2015', '1', 'kviviane', NULL, '20151023140458000089', NULL, NULL, NULL, '', '', ''),
('20150081', '2001', 'TOCHE ', 'ALEXIS', '2000', '19700210000000000000', 'M', '', '670 07 35 02', 'CHAUFFEUR ', '', 'STHYC', '0', '1', '', '', NULL, '20151210000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151210074620000218', NULL, NULL, NULL, '108126666', '', ''),
('20150082', '2001', 'DUPONT NGWE', 'EDMOND ROLAND', '2003', '19870702000000000000', 'M', '', '698 37 00 96', 'MECANICIEN ', '', 'SUM', '0', '0', '', '', NULL, '20151210000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151210075042000658', NULL, NULL, NULL, '113614580', '', ''),
('20150083', '2001', 'TADJUIDJE ', 'JEAN PIERRE', '2000', '19601009000000000000', 'M', '', '699 26 83 36', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20151210000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151210094429000597', NULL, NULL, NULL, '115783747', '', ''),
('20150084', '2003', 'WOBE  MOUSSINGA', 'DOLIANE KRYNSKY', '2003', '19930301000000000000', 'F', '', '694421677', 'ELEVE', '', NULL, '0', '0', '', '', NULL, '20151214000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151214084029000131', NULL, NULL, NULL, '111938401', '', ''),
('20150085', '2001', 'TCHOUANKAM ', 'ROGER ', '2003', '19620710000000000000', 'M', '', '', '', '', 'EMEM', '0', '1', '', '', NULL, '20151214000000000000', NULL, '', '2000', '2015', '1', 'tsonia', NULL, '20151214095622000982', NULL, NULL, NULL, '107885523', '', ''),
('20160006', '2001', 'DEFO', '', '2000', '19610811000000000000', 'M', '', '', 'VENDEUR', '', 'CMC', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104131940000676', NULL, NULL, NULL, '108153360', '', ''),
('20160007', '2001', 'MBONJO ', 'GEORGES ALAIN', '2000', '19780823000000000000', 'M', '', '', 'COURSIER', '', 'ESICO', '0', '0', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104132723000172', NULL, NULL, NULL, '1182738995', '', ''),
('20160008', '2002', 'SOMSI ', 'CATHERINE OLIVE', '2000', '19810126000000000000', 'M', '', '', 'COURSIER', '', 'ESICO', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104133004000949', NULL, NULL, NULL, '1109909588', '', ''),
('20160009', '2001', 'WOUAFO KAMGUE', 'CONSTANTIN', '2000', '19850927000000000000', 'M', '', '', 'FRIGORISTE', '', 'CMC', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104133346000433', NULL, NULL, NULL, '115327362', '', ''),
('20160010', '2001', 'KAMDEM ', 'CLEMENT ', '2000', '19840404000000000000', 'M', '', '', '', '', 'ITS', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104133829000754', NULL, NULL, NULL, '1170113786', '', ''),
('20160011', '2001', 'MBOYO NJABEA', 'ANDRIS', '2000', '19851117000000000000', 'M', '', '', '', '', 'GEC', '0', '0', '', '', NULL, NULL, NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104134852000516', NULL, NULL, NULL, '', '', ''),
('20160012', '2001', 'FOTSO KENGNE ', 'LANDREY AIME', '2003', '19910616000000000000', 'M', '', '', 'VENDEUR', '', 'SOREPCO', '0', '0', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160104135324000632', '20160104151820000523', NULL, NULL, '112037059', '', ''),
('20160013', '2001', 'NZOMO ', 'YANNICK', '2000', '19910514000000000000', 'M', '', '670752234', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104140217000167', NULL, NULL, NULL, '117456785', '', ''),
('20160014', '2001', 'ANKELZAMBA ', 'GEORGES', '2000', '19860308000000000000', 'M', '', '697529347', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104140604000877', NULL, NULL, NULL, '107560811', '', ''),
('20160015', '2001', 'ELOCK ', 'THEOPHILE CHANCELIN', '2000', '19830603000000000000', 'M', '', '677 08 21 61', 'CHEF D''EQUIPE COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104140825000367', NULL, NULL, NULL, '108999385', '', ''),
('20160016', '2001', 'MBOYONG ', 'JACQUES ROGER BERTIN', '2000', '19840111000000000000', 'M', '', '694 28 34 75', 'CHAUDRONNIER/SOUDEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'fpatrick', '20160104141033000509', '20160104161308000313', NULL, NULL, '116412920', '', ''),
('20160017', '2001', 'ATEBA BEKONO', 'ROLLAND', '2000', '19741010000000000000', 'M', '', '677 87 01 78', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160104000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160104141220000615', NULL, NULL, NULL, '109748788', '', ''),
('20160018', '2001', 'SIPOWA ', 'MARTIN', '2000', '19810614000000000000', 'M', '', '679 66 53 95', 'OPERATEUR MACHINE', '', 'CMC', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105082433000540', NULL, NULL, NULL, '115807624', '', ''),
('20160019', '2001', 'MADJOUME ', 'MAGLOIRE', '2000', '19840615000000000000', 'M', '', '674 98 94 65', 'AIDE MAçon', '', 'SSBACHY', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105082704000673', NULL, NULL, NULL, '107155821', '', ''),
('20160020', '2001', 'BASSILEKIN', 'PIERRE PATRICE', '2003', NULL, 'M', '', '674 08 30 22', 'Maçon', '', 'SSW', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105082939000909', NULL, NULL, NULL, '115239139', '', ''),
('20160021', '2003', 'NDOUBI IKITINI ', 'VERONIQUE RAISSA', '2003', '19900101000000000000', 'F', '', '697186844', 'POINTEUSE', '', 'SSW', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105085049000015', NULL, NULL, NULL, '1189887045', '', ''),
('20160022', '2001', 'YOUMBA YOUMBA', 'MARIUS', '2003', '19850528000000000000', 'M', '', '675808218', 'Maçon', '', 'SSBACHY', '0', '0', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105085311000993', NULL, NULL, NULL, '117889358', '', ''),
('20160023', '2001', 'LOUMOU BETONDE ', 'CALVIN', '2003', '19780728000000000000', 'M', '', '699 17 78 53', 'CONDUCTEUR D''ENGIN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105092955000482', NULL, NULL, NULL, '111012539', '', ''),
('20160024', '2002', 'EDIMO ', 'HERMINE', '2003', '19810401000000000000', 'F', '', '699 52 87 70', 'RECEPTIONNISTE', '', 'HVP', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105095346000286', NULL, NULL, NULL, '115032660', '', ''),
('20160025', '2001', 'NACTCHAC ', 'MARXIME', '2003', '19920525000000000000', 'M', '', '', 'SOUDEUR', '', 'BR', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105110554000058', NULL, NULL, NULL, '115014641', '', ''),
('20160026', '2001', 'AHMAD', 'ABBA', '2003', '19850811000000000000', 'M', '', '699 86 73 97', 'COMPTABLE', '', 'STHYC', '0', '1', '', '', NULL, '20160105000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160105135115000797', NULL, NULL, NULL, '107225967', '', ''),
('20160027', '2001', 'MAKON MA NDENGA ', 'MARTIN', '2003', '19810310000000000000', 'M', '', '694094495', 'CHEF CHANTIER TERRASSEMNT', '', 'SSBACHY', '0', '1', '', '', NULL, '20160106000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160106083815000417', NULL, NULL, NULL, '107156220', '', ''),
('20160028', '2001', 'LONTSI NOTSA ', 'LANDRY', '2003', '19941119000000000000', 'M', '', '690228810', '', '', NULL, '0', '0', '', '', NULL, '20160106000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160106092624000217', NULL, NULL, NULL, '1173129176', '', ''),
('20160029', '2001', 'FOSSO TSINGOUM', 'VERLIN', '2000', '19840301000000000000', 'M', '', '674 95 35 41', 'ECHAFFAUDEUR /PEINTRE', '', 'COMETAL', '0', '1', '', '', NULL, '20160106000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160106094654000995', NULL, NULL, NULL, '111335104', '', ''),
('20160030', '2001', 'KAMDOUM ', 'JEAN CLAUDE', '2000', '19530416000000000000', 'M', '', '', 'COMPTABLE', '', NULL, '0', '0', '', '', NULL, '20160106000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160106131458000083', NULL, NULL, NULL, '106189186', '', ''),
('20160031', '2001', 'TCHINDA NOUSSI', 'GUY MARTIAL', '2003', '19900510000000000000', 'M', '', '696 72 34 29', 'ENFOULEUR', '', 'MENO', '0', '0', '', '', NULL, '20160106000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160106132725000856', NULL, NULL, NULL, '109495496', '', ''),
('20160032', '2001', 'YOUTCHOU ', 'HERVE', '2000', '19730509000000000000', 'M', '', '699900167', 'MONITEUR', '', 'STHYC', '0', '0', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107082854000597', NULL, NULL, NULL, '108044763', '', ''),
('20160033', '2001', 'DONKANE MESSOS', 'BENJAMIN', '2000', '19861128000000000000', 'M', '', '666916615', 'CONDUCTEUR COMPACTEUR', '', 'SSW', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107083555000615', NULL, NULL, NULL, '115185501', '', ''),
('20160034', '2001', 'MINYONG', 'GUY SYLVERE', '2003', '19840620000000000000', 'M', '', '676338145', 'CONDUCTEUR DE PELLE ESCAVATRICE', '', 'SSW', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107083833000570', NULL, NULL, NULL, '116737322', '', ''),
('20160035', '2001', 'DONGMO ', 'PATRICE', '2000', '19710120000000000000', 'M', '', '677 01 29 15', 'TOLIER', '', 'CMC', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107093906000574', NULL, NULL, NULL, '108671967', '', ''),
('20160036', '2001', 'ENYEGUE ABOMO ', 'DENIS', '2003', '19840515000000000000', 'M', '', '655 60 71 81', 'CHAUFFEUR', '', 'STHYC', '0', '0', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107094354000383', NULL, NULL, NULL, '117475295', '', ''),
('20160037', '2001', 'TEGUETSOP ', 'JEAN PIERRE', '2000', '19700429000000000000', 'M', '', '676833416', 'FERRAILLEUR', '', 'BR', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107100139000253', NULL, NULL, NULL, '111009223', '', ''),
('20160038', '2001', 'AMBA NDJANA ', 'GASTON', '2003', '19680111000000000000', 'M', '', '676 72 75 07', 'CUISINIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160107100945000981', '20160107101007000232', NULL, NULL, '1189886327', '', ''),
('20160039', '2001', 'PAUL BIYA EKWABI EWANE', '', '2003', '19840106000000000000', 'M', '', '679 937 348', 'CONTROLEUR GESTION', '', 'FLO', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107102429000119', NULL, NULL, NULL, '114433502', '', ''),
('20160040', '2003', 'DJUIKOUO KAMDEM ', 'INES ALPHONSINE', '2003', '19860824000000000000', 'F', '', '677 83 76 45', 'COMPTABLE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107102950000589', NULL, NULL, NULL, '116450436', '', ''),
('20160041', '2001', 'BOULOCK', 'BIOL ASER', '2003', '19810902000000000000', 'M', '', '', 'COURISER', '', 'COMETAL', '0', '1', '', '', NULL, '20160107000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160107145551000261', NULL, NULL, NULL, '117377615', '', ''),
('20160042', '2002', 'MEGUENO EPSE BAHEL ', 'GISELE FLORE', '2000', '19740217000000000000', 'M', '', '699 84 45 62', 'INFORMATICIENNE', '', 'STHYC', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108080032000559', NULL, NULL, NULL, '107023190', '', ''),
('20160043', '2001', 'BIKA ', 'LUC ROGER ', '2000', NULL, 'M', '', '69 00 65 119', 'CHAUFFEUR ', '', 'STHYC', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108080244000009', NULL, NULL, NULL, '11176245', '', ''),
('20160044', '2001', 'SONFACK BOGNI', 'GIRESSE', '2000', '19870405000000000000', 'M', '', '699 87 30 71', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108080450000366', NULL, NULL, NULL, '107570239', '', ''),
('20160045', '2001', 'FOSSOUO ', 'ANATOLE', '2000', '19770207000000000000', 'M', '', '690 067 435', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108080634000231', NULL, NULL, NULL, '109192403', '', ''),
('20160046', '2001', 'NKOUNGA FOTSO ', 'ARSENE ', '2003', '19860420000000000000', 'M', '', '696 35 37 33', 'POINTEUR', '', 'TAC', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108091812000481', NULL, NULL, NULL, '1184585673', '', ''),
('20160047', '2001', 'FOWO ', 'ENGELBERT MIRABEAU', '2000', '19740504000000000000', 'M', '', '694 68 55 36', 'CHARGE DES TRAVAUX', '', 'ITS', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108093650000964', NULL, NULL, NULL, '115159786', '', ''),
('20160048', '2001', 'MAKAMTO KUATCHE ', 'ORIANE', '2003', '19950605000000000000', 'M', '', '', 'ETUDIANTE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108103052000594', NULL, NULL, NULL, '115540345', '', ''),
('20160049', '2001', 'HAMIDOU ', 'ABDOURAOUF', '2000', '19720823000000000000', 'M', '', '', 'ADMIN SOCIETE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160108000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160108153320000694', NULL, NULL, NULL, '110551409', '', ''),
('20160050', '2001', 'ONGUENE ', 'MAURICE IRANKLIN', '2003', '19840902000000000000', 'M', '', '696 96 87 93', 'OPERATEUR PETIT MATERIEL', '', 'SSW', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109081212000562', NULL, NULL, NULL, '1112361111', '', ''),
('20160051', '2001', 'NTI MVOGO', 'JACQUES', '2000', '19630502000000000000', 'M', '', '696967256', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109081545000284', NULL, NULL, NULL, '115828154', '', ''),
('20160052', '2001', 'NGONA NWATSOK ', 'DESIRE AIME', '2002', '19611210000000000000', 'M', '', '696992457', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109082020000297', NULL, NULL, NULL, '107845121', '', ''),
('20160053', '2001', 'NDOUMBE ', 'DANIEL', '2000', '19591204000000000000', 'M', '', '696085449', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109082248000310', NULL, NULL, NULL, '1088575603', '', ''),
('20160054', '2001', 'ETOUNDI ', 'ACHILLE PARFAIT', '', '19820616000000000000', 'M', '', '', 'MANOEUVRE ', '', 'SSW', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109083025000203', NULL, NULL, NULL, '117697728', '', ''),
('20160055', '2001', 'NSASSAN NGUIRANG ', 'JEAN PAUL', '2003', '19900909000000000000', 'M', '', '676 99 22 46', 'MANOEUVRE', '', 'SSBACHY', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109083254000886', NULL, NULL, NULL, '1188819317', '', ''),
('20160056', '2001', 'ESSALAK MBOSSIBE ', 'PRISO', '2003', '19830604000000000000', 'M', '', '671 98 91 72', 'MANOEUVRE', '', 'SSBACHY', '0', '1', '', '', NULL, '20160109000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160109083501000776', NULL, NULL, NULL, '112566271', '', ''),
('20160057', '2001', 'KAMENI POUABE ', 'ACHILLE LANDRY', '2003', '19860121000000000000', 'M', '', '679 25 61 05', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111082525000659', NULL, NULL, NULL, '108772649', '', ''),
('20160058', '2001', 'YOUADEU LAPI', 'NICODEME JORDAN', '2003', '19860410000000000000', 'M', '', '697132215', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111082924000964', NULL, NULL, NULL, '110132909', '', ''),
('20160059', '2001', 'FODJI MANFOUA ', 'VALERY ROCHER', '2003', '19840427000000000000', 'M', '', '674 47 05 01', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111083427000963', NULL, NULL, NULL, '108757525', '', ''),
('20160060', '2001', 'OMAM ', 'FRANCOIS', '2000', '19690606000000000000', 'M', '', '679 50 45 81', 'CADRE ADMINISTRATIF ET JURIDIQUE', '', 'ACMS ', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111083818000157', NULL, NULL, NULL, '117632182', '', ''),
('20160061', '2001', 'TALLA ', 'ANDRE RAOUL', '2003', '19830626000000000000', 'M', '', '675 72 53 21', 'EXTRUCTION', '', 'CMC', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111084131000831', NULL, NULL, NULL, '115466233', '', ''),
('20160062', '2001', 'AKEDE ', 'FIDELE', '2000', '19740918000000000000', 'M', '', '670 24 82 29', 'MANOEUVRE', '', 'EMEM', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111090936000040', NULL, NULL, NULL, '115936315', '', ''),
('20160063', '2001', 'JACQUES NGACK BOSANG', '', '2003', '20160111000000000000', 'M', '', '696 23 78 70', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111091559000520', NULL, NULL, NULL, '113864981', '', ''),
('20160064', '2001', 'FOSSI ', 'ELIE', '2000', '19810705000000000000', 'M', '', '675 83 08 34', 'CARISTE', '', 'CONG', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111114704000005', NULL, NULL, NULL, '114936140', '', ''),
('20160065', '2001', 'ATANGA OLOA', '', '2000', '19640604000000000000', 'M', '', '655 95 22 26', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111115203000806', NULL, NULL, NULL, '11205292', '', ''),
('20160066', '2001', 'ZOA ZOA ', 'SIMEON NAZAIRE', '2003', '19800626000000000000', 'M', '', '675750045', 'CHAUFFEUR', '109983157', 'SSBMD', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111125850000394', NULL, NULL, NULL, '109983157', '', ''),
('20160067', '2001', 'WAMBO TALLA', 'FABRICE AIME', '2000', '19810516000000000000', 'M', '', '696094525', 'VENDEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111141334000519', NULL, NULL, NULL, '109221436', '', ''),
('20160068', '2001', 'TAKAM ', 'ALPHONSE', '2000', '19621112000000000000', 'M', '', '678 36 99 01', 'MECANINIEN', '', 'CONG', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111151426000088', NULL, NULL, NULL, '', '', ''),
('20160069', '2001', 'KENGNI', 'JEAN CLOVIS', '2000', '19820910000000000000', 'M', '', '', 'TOLIER', '', '3S', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111151742000055', NULL, NULL, NULL, '117259768', '', ''),
('20160070', '2003', 'WOUOME ', 'NADEGE MARIE NOEL', '2003', '19810103000000000000', 'F', '', '675 48 24 63', 'SURVEILLANTE DES TRAVAUX', '', 'SATOMWOURI', '0', '1', '', '', NULL, '20160111000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160111155602000072', NULL, NULL, NULL, '1180994622', '', ''),
('20160071', '2001', 'ALIMA ALIMA', 'EMILE ARNAUD', '2000', '19930408000000000000', 'M', '', '674 86 35 56', 'TOLIER', '', '3S', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112082206000007', NULL, NULL, NULL, '109576868', '', ''),
('20160072', '2001', 'TCHOUALACK ', 'ADRIEN WALTER', '2003', '19910212000000000000', 'M', '', '691 65 55 74', 'MECANICIEN', '', '3S', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112102717000456', NULL, NULL, NULL, '115814943', '', ''),
('20160073', '2001', 'TAMAFO LEMOFOUO', 'PAULIN', '2003', '19890619000000000000', 'M', '', '676 29 26 07', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112103048000406', NULL, NULL, NULL, '', '', ''),
('20160074', '2001', 'NGO BOUM ', 'XAVIER CHANTAL', '2003', '19881001000000000000', 'M', '', '694 75 0121', 'TECHNICIENNE DE SURFACE', '', 'FLO', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112104830000898', NULL, NULL, NULL, '1167459876', '', ''),
('20160075', '2001', 'ZOGNING AWOWO ', 'ERIC MARCEL', '2000', '19790106000000000000', 'M', '', '699 76 25 94', 'CONTROLEUR DE GESTION CHANTIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112114035000963', NULL, NULL, NULL, '108439329', '', ''),
('20160076', '2001', 'TALELE FOTSO', 'BRUNO MAGLOIRE', '2003', '19690904000000000000', 'M', '', '677846060/695158258', 'CHAUFFEUR CAMION TOUPIE', '', 'SSBMD', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112115350000794', NULL, NULL, NULL, '115925716', '', ''),
('20160077', '2001', 'SISSA ', 'JEAN ISAAC', '2003', '19840310000000000000', 'M', '', '697 26 39 93', 'CONDUCTEUR DE COMPACTEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112145946000427', NULL, NULL, NULL, '109296381', '', ''),
('20160078', '2001', 'AWONO  NOA', 'HERBIN', '2000', '19760127000000000000', 'M', '', '679 64 37 23', 'OPERATEUR TOPOGRAPHE', '', 'SSBACHY', '0', '1', '', '', NULL, '20160112000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160112161008000871', NULL, NULL, NULL, '109531298', '', ''),
('20160079', '2001', 'DEFO TABUE ', 'GUSTAVE ODILON', '2000', '19721005000000000000', 'M', '', '', 'CHAUFFEUR', '', 'SUM', '0', '1', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113080553000664', NULL, NULL, NULL, '114831112', '', ''),
('20160080', '2001', 'MANE WADJIE ', 'ANNE LITICIA', '2000', '19910423000000000000', 'M', '', '694 47 29 29', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113084326000399', NULL, NULL, NULL, '115942437', '', ''),
('20160081', '2001', 'DAMEGNI ', 'NELLO GAEL', '2003', '19930324000000000000', 'M', '', '674 59 64 60', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113084635000689', NULL, NULL, NULL, '110398323', '', ''),
('20160082', '2001', 'FOWA ', 'JEAN', '2000', '19740820000000000000', 'M', '', '672256585', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113093208000747', NULL, NULL, NULL, '110199834', '', ''),
('20160083', '2002', 'NDZUAKOU ', 'MERCEDES', '2004', '19440101000000000000', 'F', '', '699927726', 'MENAGERE', '', NULL, '0', '0', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113093710000740', NULL, NULL, NULL, '111367928', '', ''),
('20160084', '2001', 'TEFOUET ', 'ALAIN VICTOR', '2003', '19800428000000000000', 'M', '', '677 46 53 14', 'MAçON', '', 'SSW', '0', '1', '', '', NULL, '20160113000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160113123659000614', NULL, NULL, NULL, '108490973', '', ''),
('20160085', '2001', 'TCHAPDA', 'GUY MERLIN', '2000', '19770816000000000000', 'M', '', '677 57 08 20', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114082222000478', NULL, NULL, NULL, '107483511', '', ''),
('20160086', '2003', 'APAWA NGUEUTUE ', 'MADELEINE LINE', '2003', '19821011000000000000', 'M', '', '696607835', '', '', NULL, '0', '1', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114082552000392', NULL, NULL, NULL, '1124608143', '', ''),
('20160087', '2001', 'NOUKI TOUNDA ', 'VIALLE CHRISTIAN', '2003', '19691119000000000000', 'M', '', '112637056', 'TECHNICIENNE DE SURFACE', '', 'FLO', '0', '1', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114095105000567', NULL, NULL, NULL, '112637056', '', ''),
('20160088', '2002', 'NDOUMBE MBONJO ', 'HELENE DIANE', '2000', '19850607000000000000', 'M', '', '699 33 23 63', 'STANDARDISTE', '', 'COMETAL', '0', '1', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114102937000287', NULL, NULL, NULL, '111584917', '', ''),
('20160089', '2002', 'TEBUDE ', 'BEATRICE', '2002', '19750401000000000000', 'M', '', '676602760', 'HOSPITAL ADMINISTRATOR', '', NULL, '0', '0', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114124702000788', NULL, NULL, NULL, '', '', ''),
('20160090', '2001', 'MBIDA NTOLO', 'GUSTAVE NESTOR', '2000', '19751111000000000000', 'M', '', '', 'HOTELIER', '', 'SOREPCO', '0', '0', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114150035000587', NULL, NULL, NULL, '111202166', '', ''),
('20160091', '2001', 'KOUKPAKI ADEIKA', 'BERTRAND', '2000', '19750312000000000000', 'M', '', '', 'MENUISIER', '', 'HVP', '0', '1', '', '', NULL, '20160114000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160114151701000848', NULL, NULL, NULL, '110818777', '', ''),
('20160092', '2001', 'KAMSU ', 'FILBERT', '2000', '19760812000000000000', 'M', '', '674 93 91 20', 'RESPONSABLE QUALITE', '', 'EMEM', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115080000000600', NULL, NULL, NULL, '108191526', '', ''),
('20160093', '2001', 'NDANGA NGUINDA', 'ROLAND', '2000', '19800912000000000000', 'M', '', '', 'CARROSSIER', '', '3S', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115082041000332', NULL, NULL, NULL, '1186621782', '', ''),
('20160094', '2001', 'NGUELEFACK NGUETSA ', 'GODEFROY', '2000', '19820829000000000000', 'M', '', '670 86 20 66', '', '', 'CMC', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115082622000926', NULL, NULL, NULL, '109591848', '', ''),
('20160095', '2001', 'DJOTIO SONKOUE', 'GUY', '2000', '19860612000000000000', 'M', '', '677 55 85 72', 'CHAUDRONNIER', '', 'COMETAL', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115085025000467', NULL, NULL, NULL, '115934992', '', ''),
('20160096', '2001', 'BINAM BI BINAM ', 'BENJAMIN', '2000', '19900915000000000000', 'M', '', '', 'TOPOGRAPHE', '', 'SSW', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115153803000830', NULL, NULL, NULL, '', '', ''),
('20160097', '2001', 'HAMADAMA', 'JOSEPH', '2000', '19770905000000000000', 'M', '', '673 88 98 33', 'CONDUCTEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115161605000807', NULL, NULL, NULL, '108748688', '', ''),
('20160098', '2001', 'ESSOME BEKONO', 'GEORGES ALAIN', '2003', '19870117000000000000', 'M', '', '696 44 21 82', 'AIDE SERIGRAPHE', '', 'SSW', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115161838000907', NULL, NULL, NULL, '115093871', '', ''),
('20160099', '2001', 'MBOO', 'MICHEL', '2003', '19890421000000000000', 'M', '', '655 96 20 54', 'TOPOGRAPHE', '', 'SSW', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115162053000398', NULL, NULL, NULL, '108108389', '', ''),
('20160100', '2001', 'NOGNIBO', 'RICHARD DADIE', '2003', '19820602000000000000', 'M', '', '698 789 987', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115162414000468', NULL, NULL, NULL, '10797549', '', ''),
('20160101', '2001', 'OUM ', 'SERGE', '2000', '19870510000000000000', 'M', '', '699915528', 'AIDE TOPOGRAPHE', '', 'SSW', '0', '0', '', '', NULL, '20160115000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160115162655000595', NULL, NULL, NULL, '107048904', '', '');
INSERT INTO `tab_pat` (`COD_PAT`, `LIB_TIT`, `LIB_NOM`, `LIB_PRE`, `ENU_STA_MAT`, `DAT_NAIS`, `LIB_SEX`, `LIB_ADR`, `LIB_NUM_TEL`, `LIB_PROF`, `LIB_FON`, `COD_SOC`, `BOO_EST_ASS`, `BOO_EST_AFF`, `LIB_PER_CON`, `LIB_NUM_TEL_PER_CON`, `COD_ASS`, `DAT_ENREG`, `BOO_EST_ARCH`, `LIB_MED`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `LIB_ASS`, `LIB_SOC`, `LIB_NUM_CNI`, `LIB_NUM_CNPS`, `LIB_MAT`) VALUES
('20160102', '2001', 'HOSENI YABOKO', '', '2003', '19970726000000000000', 'M', '', '114429903', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118084052000938', NULL, NULL, NULL, '110538336', '', ''),
('20160103', '2001', 'ABDOULNASSIRI', '', '2000', '19780622000000000000', 'M', '', '677 00 66 18', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118084301000030', NULL, NULL, NULL, '114429903', '', ''),
('20160104', '2001', 'MBENTEM LEKEFACK', 'LANDRY', '2000', '19860225000000000000', 'M', '', '674 95 53 54', 'CHAUFFEUR TRACTEUR', '', '3TC', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118101820000477', NULL, NULL, NULL, '111975274', '', ''),
('20160105', '2001', 'POUWAWE', 'BONIFACE ARNAUD', '2003', '19900306000000000000', 'M', '', '662 95 11 47', 'TREMPORAIRE', '', 'CONG', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118102011000191', NULL, NULL, NULL, '109888332', '', ''),
('20160106', '2001', 'DJIELA KENKO ', 'IGNACE BILINCE', '2003', '19920110000000000000', 'M', '', '694 08 50 28', 'SOUDEUR', '', 'EMEM', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118104342000416', NULL, NULL, NULL, '108881392', '', ''),
('20160107', '2001', 'NDE MBA ', 'ROBERT', '2000', NULL, 'M', '', '696 27 75 60', '', 'CHAUFFEUR', 'STHYC', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118110345000872', NULL, NULL, NULL, '110472806', '110472806', ''),
('20160108', '2001', 'DJEUTCHOUANG DJIMO', 'MICHEL HERVE', '2000', '19750617000000000000', 'M', '', '694 436 921', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118110539000476', NULL, NULL, NULL, '109253396', '', ''),
('20160109', '2001', 'SILATCHOM', 'JUSTIN', '2003', '19960128000000000000', 'M', '', '673 03 36 56', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118111513000743', NULL, NULL, NULL, '1183774873', '', ''),
('20160110', '2001', 'NTOUBE ', 'MICHEL DIFANG', '2000', '19830513000000000000', 'M', '', '694 65 70 57', 'COURSIER', '', 'ESICO', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118115921000521', NULL, NULL, NULL, '', '', ''),
('20160111', '2002', 'MUBANG ', 'MARY BI', '2000', '19700521000000000000', 'M', '', '673 12 70 15', 'PRODUCTION', '', 'SAVES', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118123040000569', NULL, NULL, NULL, '117098731', '', ''),
('20160112', '2001', 'KAMGUE FOKO', 'ARNAUD', '2000', '19910124000000000000', 'M', '', '', 'MENUISIER', '', NULL, '0', '0', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118131753000502', NULL, NULL, NULL, '114779374', '', ''),
('20160113', '2001', 'TALLA ', 'BAURICE GREGOIRE', '2003', '19890415000000000000', 'M', '', '675459441', 'AIDE OUVRIER', '', 'SSBMD', '0', '0', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118132907000314', NULL, NULL, NULL, '108704497', '', ''),
('20160114', '2001', 'NGUEFACK  ', 'MARTIN SYLVAIN', '2000', '19820729000000000000', 'M', '', '676 49 31 24', 'SOUDEUR', '', 'EMEM', '0', '1', '', '', NULL, '20160118000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160118135551000993', NULL, NULL, NULL, '115014985', '', ''),
('20160115', '2001', 'FOTSOO KAMGA ', 'SERGE ROMEO ', '2000', '19791031000000000000', 'M', '', '699 43 62 02', 'INGENIEUR DE GENIE CIVIL', '', 'SSW', '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119081724000108', NULL, NULL, NULL, '112426175', '', ''),
('20160116', '2001', 'KENGNE ', 'ALAIN STEPHEN', '2003', '19900710000000000000', 'M', '', '656 33 01 11', 'MECANICIEN', '', 'STHYC', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119085124000590', NULL, NULL, NULL, '1088899174', '', ''),
('20160117', '2002', 'MBINGLO EPSE BUSHU', 'VERA ASHERI', '2000', '19840529000000000000', 'F', '', '', '', '', 'OLAM', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119085328000604', NULL, NULL, NULL, '1178297285', '', ''),
('20160118', '2001', 'WAHNYO MAKEUE ', 'MOISE EUSTACHE', '2003', '19900619000000000000', 'M', '', '694 51 09 59', 'LABORANTIN SPECIALISE', '', 'SSW', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119093341000800', NULL, NULL, NULL, '1189879756', '', ''),
('20160119', '2001', 'EVENHE ETEME', 'HENRI BERTRAND', '2003', '19890910000000000000', 'M', '', '695 95 08 81', 'LABORANTIN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119093546000884', NULL, NULL, NULL, '115936911', '', ''),
('20160120', '2001', 'FEUKAM TAGNE', 'BORIS FERDY', '2003', '19870718000000000000', 'M', '', '696828412', 'AIDE LABORANTIN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119093736000963', NULL, NULL, NULL, '109034459', '', ''),
('20160121', '2001', 'DJOMAHA ', 'ALPHONSE DESIRE', '2000', '19340703000000000000', 'M', '', '695663471', '', '', 'ESICO', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119093934000677', NULL, NULL, NULL, '10468971', '', ''),
('20160122', '2002', 'SIMO MAGAPTCHE', 'JUSTINE', '2000', '19580626000000000000', 'M', '', '699 66 76 57', 'CADRE DE BANQUE', '', 'GE', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119094153000807', NULL, NULL, NULL, '107700731', '', ''),
('20160123', '2001', 'NDJANA NKO', 'LAMBERT', '2000', '19880507000000000000', 'M', '', '', 'CONDUCTEUR D''ENGINS', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119101935000785', NULL, NULL, NULL, '116520974', '', ''),
('20160124', '2001', 'KAMDEM ', 'BERNARD', '2000', '19631210000000000000', 'M', '', '677 17 04 41', 'COMMERCANT', '', NULL, '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119102434000635', NULL, NULL, NULL, '', '', ''),
('20160125', '2002', 'ONGMANDAK EPSE BEKOTO', 'REGINE', '2000', '19531110000000000000', 'M', '', '694 41 33 18', 'MENAGERE', '', NULL, '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119103312000323', NULL, NULL, NULL, '115786302', '', ''),
('20160126', '2001', 'KENGNE ', 'FRANCKY', '2003', '19900925000000000000', 'M', '', '675 16 30 77', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119104144000993', NULL, NULL, NULL, '110148351', '', ''),
('20160127', '2001', 'GEORGE MBAH KEDZEKA', '', '2000', '19680504000000000000', 'M', '', '677 07 0228', 'CHEF D''EQUIPE FERRAILLEUR', '', 'SSBACHY', '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119111155000937', NULL, NULL, NULL, '107844151', '', ''),
('20160128', '2001', 'JAMES ACHA MUNAGWI JUNIOR', '', '2003', '19871205000000000000', 'M', '', '672 26 16 12', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119111419000141', NULL, NULL, NULL, '11468 75 40', '', ''),
('20160129', '2001', 'FRANCIS EKAMBI KABA', '', '2003', '19880127000000000000', 'M', '', '675 88 93 73', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119111728000119', NULL, NULL, NULL, '114645950', '', ''),
('20160130', '2001', 'KWAMEN ', 'MATHIEU', '2003', '19750927000000000000', 'M', '', '679 39 93 81', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119114444000565', NULL, NULL, NULL, '109088682', '', ''),
('20160131', '2001', 'MBONDI ', 'PAUL ', '2000', '19630710000000000000', 'M', '', '697 37  83 46', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119123344000456', NULL, NULL, NULL, '116075763', '', ''),
('20160132', '2001', 'MBONGUE ', 'VICTOR', '2003', '19680906000000000000', 'M', '', '696 64 75 15', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119123546000167', NULL, NULL, NULL, '113796923', '', ''),
('20160133', '2001', 'NJOCKE ', 'DIDIER ALAIN', '2003', '19680229000000000000', 'M', '', '696 65 95 74', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119123738000886', NULL, NULL, NULL, '115082094', '', ''),
('20160134', '2001', 'LAHA ', 'HENRI', '2003', '19721218000000000000', 'M', '', '673 08 68 68', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119130856000804', NULL, NULL, NULL, '108977649', '', ''),
('20160135', '2001', 'TSANGA ', 'TOBIE', '2003', '19761001000000000000', 'M', '', '673 00 26 08', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119131105000156', NULL, NULL, NULL, '1186697827', '', ''),
('20160136', '2003', 'YAKAM ', 'ROSINE', '2003', '19900626000000000000', 'F', '', '673 17 33 73', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119131314000781', NULL, NULL, NULL, '116388569', '', ''),
('20160137', '2001', 'MBOUENDEU ', 'JEAN CLAUDE', '2000', '19790907000000000000', 'M', '', '694 53 51 71', 'VENDEUR', '', NULL, '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119145356000982', NULL, NULL, NULL, '109205823', '', ''),
('20160138', '2002', 'MBGA EDOU ', 'SABINE', '2000', '19900910000000000000', 'M', '', '695 85 60 08', 'ELEVE', '', NULL, '0', '0', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119145545000532', NULL, NULL, NULL, '109471820', '', ''),
('20160139', '2001', 'MPELI ', 'MARCEL GAETAN', '2003', '19870709000000000000', 'M', '', '670 13 82 78', 'MECANICIEN', '', '3S', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119151939000875', NULL, NULL, NULL, '113711838', '', ''),
('20160140', '2001', 'MBALLA ', 'JEAN CLAUDE', '2003', '19840413000000000000', 'M', '', '693 36 67 41', 'INGENIEUR DES TRAVUX', '', 'SSBACHY', '0', '1', '', '', NULL, '20160119000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160119154104000669', NULL, NULL, NULL, '170227152', '', ''),
('20160141', '2001', 'PEPOUBONEKO ', 'SEBASTIEN', '2000', '19860121000000000000', 'M', '', '675 98 79 116', 'MECANICIEN', '', 'STHYC', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120081108000309', NULL, NULL, NULL, '', '', ''),
('20160142', '2001', 'TOKAM NONO', 'SAMUEL ', '2000', '19840209000000000000', 'M', '', '', 'CARISTE', '', 'CMC', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120082339000388', NULL, NULL, NULL, '115530555', '', ''),
('20160143', '2001', 'KAMDEM ', 'FRANC DELON', '2003', '19910915000000000000', 'M', '', '654 58 32 40', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120093027000122', NULL, NULL, NULL, '110306157', '', ''),
('20160144', '2001', 'MONTHE SENGA ', 'FRANCK CABREL', '2003', '19901214000000000000', 'M', '', '678 88 98 45', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120111449000366', NULL, NULL, NULL, '110706572', '', ''),
('20160145', '2001', 'MEKINDA ', 'JEAN PAUL', '2003', '20160120000000000000', 'M', '', '653 18 89 43', '', '', 'SSBMD', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120112149000952', NULL, NULL, NULL, '112059926', '', ''),
('20160146', '2001', 'NGAH ABOUDI ', 'CHRISTIAN', '2003', '19860325000000000000', 'M', '', '676 94 40 72', '', '', 'SSBMD', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120112337000893', NULL, NULL, NULL, '108027203', '', ''),
('20160147', '2001', 'M. TSAGUE TADONGE ', 'FRANCK BORIS', '2003', '19910505000000000000', 'M', '', '652 10 16 42', 'CHAUFFEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120114226000811', NULL, NULL, NULL, '113874694', '', ''),
('20160148', '2001', 'TSAGUE TADONCE', 'FRANCK BORIS', '2003', '19910505000000000000', 'M', '', '652101642', 'CHAUFFEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160120000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160120121123000843', NULL, NULL, NULL, '113874694', '', ''),
('20160149', '2001', 'SALLA ', 'FRITZ', '2003', '19560724000000000000', 'M', '', '694 42 85 36', 'MECANICIEN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121072712000613', NULL, NULL, NULL, '112368693', '', ''),
('20160150', '2001', 'DEUGOUE ', 'GUY MARCIAL', '2003', '19800913000000000000', 'M', '', '699 13 99 48', 'ELECTROMECANICIEN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121073150000980', NULL, NULL, NULL, '1149699812', '', ''),
('20160151', '2001', 'SONTSA ', 'JEAN MARIE', '2000', '19740102000000000000', 'M', '', '697 23 05 14', 'MECANICIEN', '', 'STHYC', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121074443000570', NULL, NULL, NULL, '110791082', '', ''),
('20160152', '2001', 'DIZAOU TAIPANA ', 'PROCHORE', '2003', '19850303000000000000', 'M', '', '', 'CHAUFFEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121075554000885', NULL, NULL, NULL, '115991227', '', ''),
('20160153', '2001', 'TEPOUORE', 'ABOUKAKAR', '2003', '19910213000000000000', 'M', '', '697 58 09 08', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121081313000405', NULL, NULL, NULL, '1188016252', '', ''),
('20160154', '2001', 'TCHOUPE ', 'JEAN', '2000', '19821106000000000000', 'M', '', '677781261', 'SOUDURE', '', 'CONG', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121091651000054', NULL, NULL, NULL, '', '', ''),
('20160155', '2001', 'GOKENG ', 'JEAN PAUL', '2000', '19711011000000000000', 'M', '', '698 95 48 80', 'CHAUFFEUR TRACTEUR', '', '3TC', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121093731000511', NULL, NULL, NULL, '114092839', '', ''),
('20160156', '2001', 'SOPPO KINGUE', 'ROBERT ARMAND', '2003', '19860723000000000000', 'M', '', '696 54 40 44', '', '', 'SOPHYNET ', '0', '1', '', '', NULL, '19860723000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121094659000774', NULL, NULL, NULL, '108467040', '', ''),
('20160157', '2001', 'DJAMEN LEUKEU ', 'NARCISSE SAMUEL', '2000', '19870602000000000000', 'M', '', '675 70 44 02', 'CHAUFFEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121111416000756', NULL, NULL, NULL, '117424154', '', ''),
('20160158', '2001', 'KARNGONG ', 'RICHARD LENYUY', '2003', '19720602000000000000', 'M', '', '676 78 7 9 83', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121111650000557', NULL, NULL, NULL, '1169319776', '', ''),
('20160159', '2001', 'PILOKO ', 'BENOIT WALTER', '2003', '19840720000000000000', 'M', '', '', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121131712000704', NULL, NULL, NULL, '1186754335', '', ''),
('20160160', '2001', 'NSIA EPANGUE ', 'SAMUEL', '2003', '19931106000000000000', 'M', '', '691 05 74 47', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121131931000732', NULL, NULL, NULL, '1183937273', '', ''),
('20160161', '2001', 'NGOLA NGONPI ', 'JEAN PIERRE', '2003', '19911231000000000000', 'M', '', '655 75 08 11', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121165814000570', NULL, NULL, NULL, '110915754', '', ''),
('20160162', '2001', 'MBOGNE ', 'DIDIER CONSTANT', '2003', '19861025000000000000', 'M', '', '', 'COFFREUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160121000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160121170141000400', NULL, NULL, NULL, '110473476', '', ''),
('20160163', '2001', 'TIODJIO', 'ROBERT', '2000', '19731212000000000000', 'M', '', '', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122075238000597', NULL, NULL, NULL, '113382891', '', ''),
('20160164', '2001', 'NJIBOUO ', 'JEAN PIERRE', '2000', '19741031000000000000', 'M', '', '677854636', 'CHAUFFEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122075531000789', NULL, NULL, NULL, '107041888', '', ''),
('20160165', '2001', 'NDOUM PENDA', 'EMMANUEL', '2003', '19811212000000000000', 'M', '', '696 17 03 21', 'ELINGUEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122075838000350', NULL, NULL, NULL, '111948119', '', ''),
('20160166', '2001', 'GNOUATSA NGOUANA ', 'ROSTANT DIDI', '2000', '19800124000000000000', 'M', '', '675 55 83 81', 'CHAUFFEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122084514000405', NULL, NULL, NULL, '107587471', '', ''),
('20160167', '2001', 'ADAMU ', 'SEIDOU', '2000', '19780315000000000000', 'M', '', '6 77 47 57 77', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122094551000146', NULL, NULL, NULL, '115725975', '', ''),
('20160168', '2001', 'FONE TASSOP', 'LOUIS', '2000', '19671115000000000000', 'M', '', '654 01 23 93', 'CALLIBREUR', '', 'CONG', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122095728000783', NULL, NULL, NULL, '', '', ''),
('20160169', '2001', 'BANDIO ', 'OLIVIER ETIENNE', '2003', '19700628000000000000', 'M', '', '696 36 79 01', 'MECANICIEN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122100315000046', NULL, NULL, NULL, '114692236', '', ''),
('20160170', '2001', 'MOUNDI KAIN', 'MOUSTAPHA', '2003', '19901120000000000000', 'M', '', '693 60 59 80', 'VITRIER', '', 'BR', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122102053000797', NULL, NULL, NULL, '117622520', '', ''),
('20160171', '2001', 'TCHINDA ', 'BRICE', '2003', '19950501000000000000', 'M', '', '650 45 60 89', 'MANOEUVRE', '', 'BR', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122102304000393', NULL, NULL, NULL, '113796647', '', ''),
('20160172', '2001', 'EHIK BELLA', 'EUGENE', '2000', '19780405000000000000', 'M', '', '671 32 86 40', 'FERRAILLEUR', '', 'SSW', '0', '0', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122103204000175', NULL, NULL, NULL, '112616315', '', ''),
('20160173', '2001', 'ZOGO YEBEGA ', 'FAUSTIN', '2003', '19790427000000000000', 'M', '', '675 14 66 17', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122103353000474', NULL, NULL, NULL, '109762429', '', ''),
('20160174', '2001', 'YETNA ', 'JOSEPH', '2003', '19671114000000000000', 'M', '', '671 35 78 42', 'FERRRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122103911000681', NULL, NULL, NULL, '108702254', '', ''),
('20160175', '2001', 'DOUMBE DOUMBE ', 'JEAN DANIEL', '2003', '19860316000000000000', 'M', '', '697 99 40 26', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122104133000379', NULL, NULL, NULL, '114874469', '', ''),
('20160176', '2001', 'KOKO A FIEDIECK ', 'FLORA WALTER', '2003', '19870413000000000000', 'M', '', '697 577 486', '', '', 'EMEM', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122121541000658', NULL, NULL, NULL, '', '', ''),
('20160177', '2001', 'EBODE ', 'SIMEON OLIVIER', '2003', '19910707000000000000', 'M', '', '698 31 19 18', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122122457000287', NULL, NULL, NULL, '116166268', '', ''),
('20160178', '2002', 'FONO NGOUNOU', 'ELIANE FRANCINE', '2003', '19890219000000000000', 'F', '', '674 24 56 63', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122150530000879', NULL, NULL, NULL, '111697575', '', ''),
('20160179', '2001', 'KOOH MAYO', 'PHILIPPE', '2003', '19731228000000000000', 'M', '', '696 48 51 93', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122170506000313', NULL, NULL, NULL, '114079793', '', ''),
('20160180', '2001', 'MBA ', 'NACER', '2000', '19780324000000000000', 'M', '', '675 862264', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122170718000508', NULL, NULL, NULL, '107971183', '', ''),
('20160181', '2001', 'DAOUDA ', 'EZEKIEL', '2003', '19770101000000000000', 'M', '', '670 15 17 66', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122171316000419', NULL, NULL, NULL, '116351323', '', ''),
('20160182', '2001', 'YALLA', 'JEAN PIERRE', '2000', '19610406000000000000', 'M', '', '675 65 53 18', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160122000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160122171456000064', NULL, NULL, NULL, '109650223', '', ''),
('20160183', '2002', 'TAGNE BAKAM EPSE KAMENI', 'CARINE', '2000', '19930622000000000000', 'F', '', '679 34 41 07', 'EMPLOYE DE BUREAU', '', '3S', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123082021000696', NULL, NULL, NULL, '117295618', '', ''),
('20160184', '2001', 'TADJUIDJE ', 'JEAN PIERRE', '2000', '19601009000000000000', 'M', '', '699 268336', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123084105000143', NULL, NULL, NULL, '115783747', '', ''),
('20160185', '2001', 'NANA NDJANGANG ', 'CLAUDE ', '2000', '19840613000000000000', 'M', '', '696 38 39 77', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123084625000534', NULL, NULL, NULL, '1088835750', '', ''),
('20160186', '2001', 'KELLY ', 'PETER FOY', '2000', '19600818000000000000', 'M', '', '670632421', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123094957000002', NULL, NULL, NULL, '115415238', '', ''),
('20160187', '2001', 'BWENBA MBOE ', 'SAMUEL PIUS', '2000', '19771111000000000000', 'M', '', '674 43 11 81', 'PATISSIER', '', 'MENO', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123095321000129', NULL, NULL, NULL, '115036820', '', ''),
('20160188', '2001', 'NAOUSSI ', 'OLIVIER ', '2000', '19730204000000000000', 'M', '', '699 60 13 84', 'CHAUFFEUR ', '', 'STHYC', '0', '1', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123101831000742', NULL, NULL, NULL, '114691131', '', ''),
('20160189', '2001', 'MOUGANG ', 'EMMANUEL', '2000', '19611121000000000000', 'M', '', '699 72 23 21', 'CHAUFFEUR', '', 'STHYC', '0', '0', '', '', NULL, '20160123000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160123103058000199', NULL, NULL, NULL, '110804624', '', ''),
('20160190', '2002', 'ESSENGUE ', 'MARTINE JUDITH', '2003', '19721120000000000000', 'M', '', '695650551', 'FEMME DE MENAGE', '', 'SSBACHY', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125080538000562', NULL, NULL, NULL, '111247040', '', ''),
('20160191', '2001', 'FOTSO ', 'SYLVAIN', '2003', '19781128000000000000', 'M', '', '694 95 68 07', 'JARDINIER', '', 'STHYC', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125081633000419', NULL, NULL, NULL, '117935501', '', ''),
('20160192', '2001', 'KAPTOUOM ', 'ANTOINE', '2000', '19520101000000000000', 'M', '', '694 56 13 91', 'MECANICIEN', '', 'STHYC', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125081920000699', NULL, NULL, NULL, '117424244', '', ''),
('20160193', '2001', 'FOTSO TEDEFO ', 'ALAIN', '2003', '19830217000000000000', 'M', '', '674426169', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125082103000206', NULL, NULL, NULL, '115780967', '', ''),
('20160194', '2001', 'BILLE MBOKO ', 'MARTIN', '2003', '19710828000000000000', 'M', '', '699820497', 'FERRAILEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125082240000785', NULL, NULL, NULL, '103025686', '', ''),
('20160195', '2001', 'LOWE', 'FABRICE', '2003', '19771006000000000000', 'M', '', '', 'MECANICIEN', '', 'EMEM', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125082310000208', NULL, NULL, NULL, '108174503', '', ''),
('20160196', '2001', 'LEGA ', 'THEODORE', '2003', '19860507000000000000', 'M', '', '697 22 02 40', 'CONDUCTEUR', '', 'BR', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125083943000332', NULL, NULL, NULL, '', '', ''),
('20160197', '2001', 'TONYE  KWE', 'ALBERT', '2003', '19830606000000000000', 'M', '', '696 710 344', 'GRUTIER', '', 'SSBACHY', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125102857000033', NULL, NULL, NULL, '114674427', '', ''),
('20160198', '2001', 'DONFACK ', 'MARTIAL', '2000', '19830511000000000000', 'M', '', '695 06 63 62', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125104756000248', NULL, NULL, NULL, '117018463', '', ''),
('20160199', '2001', 'PETATO ', 'GILBERT', '2000', '19850620000000000000', 'M', '', '673 04 96 51', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125105006000791', NULL, NULL, NULL, '1180064751', '', ''),
('20160200', '2001', 'TCHUENKAM KAMDEM', 'SERGE ALAIN', '2003', '19861030000000000000', 'M', '', '697 12 60 31', 'EMPLOYE DE BUREAU', '', 'SOREPCO', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125105239000946', NULL, NULL, NULL, '114603657', '', ''),
('20160201', '2001', 'NDE ', 'PIERRE CLARENCE', '2000', '19761004000000000000', 'M', '', '694 11 37 86', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125111215000936', NULL, NULL, NULL, '109112299', '', ''),
('20160202', '2001', 'NDONGO DJOB', 'MATHIAS', '2000', '19710122000000000000', 'M', '', '677 84 77 06', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160125000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160125113950000135', NULL, NULL, NULL, '113309844', '', ''),
('20160203', '2001', 'TSAMO TSAGUE ', 'ERIC THIERRY', '2003', '19740607000000000000', 'M', '', '675 75 13 17', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126081352000681', NULL, NULL, NULL, '1114665646', '', ''),
('20160204', '2001', 'SOUSSOUSSI NGUENYEMO', 'SEBASTIEN', '2000', '19650407000000000000', 'M', '', '677 83 53 89', 'CHAUFFEUR', '', 'TAC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126083347000830', NULL, NULL, NULL, '117463690', '', ''),
('20160205', '2002', 'FANDJIO SEUMEN', '', '2000', '19780905000000000000', 'F', '', '676070005', 'CAISSIERE', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126083556000842', NULL, NULL, NULL, '1104819796', '', ''),
('20160206', '2002', 'KENGNE FOKO ', 'EDITH ', '2000', '19870610000000000000', 'F', '', '675795223', 'SECRETAIRE', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126083801000409', NULL, NULL, NULL, '1081247089', '', ''),
('20160207', '2001', 'CHOUPO ', 'YANNICK STEPHANE', '2003', '19890215000000000000', 'M', '', '671 35 99 33', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126084053000118', NULL, NULL, NULL, '1084273579', '', ''),
('20160208', '2001', 'TCHAKAM ', 'EASILE MAURICE', '2003', '19770917000000000000', 'M', '', '675 75 14 20', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126084232000412', NULL, NULL, NULL, '', '', ''),
('20160209', '2001', 'MAYOU NDAM', 'AMED BACHIR', '2000', '19810830000000000000', 'M', '', '677282046', 'Maçon', '', 'SSW', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126084446000853', NULL, NULL, NULL, '113737832', '', ''),
('20160210', '2001', 'BIYIHA ', 'ETIENNE FREDY', '2000', '19880208000000000000', 'M', '', '696 66 54 92', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126091032000087', NULL, NULL, NULL, '107575330', '', ''),
('20160211', '2002', 'NTCHICHOEUE KAMTE EPSE SASSUM', 'HUGUETTE NADINE', '2000', '19810414000000000000', 'M', '', '679 99 53 23', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126091254000078', NULL, NULL, NULL, '108997082', '', ''),
('20160212', '2001', 'LOUMOUSNA', 'ALPHONSE', '2000', '19840101000000000000', 'M', '', '679 71 10 38', 'OUVRIER', '', 'SUM', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126091757000343', NULL, NULL, NULL, '108082795', '', ''),
('20160213', '2001', 'AVODO BESSALA', 'FABIEN', '2000', '19820102000000000000', 'M', '', '698390608', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126101027000627', NULL, NULL, NULL, '107441536', '', ''),
('20160214', '2001', 'BETAKITEMB ', 'OLIVIER ROLAND', '2003', '19750812000000000000', 'M', '', '694 25 32 57', 'MECANICIEN/CHAUFFEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126101248000009', NULL, NULL, NULL, '116336761', '', ''),
('20160215', '2001', 'NANA SAHA ', 'GIRESSE THIERRY', '', '19850812000000000000', 'M', '', '674 78 98 86', 'LAVEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126104236000322', NULL, NULL, NULL, '1188728177', '', ''),
('20160216', '2001', 'NGANOU ', 'SAMUEL', '2000', '19600724000000000000', 'M', '', '699 70 88 53', 'FERRAILLEUR', '', 'BR', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126104513000872', NULL, NULL, NULL, '108355774', '', ''),
('20160217', '2001', 'NOUPA TCHAKOUNTE', 'EMERIC', '2003', '19821021000000000000', 'M', '', '677 68 02 02', 'AGENT COMMERCIAL', '', 'FLO', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126124135000731', NULL, NULL, NULL, '11685993', '', ''),
('20160218', '2001', 'DEFFEU FOKOUO', 'LAMBERT', '2000', '19680917000000000000', 'M', '', '675 27 57 41', 'MECANIICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126133753000556', NULL, NULL, NULL, '108883432', '', ''),
('20160219', '2001', 'EBONGUE LENGUE ', 'FREDERIC ', '2000', '19690131000000000000', 'M', '', '697 36 33 79', 'COMPTABLE', '', 'SSBMD', '0', '1', '', '', NULL, '20160126000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160126135105000180', NULL, NULL, NULL, '115936746', '', ''),
('20160220', '2001', 'TOCHE ', 'ALEXIS', '2000', '19700208000000000000', 'M', '', '670073502', 'CHAUFFEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127081430000348', NULL, NULL, NULL, '108126666', '', ''),
('20160221', '2001', 'NGANMIGNI ', 'ACHILLE ROBESPIERRE', '2000', '19740227000000000000', 'M', '', '697 06 13 15', 'SUPERVISEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127081815000909', NULL, NULL, NULL, '1183939741', '', ''),
('20160222', '2001', 'TCHOUBOU ', 'HERVE PARFAIT', '2000', '19820703000000000000', 'M', '', '109638037', 'AGENT D''ENTRETIEN', '', 'STHYC', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127084645000492', NULL, NULL, NULL, '109638037', '', ''),
('20160223', '2001', 'SIGNE ', 'WILLIAMS', '2003', '19870128000000000000', 'M', '', '676 26 56 09', 'COMPTABLE', '', 'STHYC', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127084831000894', NULL, NULL, NULL, '107735846', '', ''),
('20160224', '2001', 'KENGNE ', 'ANDRE MARIE', '2000', '19790130000000000000', 'M', '', '651 88 28 78', 'CONVOYEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127112400000410', NULL, NULL, NULL, '1107101043', '', ''),
('20160225', '2003', 'MAKOLLO EPEE', 'MOSSI MARIE', '2003', '19801018000000000000', 'F', '', '656 71 46 46', 'OPERATTICE SOGEMAT', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127120612000778', NULL, NULL, NULL, '109970345', '', ''),
('20160226', '2001', 'KOUENGUE ', 'ARMAND', '2000', '19610827000000000000', 'M', '', '691261501', 'CHEF CHANTIER GC', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127120943000791', NULL, NULL, NULL, '107147752', '', ''),
('20160227', '2002', 'NGUEMNENG ', 'NELLY MICHELLE', '2003', '19820102000000000000', 'M', '', '679959763', 'OPERATRICE SOGEMAT', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127121234000135', NULL, NULL, NULL, '108156277', '', ''),
('20160228', '2002', 'TANKEU NGASSAM EPSE DJIAHA NGAMALEU ', 'CATHY', '2000', '19830516000000000000', 'M', '', '691130140', 'SECRETAIRE MATERIEL', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127121452000234', NULL, NULL, NULL, '1187223213', '', ''),
('20160229', '2001', 'KENGNE ', 'APPOLINAIRE', '2000', '19720905000000000000', 'M', '', '1094339364', 'CHAUFFEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127141358000764', NULL, NULL, NULL, '109433926', '', ''),
('20160230', '2001', 'MVOGO MBIA ', 'EMILE ANSELME', '2003', '19860101000000000000', 'M', '', '696448306', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127141606000985', NULL, NULL, NULL, '116449562', '', ''),
('20160231', '2001', 'MVELLE POLYE ', 'FREDERIC', '2003', '19841107000000000000', 'M', '', '696062867', 'CHAUFFEUR VL', '', 'SSBMD', '0', '1', '', '', NULL, '20160127000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160127141828000250', NULL, NULL, NULL, '115431871', '', ''),
('20160232', '2000', 'KAMGA MOCHE', 'STACY', '', '20070401000000000000', 'M', '', '699673315', '', '', NULL, '0', '0', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128081407000172', NULL, NULL, NULL, '', '', ''),
('20160233', '2001', 'TAMOUAFO GHOTICK ', 'JEAN ', '2003', '19690101000000000000', 'M', '', '694146871', 'SUPERVISEUR', '', 'STHYC', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128084325000776', NULL, NULL, NULL, '111382968', '', ''),
('20160234', '2001', 'BITOUNOU MBEZELE ', 'JEAN CONSTANT', '2000', '19610311000000000000', 'M', '', '691 13 00 19', 'CHAUFFEUR', '', 'SSBMD', '0', '0', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128085025000281', NULL, NULL, NULL, '108557315', '', ''),
('20160235', '2002', 'TCHAPTCHET NGANGUE ', 'KORINE MICHELLE', '2003', '19810528000000000000', 'M', '', '691 13 01 41', 'MAGASINIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128094839000156', NULL, NULL, NULL, '110922611', '', ''),
('20160236', '2002', 'SOPO MANGAN', 'ANGE LISETTE', '2003', '19820811000000000000', 'M', '', '699 61 02 48', 'ASSISTANTE DE DIRECTION', '', 'SSBMD', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128095120000754', NULL, NULL, NULL, '115527323', '', ''),
('20160237', '2002', 'DJUIMELA TALLA', 'JAPHET NAOMI', '2003', '19911112000000000000', 'F', '', '', 'COMPTABLE', '', 'SSBMD', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128095403000400', NULL, NULL, NULL, '109885543', '', ''),
('20160238', '2001', 'BANGMO ', 'SAMUEL', '2000', '19580215000000000000', 'M', '', '691130131', 'CHAUFFEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128095733000322', NULL, NULL, NULL, '117021046', '', ''),
('20160239', '2001', 'BOTAME', 'EMILE', '2003', NULL, 'M', '', '698 95 8182', 'CHAUFFEUR COURSIER', '', '3TC', '0', '0', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160128120345000568', '20160128120414000205', NULL, NULL, '108343594', '', ''),
('20160240', '2001', 'NONO', 'ERNEST', '2000', '19740913000000000000', 'M', '', '', 'COURSIER', '', 'ESICO', '0', '1', '', '', NULL, '20160128000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160128130502000267', NULL, NULL, NULL, '117082532', '', ''),
('20160241', '2002', 'SANDJO MBETMI', 'LEONCE', '2003', '19901231000000000000', 'F', '', '673 21 80 09', 'CUISINIERE', '', 'SSBMD', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129083937000530', NULL, NULL, NULL, '117803920', '', ''),
('20160242', '2001', 'NSAYOU', 'ETIENNE', '2000', '19760731000000000000', 'M', '', '675 38 93 22', 'OUVRIER', '', 'SUM', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129084209000720', NULL, NULL, NULL, '110564548', '', ''),
('20160243', '2001', 'TAYOU', 'ALBERT', '2000', '19741215000000000000', 'M', '', '677 70 66 66', 'ATELIER', '', 'CMC', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129091732000071', NULL, NULL, NULL, '', '', ''),
('20160244', '2003', 'TETSSOP MEKEMDENG', 'ISABELLE NADIA', '2003', '19930507000000000000', 'M', '', '694 84 52 44', 'ASSISTANTE ADMINISTRATIF RH', '', 'EMEM', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129093313000691', NULL, NULL, NULL, '114273864', '', ''),
('20160245', '2002', 'MAGNE FOGUE EPSE KUATE', 'OLIVE', '2000', '19790307000000000000', 'F', '', '699 80 71 13', 'SECRETAIRE', '', 'TAC', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129104612000848', NULL, NULL, NULL, '110813809', '', ''),
('20160246', '2001', 'NOTTTI ', 'JEAN CIRILE', '2003', '19810914000000000000', 'M', '', '656 40 92 23', 'FERRAILLEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129110548000616', NULL, NULL, NULL, '110701471', '', ''),
('20160247', '2001', 'BOUKLIBO', 'JEAN', '2000', '19710101000000000000', 'M', '', '1184614557', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129110736000252', NULL, NULL, NULL, '1184614557', '', ''),
('20160248', '2001', 'BETCHEM  ', 'JEAN PIERRE', '2000', '19580413000000000000', 'M', '', '675 01 44 87', 'MACHINISTE', '', 'SITRA', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129111254000850', NULL, NULL, NULL, '1180384694', '', ''),
('20160249', '2001', 'FOKA KAMDEM ', 'ARTHUR VICTOIR', '2003', '19820716000000000000', 'M', '', '675 41 23 77', 'NETTOYEUR', '', 'FLO', '0', '1', '', '', NULL, '20160129000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160129114742000161', NULL, NULL, NULL, '1181773546', '', ''),
('20160250', '2001', 'ISSA AYATOU ', 'HALIM', '2000', '19850107000000000000', 'M', '', '695 92 88 00', 'CHAUFFEUR ', '', 'ESICO', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201084738000518', NULL, NULL, NULL, '113857802', '', ''),
('20160251', '2001', 'BUGHE ', 'DIEUDONNE', '2003', '19890725000000000000', 'M', '', '677 02 93 91', 'PATISSIER', '', 'MENO', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201093324000421', NULL, NULL, NULL, '111472993', '', ''),
('20160252', '2001', 'KEPTCHOUANG KADJI ', 'SYLVESTRE ', '2000', '19790209000000000000', 'M', '', '697 58 88 27', 'MENUISIER', '', 'BR', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201095906000046', NULL, NULL, NULL, '117124658', '', ''),
('20160253', '2001', 'FOE ', 'JEAN CARNOT', '2000', '19830414000000000000', 'M', '', '674 66 94 21', 'LABORABTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201122737000658', NULL, NULL, NULL, '113982044', '', ''),
('20160254', '2003', 'DJOTSING FOTSING ', 'EPIPHANIE', '2003', '19890417000000000000', 'F', '', '', '', '', 'CREAT', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201134830000448', NULL, NULL, NULL, '10852616', '', ''),
('20160255', '2001', 'NGAYE ', 'PATRICE', '2000', '19651112000000000000', 'M', '', '699563775', 'OPERATEUR PONT BASULE', '', 'SSBACHY', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201150408000335', NULL, NULL, NULL, '109469232', '', ''),
('20160256', '2001', 'AKO''O ZOUAMO ', '', '2000', '19630920000000000000', 'M', '', '696 86 91 53', 'CONDUCTEUR COMPACTEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201150638000283', NULL, NULL, NULL, '', '', ''),
('20160257', '2001', 'FOUTH NDE ', 'BENJAMIN', '2003', '19770711000000000000', 'M', '', '675 09 30 07', 'ELINGUEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201151251000957', NULL, NULL, NULL, '115721769', '', ''),
('20160258', '2002', 'BEREM ', 'CEDRIC ', '2003', '19900130000000000000', 'M', '', '698 97 72 11', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160201000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160201154604000474', NULL, NULL, NULL, '113903251', '', ''),
('20160259', '2001', 'WOUAWOUO ', 'WILLIAMS ELVIS', '2003', '19780422000000000000', 'M', '', '677 32 07 12', 'CHAUFFEUR ', '', 'SOREPCO', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202075532000330', NULL, NULL, NULL, '109431105', '', ''),
('20160260', '2003', 'SIMO KAMBU ', 'CHRISTELLE ANNICK', '2003', '19910921000000000000', 'F', '', '652 04 140 69', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202082441000630', NULL, NULL, NULL, '111283256', '', ''),
('20160261', '2001', 'TCHUEM  KOUOBOU', 'BARTHELEMY ', '2003', '19880421000000000000', 'M', '', '698 00 91 86', 'INGENIEUR', '', 'COMETAL', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202084438000198', NULL, NULL, NULL, '1183897337', '', ''),
('20160262', '2001', 'SADEU ', 'JEAN BERNARD', '2000', '19810613000000000000', 'M', '', '673 07 37 56', 'DIRECTEUR RD', '', 'COMETAL', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202084750000484', NULL, NULL, NULL, '', '', ''),
('20160263', '2002', 'NLEND', 'LANDRY PIERRE', '2000', '19781007000000000000', 'M', '', '697 03 55 65', 'MACON', '', 'SSW', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202085007000756', NULL, NULL, NULL, '109870109', '', ''),
('20160264', '2001', 'NINAMA NA AMAYA', 'NARCISSE', '2000', '19881223000000000000', 'M', '', '679 76 96 44', 'MACON', '', 'SSW', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202085257000320', NULL, NULL, NULL, '112526749', '', ''),
('20160265', '2001', 'MVO', 'EMMANUEL', '2003', '19891228000000000000', 'M', '', '672366678', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202085439000248', NULL, NULL, NULL, '108530442', '', ''),
('20160266', '2002', 'BAWOH EPSE EMBOLO ETOGA ', 'MARIE JOSEPHINE', '2000', '19820303000000000000', 'M', '', '651 87 65 45', 'TECHNICIENNE DE SURFACE', '', 'FS', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202093020000241', NULL, NULL, NULL, '114601362', '', ''),
('20160267', '2001', 'MBOCK YEMBA ', 'JEAN YVES ', '2000', '19871022000000000000', 'M', '', '675 99 91 31', 'GRUTTTIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202093452000035', NULL, NULL, NULL, '1183913744', '', ''),
('20160268', '2001', 'NGUESSOM TAGNE', 'STEVE ANICET', '2003', '19900207000000000000', 'M', '', '671 51 57 39', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202094803000109', NULL, NULL, NULL, '109940498', '', ''),
('20160269', '2001', 'FONO FOKO', 'LAURENT CLAUDE', '2000', '19790822000000000000', 'M', '', '694 27 82 69', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202095038000220', NULL, NULL, NULL, '109758980', '', ''),
('20160270', '2001', 'BAYEM ', 'PAUL', '2003', '19840524000000000000', 'M', '', '696 92 19 08', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202104630000649', NULL, NULL, NULL, '108415230', '', ''),
('20160271', '2001', 'LEMA', 'SIMPLICE', '2000', '19571104000000000000', 'M', '', '699 27 02 38', 'CHAUFFEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202105643000995', NULL, NULL, NULL, '107680128', '', ''),
('20160272', '2001', 'NGENGE ', 'EUGENE', '2000', '19821219000000000000', 'M', '', '673395659', 'MAçON', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202110320000669', NULL, NULL, NULL, '111025199', '', ''),
('20160273', '2001', 'MVONDO ', 'DESIRE ALPHONSE', '2000', '19680311000000000000', 'M', '', '677 72 44 24', 'CONDUCTEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202110654000922', NULL, NULL, NULL, '116393320', '', '');
INSERT INTO `tab_pat` (`COD_PAT`, `LIB_TIT`, `LIB_NOM`, `LIB_PRE`, `ENU_STA_MAT`, `DAT_NAIS`, `LIB_SEX`, `LIB_ADR`, `LIB_NUM_TEL`, `LIB_PROF`, `LIB_FON`, `COD_SOC`, `BOO_EST_ASS`, `BOO_EST_AFF`, `LIB_PER_CON`, `LIB_NUM_TEL_PER_CON`, `COD_ASS`, `DAT_ENREG`, `BOO_EST_ARCH`, `LIB_MED`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `LIB_ASS`, `LIB_SOC`, `LIB_NUM_CNI`, `LIB_NUM_CNPS`, `LIB_MAT`) VALUES
('20160274', '2001', 'NGWANG NKAMANJONG ', 'MARCEL', '2000', '19820128000000000000', 'M', '', '679 61 69 84', 'CONDUCTEUR PELLE', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202111047000616', NULL, NULL, NULL, '1186731533', '', ''),
('20160275', '2001', 'NZOUEFA YONTA ', 'FABRICE PEGUY', '2003', '19860225000000000000', 'M', '', '697 80 78 89', 'ELECTRICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202111242000087', NULL, NULL, NULL, '109297065', '', ''),
('20160276', '2001', 'JESEH ', 'DANIEL KODI', '2003', '19870101000000000000', 'M', '', '670 63 46 54', 'MESUREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202111710000674', NULL, NULL, NULL, '109875523', '', ''),
('20160277', '2001', 'VOSTER KUBAH OTTIA', '', '2000', '19770306000000000000', 'M', '', '671 74 58 37', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202111952000464', NULL, NULL, NULL, '107032337', '', ''),
('20160278', '2001', 'AYUK ', 'ZACHEUS AGBOR', '2003', '19920426000000000000', 'M', '', '671 50 58 93 ', 'SIGNALEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202112400000404', NULL, NULL, NULL, '108436945', '', ''),
('20160279', '2001', 'HICENT NJANDAME TIKOH', '', '2003', '19741122000000000000', 'M', '', '675 38 41 80', 'SIGNALEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202112617000959', NULL, NULL, NULL, '115747219', '', ''),
('20160280', '2001', 'NDI ', 'MICHAEL ANDONG', '2003', '19920630000000000000', 'M', '', '677 61 92 71', 'SIGNALEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202113301000275', NULL, NULL, NULL, '112460301', '', ''),
('20160281', '2001', 'TALLA FOSSO ', 'ZITA LEA', '2003', '19900722000000000000', 'M', '', '691 87 44 41', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202113458000128', NULL, NULL, NULL, '110943684', '', ''),
('20160282', '2001', 'IBRAHIM YAYA', '', '2003', '19810201000000000000', 'M', '', '699 18 28 64', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202114038000736', NULL, NULL, NULL, '110873955', '', ''),
('20160283', '2001', 'TAFON ', 'SHIRAME FON', '2003', '19861027000000000000', 'M', '', '674 36 83 88', 'AIDE MAGASINIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202114222000403', NULL, NULL, NULL, '114808698', '', ''),
('20160284', '2001', 'NDONGO ESSIMBI ', 'MARTIN', '2000', '19760224000000000000', 'M', '', '673 01 59 00', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202114415000024', NULL, NULL, NULL, '1169344416', '', ''),
('20160285', '2001', 'TUMFONG TUMFONG', 'JOHN', '2000', '19641102000000000000', 'M', '', '675 19 36 82', 'CHAUFFEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202114644000331', NULL, NULL, NULL, '', '', ''),
('20160286', '2001', 'PIME ', '', '2000', '19591111000000000000', 'M', '', '691 69 99 81', 'OPERATEUR CENTRALE ENROBE', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202114925000254', NULL, NULL, NULL, '107207614', '', ''),
('20160287', '2001', 'MBEZELE NGONO', 'THEOPHILE', '2000', '19600305000000000000', 'M', '', '699 84 61 06', 'PLOMBIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202115113000430', NULL, NULL, NULL, '107891652', '', ''),
('20160288', '2001', 'NDONI', 'EBENEZER', '2000', '19630318000000000000', 'M', '', '696 65 54 72', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202115249000622', NULL, NULL, NULL, '114417979', '', ''),
('20160289', '2002', 'DYMPNA MBOTI EPSE ', 'NDAMGAN', '2000', '19730623000000000000', 'F', '', '675 68 50 94', 'AGENT ENTRETIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202115524000734', NULL, NULL, NULL, '1163313715', '', ''),
('20160290', '2001', 'PEH BAYANG ', 'JOSEPH DIDIER', '2003', '19770222000000000000', 'M', '', '691 40 94 49', 'FERRAILLEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202115843000625', NULL, NULL, NULL, '117505310', '', ''),
('20160291', '2001', 'MBONDJE NTANG ', 'ISMAEL', '2003', '19840120000000000000', 'M', '', '673 39 69 84', 'MESUREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202120018000221', NULL, NULL, NULL, '112190640', '', ''),
('20160292', '2001', 'HAMADOU AMADOU', '', '2000', '19840805000000000000', 'M', '', '69964 02 97', 'GESTION INFORMATIQUE DE STOCK', '', 'OLAM', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160202161635000567', NULL, NULL, NULL, '11671328', '', ''),
('20160293', '2002', 'KADJE KUITCHE ', 'ROLANDE', '2003', '19840405000000000000', 'F', '', '675 89 73 93', 'VENDEUSE', '', 'MENO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203074954000401', NULL, NULL, NULL, '106857145', '', ''),
('20160294', '2001', 'SAHDEU ', 'HUBERT MARCIAL', '2003', '19830429000000000000', 'M', '', '675 13 84 87', 'OUVRIER', '', 'SUM', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203080221000041', NULL, NULL, NULL, '107134784', '', ''),
('20160295', '2001', 'DJOUDA SOH ', 'JEAN ROMUALD', '2003', '19850505000000000000', 'M', '', '650 75 66 42', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203080525000653', NULL, NULL, NULL, '107659097', '', ''),
('20160296', '2001', 'NJIKE ', 'HERMANN DALANG', '2003', '19871104000000000000', 'M', '', '655 79 31 63', 'SUPERVISEUR ', '', 'STHYC', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203083214000959', NULL, NULL, NULL, '109880109', '', ''),
('20160297', '2001', 'NJIMPIE NGANLO ', 'ACHILLE', '2003', '19850217000000000000', 'M', '', '675 48 00 34', 'CHEF D''EQUIPE GENIE CIVIL', '', 'SSW', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203083455000371', NULL, NULL, NULL, '1094555102', '', ''),
('20160298', '2001', 'BOPDA KENGNE ', 'HUGUES EMMANUEL', '2000', '19860120000000000000', 'M', '', '690 83 25 26', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203083646000994', NULL, NULL, NULL, '109981339', '', ''),
('20160299', '2001', 'KAPSEU ', 'LAURE MARTIAL', '2000', '19820330000000000000', 'M', '', '691 13 00 11', 'ELECTROTECHNICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203085405000059', NULL, NULL, NULL, '117449640', '', ''),
('20160300', '2002', 'SILEU MINTHEU ', 'THERESE RITA', '2000', '19870109000000000000', 'F', '', '698 00 50 87', 'RESPONSABLE QUALITE', '', 'COMETAL', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203085543000834', NULL, NULL, NULL, '112184995', '', ''),
('20160301', '2001', 'MENGUE ', 'HENRI', '2000', '19731005000000000000', 'M', '', '674 90 76 08', 'CHEF BRIGADE TOPO', '', NULL, '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203104348000847', NULL, NULL, NULL, '108630209', '', ''),
('20160302', '2001', 'BABU ZHUH ', 'VALENTINE ', '2000', '19760323000000000000', 'M', '', '675 80 86 64', 'OPERATEUR TOPOGRAPHE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203104726000963', NULL, NULL, NULL, '114113204', '', ''),
('20160303', '2001', 'TCHAMBA ', 'FLORENT PATRICK', '2000', '19871105000000000000', 'M', '', '679 59 36 38', 'AIDE TOPOGARPHE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203105028000927', NULL, NULL, NULL, '1183733853', '', ''),
('20160304', '2001', 'ASANJI', 'ELVIS FOKABO', '2000', '19820105000000000000', 'M', '', '676 24 47 74', 'AIDE TOPOGAPHE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203105315000481', NULL, NULL, NULL, '', '', ''),
('20160305', '2002', 'MANKA ', 'MARYLINE YAH', '2003', '19760724000000000000', 'M', '', '677 54 25 469', 'INFIRMIERE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203110322000514', NULL, NULL, NULL, '117098871', '', ''),
('20160306', '2002', 'BIKAH ', 'LYDIE', '2003', '19830903000000000000', 'M', '', '693 56 47 39', 'CONDUCTRICE NIVELLEUSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203110730000697', NULL, NULL, NULL, '', '', ''),
('20160307', '2001', 'NDONGO ', 'ISRAEL ALEXANDRE', '2003', '19860301000000000000', 'M', '', '697 76 83 63', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203110920000644', NULL, NULL, NULL, '117932595', '', ''),
('20160308', '2001', 'TAYONG ', 'JULUS', '2003', '19800715000000000000', 'M', '', '675 933 296', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203111213000071', NULL, NULL, NULL, '112718309', '', ''),
('20160309', '2001', 'NCHEIYI ', 'PAUL MEYEUTEKEU', '2000', '19871119000000000000', 'M', '', '675 41 88 58', 'AIDE FERRAILLEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160203111550000526', '20160203111633000807', NULL, NULL, '107541117', '', ''),
('20160310', '2001', 'FODJEU ', 'FERDINAND', '2003', '19761024000000000000', 'M', '', '673 48 86 35', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203111855000749', NULL, NULL, NULL, '112649984', '', ''),
('20160311', '2001', 'BOUCHOUANG ', 'DIDIER ', '2003', '19880112000000000000', 'M', '', '679 26 14 28', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203112036000017', NULL, NULL, NULL, '114472103', '', ''),
('20160312', '2001', 'MBALLA ESSAMA ', 'MARCEL', '2000', '19710911000000000000', 'M', '', '675 36 99 38', 'CHAUFFEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203112236000025', NULL, NULL, NULL, '114536258', '', ''),
('20160313', '2001', 'GONGMAZOU ', 'BARTHELEMY', '2003', '19620515000000000000', 'M', '', '676 70 40 80', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203112656000545', NULL, NULL, NULL, '108889650', '', ''),
('20160314', '2001', 'NYEBE AMBENE ', '', '2000', '19590101000000000000', 'M', '', '675 15 09 32', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203112927000270', NULL, NULL, NULL, '115602135', '', ''),
('20160315', '2001', 'EFFA', 'PIERRE', '2003', '19770630000000000000', 'M', '', '697 33 54 89', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203113127000443', NULL, NULL, NULL, '108721420', '', ''),
('20160316', '2001', 'NGUNDAM ', 'GERALD', '2000', '19841112000000000000', 'M', '', '670 23 59 50', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203113414000371', NULL, NULL, NULL, '116127409', '', ''),
('20160317', '2001', 'ONGUENE TSANGA ', 'DAVY  OLIVIER', '2003', '19870920000000000000', 'M', '', '690 05 21 81', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203113756000616', NULL, NULL, NULL, '107928883', '', ''),
('20160318', '2001', 'WANDJIE ', 'EMMANUEL', '2000', '19640101000000000000', 'M', '', '679 27 52 40', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203114008000358', NULL, NULL, NULL, '116522779', '', ''),
('20160319', '2001', 'EKOUDI ', 'JOSEPH MARIE', '2003', '19651018000000000000', 'M', '', '678 98 79 78', 'OPERATEUR BITUME', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203114222000589', NULL, NULL, NULL, '111955860', '', ''),
('20160320', '2001', 'NZUSSOUO  OUAFO ', 'HERVE DEDI', '2003', '19930607000000000000', 'M', '', '', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203134534000593', NULL, NULL, NULL, '111938286', '', ''),
('20160321', '2001', 'LOLAKEPWA ', 'NESTO', '2003', '19890302000000000000', 'M', '', '', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203134750000469', NULL, NULL, NULL, '109994251', '', ''),
('20160322', '2002', 'KAMENI TCHAPDA ', 'AUDREY TATIANA', '2003', '19900217000000000000', 'M', '', '679 69 47 25', 'AIDE MAGASINIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203145748000279', NULL, NULL, NULL, '110045959', '', ''),
('20160323', '2001', 'TOUNA', 'JEAN PAUL', '2003', '19820317000000000000', 'M', '', '680 10 36 72', 'CONDUCTEUR MECALAC', '', 'SSW', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203150145000405', NULL, NULL, NULL, '115636164', '', ''),
('20160324', '2001', 'KWAMEN TCHAKOTIO ', 'GILDAS CHAMIE', '2003', '19900613000000000000', 'M', '', '697 38 79 46', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203161330000942', NULL, NULL, NULL, '112034790', '', ''),
('20160325', '2001', 'KONO ', 'ANDRE', '', '19790330000000000000', 'M', '', '677 33 23 55', '', '', 'TOK', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160203165446000971', NULL, NULL, NULL, '109673494', '', ''),
('20160326', '2002', 'BAWOH EPSE EMBOLO ETOGA ', 'MARIE JOSEPHINE', '2000', '19820303000000000000', 'M', '', '', 'MENAGERE', '', '3S', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204080839000152', NULL, NULL, NULL, '114601362', '', ''),
('20160327', '2001', 'ESSIMI NKOUSSA ', 'JOSUE CLEMENT', '2003', '19861019000000000000', 'M', '', '675 66 07 63', 'AGENT RAFFINAGE', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204084843000738', NULL, NULL, NULL, '108204165', '', ''),
('20160328', '2001', 'FOUEKEUM', 'MARTIN', '2000', '19711122000000000000', 'M', '', '675 60 91 52', 'SOUDEUR', '', '3TC', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204094726000742', NULL, NULL, NULL, '110441819', '', ''),
('20160329', '2001', 'EYADA ', 'SYLVESTRE ROLAND', '2000', '19820619000000000000', 'M', '', '672 09 75 04', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160204111621000306', '20160204111733000622', NULL, NULL, '1170170775', '', ''),
('20160330', '2001', 'NGONO DJEBE', 'PAUL', '2003', '19871022000000000000', 'M', '', '675 03 47 80', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204111910000015', NULL, NULL, NULL, '107536201', '', ''),
('20160331', '2001', 'MATOUKE ', 'SALOMON FRANCK OLIVIER', '2003', '19890430000000000000', 'M', '', '698 334 760', 'ASSISTANT LABO', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204112158000547', NULL, NULL, NULL, '1184605353', '', ''),
('20160332', '2001', 'KINIGUE ', 'GASTON ', '2003', '19620201000000000000', 'M', '', '699 36 69 73', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204112643000290', NULL, NULL, NULL, '111331622', '', ''),
('20160333', '2001', 'KOUEKAM ', 'FRANCOIS', '2003', '19720220000000000000', 'M', '', '677 23 19 86', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204112900000643', NULL, NULL, NULL, '107563616', '', ''),
('20160334', '2001', 'ESSIMI NDONGO ', 'FABIEN', '2003', '19761119000000000000', 'M', '', '674 65 31 39', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204113327000674', NULL, NULL, NULL, '107367503', '', ''),
('20160335', '2001', 'ATEMKENG ', 'NESTOR', '2003', '19840430000000000000', 'M', '', '674 75 87 87', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204113528000663', NULL, NULL, NULL, '107 98 85 57', '', ''),
('20160336', '2001', 'DJOUMESSI KANKE ', 'ETIENNE JEPHTE', '2003', '19830722000000000000', 'M', '', '650 80 87 88', 'AIDE OUVIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204113810000788', NULL, NULL, NULL, '11 788 52 01', '', ''),
('20160337', '2001', 'TIWA ', 'ERNEST', '2003', '19710826000000000000', 'M', '', '677 58 77 41', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204114447000662', NULL, NULL, NULL, '10788 99 12', '', ''),
('20160338', '2001', 'NYEMECK BESSALA', 'GEDEON PIERRE', '2003', '19931111000000000000', 'M', '', ' 673 42 40 90', 'POINTEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204114643000490', NULL, NULL, NULL, '114703996', '', ''),
('20160339', '2001', 'DJOKO KOUAM', 'EMERIC BRICE', '2003', '19901109000000000000', 'M', '', '680 98 74 67', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204115119000321', NULL, NULL, NULL, '115133057', '', ''),
('20160340', '2001', 'BENGOUE BIKOI ', 'BERTRAND', '2003', '19901101000000000000', 'M', '', '694 97 47 03', 'FERRAILLEUR ', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204123246000650', NULL, NULL, NULL, '109635376', '', ''),
('20160341', '2001', 'BELINGA ', 'LOUIS DE SAXE', '2003', '19750601000000000000', 'M', '', '698 89 21 39', 'FERRAILLEUR ', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204124011000223', NULL, NULL, NULL, '10830 4579', '', ''),
('20160342', '2001', 'MANGWACHE ', 'CHRISANTUS', '2003', '19890822000000000000', 'M', '', '679 80 37 76', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204124325000181', NULL, NULL, NULL, '109568910', '', ''),
('20160343', '2001', 'KOLONG ', 'WILLY CLOVIS', '2003', '19860108000000000000', 'M', '', '694 43 59 13', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204124715000541', NULL, NULL, NULL, '117252110', '', ''),
('20160344', '2001', 'NGA TEME ', 'HERBERT SERGE', '2003', '20160320000000000000', 'M', '', '694 13 19 42', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204124942000015', NULL, NULL, NULL, '108386452', '', ''),
('20160345', '2001', 'NGOG ESSAM ', 'FRANCOIS', '2003', '19820124000000000000', 'M', '', '697 46 54 55', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204125148000858', NULL, NULL, NULL, '107918856', '', ''),
('20160346', '2001', 'MPOULI ', 'ACHILLE PAULIN', '2003', '19810411000000000000', 'M', '', '699 05 47 28', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204125503000694', NULL, NULL, NULL, '116855731', '', ''),
('20160347', '2001', 'NOA ', 'THEOPHILE PARFAIT', '2004', '19590706000000000000', 'M', '', '652 21 13 90', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204130340000267', NULL, NULL, NULL, '1183604651', '', ''),
('20160348', '2003', 'ASEK ', 'YVONNE OJONG', '2003', '19901011000000000000', 'M', '', '670 02 51 37', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204133956000578', NULL, NULL, NULL, '11890 08204', '', ''),
('20160349', '2001', 'FOE ', 'JEAN JACQUES', '2003', '19780521000000000000', 'M', '', '673 43 48 89', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204134147000192', NULL, NULL, NULL, '116631688', '', ''),
('20160350', '2001', 'TATCHIM  KAMDEM ', 'THIERRY ZAKY', '2003', '19890807000000000000', 'M', '', '696 15 50 73', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204135651000624', NULL, NULL, NULL, '111270890', '', ''),
('20160351', '2001', 'NSOA MANDENG', 'ETIENNE', '2003', '19760202000000000000', 'M', '', '691 13 02 29', 'CHAUFFEUR VL', '', 'SSBMD', '0', '1', '', '', NULL, '20160204000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160204150911000571', NULL, NULL, NULL, '108721415', '', ''),
('20160352', '2001', 'FOGUE ', 'BERTRAND', '2000', '19741204000000000000', 'M', '', '677 10 87 91', 'COURSIER ', '', 'ESICO', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205083117000647', NULL, NULL, NULL, '107074680', '', ''),
('20160353', '2002', 'MENGA PEGGY ', 'LIONELLE', '2003', '19851114000000000000', 'M', '', '699946089', 'SECRETAIRE', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205083850000036', NULL, NULL, NULL, '108707468', '', ''),
('20160354', '2001', 'WOUBISSIPE', 'PHILIPPE', '2000', '19620120000000000000', 'M', '', '699 84 65 74', 'CHAUFFEUR ', '', 'STHYC', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205090317000196', NULL, NULL, NULL, '109617403', '', ''),
('20160355', '2001', 'NWEHEL NWEHEL', 'DIEUDONNE', '2003', '19771231000000000000', 'M', '', '670629390', 'CONDUCTEUR MERLO', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205101413000314', NULL, NULL, NULL, '117222602', '', ''),
('20160356', '2001', 'MAMA BELIBI ', 'CHRISTOPHE LEOPOLD', '2003', '19880105000000000000', 'M', '', '696504461', 'OPERATEUR PONT BASCULE', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205103939000624', NULL, NULL, NULL, '1188456245', '', ''),
('20160357', '2001', 'EMOA NGOA ', 'LAZARE', '2003', '19790125000000000000', 'M', '', '676 50 54 99', 'CHEF D''EQUIPETOPO', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205134922000364', NULL, NULL, NULL, '109922538', '', ''),
('20160358', '2001', 'NGUBI NYUYSHAM', 'KILIAN', '2000', '19700210000000000000', 'M', '', '679 450529', 'CHAUFFEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205135309000573', NULL, NULL, NULL, '10783300', '', ''),
('20160359', '2001', 'BEKONO ASSEM', 'ANTOINE', '2003', '19830807000000000000', 'M', '', '676 22 70 03', 'TOPOGRAPHE', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205135656000775', NULL, NULL, NULL, '111827990', '', ''),
('20160360', '2001', 'MBENE ', 'ARMAND VALERE', '2003', '19721028000000000000', 'M', '', '695 78 96 72', '', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205140016000634', NULL, NULL, NULL, '111936199', '', ''),
('20160361', '2001', 'BATE EYA ', 'JAMES OROCK', '2003', '19750517000000000000', 'M', '', '691 70 92 10', 'OPERATEUR PONT BASCULE', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205141924000151', NULL, NULL, NULL, '112232944', '', ''),
('20160362', '2001', 'MOMAKOUET ', 'IBRAHIM', '2000', '19630126000000000000', 'M', '', '674 27 89 59', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160203000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160205142235000824', '20160205142247000663', NULL, NULL, '114501743', '', ''),
('20160363', '2001', 'ELONG DINA ', 'GUY SIMPLICE', '2003', '19750612000000000000', 'M', '', '679 04 01 06', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160205142630000911', '20160205142651000975', NULL, NULL, '108482684', '', ''),
('20160364', '2001', 'ESSOMBA BALENG', '', '2003', '19870122000000000000', 'M', '', '653 13 26 10', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205143019000838', NULL, NULL, NULL, '113 686913', '', ''),
('20160365', '2001', 'MVENYI ', 'ERIC', '2003', '19870621000000000000', 'M', '', '673 58 62 35', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205143323000089', NULL, NULL, NULL, '108016082', '', ''),
('20160366', '2001', 'TAMBI FOTABE ', 'JOHNSON', '2003', '19870824000000000000', 'M', '', '674 22 43 40', 'AIDE OUVRIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160202000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205143456000118', NULL, NULL, NULL, '1188803594', '', ''),
('20160367', '2001', 'NDJEM FILS', '', '2000', '19850619000000000000', 'M', '', '673 33 72 03', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160205000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160205144053000609', NULL, NULL, NULL, '108635583', '', ''),
('20160368', '2001', 'NDEFO WABO ', 'GREGOIRE ', '2000', '19800903000000000000', 'M', '', '699 01 33 93', 'CHAUFFEUR ', '', '3TC', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206084234000810', NULL, NULL, NULL, '109088404', '', ''),
('20160369', '2002', 'TCHUENTEU ', 'MARIE CHRISTELLE', '2003', '19911017000000000000', 'M', '', '670 27 96 18', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206084711000748', NULL, NULL, NULL, '1184021587', '', ''),
('20160370', '2001', 'TEMBI ', 'TERRENCE CHI', '2003', '19870506000000000000', 'M', '', '676 75 77 31', 'MANOEUVRE ', '', 'SSW', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206085433000502', NULL, NULL, NULL, '110878324', '', ''),
('20160371', '2001', 'DEH ', 'ROGER NSAH', '2003', '19860120000000000000', 'M', '', '652 32 90 88', 'PLOMBIER', '', 'SSBACHY', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206085759000563', NULL, NULL, NULL, '109157419', '', ''),
('20160372', '2001', 'ANDZONGO NDJOCK ', 'GAETAN ACHILLE', '2003', '19810120000000000000', 'M', '', '699 51 87 10', '', '', 'SSBMD', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160206090316000338', '20160209083729000911', NULL, NULL, '114450504', '', ''),
('20160373', '2003', 'MEKAK PETE ', 'ADELAIDE GAELLE', '2003', '19870701000000000000', 'M', '', '674 30 91 88', 'STANDARDISTE', '', '3TC', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206093850000117', NULL, NULL, NULL, '114319535', '', ''),
('20160374', '2001', 'MBUENTEM LEKEFACK ', 'LANDRY', '2003', '19860225000000000000', 'M', '', '698 98 78 04', 'CHAUFFEUR TRACTEUR', '', '3TC', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206094140000479', NULL, NULL, NULL, '111975274', '', ''),
('20160375', '2001', 'ATANGANA ATANGANA ', 'RAYMOND COURTELINE', '2003', '19760408000000000000', 'M', '', '699 00 91 95', 'CHAUFFEUR TRACTEUR', '', '3TC', '0', '0', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206100019000822', NULL, NULL, NULL, '116565596', '', ''),
('20160376', '2001', 'POKAM TATEPONNG', 'ERIC AURELIEN', '2003', '19860403000000000000', 'M', '', '69900 92 14', 'CHAUFFEUR TRACTEUR ', '', '3TC', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206100330000339', NULL, NULL, NULL, '114089648', '', ''),
('20160377', '2001', 'TOUONOU LONGANG ', 'ACHILLE DONALD', '2003', '19810311000000000000', 'M', '', '698693388', 'AGENT LOGISTIQUE', '', '3TC', '0', '1', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206100846000926', NULL, NULL, NULL, '116454414', '', ''),
('20160378', '2001', 'KUIKA', '', '2000', '19510810000000000000', 'M', '', '699 38 38 59', 'RETRAITE', '', NULL, '0', '0', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206103556000716', NULL, NULL, NULL, '107959651', '', ''),
('20160379', '2001', 'MOUKOUDI ', 'MARCEL', '2003', '19891019000000000000', 'M', '', '694 28 24 33', 'CUISINIER', '', 'HVP', '0', '0', '', '', NULL, '20160206000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160206113654000292', NULL, NULL, NULL, '109585335', '', ''),
('20160380', '2001', 'SAGNAG MOUNPAIN ', 'GYBELINCE LARIOS', '2003', '19850519000000000000', 'M', '', '694 95 94 40', 'MECANICIEN', '', 'TAC', '0', '0', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208082602000545', NULL, NULL, NULL, '107812116', '', ''),
('20160381', '2001', 'BAOURO MANSOUROU', '', '2003', '19850804000000000000', 'M', '', '696 89 07 92', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208083327000195', NULL, NULL, NULL, '108346035', '', ''),
('20160382', '2001', 'DEWA ', 'IBRIHIMA', '2000', '19830505000000000000', 'M', '', '675 79 98 60', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208083613000441', NULL, NULL, NULL, '117858415', '', ''),
('20160383', '2001', 'ESSOMBA ', 'PIERRE', '2003', '19760206000000000000', 'M', '', '699 10 41 15', '', '', 'SSW', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208085306000410', NULL, NULL, NULL, '108570342', '', ''),
('20160384', '2001', 'FOTSO TOGUE ', 'MARTIAL', '2003', '19790630000000000000', 'M', '', '697 63 42 86', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208090723000554', NULL, NULL, NULL, '118008182', '', ''),
('20160385', '2001', 'WOUNKEP KOBE ', 'RODOLPHE', '2003', '19921004000000000000', 'M', '', '691 19 86 37', 'FABRICANT DES FEUILLES', '', 'TAC', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208092120000867', NULL, NULL, NULL, '117733727', '', ''),
('20160386', '2002', 'NGUEUGA TIEPE  EPSE NGUETCHE', 'EDITH', '2000', '19750715000000000000', 'M', '', '675 07 08 76', 'AGENT D''ENTRETIEN', '', 'EMEM', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208101301000535', NULL, NULL, NULL, '117891965', '', ''),
('20160387', '2001', 'KALBOUNGSOU ', 'GABRIEL', '2000', '19910707000000000000', 'M', '', '691 27 77 27', 'AGENT D''ENTRETEIN', '', '3TC', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208101522000534', NULL, NULL, NULL, '109834320', '', ''),
('20160388', '2001', 'ANDING EVONA', 'MARCELLIN', '2003', '19800401000000000000', 'M', '', '677 88 94 94', 'CONDUCTEUR P. CHARG', '', 'SSBMD', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208104105000127', NULL, NULL, NULL, '108548428', '', ''),
('20160389', '2001', 'MONGANG KOUATCHE ', 'PATRICK CHARLIN', '2003', '19790222000000000000', 'M', '', '650 62 76 24', 'MAGASINIER', '', 'BR', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208105024000397', NULL, NULL, NULL, '114664506', '', ''),
('20160390', '2002', 'MAFODI ', 'GERMAINE', '2003', '19840408000000000000', 'M', '', '671103122', 'MENAGERE', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208143709000585', NULL, NULL, NULL, '', '', ''),
('20160391', '2001', 'WAFO KUATE ', 'LUC ', '2000', '19670717000000000000', 'M', '', '677 73 00 06', 'INGENIEUR GENIE CIVIL', '', NULL, '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208150726000562', NULL, NULL, NULL, '1091484118', '', ''),
('20160392', '2001', 'BIBOUM BI YONG ', 'THIERRY DONATIEN', '2003', '19940603000000000000', 'M', '', '696 88 62 60', 'STAGIAIRE', '', 'SSBMD', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160208153116000425', '20160208153255000562', NULL, NULL, '109809144', '', ''),
('20160393', '2001', 'AVA ZE', 'JEAN PARFAIT', '2003', '19870102000000000000', 'M', '', '672 90 03 72', 'POINTEUR PRINCIPAL', '', 'SSBMD', '0', '1', '', '', NULL, '20160208000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160208154332000572', NULL, NULL, NULL, '109809144', '', ''),
('20160394', '2001', 'TIENTCHEU ', 'STEEVE', '2003', '19861128000000000000', 'M', '', '699 49 87 67', 'ASSISTANT RH', '', 'SSBACHY', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209075308000619', NULL, NULL, NULL, '114602260', '', ''),
('20160395', '2001', 'TANKOUA NGOTCHUI ', 'GERMAIN SETRILE', '2003', '19800926000000000000', 'M', '', '691 82 18 89', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209082651000177', NULL, NULL, NULL, '117790331', '', ''),
('20160396', '2001', 'POKAM SAA', 'BLAISE', '2000', '19780412000000000000', 'M', '', '699 78 44 43', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209083014000950', NULL, NULL, NULL, '107946703', '', ''),
('20160397', '2001', 'MOTTO ', 'PIERRE', '2003', '19890602000000000000', 'M', '', '677 46 83 18', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209083205000784', NULL, NULL, NULL, '108781473', '', ''),
('20160398', '2001', 'KAFFO ', 'JOSEPH ', '2000', '19640101000000000000', 'M', '', '677 91 31 58', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209083405000529', NULL, NULL, NULL, '115352985', '', ''),
('20160399', '2001', 'SIDJUI ', 'MARCEL ', '2003', '19910313000000000000', 'M', '', '694 74 45 68', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209083630000828', NULL, NULL, NULL, '114168796', '', ''),
('20160400', '2001', 'TIENTCHEU ', 'STEEVE', '2003', '19861128000000000000', 'M', '', '699 49 87 67', 'ASSISTANT RH', '', 'SSBACHY', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209083920000198', NULL, NULL, NULL, '114602260', '', ''),
('20160401', '2001', 'KEPSEU MIMBA', 'YANICK FABRICE', '2003', '19860112000000000000', 'M', '', '699 01 13 15', 'MACON', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209084128000974', NULL, NULL, NULL, '108261567', '', ''),
('20160402', '2001', 'NKANA NKANA ', 'ANDRE PAULIN', '2000', '19820504000000000000', 'M', '', '675 85 91 94', 'FERRAILLEUR ', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209084403000806', NULL, NULL, NULL, '107255760', '', ''),
('20160403', '2001', 'NGANTCHOU ', 'FIMIN', '2000', '19690915000000000000', 'M', '', '677 84 53 87', 'MACON', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209084613000644', NULL, NULL, NULL, '1184 98 66 07', '', ''),
('20160404', '2001', 'TENE ', 'GABRIEL', '2003', '19790408000000000000', 'M', '', '677 96 61 81', 'FERRAILLEUR ', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209084804000286', NULL, NULL, NULL, '110867557', '', ''),
('20160405', '2001', 'KINGUE EYANGO ', 'PAUL VERLAINE', '2003', '19890723000000000000', 'M', '', '695 86 80 68', 'PHYTO SANITAIRE', '', 'SOPHYNET ', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209091103000241', NULL, NULL, NULL, '109141713', '', ''),
('20160406', '2001', 'NOUNLOCK ', 'LUC GUILLAUME LE BENJAMIN', '2003', '19820614000000000000', 'M', '', '691 35 15 74', 'POINTEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209091530000384', NULL, NULL, NULL, '116727880', '', ''),
('20160407', '2001', 'NANA NGANTCHAN ', 'CELESTIN', '2003', '19900118000000000000', 'M', '', '678 09 11 93', 'COFFREUR ', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209091847000356', NULL, NULL, NULL, '110373061', '', ''),
('20160408', '2001', 'BEKOTO MBANG', 'CEDRIC', '2003', '19900118000000000000', 'M', '', '699 66 88 37', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209092057000411', NULL, NULL, NULL, '108091379', '', ''),
('20160409', '2001', 'GANDEU ', 'ALBERT', '2000', '19670330000000000000', 'M', '', '679 11 24 92', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160209093016000465', '20160209093253000708', NULL, NULL, '107253134', '', ''),
('20160410', '2001', 'TEDJOU ', 'CYRILLE VALERE', '2003', '19740317000000000000', 'M', '', '677 51 41 02', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209093156000312', NULL, NULL, NULL, '114844532', '', ''),
('20160411', '2001', 'EWODO ', 'ROMUALD', '2003', '19810225000000000000', 'M', '', '695508500', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209094324000189', NULL, NULL, NULL, '1181784913', '', ''),
('20160412', '2001', 'MBVOUMARO', 'PHILIPPE', '2003', '19861108000000000000', 'M', '', '677 51 90 27', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209094720000281', NULL, NULL, NULL, '112749566', '', ''),
('20160413', '2001', 'YAOUBA TEOUSSOU ', '', '2003', '19810505000000000000', 'M', '', '696 78 13 65', 'FERRAILLEUR', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209095003000979', NULL, NULL, NULL, '115993324', '', ''),
('20160414', '2001', 'NGOH MBANGUE', 'MARTIAL LANDER', '2003', '19910210000000000000', 'M', '', '693 24 87 81', 'POINTEUR PRINCIPAL', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209095554000724', NULL, NULL, NULL, '116343252', '', ''),
('20160415', '2001', 'NGOH MBANGUE', 'MARTIAL LANDER', '2003', '19910210000000000000', 'M', '', '693 24 87 81', 'POINTEUR PRINCIPAL', '', 'SSBMD', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209100058000827', NULL, NULL, NULL, '116343252', '', ''),
('20160416', '2001', 'FOSSO NYA', '', '2003', '19910206000000000000', 'M', '', '676 12 28 27', '', '', 'SUM', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209100237000667', NULL, NULL, NULL, '110398220', '', ''),
('20160417', '2001', 'TALLA', 'RIGOBERT', '2000', '19710522000000000000', 'M', '', '679 22 38 22', 'CHAUFFEUR ', '', '3TC', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209102110000655', NULL, NULL, NULL, '109929093', '', ''),
('20160418', '2003', 'BEBONG ', 'ARLETTE LAURE', '2003', '19870720000000000000', 'M', '', '678 93 47 91', 'POINTEUSE', '', 'SSW', '0', '1', '', '', NULL, '20160209000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160209113044000910', NULL, NULL, NULL, '112 96 69 98', '', ''),
('20160419', '2001', 'DJIMBONSOU', 'ANDRE', '2003', '19860912000000000000', 'M', '', '694 02 62 70', 'ANIMATEUR DE VENTE', '', 'SOREPCO', '0', '0', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210083845000299', NULL, NULL, NULL, '109589952', '', ''),
('20160420', '2001', 'KAMNANG ', 'PIELLE', '2003', '19850808000000000000', 'M', '', '699 01 09 45', 'CHAUFFEUR TRACTEUR ', '', '3TC', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210084254000158', NULL, NULL, NULL, '115542947', '', ''),
('20160421', '2001', 'ESSOH ', 'MYSTER ', '2003', '19891020000000000000', 'M', '', '674 31 86 02', 'OUVRIER', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210090820000679', NULL, NULL, NULL, '108465926', '', ''),
('20160422', '2001', 'MBIARGA OWONA ', 'JEAN PIERRE', '2000', '19591010000000000000', 'M', '', '699 32 47 57', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210093424000426', NULL, NULL, NULL, '111473536', '', ''),
('20160423', '2001', 'EYEBE EYEBE', 'JACQUES', '2003', '19830327000000000000', 'M', '', '655 16 03 48', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210093544000088', NULL, NULL, NULL, '114793141', '', ''),
('20160424', '2001', 'MBIAGA TCHOUA', 'ULRICH GABIN', '2003', '19910421000000000000', 'M', '', '698 93 52 03', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210093723000008', NULL, NULL, NULL, '1188725964', '', ''),
('20160425', '2001', 'DJOMI ', 'MAJOIE SIMPLICE', '2000', '19821123000000000000', 'M', '', '699 26 78 68', 'SUPERVISUER', '', 'STHYC', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210103301000421', NULL, NULL, NULL, '110173060', '', ''),
('20160426', '2001', 'ANANFACK ', 'MATHIAS ELYSEE', '2003', '19881002000000000000', 'M', '', '698 19 00 19', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210103439000986', NULL, NULL, NULL, '110625474', '', ''),
('20160427', '2001', 'TOUOKOUONG ', 'HERENCE', '2000', '19790908000000000000', 'M', '', '699 78 42 42', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210145123000642', NULL, NULL, NULL, '110934586', '', ''),
('20160428', '2001', 'BITJOKA ', 'ALBERT OLIVIER', '2000', '19751208000000000000', 'M', '', '691 99 81 74', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210145551000234', NULL, NULL, NULL, '112064740', '', ''),
('20160429', '2001', 'CHENG ', 'MOSES ABANG', '2003', '19761104000000000000', 'M', '', '677 95 46 83', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210150043000967', NULL, NULL, NULL, '114100575', '', ''),
('20160430', '2001', 'FOUPOUAPOGNI POGNIGNI', 'MOUSSA', '2000', '19670829000000000000', 'M', '', '656 29 76 79', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210150752000822', NULL, NULL, NULL, '117091757', '', ''),
('20160431', '2001', 'MEKA ', 'ERIC', '2003', '19840110000000000000', 'M', '', '670 28 98 1967', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210151107000684', NULL, NULL, NULL, '110868847', '', ''),
('20160432', '2001', 'ATANGA NICARTUS ACHIRI', '', '2000', '19771011000000000000', 'M', '', '694904378', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210152004000431', NULL, NULL, NULL, '117637678', '', ''),
('20160433', '2001', 'TALLA NGOUNOU ', 'BIENVENU LEOPOLD', '2003', '19800101000000000000', 'M', '', '675 93 76 15', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210152548000345', NULL, NULL, NULL, '114603610', '', ''),
('20160434', '2001', 'FOTSO DJIDJOU', 'OLIVIER', '2000', '19870603000000000000', 'M', '', '676 93 76 15', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210152934000698', NULL, NULL, NULL, '107052508', '', ''),
('20160435', '2001', 'LACPA ', 'ROBERT ', '2003', '19831013000000000000', 'M', '', '675 17 36 29', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210153155000230', NULL, NULL, NULL, '117 19 92 87', '', ''),
('20160436', '2001', 'EKANI ENYENGUE TOBIE', '', '2000', '19630505000000000000', 'M', '', '650 65 10 76', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210153414000761', NULL, NULL, NULL, '1117713646', '', ''),
('20160437', '2001', 'EFFENDENE ', 'JOSEPH GUY', '2000', '19810812000000000000', 'M', '', '652 97 50 81', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210153615000602', NULL, NULL, NULL, '114653065', '', ''),
('20160438', '2001', 'KALDJOB ', 'LIBERTE CLAUDE', '2003', '19880505000000000000', 'M', '', '691 99 11 66', 'SIGNALEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210153815000695', NULL, NULL, NULL, '116258768', '', ''),
('20160439', '2001', 'TCHOUMKEU TONJI ', 'PROSPER', '2000', '19801104000000000000', 'M', '', '671 51 21 07', 'COFFREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210154114000643', NULL, NULL, NULL, '1184 96 03 66', '', ''),
('20160440', '2001', 'CHEYEP NOUBISSI ', 'VINCENT', '2003', '19780605000000000000', 'M', '', '677 26 68 37', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210154357000807', NULL, NULL, NULL, '108940920', '', ''),
('20160441', '2001', 'DOUMBE ', 'FREDERIC MARTIAL', '2003', '19800627000000000000', 'M', '', '698 98 44 88', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210154836000876', NULL, NULL, NULL, '109460267', '', ''),
('20160442', '2001', 'MEYONG ESABINA ', 'AUGUSTIN ARMAND', '2003', '19781026000000000000', 'M', '', '675 46 22 95', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210160407000742', NULL, NULL, NULL, '114717457', '', ''),
('20160443', '2001', 'DJIKIGOUE KAKAM', 'BERNARD LEDOUX', '2000', '19760213000000000000', 'M', '', '690 04 32 63', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210160620000081', NULL, NULL, NULL, '113384358', '', '');
INSERT INTO `tab_pat` (`COD_PAT`, `LIB_TIT`, `LIB_NOM`, `LIB_PRE`, `ENU_STA_MAT`, `DAT_NAIS`, `LIB_SEX`, `LIB_ADR`, `LIB_NUM_TEL`, `LIB_PROF`, `LIB_FON`, `COD_SOC`, `BOO_EST_ASS`, `BOO_EST_AFF`, `LIB_PER_CON`, `LIB_NUM_TEL_PER_CON`, `COD_ASS`, `DAT_ENREG`, `BOO_EST_ARCH`, `LIB_MED`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `LIB_ASS`, `LIB_SOC`, `LIB_NUM_CNI`, `LIB_NUM_CNPS`, `LIB_MAT`) VALUES
('20160444', '2001', 'NDZOMO ', 'SIMPLICE ', '2000', '19670718000000000000', 'M', '', '691 64 24 62', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160210000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160210160808000209', NULL, NULL, NULL, '114831262', '', ''),
('20160445', '2001', 'AGOUDOUM WANGA ', 'MARTIN', '2000', '19750614000000000000', 'M', '', '699 36 41 09', 'CHEF BRIGADE TOPOGRAPHE', '', 'SSBMD', '0', '1', '', '', NULL, '20160211000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160211081541000928', NULL, NULL, NULL, '117648558', '', ''),
('20160446', '2001', 'TCHENEGHOM FEUSSI', 'INNOCENT', '2003', '19891117000000000000', 'M', '', '679 46 94 87', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160211000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160211090422000631', NULL, NULL, NULL, '115146533', '', ''),
('20160447', '2001', 'DINA ', 'MYRIAM NATHALIE', '2003', '19760228000000000000', 'M', '', '699 43 85 80', 'LOGISTIQUE DE TRANSPORT', '', 'SUM', '0', '1', '', '', NULL, '20160211000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160211094413000832', NULL, NULL, NULL, '117552994', '', ''),
('20160448', '2001', 'FAYCAL HAMED', 'ABDEL LADIFOU', '2003', '19900107000000000000', 'M', '', '696 54 92 09', 'MECANICIEN', '', '3S', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212080034000219', NULL, NULL, NULL, '107608899', '', ''),
('20160449', '2001', 'TANEFO TATSING ', 'EMMANUEL', '2003', '19760501000000000000', 'M', '', '677 37 59 84', 'MAGASINIER', '', 'SUM', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212083211000932', NULL, NULL, NULL, '107617584', '', ''),
('20160450', '2002', 'NGASSA KOUAMEN EPSE NGATAT', 'CYRILLE PRISCILLE', '2000', '19861016000000000000', 'M', '', '670 07 11 64', '', '', 'EXEXCH', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212084950000032', NULL, NULL, NULL, '113085799', '', ''),
('20160451', '2001', 'NGNIMPA MELI', 'NARCISSE', '2000', '19810428000000000000', 'M', '', '695311856', 'FERRAILLEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212104856000734', NULL, NULL, NULL, '1189021005', '', ''),
('20160452', '2001', 'LONFO ', 'JEAN NOEL', '2000', '19761203000000000000', 'M', '', '674555615', 'MENUISIER/COFFREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212105343000027', NULL, NULL, NULL, '115030142', '', ''),
('20160453', '2001', 'MOT MOT ', 'JOACHIM', '2000', '19650815000000000000', 'M', '', '673 24 76 14', 'MAçON', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212110218000967', NULL, NULL, NULL, '112755441', '', ''),
('20160454', '2001', 'BENG EPHREM', '', '2000', '19690608000000000000', 'M', '', '676 27 91 12', 'MENUISIER/COFFREUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212111126000581', NULL, NULL, NULL, '113367004', '', ''),
('20160455', '2001', 'VANGNET ZE ', 'MARCELIN', '', '19820724000000000000', 'M', '', '674 75 40 98', 'MACON/COFFREUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212111356000886', NULL, NULL, NULL, '108107133', '', ''),
('20160456', '2001', 'BOMON ', 'FRANCIS', '', '19740420000000000000', 'M', '', '699 01 01 28', 'MACON/COFFREUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212111746000358', NULL, NULL, NULL, '116906825', '', ''),
('20160457', '2001', 'MOUDIO ', 'JOACHIM', '2003', '19810723000000000000', 'M', '', '699 91 72 75', 'LABORANTIN', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212111946000031', NULL, NULL, NULL, '113790 275', '', ''),
('20160458', '2001', 'TANDJA DJEUDJI ', 'CELESTIN', '2003', '19930913000000000000', 'M', '', '655 70 23 53', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212112223000376', NULL, NULL, NULL, '116417349', '', ''),
('20160459', '2001', 'MOUGANG ', 'EMMANUEL', '', '19620729000000000000', 'M', '', '670 63 81 88', 'CHEF D''EQUIPE', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212112951000828', NULL, NULL, NULL, '109078231', '', ''),
('20160460', '2001', 'NTON ', 'PIERRE ALAIN AUGUSTE', '2003', '19840424000000000000', 'M', '', '694 73 23 20', 'AIDE LABORANTIN', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212113156000390', NULL, NULL, NULL, '112351510', '', ''),
('20160461', '2001', 'TCHEMATCHOU WONSI', 'BASILE CEDRICK', '', '19861007000000000000', 'M', '', '691 34 43 03', 'GRUTIER', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212113418000851', NULL, NULL, NULL, '112887803', '', ''),
('20160462', '2001', 'KEUNDOP ', 'JEAN CLAUDE', '', '19711209000000000000', 'M', '', '675 89 71 88', 'MANOEUVRE SPECIALISE', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212114101000091', NULL, NULL, NULL, '108523194', '', ''),
('20160463', '2001', 'NGWA NDASI ', 'OLIVER', '', '19830618000000000000', 'M', '', '675 79 59 61', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212114259000420', NULL, NULL, NULL, '115152347', '', ''),
('20160464', '2001', 'ACHONDUH ', 'MICHAEL ANBEKWI', '2003', '19791211000000000000', 'M', '', '675 34 17 06', 'FERRAILLEUR ', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212120449000230', NULL, NULL, NULL, '108095961', '', ''),
('20160465', '2001', 'FOTSA TCHOPEUBE', 'BLONDEL JEFFERSON', '2003', '19930118000000000000', 'M', '', '670 26 56 90', 'COFFREUR ', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212120711000333', NULL, NULL, NULL, '116750117', '', ''),
('20160466', '2001', 'MANI MAMA ', 'PATRICE', '2003', '19810925000000000000', 'M', '', '674 283 156', 'CONDUCTEUR PELLE CHAR', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212124225000975', NULL, NULL, NULL, '105316069', '', ''),
('20160467', '2001', 'KALDJOB ', 'BONIFACE', '2003', '19870118000000000000', 'M', '', '694 91 60 49', 'MANOEUVRE ', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212124509000042', NULL, NULL, NULL, '109111640', '', ''),
('20160468', '2001', 'DJEUMENI NGOUNOU ', 'JEAN ETIENNE', '2003', '19810915000000000000', 'M', '', '677192841', 'ELECTROTECHNICIEN', '', 'SSW', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212124831000961', NULL, NULL, NULL, '110116796', '', ''),
('20160469', '2001', 'NGOLLE EPIE ', 'JULES', '2003', '19841002000000000000', 'M', '', '699 90 23 46', 'MACON', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160212140847000437', NULL, NULL, NULL, '114782009', '', ''),
('20160470', '2001', 'KEMEGNE ', 'PIERRE', '2000', '19720830000000000000', 'M', '', '677 22 82 06', 'INFORMATICIEN', '', 'CMC', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215083346000271', NULL, NULL, NULL, '113373004', '', ''),
('20160471', '2001', 'TIATI ACHANG', 'RODRIGUE PARFAIT', '2000', '19790607000000000000', 'M', '', '697 53 25 25', 'MELANGEUR', '', 'CMC', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215083603000195', NULL, NULL, NULL, '107088566', '', ''),
('20160472', '2001', 'OBAMA NYEE', 'DIEUDONNE', '2000', '19791008000000000000', 'M', '', '699 72 33 33', 'BULLISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215085100000444', NULL, NULL, NULL, '108718053', '', ''),
('20160473', '2001', 'FOTSO ', 'ISSA BANISSADRE', '2000', '19821102000000000000', 'M', '', '674 27 60 47', 'MPECANICIEN', '', '3S', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215085945000289', NULL, NULL, NULL, '112816871', '', ''),
('20160474', '2001', 'FONCHAM ', 'OSWALD MUNNAKWAH', '2004', '19660319000000000000', 'M', '', '690 94 95 22/ 679 77 63 61', 'SOUDEUR ', '', 'CTC', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215090838000088', NULL, NULL, NULL, '110148484', '', ''),
('20160475', '2001', 'FEUGAING', 'DAVID', '2000', '19530929000000000000', 'M', '', '698 51 04 35', 'CHAUFFEUR', '', 'SOREPCO', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215100439000509', NULL, NULL, NULL, '107190464', '', ''),
('20160476', '2001', 'HOUMA KROSSALA', 'RIGOBERT', '2000', '19790101000000000000', 'M', '', '673 12 66 80', 'CHEF D''EQUIPE', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215103718000160', NULL, NULL, NULL, '112714926', '', ''),
('20160477', '2001', 'NGUILAO ', 'PIERRE', '2000', '19770101000000000000', 'M', '', '114382844', 'MAGASINIER', '', 'SOREPCO', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215104231000824', NULL, NULL, NULL, '114382844', '', ''),
('20160478', '2001', 'NYAM ', 'JEAN MARIE LEOPOLD', '2003', '19621009000000000000', 'M', '', '679 14 71 93', 'CONDUCTEUR PELLE CHARG', '', 'SSBMD', '0', '1', '', '', NULL, '20160213000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215110455000965', NULL, NULL, NULL, '113887109', '', ''),
('20160479', '2001', 'FOTSO KUATE ', 'LEONEL FRANCK', '', '19900305000000000000', 'M', '', '697 23 33 36', 'POINTEUR DE PISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160213000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215110748000663', NULL, NULL, NULL, '111671089', '', ''),
('20160480', '2001', 'BAHETEN ', 'FRANCINE LINDA', '', '19901215000000000000', 'M', '', '699 77 01 18', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215112446000345', NULL, NULL, NULL, '114745329', '', ''),
('20160481', '2001', 'HAGUE BABIAGUE', '', '2000', '19651127000000000000', 'M', '', '681 071 754', 'CHEF APPLICATION', '', 'SSBMD', '0', '1', '', '', NULL, '20160212000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215112920000288', NULL, NULL, NULL, '110372 840', '', ''),
('20160482', '2001', 'BOUBAYE', 'DANIEL', '2000', '19681210000000000000', 'M', '', '672 20 62 52', 'CONDUCTEUR DES TRAVAUX', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215113512000234', NULL, NULL, NULL, '108874256', '', ''),
('20160483', '2001', 'TEINGAR NGARNAVAL', 'CHRISOSTOM', '', '19810302000000000000', 'M', '', '650 98 71 80', 'CHEF DE PRODUCTION', '', 'SSBMD', '0', '1', '', '', NULL, '20160213000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215114217000861', NULL, NULL, NULL, 'R0195363', '', ''),
('20160484', '2001', 'BOUBAKARY', '', '2003', '19840917000000000000', 'M', '', '698 21 50 09', 'FONDOIR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215114424000637', NULL, NULL, NULL, '115592973', '', ''),
('20160485', '2001', 'BESSALA ', 'NESTOR CLEMENT', '2000', NULL, 'M', '', '676 02 08 03', 'REGLEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215114732000149', NULL, NULL, NULL, '110211493', '', ''),
('20160486', '2001', 'TCHAPI', 'PIERRE ', '', '19670315000000000000', 'M', '', '671 73 16 42', 'CONDUCTEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215115319000051', NULL, NULL, NULL, '117698468', '', ''),
('20160487', '2001', 'SAIDOU SAMBOU', '', '', '19640101000000000000', 'M', '', '670 56 17 70', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215115531000757', NULL, NULL, NULL, '115571987', '', ''),
('20160488', '2001', 'MAMADOU BIA', '', '2000', '19820101000000000000', 'M', '', '673 79 44 65', 'COMPACTERISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215121446000836', NULL, NULL, NULL, '117813045', '', ''),
('20160489', '2001', 'ILYASSOU ', 'ALIM', '2000', '19850101000000000000', 'M', '', '672 07 54 90', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215121749000966', NULL, NULL, NULL, '116247392', '', ''),
('20160490', '2001', 'IYA GARO', '', '2000', '19770101000000000000', 'M', '', '678694405', 'BOUILLEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215122038000891', NULL, NULL, NULL, '115592572', '', ''),
('20160491', '2001', 'LEKINI ', 'DESIRE MARIE', '2000', '19670101000000000000', 'M', '', '677 89 71 44', 'CHEF D''EQUIPE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215122533000729', NULL, NULL, NULL, '115956583', '', ''),
('20160492', '2001', 'MVONDO ', 'ALFRED DULAN', '2003', '19890101000000000000', 'M', '', '565 510 028', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215123651000646', NULL, NULL, NULL, '115606062', '', ''),
('20160493', '2001', 'ONANA ', 'EMILE ROLAND', '2003', '19840101000000000000', 'M', '', '678 83 54 22', 'FONDOIR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215123937000026', NULL, NULL, NULL, '109173713', '', ''),
('20160494', '2001', 'FOGUE ', 'GUY BERTRAND', '2003', '19881002000000000000', 'M', '', '670 06 27 03', '', '', 'CMC', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215124140000771', NULL, NULL, NULL, '1184628182', '', ''),
('20160495', '2001', 'MOUSSA HOUSSENI', '', '2003', '19840101000000000000', 'M', '', '672 28 76 25', 'BITUMEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215133512000479', NULL, NULL, NULL, '1188770414', '', ''),
('20160496', '2001', 'NDOUMBA ', 'PAUL', '2000', '19610101000000000000', 'M', '', '675 56 75 03', 'COMPACTERISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215143344000158', NULL, NULL, NULL, '107636531', '', ''),
('20160497', '2001', 'NOESSI ', 'JOEL MARTIAL', '', '19750101000000000000', 'M', '', '', 'REGLEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215144033000743', NULL, NULL, NULL, '114076686', '', ''),
('20160498', '2001', 'ELOMO NGONO', 'MARCEL GEORGES', '2003', '19760101000000000000', 'M', '', '694 54 34 14', 'REGLEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215144600000056', NULL, NULL, NULL, '108761290', '', ''),
('20160499', '2001', 'GUEBI ', 'JEAN PIERRE', '2000', '19710101000000000000', 'M', '', '676 32 76 39', 'COMPACTERISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215144804000169', NULL, NULL, NULL, '117426242', '', ''),
('20160500', '2001', 'IDRISSOU LAKSSIRA', '', '2000', '19800201000000000000', 'M', '', '698 10 80 33', 'FONDOIR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215145156000714', NULL, NULL, NULL, '110458290', '', ''),
('20160501', '2001', 'ENGUENE ', 'FRIDOLIN ALAIN', '2003', '19830306000000000000', 'M', '', '651 50 56 60', 'CONDUCTEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215150322000310', NULL, NULL, NULL, '111791091', '', ''),
('20160502', '2001', 'ASSOGO ', 'MARTIN LUTHER', '2000', '19810225000000000000', 'M', '', '673 34 91 51', 'BOUILLEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215150514000058', NULL, NULL, NULL, '108384844', '', ''),
('20160503', '2001', 'NJONKOU ', 'ALAIN MICHEL', '2000', '19691118000000000000', 'M', '', '677077142', 'AIDE OPERATEUR CENTRALE ENROBEE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215150821000209', NULL, NULL, NULL, '108395433', '', ''),
('20160504', '2002', 'ZANG OLINGA', 'NADINE', '2003', '19881020000000000000', 'F', '', '699436264', 'POINTEUSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215151024000164', NULL, NULL, NULL, '113384330', '', ''),
('20160505', '2001', 'ZENGUE', 'ANICET GEORGES', '2003', '19820515000000000000', 'M', '', '677 66 83 21', 'COMPACTERISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215151221000470', NULL, NULL, NULL, '110147580', '', ''),
('20160506', '2001', 'EYANGA MENYE', '', '2003', '19830217000000000000', 'M', '', '690 91 59 05', 'CHEF D''APPLICATION', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215151414000093', NULL, NULL, NULL, '116870922', '', ''),
('20160507', '2001', 'OWONA ATANGANA', 'ALAIN ROBERT', '2000', '19750505000000000000', 'M', '', '674 77 73 82', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215151832000903', NULL, NULL, NULL, '107116706', '', ''),
('20160508', '2001', 'OWONA', 'BENOIT', '2000', '19780512000000000000', 'M', '', '676 97 27 12', 'REGLEUR FINISHER', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215152054000096', NULL, NULL, NULL, '112602525', '', ''),
('20160509', '2001', 'YOH ', 'SERGE RODRIGUE', '2003', '19830408000000000000', 'M', '', '697 90 10 90', 'FONDOIR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215152312000743', NULL, NULL, NULL, '114341035', '', ''),
('20160510', '2001', 'TCHUIBA CHEUDIO', 'ROSINE', '2003', '19900124000000000000', 'M', '', '674 06 14 54', 'OPERATRICE PONT BASCULE', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215152451000555', NULL, NULL, NULL, '112314437', '', ''),
('20160511', '2001', 'KINGUE MBENDE ', 'OSCAR ROGER', '2003', '19880719000000000000', 'M', '', '694 72 33 32', 'BOUILLEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215152721000581', NULL, NULL, NULL, '117774446', '', ''),
('20160512', '2001', 'NGWHET ', 'ISAAC CALVIN', '2003', '19901001000000000000', 'M', '', '694 26 57 39', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215152943000230', NULL, NULL, NULL, '107880772', '', ''),
('20160513', '2001', 'EKOSSOU TCHAGNA ', 'BOSSIS TEDDY', '2003', '19870829000000000000', 'M', '', '698 73 82 60', 'AIDE RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215153210000236', NULL, NULL, NULL, '110122076', '', ''),
('20160514', '2001', 'WASSOH ', 'JAURES', '2003', '19850312000000000000', 'M', '', '691 47 51 35', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215153430000364', NULL, NULL, NULL, '114523743', '', ''),
('20160515', '2001', 'CHOUAKE DJAMBOU ', 'JOEL', '2003', '19880217000000000000', 'M', '', '677 32 65 16', 'SIGNALEUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215153809000548', NULL, NULL, NULL, '117189421', '', ''),
('20160516', '2001', 'ANGOULA ', 'JUNIOR', '2003', '19920822000000000000', 'M', '', '690983737', 'CONDUCTEUR MANITOU', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215153956000189', NULL, NULL, NULL, '115763591', '', ''),
('20160517', '2001', 'MOUKOUELLE EKOUO', 'DESIRE JOSEPH', '2000', '19691022000000000000', 'M', '', '696 26 86 14', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215154138000603', NULL, NULL, NULL, '110917876', '', ''),
('20160518', '2001', 'TAZO ', 'FIDELE LEONEL', '2003', '19860507000000000000', 'M', '', '695 19 11 34', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215154320000373', NULL, NULL, NULL, '110106478', '', ''),
('20160519', '2001', 'CLINTON NGALLE MONGAMBO', '', '2003', '19941020000000000000', 'M', '', '681247868', 'COFFREUR/MACON', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215154829000215', NULL, NULL, NULL, '114415615', '', ''),
('20160520', '2001', 'BOMBA ', 'ALEX MATHIEU', '2003', '19901111000000000000', 'M', '', '699316032', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215154959000755', NULL, NULL, NULL, '115960369', '', ''),
('20160521', '2001', 'WAMBA TASSEMO', 'CEDRIC', '2003', '19910421000000000000', 'M', '', '690 25 54 00', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215155144000225', NULL, NULL, NULL, '115961218', '', ''),
('20160522', '2001', 'SOULEYMANOU', '', '2000', '19800928000000000000', 'M', '', '696 92 67 48', 'CHAUFFEUR VL', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215155419000926', NULL, NULL, NULL, '108907844', '', ''),
('20160523', '2001', 'BELIBI ', 'JOSEPH DESIRE', '2000', '19700225000000000000', 'M', '', '677391796', 'CHAUFFEUR VL', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215155648000279', NULL, NULL, NULL, '108340782', '', ''),
('20160524', '2001', 'EYEBE ', 'JEAN JACQUES', '2003', '19840625000000000000', 'M', '', '670727747', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215155831000518', NULL, NULL, NULL, '110102976', '', ''),
('20160525', '2001', 'NDE WEDA', '', '2003', '19810104000000000000', 'M', '', '675902633', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215160026000984', NULL, NULL, NULL, '109636930', '', ''),
('20160526', '2001', 'SADIOC NEMALEU', 'BENILDE', '2000', '19800626000000000000', 'M', '', '671 84 71 85', 'CHAUFFEUR PL', '', 'SSBMD', '0', '1', '', '', NULL, '20160215000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160215160305000228', NULL, NULL, NULL, '', '', ''),
('20160527', '2002', 'MONGA YOBI', 'GERMAINE', '2003', '19830728000000000000', 'M', '', '677872825', 'SIGNALEUSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216080907000008', NULL, NULL, NULL, '117190009', '', ''),
('20160528', '2001', 'DJOB ', 'ESTELLE NICAISE', '2003', '19830728000000000000', 'M', '', '690 49 99 95', 'MAGASIGNIERE', '', 'SSBMD', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216081757000907', NULL, NULL, NULL, '109628441', '', ''),
('20160529', '2001', 'KUATE ', 'FRANCOIS', '2003', '19720119000000000000', 'M', '', '675 13 74 56', 'CHAUFFEUR ', '', '3TC', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216082604000888', NULL, NULL, NULL, '107739275', '', ''),
('20160530', '2001', 'PETSOTE ', 'EPHRAIM PAUL', '2003', '19700714000000000000', 'M', '', '698 97 54 88', 'CHAUFFEUR ', '', '3TC', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216085435000568', NULL, NULL, NULL, '114850043', '', ''),
('20160531', '2001', 'ABONGWA ', 'EMMANUEL TEMASANG', '2000', '19850111000000000000', 'M', '', '675 32 98 82', 'SOUDEUR ', '', 'COMETAL', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216085631000880', NULL, NULL, NULL, '', '', ''),
('20160532', '2002', 'KIOMEGNI', 'LINDA NINA', '2003', '19860101000000000000', 'M', '', '', '', '', 'MENO', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216091504000498', NULL, NULL, NULL, '114555448', '', ''),
('20160533', '2001', 'SAGDJIO PEUKEP ', 'NARCISSE', '2003', '19860217000000000000', 'M', '', '696 52 67 77', 'TOPOGRAPHE', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216093427000984', NULL, NULL, NULL, '109465106', '', ''),
('20160534', '2001', 'DJOCKY NDJAMBE ', 'HARICE NICOLAS', '2003', '19840319000000000000', 'M', '', '699 24 76 17', 'MAçON', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216093717000746', NULL, NULL, NULL, '117251826', '', ''),
('20160535', '2001', 'MOYOPO ', 'DONACIEN', '2000', '19780101000000000000', 'M', '', '678 82 92 21', 'MAGASINIER', '', 'SOREPCO', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216093915000936', NULL, NULL, NULL, '109305895', '', ''),
('20160536', '2001', 'LOBE ', 'ALBERT FANFAN', '2003', '19931126000000000000', 'M', '', '697 79 51 94', 'COFFREUR', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216094735000868', NULL, NULL, NULL, '112 335 262', '', ''),
('20160537', '2001', 'LONTIO FOMEKONG ', 'MERLIN', '2003', '19830213000000000000', 'M', '', '', '', '', 'SUM', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216095705000132', NULL, NULL, NULL, '117951641', '', ''),
('20160538', '2001', 'NEBA AMBE', 'COLINES', '2003', '19891107000000000000', 'M', '', '670 34 47 02', 'COFFRUER', '', 'SSBMD', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216102708000617', NULL, NULL, NULL, '110521663', '', ''),
('20160539', '2001', 'SYLVERTER IKOME MOLUA', '', '2003', '19920613000000000000', 'M', '', '677 13 56 53', 'AIDE LABORANTIN', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216103221000364', NULL, NULL, NULL, '109210320', '', ''),
('20160540', '2001', 'IJOMB ', 'PIERRE CHRISTIAN', '2003', '19900607000000000000', 'M', '', '694 19 45 86', 'LABORANTIN', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216103505000137', NULL, NULL, NULL, '1184343282', '', ''),
('20160541', '2001', 'TITI MBELLA', 'JULIEN', '2003', '19700519000000000000', 'M', '', '699 99 75 92', 'MACON', '', 'SSW', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216103712000382', NULL, NULL, NULL, '107714180', '', ''),
('20160542', '2001', 'TCHETCHOMDJE ', 'JEAN  DE DIEU', '2000', '19460101000000000000', 'M', '', '679 86 79 62', 'AGENT DE COMMUNICATION', '', NULL, '0', '0', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216115118000524', NULL, NULL, NULL, '107514740', '', ''),
('20160543', '2001', 'ALIOU ', 'BOUKAR', '', NULL, 'M', '', '', 'OUVIER', '', 'HYPRO', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216124347000347', NULL, NULL, NULL, '', '', ''),
('20160544', '2001', 'OJONJAP', 'HANS TUKU', '2003', '19941028000000000000', 'M', '', '651 72 18 66', 'MANUTENTIONNAIRE', '', 'BR', '0', '0', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216124817000064', NULL, NULL, NULL, '1181319867', '', ''),
('20160545', '2001', 'LOUBENGNI', 'YACOUBA', '2003', '19920428000000000000', 'M', '', '690 47 38 87', 'MANUTENTIONNAIRE', '', 'BR', '0', '1', '', '', NULL, '20160216000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160216125049000566', NULL, NULL, NULL, '108977927', '', ''),
('20160546', '2001', 'Kounga', 'Djouguela', '2003', NULL, 'M', '', '', 'Coffreur', 'Coffreur', NULL, '0', '1', '', '', NULL, '20160218000000000000', NULL, '', '2000', '2016', '1', 'fewane', 'fewane', '20160218094504000398', '20160218094628000529', NULL, NULL, '', '', ''),
('20160547', '2002', 'METUE KAPCHE EPSE KAMGANG SIELAYAP', 'SOLANGE YVETTE', '2000', '19700531000000000000', 'M', '', '677 73 01 10', 'INFORMATICIENNE', '', 'COMETAL', '0', '1', '', '', NULL, '20160218000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160218114105000234', NULL, NULL, NULL, '113815530', '', ''),
('20160548', '2001', 'MIGNONG ', 'GASTON', '2000', '19860721000000000000', 'M', '', '678 40 04 66', 'CONDUCTEUR D''ENGINS', '', 'SITRA', '0', '0', '', '', NULL, '20160218000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160218131507000990', NULL, NULL, NULL, '117928577', '', ''),
('20160549', '2001', 'FOTSA TCHOUBEUBE ', 'BLONDEL JEFFERSON', '2003', '19930116000000000000', 'M', '', '670 26 56 90', 'PEROVIERE P6', '', 'SSW', '0', '0', '', '', NULL, '20160218000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160218145739000687', NULL, NULL, NULL, '116750117', '', ''),
('20160550', '2001', 'DJAKOU DJAMNANG', 'ALAIN MICHEL', '2003', '19880707000000000000', 'M', '', '674 48 18 43', 'TECHNICO COMMERCIAL', '', 'SOREPCO', '0', '1', '', '', NULL, '20160219000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160219082154000257', NULL, NULL, NULL, '116790831', '', ''),
('20160551', '2001', 'BIANG ', 'MARTIN', '2000', '19581120000000000000', 'M', '', '656442291', 'CHEF CHANTIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160219000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160219091754000622', NULL, NULL, NULL, '1188907465', '', ''),
('20160552', '2001', 'SATCHA TALLA', 'CLOVIS CHANFOR', '2003', '19840717000000000000', 'M', '', '672 00 26 04', 'ELECTRICIEN', '', 'CTC', '0', '1', '', '', NULL, '20160219000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160219160904000675', NULL, NULL, NULL, '1189880912', '', ''),
('20160553', '2001', 'VOURKOUROUMDI', '', '2003', '19780417000000000000', 'M', '', '695 49 09 44', 'VIGILE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160220000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160220090253000277', NULL, NULL, NULL, '110708863', '', ''),
('20160554', '2001', 'TOKAM DJEMO ', 'WALTER ', '2000', '19840506000000000000', 'M', '', '697 80 43 49', 'MACHINISTE', '', 'TAC', '0', '1', '', '', NULL, '20160220000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160220095435000268', NULL, NULL, NULL, '107895769', '', ''),
('20160555', '2001', 'DZOGNOU WONEPO ', 'JULIOS', '2003', '19910918000000000000', 'M', '', '675 09 04 58', 'AIDE MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222083656000138', NULL, NULL, NULL, '1110753891', '', ''),
('20160556', '2001', 'TSANGA ', 'JEAN PAUL', '2003', '19630709000000000000', 'M', '', '696 45 08 25', 'CHEF D''EQUIPE TERRASSEMENT', '', 'SSBMD', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222084012000652', NULL, NULL, NULL, '1185611655', '', ''),
('20160557', '2001', 'MISSAMBBO MBOMA', 'COLBERT', '2003', '19870522000000000000', 'M', '', '699 69 54 39', 'EXCECUTANT', '', 'ITS', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222084154000986', NULL, NULL, NULL, '108783186', '', ''),
('20160558', '2001', 'DJOUYIEP TSAMO', 'STANISLAS DOUGLAS', '2000', '19920930000000000000', 'M', '', '674 14 12 42', 'CONSULTANT', '', 'ITS', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222084344000939', NULL, NULL, NULL, '1161258741', '', ''),
('20160559', '2001', 'TSAKEM KENGNI', 'LEONEL', '2000', '19821103000000000000', 'M', '', '675 09 45 57', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222085522000424', NULL, NULL, NULL, '117242106', '', ''),
('20160560', '2001', 'SOM HIONG', 'Alain', '2000', '19800112000000000000', 'M', '', '', '', 'Chef Parc', NULL, '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2001', '2016', '0', 'fewane', NULL, '20160222095905000687', NULL, NULL, NULL, '', '', ''),
('20160561', '2001', 'OUAMBO NZOGANG', 'ZEPHIRIN', '2000', '19820927000000000000', 'M', '', '', 'INFORMATICIEN', '', 'SOREPCO', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222130747000737', NULL, NULL, NULL, '109550743', '', ''),
('20160562', '2002', 'BILLE ', 'ALICE JORDANIELLE', '2000', '19751220000000000000', 'F', '', '696 28 00 82', 'TECHNICIENNE DE SURFACE', '', 'FLO', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160222140709000853', NULL, NULL, NULL, '111199313', '', ''),
('20160563', '2001', 'AMBANG ', 'DENIS ', '2000', '19801124000000000000', 'M', '', '', '', '', 'FMEGAZ', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223091043000353', NULL, NULL, NULL, '', '', ''),
('20160564', '2001', 'TIAHA ', 'DANIEL BLAISE', '2003', '19760316000000000000', 'M', '', '698 88 04 44', 'CHAUFFEUR TRACTEUR ', '', '3TC', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223092708000902', NULL, NULL, NULL, '109453425', '', ''),
('20160565', '2001', 'KENNE ', 'ARNAUD ', '2000', '19801010000000000000', 'M', '', '690 61 17 86', 'AGENT D''APPROVISIONNEMENT', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223093235000254', NULL, NULL, NULL, '111102576', '', ''),
('20160566', '2001', 'ACHE NGAH', 'RICHARD', '2000', '19710104000000000000', 'M', '', '675 92 48 31', 'PEINTRE', '', 'COMETAL', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223093425000945', NULL, NULL, NULL, '115723579', '', ''),
('20160567', '2002', 'NGO NKOK ', 'RACHELLE MARIE MICHELLE', '2003', '19870615000000000000', 'M', '', '675 92 56 29', 'ASSISTANTE LOGISTIQUE ', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223095652000445', NULL, NULL, NULL, '107386458', '', ''),
('20160568', '2001', 'KAMENI KOUOTCHE ', 'ALAIN', '2003', '19780504000000000000', 'M', '', '679596524', 'CHARGE DES TRAVAUX', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223100255000998', NULL, NULL, NULL, '109492511', '', ''),
('20160569', '2003', 'NGOUNJOU ', 'RITA AIMEE', '2003', '19841002000000000000', 'F', '', '675 03 3634', 'SECRETAIRE ', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223121656000208', NULL, NULL, NULL, '113899302', '', ''),
('20160570', '2001', 'TAMAFO LEMOFOUO ', 'PAULIN', '2003', '19890619000000000000', 'M', '', '676 29 26 07', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223124348000418', NULL, NULL, NULL, '110636374', '', ''),
('20160571', '2001', 'DJONTU TAKOUKOUO ', 'PIERRE DESIRE', '2000', '19810629000000000000', 'M', '', '691 94 52 89', 'MONTEUR ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223124642000563', NULL, NULL, NULL, '116452209', '', ''),
('20160572', '2001', 'MISSAMBO MBOMA ', 'COLBERT', '2003', '19870522000000000000', 'M', '', '699 69 54 39', 'EXECUTANT', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223125220000149', NULL, NULL, NULL, '108783186', '', ''),
('20160573', '2001', 'TOUKAM TCHOUANGUE ', 'SERGE LUCIANO', '2003', '19790311000000000000', 'M', '', '699 15 47 86', 'CHARGE DES TRAVAUX', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223131215000801', NULL, NULL, NULL, '114560972', '', ''),
('20160574', '2003', 'FRANCINE MICHELLE', 'NGOKOBI', '2003', '19810616000000000000', 'F', '', '676 11 23 72', 'RH', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223131750000165', NULL, NULL, NULL, '113083744', '', ''),
('20160575', '2003', 'KANA ', 'VIRGINIE', '2003', '19810729000000000000', 'F', '', '678 22 54 90', 'COMPTABLE', '', 'ITS', '0', '1', '', '', NULL, '20160222000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223132544000698', NULL, NULL, NULL, '115715392', '', ''),
('20160576', '2001', 'TCHOUMI ', 'MARTIAL', '2000', '19790801000000000000', 'M', '', '696552428', 'MONTEUR ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223133116000075', NULL, NULL, NULL, '11582294048', '', ''),
('20160577', '2001', 'FOWO ', 'MIRABEAU ENGELBERT', '2003', '19740504000000000000', 'M', '', '694685536', 'CHARGE DES TRAVAUX', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223134647000971', NULL, NULL, NULL, '115159586', '', ''),
('20160578', '2001', 'NTEKI ', 'JOSE ARANTES', '2003', '19820227000000000000', 'M', '', '694680139', 'LOGISTICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223135142000464', NULL, NULL, NULL, '114387338', '', ''),
('20160579', '2003', 'AGWO ', 'SOLANGE ATUH', '2003', '19891011000000000000', 'M', '', '676682505', 'INGENIEUR', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223135614000715', NULL, NULL, NULL, '1174110463', '', ''),
('20160580', '2001', 'KAMGANG DOMFANG', 'FABRICE ', '2003', '19851217000000000000', 'M', '', '696064170', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223135920000273', NULL, NULL, NULL, '1177296897', '', ''),
('20160581', '2001', 'TCHAPTCHET ', 'ALAIN BLAISE', '2003', '19850101000000000000', 'M', '', '674022816', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160223140907000986', NULL, NULL, NULL, '115055413', '', ''),
('20160582', '2001', 'MPOULI NDEMA ', 'DAVID', '2003', '19830708000000000000', 'M', '', '699884188', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224084109000108', NULL, NULL, NULL, '115695280', '', ''),
('20160583', '2001', 'DJOMMOU ', 'AQUIN GABRIEL ', '2003', '19860829000000000000', 'M', '', '674099834', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224084920000618', NULL, NULL, NULL, '111259772', '', ''),
('20160584', '2001', 'TCHIEMOU NJOUOGOUA ', 'GILBERT', '2003', '19881126000000000000', 'M', '', '696751721', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224085122000723', NULL, NULL, NULL, '112004930', '', ''),
('20160585', '2001', 'EWUNDU ', 'ANDREAS AKPAH', '2000', '19741215000000000000', 'M', '', '677 51 07 96', 'SECURITY', '', 'SOREPCO', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224104641000593', NULL, NULL, NULL, '115321582', '', ''),
('20160586', '2001', 'SONE MBANGUE ', 'RICHARD', '2000', '19570101000000000000', 'M', '', '676583823', 'TERRASSEMENT', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224122040000092', NULL, NULL, NULL, '107909728', '', ''),
('20160587', '2001', 'ABBA VAGAI GOLE', '', '2000', '19590101000000000000', 'M', '', '654 28 10 99', 'CONDUCTEUR DE CHARGEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224155936000576', NULL, NULL, NULL, '116704978', '', ''),
('20160588', '2001', 'ALLEH KOUMABEL ', 'JEAN ROMUALD', '2003', '19930724000000000000', 'M', '', '691 72 72 19', 'POINTEUR DE PISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224160234000260', NULL, NULL, NULL, '117378028', '', ''),
('20160589', '2001', 'VOUNDI ', 'JEAN MARC', '2003', '19780313000000000000', 'M', '', '699460064', 'SABLEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160223000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224161226000672', NULL, NULL, NULL, '108638226', '', ''),
('20160590', '2003', 'ENDALLE EWANDJE ', 'MONIQUE', '2003', '19820129000000000000', 'M', '', '694 16 18 05', 'SIGNALEUSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224163018000943', NULL, NULL, NULL, '108709680', '', ''),
('20160591', '2001', 'WOMASSE TAIWE', 'PIERRE', '', '19920101000000000000', 'M', '', '696 74 61 30', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224163215000790', NULL, NULL, NULL, '113442155', '', ''),
('20160592', '2001', 'KALPELE ', 'JEAN', '', '19910210000000000000', 'M', '', '690053497', 'POINTEUR DE PISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224163403000479', NULL, NULL, NULL, '112256402', '', ''),
('20160593', '2001', 'MBONJO NGOSSO', 'ZABULON', '', '19680914000000000000', 'M', '', '695240048', 'AIDE MAGASINIER', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224163629000993', NULL, NULL, NULL, '110885225', '', ''),
('20160594', '2001', 'ELOME NGANDO ', 'SAMUEL', '', '19790415000000000000', 'M', '', '67044 75 61', 'MANOEUVRE', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224164114000290', NULL, NULL, NULL, '1171307715', '', ''),
('20160595', '2001', 'FODJO ', 'JEAN MICHEL', '', '19710501000000000000', 'M', '', '677030808', 'POINTEUR DE PISTE', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224164357000899', NULL, NULL, NULL, '113972397', '', ''),
('20160596', '2001', 'BEASSOUM ', 'CELESTIN', '', '19790910000000000000', 'M', '', '651252318', 'RATELEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224164656000391', NULL, NULL, NULL, 'RO335173', '', ''),
('20160597', '2001', 'NGAISSONA ', 'JOSUE', '', '19780105000000000000', 'M', '', '651239697', 'ELECTROMECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224165007000179', NULL, NULL, NULL, 'RO0335346', '', ''),
('20160598', '2001', 'ALRAM ', 'BRAZZIE', '', '19831101000000000000', 'M', '', '676 04 92 21', 'CONDUCTEUR D''ENGIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224165425000724', NULL, NULL, NULL, 'RO335177', '', ''),
('20160599', '2001', 'NERAMBAYE', 'GEDEON', '', '19740323000000000000', 'M', '', '676 04 92 21', 'CONDUCTEUR D''ENGIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224165630000991', NULL, NULL, NULL, 'RO335246', '', ''),
('20160600', '2001', 'MBAI LASSEM', 'DAVID', '', '19820101000000000000', 'M', '', '676 04 79 89', 'CONDUCTEUR D''ENGIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224165831000907', NULL, NULL, NULL, 'RO335172', '', ''),
('20160601', '2001', 'NADJIAOUKEM MEDEMAILOU', '', '', '19640101000000000000', 'M', '', '651 25 21 88', 'CONDUCTEUR D''ENGIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224170038000003', NULL, NULL, NULL, 'R0335247', '', ''),
('20160602', '2001', 'LAOUDANBE ', 'PATRICE', '', '19780101000000000000', 'M', '', '651 23 96 97', 'CONDUCTEUR D''ENGIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224170223000230', NULL, NULL, NULL, 'R0335171', '', ''),
('20160603', '2001', 'BIMBAYE ', 'NDILBOYE', '', '19760817000000000000', 'M', '', '676 04 92 21', 'CHEF D''EQUIPE', '', 'SSBMD', '0', '1', '', '', NULL, '20160224000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160224170414000079', NULL, NULL, NULL, 'R0335176', '', ''),
('20160604', '2001', 'FEUWO TALOM ', 'LAZARE AURELIE', '2000', '19700920000000000000', 'M', '', '695362688', 'COMPTABLE ', '', 'SSW', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225080832000167', NULL, NULL, NULL, '111264141', '', ''),
('20160605', '2002', 'LAGLANE ', 'NADEGE EMMANUELLE', '2000', '19880914000000000000', 'F', '', '694 88 75 29', 'RECEPTIONNSITE', '', 'OLAM', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225081042000429', NULL, NULL, NULL, '114525319', '', ''),
('20160606', '2001', 'NDJAPPA ', 'JEAN', '', '19600302000000000000', 'M', '', '699302464', 'MECANICIEN/CONDUCTEUR D''ENGIN', '', 'SSBACHY', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225083621000311', NULL, NULL, NULL, '1077736226', '', ''),
('20160607', '2001', 'MBAKOP ', 'ELVIS GHISLAIN', '', '19860909000000000000', 'M', '', '', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225083924000814', NULL, NULL, NULL, '109862354', '', ''),
('20160608', '2001', 'FOATE GUIAGAIN ', 'ERIC XAVIER', '', '19821125000000000000', 'M', '', '674969415', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225084749000631', NULL, NULL, NULL, '117827025', '', ''),
('20160609', '2001', 'YATCHOUKEU NANA ', 'MOÏSE', '', '19770510000000000000', 'M', '', '696860173', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225084950000462', NULL, NULL, NULL, '107253018', '', ''),
('20160610', '2001', 'ABESSOLO ', 'THIERRY CLAUDE', '', '19850709000000000000', 'M', '', '699082009', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225085336000403', NULL, NULL, NULL, '110173801', '', ''),
('20160611', '2001', 'DJEUFFO  ', 'HYPOLLITE ', '', '19900810000000000000', 'M', '', '655638649', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225085515000495', NULL, NULL, NULL, '115443462', '', ''),
('20160612', '2001', 'NDAMEN TCHATO', 'RICHARD', '', '19670915000000000000', 'M', '', '691844510', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225090854000439', NULL, NULL, NULL, '117152274', '', ''),
('20160613', '2001', 'BIAYA ', 'RAPHAEL', '', '19890423000000000000', 'M', '', '699430658', 'ELECTRICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225091042000152', NULL, NULL, NULL, '110817105', '', ''),
('20160614', '2001', 'NDJAKA NDOKA ', 'MARTIN', '', '19810515000000000000', 'M', '', '696 30 88 89', 'PLOMBIER', '', 'SSBACHY', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225091247000709', NULL, NULL, NULL, '117096207', '', '');
INSERT INTO `tab_pat` (`COD_PAT`, `LIB_TIT`, `LIB_NOM`, `LIB_PRE`, `ENU_STA_MAT`, `DAT_NAIS`, `LIB_SEX`, `LIB_ADR`, `LIB_NUM_TEL`, `LIB_PROF`, `LIB_FON`, `COD_SOC`, `BOO_EST_ASS`, `BOO_EST_AFF`, `LIB_PER_CON`, `LIB_NUM_TEL_PER_CON`, `COD_ASS`, `DAT_ENREG`, `BOO_EST_ARCH`, `LIB_MED`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `LIB_ASS`, `LIB_SOC`, `LIB_NUM_CNI`, `LIB_NUM_CNPS`, `LIB_MAT`) VALUES
('20160615', '2001', 'ONANA ', 'FELIX ', '', '19820417000000000000', 'M', '', '694799577', 'CHAUFFEUR ', '', 'SSBACHY', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225091419000470', NULL, NULL, NULL, '117322628', '', ''),
('20160616', '2001', 'KWATE PENANDJO', 'BORIS', '', '19820918000000000000', 'M', '', '699 82 94 54', 'ELECTROTECHNICIEN', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225092147000701', NULL, NULL, NULL, '109409400', '', ''),
('20160617', '2001', 'NOMI ', 'BLAISE ', '', '19690223000000000000', 'M', '', '672 76 49 36', 'CHAUFFEUR ', '', 'SOREPCO', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160225092434000542', '20160225092505000797', NULL, NULL, '117122607', '', ''),
('20160618', '2001', 'MBEMBEL BIYIHA ', 'DANIEL JACQUES', '', '19920725000000000000', 'M', '', '670 89 89 76', 'MACHINISTE', '', 'CMC', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225094611000286', NULL, NULL, NULL, '110344703', '', ''),
('20160619', '2001', 'BOUHAPI YAYA', '', '', '19780101000000000000', 'M', '', '', 'TECHNICIEN', '', 'CTC', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225113051000958', NULL, NULL, NULL, '110212115', '', ''),
('20160620', '2001', 'KAMDEM', 'CLEMENT ', '', '19840404000000000000', 'M', '', '691 845 812', 'CHARGE D4ETUDE', '', 'ITS', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225115600000215', NULL, NULL, NULL, '11701113786', '', ''),
('20160621', '2001', 'NJOYA ', 'MOHAMED', '', '19920212000000000000', 'M', '', '676 74 76 74', 'MANOEUVRE', '', 'SSW', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225121214000856', NULL, NULL, NULL, '108215475', '', ''),
('20160622', '2001', 'NJOUNDAP ', 'IBRAHIM', '', '19891217000000000000', 'M', '', '', 'POINTEUR', '', 'CONG', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225125437000728', NULL, NULL, NULL, '1184342591', '', ''),
('20160623', '2001', 'NJI ', 'CHRISTIAN', '', '19831002000000000000', 'M', '', '', 'TOLIER', '', '3TC', '0', '1', '', '', NULL, '20160225000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160225164646000612', NULL, NULL, NULL, '114563382', '', ''),
('20160624', '2001', 'NEKAM SADO', 'JOEL', '', '19810924000000000000', 'M', '', '677 74 66 98', 'AGENT DE SECURITE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160226000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160226082702000739', NULL, NULL, NULL, '117463775', '', ''),
('20160625', '2001', 'PIEGHU WEAWOH', 'ALBERT ', '', '19621215000000000000', 'M', '', '697 89 60 17', 'AGENT DE SECURITE', '', 'COMETAL', '0', '1', '', '', NULL, '20160226000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160226100354000667', NULL, NULL, NULL, '107676509', '', ''),
('20160626', '2001', 'TOUWALSOU ', 'DANIEL', '', '19850303000000000000', 'M', '', '696 77 43 02', 'FICHISTE', '', 'CMC', '0', '1', '', '', NULL, '20160226000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160226113527000876', NULL, NULL, NULL, '117242738', '', ''),
('20160627', '2001', 'NZUSSOUO OUAFO ', 'HERVE DEDI', '', '19930607000000000000', 'M', '', '694 57 30 39', 'STAGIAIRE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160226000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160226114416000381', NULL, NULL, NULL, '11938286', '', ''),
('20160628', '2001', 'TIOGO ', 'HERMANN ARMEL', '2003', '19920107000000000000', 'M', '', '675 97 62 29', '', '', 'SOREPCO', '0', '0', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229084220000239', NULL, NULL, NULL, '110855688', '', ''),
('20160629', '2001', 'TOUWE TCHIOMTCHOUA ', 'DUCLAIR', '2003', '19890416000000000000', 'M', '', '694 13 36 10', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229090127000071', NULL, NULL, NULL, '110145262', '', ''),
('20160630', '2001', 'KUATE ', 'LEOPOLD', '', '19811004000000000000', 'M', '', '675 55 70 08', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229091703000776', NULL, NULL, NULL, '108311877', '', ''),
('20160631', '2001', 'TEDJONG', 'FABRICE ROMUALD', '2003', '19930302000000000000', 'M', '', '690 57 54 00', '', '', 'SOREPCO', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229100548000549', NULL, NULL, NULL, '110901681', '', ''),
('20160632', '2001', 'FONGANG TEDA', 'SEVERIN', '2003', '19901105000000000000', 'M', '', '680 16 22 97', 'SERVICE ENTRETIEN', '', 'FLO', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229114527000754', NULL, NULL, NULL, '112369413', '', ''),
('20160633', '2001', 'KWEDI MBONGO ', 'GASTON ALAIN', '2003', '19820127000000000000', 'M', '', '696 47 63 16', 'ATTACHE DE DIRECTION', '', 'SOPHYNET ', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229121012000330', NULL, NULL, NULL, '1189017681', '', ''),
('20160634', '2001', 'LEMBEH ALADU', '', '2000', '19770829000000000000', 'M', '', '679 84 84 73', 'CONDUCTEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160229000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160229144004000797', NULL, NULL, NULL, '16221250', '', ''),
('20160635', '2001', 'FEDENET OUADANKOUA', '', '', '19700507000000000000', 'M', '', '690854102', 'CONDUCTEUR BOUILLE', '', 'SSBMD', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', 'tsonia', '20160301085007000170', '20160301085703000120', NULL, NULL, 'RO335486', '', ''),
('20160636', '2003', 'MONCHAU ', 'MARIE FABIENNE ESTELLE CLOTILDE', '', '19910503000000000000', 'F', '', '694 055 580', 'AGENT HSE', '', 'SSW', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160301085511000756', NULL, NULL, NULL, '12CV85650', '', ''),
('20160637', '2001', 'NDJONKAM ', 'MERLIN GISCARD', '', '19751113000000000000', 'M', '', '690929385', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160301085918000427', NULL, NULL, NULL, '1184933994', '', ''),
('20160638', '2001', 'MANDENG ', 'PAUL CHRISTIAN', '', '19831128000000000000', 'M', '', '691280829', 'MANOEUVRE', '', 'SSBMD', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160301090049000234', NULL, NULL, NULL, '115918547', '', ''),
('20160639', '2001', 'NGNINGNINFOUA MFOME', 'HERVE', '', '19920827000000000000', 'M', '', '694113920', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160301090242000328', NULL, NULL, NULL, '1178273327', '', ''),
('20160640', '2001', 'LELE ', 'CHRISTELLE CAROLE DASSILVA', '', '19860521000000000000', 'M', '', '675 15 19 19', 'COMMERCIALE', '', 'SOREPCO', '0', '1', '', '', NULL, '20160301000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160301095851000378', NULL, NULL, NULL, '117017921', '', ''),
('20160641', '2001', 'BILIM', 'DANIEL', '', '19820707000000000000', 'M', '', '695564747', '', '', 'CMC', '0', '1', '', '', NULL, '20160302000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160302122731000403', NULL, NULL, NULL, '114746516', '', ''),
('20160642', '2001', 'ABAG ', 'EMMANUEL', '', '19751224000000000000', 'M', '', '699 74 26 74', 'LABORANTIN', '', 'SSBMD', '0', '1', '', '', NULL, '20160302000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160302124658000478', NULL, NULL, NULL, '113624257', '', ''),
('20160643', '2001', 'MASSANGO NDIBA', 'MARTIN', '', '19600502000000000000', 'M', '', '681 92 47 90', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160302000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160302135554000969', NULL, NULL, NULL, '116173290', '', ''),
('20160644', '2001', 'BOUBA ', 'LAMBERT', '', '19860524000000000000', 'M', '', '', '', '', 'EXEXCH', '0', '0', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303085422000803', NULL, NULL, NULL, '109449237', '', ''),
('20160645', '2001', 'KENGNE ', 'EVARISTE', '', '19720515000000000000', 'M', '', '696 36 04 00', 'AGENT DE SECURITE', '', '3TC', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303085607000000', NULL, NULL, NULL, '109879529', '', ''),
('20160646', '2001', 'KEPTCHOUANG KADJI ', 'SYLVESTRE ', '', '19790209000000000000', 'M', '', '652 12 37 01', 'MENUISIER ', '', 'BR', '0', '1', '', '', NULL, NULL, NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303103643000336', NULL, NULL, NULL, '117124658', '', ''),
('20160647', '2001', 'NAOUSSI GUY ', 'MARTIAL', '', '19930807000000000000', 'M', '', '671 84 28 22', '', '', 'CONG', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303110722000746', NULL, NULL, NULL, '1186611027', '', ''),
('20160648', '2001', 'ELO ', 'MARCEL', '', '19790724000000000000', 'M', '', '695 81 50 08', 'ELECTROMECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303125202000176', NULL, NULL, NULL, '115830714', '', ''),
('20160649', '2001', 'NINGLA ', 'BARNABAS', '', '19610523000000000000', 'M', '', '674685496', 'MAçON COFFREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303125940000193', NULL, NULL, NULL, '114138971', '', ''),
('20160650', '2001', 'ALEGA ATEBA ', 'ANTOINE', '', '19750821000000000000', 'M', '', '691 30 28 72', 'MACON', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303130109000188', NULL, NULL, NULL, '117521016', '', ''),
('20160651', '2001', 'YOMBO A BETCHEM', 'YVES', '', '19790616000000000000', 'M', '', '690 27 38 55', 'MESUREUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303130809000090', NULL, NULL, NULL, '117521016', '', ''),
('20160652', '2001', 'GWAN ', 'PETER MBAH', '', '19600618000000000000', 'M', '', '674 36 59 34', 'FERRAILLEUR', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303131040000877', NULL, NULL, NULL, '111349022', '', ''),
('20160653', '2001', 'MEKONTSO ', 'ROMIEN', '', '19620821000000000000', 'M', '', '699265561', 'MACON', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303131722000888', NULL, NULL, NULL, '108 74 70 38', '', ''),
('20160654', '2001', 'TANYI TIMOTHY AGBOR', '', '', '19910315000000000000', 'M', '', '680631654', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303131858000411', NULL, NULL, NULL, '111252542', '', ''),
('20160655', '2001', 'CHOMGA ', 'FRANCOIS LIENOU', '', '19921023000000000000', 'M', '', '670949383', 'MANOEUVRE SPECIALISEE', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303132253000857', NULL, NULL, NULL, '108969930', '', ''),
('20160656', '2001', 'ERUAKONG TANYI FRTZ', '', '2003', '19940626000000000000', 'M', '', '670617419', 'AIDE COFFREUR ', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303132605000033', NULL, NULL, NULL, '115715140', '', ''),
('20160657', '2001', 'DJIEDEU TCHIADJEU', 'GEOVANY MITROVIC', '', '19890508000000000000', 'M', '', '670 54 28 26', 'MANOEUVRE SPECIALISEE', '', 'SSBMD', '0', '0', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303132919000793', NULL, NULL, NULL, '110732079', '', ''),
('20160658', '2001', 'BILONG ', 'THOMAS FRIDOLIN', '', '19760716000000000000', 'M', '', '674593389', 'MANOEUVRE ', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303133247000312', NULL, NULL, NULL, '1161740889', '', ''),
('20160659', '2001', 'DEUTOU DJIDJIABEU', 'JEOVANYL IGOR', '', '19930312000000000000', 'M', '', '690 79 70 60', 'MANOEUVRE SPECIALISE', '', 'SSBMD', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303133622000078', NULL, NULL, NULL, '116174266', '', ''),
('20160660', '2002', 'NJAMEN JITEU', 'MARCELLE LINDA', '', '19890209000000000000', 'M', '', '', 'INGENIEUR AGRO INDUSTRIELLE', '', 'SOPROICAM', '0', '1', '', '', NULL, '20160303000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160303151152000644', NULL, NULL, NULL, '114074028', '', ''),
('20160661', '2001', 'OWONA GAUTHIER', '', '', '19801016000000000000', 'M', '', '677397592', 'INGENIEUR DES TRAVAUX PROJETEUR', '', 'SSBACHY', '0', '1', '', '', NULL, '20160304000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160304085819000146', NULL, NULL, NULL, '1188939114', '', ''),
('20160662', '2002', 'LUMNWI ', 'MODESTE', '', '19930508000000000000', 'M', '', '674447123', 'RELAIS HSE', '', 'SSBMD', '0', '1', '', '', NULL, '20160304000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160304090536000638', NULL, NULL, NULL, '1186482753', '', ''),
('20160663', '2001', 'MESUMBE', 'TERENCE EBONG', '', '19900324000000000000', 'M', '', '678 63 07 89', '', '', 'BR', '0', '1', '', '', NULL, '20160304000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160304120633000365', NULL, NULL, NULL, '110639148', '', ''),
('20160664', '2001', 'CHAKIKA SODJE', '', '', '19791130000000000000', 'M', '', '', 'COMPTABLE', '', 'SSW', '0', '0', '', '', NULL, '20160305000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160305082538000732', NULL, NULL, NULL, 'R0306935', '', ''),
('20160665', '2001', 'NOAH NDZANA ', '', '', '19711106000000000000', 'M', '', '678638600', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160305000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160305101326000978', NULL, NULL, NULL, '110540216', '', ''),
('20160666', '2001', 'SHYNYUI MBINE ISAIAH', '', '', '19770615000000000000', 'M', '', '681919517', 'MECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160304000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160305101913000935', NULL, NULL, NULL, '116079681', '', ''),
('20160667', '2001', 'NOUTCHA NOUTCHA ', 'GUY CYRILLE', '', '19761231000000000000', 'M', '', '691191058', 'ELECTRICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160305000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160305102113000453', NULL, NULL, NULL, '115080914', '', ''),
('20160668', '2001', 'MBETDJEU TAHI II', 'FRANCKY', '', '19760416000000000000', 'M', '', '693 21 31 64', 'ELECTROMECANICIEN', '', 'SSBMD', '0', '1', '', '', NULL, '20160304000000000000', NULL, '', '2000', '2016', '1', 'tsonia', NULL, '20160305102538000612', NULL, NULL, NULL, '115680914', '', ''),
('20160669', '2000', 'TAMO', 'Alain', '', '20140203000000000000', 'M', '', '', '', '', '3TC', '0', '1', 'TAMO ELIE', '698881211', 'CHANAS', '20160603000000000000', NULL, '', '2000', '2016', '1', 'admin', NULL, '20160603150936000255', NULL, NULL, NULL, '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `tab_pce_jte`
--

CREATE TABLE IF NOT EXISTS `tab_pce_jte` (
  `C_PCE` varchar(255) NOT NULL DEFAULT '',
  `D_PCE` varchar(32) DEFAULT NULL,
  `L_INF_PCE` varchar(255) DEFAULT NULL,
  `L_REF_FCH` varchar(255) DEFAULT NULL,
  `L_REF_PCE` varchar(255) DEFAULT NULL,
  `V_VAL_PCE` decimal(20,2) DEFAULT '0.00',
  `C_LOT_DOC` varchar(255) DEFAULT NULL,
  `C_TYP_PCE` varchar(255) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`C_PCE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_rap_vis_med_emb`
--

CREATE TABLE IF NOT EXISTS `tab_rap_vis_med_emb` (
  `COD_RAP_VIS_MED_EMB` varchar(32) NOT NULL DEFAULT '',
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_RAP_EXAM_CLI` varchar(2048) DEFAULT NULL,
  `LIB_RAP_EXAM_NOR` varchar(2048) DEFAULT NULL,
  `LIB_RAP_EXAM_ANOR` varchar(2048) DEFAULT NULL,
  `LIB_CONCL` varchar(2048) DEFAULT NULL,
  `LIB_RECOM_PART` varchar(2048) DEFAULT NULL,
  `DAT_EDI` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_RAP_VIS_MED_EMB`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_rap_vis_med_perio`
--

CREATE TABLE IF NOT EXISTS `tab_rap_vis_med_perio` (
  `COD_RAP_VIS_MED_PERIO` varchar(32) NOT NULL DEFAULT '',
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `COD_PAT` varchar(32) DEFAULT NULL,
  `LIB_OBJ` varchar(1024) DEFAULT NULL,
  `LIB_RAP_EXAM_CLI` varchar(2048) DEFAULT NULL,
  `LIB_RAP_EXAM_NOR` varchar(2048) DEFAULT NULL,
  `LIB_RAP_EXAM_ANOR` varchar(2048) DEFAULT NULL,
  `LIB_CONCL` varchar(2048) DEFAULT NULL,
  `LIB_RECOM_PART` varchar(2048) DEFAULT NULL,
  `DAT_EDI` varchar(32) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_RAP_VIS_MED_PERIO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_rdv`
--

CREATE TABLE IF NOT EXISTS `tab_rdv` (
  `COD_RDV` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `COD_TYP_RDV` varchar(32) DEFAULT NULL,
  `LIB_TYP_RDV` varchar(255) DEFAULT NULL,
  `COD_SVC` varchar(32) DEFAULT NULL,
  `LIB_SVC` varchar(255) DEFAULT NULL,
  `DAT_DEM` varchar(32) DEFAULT NULL,
  `DAT_RDV` varchar(32) DEFAULT NULL,
  `VAL_NUM_ORDRE` varchar(32) DEFAULT NULL,
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
  `COD_SPEC` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`COD_RDV`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_rol`
--

CREATE TABLE IF NOT EXISTS `tab_rol` (
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
-- Contenu de la table `tab_rol`
--

INSERT INTO `tab_rol` (`COD_ROL`, `LIB_ROL`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('admin', 'Administrateur', '', '2000', '2015', '1', 'admin', NULL, '20150125092122000342', NULL),
('CMP', 'Comptabilité', '', '2000', '2015', '1', 'admin', NULL, '20150221134100000684', NULL),
('INF', 'Infirmier(e)', '', '2000', '2014', '1', 'admin', NULL, '20140922054309000502', NULL),
('MED', 'Medécin', '', '2000', '2014', '1', 'admin', NULL, '20140922054224000191', NULL),
('MED_CHEF', 'Medecin chef', 'ras ras ras', '2000', '2014', '1', 'admin', NULL, '20140808185604000204', NULL),
('SECR', 'Secrétaire', '', '2000', '2014', '1', 'admin', NULL, '20140922054249000293', NULL),
('TCHLAB', 'Technicien(e) Laboratoire', '', '2000', '2015', '1', 'admin', NULL, '20150906012305000217', NULL),
('TCHRADIO', 'Technicien(e) Radio', '', '2000', '2015', '1', 'admin', NULL, '20150906012350000577', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_soc`
--

CREATE TABLE IF NOT EXISTS `tab_soc` (
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
  `VAL_EFF` decimal(20,0) DEFAULT NULL,
  `VAL_PRI_UNI` decimal(20,0) DEFAULT NULL,
  `VAL_TARIF_FIX_MEN` decimal(20,0) DEFAULT NULL,
  `VAL_TARIF_FORFAIT` decimal(20,0) DEFAULT NULL,
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
  `REG_COM` varchar(100) DEFAULT NULL COMMENT 'Registre Commerce',
  PRIMARY KEY (`COD_SOC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_soc`
--

INSERT INTO `tab_soc` (`COD_SOC`, `LIB_SOC`, `LIB_RESP`, `LIB_BP`, `LIB_VIL`, `LIB_TEL`, `LIB_NUM_CONTRIB`, `LIB_SIEGE`, `LIB_ADR_COM`, `BOO_EST_AFF`, `DAT_AFF`, `VAL_EFF`, `VAL_PRI_UNI`, `VAL_TARIF_FIX_MEN`, `VAL_TARIF_FORFAIT`, `DAT_CRE`, `LIB_MAIL`, `LIB_FAX`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `REG_COM`) VALUES
('3S', '3S MOTOR', 'M. HASSAN', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, '20160111000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160111151712000259', NULL, NULL),
('3TC', '3T CAMEROUN', 'INCONNU', '12554', 'Douala', '33404172', 'M069100000719K', '', '', '1', '20120701000000000000', '90', '600', '0', '0', NULL, NULL, NULL, '2000', '2015', '1', 'admin', 'tsonia', '2,02E+19', '20150911150145000276', '09279'),
('ACMS ', 'ACMS ', 'M. NSANGOU', '4989', 'Douala', '33 41 77 12', '', '', '', '1', '20100401000000000000', '14', '850', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('AFC', 'GROUPE AFC', 'M.J.P NENDA', '', 'Douala', '33 42 29 97', '', '', '', '1', '20131023000000000000', '32', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('BATI PLUS', 'BATI PLUS', '', '', 'Douala', '2 33 13 02 27', '', '', '', '1', '20120401000000000000', '9', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('BR', 'BATISSEUR REUNIS', 'M.KEMELO', '5908', 'Douala', '33 42 9276', '', '', '', '1', '20110201000000000000', '32', '750', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('CAT', 'CAT CAMEROUN', 'Mme EVOUTA REGINE', '3832', 'Douala', '33 43 96 14', '', '', '', '1', '20060801000000000000', '7', '850', '25000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('CCF', 'CCF', 'M.DEFFO GACHE JEAN P', '', 'Douala', '33 43 80 63', '', '', '', '1', '20060301000000000000', '40', '0', '0', '60000', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('CMC', 'CMC SARL', '', '2854', 'Douala', '2 33 37  40  88', 'M079700008399W', '', '', '1', '20100501000000000000', '157', '600', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '18246'),
('COCOSAF', 'COMPLEXE COMMERCIAL SANS FRONTIERE', 'JAFFEUR', '', 'Douala', '', '', '', '', '1', '20140701000000000000', '40', '0', '60000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('CODIREL', 'CODIREL', 'M. FOTSO LEONARD', '', 'Douala', '', '', '', '', '1', '20020601000000000000', '13', '850', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('COMETAL', 'COMETAL', 'Mme SAMO CHARLOTTE ', '4382', 'Douala', '33 39 18 55', 'M0199000019U', '', '', '1', '20120101000000000000', '330', '600', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '021992'),
('CONG', 'CONGELCAM', 'M.SAH REMY', '', 'Douala', '33 42 52 25 ', '', '', '', '1', '20091201000000000000', '150', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('CREAT', 'CREATIVE SARL', 'FOTSING', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, '20150801000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160201134807000196', NULL, NULL),
('CTC', 'COMPAGNIE DE TRANSPORT ET DE COMMERCE', 'NKEMELO', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, '20160215000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160215090649000379', NULL, NULL),
('EMEM', 'EMEM SARL', '', '', 'Douala', '2 33 39 02 55', '', '', '', '1', '20120701000000000000', '44', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('ESICO', 'ESICO', 'M. KAMGNO SAMUEL', '5200', 'Douala', '33 40 05 49 ', 'M120100013923H', '', '', '1', '20041101000000000000', '50', '1000', '40000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '01857'),
('EXEXCH', 'EXPRESS EXCHANGE', '', '', 'Douala', '2 33 43 82 15', '', '', '', '1', '20121001000000000000', '100', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('FLO', 'FLORE SERVICE', 'MADAME', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, '20160107000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160107102328000830', NULL, NULL),
('FMEGAZ', 'FME GAZ', '', '3224', 'Douala', '', 'M059300000208W', '', '', '1', '20120701000000000000', '66', '600', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('FS', 'FLORE SERVICES', 'M. NOUPA EMERIC', '', 'Douala', '33 40 22 69', '', '', '', '1', '20040301000000000000', '22', '0', '60000', '60000', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('GE', 'GECEFIC SA', 'M ', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '2000', '2015', '1', 'tsonia', NULL, '20150925091737000929', NULL, NULL),
('GEC', 'GECEFIC ', 'M. KAMWA', '', '', '', '', '', '', '0', NULL, '0', NULL, NULL, NULL, '20160104000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160104134759000912', NULL, NULL),
('GMCLTD', 'GARAGE M. CAMEROON LTD', '', '', 'Douala', '2 33 00 12 71', '', '', '', '1', '20150501000000000000', '8', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('GSIP', 'GARAGE SSS INTER PNEUS', 'ASSAD WADIH', '', 'Douala', '33 42 62 83', '', '', '', '1', '20011101000000000000', '72', '850', '60000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('GT', 'Groupe TEGUO', 'TEGUO Romaric', '', '', '', '222333', '', '', '1', NULL, '37', '12000', NULL, NULL, NULL, NULL, NULL, '2000', '2014', '1', 'admin', 'admin', '20140925065024000070', '20141029065729000751', NULL),
('HACITY', 'HOTEL AKENA CITY', '', '', 'Douala', '2 33 42 17 04', '', '', '', '1', '20120401000000000000', '10', '850', '20000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('HSD', 'HSD', 'M. HUBERT NANA', '', 'Douala', '33 43 62 03', '', '', '', '1', '20100301000000000000', '15', '850', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('HVP', 'HOTEL VALLEE DES PRINCES', 'M.WAMBO SEVERIN', '', 'Douala', '33 40 37 45', '', '', '', '1', '20111101000000000000', '40', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('HYPRO', 'HYPRO SA', 'M.NEMBOT NDASSI', '8074', 'Douala', '33 40 02 32', '', '', '', '1', '20140701000000000000', '50', '850', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('ITS', 'ITS', '', '', 'Douala', '6 99 97 13 73', '', '', '', '1', '20120401000000000000', '37', '1000', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('JEANNOT', 'JEANNOT SARL', 'M.FOTSO JEAN', '', 'Douala', '33 43 41 03 ', '', '', '', '1', '20131101000000000000', '34', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('M2B', 'M2B ENERGY SARL', 'JEAN CLAUDE HAPPY', '362', 'Douala', '2 33 42 44 90', '', '', '', '1', '20150201000000000000', '15', '850', '20000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('MENO', 'GROUPE MENO', 'Robert', '8100', 'Douala', '2 30 40 7757', '', '', '', '1', '20121201000000000000', '106', '850', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('OAS', 'ONYX ALLIED SERVICES ', 'M. NKWALLA WILFRIED', '', 'Douala', '99 84 43 35', '', '', '', '1', '20080201000000000000', '25', '850', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('OBRAS', 'OBRAS CAMEROUN SARL', '', '', 'Douala', '6 99 55 29 72', '', '', '', '1', '20120401000000000000', '10', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('OLAM', 'OLAM CAM SA ', 'Mme  EBOBISSE PRISCILA', '', 'Douala', '33 42 28 15', '', '', '', '1', '20131220000000000000', '97', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('OLAMBEKOKO', 'OLAM CAM BEKOKO', 'M SARKAR SUJAY', '5207', 'Douala', '2 33 42 68 15', 'M050950000389L', '', '', '1', '20131220000000000000', '296', '1000', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('PRIMELEC', 'PRIMELEC SARL', 'M.ABESSOLO', '12100', 'Douala', '33 42 69 74 ', '', '', '', '1', '20140709000000000000', '29', '850', '20000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SAAR', 'SAAR Assurances', '', '', 'Douala', '', '', '', '', '1', '20140701000000000000', '40', '0', '60000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SANYAFRI', 'SANY AFRICAM', '', '827', 'Douala', '22 09 86 97', '', '', '', '1', '20120501000000000000', '10', '850', '20000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SATM', 'SATM', 'M.VOUFO EMMANUEL', '', 'Douala', '33 42 25 24', '', '', '', '1', '20060801000000000000', '52', '850', '60400', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SATOMWOURI', 'SATOM LE WOURI', '', '', 'Douala', '6 91 13 02 42', '', '', '', '1', '20131201000000000000', '0', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SAVES', 'SAVES SARL', '', '', 'Douala', '22 18 47 67', '', '', '', '1', '20130901000000000000', '15', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SITRA', 'SITRACEL SA', 'Me KENMOGNE ', '6813', 'Douala', '22 31 78 20', '', '', '', '1', '20100101000000000000', '55', '850', '25000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SO', 'SOPHYNET', 'SO', '', 'DOUALA', '', '', 'AKWA', '', '0', NULL, '0', NULL, NULL, NULL, '20160209000000000000', NULL, NULL, '2000', '2016', '1', 'tsonia', NULL, '20160209090944000627', NULL, NULL),
('SOPHYNET ', 'SOPHYNET ', 'M. ONOMO', '', 'Douala', '33 43 40 69', '', '', '', '1', '20130905000000000000', '12', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SOPLASCAM', 'SOPLASCAM SARL', 'Mme WABO JULIENNE', '', 'Douala', '99 94 48 59', '', '', '', '1', '20140701000000000000', '11', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SOPROICAM', 'SOPROICAM', '', '', 'Douala', '2 33 04 18 95', '', '', '', '1', '20120201000000000000', '47', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SOREPCO', 'SOREPCO SA', 'M. FELIX SIGNE', '2854', 'Douala', '33 42 08 36', 'M078900001041R', '', '', '1', '20120901000000000000', '230', '600', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '06776'),
('SPDP ', 'SPDP CAPLAIN & SCIE', 'M.WILLS CLEMENT', '', 'Douala', '77 76 23 44', '', '', '', '1', '20060801000000000000', '170', '850', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SSBACHY', 'SUCCURSALE SOLETANCHE BACHY', '', '3210', 'Douala', '', 'M031200040266S', '', '', '1', '20140701000000000000', '235', '850', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SSBMD', 'SOGEA SATOM BASE MATERIELLE', 'MTCHAIWOU MICHEL', '5680', 'Douala', '33 37 38 11', '', '', '', '1', '20080401000000000000', '231', '850', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SSBMY', 'SOGEA SATOM BASE MATERIELLE-YDE', 'MTCHAIWOU MICHEL', '', 'Yaounde', '33 37 38 11', '', '', '', '1', '20080401000000000000', '32', '850', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('SSW', 'SOGEA SATOM LE WOURI', ' ', '5680 DOUALA', 'DOUALA', '', 'M 090300015762 E', 'SUR LE PONT', '', '0', NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, '2000', '2015', '1', 'tsonia', NULL, '20150916123639000495', NULL, NULL),
('STHYC', 'STHYC', '', '191', 'Douala', '6 77 76 42 90', 'M120100013111R', '', '', '1', '20121201000000000000', '50', '850', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '028.059'),
('SUM', 'SUMOCAM', 'Mme SEUDIEU', '5802', 'Douala', '33 37 30 03', 'M060000012765X', '', '', '1', '20031201000000000000', '80', '850', '50000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('TAC', 'TAC SARL', 'M LODEWIJK DELAERE', '', 'Douala', '2 33 41 02 16', '', '', '', '1', '20140828000000000000', '70', '850', '25000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('TEI', 'TEI', 'M. GOULA', '', 'Douala', '', '', '', '', '1', '20140215000000000000', '12', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('TIG', 'TAF INVESTMENT GROUP', 'Mme ASSONG NADIA', '1500', 'Douala', '33404170', 'M0411646390K', '', '', '1', '20100501000000000000', '96', '0', '0', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('TOK', 'TRANSPORT OMAIS KASSIM', 'M. KALED', '', 'Douala', '675 29 17 80', '', '', '', '1', '20080401000000000000', '26', '850', '30000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, ''),
('UTI', 'UTI', 'M.TCHUGFA', '5327', 'Douala', '77 50 26 77', '', '', '', '1', '20070701000000000000', '93', '850', '25000', '0', '2,02E+19', NULL, NULL, '2000', '2015', '1', 'admin', NULL, '2,02E+19', NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `tab_soin`
--

CREATE TABLE IF NOT EXISTS `tab_soin` (
  `COD_SOIN` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_TYP_SOIN` varchar(32) DEFAULT NULL,
  `LIB_SOIN` varchar(45) DEFAULT NULL,
  `LIB_MOTIF` varchar(1024) DEFAULT NULL,
  `VAL_MNT_TTC` decimal(20,2) DEFAULT NULL,
  `DAT_SOIN` varchar(32) DEFAULT NULL,
  `LIB_OBS` varchar(1024) DEFAULT NULL,
  `BOO_VAL` decimal(1,0) DEFAULT '0',
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_PAIE` decimal(1,0) DEFAULT NULL,
  `REF_FAC` varchar(32) DEFAULT NULL,
  `ENU_MOD_PCHG` varchar(30) DEFAULT NULL,
  `COD_VIS_MED_EMB` varchar(32) DEFAULT NULL,
  `COD_VIS_MED_PERIO` varchar(32) DEFAULT NULL,
  `TYP_VIS_MED_SRC` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`COD_SOIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_spec`
--

CREATE TABLE IF NOT EXISTS `tab_spec` (
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
-- Contenu de la table `tab_spec`
--

INSERT INTO `tab_spec` (`COD_SPEC`, `LIB_SPEC`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('S00', 'MEDECINE GENERALE', '', '2000', '2015', '1', 'tsonia', NULL, '20150919160517000557', NULL),
('S10', 'LABORATOIRE', '', '2000', '2015', '1', 'admin', NULL, '20150810150705000569', NULL),
('S11', 'HEMATOLOGIE', '', '2000', '2015', '1', 'admin', NULL, '20150810150733000811', NULL),
('S6', 'NEONATALOGIE', '', '2000', '2015', '1', 'admin', NULL, '20150810145719000909', NULL),
('S7', 'CANCEROLOGIE', '', '2000', '2015', '1', 'admin', NULL, '20150810145742000251', NULL),
('S8', 'INFECTIOLOGIE', '', '2000', '2015', '1', 'admin', NULL, '20150810145803000749', NULL),
('S9', 'RADIOLOGIE', '', '2000', '2015', '1', 'admin', NULL, '20150810150331000308', NULL),
('SPEC_3', 'MEDECINE DU TRAVAIL', 'RAS', '2000', '2014', '1', 'admin', 'admin', '20140922052959000767', '20150810150413000214'),
('SPEC_4', 'DIABETOLOGIE', '', '2001', '2014', '0', 'admin', 'admin', '20140922053035000215', '20150810150443000467'),
('SPEC_5', 'NEUROLOGIE', '', '2000', '2014', '1', 'admin', 'admin', '20140922053057000532', '20150810150520000127'),
('SPEC_A', 'BIOLOGIE', 'RAS', '2000', '2014', '1', 'admin', 'admin', '20140813130821000635', '20150810150547000101'),
('SPEC_B', 'IMAGERIE MEDICALE', 'RAS', '2000', '2014', '1', 'admin', 'admin', '20140813131108000920', '20150810150626000092');

-- --------------------------------------------------------

--
-- Structure de la table `tab_svc`
--

CREATE TABLE IF NOT EXISTS `tab_svc` (
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
-- Contenu de la table `tab_svc`
--

INSERT INTO `tab_svc` (`COD_SVC`, `LIB_SVC`, `LIB_DESC`, `COD_SVC_PAR`, `LIB_SVC_PAR`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('CHIR_DENT', 'Chirugie dentaire', '', 'D_G', 'Pédiatrie', '2000', '2014', '1', 'admin', 'admin', '20140808184646000958', '20150906012027000497'),
('D_G', 'Direction générale', 'RAS', NULL, 'Pédiatrie', '2000', '2014', '1', 'admin', 'admin', '20140808190806000022', '20140905153010000973'),
('INF', 'Infirmerie', '', 'D_G', NULL, '2000', '2014', '1', 'admin', NULL, '20141014124627000219', NULL),
('LABO', 'Laboratoire', '', 'D_G', NULL, '2000', '2014', '1', 'admin', NULL, '20141014090534000212', NULL),
('PED', 'Pédiatrie', 'RAS', 'D_G', NULL, '2000', '2014', '1', 'admin', 'admin', '20140808190837000342', '20150906011940000089'),
('RADIO', 'Radiologie', '', 'D_G', NULL, '2000', '2015', '1', 'admin', NULL, '20150906012129000757', NULL),
('SVC_ACC', 'Accueil', 'RAS', 'D_G', NULL, '2000', '2014', '1', 'admin', 'admin', '20140905152753000291', '20140905152957000895');

-- --------------------------------------------------------

--
-- Structure de la table `tab_typ_exam`
--

CREATE TABLE IF NOT EXISTS `tab_typ_exam` (
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
  `VAL_COUT` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_EXAM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_typ_exam`
--

INSERT INTO `tab_typ_exam` (`COD_TYP_EXAM`, `LIB_TYP_EXAM`, `LIB_DESC`, `COD_CAT_EXAM`, `LIB_CAT_EXAM`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `VAL_COUT`) VALUES
('ASLO', 'ASLO', '', 'CAT3', NULL, '2000', '2016', '1', 'admin', NULL, '20160108160832000859', NULL, '10000'),
('BU', 'Biochimie  urinaire', '', 'CAT4', NULL, '2001', '2015', '0', 'kviviane', 'admin', '20150914114426000596', '20160108160556000441', '6000'),
('CREAT', 'CREATININE', '', 'CAT4', NULL, '2000', '2016', '1', 'admin', NULL, '20160108133717000764', NULL, '6000'),
('CRP', 'CRP', '', 'CAT3', NULL, '2000', '2016', '1', 'admin', NULL, '20160108160726000413', NULL, '10000'),
('GE', 'GE (Goutte Epaisse)', '', 'CAT1', NULL, '2000', '2014', '1', 'admin', 'admin', '20140922060756000856', '20150814215413000311', '4000'),
('GLY', 'Glycemie', '', 'CAT4', NULL, '2000', '2014', '1', 'admin', 'admin', '20140922061153000440', '20160108132802000933', '3000'),
('GSR', 'Groupe Sanguin et Rhésus', '', 'CAT1', NULL, '2000', '2015', '1', 'admin', NULL, '20150814215803000681', NULL, '5000'),
('NFS', 'Numération Formule Sanguine', '', 'CAT1', NULL, '2000', '2015', '1', 'admin', NULL, '20150814215545000193', NULL, '6750'),
('SELLES', 'SELLES', '', 'CAT2', NULL, '2000', '2016', '1', 'admin', NULL, '20160108160200000404', NULL, '3000'),
('SM', 'SM (Serologie Moderne)', '', 'CAT3', NULL, '2000', '2014', '1', 'admin', 'admin', '20140922061040000403', '20160108153021000703', '10000'),
('TBC', 'Test  de tuberculose (cassette)', '', 'CAT3', NULL, '2000', '2015', '1', 'kviviane', NULL, '20150914114158000461', NULL, '10000'),
('UREE', 'UREE', '', 'CAT4', NULL, '2000', '2016', '1', 'admin', NULL, '20160108133411000141', NULL, '6000'),
('URINE', 'URINE', '', 'CAT4', NULL, '2001', '2016', '0', 'admin', NULL, '20160108143053000589', NULL, '6000'),
('WI', 'WIDAL', '', 'CAT3', NULL, '2000', '2015', '1', 'kviviane', NULL, '20150915113436000640', NULL, '7500');

-- --------------------------------------------------------

--
-- Structure de la table `tab_typ_medi`
--

CREATE TABLE IF NOT EXISTS `tab_typ_medi` (
  `COD_TYP_MEDI` varchar(32) NOT NULL DEFAULT '',
  `LIB_TYP_MEDI` varchar(32) NOT NULL DEFAULT '',
  `LIB_TYPE_MEDI` varchar(32) DEFAULT NULL,
  `LIB_DES_MEDI` varchar(254) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_MEDI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tab_typ_rdv`
--

CREATE TABLE IF NOT EXISTS `tab_typ_rdv` (
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
-- Contenu de la table `tab_typ_rdv`
--

INSERT INTO `tab_typ_rdv` (`COD_TYP_RDV`, `LIB_TYP_RDV`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`) VALUES
('CONS_10', 'Consultation', 'RDV pour les consultations', '2000', '2014', '1', 'admin', NULL, '20140813172604000965', NULL),
('HOSTI_11', 'Hospitalisation', 'Rendez-vous pour hospitalisation', '2000', '2014', '1', 'admin', NULL, '20140813172859000658', NULL),
('RDV_EXAM', 'Rendez-vous Examen', '', '2000', '2014', '1', 'admin', NULL, '20140922053145000177', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_typ_soin`
--

CREATE TABLE IF NOT EXISTS `tab_typ_soin` (
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
  `VAL_COUT` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`COD_TYP_SOIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_typ_soin`
--

INSERT INTO `tab_typ_soin` (`COD_TYP_SOIN`, `LIB_TYP_SOIN`, `LIB_DESC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `VAL_COUT`) VALUES
('SOIN_3', 'Perfusion', '', '2000', '2014', '1', 'admin', NULL, '20141014132552000887', NULL, '0.00'),
('SOIN_A', 'Injection', 'RAS', '2000', '2014', '1', 'admin', 'admin', '20140813130938000245', '20141014133443000681', '5000.00'),
('SOIN_B', 'Pensement', 'RAS', '2000', '2014', '1', 'admin', 'admin', '20140813131008000102', '20140922053340000475', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `tab_usr`
--

CREATE TABLE IF NOT EXISTS `tab_usr` (
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
  `COD_SVC` varchar(32) DEFAULT NULL,
  `COD_ROL` varchar(32) DEFAULT NULL,
  `DAT_MOD` varchar(255) DEFAULT NULL,
  `DAT_CRT` varchar(255) DEFAULT NULL,
  `COD_USR_MOD` varchar(255) DEFAULT NULL,
  `COD_USR_CRT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COD_USR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_usr`
--

INSERT INTO `tab_usr` (`COD_USR`, `BOO_ACT`, `COD_EXE_FIS`, `ETAT_ENT`, `BOO_SEX`, `COD_PWD`, `DAT_EMBCH`, `DAT_EXP_PWD`, `LIB_ADR`, `LIB_FON`, `LIB_NOM`, `LIB_PRE`, `COD_SVC`, `COD_ROL`, `DAT_MOD`, `DAT_CRT`, `COD_USR_MOD`, `COD_USR_CRT`) VALUES
('admin', '0.00', '2014', '2000', 'M', 'sysgeho', '20111221000000000000', NULL, '20141221000000000000', 'RH', 'TEGUO', 'Romaric', 'D_G', 'MED_CHEF', '20150221134002000579', '20141221000000000000', 'admin', NULL),
('cepenza', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'EPENZA', 'FLORENCE', 'LABO', 'MED', '20160104144057000750', '20150221140143000174', 'tsonia', 'admin'),
('cmetafeuh', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'METAFEUH', 'Carine', 'INF', 'INF', NULL, '20150221135434000858', NULL, 'admin'),
('dmardochee', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'DJUKOUO', 'Mardochee', 'LABO', 'INF', NULL, '20150906011441000470', NULL, 'admin'),
('fewane', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'DR EWANE', 'Florence', 'D_G', 'MED', NULL, '20150331165428000012', NULL, 'admin'),
('fpatrick', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', 'Médecin', 'FEUSSOUO', 'Patrick', 'D_G', 'MED', NULL, '20150906011724000939', NULL, 'admin'),
('house', '1.00', '2014', '2000', 'M', 'house', '20090805000000000000', '20160825000000000000', 'Douala-bonandjo 75 85 89 63', 'Généraliste', 'Dr House', 'Blanchard', 'PED', 'MED_CHEF', NULL, '20140815110312000436', NULL, 'admin'),
('jkussiu', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'KUSSIU', 'Josiane', 'SVC_ACC', 'SECR', NULL, '20150221134830000674', NULL, 'admin'),
('kchristelle', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', 'Infirmière', 'KAMDEM', 'Christelle', 'INF', 'INF', NULL, '20150906010803000389', NULL, 'admin'),
('kjoseph', '1.00', '2014', '2000', 'M', 'sysgeho', NULL, NULL, '', '', 'Dr KAPTUE', ' Joseph Sylvere', 'D_G', 'MED_CHEF', NULL, '20140925065524000100', NULL, 'admin'),
('kviviane', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, NULL, NULL, 'KENFACK', NULL, 'LABO', 'INF', NULL, '20150906011016000784', NULL, 'admin'),
('lbiverline', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'LAKOUJI', 'Biverline', 'INF', 'INF', NULL, '20150906012551000297', NULL, 'admin'),
('medecin', '1.00', '2015', '2000', 'M', 'medecin', NULL, NULL, '', '', 'Dr TAMO', '', 'CHIR_DENT', 'MED', NULL, '20150125093851000777', NULL, 'admin'),
('mtchikou', '1.00', '2015', '2000', 'F', 'hortence', NULL, NULL, '', '', 'TCHIKOU', 'Marie Hortence', 'INF', 'INF', NULL, '20150603190915000058', NULL, 'admin'),
('ncarine', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'NYA', 'Carine', 'INF', 'INF', NULL, '20150906012810000587', NULL, 'admin'),
('nchristelle', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'NGONTCHA', 'Christelle', 'RADIO', 'TCHLAB', NULL, '20150906012951000538', NULL, 'admin'),
('RAS', '0.00', '2014', '2001', 'F', 'ras', NULL, '20140821000000000000', '', '', 'ras', '', 'D_G', 'MED_CHEF', NULL, '20140823111732000910', NULL, 'admin'),
('RED', '0.00', '2014', '2001', 'F', '111', NULL, '20140820000000000000', '', 're', 're', 're', 'D_G', 'MED_CHEF', NULL, '20140823152949000243', NULL, 'admin'),
('rmenetsa', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'MENETSA', 'Roseline', 'INF', 'INF', NULL, '20150221140335000796', NULL, 'admin'),
('snguemaleu', '1.00', '2015', '2000', 'M', 'sysgeho', NULL, NULL, '', '', 'NGUEMALEU', 'Stéphane', 'SVC_ACC', 'CMP', NULL, '20150221135221000037', NULL, 'admin'),
('sysgeho', '1.00', '2014', '2000', 'M', 'sysgeho', '20140823000000000000', '20160818000000000000', 'RAS', 'ING', 'Le Mego', 'yaya', 'D_G', 'MED_CHEF', NULL, '20140823092541000330', NULL, 'admin'),
('tflorentine', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', '', 'TANDZI', 'Florentine', 'RADIO', 'TCHRADIO', NULL, '20150906013134000630', NULL, 'admin'),
('tsonia', '1.00', '2014', '2000', 'M', 'sonia', NULL, NULL, '', '', 'TAMNO', 'Sonia', 'SVC_ACC', 'MED_CHEF', NULL, '20140922054138000158', NULL, 'admin'),
('vmveng', '1.00', '2015', '2000', 'M', 'sysgeho', NULL, NULL, '', '', 'MVENG', 'Valentin', 'D_G', 'MED', NULL, '20150221135949000995', NULL, 'admin'),
('ysandrine', '1.00', '2015', '2000', 'F', 'sysgeho', NULL, NULL, '', 'Technicienne de laboratoire', 'YIMGA', 'Sandrine', 'LABO', 'INF', NULL, '20150906011226000760', NULL, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `tab_vis_med_emb`
--

CREATE TABLE IF NOT EXISTS `tab_vis_med_emb` (
  `COD_VIS_MED_EMB` varchar(32) NOT NULL DEFAULT '',
  `COD_PAT` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `DAT_VIS_MED` varchar(32) DEFAULT NULL,
  `LIB_MOTIF` varchar(255) DEFAULT NULL,
  `LIB_OBS` varchar(1024) DEFAULT NULL,
  `BOO_EST_VAL` decimal(1,0) DEFAULT '0',
  `VAL_MNT_TTC` decimal(20,0) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  `BOO_RAP_VIS_MED` decimal(1,0) DEFAULT NULL,
  PRIMARY KEY (`COD_VIS_MED_EMB`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tab_vis_med_emb`
--

INSERT INTO `tab_vis_med_emb` (`COD_VIS_MED_EMB`, `COD_PAT`, `COD_USR`, `DAT_VIS_MED`, `LIB_MOTIF`, `LIB_OBS`, `BOO_EST_VAL`, `VAL_MNT_TTC`, `ETAT_ENT`, `COD_EXE_FIS`, `BOO_ACT`, `COD_USR_CRT`, `COD_USR_MOD`, `DAT_CRT`, `DAT_MOD`, `BOO_RAP_VIS_MED`) VALUES
('2016000005', '20160017', 'fpatrick', '20160104000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160104150115000519', NULL, '0'),
('2016000004', '20160013', 'cepenza', '20160104000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '1', '0', '2002', '2016', '1', 'tsonia', 'tsonia', '20160104144639000201', '20160104144655000785', '0'),
('2015000005', '20150013', 'fpatrick', '20150914000000000000', 'VISITE D''EMBAUCHE SOREPCO', '', '0', '13500', '2000', '2015', '1', 'tsonia', NULL, '20150914103302000341', NULL, '0'),
('2015000006', '20150017', 'fewane', '20150914000000000000', 'VISITE D''EMBAUCHE', '', '0', '13500', '2000', '2015', '1', 'tsonia', NULL, '20150914103635000508', NULL, '0'),
('2015000007', '20150020', 'fpatrick', '20150914000000000000', 'VISITE D''EMBAUCHE SOREPCO', '', '0', '13500', '2000', '2015', '1', 'tsonia', NULL, '20150914103745000205', NULL, '0'),
('2015000008', '20150023', 'kjoseph', '20150914000000000000', 'Visite médicale d''embauche', '', '1', '0', '2002', '2015', '1', 'tsonia', 'tsonia', '20150914161306000041', '20150914161719000001', '0'),
('2015000009', '20150025', 'fewane', '20150915000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '1', '13500', '2002', '2015', '1', 'tsonia', 'tsonia', '20150915075703000337', '20150915075720000403', '0'),
('2015000010', '20150024', 'fpatrick', '20150915000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '1', '13500', '2002', '2015', '1', 'tsonia', 'tsonia', '20150915075925000921', '20150915075936000092', '0'),
('2016000006', '20160015', 'fewane', '20160104000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160104150251000004', NULL, '0'),
('2016000007', '20160014', 'fpatrick', '20160104000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160104150420000693', NULL, '0'),
('2016000008', '20160019', 'fpatrick', '20160105000000000000', 'visite medicale d''embauche', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105091723000321', NULL, '0'),
('2016000009', '20160022', 'fewane', '20160105000000000000', 'visite medicale d''embauche', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105092026000607', NULL, '0'),
('2016000010', '20160020', 'fpatrick', '20160105000000000000', 'visite medicale d''embauche', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105092237000700', NULL, '0'),
('2016000011', '20160021', 'fpatrick', '20160105000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105092406000347', NULL, '0'),
('2016000012', '20160023', 'fpatrick', '20160105000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105093114000580', NULL, '0'),
('2016000013', '20160026', 'fpatrick', '20160105000000000000', 'VISITE MEDICALE D''EMBAUCHE', '', '0', '0', '2000', '2016', '1', 'tsonia', NULL, '20160105135215000995', NULL, '0'),
('2016000014', NULL, NULL, '20160218000000000000', 'VME', 'examen normal', '0', '0', '2000', '2016', '1', 'fewane', NULL, '20160218094850000620', NULL, '0');

-- --------------------------------------------------------

--
-- Structure de la table `tab_vis_med_perio`
--

CREATE TABLE IF NOT EXISTS `tab_vis_med_perio` (
  `COD_VIS_MED_PERIO` varchar(32) NOT NULL DEFAULT '',
  `LIB_VIS_MED_PERIO` varchar(255) DEFAULT NULL,
  `COD_SOC` varchar(32) DEFAULT NULL,
  `COD_USR` varchar(32) DEFAULT NULL,
  `DAT_VIS_MED` varchar(32) DEFAULT NULL,
  `DAT_DER_VIS_MED` varchar(32) DEFAULT NULL,
  `LIB_MOTIF` varchar(255) DEFAULT NULL,
  `LIB_OBS` varchar(1024) DEFAULT NULL,
  `BOO_EST_VAL` decimal(1,0) DEFAULT '0',
  `VAL_MNT_TTC` decimal(20,2) DEFAULT NULL,
  `VAL_NBR` decimal(20,0) DEFAULT NULL,
  `ETAT_ENT` varchar(30) DEFAULT NULL,
  `COD_EXE_FIS` varchar(30) DEFAULT NULL,
  `BOO_ACT` decimal(1,0) DEFAULT '0',
  `COD_USR_CRT` varchar(30) DEFAULT NULL,
  `COD_USR_MOD` varchar(30) DEFAULT NULL,
  `DAT_CRT` varchar(30) DEFAULT NULL,
  `DAT_MOD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`COD_VIS_MED_PERIO`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
