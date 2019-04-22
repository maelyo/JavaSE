package fr.eni.editions.collections;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSetEnsemble {
	public static void main(String[] args) {
		HashSet<Personne> acteurs;
		HashSet<Personne> chanteurs;
		acteurs = new HashSet<Personne>();
		chanteurs = new HashSet<Personne>();

		// création des personnes pour remplir la liste
		Personne p1, p2, p3, p4, p5;
		p1 = new Personne("Wayne", "John", LocalDate.of(1907, 5, 26));
		p2 = new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24));
		p3 = new Personne("Lennon", "John", LocalDate.of(1940, 10, 9));
		p4 = new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3));
		p5 = new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19));

		acteurs.add(p1);
		acteurs.add(p2);
		acteurs.add(p4);
		acteurs.add(p5);

		chanteurs.add(p1);
		chanteurs.add(p3);

		// test si les chanteurs sont également acteurs
		if (acteurs.containsAll(chanteurs))
			System.out.println("tous les chanteurs sont aussi acteurs");
		else
			System.out.println("certains chanteurs ne sont pas aussi acteurs");
		System.out.println("******* les artistes *****************");
		// création d'un HashSet artistes contenant chanteurs
		// et acteurs
		HashSet<Personne> artistes;
		artistes = new HashSet<Personne>(chanteurs);
		artistes.addAll(acteurs);
		// parcours du premier HashSet des artistes
		Iterator<Personne> it;
		it = artistes.iterator();
		// tant qu'il reste des éléments dans le HashSet
		Personne p;
		while (it.hasNext()) {
			// récupération de l'élément courant
			p = it.next();
			System.out.println(p.getNom());
		}
		System.out.println("***** chanteurs et acteurs *******************");
		// création d'un HashSet des personnes qui sont
		// chanteurs et acteurs

		HashSet<Personne> act_chant;
		act_chant = new HashSet<Personne>(chanteurs);
		act_chant.retainAll(acteurs);
		it = act_chant.iterator();
		// tant qu'il reste des éléments dans le HashSet
		while (it.hasNext()) {
			// récupération de l'élément courant
			p = it.next();
			System.out.println(p.getNom());
		}
		System.out.println("***** chanteurs uniquement *******************");
		// création d'un HashSet des personnes
		// uniquement acteurs
		HashSet<Personne> uniquementChanteurs;
		uniquementChanteurs = new HashSet<Personne>(chanteurs);
		uniquementChanteurs.removeAll(acteurs);
		for (Personne pe : uniquementChanteurs) {
			System.out.println(pe.getNom());
		}

		System.out.println("***** acteurs uniquement *******************");
		// création d'un HashSet des personnes
		// uniquement acteurs
		HashSet<Personne> uniquementActeurs;
		uniquementActeurs = new HashSet<Personne>(acteurs);
		uniquementActeurs.removeAll(chanteurs);
		for (Personne pe : uniquementActeurs) {
			System.out.println(pe.getNom());
		}

	}
}
