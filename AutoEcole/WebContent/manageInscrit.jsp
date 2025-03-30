<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="com.appfactory.*" %>  
  <%@ page import="com.dao.DaoInscrit" %>   
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
    
<title>Gestion des Inscrit</title>
</head>
<body>
<%@include file="menu.jsp" %>
<%  DaoInscrit dao = (DaoInscrit) Appfactory.getInstance().getModel("DaoInscrit");%>
<div class="container">
    <%
      // R�cup�ration du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      } else {
    	  
    	  String succes = (String) request.getAttribute("succes");
          // Affichage du message s'il existe
          if (succes != null) { %>
               <p> <div class="alert alert-success">    <strong>Succ�s !</strong> <%= succes %></div> </p>
    	  
         <%} 
      }
       %>
  
  <table class="table">
   <caption> Liste des inscrit</caption>
   <thead>
      <tr>
         <th>Nb Fautes</th>
         <th>N� El�ve</th>
         <th>Date</th>
         <th>Dur�e</th>
         <th>Modifier</th>
         <th>Suppimer</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach var="p" items="<%= dao.findAll() %>" > 
       <tr class="active">
         <td>${p.nbfautes}</td>
         <td>${p.id.nume}</td>
         <td>${p.id.datee}</td>
         <td>${p.id.heuree}</td>
         <td><a href="Inscritctrl?action=modifier&nume=${p.id.nume}&datee=${p.id.datee}&heuree=${p.id.heuree}" >Modifier</a></td>
		 <td><a href="Inscritctrl?action=supprimer&nume=${p.id.nume}&datee=${p.id.datee}&heuree=${p.id.heuree}" onclick="return confirm('Voulez vous supprimer')">Supprimer</a></td>
      </tr>
   
   </c:forEach>
   
   </tbody>
   </table>

</div><!-- /.container -->


</body>
</html>