-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 14 mars 2025 à 06:37
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `auto_ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartient`
--

CREATE TABLE `appartient` (
  `numq` int(4) NOT NULL,
  `numcd` int(4) NOT NULL,
  `nums` int(4) NOT NULL,
  `rang` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `appartient`
--

INSERT INTO `appartient` (`numq`, `numcd`, `nums`, `rang`) VALUES
(1001, 120, 1, 2),
(1001, 120, 4, 2),
(1001, 130, 3, 1),
(1001, 140, 2, 6),
(1002, 120, 1, 2),
(1003, 120, 1, 3),
(1004, 150, 1, 10),
(1005, 150, 1, 11),
(1006, 120, 1, 5),
(1006, 120, 4, 1),
(1007, 120, 4, 4),
(1007, 140, 3, 7),
(1008, 120, 4, 3),
(1008, 140, 2, 8),
(1009, 120, 1, 6),
(1010, 120, 1, 8),
(1011, 120, 4, 6),
(1011, 130, 3, 2),
(1012, 130, 3, 3),
(1013, 130, 3, 5),
(1014, 130, 3, 6),
(1015, 140, 2, 7),
(1018, 120, 4, 5),
(1018, 150, 1, 20);

-- --------------------------------------------------------

--
-- Structure de la table `assiste`
--

CREATE TABLE `assiste` (
  `nume` int(4) NOT NULL,
  `datea` date NOT NULL,
  `heurea` int(4) NOT NULL,
  `nbfautes` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `assiste`
--

INSERT INTO `assiste` (`nume`, `datea`, `heurea`, `nbfautes`) VALUES
(13001, '2013-06-05', 10, 1),
(13001, '2013-06-06', 10, 0),
(13001, '2013-06-07', 10, 3),
(13001, '2013-06-07', 11, 2),
(13001, '2013-06-07', 14, 3),
(13002, '2013-06-07', 10, 6),
(13002, '2013-06-07', 11, 2),
(13002, '2013-06-07', 14, 5),
(13002, '2013-06-10', 10, 1),
(13003, '2013-06-07', 10, 6),
(13003, '2013-06-10', 11, 2),
(13003, '2013-06-10', 14, 5),
(13004, '2013-06-07', 10, 2),
(13004, '2013-06-10', 11, 1),
(13004, '2013-06-10', 14, 3),
(13005, '2013-06-06', 10, 3),
(13005, '2013-06-06', 11, 2),
(13005, '2013-06-07', 10, 1),
(13005, '2013-06-07', 11, 3),
(13006, '2013-06-05', 10, 2),
(13006, '2013-06-06', 11, 1),
(13006, '2013-06-06', 14, 3),
(13006, '2013-06-07', 14, 0),
(13006, '2013-06-10', 14, 2),
(13007, '2013-06-05', 14, 3),
(13007, '2013-06-06', 11, 2),
(13007, '2013-06-06', 15, 3),
(13007, '2013-06-07', 14, 0),
(13008, '2013-06-05', 10, 1),
(13008, '2013-06-06', 11, 3),
(13008, '2013-06-06', 14, 2),
(13008, '2013-06-07', 14, 1),
(13008, '2013-06-10', 14, 6);

-- --------------------------------------------------------

--
-- Structure de la table `cd`
--

CREATE TABLE `cd` (
  `numcd` int(4) NOT NULL,
  `editeur` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cd`
--

INSERT INTO `cd` (`numcd`, `editeur`) VALUES
(110, 'editeurA'),
(120, 'editeurA'),
(130, 'editeurB'),
(140, 'editeurC'),
(150, 'editeurD'),
(160, 'editeurD');

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE `eleve` (
  `nume` int(4) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `adresse` varchar(40) DEFAULT NULL,
  `datenaiss` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`nume`, `nom`, `prenom`, `adresse`, `datenaiss`) VALUES
(13001, 'Lagaffe', 'Gaston', 'adresse', '1957-02-27'),
(13002, 'Labévue', 'Bertrand', 'adresse', '1957-06-10'),
(13003, 'Molaire', 'Mélanie', 'adresse', '1957-06-10'),
(13004, 'de Mesmaeker', 'M.', 'adresse', '1957-06-10'),
(13005, 'Longtarin', 'policier', 'adresse', '1957-06-10'),
(13006, 'Fantasio', NULL, 'adresse', '1938-06-10'),
(13007, 'de Champignac', 'Ladislas', 'Champignac', '1938-06-10'),
(13008, 'Labarbe', 'Gustave', 'Champignac', '1938-06-10'),
(13009, 'Dupilon', 'Célestin', 'Champignac', '1938-06-10');

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE `examen` (
  `datee` date NOT NULL,
  `heuree` int(4) NOT NULL,
  `typee` varchar(25) DEFAULT NULL,
  `resultate` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `examen`
--

INSERT INTO `examen` (`datee`, `heuree`, `typee`, `resultate`) VALUES
('2013-06-08', 10, 'code', NULL),
('2013-06-11', 14, 'conduite', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `inscrit`
--

CREATE TABLE `inscrit` (
  `nume` int(4) NOT NULL,
  `datee` date NOT NULL,
  `heuree` int(4) NOT NULL,
  `nbfautes` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `inscrit`
--

INSERT INTO `inscrit` (`nume`, `datee`, `heuree`, `nbfautes`) VALUES
(13001, '2013-06-08', 10, 0),
(13005, '2013-06-08', 10, 6),
(13006, '2013-06-08', 10, 7),
(13007, '2013-06-11', 14, NULL),
(13008, '2013-06-08', 10, 6);

-- --------------------------------------------------------

--
-- Structure de la table `lecon`
--

CREATE TABLE `lecon` (
  `numl` int(4) NOT NULL,
  `date_cours` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `duree` int(4) DEFAULT NULL,
  `nume` int(4) DEFAULT NULL,
  `numm` int(4) DEFAULT NULL,
  `numv` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `lecon`
--

INSERT INTO `lecon` (`numl`, `date_cours`, `heure_debut`, `duree`, `nume`, `numm`, `numv`) VALUES
(1, '2013-06-10', '09:00:00', 2, 13001, 1, 1),
(2, '2013-06-12', '14:30:00', 2, 13001, 1, 1),
(3, '2013-06-08', '09:30:00', 3, 13005, 3, 3),
(4, '2013-06-05', '10:00:00', 2, 13006, 2, 2),
(5, '2013-06-08', '15:00:00', 1, 13006, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `moniteur`
--

CREATE TABLE `moniteur` (
  `numm` int(4) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `moniteur`
--

INSERT INTO `moniteur` (`numm`, `nom`, `prenom`) VALUES
(1, 'Prost', 'Alain'),
(2, 'Vaillant', 'Michel'),
(3, 'Peterhansel', 'Stéphane');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `numq` int(4) NOT NULL,
  `intitule` varchar(200) DEFAULT NULL,
  `reponse` varchar(4) DEFAULT NULL,
  `diffic` int(4) DEFAULT NULL,
  `theme` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`numq`, `intitule`, `reponse`, `diffic`, `theme`) VALUES
(1001, 'Le jour se lève, ce cycliste circulant en agglomération doit porter le gilet rétro-réfléchissant de sécurité: A) oui B) non', 'B', 4, 'Vehicule et conducteur'),
(1002, 'L\'éco-conduite a des effets positifs, en terme de sécurité routière: A) oui B) non', 'A', 1, 'Vehicule et conducteur'),
(1003, 'L\'éco-conduite a des effets positifs, en terme de confort pour le conducteur et les passagers: A) oui B) non', 'A', 1, 'Vehicule et conducteur'),
(1004, 'Pour limiter la consommation de carburant, je dois changer les vitesses à bas régime moteur: A) oui B) non', 'A', 2, 'Vehicule et conducteur'),
(1005, 'Je circule hors agglomération, j\'allume: A) les feux de route B) les feux de croisement C) les feux de position seuls', 'B', 1, 'Circulation'),
(1006, 'La limitation de vitesse: A) commence au panneau B) commence à 400 mètres C) s\'étend sur 400 mètres D) se termine à 400 mètres', 'B', 4, 'Signalisation'),
(1007, 'Dans les tunnels les dispositifs à diodes bleues servent à: A) éclairer le tunnel B) délimiter les distances de sécurité C) annoncer une issue de secours D) annoncer une niche de sécurité', 'B', 4, 'Signalisation'),
(1008, 'L\'assurance responsabilité civile couvre les dégâts d\'un véhicule volé: A) oui B) non', 'B', 1, 'Vehicule et conducteur'),
(1009, 'La rue est à sens unique: A) oui B) non', 'B', 3, 'Signalisation'),
(1010, 'Dans une voie pour véhicule lent, on peut circuler au maximum à: A) 40 km/h B) 50 km/h C) 60 km/h D) 70 km/h', 'C', 4, 'Circulation'),
(1011, 'Je suis le dernier de la file, j\'allume les feux de détresse: A) oui B) non', 'A', 1, 'Circulation'),
(1012, 'Je me sens fatigué: A) j\'accélère pour arriver plus vite B) je circule moins vite, c\'est plus prudent C) je m\'arrête pour me reposer', 'C', 1, 'Vehicule et conducteur'),
(1013, 'Ce panneau annonce un dénivelé de: A) 5 mètres tous les 10 mètres B) 5 mètres tous les 100 mètres C) 5 mètres tous les 1000 mètres', 'B', 4, 'Signalisation'),
(1014, 'Cette très jeune cycliste peut circuler sur la piste cyclable: A) oui B) non', 'A', 2, 'Circulation'),
(1015, 'Le plus grand responsable des accidents mortels est: A) le comportement du conducteur B) l\'alcool C) la vitesse D) la fatigue', 'A', 3, 'Vehicule et conducteur'),
(1016, 'Je pars en vacances 15 jours, je peux laisser mon véhicule dans cette rue où le stationnement est gratuit: A) oui B) non', 'B', 3, 'Stationnement'),
(1017, 'La distance parcourue pendant le temps de réaction dépend: A) de la vitesse B) de l\'état de la route', 'A', 2, 'Circulation'),
(1018, 'Je peux tourner à droite: A) oui B) non', 'A', 1, 'Priorités'),
(1019, 'Je dépasse ce cycliste: A) oui B) non', 'B', 4, 'Croiser et depasser');

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE `seance` (
  `dates` date NOT NULL,
  `heures` int(4) NOT NULL,
  `nums` int(4) DEFAULT NULL,
  `numcd` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`dates`, `heures`, `nums`, `numcd`) VALUES
('2013-06-05', 10, 1, 110),
('2013-06-07', 10, 1, 120),
('2013-06-10', 11, 1, 150),
('2013-06-06', 10, 1, 160),
('2013-06-10', 10, 2, 120),
('2013-06-05', 14, 2, 140),
('2013-06-06', 14, 2, 140),
('2013-06-07', 14, 2, 140),
('2013-06-07', 13, 2, 150),
('2013-06-10', 13, 2, 160),
('2013-06-10', 15, 3, 120),
('2013-06-05', 13, 3, 150),
('2013-06-06', 13, 3, 160),
('2013-06-05', 15, 4, 110),
('2013-06-06', 15, 4, 120),
('2013-06-07', 15, 4, 120),
('2013-06-10', 14, 4, 140),
('2013-06-06', 11, 4, 150),
('2013-06-07', 11, 4, 150),
('2013-06-05', 11, 4, 160);

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

CREATE TABLE `serie` (
  `nums` int(4) NOT NULL,
  `numcd` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `serie`
--

INSERT INTO `serie` (`nums`, `numcd`) VALUES
(1, 110),
(1, 120),
(1, 130),
(1, 140),
(1, 150),
(1, 160),
(2, 110),
(2, 120),
(2, 130),
(2, 140),
(2, 150),
(2, 160),
(3, 110),
(3, 120),
(3, 130),
(3, 140),
(3, 150),
(3, 160),
(4, 110),
(4, 120),
(4, 130),
(4, 140),
(4, 150),
(4, 160);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `numv` int(11) NOT NULL,
  `immatriculation` varchar(9) DEFAULT NULL,
  `modele` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`numv`, `immatriculation`, `modele`) VALUES
(1, '911NPB75', 'Porche 911'),
(2, 'JBZ6007', 'Aston Martin DB5'),
(3, 'ZZ784AA', 'Lotus Seven'),
(4, 'AB093CD', 'Renault Clio'),
(5, '44122MG', 'pegeo');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appartient`
--
ALTER TABLE `appartient`
  ADD PRIMARY KEY (`numq`,`numcd`,`nums`),
  ADD KEY `FK_QUESTION_NUMS_NUMCD_SERIE` (`nums`,`numcd`);

--
-- Index pour la table `assiste`
--
ALTER TABLE `assiste`
  ADD PRIMARY KEY (`nume`,`datea`,`heurea`),
  ADD KEY `FK_ASSISTE_DATEA_HEUREA_SEANCE` (`datea`,`heurea`);

--
-- Index pour la table `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`numcd`);

--
-- Index pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD PRIMARY KEY (`nume`);

--
-- Index pour la table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`datee`,`heuree`);

--
-- Index pour la table `inscrit`
--
ALTER TABLE `inscrit`
  ADD PRIMARY KEY (`nume`,`datee`,`heuree`),
  ADD KEY `FK_INSCRIT_DATEE_HEUREE_SEANCE` (`datee`,`heuree`);

--
-- Index pour la table `lecon`
--
ALTER TABLE `lecon`
  ADD PRIMARY KEY (`numl`),
  ADD KEY `FK_LECON_NUME_ELEVE` (`nume`),
  ADD KEY `FK_LECON_NUMM_MONITEUR` (`numm`),
  ADD KEY `FK_LECON_NUMV_VEHICULE` (`numv`);

--
-- Index pour la table `moniteur`
--
ALTER TABLE `moniteur`
  ADD PRIMARY KEY (`numm`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`numq`),
  ADD UNIQUE KEY `intitule` (`intitule`);

--
-- Index pour la table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`dates`,`heures`),
  ADD KEY `FK_SEANCE_NUMS_NUMCD_SERIE` (`nums`,`numcd`);

--
-- Index pour la table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`nums`,`numcd`),
  ADD KEY `FK_SERIE_NUMCD_CD` (`numcd`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`numv`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cd`
--
ALTER TABLE `cd`
  MODIFY `numcd` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161;

--
-- AUTO_INCREMENT pour la table `eleve`
--
ALTER TABLE `eleve`
  MODIFY `nume` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13010;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `numq` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1020;

--
-- AUTO_INCREMENT pour la table `serie`
--
ALTER TABLE `serie`
  MODIFY `nums` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `numv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartient`
--
ALTER TABLE `appartient`
  ADD CONSTRAINT `FK_QUESTION_NUMQ_QUESTION` FOREIGN KEY (`numq`) REFERENCES `question` (`numq`),
  ADD CONSTRAINT `FK_QUESTION_NUMS_NUMCD_SERIE` FOREIGN KEY (`nums`,`numcd`) REFERENCES `serie` (`nums`, `numcd`);

--
-- Contraintes pour la table `assiste`
--
ALTER TABLE `assiste`
  ADD CONSTRAINT `FK_ASSISTE_DATEA_HEUREA_SEANCE` FOREIGN KEY (`datea`,`heurea`) REFERENCES `seance` (`dates`, `heures`),
  ADD CONSTRAINT `FK_ASSISTE_NUME_NUM_ELEVE` FOREIGN KEY (`nume`) REFERENCES `eleve` (`nume`);

--
-- Contraintes pour la table `inscrit`
--
ALTER TABLE `inscrit`
  ADD CONSTRAINT `FK_INSCRIT_DATEE_HEUREE_SEANCE` FOREIGN KEY (`datee`,`heuree`) REFERENCES `examen` (`datee`, `heuree`),
  ADD CONSTRAINT `FK_INSCRIT_NUME_NUM_ELEVE` FOREIGN KEY (`nume`) REFERENCES `eleve` (`nume`);

--
-- Contraintes pour la table `lecon`
--
ALTER TABLE `lecon`
  ADD CONSTRAINT `FK_LECON_NUME_ELEVE` FOREIGN KEY (`nume`) REFERENCES `eleve` (`nume`),
  ADD CONSTRAINT `FK_LECON_NUMM_MONITEUR` FOREIGN KEY (`numm`) REFERENCES `moniteur` (`numm`),
  ADD CONSTRAINT `FK_LECON_NUMV_VEHICULE` FOREIGN KEY (`numv`) REFERENCES `vehicule` (`numv`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `FK_SEANCE_NUMS_NUMCD_SERIE` FOREIGN KEY (`nums`,`numcd`) REFERENCES `serie` (`nums`, `numcd`);

--
-- Contraintes pour la table `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `FK_SERIE_NUMCD_CD` FOREIGN KEY (`numcd`) REFERENCES `cd` (`numcd`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
