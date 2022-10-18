<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Connexion Utilisateur</title>
</head>
<body>
				<!-- //////////////PAGE 2/13\\\\\\\\\\\\\\\ -->
	<%
		String messageErreur = (String) request.getAttribute("messageErreur");
	%>
	<div class="container col-md-offset-1 col-md-10">
		<div class = "col-md-4">
			<div class="logo">
				<a href="./ListesDesEncheres" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
			</div>
		</div>
		<h1 class= "col-md-12"></h1>
		<div class= "col-md-offset-3 col-md-7">
			<form method="post" action="./connexion" class="form-inline">
				<div class="col-md-12">
					<div class="form-group col-md-12">
						<label for="pseudo">Identifiant :</label> 
						<input type="text" name="sidentifiant" class="form-control" size="20" required>
					</div>
					<div class="form-group col-md-12">
						<label for="password">Mot de passe :</label> 
						<input type="password" name="smotdepasse" class="form-control" size="20"required>
					</div>
				</div>
				<br>
				<div class="form-group col-md-3">
					<button type="submit" name="ssubmit" class="btn btn-primary btn-lg" value="Connexion">Connexion</button>
					<font color="red"><%=request.getAttribute("messageErreur") != null ? request.getAttribute("messageErreur") : ""%></font>
				</div>
			</form>
			<div class= "col-md-1">
			</div>
			<div class="form-group col-md-5">			
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
					<label>Se souvenir de moi</label>
					<br>
	<!-- MOT DE PASSE OUBLIE>> AHREF A METTRE A JOUR -->
					<a href="">Mot de passe oublié</a>
				</div>
			</div>
		</div>
		<br class= "col-md-12">
		<br class= "col-md-12">
		<br class= "col-md-12">
		<br class= "col-md-12">
		<div class= "col-md-offset-5 col-md-5 bouttonCreerCompte">
			<a href="./Profil"> 
				<input type="submit" class="btn btn-primary btn-lg" value="Créer un compte">
			</a>
		</div>
	</div>
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>