package fr.eni.projetEnchere.bll;

public class BLLException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BLLException() {
		super();
	}
	// constructeur surchargé (avec Message)
	public BLLException(String message) {
		super(message);
	}
	// constructeur surchargé (Avec Message et l'exception Maman
	public BLLException(String message, Throwable cause) {
		super(message, cause);
	}
	//Methode qui redefinie la methode getMessage() de la classe Throwable
	// permettant de specialiser l'affichage du message d'erreur 
	@Override
	public String getMessage() {
		StringBuilder sb =new StringBuilder();
		sb.append(super.getMessage());
		return sb.toString();
	}
	

}
