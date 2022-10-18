package fr.eni.projetEnchere.dal;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConnection
 */
@WebServlet("/TestConnection")
public class TestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connexion = null;
		try {
			connexion=ConnexionProvider.seConnecter();
			response.getWriter().append("Connection avec Base Ench�re ok");
		} catch (DALException e) {
			response.getWriter().append("Pas de connection avec la base Ench�re").append("\n").append(e.getMessage());
		}finally {
			try {
				ConnexionProvider.seDeconnecter(connexion);
			} catch (DALException e) {
				response.getWriter().append("Probl�me Lib�ration de connection avec la base Ench�re").append("\n").append(e.getMessage());
			}
		}

	}



}
