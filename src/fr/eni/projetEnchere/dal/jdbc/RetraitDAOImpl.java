package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO{

	private static final String INSERT="Insert into retraits (rue,code_postal,ville) values(?,?,?)";
	
	@Override
	public void ajoutRetrait(Retrait r) throws DALException {
		PreparedStatement pstatement=null;
		Connection cnx = ConnexionProvider.seConnecter();
		try {
			pstatement=cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			pstatement.setString(1, r.getRue());
			pstatement.setString(2, r.getCodePostal());
			pstatement.setString(3, r.getVille());
			// Exécution de la requête
			pstatement.executeUpdate();
			//récupération de la valeur de identity pour noRetrait
			ResultSet rs = pstatement.getGeneratedKeys();
			// Chargement de la valeur dans l'objet Retrait
			if(rs.next()) {
				r.setNoRetrait(rs.getInt(1));
			}
			// fermeture de resultset et du prepareStatement
			rs.close();
		} catch (SQLException e) {
			new DALException("Problème Insertion Retrait"+e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstatement, cnx);
		}// Fin du finally

	}

}
