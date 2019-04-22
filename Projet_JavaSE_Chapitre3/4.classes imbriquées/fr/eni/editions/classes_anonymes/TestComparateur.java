package fr.eni.editions.classes_anonymes;

import java.time.LocalDate;
import java.util.Arrays;

public class TestComparateur {

public static void main(String[] args) {
	Personne[] tab = new Personne[5];
	tab[0] = new Personne("toto2", 
						  "prenom2", 
						  LocalDate.of(1922, 2, 15));
	tab[1] = new Personne("toto1", 
						  "prenom1 ", 
						  LocalDate.of(1911, 1, 15));
	tab[2] = new Personne("toto5", 
						  "prenom5 ", 
						  LocalDate.of(1955, 05, 15));
	tab[3] = new Personne("toto3", 
						  "prenom3 ", 
						  LocalDate.of(1933, 03, 15));
	tab[4] = new Personne("toto4", 
						  "prenom4 ", 
						  LocalDate.of(1944, 04, 15));

	System.out.println("Tri par nom:");
	Personne[] tabTrie = (Personne[]) tri(tab,
			// création d'une instance de classe implémentant
			// l'interface Comparateur
			new Comparateur()
			// voici le code de la classe
			{
				// comme l'exige l'interface voici la méthode compare
				public int compare(Object o1, Object o2) {
					Personne p1, p2;
					if (o1 instanceof Personne & o2 instanceof Personne) {
						p1 = (Personne) o1;
						p2 = (Personne) o2;
					} else {
						return Comparateur.ERREUR;
					}
					if (p1.getNom().compareTo(p2.getNom()) < 0) {
						return Comparateur.INFERIEUR;
					}
					if (p1.getNom().compareTo(p2.getNom()) > 0) {
						return Comparateur.SUPERIEUR;
					}

					return Comparateur.EGAL;

				} // accolade de fermeture de la méthode compare

			} // accolade de fermeture de la classe
	); // fin de l'appel de la fonction de tri

	// affichage du tableau trié

	for (int i = 0; i < tabTrie.length; i++) {
		System.out.println(tabTrie[i]);
	}

	System.out.println("Tri par âge:");
	tabTrie = (Personne[]) tri(tab,
			// création d'une instance de classe implémentant
			// l'interface Comparateur
			new Comparateur()
			// voici le code de la classe
			{
				// comme l'exige l'interface voici la méthode compare
				public int compare(Object o1, Object o2) {
					Personne p1, p2;
					if (o1 instanceof Personne & o2 instanceof Personne) {
						p1 = (Personne) o1;
						p2 = (Personne) o2;
					} else {
						return Comparateur.ERREUR;
					}
					if (p1.calculerAge()<p2.calculerAge()) {
						return Comparateur.INFERIEUR;
					}
					if (p1.calculerAge()>p2.calculerAge()) {
						return Comparateur.SUPERIEUR;
					}
				
					return Comparateur.EGAL;
				
				} // accolade de fermeture de la méthode compare

			} // accolade de fermeture de la classe
	); // fin de l'appel de la fonction de tri

	// affichage du tableau trié

	for (int i = 0; i < tabTrie.length; i++) {
		System.out.println(tabTrie[i]);
	}
}

	public static Object[] tri(Object[] tablo, Comparateur trieur) {
		int i, j;
		Object c;
		Object[] tabloTri;
		tabloTri = Arrays.copyOf(tablo, tablo.length);
		for (i = 0; i < tabloTri.length; i++) {
			for (j = i + 1; j < tabloTri.length; j++) {
				// utilise la fonction compare de l'objet reçu en paramètre
				// pour comparer le contenu de deux cases du tableau
				if (trieur.compare(tabloTri[j], tabloTri[i]) == Comparateur.INFERIEUR) {
					c = tabloTri[j];
					tabloTri[j] = tabloTri[i];
					tabloTri[i] = c;
				} else if (trieur.compare(tabloTri[j], tabloTri[i]) == Comparateur.ERREUR) {
					return null;
				}
			}
		}
		return tabloTri;
	}
}
