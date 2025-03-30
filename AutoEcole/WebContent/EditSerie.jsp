<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.*" %> 
 <%@ page import="com.dao.DaoCd" %>  
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
    
<title>Modifier une série</title>
</head>
<body>
<%@include file="menu.jsp" %>
<% DaoCd cd = new DaoCd();%>
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Modifier une série</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Seriectrl?action=edit" method="post" >
   <form class="form-horizontal">
         
         <div class="form-group" style="padding-top: 20px;">
            <label for="nom" class="control-label col-xs-2">N° série</label>
            <div class="col-xs-10">
                <label for="nums" class="control-label">${p.id.nums}</label> 
                <input type="hidden" class="form-control" name="nums" value="${p.id.nums}">
            </div>
        </div>
         
        <div class="form-group" style="padding: 20px;">
		    <label for="nume" class="control-label col-xs-2">N° cd </label>
		    <div class="col-xs-10">
			      <select class="form-control" name="numcd">
			       <c:forEach var="val" items="<%= cd.findAllId() %>" > 
			        <option value="${val}" ${val == p.id.numcd ? 'selected' : ''}>${val}</option>
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