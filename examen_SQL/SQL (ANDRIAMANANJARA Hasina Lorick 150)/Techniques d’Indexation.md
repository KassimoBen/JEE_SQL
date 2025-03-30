# Techniques d’Indexation - Module J4

##  Introduction
Les index sont des structures utilisées pour **accélérer l’accès aux données** dans PostgreSQL. Ils permettent d’éviter un parcours séquentiel des tables et améliorent la performance des requêtes **SELECT**. Leur gestion repose sur le **développeur** et le **DBA**, qui doivent les adapter aux besoins des requêtes.

---

##  Objectifs
- Comprendre **le rôle et l’importance des index**.
- Savoir **créer et maintenir** un index dans PostgreSQL.
- Découvrir **les différents types d’index** et leurs usages spécifiques.

---

##  1. Introduction aux Index
###  Pourquoi utiliser un index ?
Un index permet :
- **D’accélérer l’accès aux données** en évitant un scan séquentiel de la table.
- **D’optimiser les tris et les agrégats** (GROUP BY, ORDER BY).
- **D’améliorer les performances des jointures**.
- **D’éviter des lectures inutiles** grâce aux Index Only Scan.

###  Inconvénients des index
- **Ralentissent les opérations d’écriture** (INSERT, UPDATE, DELETE).
- **Consomment de l’espace disque**.
- **Nécessitent une maintenance** (VACUUM, REINDEX).

---

##  2. Fonctionnement d’un Index
###  Structure d’un index
Un index associe **des clés (valeurs indexées) à des localisations physiques (ctid)**. Il est **séparé de la table** et fonctionne comme un index de livre.

###  Types d’index dans PostgreSQL
- **B-tree (par défaut)** : rapide pour les comparaisons `=`, `<`, `>`.
- **Hash** : optimisé pour les recherches exactes (`=`).
- **GiST** : adapté aux données géospatiales et textuelles.
- **GIN** : efficace pour les tableaux et documents JSON.
- **BRIN** : conçu pour les très grandes tables avec données ordonnées.

###  Index et Requêtes SQL
Un index est efficace pour :
- **Les recherches conditionnelles** (`WHERE champ = valeur`).
- **Les tris (`ORDER BY`) et agrégations (`GROUP BY`)**.
- **Les jointures entre tables**.

Mais il peut être inutilisé si :
- **L’optimiseur PostgreSQL juge son coût trop élevé**.
- **Les statistiques ne sont pas à jour (`ANALYZE`)**.
- **La requête utilise une fonction sur la colonne indexée**.

---

##  3. Création et Optimisation des Index
###  ***Création d’un Index***
```sql
CREATE INDEX idx_nom ON table (colonne);

```
- Bloque les écritures pendant la création.
- Solution : CREATE INDEX CONCURRENTLY pour éviter ce blocage.

### ***Réindexation et Maintenance***

- ***Réindexer un index fragmenté*** :
```sql
REINDEX INDEX idx_nom;
```
- ***Analyser l’utilisation des index*** :
```sql
SELECT * FROM pg_stat_user_indexes WHERE idx_scan = 0;
```
### Bonnes pratiques
- Indexer uniquement les colonnes utiles pour les requêtes fréquentes.
- Ne pas créer trop d’index pour éviter de ralentir les écritures.
- Surveiller l’usage des index avec ***pg_stat_user_indexes***.


#  4. Index Avancés

##  Index Multicolonnes
- Permet d’indexer **plusieurs colonnes** en même temps.
- **L’ordre des colonnes est crucial** :
  ```sql
  CREATE INDEX idx_multicol ON table (col1, col2);
 ```
##  Index Partiels  
- **Indexe seulement une partie des données** pour optimiser l’espace et les performances.  
- Utilisé pour des **requêtes fréquentes sur un sous-ensemble** :  

```sql
CREATE INDEX idx_partiel ON table (colonne) WHERE condition;
```
##  Index Fonctionnels
- Permet d’indexer **une expression ou une fonction** appliquée à une ou plusieurs colonnes d’une table.
- Exemple de création d’un index fonctionnel :
  ```sql
  CREATE INDEX idx_lower ON table (LOWER(colonne));
```
##  Index Couvrants
- Stocke **toutes les colonnes nécessaires** pour éviter d’accéder à la table.
- **Optimisé pour les Index Only Scan** :
  ```sql
  CREATE INDEX idx_couvrant ON table (colonne1, colonne2) INCLUDE (colonne3);
```
##  Bloque les écritures pendant la création.
**Solution** : `CREATE INDEX CONCURRENTLY` pour éviter ce blocage.

---

##  Réindexation et Maintenance

### Réindexer un index fragmenté :
```sql
REINDEX INDEX idx_nom;
```
Analyser l’utilisation des index :
```sql
SELECT * FROM pg_stat_user_indexes WHERE idx_scan = 0;
```

##  Bonnes pratiques
-  **Indexer uniquement les colonnes utiles pour les requêtes fréquentes.**
-  **Ne pas créer trop d’index** pour éviter de ralentir les écritures.
-  **Surveiller l’usage des index** avec `pg_stat_user_indexes`.

##  Conclusion
- **Choisir le bon type d’index** en fonction des requêtes.
- **Éviter la surcharge** avec trop d’index inutilisés.
- **Surveiller l’efficacité des index** avec `pg_stat_user_indexes`.
