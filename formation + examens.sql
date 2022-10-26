-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 19 oct. 2022 à 19:26
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `e_lmadrsa`
--

-- --------------------------------------------------------

--
-- Structure de la table `attestation`
--

DROP TABLE IF EXISTS `attestation`;
CREATE TABLE IF NOT EXISTS `attestation` (
  `idAttestation` int(11) NOT NULL AUTO_INCREMENT,
  `idparticipation` int(11) NOT NULL,
  `dateAcq` date NOT NULL,
  PRIMARY KEY (`idAttestation`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `idCategorie` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomCategorie` bigint(20) NOT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

DROP TABLE IF EXISTS `competences`;
CREATE TABLE IF NOT EXISTS `competences` (
  `idCompetence` bigint(20) NOT NULL,
  `nomCompetence` varchar(255) NOT NULL,
  PRIMARY KEY (`idCompetence`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

DROP TABLE IF EXISTS `examen`;
CREATE TABLE IF NOT EXISTS `examen` (
  `idExamen` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomExamen` varchar(255) NOT NULL,
  `pourcentage` double NOT NULL,
  `DureeExamen` int(11) NOT NULL,
  `formationId` bigint(20) DEFAULT NULL,
  `idcategorie` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idExamen`),
  KEY `Examen_fk1` (`idcategorie`),
  KEY `Examen_fk0` (`formationId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `examen`
--

INSERT INTO `examen` (`idExamen`, `nomExamen`, `pourcentage`, `DureeExamen`, `formationId`, `idcategorie`) VALUES
(20, 'fr', 30, 40, NULL, NULL),
(15, 'fr', 30, 40, NULL, NULL),
(4, 'symfony', 12, 60, NULL, NULL),
(19, 'symfony', 12, 60, NULL, NULL),
(18, 'mathhhh', 10, 10, NULL, NULL),
(17, 'dd', 20, 0, NULL, NULL),
(14, 'allemand ', 60, 100, NULL, NULL),
(12, 'mathhhh', 10, 10, NULL, NULL),
(21, 'symfony', 12, 60, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `idFormation` bigint(20) NOT NULL AUTO_INCREMENT,
  `Sujet` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Difficulté` enum('facile','moyen','difficile') DEFAULT NULL,
  `durée` int(11) NOT NULL,
  `idPrerequis` bigint(20) DEFAULT NULL,
  `idCompetence` bigint(20) DEFAULT NULL,
  `idExamen` bigint(20) NOT NULL,
  `idCategorie` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idFormation`),
  KEY `Formation_fk0` (`idPrerequis`),
  KEY `Formation_fk1` (`idCompetence`),
  KEY `Formation_fk2` (`idExamen`),
  KEY `Formation_fk3` (`idCategorie`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`idFormation`, `Sujet`, `Description`, `Difficulté`, `durée`, `idPrerequis`, `idCompetence`, `idExamen`, `idCategorie`) VALUES
(2, 'sujet1', 'descp1', 'facile', 12, 0, 2, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `opt`
--

DROP TABLE IF EXISTS `opt`;
CREATE TABLE IF NOT EXISTS `opt` (
  `idOption` int(11) NOT NULL AUTO_INCREMENT,
  `optionName` varchar(255) NOT NULL,
  `questionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idOption`),
  KEY `Option_fk0` (`questionId`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `opt`
--

INSERT INTO `opt` (`idOption`, `optionName`, `questionId`) VALUES
(7, 'ded', NULL),
(3, 'ded', NULL),
(4, 'sss', NULL),
(8, 'oui', NULL),
(6, '', NULL),
(9, 'oui', NULL),
(10, ',,,', NULL),
(11, 'dd', NULL),
(12, 'aaaaaaaa', NULL),
(13, 'ahmed', 1),
(14, 'ahmed', 1),
(15, 'nonchayla', NULL),
(16, 'sssssssssssss', 2),
(17, 'question 1', 6);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `idParticipation` bigint(20) NOT NULL AUTO_INCREMENT,
  `idUser` bigint(20) DEFAULT NULL,
  `idFormation` bigint(20) DEFAULT NULL,
  `resultat` double DEFAULT NULL,
  PRIMARY KEY (`idParticipation`),
  KEY `Participation_fk0` (`idUser`),
  KEY `Participation_fk1` (`idFormation`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`idParticipation`, `idUser`, `idFormation`, `resultat`) VALUES
(1, NULL, NULL, 50),
(2, NULL, NULL, 50),
(3, NULL, NULL, 50),
(4, NULL, NULL, 50),
(5, NULL, NULL, 50),
(6, NULL, NULL, 50),
(7, NULL, NULL, 50);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`) VALUES
(1, 'ahmed', 'gouiaa'),
(2, 'ahmed', 'gouiaa'),
(3, 'ahmed', 'aymen'),
(4, 'ahmed', 'aymen'),
(5, '', ''),
(6, 'emna', 's'),
(7, 'mariem ', 'gouiaa'),
(8, 'chouaib', 'gouiaa');

-- --------------------------------------------------------

--
-- Structure de la table `prerequis`
--

DROP TABLE IF EXISTS `prerequis`;
CREATE TABLE IF NOT EXISTS `prerequis` (
  `idPrerequis` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomPrerequis` varchar(255) NOT NULL,
  PRIMARY KEY (`idPrerequis`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `idQuestion` bigint(20) NOT NULL AUTO_INCREMENT,
  `ennonce` varchar(255) NOT NULL,
  `quizId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idQuestion`),
  KEY `Question_fk0` (`quizId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`idQuestion`, `ennonce`, `quizId`) VALUES
(2, 'aslema', NULL),
(4, 'aslema', NULL),
(6, 'aslema', 2);

-- --------------------------------------------------------

--
-- Structure de la table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
CREATE TABLE IF NOT EXISTS `quiz` (
  `idQuiz` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameQuiz` varchar(255) NOT NULL,
  `examenId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idQuiz`),
  KEY `Quiz_fk0` (`examenId`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quiz`
--

INSERT INTO `quiz` (`idQuiz`, `nameQuiz`, `examenId`) VALUES
(10, 'K', NULL),
(2, 'html', NULL),
(3, 'symfony', NULL),
(7, 'non', NULL),
(5, 'quiz1000', NULL),
(11, 'sss', 20),
(9, '', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
