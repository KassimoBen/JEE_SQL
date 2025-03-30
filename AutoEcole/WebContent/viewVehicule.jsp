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
    
<title>Informations du Véhicule</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">

   <div class="row">
  <div class="col-md-6 col-md-offset-3">
  <div class="panel panel-info">
    <div class="panel-heading">Informations du Véhicule</div>
    <div class="panel-body">
    <form role="form" action="Recherche.jsp" method="post" >
   <form class="form-horizontal">
        <div class="form-group" style="padding: 20px;">
            <label for="nom" class="control-label col-xs-2">Modèle</label>
            <div class="col-xs-10">
             <label for="nom" class="control-label col-xs-2">${p.modele}</label>
            </div>
        </div>

        <div class="form-group" style="padding: 20px;">
            <label for="immat" class="control-label col-xs-2">Immat</label>
            <div class="col-xs-10">
                <label for="immat" class="control-label col-xs-2">${p.immatriculation}</label>
            </div>
        </div>
       
       <div class="form-group" style="padding: 20px;">
            <div class="col-xs-offset-2 col-xs-10">
             <button class="btn btn-success">OK</button>
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