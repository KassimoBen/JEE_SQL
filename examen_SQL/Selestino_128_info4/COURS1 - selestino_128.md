# VUE

## Definition
- c'est une table vurtuel
- resultat d'une requette a laquelle on a donner un nom

## Creation du VIEW
```sql
    CREATE VIEW nom_de_view AS requette_sql
```
- Exemple:
```sql
    CREATE VIEW new_member AS SELECT nom, prenom, email, birth_day FROM user WHERE EXTRACT(YEAR FROM created_at) = 2025
```
## Selection dans VIEW
- C'est comme au selection du table
```sql
    SELECT * FROM new_member
```
## Supprimer une VIEW
```sql
    DROP VIEW new_member
```
## Renommer une VIEW
```sql
    RENAME nom_acienne TO nom_nouveau
```
- exemple:
```sql
    RENAME new_member TO top_user
```
## Simplification du requette SQL avec VIEW
```sql
    CREATE VIEW FilmCritique (NumFilm, Titre, NomReal,
    NomCrit, Note) AS SELECT F.NumFilm, Titre, I1.NomIndividu, I2.NomIndividu, Note
    FROM Film F, Individu I1; Individu I2, Critique C WHERE C.NumFilm = F.NumFilm AND C.NumIndividu = I2.NumIndividu AND F.NumRealisateur = I1.NumIndividu
```
## Securiser la confidentialite
```sql
    CREATE VIEW memder AS SELECT nom, prenom, email, birth_day FROM user
```
## Assurer des contraintes d’intégrité
```sql
    CREATE VIEW user_profil AS SELECT u.nom, u.prenom, u.email, pdp.img FROM user u LEFT JOIN img_profil pdp ON u.id = pdp.user_id WHERE pdp.img IS NULL
```
```sql
    UPDATE user_profil SET img = 'default_profil.jpeg';
```
```sql
    UPDATE user_profil SET nom = UPPER(nom);
```


# INDEX
Pour accéder plus vite aux lignes d’une table, Indexer ce qui est nécessaire.
## Creation
```sql
    CREATE nom_index ON nom_table(nom_colonne)
```
- exemple:
```sql
    CREATE username ON user(nom)
```
## Type (dans `ORACLE`)
- B-Arbre
- Bitmap
## Avantage
- rapidite du selection
## Incoveniant
- table grand volume
- Ne suporte pas les selections `IS NULL`


##### examen Selestino - 128/INFO4
