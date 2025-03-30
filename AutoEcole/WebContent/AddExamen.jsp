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
    
<title>Ajouter un Examen</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">
  
   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Ajouter un Examen</div>
    <div class="panel-body">
    <%
      // Récupération du message d'erreur 
      String erreur = (String) request.getAttribute("erreur");
      // Affichage du message s'il existe
      if (erreur != null) { %>
           <p> <div class="alert alert-danger"> <strong>Erreur !</strong> <%= erreur %></div> </p>
      <%
      }%>
    <form role="form" action="Examenctrl?action=ajouter" method="post" >
   <form class="form-horizontal">
        <div class="form-group" style="padding: 20px;">
            <label for="nom" class="control-label col-xs-2">Date</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="datee" placeholder="aaaa-mm-jj">
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="prenom" class="control-label col-xs-2">Heure</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" name="heuree" placeholder="hh:mm:ss">
            </div>
        </div>
        
        <div class="form-group" style="padding: 20px;">
		    <label for="typee" class="control-label col-xs-2">Type</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="typee">
			        <option value="code">code</option>
			        <option value="conduite">conduite</option>
		      	 </select>
		     </div>
      	</div>
      	
      	<div class="form-group" style="padding: 20px;">
		    <label for="resultate" class="control-label col-xs-2">resultate</label>
		    <div class="col-xs-10">
			      <select class="form-control" name="resultate">
			        <option value="réussi">réussi</option>
			        <option value="echec">echec</option>
			        <option value="néant">néant</option>
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