package fr.eni.projetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEnchere.bll.AnnuaireUtilisateurManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bo.Utilisateur;

@WebServlet("/Profil")

public class CreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des champs de formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
			
		StringBuilder messageError = new StringBuilder();

// =========>>>> met on le crédit ici à 100 ?
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		// Initialisation des attributs session
		HttpSession maSession = null;
		RequestDispatcher dispatcher = null;
		
		//Test de la confirmation du mot de passe
		boolean testPassword = false;
		if(password.equals(passwordConfirm)) {
			testPassword = true;
		} else {
			testPassword = false;
			messageError.append("\n"+"Les mots de passes" + "\n" +"ne sont pas identiques");
		}
		//Création de l'inscription
		Utilisateur u = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,100);
		try {
			annuaire.nouvelleInscription(u);
		} catch (BLLException e1) {
			testPassword=false;
			messageError.append(e1.getMessage());
		}
		if(testPassword==true) {
			maSession = request.getSession();
			maSession.setAttribute("utilisateurConnecte", u);
			//Si valide redirection vers la page...
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mesventes.jsp");
		}else {
			request.setAttribute("messageErreur", messageError.toString());
			//Si non valide redirection vers la page...
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/creercompte.jsp");
		}	
		dispatcher.forward(request, response);	
	}
}