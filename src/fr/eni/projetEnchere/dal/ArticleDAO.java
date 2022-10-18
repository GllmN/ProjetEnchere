package fr.eni.projetEnchere.dal;

import java.util.HashMap;
import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;

public interface ArticleDAO {

void nouvelleVente(ArticleVendu a, Utilisateur u,Categorie c,Retrait r) throws DALException;

HashMap<ArticleVendu,Integer>selectArticlesByCategorieNom(int categorie,String nom)throws DALException;
	
}
