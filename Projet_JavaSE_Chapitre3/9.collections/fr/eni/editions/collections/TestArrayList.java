package fr.eni.editions.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestArrayList {
	public static void main(String[] args) {
		// Déclaration de deux variables
		// du type de l'interface voulue
		List<Personne> liste1;
		List<Personne> liste2;
		// création des deux instances
		liste1 = new ArrayList<Personne>();
		liste2 = new ArrayList<Personne>();

		// création des personnes pour remplir la liste
		Personne p1, p2, p3, p4, p5;
		p1 = new Personne("Wayne", "John", LocalDate.of(1907, 5, 26));
		p2 = new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24));
		p3 = new Personne("Lennon", "John", LocalDate.of(1940, 10, 9));
		p4 = new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3));
		p5 = new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19));

		// ajout de quatre personnes à la liste
		liste1.add(p1);
		liste1.add(p3);
		liste1.add(p4);
		liste1.add(p5);

		// insertion d'une personne entre p1 et p3
		// donc à la position 1 de la liste
		liste1.add(1, p2);

		// ajout du contenu d'une liste à une autre liste
		// les deux listes contiennent maintenant les mêmes objets.
		// !!!! ne pas confondre avec liste2=liste1; !!!
		liste2.addAll(liste1);

		// affichage du nombre d'éléments de la liste
		System.out.println("il y a " + liste1.size() + " personne(s) dans la liste");

		System.out.println("Voici les personnes dans la liste 1 (foreach):");
		// parcours de la première liste avec la boucle foreach
		for (Personne personne : liste1) {
			System.out.println(personne.getNom());
		}

		System.out.println("Voici les personnes dans la liste 1 (for):");
		// parcours de la première liste avec la boucle for
		for (int index = 0; index < liste1.size(); index++) {
			System.out.println(liste1.get(index).getNom());
		}

		System.out.println("Voici les personnes dans la liste 1 (Iterator):");
		// parcours de la première liste du début vers la fin
		Iterator<Personne> it;
		it = liste1.iterator();
		Personne p;
		// tant qu'il reste des éléments

		while (it.hasNext()) {
			// récupération de l'élément courant
			p = it.next();
			System.out.println(p.getNom());
		}

		System.out.println("Voici les personnes dans la liste 1 (ListIterator):");
		// parcours de la première liste de la fin vers le début
		// récupération d'un ListIterator positionné après
		// le dernier élément (le nombre d'éléments de la liste)

		ListIterator<Personne> lit;
		lit = liste1.listIterator(liste1.size());
		// tant qu'il reste des éléments
		while (lit.hasPrevious()) {
			// récupération de l'élément courant
			// en remontant dans la liste
			p = lit.previous();
			System.out.println(p.getNom());
		}

		// remplacement d'un élément de liste
		liste1.set(2, new Personne("Grant", "Cary", LocalDate.of(1904, 1, 18)));

		// affichage de l'élément à la troisième position de la liste
		System.out.println(liste1.get(2).getNom());

		// recherche d'un élément dans la liste
		int position;
		position = liste1.indexOf(p4);
		if (position == -1)
			System.out.println("non trouve dans la liste");
		else
			System.out.println(liste1.get(position).getNom());

		// recherche d'un élément inexistant dans la liste.
		// John Lennon a été remplacé par Cary Grant
		// La recherche débute à la fin de la liste

		position = liste1.lastIndexOf(p3);
		if (position == -1)
			System.out.println("non trouve dans la liste");
		else
			System.out.println(liste1.get(position).getNom());
	}
}
