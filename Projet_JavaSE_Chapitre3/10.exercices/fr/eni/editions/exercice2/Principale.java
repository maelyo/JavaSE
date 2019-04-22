package fr.eni.editions.exercice2;

import java.time.Duration;

public class Principale {
	public static void main(String[] args) {
		Livre l;
		Dvd d;
		l = new Livre();
		l.setReference(100);
		l.setDesignation("Le Crabe aux pinces d'or");
		l.setPrix(8.5);
		l.setNbPages(86);
		l.setAuteur("Hergé");
		System.out.println(l.toString());

		d = new Dvd();
		d.setReference(110);
		d.setDesignation("La soupe aux choux");
		d.setPrix(19.50);
		d.setDuree(Duration.ofMinutes(98));
		d.setRealisateur("Girault");
		System.out.println(d.toString());

	}
}
