package fr.eni.projetEnchere.dal.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.UtilisateurDAO;

@WebServlet("/TestUtilisateurJdbcImpl")
public class TestUtilisateurDAOImpl extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Utilisateur u1 = new Utilisateur("Renelataupe","René","Brice","deux@laposte.net","0610203040","4 rue du soleil", "44000","Nantes","lataupe",0);
//		UtilisateurDAO u = new UtilisateurDAOImpl();
//		
////		try {
////			u.addUtilisateur(u1);
////			System.out.println("J'ai créer un article sans retrait");
////			} catch (DALException e) {
////			System.out.println(e.getMessage());
////			}
////	}
////
////	
//	
//	//Appel a la methode dans le doget?
//	
//	UtilisateurDAOImpl utilisateurdaoimpl = new UtilisateurDAOImpl();
//	try {
//		Utilisateur u2= utilisateurdaoimpl.selectByPseudo("tSalmon");
//		System.out.println(u2);
//	} catch (DALException e) {
//		System.out.println(e.getMessage());
//	}
//}
//	
	
//	Utilisateur u3 = new Utilisateur(12, "Gui4444", "Neau", "Guillaume", "email@kk", "0000", "4 rue", "444000", "Nnatre", "5555", 300000000, false);
//	UtilisateurDAOImpl utilisateurdaoimpl = new UtilisateurDAOImpl();
//	try {
//		utilisateurdaoimpl.upUtilisateur(u3);
//	} catch (DALException e) {
//		System.out.println(e.getStackTrace());
//		e.printStackTrace();
//	}

	
	// =================> A TOI BRICE <============================
	// Test selectByPseudo
	// =================> A TOI BRICE <============================
	
//	String email="rose@orange.com";
//	try {
//		System.out.println(utilisateurdaoimpl.emailAlreadyExist(email));
//		System.out.println("emailexist");
//	} catch (DALException e) {
//		System.out.println("emailexist pas");
//	}
	
	
}
}
