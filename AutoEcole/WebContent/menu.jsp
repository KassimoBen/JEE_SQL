<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des Ressources</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        /* Style du menu Clubic */
        .navbar {
            background-color: #007BFF; /* Bleu Clubic */
            padding: 15px;
        }
        .navbar a {
            color: white !important;
            font-size: 20px;
            font-weight: bold;
            padding: 12px 20px;
            transition: 0.3s;
        }
        .navbar a:hover {
            background-color: #0056b3; /* Bleu plus foncé */
            border-radius: 5px;
        }
        .dropdown-menu {
            background-color: white;
            border: none;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }
        .dropdown-menu a {
            color: #007BFF !important;
            font-size: 18px;
        }
        .dropdown-menu a:hover {
            background-color: #f1f1f1;
        }
        /* Contenu principal */
        .content {
            margin-top: 80px; /* Pour éviter que le menu ne cache le contenu */
            text-align: center;
            padding: 20px;
        }
        /* Augmenter la taille du texte global */
        body {
            font-size: 20px; /* Texte plus grand */
            font-family: Arial, sans-serif;
        }
        /* Titres */
        h1 {
            font-size: 34px;
            font-weight: bold;
            color: #0056b3;
        }
        h2 {
            font-size: 30px;
            font-weight: bold;
            color: #007BFF;
        }
        h3 {
            font-size: 26px;
            font-weight: bold;
            color: #004085;
        }
        /* Paragraphes et autres textes */
        p, li, td {
            font-size: 20px;
            line-height: 1.8;
            color: #333;
        }
        /* Taille des boutons */
        button, .btn {
            font-size: 20px;
            padding: 14px 24px;
        }
        /* Le menu garde une taille standard */
        .navbar a, .dropdown-menu a {
            font-size: 18px;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><i class="fa fa-home"></i> Accueil</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-user-graduate"></i> Élèves
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageEleve.jsp">Voir les élèves</a></li>
                        <li><a class="dropdown-item" href="AddEleve.jsp">Ajouter un élève</a></li>
                        <li><a class="dropdown-item" href="Recherche.jsp">Rechercher un élève</a></li>
                        <li><a class="dropdown-item" href="manageAssiste.jsp">Afficher assiste</a></li>
                        <li><a class="dropdown-item" href="AddAssiste.jsp">Ajouter assiste</a></li>
                        <li><a class="dropdown-item" href="manageInscrit.jsp">Afficher inscrit</a></li>
                        <li><a class="dropdown-item" href="AddInscrit.jsp">Ajouter inscrit</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-car"></i> Véhicules
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageVehicule.jsp">Voir les véhicules</a></li>
                        <li><a class="dropdown-item" href="AddVehicule.jsp">Ajouter un véhicule</a></li>
                        <li><a class="dropdown-item" href="Recherche.jsp">Rechercher un véhicule</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-chalkboard-teacher"></i> Moniteurs
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageMoniteur.jsp">Voir les moniteurs</a></li>
                        <li><a class="dropdown-item" href="AddMoniteur.jsp">Ajouter un moniteur</a></li>
                        <li><a class="dropdown-item" href="Recherche.jsp">Rechercher un moniteur</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-book"></i> Leçons
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageLecon.jsp">Voir les leçons</a></li>
                        <li><a class="dropdown-item" href="AddLecon.jsp">Ajouter une leçon</a></li>
                        <li><a class="dropdown-item" href="manageQuestion.jsp">Afficher Questions</a></li>
                        <li><a class="dropdown-item" href="AddQuestion.jsp">Ajouter Questions</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-file-alt"></i> Examens
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageExamen.jsp">Voir les examens</a></li>
                        <li><a class="dropdown-item" href="AddExamen.jsp">Ajouter un examen</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                        <i class="fa fa-folder"></i> Séries
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="manageSerie.jsp">Voir les séries</a></li>
                        <li><a class="dropdown-item" href="AddSerie.jsp">Ajouter une série</a></li>
                        <li><a class="dropdown-item" href="manageAppartient.jsp">Afficher Appartient</a></li>
                        <li><a class="dropdown-item" href="AddAppartient.jsp">Ajouter Appartient</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Contenu principal -->
<div class="content">
    <h1>Bienvenue sur votre plateforme de gestion</h1>
    <p>Utilisez le menu pour naviguer entre les différentes sections.</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
