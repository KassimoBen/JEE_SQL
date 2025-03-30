# I. Vues et Index

## 1. Les Vues : Définition et Intérêt

### 1.1. Définition
Une vue est une table virtuelle, résultat d'une requête à laquelle on a donné un nom.


### 1.2. Les vues permettent de :
- Simplifier des requêtes complexes
- Résoudre des problèmes de confidentialité
- Garantir l'intégrité d'une base
### 1.3. Création
```sql
CREATE [OR REPLACE] [FORCE|NO FORCE] VIEW <nom_de_vue> [<liste_attributs>] AS <clause_select> [WITH CHECK OPTION [CONSTRAINT <nom_de_contrainte>]] [WITH READ ONLY]
```
#### Utilisation
```sql
SELECT ... FROM <nom de vue> WHERE ...
```
#### Exemple
```sql
CREATE VIEW CritiquesLeMonde AS SELECT * FROM Critique WHERE Source='Le Monde';
```
### 1.4. Suppression, renommage
```sql
DROP VIEW <nom_de_vue>;
RENAME <ancien_nom_de_vue> TO <nouveau_nom_de_vue>;
```
#### Remarque:
- Suppression d’une vue mais pas suppression des donnees
- Pour connaitre les vues, on peut les retrouver dans les tables
systeme : ALL-CATALOG, USER VIEWS et ALL VIEWS
### 1.5. Avantages des vues
- Simplifier des requêtes complexes
(avoir facilement, pour un film, les critiques “en clair”)
```sql
CREATE VIEW FilmCritique (NumFilm, Titre, NomReal,
NomCrit, Note) AS
SELECT F.NumFilm, Titre, I1.NomIndividu,
I2.NomIndividu, Note FROM Film F, Individu I1; Individu I2, Critique C WHERE C.NumFilm = F.NumFilm AND C.NumIndividu = I2 NumIndividu AND F.NumRealisateur = I1.NumIndividu;
```
- Assurer la confidentialité(permet de ne donner acces qu’a une partie des informations)
```sql
CREATE VIEW IndividuPublic
SELECT NumIndividu, NomIndividu, PrenomIndividu FROM INDIVIDU;
```
- Assurer des contraintes d'intégrité(eviter les critiques “vides”)
```sql
CREATE VIEW CritiqueSansAvis AS SELECT * FROM Critique WHERE Texte IS NULL
```
Mise a jour :
```sql
UPDATE CritiqueSansAvis SET Texte='Sans interet' WHERE Note = 0
```
- Augmenter l'indépendance logique(Impossible si :)
```sql
CREATE VIEW CritiqueSansAvis AS SELECT * FROM Critique WHERE Texte IS NULL WITH CHECK OPTION CONSTRAINT CO CRIT SA
```
l’erreur CO CRIT SA sera alors declenchee
### 1.6.Conditions generales de mise a jour
#### UPDATE, DELETE, INSERT possibles si :
La vue ne contient pas:
- Un operateur ensembliste (UNION, EXCEPT, INTERSECT)
- Un operateur DISTINCT
- Une fonction d’aggregation comme attribut
- Une clause GROUP BY, ORDER BY ou CONNECT BY
- Une jointure (vue construite sur une seule table) 

## 2. Index : Généralités

### 2.1. Index est utilise pour:
- Vérifier des contraintes d'unicité (index implicites)
- Accéder plus vite aux lignes d'une table (index explicites)

#### Création d'un index
```sql
CREATE [UNIQUE | BITMAP] INDEX [<schema>.]<nom_index> ON <nom_de_table> (<nom_de_colonne> [ASC|DESC], ...)
```
Exemple :
```sql
CREATE INDEX IndNomIndividu ON Individu(nomIndividu);
```
### 2.2. Organisation de l'index
- B-arbres
- Bitmap
### 2.3. Table organisee en index
#### Definition
Une table organisee en index maintient ses donnees triees sur la cle primaire. Uniquement si la cle primaire constitue l’essentiel des attributs.
#### Creation d’une table index
```sql
CREATE TABLE estActeurType
numInd...
numFilm...
type CHAR CHECK type IN (’C’, ’T’, ’S’, ’P’)
CONSTRAINT PKEAT PRIMARY KEY (numInd, numFilm)
ORGANIZATION INDEX
```
### 2.4. Quand créer un index
- Attributs utilisés dans des jointures
- Attributs servant souvent pour les sélections
- Table de gros volume (sélectionne - de 15% des lignes)

### 2.5. Quand ne pas créer un index
- Attributs souvent modifiés
- Table de petit volume
- Requêtes sur NULL
#### Exemple
La requˆete suivante peut utiliser l’index ci-dessous en Oracle,mais pas en SQL standard :
```sql
SELECT * FROM Individu WHERE UPPER(nomIndividu)='SPIELBERG' CREATE INDEX individuNomMajuscule ON Individu (UPPER(nomIndividu))
```
# II. Index
## 1. Création d’un index sur une colonne
```sql
CREATE INDEX idx_test_id ON test (id) ;
```
### Accélère les requêtes filtrant sur id
#### Exemple
```sql 
SELECT * FROM test WHERE id = 10000 ;
```
Sans index, la requête fait un Seq Scan (lecture séquentielle de la table), ce qui est lent. Avec l’index, elle utilise un Index Scan, beaucoup plus rapide
## 2. Création d’un index en mode concurrent (sans bloquer les écritures)
```sql
CREATE INDEX CONCURRENTLY ON matable (macolonne) ;
```
Le mot-clé CONCURRENTLY permet de ne pas bloquer les transactions en cours, mais il peut échouer si d’autres écritures se produisent en parallèle




## 3. Réindexation d’un index existant (en cas de fragmentation)
```sql
REINDEX INDEX nomindex ;
REINDEX TABLE CONCURRENTLY nomtable ;
```
La fragmentation des index peut ralentir les performances. REINDEX reconstruit l’index pour optimiser l’accès aux données


## 4. Création d’un index UNIQUE
```sql
CREATE UNIQUE INDEX ON personne (id) ;
 ```
Empêche l’insertion de doublons sur id, mais il est préférable d’utiliser une contrainte d’unicité :

```sql
ALTER TABLE personne ADD CONSTRAINT unique_id UNIQUE (id) ;
```
Cette contrainte garantit l’unicité et empêche la suppression accidentelle de l’index.


## 5. Création d’un index multicolonne
```sql
CREATE INDEX ON ma_table (id, name) ;
```
Utile pour les requêtes filtrant d’abord sur id, puis sur name. L’ordre des colonnes est important :
```sql
WHERE id = … AND name = … → optimal
WHERE name = … → sous-optimal ou inutilisable
```


## 6. Création d’un index partiel (indexe seulement une partie des données)
```sql
CREATE INDEX idx_actifs ON users (status) WHERE status = ‘actif’ ;
```
Optimise les requêtes filtrant majoritairement sur status = ‘actif’, tout en réduisant la taille de l’index.


## 7. Création d’un index fonctionnel
```sql 
CREATE INDEX idx_lower_nom ON clients (LOWER(nom)) ;
```

Permet d’accélérer les recherches insensibles à la casse :
```sql
SELECT * FROM clients WHERE LOWER(nom) = ‘dupont’ ;
```

## 8. Création d’un index couvrant (contient plus de colonnes que nécessaire)
```sql
CREATE INDEX idx_couvrant ON commandes (id_client) INCLUDE (total, date) ;
```
PostgreSQL peut exécuter une requête sans accéder à la table si toutes les colonnes demandées sont dans l’index :
```sql
SELECT id_client, total FROM commandes WHERE id_client = 42 ;
```
Utilise un Index Only Scan pour éviter la lecture de la table entière.

## 9. Détection des index invalides
```sql 
SELECT indexrelid ::regclass AS index, indrelid ::regclass AS table
FROM pg_index WHERE indisvalid = false ;
```
Cette requête liste les index corrompus ou inutilisables, qui doivent être supprimés ou reconstruits avec REINDEX



## 10. Augmenter la mémoire pour accélérer la création d’index
```sql
SET maintenance_work_mem = ‘2GB’ ;
```
Permet d’éviter l’utilisation excessive de fichiers temporaires lors de la création d’un gros index


## 11. Vérification de l’utilisation d’un index
```sql
EXPLAIN (ANALYZE, BUFFERS)
SELECT * FROM commandes WHERE date_commande >= ‘2024-01-01’ ;
```
EXPLAIN ANALYZE montre si PostgreSQL utilise l’index ou fait un Seq Scan. Si l’index n’est pas utilisé, il faut vérifier :

-	Les statistiques (ANALYZE)
-	La sélectivité (si trop de lignes sont retournées, PostgreSQL préférera un Seq Scan)
-	Les types de données (un mauvais CAST peut empêcher l’utilisation de l’index)


## 12. Optimisation d’une recherche avec LIKE
```sql
CREATE INDEX idx_nom_gin ON clients USING GIN (nom gin_trgm_ops) ;
```
Un index B-tree ne fonctionne pas avec LIKE ‘…%’. Un index GIN avec trigrams améliore les performances des recherches textuelles

