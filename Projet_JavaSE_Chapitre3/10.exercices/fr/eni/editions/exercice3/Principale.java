package fr.eni.editions.exercice3;

import java.time.Duration; 
import java.time.LocalDate;

public class Principale {
	public static void main(String[] args) {
		Livre l;
		Dvd d;
		l = new Livre();
		l.setReference(100);
		l.setDesignation("Le Crabe aux pinces d'or");
		l.setPrix(8.5);
		l.setNbPages(86);
		l.setAuteur(new Personne("Hergé", "Georges", LocalDate.of(1907, 05, 22)));
		testLivre(l);
		System.out.println(l.toString());

		d = new Dvd();
		d.setReference(110);
		d.setDesignation("La soupe aux choux");
		d.setPrix(19.50);
		d.setDuree(Duration.ofMinutes(98));
		d.setRealisateur(new Personne("Girault", "jean", LocalDate.of(1924, 05, 9)));
		testDvd(d);
		System.out.println(d.toString());

	}

	public static void test(Article a) {
		System.out.println("reference : " + a.getReference());
		System.out.println("designation : " + a.getDesignation());
		System.out.println("prix : " + a.getPrix() + " €");
	}

	public static void testLivre(Livre l) {
		test(l);
		System.out.println("nombre de pages : " + l.getNbPages());
		System.out.println("auteur : " + l.getAuteur().toString());
	}

	public static void testDvd(Dvd d) {
		test(d);
		System.out.println("durée : " + d.getDuree().toMinutes() + " minutes");
		System.out.println("réalisateur : " + d.getRealisateur().toString());
	}
 }
