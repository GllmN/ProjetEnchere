package fr.eni.projetEnchere.bll;

import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieDAO;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	static CategorieManager catalogue;
	
	//Le constructeur Singleton et sa m�thode getInstance
	
	private CategorieManager() {
		categorieDAO= FactoryDAO.getCategorieDAO();
	}
	public static CategorieManager getInstance() {
		if(catalogue==null) {
			catalogue=new CategorieManager();
		}
		return catalogue;
	}
	// Les m�thodes
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
			throw new BLLException("Pb M�thode"+e.getMessage());
		}
		return c;
	}
	
	
}
