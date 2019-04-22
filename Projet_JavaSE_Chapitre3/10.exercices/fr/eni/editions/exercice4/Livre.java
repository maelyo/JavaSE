package fr.eni.editions.exercice4;

import java.util.ArrayList;

public class Livre extends Article {
	private String isbn;
	private int nbPages;
	private Personne auteur;

	public Livre() {
		super();
	}

	public Livre(int reference, String designation, double prix, String isbn, int nbPages, Personne auteur) {
		super(reference, designation, prix);
		setIsbn(isbn);
		setNbPages(nbPages);
		setAuteur(auteur);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public Personne getAuteur() {
		return auteur;
	}

	public void setAuteur(Personne auteur) {
		// si l'œuvre appartenait à un autre auteur
		// alors je la retire de la liste de cet ancien auteur
		if (this.auteur != null) {
			this.auteur.getOeuvres().remove(this);
		}
		this.auteur = auteur;
		ArrayList<Article> lst;
		lst = auteur.getOeuvres();
		if (!lst.contains(this)) {
			lst.add(this);
		}
	}

	public String toString() 
     { 
         return super.toString() + " " + getNbPages() + " " + getAuteur(); 
     }

}
