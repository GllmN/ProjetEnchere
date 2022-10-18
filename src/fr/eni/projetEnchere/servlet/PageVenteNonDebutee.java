package fr.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Les champs sont d�j� remplis mais la date de d�but n'est pas arriv�: ici date le 5/08 et ench�re d�bute le 10/08-->10/09

@WebServlet(name ="PageVenteNonDebutee",
value = {"/nouvelleVente"})


public class PageVenteNonDebutee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PageVenteNonDebutee() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageventenondebutee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
