<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="fr.eni.projetEnchere.bo.Categorie"%>
<%@page import="fr.eni.projetEnchere.bo.ArticleVendu"%>
<%@page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Listes des encheres</title>
</head>
<body>
				<!-- //////////////PAGE 1/13\\\\\\\\\\\\\\\ -->
				
	<!-- //////////////1er partie\\\\\\\\\\\\\\\ -->
	
		<!-- //////////////HEADER\\\\\\\\\\\\\\\ -->
	<%@ include file="../fragments/header.jspf" %>
	
		<!-- //////////////NAV\\\\\\\\\\\\\\\ -->
	<nav>
		<ul>
			<li><a href="./connexion">Se connecter - S'inscrire</a></li>
		</ul>
	</nav>
	<h1>Liste des enchères</h1>
	<br>
	<form method="post">
		<div>
			<div class="side-search">
				<h2>Filtres</h2>
				<input type="search" id="search-auction" name="srecherche" placeholder="Le nom de l'article contient">
				<button type="submit">Go</button>
			</div>
			<div class="col-md-12">
				<label class="control-label col-md-1">Categorie : </label>
				<div class="form-group col-md-6">
					<select name="scategorie" class="form-control" id="sel1">
							<c:forEach items="${ categories }" var="cate">
								<option value="<c:out value="${cate.noCategorie}"/>">
										<c:out value="${cate.libelle}"/>
								</option>
		   					</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-1">
		</div>
		<div class="col-md-3">
			<button type="submit" class="col-md-12 btn btn-primary btn-lg"> Rechercher </button>
		</div>
		<div class="col-md-1">
		</div>
		
	</form>
			
	<!-- //////////////espace\\\\\\\\\\\\\\\ -->
	<div class="container col-md-12">
		<br>
		<br>
	</div>
	<!-- //////////////2ème partie\\\\\\\\\\\\\\\ -->	
	<div class="container col-md-offset-1 col-md-10">
	
	
	  
      
   
	
	<c:forEach items="${listeArticles.entrySet().toArray()}" var="article">
			<div class="container col-md-5">
				<div class="annonceEnchereEnCours">
					<div class="col-md-5">
						<div class="annonceImg">
							<a href=""><img src="./images/annonceVoiture.jpg" width="100%" height=auto/></a>
						</div>
					</div>
					<div class="col-md-7">
						<div class="annonceText">
							<div class="annonceTitre">
								<p> ${article.key.nomArticle}</p>
								<p> ${article.key.description}</p>
							</div>
							<br>
							<div class="annoncePrix">
								<p>Prix :${article.key.miseAPrix} euros</p>
							</div>
							<div class="annonceDate">
								<p>Début de l'enchère : ${article.key.dateHeureDebutEncheres} </p>
							</div>
							<div class="annonceDate">
								<p>Fin de l'enchère : ${article.key.dateHeureFinEncheres} </p>
							</div>
							<br>
							<div class="annonceVendeur">
								<p>Vendeur : ${article.value.nom} ${article.value.prenom}</p>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		 </c:forEach>	
						
			${message}
		
	</div>
	
	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>