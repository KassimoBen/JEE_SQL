# **Vues et Index**  

## **Définition**  

Une **vue** est une table virtuelle issue du résultat d’une requête, qui est stockée sous un **nom spécifique**. Elle permet de simplifier des requêtes complexes, d’améliorer la confidentialité des données et de garantir l’intégrité d’une base de données.  

## **Pourquoi utiliser une Vue ?**
**Simplifier** des requêtes complexes et améliorer la lisibilité du code SQL

**Restreindre** l’accès aux données sensibles en affichant uniquement les colonnes nécessaires

**Faciliter** la maintenance des requêtes SQL en centralisant la logique

**Optimiser** l’accès aux données dans certaines situations

## **Création d’une Vue**  

```sql
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW <nom_de_vue> [(<liste_attributs>)]
AS <clause_select>
[WITH CHECK OPTION [CONSTRAINT <nom_de_contrainte>]]
[WITH READ ONLY];
```

### **Utilisation d’une Vue**  

```sql
SELECT * FROM <nom_de_vue> WHERE ...;
```

**Remarque :** Une vue peut être utilisée dans `SELECT, UPDATE, DELETE, INSERT, GRANT`, sous certaines conditions.

---

## **Exemples de Vues**  

### **Vue pour filtrer des données spécifiques**  

```sql
CREATE VIEW CritiquesLeMonde AS
SELECT * FROM Critique WHERE Source = 'Le Monde';
```

---

### **Vue pour simplifier une requête complexe**  

```sql
CREATE VIEW FilmCritique (NumFilm, Titre, NomRealisateur, NomCritique, Note) AS
SELECT F.NumFilm, F.Titre, I1.NomIndividu AS Realisateur, I2.NomIndividu AS Critique, C.Note
FROM Film F
JOIN Individu I1 ON F.NumRealisateur = I1.NumIndividu
JOIN Critique C ON C.NumFilm = F.NumFilm
JOIN Individu I2 ON C.NumIndividu = I2.NumIndividu;
```

---

### **Vue pour restreindre l’accès aux données sensibles**  

```sql
CREATE VIEW IndividuPublic AS
SELECT NumIndividu, NomIndividu, PrenomIndividu
FROM Individu;
```

---

### **Vue pour assurer l’intégrité des données**  

```sql
CREATE VIEW CritiqueSansAvis AS
SELECT * FROM Critique
WHERE Texte IS NULL;
```

#### **Mise à jour à travers la Vue**  

```sql
UPDATE CritiqueSansAvis
SET Texte = 'Sans intérêt'
WHERE Note = 0;
```

---

## **Suppression et Renommage d’une Vue**  

```sql
DROP VIEW <nom_de_vue>;
RENAME <ancien_nom_de_vue> TO <nouveau_nom_de_vue>;
```

---

# **Les Index en SQL**  

## **Pourquoi utiliser un index ?**  

**Accélère** les performances des requêtes sur de grandes tables  
**Améliore** l’efficacité des recherches avec `WHERE`, `ORDER BY`, et `JOIN`  
**Assure** l’unicité des enregistrements (exemple : clé primaire)  

---

## **Création d’un Index**  

```sql
CREATE [UNIQUE | BITMAP] INDEX [<schema>.]<nom_index>
ON <nom_de_table> (<nom_de_colonne> [ASC | DESC], ...);
```

### **Exemple : Index classique pour accélérer les recherches**  

```sql
CREATE INDEX IndNomIndividu
ON Individu(NomIndividu);
```

---

### **Index pour optimiser les recherches par clé étrangère**  

```sql
CREATE INDEX IndCritiqueFilm
ON Critique(NumFilm);
```

---

### **Index Unique pour assurer l’unicité d’une colonne**  

```sql
CREATE UNIQUE INDEX IndNumIndividu
ON Individu(NumIndividu);
```

---

## **Types d’Index dans Oracle**  

- **B-tree (B-arbre)** : Arbre équilibré où chaque branche a la même profondeur  
- **Bitmap** : Utilisé pour les colonnes avec peu de valeurs distinctes  

### **Exemple d’Index en B-arbre**  

```sql
CREATE INDEX IndFilmTitre ON Film(Titre);
```

---

### **Exemple d’Index en Bitmap**  

```sql
CREATE BITMAP INDEX IndClasse ON Eleve(numClasse);
```

---