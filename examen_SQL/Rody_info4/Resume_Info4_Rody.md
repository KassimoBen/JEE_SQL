# Vues et Index : Généralités

- Le cours porte sur les vues et les index dans les bases de données.

- Les vues permettent de simplifier les requêtes complexes et de gérer la confidentialité.

- Les index servent à accélérer l'accès aux données et à vérifier l'unicité.

## Les Vues

- Une vue est une table virtuelle résultant d'une requête nommée.

- La syntaxe de création d'une vue utilise l'instruction CREATE VIEW.

- Les vues peuvent simplifier des requêtes, résoudre des problèmes de confidentialité et garantir l'intégrité.

Création, Suppression et Renommage des Vues

- Les vues sont créées avec CREATE VIEW, supprimées avec DROP VIEW et renommées avec RENAME.

- Une vue peut être créée en utilisant CREATE VIEW suivie d'une clause SELECT.

- La suppression d'une vue ne supprime pas les données sous-jacentes.

Utilisation des Vues

- Les vues peuvent être utilisées pour simplifier des requêtes complexes, comme obtenir facilement les critiques d'un film.

- Elles permettent d'assurer la confidentialité en donnant accès à une partie seulement des informations.

- Elles peuvent servir à assurer des contraintes d'intégrité, par exemple, éviter les critiques "vides".

Mise à Jour des Vues

- La mise à jour (UPDATE, DELETE, INSERT) est possible si la ligne de la table originale peut être retrouvée.

- Les vues ne doivent pas contenir d'opérateurs ensemblistes, DISTINCT, fonctions d'agrégation, GROUP BY, ORDER BY ou jointures (sauf cas particulier Oracle).

- En Oracle, les jointures sont possibles si la clé est préservée dans la table résultante.

Index : Généralités

- Les index sont utilisés pour vérifier l'unicité (clés) et accélérer l'accès aux lignes d'une table.

- Ils sont créés automatiquement (implicites) pour les contraintes d'unicité et manuellement (explicites) pour d'autres attributs.

- L'utilisation des index doit être faite avec vigilance car ils prennent de l'espace disque.

Syntaxe et Organisation des Index

- La syntaxe de création d'un index utilise l'instruction CREATE INDEX.

- Il existe deux types d'index dans Oracle : les arbres équilibrés (B-arbre) et les index Bitmap.

- Les index B-arbre sont préférables lorsque les attributs ont beaucoup de valeurs distinctes, tandis que les index Bitmap conviennent aux attributs avec peu de valeurs possibles.

Exemples d'Index

- Un exemple d'index B-arbre montre comment les clés sont organisées pour un accès rapide.

- Un exemple d'index Bitmap illustre comment une chaîne de bits est utilisée pour représenter les valeurs d'un attribut.

- Une table organisée en index maintient ses données triées sur la clé primaire.

Quand Créer ou Ne Pas Créer un Index

- Créer un index pour les attributs utilisés dans les jointures ou les sélections fréquentes, surtout dans les tables volumineuses.

- Ne pas créer d'index pour les attributs souvent modifiés, les tables de petit volume, ou les requêtes sur NULL.

- Oracle peut utiliser un index même si la clause WHERE fait appel à une fonction, contrairement à SQL standard.