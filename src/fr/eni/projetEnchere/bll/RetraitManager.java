package fr.eni.projetEnchere.bll;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;
import fr.eni.projetEnchere.dal.RetraitDAO;

public class RetraitManager {

private RetraitDAO retraitDAO;
static RetraitManager retraitManager;	
	
	private RetraitManager() {
		retraitDAO=FactoryDAO.getRetraitDAO();
	}

	public static RetraitManager getInstance() {
		if(retraitManager==null) {
			retraitManager=new RetraitManager();
		}
		return retraitManager;
	}

	public boolean validerRetrait(Retrait r) throws BLLException {
		boolean res = true;
		StringBuilder sb = new StringBuilder("La validation du lieu de Retrait n'est pas possible\n");
		if(r==null) {
			res=false;
			sb.append("L'objet Retrait est null.\n");
		}else if(r.getRue()==null||r.getRue().trim().isEmpty()) {
			res=false;
			sb.append("Merci de préciser la rue.\n");
		}
		if(r.getCodePostal()==null||r.getCodePostal().trim().isEmpty()) {
			res=false;
			sb.append("Merci de préciser le code Postal.\n");
		}
		if(r.getVille()==null||r.getVille().trim().isEmpty()) {
			res=false;
			sb.append("Merci de préciser la ville.\n");
		}
		if(res==false) {
			throw new BLLException(sb.toString());
		}
		return res;
}
	public void ajouterRetrait(Retrait r) throws BLLException {
		validerRetrait(r);
		try {
			retraitDAO.ajoutRetrait(r);
		} catch (DALException e) {
			throw new BLLException("Echec Insertion Retrait"+e.getMessage());
		}
		
	}
}