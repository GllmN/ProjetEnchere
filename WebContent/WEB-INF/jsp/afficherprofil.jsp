<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <%@ include file="../fragments/header.jspf" %> --%>
<title>Affichage du profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"	href="/projetEnchere/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/projetEnchere/theme/css/design.css">

</head>
<body>
				<!-- //////////////PAGE 7/13\\\\\\\\\\\\\\\ -->
	<div class="container col-md-offset-1 col-md-10">
		<div class = "col-md-4">
			<div class="logo">
				<a href="./MesVentes" title="retour accueil"><img src="./images/logo_small.png" width="220" height=auto alt="logoENIecole"/></a>
			</div>
		</div>
		
	    <div class="row">
	        <div class="col-md-4 col-md-offset-4">
				<table>			       		
				   <tr>
				       <td>Pseudo : </td>
				       <td>    		
							${utilisateurConnecte.pseudo}
						</td>
				   </tr>
				   <tr>
				       <td>Nom : </td>
				       <td>	
				       		${utilisateurConnecte.nom}		       
				       </td>
				   </tr>
				   <tr>
				       <td>Prénom : </td>
				       <td>
				       		${utilisateurConnecte.prenom}
				       </td>
				   </tr>
				   <tr>
				       <td>Email : </td>
				       <td>
				       		${utilisateurConnecte.email}
				       	</td>
				   </tr>
				   <tr>
				       <td>Téléphone : </td>
				       <td>
				       		${utilisateurConnecte.telephone}
				       </td>
				   </tr>
				   <tr>
				       <td>Rue : </td>
				       <td>
				       		${utilisateurConnecte.rue}
				       </td>
				   </tr>
				   <tr>
				       <td>Code postal : </td>
				       <td>
				       		${utilisateurConnecte.codePostal}
				       </td>
				   </tr>  
				   <tr>
				       <td>Ville : </td>
				       <td>
				       		${utilisateurConnecte.ville}
				       </td>
				   </tr>
				</table>
			</div>
		</div>
		<div class="form-group col-md-12 ">
			<div class="boutonAfficherProfil">	
				<a href="./ModifierProfil"><button type="submit" class="btn btn-primary">Modifier</button></a>
			</div>
		</div>
		<div class="col-md-offset-3">
			<c:if test="${messageValidationProfil!=null}">
				 <font color="green"><c:out value="${messageValidationProfil}"/></font>
			</c:if>
		</div>
	</div>	

	<script src="/projetEnchere/theme/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>