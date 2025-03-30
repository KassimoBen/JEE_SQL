##Les Vues : Définition et Intérêt##Voici votre document converti en Markdown avec du style pour une meilleure lisibilité :  

# Cours Bases de Données - 2ᵍᵀᴹ Année IUT

## 📖 Cours 1 : Vues et Index

👩‍🏫 **Anne Vilnat**  
🔗 [Cours en ligne](http://www.limsi.fr/Individu/anne/cours)

---

## Plan

1. **Les Vues**
   - 🔹 Généralités
   - 🔹 Syntaxe
   - 🔹 Avantages
   - 🔹 Conditions de mise à jour
2. **Index**
   - 🔹 Généralités
   - 🔹 Syntaxe
   - 🔹 Organisation

---

## 🔎 Définition

Une **vue** est une table virtuelle, résultat d’une requête à laquelle on a donné un **nom**.

### Pourquoi utiliser une Vue ?

**Simplifie** des requêtes complexes  
**Améliore** la confidentialité des données  
 **Garantit** l’intégrité d’une base  

---

## Création d’une Vue

```sql
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW <nom_de_vue> [(<liste_attributs>)]
AS <clause_select>
[WITH CHECK OPTION [CONSTRAINT <nom_de_contrainte>]]
[WITH READ ONLY];

###  Utilisation

```sql
SELECT ... FROM <nom_de_vue> WHERE ...
```

**Remarque :** Une vue peut être utilisée dans `SELECT, UPDATE, DELETE, INSERT, GRANT`.

### Exemple

```sql
CREATE VIEW CritiquesLeMonde AS
SELECT * FROM Critique WHERE Source='Le Monde';
```

### Suppression et Renommage

```sql
DROP VIEW <nom_de_vue>;
RENAME <ancien_nom_de_vue> TO <nouveau_nom_de_vue>;
```

 **Remarque :** Supprimer une vue ne supprime pas les données.

### Exemple : Vue pour simplifier une requête complexe

```sql
CREATE VIEW FilmCritique (NumFilm, Titre, NomReal, NomCrit, Note) AS
SELECT F.NumFilm, Titre, I1.NomIndividu, I2.NomIndividu, Note
FROM Film F, Individu I1, Individu I2, Critique C
WHERE C.NumFilm = F.NumFilm
AND C.NumIndividu = I2.NumIndividu
AND F.NumRealisateur = I1.NumIndividu;
```

### Vue pour assurer la confidentialité

```sql
CREATE VIEW IndividuPublic AS
SELECT NumIndividu, NomIndividu, PrenomIndividu
FROM INDIVIDU;
```

### Vue pour assurer l’intégrité

```sql
CREATE VIEW CritiqueSansAvis AS
SELECT * FROM Critique
WHERE Texte IS NULL;
```

➡️ **Mise à jour** :

```sql
UPDATE CritiqueSansAvis
SET Texte = 'Sans intérêt'
WHERE Note = 0;
```

---

## Index : Généralités

### Pourquoi utiliser un index ?

**Optimise** l’accès aux données  
**Assure** l’unicité (clé primaire, contraintes explicites)  

### Création d’un Index

```sql
CREATE [UNIQUE | BITMAP] INDEX [<schema>.]<nom_index>
ON <nom_de_table> (<nom_de_colonne> [ASC | DESC], ...);
```

**Exemple** :

```sql
CREATE INDEX IndNomIndividu
ON Individu(nomIndividu);
```

### Organisation des Index

#### Types d’index dans Oracle :

- **B-arbre** : Toutes les branches ont la même longueur.
- **Bitmap** : Utile si peu de valeurs distinctes.

**Exemple d’index en B-arbre** :

```sql
CREATE INDEX IndFilmTitre ON Film(Titre);
```

**Exemple d’index en Bitmap** :

```sql
CREATE BITMAP INDEX IndClasse ON Eleve(numClasse);
```

---

**Résumé**  
Ce cours présente les **vues** et **index** en bases de données, leurs **bénéfices**, **syntaxe**, et des **exemples concrets** en 