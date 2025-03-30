<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- Bootstrap -->
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="/bootstrap/js/dropdown.js" media="screen" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    
<title>Ajouter un élève</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Modifier un Elève</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Elevectrl?action=edit" method="post" >
   <form class="form-horizontal">
   		<div class="form-group" style="padding: 20px;">
            <label for="nom" class="control-label col-xs-2">Nume</label>
            <div class="col-xs-10">
            <label for="nom" class="control-label">${p.nume}</label>
                <input type="hidden" class="form-control" name="nume" value="${p.nume}">
            </div>
        </div>
        <div class="form-group" style="padding: 20px;">
            <label for="nom" class="control-label col-xs-2">Nom</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="nom" value="${p.nom}">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Prenom</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="prenom" value="${p.prenom}">
            </div>
        </div>
       
         <div class="form-group" style="padding: 20px;">
            <label for="adresse" class="control-label col-xs-2">Adresse</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="adresse" value="${p.adresse}">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
            <label for="datenaiss" class="control-label col-xs-2">Date Naissance</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="datenaiss" value="${p.datenaiss}">
            </div>
        </div>
      
        <div class="form-group" style="padding: 20px;">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Modifier</button>
            </div>
        </div>
    </form>
    </form>

    </div>
  </div>
</div>
</div>    

</div><!-- /.container -->


</body>
</html>