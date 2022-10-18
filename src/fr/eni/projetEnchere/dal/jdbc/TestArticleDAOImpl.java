package fr.eni.projetEnchere.dal.jdbc;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.CategorieDAO;
import fr.eni.projetEnchere.dal.DALException;


/**
 * Servlet implementation class TestArticleDAOImpl
 */
@WebServlet("/TestArticleDAOImpl")
public class TestArticleDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u1=new Utilisateur(2,"tSalmon","Salmon","Titouan","titouan@gmail.com","0685445454","4 rue eglise","13100","Les Milles","coucou2",15,false);
		Categorie cat1=new Categorie(1,"INFORMATIQUE");
//		//ArticleVendu a1=new ArticleVendu("Ordinateur Portable","Philips",LocalDate.of(2021,02, 25),LocalDate.of(2021,02, 28),100,cat1);//utilisateur ?
		ArticleDAOImpl a = new ArticleDAOImpl();

// Test 1 Création d'une vente sans classe Retrait		
//		try {
//			a.nouvelleVente(a1, u1,cat1,null);
//			System.out.println("J'ai créer un article sans retrait");
//		} catch (DALException e) {
//			System.out.println(e.getMessage());
//		}
		
		// Test 2 Création d'une vente avec classe Retrait			
//		Retrait retrait1 = new Retrait(1,"rue des Peupliers","13000","Aix en Provence");
//		ArticleVendu a2=new ArticleVendu("Imprimante","LaserJet Pro",LocalDate.of(2021,02, 26),LocalDate.of(2021,03, 29),120,cat1);
//		try {
//			a.nouvelleVente(a2, u1,cat1,retrait1);
//			System.out.println("J'ai créer un article avec retrait");
//		} catch (DALException e) {
//			System.out.println(e.getMessage());
//		}		
		// Test 3 Création d'une vente avec classe Retrait à null
//		ArticleVendu a3=new ArticleVendu("Souris","Verte",LocalDateTime.of(2021,02,18,13,5),LocalDateTime.of(2021,02,19,13,5),5,cat1);
//	
//		try {
//		a.nouvelleVente(a3, u1,cat1,null);
//			System.out.println("J'ai créé un article sans retrait");
//		} catch (DALException e) {
//			System.out.println(e.getMessage());
//		}
//	
//	try {
//		System.out.println(a.selectByNo(1));
//	} catch (DALException e) {
//		System.out.println("eh merdre");	}
//	}
//	
//		List <Categorie> liste=new ArrayList<>();
//		CategorieDAO cat = new CategorieDAOImpl();
//		try {
//			liste =cat.selectAllCategorie();
//		} catch (DALException e) {
//			System.out.println(e);
//		}
//		for (Categorie c : liste) {
//			System.out.println(c);			
//		}
	
//	Retrait r = new Retrait("avenue des franciscains","44300","Nantes");
//	RetraitDAOImpl dao = new RetraitDAOImpl();
//	try {
//		dao.ajoutRetrait(r);
//		
//	} catch (DALException e) {
//		System.out.println(e);
//	}
	
		ArticleDAOImpl ad = new ArticleDAOImpl();
		HashMap <ArticleVendu,Integer> resultat= new HashMap<ArticleVendu,Integer>();
	
			try {
				resultat=ad.selectArticlesByCategorieNom(1,"");
			} catch (DALException e) {
				System.out.println(e.getMessage());
			}
	for(HashMap.Entry<ArticleVendu,Integer> monEntree : resultat.entrySet()) {
		System.out.println(monEntree.getKey());
		System.out.println("Vendeur :"+monEntree.getValue());
	}
			
	}
	}


