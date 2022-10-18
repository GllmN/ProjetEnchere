package fr.eni.projetEnchere.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class TestUtilisateurManager
 */
@WebServlet("/TestUtilisateurManager")
public class TestUtilisateurManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
//		Utilisateur u1 = new Utilisateur("","","","","","", "","","",0);
//		try {
//			System.out.println(annuaire.validerInscription(u1));
//			annuaire.nouvelleInscription(u1);
//		} catch (BLLException e) {
//			System.out.println(e.getMessage());
//		}
		
//		Utilisateur u = new Utilisateur(12, "jp", "jean-pierre", "papin", "jpp44@orange.fr", "060606", "4", "440000", "nantes", "000");
//		try {
//			annuaire.updateUtilisateur(u);
//		} catch (BLLException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		try {
			System.out.println(annuaire.verifierMail("noo@gmail.com"));
		} catch (BLLException e) {
			System.out.println(e.getMessage());
		}
	}
}
