# Spécifications Fonctionnelles
# Projet : TP Bank - Conception du noyau d’une banque en ligne

## 1. Présentation du projet

TP Bank est une banque en ligne dont le système d'information est en phase de conception.

L’objectif est de développer le noyau applicatif permettant de gérer :

- Les clients
- Les comptes bancaires
- Les opérations bancaires

Toutes les données doivent être stockées dans une base de données MySQL et accessibles via une architecture logicielle fiable, maintenable et extensible.

Le système doit permettre l'ajout futur de nouvelles fonctionnalités telles que :

- Application mobile
- API Web
- Nouveaux types de comptes
- Nouveaux produits bancaires

---

# 2. Gestion des clients

## SF-01 : Consulter la liste des clients

Le système doit permettre d'afficher la liste de tous les clients enregistrés.

### Informations affichées

- Identifiant client
- Nom
- Prénom
- Adresse e-mail

---

## SF-02 : Consulter les informations d'un client

Le système doit permettre de consulter les informations détaillées d'un client à partir de son identifiant.

---

## SF-03 : Consulter les comptes d'un client

Le système doit permettre d'afficher tous les comptes associés à un client.

---

# 3. Gestion des comptes bancaires

## SF-04 : Gestion de plusieurs types de comptes

Le système doit gérer au minimum les types de comptes suivants :

- Compte Courant
- Compte Épargne
D
---

## SF-05 : Création manuelle des comptes

L'utilisateur doit pouvoir créer automatiquement le type de compte.

---

## SF-05bis : Création dynamique des comptes

Le système doit être capable de créer automatiquement le type de compte approprié en fonction des informations stockées dans la base de données.

L'ajout d'un nouveau type de compte doit pouvoir être réalisé avec un impact minimal sur les autres composants de l'application.

---

## SF-06 : Consultation d'un compte

Le système doit permettre d'obtenir les informations suivantes :

- Numéro de compte
- Type de compte
- Solde actuel
- Titulaire du compte

---

## SF-07 : Vérification de l'existence d'un compte

Avant toute opération bancaire, le système doit vérifier que le compte existe.

Si le compte n'existe pas, une erreur doit être générée.

---

# 4. Gestion des opérations bancaires

## SF-08 : Effectuer un dépôt

Le système doit permettre :

- La sélection d'un compte
- La saisie d'un montant
- La mise à jour du solde

### Résultat attendu

Le montant déposé est ajouté au solde du compte.

---

## SF-09 : Enregistrement d'un dépôt

Après chaque dépôt :

- Une opération de type DEPOT doit être enregistrée dans l'historique.

---

## SF-10 : Effectuer un retrait

Le système doit permettre :

- La sélection d'un compte
- La saisie d'un montant
- La mise à jour du solde

### Résultat attendu

Le montant retiré est déduit du solde du compte.

---

## SF-11 : Vérification du solde avant retrait

Le système doit vérifier que le solde disponible est suffisant pour effectuer le retrait.

---

## SF-12 : Refus d'un retrait non autorisé

Si le solde est insuffisant :

- Le retrait doit être refusé
- Le solde doit rester inchangé
- Un message d'erreur doit être retourné

---

## SF-13 : Enregistrement d'un retrait

Après chaque retrait :

- Une opération de type RETRAIT doit être enregistrée dans l'historique.

---

# 5. Historique des opérations

## SF-14 : Conservation de l'historique

Le système doit conserver l'historique complet des opérations bancaires.

Les opérations concernées sont :

- Dépôts
- Retraits

---

## SF-15 : Consultation de l'historique

Le système doit permettre de consulter l'historique d'un compte.

### Informations affichées

- Identifiant de l'opération
- Type d'opération
- Montant
- Date de l'opération
- Compte concerné

---

# 6. Gestion des données

## SF-16 : Stockage des données

Le système doit stocker dans la base de données MySQL :

- Les clients
- Les comptes
- Les opérations bancaires

---

## SF-17 : Consultation des données

Le système doit permettre la lecture des données enregistrées dans la base.

---

## SF-18 : Mise à jour des données

Le système doit permettre :

- La mise à jour des soldes
- L'enregistrement des opérations
- La consultation des informations historiques

---

# 7. Gestion des règles métier

## SF-19 : Centralisation des règles métier

Toutes les règles bancaires doivent être regroupées dans une couche métier dédiée.

Les règles ne doivent pas être implémentées :

- Dans l'interface utilisateur
- Dans les classes d'accès aux données

---

## SF-20 : Respect du processus métier

Toute opération bancaire doit :

1. Vérifier les règles métier
2. Modifier le solde du compte
3. Enregistrer l'opération dans l'historique

---

## SF-21 : Cohérence des opérations

Le système doit garantir qu'une opération bancaire soit entièrement exécutée ou entièrement annulée en cas d'erreur.

---

# 8. Gestion des erreurs

## SF-22 : Compte introuvable

Le système doit signaler toute tentative d'accès à un compte inexistant.

---

## SF-23 : Solde insuffisant

Le système doit signaler toute tentative de retrait dont le montant dépasse le solde disponible.

---

## SF-24 : Erreurs d'accès aux données

Le système doit gérer les erreurs de connexion ou d'accès à la base de données.

---

# 9. Interface Console

Afin de valider le fonctionnement du noyau métier, une interface console doit être développée.

---

## SF-25 : Affichage d'un menu principal

L'application doit afficher un menu permettant d'accéder aux principales fonctionnalités.

---

## SF-26 : Affichage de la liste des clients

L'utilisateur doit pouvoir afficher tous les clients enregistrés.

---

## SF-27 : Affichage des comptes d'un client

L'utilisateur doit pouvoir consulter les comptes associés à un client.

---

## SF-28 : Réalisation d'un dépôt

L'utilisateur doit pouvoir saisir :

- Un numéro de compte
- Un montant

Puis exécuter un dépôt.

---

## SF-29 : Réalisation d'un retrait

L'utilisateur doit pouvoir saisir :

- Un numéro de compte
- Un montant

Puis exécuter un retrait.

---

## SF-30 : Consultation de l'historique

L'utilisateur doit pouvoir consulter l'ensemble des opérations réalisées sur un compte.

---

# 10. Exigences techniques

## ST-01 : Base de données

Le système doit utiliser MySQL comme système de gestion de base de données.

---

## ST-02 : Gestion centralisée des connexions

L'accès à la base de données doit être centralisé afin d'éviter la multiplication des connexions.

---

## ST-03 : Création centralisée des comptes

La création des comptes doit être centralisée dans un composant dédié.

---

## ST-04 : Séparation de l'accès aux données

Le système doit isoler :

- Les requêtes SQL
- La persistance des données
- La logique métier

---

## ST-05 : Couche métier dédiée

Les règles bancaires doivent être regroupées dans une couche spécifique responsable du comportement fonctionnel du système.

---

## ST-06 : Architecture modulaire

Le système doit permettre l'ajout futur de nouveaux types de comptes ou de nouvelles fonctionnalités sans modification majeure de l'existant.

---

# 11. Design Patterns attendus

## Singleton

Objectif :
Garantir une instance unique de la connexion à la base de données.

---

## Factory Method / Factory

Objectif :
Créer dynamiquement les différents types de comptes bancaires.

---

## DAO (Data Access Object)

Objectif :
Isoler les accès à la base de données du reste de l'application.

---

## Service Layer

Objectif :
Centraliser les règles métier de la banque.

---

## Architecture MVC simplifiée

Séparation entre :

- Interface Console
- Logique Métier
- Accès aux Données

---

# 12. Livrables attendus

Le projet devra fournir :

## Diagramme UML

Diagramme des principales classes du système.

### Classes principales attendues

- Client
- Compte
- CompteCourant
- CompteEpargne
- Operation
- DatabaseConnection
- CompteFactory
- ClientDAO
- CompteDAO
- OperationDAO
- BanqueService

---

## Code source Java complet

L'application doit être développée en Java orienté objet.

---

## Script SQL

Le projet devra fournir un script SQL permettant :

- La création de la base de données
- La création des tables
- L'insertion éventuelle de données de test