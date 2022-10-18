package fr.eni.projetEnchere.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;



public class ArticleVendu {

	// Attributs
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime dateHeureDebutEncheres;
	private LocalDateTime dateHeureFinEncheres;	
	private int miseAPrix;
	private int prixVente;
	// Type à valider avec Gregory (enchères non débuté, enchère en cours, enchère cloturé ???)
	private int etatVente;    //pas un boolean, on a cree une classe EtatVente avc 3 attributs
	private Retrait lieuRetrait = null;
	private Categorie categorie;
	private List<Enchere> listeEncheres;



	// si le lieu de retrait est l'adresse de l'utilisateur (vendeur), valeur = null

	// constructeur avec les parametres suivants :  nomArticle, description, dateDebutEncheres,dateFinEncheres,  miseAPrix,  Categorie 
	public ArticleVendu(String nomArticle, String description, LocalDateTime dateHeureDebutEncheres,
			LocalDateTime dateHeureFinEncheres, int miseAPrix,  Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
		this.dateHeureFinEncheres = dateHeureFinEncheres;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		
	}


	// constructeur vide (java bean)
	public ArticleVendu() {
		//setEtatVente();
		this.listeEncheres = new ArrayList<Enchere>();
	}


	// constructeur (sans prix de vente et mise à prix = DON)
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateHeureDebutEncheres,
			LocalDateTime dateHeureFinEncheres, int etatVente, Retrait retrait, Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
		this.dateHeureFinEncheres = dateHeureFinEncheres;
		this.etatVente = etatVente;
		this.lieuRetrait = retrait;
		this.categorie = categorie;
		this.listeEncheres = new ArrayList<Enchere>();
		
	}


	// Assesseurs et mutateurs :

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateHeureDebutEncheres() {
		return dateHeureDebutEncheres;
	}

	public void setDateHeureDebutEncheres(LocalDateTime dateHeureDebutEncheres) {
		this.dateHeureDebutEncheres = dateHeureDebutEncheres;
	}

	public LocalDateTime getDateHeureFinEncheres() {
		return dateHeureFinEncheres;
	}

	public void setDateHeureFinEncheres(LocalDateTime dateHeureFinEncheres) {
		this.dateHeureFinEncheres = dateHeureFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getEtatVente() {
		int etatVente=3;
		LocalDateTime dateDuJour = LocalDateTime.now();
		if(dateDuJour.isBefore(dateHeureFinEncheres)&&dateDuJour.isAfter(dateHeureDebutEncheres)) {
			etatVente=EtatVente.EN_COURS;
		}else if(dateDuJour.isAfter(dateHeureFinEncheres)) {
			etatVente=EtatVente.TERMINEE;
		}else if(dateDuJour.isBefore(dateHeureDebutEncheres)) {
			etatVente=EtatVente.NON_DEBUTEE;
		}
	if(etatVente==3) {
		System.out.println("pb etat vente");
	}
	return etatVente;
	}
		

	
	public void setEtatVente(int monEtatVente) {
	this.etatVente=monEtatVente;
	}
	
	public Retrait getRetrait() {
		return lieuRetrait;
	}


	public void setRetrait(Retrait retrait) {
		this.lieuRetrait = retrait;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}


	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	//Méthodes :
	// TODO : met on retrait dans l'article vendu dans le string builder?
	// met on categorie dans l'article vendu dans le string builder?
	// met on listeEncheres dans l'article vendu dans le string builder?
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateHeureDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateHeureFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", catagorie");
		builder.append(categorie);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append("]");
		return builder.toString();
	}



}
