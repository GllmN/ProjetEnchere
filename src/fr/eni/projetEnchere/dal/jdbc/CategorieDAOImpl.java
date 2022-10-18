package fr.eni.projetEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieDAO;
import fr.eni.projetEnchere.dal.ConnexionProvider;
import fr.eni.projetEnchere.dal.DALException;

public class CategorieDAOImpl implements CategorieDAO{

	private static final String SELECTBYNOCATEGORIE="select no_categorie,libelle from categories where no_categorie=?";
	private static final String SELECTALL="select no_categorie,libelle from categories";
	
	@Override
	public List<Categorie> selectAllCategorie() throws DALException {
		List<Categorie> categories = new ArrayList<Categorie>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection cnx= ConnexionProvider.seConnecter();
		try {
			pstmt=cnx.prepareStatement(SELECTALL);
			rs=pstmt.executeQuery();
			Categorie c;
			while(rs.next()) {
				c=new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"));
				categories.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			throw new DALException("Pb select All categorie"+e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(pstmt,cnx);
		}
			return categories;	
		}
	
	@Override
	public Categorie selectByNo(int noCategorie) throws DALException {
		Categorie cat=null;
		PreparedStatement ppst=null;
		Connection cnx = ConnexionProvider.seConnecter();
		ResultSet rs;
		
		try {
			ppst=cnx.prepareStatement(SELECTBYNOCATEGORIE);
			ppst.setInt(1, noCategorie);
			rs=ppst.executeQuery();
			if(rs.next()) {
				cat=new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"));
			}
			rs.close();
			
			
		} catch (SQLException e) {
			throw new DALException("erreur dans selectCategorie"+e.getMessage());
		}finally {
			ConnexionProvider.seDeconnecter(ppst,cnx);}
		return cat;
	
	
	}
	
}
