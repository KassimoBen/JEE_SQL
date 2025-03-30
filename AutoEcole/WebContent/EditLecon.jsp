<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="com.dao.DaoEleve" %>  
 <%@ page import="com.dao.DaoVehicule" %> 
 <%@ page import="com.dao.DaoMoniteur" %> 
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
    
<title>Ajouter une Leçon</title>
</head>
<body>
<%@include file="menu.jsp" %>
<% DaoEleve eleve = new DaoEleve();%>
<%  DaoMoniteur moniteur = new DaoMoniteur();%>  
 <%  DaoVehicule vehicule = new DaoVehicule(); %> 
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Modifier une leçon</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Leconctrl?action=edit" method="post" >
   <form class="form-horizontal">
   <div class="form-group" style="padding: 20px;">
            <label for="date cours" class="control-label col-xs-2">N°</label>
            <div class="col-xs-10">
                <label for="numl" class="control-label">${p.numl}</label> 
                <input type="hidden" class="form-control" name="numl" value="${p.numl}">
            </div>
        </div>
   
        <div class="form-group" style="padding: 20px;">
            <label for="date cours" class="control-label col-xs-2">Date cours</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="dateCours" value="${p.dateCours }">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Heure Debut</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="heurDebut" value="${p.heureDebut}">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Durée</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="duree" value="${p.duree}">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
		    <label for="nume" class="control-label col-xs-2">Eleve</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="nume" >
			       <c:forEach var="val" items="<%= eleve.findAllId() %>" > 
			        <option value="${val}" ${p.nume == val ? 'selected' : ''}>${val}</option>
			        </c:forEach>
		      	 </select>
		     </div>
      	</div>
      	
      	<div class="form-group" style="padding: 20px;">
		    <label for="numm" class="control-label col-xs-2">Moniteur</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="numm">
			        <c:forEach var="val" items="<%= moniteur.findAllId() %>" > 
			       <option value="${val}" ${p.numm == val ? 'selected' : ''}>${val}</option>
			        </c:forEach>
		      	 </select>
		      	 </div>
      	</div>
      	
      	<div class="form-group" style="padding: 20px;">
		    <label for="numv" class="control-label col-xs-2">Véhicule</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="numv">
			       <c:forEach var="val" items="<%= moniteur.findAllId() %>" > 
			      <option value="${val}" ${p.numv == val ? 'selected' : ''}>${val}</option>
			        </c:forEach>
		      	 </select>
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