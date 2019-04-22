package fr.eni.editions.exercice4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personne {
	private String nom;
	private String prenom;
	private LocalDate date_nais;
	private ArrayList<Article> oeuvres;

	public Personne() {
		super();
		oeuvres = new ArrayList<>();
	}

	public Personne(String n, String p, LocalDate d) {
		this();
		this.nom = n;
		this.prenom = p;
		this.date_nais = d;
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

	public LocalDate getDate_nais() {
		return date_nais;
	}

	public void setDate_nais(LocalDate date_nais) {
		this.date_nais = date_nais;
	}

	public ArrayList<Article> getOeuvres() {
		return oeuvres;
	}

	public String toString() {
		return prenom + " " + nom;
	}
}

