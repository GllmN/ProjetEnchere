package fr.eni.projetEnchere.bll;


import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DALException;
import fr.eni.projetEnchere.dal.FactoryDAO;
import fr.eni.projetEnchere.dal.UtilisateurDAO;
/**
 * Classe BLL qui permet de cr�er une base unique d'Utilisateurs gr�ce au pattern Singleton
 * @author Brice Delphine Guillaume
 *
 */


// Class permettant de tester la confirmit� des utilisateurs avant leur transmission � la DAL
public class AnnuaireUtilisateurManager {

	private UtilisateurDAO daoUtilisateur;

	static AnnuaireUtilisateurManager annuaire;

	// Constructeur priv� pour mise en place du pattern Singleton	
	private AnnuaireUtilisateurManager() {
		this.daoUtilisateur = FactoryDAO.getUtilisateurDAO() ;
	}

	// M�thode pour cr�er une instance
	public static AnnuaireUtilisateurManager getInstance() {
		if(annuaire==null) {
			annuaire= new AnnuaireUtilisateurManager();
		}
		return annuaire;
	}

	/**
	 * Validation d'un utilisateur avant son inscription, son ajout dans la base
	 * @param Utilisateur avec les donn�es saisies dans le formulaire
	 * @return vrai selon plusieurs crit�res de validation d'inscription
	 * @throws BLLException si faux on envoie une exception pour message utilisateur dans IHM
	 */
	public boolean validerInscription(Utilisateur u) throws BLLException {
		StringBuilder messageErreur = new StringBuilder();
		boolean inscriptionValide = true;
		// R�gle m�tier :
		// L'utilisateur ne doit pas �tre null
		if(u==null)	{
			throw new BLLException("utilisateur est null");
		}
		// Le pseudo ne peut pas �tre vide et ne peut pas contenir d'espace
		if(u.getPseudo()==null || u.getPseudo().trim().isEmpty()) {
			messageErreur.append("Le pseudo est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}

		if(u.getNom()==null || u.getNom().isEmpty()) {
			messageErreur.append("Le nom est obligatoire\n");
			inscriptionValide = false;
		}

		if(u.getPrenom()==null || u.getPrenom().isEmpty()) {
			messageErreur.append("Le prenom est obligatoire\n");
			inscriptionValide = false;
		}

		// limiter la taille des caract�res � 20
		if(u.getEmail()==null || u.getEmail().trim().isEmpty()) {
			messageErreur.append("L'adresse email est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}

		if(u.getTelephone()==null || u.getTelephone().trim().isEmpty()) {
			messageErreur.append("Le numero de telephone est obligatoire et ne doit pas comporter d'espace\n");
			inscriptionValide = false;
		}

		if(u.getRue()==null || u.getRue().isEmpty()) {
			messageErreur.append("La rue est obligatoire\n");
			inscriptionValide = false;
		}

		// limiter la taille des caract�res � 5 et que des chiffres
		if(u.getCodePostal()==null || u.getCodePostal().trim().isEmpty()) {
			messageErreur.append("Le code postal est obligatoire et ne doit pas comporter d'espace\n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}

		if(u.getVille()==null || u.getVille().trim().isEmpty()) {
			messageErreur.append("\n Le nom de la ville est obligatoire et ne doit pas comporter d'espace\n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}

		if(u.getMotDePasse()==null || u.getMotDePasse().trim().isEmpty()) {
			messageErreur.append("Le mot de passe est obligatoire et ne doit pas comporter d'espace. \n");
			messageErreur.append("\n");
			inscriptionValide = false;
		}
		// Est ce que le email Existe d�j� ?

		try {
			if(daoUtilisateur.emailAlreadyExist(u.getEmail())) {
				// Gestion du cas de l'update utilisateur A  revoir :)
				//int id = daoUtilisateur.selectByPseudo(u.getPseudo()).getNoUtilisateur();
				//if(id!=u.getNoUtilisateur()) {
				messageErreur.append("Un utilisateur a d�j� cet email. Merci d'en renseigner un autre. \n");
				inscriptionValide=false;
			}//}
		} catch (DALException e1) {
			throw new BLLException(e1.getMessage());
		}
		//Est ce que le pseudo contient des caracteres alphanumeric a-z A-Z 0-9?
		if(!u.getPseudo().matches("^[A-Za-z0-9]+$")) {
			messageErreur.append("Saisir des chiffres et/ou des lettres dans le pseudo uniquement \n");
			inscriptionValide=false;
		}

		// Est ce que le pseudo Existe d�j� ?
		try {
			if(daoUtilisateur.selectByPseudo(u.getPseudo())!=null) {
				messageErreur.append("Ce pseudo est d�j� utilis�, merci d'en renseigner un autre. \n");
				inscriptionValide=false;
			}
		} catch (DALException e) {
			throw new BLLException("Pb pseudo "+ e.getMessage());
		}


		if(!inscriptionValide) {
			throw new BLLException(messageErreur.toString());
		}
		return inscriptionValide;
	}
	/**
	 * M�thode pour cr�er une nouvelle inscription si elle est valide 
	 * (appelle � la m�thode valider inscription)
	 * @param Utilisateur avec les donn�es saisies dans le formulaire
	 * @throws BLLException si non valide on envoie une exception pour message utilisateur dans IHM
	 */
	public void nouvelleInscription(Utilisateur u) throws BLLException{
		validerInscription(u);
		try {
			// Lien avec DAL
			this.daoUtilisateur.addUtilisateur(u);
		} catch (DALException e){
			throw new BLLException("Echec inscription utilisateur", e);
		}
	}
	/**
	 * M�thode permettant de chercher un utilisateur dans la base selon son pseudo
	 * * @param pseudo
	 * @return Utilisateur - si l'utilisateur n'existe pas il sera null
	 * @throws BLLException
	 */
	public Utilisateur getUtilisateur(String pseudo) throws BLLException {
		Utilisateur u= null;
		try {
			u = this.daoUtilisateur.selectByPseudo(pseudo);
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
		return u;
	}
	/**
	 * M�thode permettant de chercher un utilisateur dans la base selon son id
	 * * @param pseudo
	 * @return Utilisateur - si l'utilisateur n'existe pas il sera null
	 * @throws BLLException
	 */
	public Utilisateur getUtilisateur(int id) throws BLLException {

		Utilisateur u= null;
		try {
			u = this.daoUtilisateur.selectById(id);
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
		return u;
	}
	/**
	 * M�thode qui permet ou non de se connecter et d'entrer en session 
	 * * @param pseudo
	 * @param motDePasse
	 * @return Utilisateur (si on ne peut se connecter il sera null)
	 * @throws BLLException
	 */
	public Utilisateur testConnexion(String pseudo, String motDePasse) throws BLLException {
		Utilisateur u = null;
		boolean res = true;
		StringBuilder sb = new StringBuilder("Vous ne pouvez pas vous connecter : \n");
		if(pseudo==null||pseudo.trim().isEmpty()) {
			sb.append("Aucun Pseudo n'a �t� saisi");			
			res=false;
		}else if (motDePasse==null||motDePasse.trim().isEmpty()) {
			sb.append("Aucun Mot de passe n'a �t� saisi");
			res=false;
			// si champs mot de passe et pseudo ne sont pas vide
		}else {			
			// je r�cup�re l'utilisateur � partir du pseudo/identifiant
			u=getUtilisateur(pseudo);
			// je v�rifie que je r�cup�re un utilisateur
			if(u==null) {
				res=false;
				sb.append("Le pseudo saisi n'existe pas \n");
				// je v�rifie que le mot de passe de l'utilisateur recup�r� correspond � celui saisi	
			}else 
				if(u.getMotDePasse().equals(motDePasse)){
					res=true;
				}else {
					res=false;
					sb.append("Le mot de passe est erron� \n");
				}
		}// Fin des tests
		if(res!=true) {
			throw new BLLException(sb.toString());
		}
		return u;
	}
	/**
	 * M�thode pour mettre � jour des donn�es d'un utilisateur � notre application 
	 * * @param Utilisateur
	 * TODO Valider Inscription avec gestion email et pseudo d�j� existant dans la base
	 * @throws BLLException
	 */

	public void updateUtilisateur(Utilisateur u) throws BLLException {
		//validerInscription(u);// Pb Email et Pseudo A g�rer
		try {
			this.daoUtilisateur.upUtilisateur(u);
		} catch (DALException e) {
			throw new BLLException("Echec de la mise � jour du profil utilisateur", e);
		}

	}
	/**
	 * M�thode v�rifier mail existant 
	 * * @param email
	 * @return true = mail existe d�j� dans la base
	 * @throws BLLException
	 */

	public boolean verifierMail(String email) throws BLLException {
		boolean mailExistant = false;
		try {
			mailExistant = daoUtilisateur.emailAlreadyExist(email);
		} catch (DALException e1) {
			throw new BLLException(e1.getMessage());
		}
		return mailExistant;
	}

	
	
	
}



