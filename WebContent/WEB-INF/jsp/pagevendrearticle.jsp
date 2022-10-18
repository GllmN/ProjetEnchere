<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@ page import="fr.eni.projetEnchere.bo.Utilisateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Nouvelle vente</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

</head>
<body>
				<!-- //////////////PAGE 9/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
		<div class = "col-md-4">
			<div class="logo">
				<a href="./MesVentes" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
			</div>
		</div>
		<h1 class= "col-md-12">Nouvelle vente</h1>
		<br>
		<form class="form-horizontal col-md-offset-2" method="post" action="./VendreArticle">
			<div class="form-group">
				<label class="control-label col-sm-2">Article</label>
				<div class="col-sm-6">
					<input type="text" name="sarticle" class="form-control">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-2">Description </label>
				<div class="col-sm-6">
					<textarea rows="5" cols="20" name="sdescription"
						class="form-control"></textarea>
				</div>
				<br>
			</div>;
			<br>
			<div class="form-group">
				<label class="control-label col-sm-2" for="sel1">Categorie</label>
				<div class="col-sm-6">
					<select name="scategorie" class="form-control" id="sel1">
						<c:forEach items="${ categories }" var="cate">
						<option value="<c:out value="${cate.noCategorie}"/>"><c:out value="${cate.libelle}"/></option>
	 							</c:forEach>
					</select>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-2">Photo de l'article</label>
				<button class="btn btn-secondary" disabled>UPLOADER</button>
				<br>
			</div>
			<br>
			<div class="form-group">
				<label class="control-label col-sm-2">Mise à prix</label>
				<div class="col-sm-6">
					<input type="number" name="sprix" class="form-control" min="0" max="50000"><br>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Début de l'enchere</label>
				<div class="col-sm-6">
					<input type="datetime-local" class="form-control" name="sdateDebut">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Fin de l'enchere</label>
				<div class="col-sm-6">
					<input class="form-control" id="date" name="sdateFin" type="datetime-local">
				</div>
			</div>
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Retrait</legend>
				<div class="form-group">
					<label class="control-label col-sm-2">Rue</label>
					<div class="col-sm-6">
						<input type="text" name="srue" class="form-control" value="${utilisateurConnecte.rue}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Code postal</label>
					<div class="col-sm-6">
						<input type="text" name="scodePostal" class="form-control" value="${utilisateurConnecte.codePostal}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Ville</label>
					<div class="col-sm-6">
						<input type="text" name="sville" class="form-control" value="${utilisateurConnecte.ville}">
					</div>
				</div>
			</fieldset>
			<br>
			<div class="form-row col-md-offset-4 col-md-1">
				<div class="form-group col-md-offset-4 col-md-2">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
				</div>
			</div>	
		</form>
		<div class="form-row col-md-4">
			<a href="./MesVentes">
			<button type="submit" class="btn btn-primary">Annuler</button>
			</a>
		</div>
		<br>
		<c:if test="${messageErreur!=null}">
			<font color="red"><c:out value="${messageErreur}"/></font>
		</c:if>
	</div>


	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>