package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieDAO;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	static CategorieManager catalogue;
	
	//Le constructeur Singleton et sa méthode getInstance
	
	private CategorieManager() {
		categorieDAO= FactoryDAO.getCategorieDAO();
	}
	public static CategorieManager getInstance() {
		if(catalogue==null) {
			catalogue=new CategorieManager();
		}
		return catalogue;
	}
	// Les méthodes
	public List<Categorie>getCategories() throws BLLException{
		try {
			return categorieDAO.selectAllCategorie();
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
	}
	public Categorie getCategorieParId(int idCategorie) throws BLLException{
		Categorie c =null;
		try {
			c=categorieDAO.selectByNo(idCategorie);
		} catch (DALException e) {
			throw new BLLException("Pb Méthode"+e.getMessage());
		}
		return c;
	}
	
	
}
