<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="com.dao.DaoSerie" %>  
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
    
<title>Ajouter une séance</title>
</head>
<body>
<%@include file="menu.jsp" %>
<% DaoSerie serie = new DaoSerie();%>
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Ajouter une séance</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Seancectrl?action=ajouter" method="post" >
   <form class="form-horizontal">
         
          <div class="form-group" style="padding: 20px;">
            <label for="nom" class="control-label col-xs-2">Date</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="dates" placeholder="aaaa-mm-jj">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Durée</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="heures" placeholder="">
            </div>
        </div>
         
        <div class="form-group" style="padding: 20px;">
		    <label for="nume" class="control-label col-xs-2">N°Série_N°Cd </label>
		    <div class="col-xs-10">
			      <select class="form-control" name="numsnumcd">
			       <c:forEach var="p" items="<%= serie.findAll() %>" > 
			        <option value="${p.id.nums}_${p.id.numcd}">${p.id.nums}_${p.id.numcd}</option>
			        </c:forEach>
		      	 </select>
		     </div>
      	</div>
      	
       
        <div class="form-group" style="padding: 20px;">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Ajouter</button>
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