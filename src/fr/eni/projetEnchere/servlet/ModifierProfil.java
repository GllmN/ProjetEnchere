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


@WebServlet(name ="ModifierProfil",
value = {"/ModifierProfil"})


public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Utilisateur u;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Appel du manager (lien servlet <> BLL);
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		
		// Initialisation des attributs session
		HttpSession maSession = request.getSession();
		u=(Utilisateur) maSession.getAttribute("utilisateurConnecte");
		
		// Récupération des infos saisies lors de la mise à jour du formulaire
		String pseudoFormulaire = request.getParameter("pseudo");
		String nomFormulaire = request.getParameter("nom");
		String prenomFormulaire = request.getParameter("prenom");
		String emailFormulaire = request.getParameter("email");
		String telephoneFormulaire = request.getParameter("tel");
		String rueFormulaire = request.getParameter("rue");
		String codePostalFormulaire = request.getParameter("codePostal");
		String villeFormulaire = request.getParameter("ville");
		
		// password et new passwoord à revoir dans la BLL
		String password = request.getParameter("password");
		String passwordNew = request.getParameter("passwordNew");
		String passwordNewConfirm = request.getParameter("passwordNewConfirm");
		boolean test = true;
		StringBuilder message = new StringBuilder("La modification a échouée : \n");
		//
		try {
			annuaire.testConnexion(u.getPseudo(), password);
		} catch (BLLException e2) {
			test=false;
			message.append(e2);
		}
			
		if((!passwordNew.trim().isEmpty())||!passwordNewConfirm.trim().isEmpty())  {
			if(!passwordNew.equals(passwordNewConfirm)) {
				test=false;
				message.append("Pour changer le mot de passe, saisir deux mots de passes identiques");
			}
		}
		if(passwordNew.isEmpty())  {
			passwordNew=password;
		}
		
		// Initialisation des attributs session
		RequestDispatcher dispatcher = null;
		
		Utilisateur u = (Utilisateur) maSession.getAttribute("utilisateurConnecte");
		int noUtilisateur = u.getNoUtilisateur();
		
		Utilisateur uModifier = new Utilisateur(noUtilisateur, pseudoFormulaire, nomFormulaire, prenomFormulaire, emailFormulaire, telephoneFormulaire, rueFormulaire, codePostalFormulaire, villeFormulaire, passwordNew); 
			
		if(test==true) {
		try {
			annuaire.updateUtilisateur(uModifier);
					
		} catch (BLLException e) {
			test= false;
			message.append(e.getMessage());
		}
		}
	
	
		if(test==true) {
			maSession = request.getSession();
			maSession.setAttribute("utilisateurConnecte", uModifier);	
			String messageValidation = "Vos modifications ont été enregistrées";
			request.setAttribute("messageValidationProfil", messageValidation);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/afficherprofil.jsp");
		}else {
			request.setAttribute("messageErreurProfil", message.toString());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp");
		}	
		dispatcher.forward(request, response);
	}

}
