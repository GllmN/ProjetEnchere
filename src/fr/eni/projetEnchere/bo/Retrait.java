package fr.eni.projetEnchere.bo;

public class Retrait {

	// Attributs
	private int noRetrait;
	private String rue;
	private String codePostal;
	private String ville;


	// Constructeur sans paramêtre
	public Retrait() {
	}


	// Constructeur
	public Retrait(int noRetrait, String rue, String codePostal, String ville) {
		this.noRetrait=noRetrait;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	// Constructeur
	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// Assesseurs et mutateurs :
	
	public String getRue() {
		return rue;
	}

	public int getNoRetrait() {
		return noRetrait;
	}


	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	//Méthodes :

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}




}
