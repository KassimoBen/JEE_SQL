#  Vues et Index (Bases de Données)

---

## 1.  Les Vues

###  1.1. Définition d’une Vue
Une **vue** est une **table virtuelle** résultant d'une requête SQL stockée sous un nom.  
Elle ne contient pas physiquement les données, mais affiche les résultats d’une requête.

###  **Objectifs des vues :**
- **Simplifier** des requêtes complexes.  
- **Protéger** la confidentialité en limitant l’accès aux données sensibles.  
- **Garantir** l’intégrité des données (ex : empêcher les saisies invalides).  
- **Améliorer** l’indépendance logique entre les utilisateurs et les tables physiques.  

---

### 1.2. Création d’une Vue

**Syntaxe :**
```sql
CREATE [OR REPLACE] [FORCE | NO FORCE] VIEW nom_vue [(attributs)] AS
<requête SELECT>
[WITH CHECK OPTION [CONSTRAINT nom_contrainte]] [WITH READ ONLY];


```
### Options :

- **OR REPLACE** : Remplace une vue existante.  
- **FORCE** : Crée la vue même si la table n''existe pas encore.  
- **WITH CHECK OPTION** : Empêche de modifier la vue en dehors de ses conditions.  
- **WITH READ ONLY** : Rend la vue non modifiable.  


 **Exemple :** Créer une vue affichant les critiques du journal Le Monde :

```sql
CREATE VIEW CritiquesLeMonde AS
SELECT * FROM Critique WHERE Source = 'Le Monde';
```

###  1.3. Utilisation d’une Vue  
Une **vue** peut être utilisée dans les commandes SQL comme une table classique :

- **SELECT** : Lire les données.  
- **UPDATE** : Modifier les données (si autorisé).  
- **DELETE** : Supprimer des lignes.  
- **INSERT** : Ajouter de nouvelles données.  

 **Exemple :** Afficher les critiques de Rohmer :  

```sql
SELECT NumFilm, Titre, NomCrit, Note
FROM FilmCritique
WHERE NomReal = 'ROHMER';

````

 ###  1.4. Suppression et Renommage d’une Vue

####  Suppression d''une Vue

Pour supprimer une vue, utilisez la commande suivante :

```sql
DROP VIEW nom_vue;
````
###  1.5. Conditions de Mise à Jour d’une Vue

Les commandes `UPDATE`, `DELETE` et `INSERT` sont possibles si :

- **La vue ne contient pas :**
  - Des opérateurs ensemblistes (`UNION`, `INTERSECT`, `EXCEPT`).
  - Des agrégats (`SUM`, `COUNT`, etc.).
  - `DISTINCT`, `GROUP BY`, `ORDER BY`.
  - Une jointure complexe (sauf si la clé est préservée).

**Exemple : Vue modifiable :**

```sql
CREATE OR REPLACE VIEW VueFilmsComplets AS
SELECT numFilm, titre, NumIndividu AS NumRealisateur
FROM Film, Individu
WHERE Realisateur = numIndividu;
```
 ## 2.  Les Index

###  2.1. Définition d’un Index

Un **index** est une **structure de données** associée à une table dans une base de données, conçue pour accélérer les opérations de recherche en permettant un accès rapide aux données. :contentReference[oaicite:0]{index=0}



###  2.2. Pourquoi utiliser un index ?

- **Accélérer l'accès aux lignes d'une table.**
- **Garantir l’unicité des valeurs** (par exemple, pour les clés primaires).
- **Optimiser les jointures** sur de grandes tables.

**Inconvénients :**

- **Consommation d'espace disque.**
- **Ralentissement des opérations d'insertion et de mise à jour.**

###  2.3. Types d’Index

- **Index B-Tree :** Structure hiérarchique équilibrée, adaptée aux colonnes avec de nombreuses valeurs distinctes.
  - *Exemple :* Nom d’utilisateur.
- **Index Bitmap :** Représentation sous forme de bits (0 ou 1), adaptée aux colonnes avec peu de valeurs distinctes.
  - *Exemple :* Sexe (M/F), statut (Actif/Inactif).

###  2.4. Création d’un Index

**Syntaxe :**

```sql
CREATE [UNIQUE | BITMAP] INDEX nom_index
ON nom_table (colonne [ASC | DESC]);
```

###  2.6. Conditions pour Créer un Index

**Créer un index si :**

- **Jointures fréquentes :** Les colonnes sont utilisées dans des jointures régulières.
- **Tables volumineuses :** La table est grande et les requêtes ciblent moins de 15 % des lignes.
- **Valeurs uniques ou peu variées :** L’attribut a beaucoup de valeurs uniques (index B-Tree) ou peu de valeurs distinctes (index Bitmap).

**Ne pas créer d’index si :**

- **Modifications fréquentes :** Les colonnes sont sujettes à des modifications fréquentes.
- **Tables petites :** La table est de petite taille, rendant l''indexation inutile.
- **Valeurs NULL :** Les recherches concernent des valeurs NULL, qui ne sont pas indexées.

### 2.7. Exemple : Index sur une Fonction

Certaines bases de données, comme Oracle, permettent d’indexer des fonctions.

**Exemple : Créer un index insensible à la casse :**

```sql
CREATE INDEX individuNomMajuscule
ON Individu (UPPER(nomIndividu));
