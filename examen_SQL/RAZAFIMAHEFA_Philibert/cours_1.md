### **Introduction**
Ce cours présente les concepts clés des **vues** et des **index** en bases de données, en expliquant leur définition, leur création, leurs avantages, ainsi que les conditions nécessaires pour leur mise à jour.

---

## **1. Les Vues**
### **Définition**  
Une **vue** est une table virtuelle qui représente le résultat d'une requête SQL. Elle est nommée et peut être utilisée comme une table dans d'autres requêtes.

### **1.1. Utilité des Vues**
- **Simplification des Requêtes** :  
  Les vues permettent de masquer la complexité des requêtes SQL en fournissant une interface simplifiée.  
  **Exemple :**  
  ```sql
  CREATE VIEW CommandesClients AS 
  SELECT client.nom, client.prenom, commande.date_commande, commande.montant
  FROM client
  JOIN commande ON client.id_client = commande.id_client;
  ```

- **Confidentialité des Données** :  
  Elles permettent de restreindre l’accès à certaines colonnes sensibles.  
  **Exemple :** Une vue qui masque l'email et l’adresse des employés :
  ```sql
  CREATE VIEW EmployesPublic AS
  SELECT id_employe, nom, prenom, poste
  FROM Employes;
  ```

- **Intégrité des Données** :  
  Une vue peut restreindre l'accès à certaines données tout en s'assurant qu'elles respectent des conditions spécifiques.

---

### **1.2. Création d'une Vue**
La syntaxe de création d’une vue est la suivante :  
```sql
CREATE [OR REPLACE] VIEW nom_vue AS
SELECT colonne1, colonne2, ...
FROM table_source
WHERE condition;
```

**Exemple :** Vue pour afficher uniquement les commandes de plus de 100 euros :
```sql
CREATE VIEW CommandesImportantes AS
SELECT * FROM Commandes
WHERE montant > 100;
```

---

### **1.3. Mise à Jour d'une Vue**
Les vues peuvent être mises à jour (INSERT, UPDATE, DELETE) sous certaines conditions :
- La vue ne doit pas contenir d'agrégats (`SUM()`, `AVG()`, etc.).
- Elle ne doit pas utiliser `GROUP BY`, `HAVING`, `DISTINCT`, `UNION`, `ORDER BY`, etc.
- Elle doit faire référence à une seule table.

**Exemple de mise à jour possible :**
```sql
UPDATE EmployesPublic
SET poste = 'Manager'
WHERE id_employe = 3;
```

Si la vue repose sur plusieurs tables ou inclut des fonctions d’agrégation, les mises à jour seront **impossibles**.

---

### **1.4. Suppression d'une Vue**
Pour supprimer une vue, on utilise la commande :
```sql
DROP VIEW nom_vue;
```
**Exemple :**
```sql
DROP VIEW CommandesImportantes;
```

Pour renommer une vue :
```sql
RENAME EmployesPublic TO EmployesConfidentiels;
```

---

## **2. Les Index**
### **Définition**
Un **index** est une structure qui accélère l’accès aux données en facilitant la recherche et le tri des enregistrements.

---

### **2.1. Création d'un Index**
La syntaxe est la suivante :
```sql
CREATE [UNIQUE] INDEX nom_index 
ON nom_table (colonne1 [ASC | DESC], colonne2);
```

**Exemple :**  
Création d’un index pour accélérer la recherche par nom d’individu :
```sql
CREATE INDEX idx_nomIndividu 
ON Individu(nomIndividu);
```

---

### **2.2. Types d’Index**
1. **Index B-tree (par défaut)** :  
   - Structure équilibrée pour la recherche rapide.
   - Utilisé pour les colonnes souvent filtrées par des requêtes `WHERE`.

   **Exemple :**  
   ```sql
   CREATE INDEX idx_dateCommande 
   ON Commandes(date_commande);
   ```

2. **Index Bitmap** :  
   - Efficace pour les colonnes avec peu de valeurs distinctes (ex. : sexe, statut d’un employé).  
   - Utilisé principalement pour des bases de données analytiques.  

   **Exemple :**
   ```sql
   CREATE BITMAP INDEX idx_sexe 
   ON Employes(sexe);
   ```

---

### **2.3. Suppression d’un Index**
Un index peut être supprimé avec :
```sql
DROP INDEX nom_index;
```
**Exemple :**
```sql
DROP INDEX idx_nomIndividu;
```

## **3. Exercice Pratique**
**Q1. Créez une vue qui affiche les employés ayant un salaire supérieur à 3000€.**
```sql
CREATE VIEW EmployesBienPayes AS
SELECT nom, prenom, salaire
FROM Employes
WHERE salaire > 3000;
```

**Q2. Ajoutez un index pour accélérer la recherche par email dans la table Clients.**
```sql
CREATE INDEX idx_email 
ON Clients(email);
```

**Q3. Supprimez la vue `EmployesBienPayes` et l’index `idx_email`.**
```sql
DROP VIEW EmployesBienPayes;
DROP INDEX idx_email;
```
## **Conclusion**
Les **vues** et les **index** sont deux outils essentiels en bases de données :
- **Les vues** permettent de simplifier les requêtes, restreindre l’accès aux données et garantir leur intégrité.
- **Les index** améliorent la rapidité des recherches et optimisent les performances.


