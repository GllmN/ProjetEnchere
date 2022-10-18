package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleDAO;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;


public class ArticleDAOImpl implements ArticleDAO {

	private static final String INSERT="INSERT into ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie,no_Retrait) values(?,?,?,?,?,?,?,?)";
	private static final String SELECT="select no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,no_retrait from ARTICLES_VENDUS where nom_article like ? and no_categorie=?";
	/**
	 * méthode qui permet de créer un nouvelle articles selon Article/Utilisateur/Catégorie et Retrait
	 */
	@Override
	public void nouvelleVente(ArticleVendu a, Utilisateur u,Categorie c,Retrait r) throws DALException {

		if(a==null) {
			throw new DALException("Pas d'Articles en parametre");
		}
		PreparedStatement pstatement=null;
		Connection cnx = ConnexionProvider.seConnecter();
		try {
			// Création de la requête paramétrée et "insertion" des paramètres dans la requête
			pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, a.getNomArticle());
			pstatement.setString(2, a.getDescription());
			pstatement.setTimestamp(3, Timestamp.valueOf(a.getDateHeureDebutEncheres()));
			pstatement.setTimestamp(4, Timestamp.valueOf(a.getDateHeureFinEncheres()));
			pstatement.setInt(5, a.getMiseAPrix());
			pstatement.setInt(6, u.getNoUtilisateur());
			pstatement.setInt(7,c.getNoCategorie());
			if(r!=null) {
				pstatement.setInt(8, r.getNoRetrait());
			}else {
				pstatement.setNull(8, Types.INTEGER);
			}
			// Exécution de la requête
			pstatement.executeUpdate();
			//récupération de la valeur de identity pour noArticle
			ResultSet rs = pstatement.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Article
			if(rs.next()) {
				a.setNoArticle(rs.getInt(1));
			}
			// fermeture de resultset et du prepareStatement
			rs.close();

		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstatement,cnx);
		}
	}


	/**
	 * Méthode qui permet de Rechercher les articles selon la catégories et une partie du nom
	 * Elle renvoie une HashMap avec id du Vendeur et l'article en question
	 */
	public HashMap <ArticleVendu,Integer> selectArticlesByCategorieNom(int noCategorie,String nom) throws DALException{
		HashMap <ArticleVendu,Integer> resultat= new HashMap<ArticleVendu,Integer>();
		PreparedStatement pstatement=null;
		ResultSet rs;
		Connection cnx = ConnexionProvider.seConnecter();
		CategorieDAOImpl cat= new CategorieDAOImpl();
		UtilisateurDAOImpl uti = new UtilisateurDAOImpl();
		try {
			pstatement=cnx.prepareStatement(SELECT);
			pstatement.setString(1,"%"+nom+"%");
			pstatement.setInt(2,+noCategorie);
			ArticleVendu articleCourant= new ArticleVendu();
			Utilisateur utilisateurCourant = new Utilisateur();
			rs = pstatement.executeQuery();

			// Chargement de la valeur dans l'objet ArticleCourant
			while(rs.next()) {
				//Changer Article à chaque tour de manège
				if(rs.getInt("no_article")!=articleCourant.getNoArticle()) {
					articleCourant=new ArticleVendu();
					articleCourant.setNoArticle(rs.getInt("no_article"));
					articleCourant.setNomArticle(rs.getString("nom_article"));
					articleCourant.setDescription(rs.getString("description"));
					articleCourant.setDateHeureDebutEncheres(rs.getTimestamp("date_debut_encheres").toLocalDateTime());
					articleCourant.setDateHeureFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime());
					articleCourant.setMiseAPrix(rs.getInt("prix_initial"));
					articleCourant.setPrixVente(rs.getInt("prix_vente"));
					articleCourant.setCategorie(new Categorie(rs.getInt("no_categorie"),cat.selectByNo(rs.getInt("no_categorie")).getLibelle()));
					//Finalement je ne récupère pas retrait car j'en ai pas besoin
					resultat.put(articleCourant,rs.getInt("no_utilisateur"));

				}

			}
			rs.close();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstatement,cnx);
		}

		return resultat;

	}

}
