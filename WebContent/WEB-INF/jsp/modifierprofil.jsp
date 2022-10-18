<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Modifier mon profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
</head>
<body>
				<!-- //////////////PAGE 8/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
			<div class = "col-md-4">
				<div class="logo">
					<a href="./MesVentes" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
				</div>
			</div>
			<h1 class= "col-md-12">Mon profil</h1>
			<div class="modifierProfil">
				<form method="post" action="" class="form-inline">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="pseudo">Pseudo : </label>
							<input type="text" name="pseudo" class="form-control" size="20" maxlength="20" value="${utilisateurConnecte.pseudo}">
						</div>
						<div class="form-group col-md-5">
							<label for="nom">Nom : </label>
							<input type="text" name="nom" class="form-control" size="20" maxlength="30" value="${utilisateurConnecte.nom}">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="prenom">Prénom : </label>
							<input type="text" name="prenom" class="form-control" size="20" maxlength="30" value="${utilisateurConnecte.prenom}">
						</div>
						<div class="form-group col-md-5">
							<label for="email">Email : </label>
							<input type="email" name="email" class="form-control" size="20" maxlength="20" value="${utilisateurConnecte.email}">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="tel">Teléphone :</label>
							<input type="text" name="tel" class="form-control" size="20" maxlength="10" value="${utilisateurConnecte.telephone}">
						</div>
						<div class="form-group col-md-5">
							<label for="rue">Rue :</label>
							<input type="text" name="rue" class="form-control" size="20" maxlength="50" value="${utilisateurConnecte.rue}">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="codePostal">Code postal :</label>
							<input type="text" name="codePostal" class="form-control" size="20" minlength="5" maxlength="5" value="${utilisateurConnecte.codePostal}">
						</div>
						<div class="form-group col-md-5">
							<label for="ville">Ville :</label>
							<input type="text" name="ville" class="form-control" size="20" value="${utilisateurConnecte.ville}">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-10">
							<label for="password">Mot de passe actuel :</label>
							<input type="password" name="password" class="form-control" size="20" placeholder="xxxxxxxxxxxxx" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="passwordNew">Nouveau mot de passe :</label>
							<input type="password" name="passwordNew" class="form-control" size="20" placeholder="xxxxxxxxxxxxx">
						</div>
						<div class="form-group col-md-5">
					  		<label for="passwordNewConfirm">Confirmation :</label>
							<input type="password" name="passwordNewConfirm" class="form-control" placeholder="xxxxxxxxxxxxx">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-10">
							<label for="credit">Crédit</label>
							${utilisateurConnecte.credit}
						</div>
					</div>
					<br>
					<div class="form-row col-md-offset-4 col-md-1">
						<div class="form-group col-md-offset-4 col-md-2">
							<button type="submit" class="btn btn-primary">Enregistrer</button>
						</div>
					</div>
				</form>
					<div class="form-row col-md-offset-1 col-md-4">
						<a href="">
							<button type="submit" class="btn btn-primary">Supprimer mon compte</button>
						</a>
					</div>
			</div>
			<br>
				<c:if test="${messageErreurProfil!=null}">
						<font color="red"><c:out value="${messageErreurProfil}"/></font>
				</c:if>
		</div>		
</body>
</html>