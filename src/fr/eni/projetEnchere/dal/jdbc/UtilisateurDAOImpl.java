 package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projetEnchere.bll.AnnuaireUtilisateurManager;
import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	////////////////////////////////////////////ADDUTILISATEUR////////////////////////////////////////
	@Override
	public void addUtilisateur(Utilisateur u) throws DALException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		cnx = ConnexionProvider.seConnecter();
		try {		
			String requeteSQL = "INSERT into UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			// Etape : Création de la requête paramétrée et insertion des paramètres dans la requête
			pstmt = cnx.prepareStatement(requeteSQL, PreparedStatement.RETURN_GENERATED_KEYS);

			// Etape : Remplacer les ? (valoriser les parametres de la requete) 
			pstmt.setString(1, u.getPseudo());
			pstmt.setString(2, u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCodePostal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getMotDePasse());
			pstmt.setInt(10, u.getCredit());
			pstmt.setBoolean(11, false);

			//Exécution de la requête
			pstmt.executeUpdate();

			// récupération de la valeur de identity pour noUtilisateur
			ResultSet rs = pstmt.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Utilisateur
			if(rs.next()) {
				u.setNoUtilisateur(rs.getInt(1));
			}

			// fermeture de resultatset et du prepareStatement
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'ajout d'un utilisateur: " + u, e);
		}finally {
			ConnexionProvider.seDeconnecter(pstmt, cnx);
		}
	}

	////////////////////////////////////////////UPDATEUTILISATEUR////////////////////////////////////////
	@Override
	public boolean upUtilisateur(Utilisateur uMiseAJour) throws DALException, BLLException {
		AnnuaireUtilisateurManager annuaire = AnnuaireUtilisateurManager.getInstance();
		
		boolean res= false;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		cnx = ConnexionProvider.seConnecter();

		String requeteSQL ="UPDATE UTILISATEURS SET pseudo = ?,nom = ?,prenom = ?,email = ?,telephone = ?,rue = ?,code_postal = ?,ville = ?,mot_de_passe = ? WHERE no_utilisateur=?";
		//UPDATE UTILISATEURS SET pseudo = 'bavard',nom = 'Salmon',prenom = 'Gaek',email = '40687554',telephone ='',rue ='',code_postal ='',ville = '',mot_de_passe = 'coucou' WHERE no_utilisateur=3
		try {
			pstmt = cnx.prepareStatement(requeteSQL);
			// Etape : Remplacer les ? (valoriser les parametres de la requete) 
			pstmt.setString(1, uMiseAJour.getPseudo());
			pstmt.setString(2, uMiseAJour.getNom());
			pstmt.setString(3, uMiseAJour.getPrenom());
			pstmt.setString(4, uMiseAJour.getEmail());
			pstmt.setString(5, uMiseAJour.getTelephone());
			pstmt.setString(6, uMiseAJour.getRue());
			pstmt.setString(7, uMiseAJour.getCodePostal());
			pstmt.setString(8, uMiseAJour.getVille());
			pstmt.setString(9, uMiseAJour.getMotDePasse());
			pstmt.setInt(10, uMiseAJour.getNoUtilisateur());
			pstmt.executeUpdate();
			res=true;
		
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la mise à jour de l'utilisateur");
		}
		
		ConnexionProvider.seDeconnecter(pstmt,cnx);
		return res;
		
	}



	////////////////////////////////////////////DELETEUTILISATEUR////////////////////////////////////////
	public boolean delUtilisateur(Utilisateur uSuppression) throws DALException{
		boolean res= false;
		Connection cnx = null;
		PreparedStatement pstmt = null;
		cnx = ConnexionProvider.seConnecter();


		String requeteSQL= "DELETE from UTILISATEURS where no_utilisateur= ?";
		//DELETE from UTILISATEURS where no_utilisateur=1002
		try {
			pstmt = cnx.prepareStatement(requeteSQL);
			// Etape : Remplacer les ? (valoriser les parametres de la requete) 
			pstmt.setInt(1,uSuppression.getNoUtilisateur());
			pstmt.executeUpdate();
			res=true;
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la suppression du compte de l'utilisateur");
		}
		ConnexionProvider.seDeconnecter(pstmt,cnx);
		return res;


	}



	////////////////////////////////////////////SELECTBYPSEUDO////////////////////////////////////////
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		Connection cnx=null;
		PreparedStatement pstmt= null;
		cnx=ConnexionProvider.seConnecter();
		Utilisateur u2=null;

		//requete sql testee et fonctionnelle: affiche pseudo et mdp quand pseudo= qqch
		String requeteSQL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur "
				+ "FROM UTILISATEURS where pseudo= ?"; 
		try {
			pstmt= cnx.prepareStatement(requeteSQL);
			pstmt.setString(1,pseudo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				int numero= rs.getInt("no_utilisateur");
				String pseudo1 = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
				//on cree objet utilisateur ayant en parametres les éléments ci-dessus
				u2= new Utilisateur(numero,pseudo1,nom,prenom,email, telephone,rue,cp,ville,mdp,credit,admin);
			}
			// CLOSE de RS et PSTMT
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur dans les parametres de l'utilisateur: " + u2, e);
		}finally {
			ConnexionProvider.seDeconnecter(pstmt, cnx);
		}
		return u2;
	}

	@Override
	public boolean emailAlreadyExist(String email) throws DALException {
		String emailRecup="";
		Connection cnx=null;
		PreparedStatement pstmt= null;
		cnx=ConnexionProvider.seConnecter();
		String sql="select email from Utilisateurs where email=?";
		try {
			pstmt= cnx.prepareStatement(sql);
			pstmt.setString(1,email);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				emailRecup=rs.getString("email");
			}
			rs.close();
		} catch (SQLException e) {
			throw new DALException("Requête emailIsExist "+ e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstmt,cnx);
		}
		// Comparaison de l'email en paramètre et le l'email récupéré
		if(emailRecup.trim().equalsIgnoreCase(email)) {
			return true;
		}else
			return false;
	}

	public Utilisateur selectById(int id) throws DALException {
		Connection cnx=null;
		PreparedStatement pstmt= null;
		cnx=ConnexionProvider.seConnecter();
		Utilisateur u2=null;

		//requete sql testee et fonctionnelle: affiche pseudo et mdp quand pseudo= qqch
		String requeteSQL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur "
				+ "FROM UTILISATEURS where no_utilisateur= ?"; 
		try {
			pstmt= cnx.prepareStatement(requeteSQL);
			pstmt.setInt(1,id);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				int numero= rs.getInt("no_utilisateur");
				String pseudo1 = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
				//on cree objet utilisateur ayant en parametres les éléments ci-dessus
				u2= new Utilisateur(numero,pseudo1,nom,prenom,email, telephone,rue,cp,ville,mdp,credit,admin);
			}
			// CLOSE de RS et PSTMT
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur dans les parametres de l'utilisateur: " + u2, e);
		}finally {
			ConnexionProvider.seDeconnecter(pstmt, cnx);
		}
		return u2;
	}
}
