package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bll.AnnuaireArticleManager;
import fr.eni.projetEnchere.bll.AnnuaireUtilisateurManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bll.CategorieManager;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletDemarrage
 * 
 * pas de web xml cree donc j'ai realise un parametrage par annotation pour lier la sevletdemarrage a la jsp index.jsp
 */

@WebServlet(name ="Accueil",
value = {"/ListesDesEncheres"})


public class ServletDemarrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Categorie> categories;
	CategorieManager cat ;  
  	
	@Override
	public void init() throws ServletException {
	
		CategorieManager cat = CategorieManager.getInstance();
		StringBuilder messageerreur = new StringBuilder();
		try {
			this.categories=cat.getCategories();
		} catch (BLLException e) {
			System.out.println(messageerreur.append("Je n'arrive pas à récupérer les Categories"));;
		}
		// Je met ces catégorie dans le contexte global
		this.getServletContext().setAttribute("categories", categories);
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuaireArticleManager annuaire = AnnuaireArticleManager.getInstance();
		//on s'assure que tomcat decodera les informations reçues avc le coade utf-8
		request.setCharacterEncoding("UTF-8");
		//recuperation ds parametre identifiant et vérification que le champs est rempli
		int categorie = Integer.parseInt(request.getParameter("scategorie"));
		System.out.println(categorie);
		String nom = request.getParameter("srecherche");
		System.out.println(nom);
		StringBuilder sb = new StringBuilder();
		HashMap<ArticleVendu,Utilisateur>listeAvecUtilisateur = new HashMap<ArticleVendu,Utilisateur>();
			
		try {
			listeAvecUtilisateur=annuaire.afficherVenteEnCours(categorie, nom);
		} catch (BLLException e) {
			sb.append(e);
		}
		RequestDispatcher disp=null;
		if(listeAvecUtilisateur!=null) {
			request.setAttribute("listeArticles",listeAvecUtilisateur);
			disp = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		}else {
			sb.append("Aucun Article pour votre recherche.");
			request.setAttribute("message",sb.toString());
			disp = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		}
		disp.forward(request, response);
	}

}
