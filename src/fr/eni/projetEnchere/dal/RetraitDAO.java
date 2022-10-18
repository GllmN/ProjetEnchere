package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Retrait;

public interface RetraitDAO {

	void ajoutRetrait(Retrait r)throws DALException;
}
