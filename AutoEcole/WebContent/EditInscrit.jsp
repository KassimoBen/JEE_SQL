<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="com.dao.DaoEleve" %>  
  <%@ page import="com.dao.DaoExamen" %>  
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
    
<title>Modifier un Inscrit</title>
</head>
<body>
<%@include file="menu.jsp" %>
<% DaoEleve eleve = new DaoEleve();
   DaoExamen examen = new DaoExamen();
%>

<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Modifier un Inscrit</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Inscritctrl?action=edit" method="post" >
   <form class="form-horizontal">
         
          <div class="form-group" style="padding: 20px;">
            <label for="rang" class="control-label col-xs-2">Nb Fautes</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="nbfautes" value="${p.nbfautes}">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
		    <label for="nume" class="control-label col-xs-2">N°Eleve</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="nume">
			       <c:forEach var="val" items="<%= eleve.findAllId() %>" > 
			        <option value="${val}">${val}</option>
			        </c:forEach>
		      	 </select>
		     </div>
      	</div>
         
        <div class="form-group" style="padding: 20px;">
		    <label for="nume" class="control-label col-xs-2">Date_Durée</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="dateeheuree">
			       <c:forEach var="p" items="<%= examen.findAll() %>" > 
			        <option value="${p.id.datee}_${p.id.heuree}">${p.id.datee}_${p.id.heuree}</option>
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