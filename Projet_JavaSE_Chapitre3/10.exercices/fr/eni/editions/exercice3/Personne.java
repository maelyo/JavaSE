package fr.eni.editions.exercice3;

import java.time.LocalDate; 

public class Personne {
	private String nom;
	private String prenom;
	private LocalDate date_nais;

	public Personne() {
		super();
	}

	public Personne(String n, String p, LocalDate d) {
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

	public String toString() {
		return prenom + " " + nom;
	}

 } 
