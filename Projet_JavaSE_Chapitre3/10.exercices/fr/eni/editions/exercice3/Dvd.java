package fr.eni.editions.exercice3;

import java.time.Duration;

public class Dvd extends Article {
	private Duration duree;
	private Personne realisateur;

	public Dvd() {
		super();
	}

	public Dvd(int reference, String designation, double prix, Duration duree, Personne realisateur) {
		super(reference, designation, prix);

		setDuree(duree);
		setRealisateur(realisateur);
	}

	public Duration getDuree() {
		return duree;
	}

	public void setDuree(Duration duree) {
		this.duree = duree;
	}

	public Personne getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Personne realisateur) {
		this.realisateur = realisateur;
	}

	public String toString() {
		return super.toString() + " " + getDuree().toMinutes() + " " + getRealisateur();
	}
}
