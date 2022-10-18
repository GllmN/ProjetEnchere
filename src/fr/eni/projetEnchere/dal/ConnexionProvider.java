package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// Classe qui définit les méthodes permettant d'obtenir une connection du pool de connexion
// et de libérer la connexion et de la remettre dans le pool de connexion

public class ConnexionProvider {
	private static DataSource ds;

	// bloc d'initialisation
	static {
		InitialContext jndi;
		try {
			jndi = new InitialContext();
			ConnexionProvider.ds = (DataSource) jndi.lookup("java:comp/env/dsEnchere");
		} catch (NamingException e) {
			throw new RuntimeException("impossible d'acceder à la BDD");
		}
	}// Fin du bloc d'initialisation

	//Méthode permettant d'obtenir une connexion à la base de données via un pool de connexion
	public static Connection seConnecter() throws DALException {
		Connection cnx = null;
		//--> obtention de la connexion à la BDD à partir de la datasource
		try {
			cnx= ConnexionProvider.ds.getConnection();
		} catch (SQLException e) {
			throw new DALException("Impossible d'obtenir une connexion", e);
		}

		return cnx;
	}
	//Méthode permettant d'obtenir une connexion à la base de données via un pool de connexion
	public static void seDeconnecter(Connection cnx) throws DALException {
		try {
			if (cnx!= null) {
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de fermer la connexion", e);
		}
	}
	//Méthode permettant d'obtenir une connexion à la base de données via un pool de connexion
	public static void seDeconnecter(Statement stmt, Connection cnx) throws DALException {
		try {
			if (stmt!= null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de fermer le statement", e);
		}

		seDeconnecter(cnx);
	}

}

