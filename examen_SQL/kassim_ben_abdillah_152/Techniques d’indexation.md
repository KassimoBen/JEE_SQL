Voici un résumé avec des exemples SQL pour comprendre les concepts des **INDEX en SQL** :

---

### **1. Qu’est-ce qu’un INDEX ?**
Un **index** est un objet utilisé pour accélérer l'accès aux données dans une table, en réduisant le temps de recherche.

---

### **2. Création d’un INDEX**
La syntaxe pour créer un index est la suivante :
```sql
CREATE INDEX index_name ON table_name(column_name);
```

**Exemple :**
```sql
CREATE INDEX user_id ON user(id);
```

---

### **3. Utilité d’un INDEX**
**Avant la création de l'index :**
```sql
SELECT * FROM user WHERE id = 1000;
-- Temps de réponse : 1760 ms
```

**Après la création de l'index :**
```sql
SELECT * FROM user WHERE id = 1000;
-- Temps de réponse : 27 ms
```

---

### **4. Inconvénients des INDEX**
Les index ralentissent les écritures comme **INSERT, UPDATE, DELETE** et consomment de la mémoire.

**Insertion sans index :**
```sql
CREATE TABLE test3 (id INTEGER PRIMARY KEY, valeur INTEGER);
INSERT INTO test3 (valeur) SELECT i FROM generate_series(1, 10000000) i;
-- Durée : 14,758 ms
```

**Insertion avec index :**
```sql
CREATE INDEX idx_test3_valeur ON test3(valeur);
INSERT INTO test3 (valeur) SELECT i FROM generate_series(1, 10000000) i;
-- Durée : 207,075 ms
```

---

### **5. Impact mémoire**
Les index consomment de l'espace disque :
```sql
SELECT pg_size_pretty(pg_relation_size('test2')) AS "Taille Table",
       pg_size_pretty(pg_indexes_size('test2')) AS "Taille Index";
```

---

### **6. Contraintes pratiques liées aux INDEX**
La création d'un index peut **bloquer temporairement les écritures**.

**Création bloquante :**
```sql
CREATE INDEX ON matable (macolonne);
```

**Création non-bloquante :**
```sql
CREATE INDEX CONCURRENTLY ON matable (macolonne);
```

---

### **7. Réindexation**
```sql
REINDEX INDEX pgbench_accounts_bid_idx; -- Un seul index
REINDEX TABLE pgbench_accounts;          -- Tous les index d'une table
REINDEX DATABASE pgbench;                -- Tous les index de la base
```

---

### **8. Types d’INDEX dans PostgreSQL**
- **B-tree** : Par défaut.
- **UNIQUE** : Garantit l'unicité.
- **Multicolonne, fonctionnel, partiel, couvrant**.
- **Index spécialisés** : Hash, GiST, GIN, BRIN.

---

### **9. Index multicolonne**
Les index peuvent inclure plusieurs colonnes :
```sql
CREATE INDEX ON ma_table (id, name);
```
**L'ordre des colonnes est important.**

---

### **10. Types de scans utilisant un index**
- **Index Scan**
- **Bitmap Index Scan**
- **Index Only Scan** (plus rapide)

---

### **11. Index fonctionnels**
Si une fonction est appliquée à une colonne, créez un index fonctionnel :
```sql
CREATE INDEX mon_idx ON ma_table (upper(a));
```

---

### **12. Index couvrants**
Un index couvrant inclut des colonnes supplémentaires pour optimiser les scans :
```sql
CREATE UNIQUE INDEX clients_idx1
ON clients (id_client) INCLUDE (nom_client);
```

---

### **13. Classes d’opérateurs**
Les index utilisent des classes spécifiques d'opérateurs, par exemple pour optimiser la recherche textuelle :
```sql
CREATE INDEX idx1
ON ma_table (col_varchar varchar_pattern_ops);
```