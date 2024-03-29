package fr.eni.projetEnchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

	// Attributs
	private int noUtilisateur ;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;

	//possibilit� de mettre une liste d'encheres (lien 1 et * entre utilisateur>enchere)

	// Attribut d'association
	private List <ArticleVendu> articleVendu;

	// constructeur sans param�tre (java bean)
	public Utilisateur() {
		this.articleVendu=new ArrayList<ArticleVendu>();
	}
	
	// constructeur (inscription)
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = false;
	}

	// constructeur (sans article vendu)
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articleVendu = new ArrayList<ArticleVendu>();
	}
	
	// constructeur (modification compte)
	public Utilisateur(int noUtilisateur,String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}
	// constructeur (modification compte)
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}
//
//	// constructeur avec tous les param�tres 
//	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
//			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur, List<ArticleVendu>articleVendu) {
//		this(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
//		this.articleVendu = articleVendu;
//	}
//
//
//	// constructeur (utilisateur sans num�ro de t�l�phone) , cf NOT Null SQL
//	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String rue,
//			String codePostal, String ville, String motDePasse, int credit, boolean administrateur, List<ArticleVendu>articleVendu) {
//		this(noUtilisateur, pseudo, nom, prenom, email, email, rue, codePostal, ville, motDePasse, credit, administrateur);
//		this.noUtilisateur = noUtilisateur;
//		this.pseudo = pseudo;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.email = email;
//		this.rue = rue;
//		this.codePostal = codePostal;
//		this.ville = ville;
//		this.motDePasse = motDePasse;
//		this.credit = credit;
//		this.administrateur = administrateur;
//		this.articleVendu = articleVendu;
//	}




	// Assesseurs et mutateurs : 
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<ArticleVendu> getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(List<ArticleVendu> articleVendu) {
		this.articleVendu = articleVendu;
	}


	// M�thodes : 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [noUtilisateur=");
		builder.append(noUtilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append("]");
		return builder.toString();
	}












}
