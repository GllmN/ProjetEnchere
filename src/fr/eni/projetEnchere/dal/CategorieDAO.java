package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;

public interface CategorieDAO {

List <Categorie> selectAllCategorie()throws DALException ;
	
	
Categorie selectByNo(int noCategorie) throws DALException ;

}
