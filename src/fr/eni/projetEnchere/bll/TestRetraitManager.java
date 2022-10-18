package fr.eni.projetEnchere.bll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Retrait;

/**
 * Servlet implementation class TestRetraitManager
 */
@WebServlet("/TestRetraitManager")
public class TestRetraitManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Retrait r = new Retrait("","  ","  ");
		RetraitManager rm = RetraitManager.getInstance();
		try {
			rm.ajouterRetrait(r);
		} catch (BLLException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
