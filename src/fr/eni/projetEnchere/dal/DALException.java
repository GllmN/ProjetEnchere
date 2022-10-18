package fr.eni.projetEnchere.dal;

public class DALException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DALException() {
		super();
	}
	// constructeur surchargé (avec Message)
	public DALException(String message) {
		super(message);
	}
	// constructeur surchargé (Avec Message et l'exception Maman
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}
	//Methode qui redefinie la methode getMessage() de la classe Throwable
	// permettant de specialiser l'affichage du message d'erreur 
	@Override
	public String getMessage() {
		StringBuilder sb =new StringBuilder();
		sb.append("Couche DAL - "+super.getMessage());
		return sb.toString();
	}
	
}
