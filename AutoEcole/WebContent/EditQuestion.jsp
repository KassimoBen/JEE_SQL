<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
<title>Modifier une Question</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Modifier une Question</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Questionctrl?action=edit" method="post" >
   <form class="form-horizontal">
   
   <div class="form-group" style="padding-top: 20px;">
            <label for="nom" class="control-label col-xs-2">N°</label>
            <div class="col-xs-10">
                <label for="numq" class="control-label">${p.numq}</label> 
                <input type="hidden" class="form-control" name="numq" value="${p.numq}">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
            <label for="intitule" class="control-label col-xs-2">Intitule</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="intitule" value="${p.intitule}">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Réponse</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="reponse" value="${p.reponse}">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
            <label for="diffic" class="control-label col-xs-2">Difficulté</label>   
            <div class="col-xs-10">
			      <select class="form-control" name="diffic">
                  <option value="1" ${p.diffic == '1' ? 'selected' : ''}>1</option>
                  <option value="2" ${p.diffic == '2' ? 'selected' : ''}>2</option>
                  <option value="3" ${p.diffic == '3' ? 'selected' : ''}>3</option>
                  <option value="4" ${p.diffic == '4' ? 'selected' : ''}>4</option>
		      	 </select>
		    </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
            <label for="theme" class="control-label col-xs-2">Thème</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="theme" value="${p.theme}">
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