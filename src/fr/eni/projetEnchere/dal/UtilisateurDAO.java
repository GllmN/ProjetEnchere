package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bll.BLLException;
import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur selectByPseudo(String pseudo) throws DALException;
	Utilisateur selectById(int pseuid) throws DALException;
	void addUtilisateur(Utilisateur u) throws DALException;
	boolean upUtilisateur(Utilisateur uMiseAJour) throws DALException,BLLException;;
	boolean delUtilisateur(Utilisateur uSuppression) throws DALException; 
	boolean emailAlreadyExist( String email) throws DALException;

		
	
	// ajout delete= done ligne 11 + liste utilisateur




}
