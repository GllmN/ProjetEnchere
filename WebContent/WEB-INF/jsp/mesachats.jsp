<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Mes achats</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

</head>
<body>

				<!-- //////////////PAGE ???/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
			<div class = "col-md-4">
				<div class="logo">
					<a href="./ListesDesEncheres" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
				</div>
			</div>
<h1>Liste des encheres mes achats.jsp</h1>


<p> Filtres </p>

<input type="texte" name="filtre" placeholder="barre de recherche a mettre">
<br><br>
<label for="pays">categorie:</label>
<select name="scategorie"  multiple>
			<c:forEach items="${ categories }" var="cate">
							<option value="<c:out value="${cate.noCategorie}"/>"><c:out value="${cate.libelle}"/></option>
   							</c:forEach>
		</select>

<br>
<br>
<p> Checkbox Mes Achats </p> Achats :
		<input type="checkbox" name="achats[]"  value="encheres ouvertes" checked>
		<label for="mes encheres ouvertes">encheres ouvertes</label>&nbsp;
		
		<input type="checkbox" name="achats[]" value="mes encheres" >
		<label for="mes encheres">mes encheres</label>&nbsp;
		
		<input type="checkbox" name="achats[]" value="mes enchères remportees" >
		<label for="mes enchères remportees">mes enchères remportees</label>
		<br><br>
		
		
	<p> Checkbox Mes ventes </p> Ventes :
		<input type="checkbox" name="ventes[]"  value="mes ventes en cours">
		<label for="mes ventes en cours">mes ventes en cours</label>&nbsp;
		
		<input type="checkbox" name="ventes[]" value="ventes non debutees" >
		<label for="ventes non debutees">ventes non debutees</label>&nbsp;
		
		<input type="checkbox" name="ventes[]" value="ventes terminées" >
		<label for="ventes terminées">mes enchères remportees</label>
		
<!-- 		espace pour eloigner bouton rechercher, a retirer apres -->
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		
		<button type="submit"> Rechercher</button>
		
		<p>image enchere 1</p>
		<p>image enchere 2</p>
	</div>
</body>
</html>