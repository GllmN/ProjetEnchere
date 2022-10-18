package fr.eni.projetEnchere.bll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class TestUtilisateurManagerV2
 */
@WebServlet("/TestUtilisateurManagerV2")
public class TestUtilisateurManagerV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
		//		String rue, String codePostal, String ville, String motDePasse) {
		
		
		
		AnnuaireUtilisateurManager a = AnnuaireUtilisateurManager.getInstance();
		
			try {
				Utilisateur u = new Utilisateur("---", "papin", "jean îerre", "rose@orange.fr", "060606", "4 rue", "44000", "nantes","coucou3");
				System.out.println(" pseudo "+u.getPseudo()+" nom "+u.getNom()+" prenom "+u.getPrenom()+" email "+u.getEmail()+" telephone "+
						u.getTelephone()+" rue "+u.getRue()+"code postal "+u.getCodePostal()+"ville "+u.getVille()+"m mot de passe "+u.getMotDePasse());
					
				
				System.err.println(a.validerInscription(u));
			} catch (BLLException e) {
				System.out.println(e.getMessage());
			}
		
	
		
		
	}

	

}
