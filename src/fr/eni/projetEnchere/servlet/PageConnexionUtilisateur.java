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


//@WebServlet(name ="PageConnexionUtilisateur",
//value = {"/ConnexionUtilisateur"})
@WebServlet("/connexion")

public class PageConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageConnexionUtilisateur() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}


	//methode pourra acceder aux parametres des champs remplis par l'utilisateur de la jsp 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder message = new StringBuilder();
		AnnuaireUtilisateurManager dao = AnnuaireUtilisateurManager.getInstance();
		Utilisateur u = null;
		//on s'assure que tomcat decodera les informations reçues avc le coade utf-8
		request.setCharacterEncoding("UTF-8");
		//recuperation ds parametre identifiant et vérification que le champs est rempli
		String identifiant = request.getParameter("sidentifiant");
		String motDePasse = request.getParameter("smotdepasse");
		// On va chercher la méthode dans la BLL testConnection
		// Elle nous renvera l'utilisateur en session si connection est accordée
		try {
			u=dao.testConnexion(identifiant, motDePasse);
		} catch (BLLException e) {
			message.append(e.getMessage());
		}
		HttpSession maSession=null;
		RequestDispatcher dispatcher = null;
		// Si la connexion est ok l'utilisateur n'est pas nul et donc peut entrer en session
		// Si non on recharge la page avec message erreur
		if(u!=null) {
			maSession = request.getSession();
			maSession.setAttribute("utilisateurConnecte", u);	
			dispatcher = request.getRequestDispatcher("./MesVentes");
		}else {
			request.setAttribute("messageErreur", message.toString());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		}
		dispatcher.forward(request, response);	
		
	}
	}

	


