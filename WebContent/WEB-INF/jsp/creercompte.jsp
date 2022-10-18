<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Mon Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

</head>
<body>
				<!-- //////////////PAGE 3/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
			<div class = "col-md-4">
				<div class="logo">
					<a href="./ListesDesEncheres" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
				</div>
			</div>
			<h1 class= "col-md-12">Mon profil</h1>
			<div>
				<form method="post" action="./Profil" class="form-inline">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="pseudo">Pseudo : </label>
							<input type="text" name="pseudo" class="form-control" size="20" maxlength="20" required>
						</div>
						<div class="form-group col-md-5">
							<label for="nom">Nom : </label>
							<input type="text" name="nom" class="form-control" size="20" maxlength="30"  required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="prenom">Prénom : </label>
							<input type="text" name="prenom" class="form-control" size="20" maxlength="30" required>
						</div>
						<div class="form-group col-md-5">
							<label for="email">Email : </label>
							<input type="email" name="email" class="form-control" size="20" maxlength="20" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="tel">Teléphone :</label>
							<input type="text" name="tel" class="form-control" size="20" maxlength="10" required>
						</div>
						<div class="form-group col-md-5">
							<label for="rue">Rue :</label>
							<input type="text" name="rue" class="form-control" size="20" maxlength="50" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="codePostal">Code postal :</label>
							<input type="text" name="codePostal" class="form-control" size="20" minlength="5" maxlength="5" required>
						</div>
						<div class="form-group col-md-5">
							<label for="ville">Ville :</label>
							<input type="text" name="ville" class="form-control" size="20" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="password">Mot de passe :</label>
							<input type="password" name="password" class="form-control" size="20" required>
						</div>
						<div class="form-group col-md-5">
					  		<label for="passwordConfirm">Confirmation :</label>
							<input type="password" name="passwordConfirm" class="form-control" size="20" required>
						</div>
					</div>
					<br>
					<div class="form-row col-md-offset-4 col-md-1">
						<div class="form-group col-md-offset-4 col-md-2">
							<button type="submit" class="btn btn-primary">Créer</button>
						</div>
					</div>		
				</form>
				<div class="form-row col-md-offset-1 col-md-4">
					<a href="./ListesDesEncheres">
						<button type="submit" class="btn btn-primary">Annuler</button>
					</a>
				</div>
				
				<br>
				<font color="red"><%=request.getAttribute("messageErreur")!=null?request.getAttribute("messageErreur"):"" %></font>
			</div>
		</div>
</body>
		<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</html>