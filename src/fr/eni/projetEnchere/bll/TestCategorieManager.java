package fr.eni.projetEnchere.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEnchere.bo.Categorie;

/**
 * Servlet implementation class TestCategorieManager
 */
@WebServlet("/TestCategorieManager")
public class TestCategorieManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie>categories = new ArrayList<Categorie>();
	CategorieManager categorieManager = CategorieManager.getInstance();
	try {
		categories=categorieManager.getCategories();
	} catch (BLLException e) {
		System.out.println("pb"+e.getMessage());
	}
	for (Categorie categorie : categories) {
		System.out.println(categorie);
	}	
		
	}

	

}
