package fr.eni.editions.exercice2;

import java.time.Duration;

public class Dvd extends Article {
	private Duration duree;
	private String realisateur;

	public Dvd() {
		super();
	}

	public Dvd(int reference, String designation, double prix, Duration duree, String realisateur) {
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

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String toString() {
		return super.toString() + " " + getDuree().toMinutes() + " " + getRealisateur();
	}
}
