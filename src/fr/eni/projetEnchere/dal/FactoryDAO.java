package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.dal.jdbc.ArticleDAOImpl;
import fr.eni.projetEnchere.dal.jdbc.CategorieDAOImpl;
import fr.eni.projetEnchere.dal.jdbc.RetraitDAOImpl;
import fr.eni.projetEnchere.dal.jdbc.UtilisateurDAOImpl;

public abstract class FactoryDAO {
	
//Notre place pour Fabriquer nos Classes impl�ment�es ex Utilisateur(surrement) DAO qui cr��ra UtilisateurDAOJdbcImpl() 	

public static ArticleDAO getArticleDao() {
	return new ArticleDAOImpl();
}

public static UtilisateurDAO getUtilisateurDAO() {
	return new UtilisateurDAOImpl();
}
public static CategorieDAO getCategorieDAO() {
	return new CategorieDAOImpl();
}
public static RetraitDAO getRetraitDAO() {
	return new RetraitDAOImpl();
}
}
