-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 26 nov. 2026 à 07:56
-- Version du serveur : 8.4.7
-- Version de PHP : 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp_bank`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `email`) VALUES
(1, 'Dupont', 'Jean', 'jean.dupont@email.com'),
(2, 'Martin', 'Sophie', 'sophie.martin@email.com'),
(3, 'Bernard', 'Lucas', 'lucas.bernard@email.com');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_compte` varchar(50) NOT NULL,
  `solde` decimal(10,2) NOT NULL DEFAULT '0.00',
  `client_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_compte` (`numero_compte`),
  KEY `fk_compte_client` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `numero_compte`, `solde`, `client_id`) VALUES
(1, 'FR76300020001', 1500.50, 1),
(2, 'FR76300020002', 3200.00, 1),
(3, 'FR76300020003', 450.75, 2),
(4, 'FR76300020004', 12000.00, 3);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE IF NOT EXISTS `operation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `montant` decimal(10,2) NOT NULL,
  `date` datetime NOT NULL,
  `compte_source_id` int NOT NULL,
  `compte_destinataire_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_operation_source` (`compte_source_id`),
  KEY `fk_operation_dest` (`compte_destinataire_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`id`, `type`, `montant`, `date`, `compte_source_id`, `compte_destinataire_id`) VALUES
(1, 'Depot', 500.00, '2026-06-01 10:15:00', 1, NULL),
(2, 'Retrait', 100.00, '2026-06-02 14:30:00', 1, NULL),
(3, 'Virement', 200.00, '2026-06-03 09:00:00', 1, 2),
(4, 'Depot', 1000.00, '2026-06-04 11:20:00', 3, NULL),
(5, 'Virement', 1500.00, '2026-06-05 16:45:00', 4, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_compte_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `fk_operation_dest` FOREIGN KEY (`compte_destinataire_id`) REFERENCES `compte` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_operation_source` FOREIGN KEY (`compte_source_id`) REFERENCES `compte` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
