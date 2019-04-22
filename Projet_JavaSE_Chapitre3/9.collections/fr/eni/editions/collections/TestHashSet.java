package fr.eni.editions.collections;

import java.time.LocalDate; 
import java.util.ArrayList; 
import java.util.HashSet; 
import java.util.Iterator; 
import java.util.ListIterator;

public class TestHashSet {
	public static void main(String[] args) {
		HashSet<Personne> hash1;
		HashSet<Personne> hash2;
		// création des deux instances
		hash1 = new HashSet<Personne>();
		hash2 = new HashSet<Personne>();

		// création des personnes pour remplir le HashSet
		Personne p1, p2, p3, p4, p5;
		p1 = new Personne("Wayne", "John", LocalDate.of(1907, 5, 26));
		p2 = new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24));
		p3 = new Personne("Lennon", "John", LocalDate.of(1940, 10, 9));
		p4 = new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3));
		p5 = new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19));

		// ajout de quatre personnes au HashSet
		hash1.add(p1);
		hash1.add(p3);
		hash1.add(p4);
		hash1.add(p5);

		// ajout du contenu d'un HashSet à un autre HashSet
		// les deux HashSet contiennent maintenant les mêmes
		// objets.
		// !!!! ne pas confondre avec hash2=hash1; !!!
		hash2.addAll(hash1);

		// affichage du nombre d'éléments du HashSet
		System.out.println("il y a " + hash1.size() + " personne(s) dans le HashSet");

		System.out.println("Voici les personnes dans la liste 1 (foreach):");
		// parcours de la première liste avec la boucle foreach
		for (Personne personne : hash1) {
			System.out.println(personne.getNom());
		}

		System.out.println("Voici les personnes dans la liste 1 (Iterator):");
		// parcours du premier HashSet du début vers la fin
		Iterator<Personne> it;
		it = hash1.iterator();
		// tant qu'il reste des éléments dans le HashSet
		Personne p;
		while (it.hasNext()) {
			// récupération de l'élément courant
			p = it.next();
			System.out.println(p.getNom());
		}
	}
}
