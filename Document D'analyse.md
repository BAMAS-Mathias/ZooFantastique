# Document d'Analyse Zoo Fantastique

## Sommaire

- [Etude de cas](#etude-de-cas)
- [Bilan technique](#bilan-technique)
- [Problèmes rencontrés](#problemes-rencontres)
- [Synthèse](#synthese)

---

## Etude de cas

### 1. Introduction

L'objectif de cette étude de cas est de concevoir et développer une application de simulation de zoo fantastique en Java. Le zoo fantastique doit permettre la gestion de différentes créatures, enclos et être dirigé par un maître de zoo fantastique. L'application doit également modéliser l'aspect temporel de la gestion du zoo avec plusieurs actions au sein du zoo.

### 2. Analyse des Besoins

#### Créatures
Représentent différentes espèces telles que lycanthropes, licornes, nymphes, krakens, sirènes, mégalodons, phénix et dragons.
Chaque créature a des caractéristiques communes : nom, sexe, poids, taille, âge, faim, sommeil, santé.
Des actions spécifiques à chaque type de créature, comme courir, nager ou voler.

#### Enclos
Contiennent des créatures du même type.
Caractéristiques : nom, superficie, capacité maximale, propreté.
Enclos spécifiques : volières et aquariums, avec des attributs supplémentaires.

#### Maître de Zoo Fantastique
Gère les enclos, nourrit les créatures, nettoie les enclos, transfère les créatures.
Limitation des actions par intervalle de temps.

#### Zoo Fantastique
Possède un nom, un Maître de Zoo Fantastique, un nombre maximal d'enclos.
Doit afficher le nombre total de créatures et les créatures de tous les enclos.
Gestion temporelle pour les changements d'état aléatoires.

### 3. Conception

#### Classes Principales
- Créature : Modèle de base pour toutes les créatures.
- Classes spécifiques pour chaque type de créature (Licorne, Lycanthrope, etc.).
- Enclos : Modélise les enclos, gère les créatures à l'intérieur.
- Classes spécifiques pour les types d'enclos (Volière, Aquarium).
- MaitreZooFantastique : Représente le Maître de Zoo Fantastique.
- ZooFantastique : Classe principale du zoo, gère l'ensemble du système.

### 4. Diagramme de Classes
 ![image de notre UML](Zoofantastique.jpg)

### 5. Implémentation TD4

Après avoir implémenté tout le TD3 qui était de mettre en place un ZooFantastique avec les enclos et les animaux dans celui-ci. Nous allons mettre en place le TD4 qui consiste à prendre le ZooFantastique et mettre une colonie de lycanthropes avec plusieurs aspects.

---

## Bilan Technique

*Votre bilan technique ici, avec des sections sur les choix technologiques, les performances, les problèmes rencontrés, les solutions apportées, etc.*

---

## Problèmes rencontrés

*Liste des principaux problèmes rencontrés pendant le développement, avec les correctifs et les solutions apportées.*

---

## Synthèse

*Une synthèse des points clés abordés dans ce document d'analyse, mettant en évidence les aspects importants de la conception et de l'implémentation de votre Zoo Fantastique.*


