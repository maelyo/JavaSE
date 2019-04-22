package fr.eni.editions.generiques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class TestListeGenerique {

	// static ListeGenerique<String> liste = new ListeGenerique<String>(5);
	static ListeGenerique<Personne> liste = new ListeGenerique<Personne>(5);

	public static void main(String[] args) {
		/*
		 * liste.ajout("premier"); liste.ajout("deuxième"); liste.ajout("troisième");
		 * liste.ajout("quatrième"); liste.ajout("cinquième");
		 */
		
		liste.ajout(new Personne("toto2", "prenom2", LocalDate.of(1922, 2, 15)));
		liste.ajout(new Personne("toto1", "prenom1", LocalDate.of(1911, 1, 15)));
		liste.ajout(new Personne("toto5", "prenom5", LocalDate.of(1955, 5, 15)));
		liste.ajout(new Personne("toto3", "prenom3", LocalDate.of(1933, 3, 15)));
		liste.ajout(new Personne("toto4", "prenom4", LocalDate.of(1944, 4, 15)));
		
		try {
			//Appel d'une méthode générique pour effectuer le tri
			//TestListeGenerique.tri(liste);
			//TestListeGenerique.<Personne>tri(liste);
			menu();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void menu() {
		char choix = '\0';
		System.out.println("p (premier) < (précédent) >(suivant) d (dernier) f (fin)");
		while (choix != 'f') {
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(System.in));
				choix = br.readLine().charAt(0);
				switch (choix) {
				case 'p':
					System.out.println("le premier: " + liste.premier());
					break;
				case '<':
					System.out.println("le précédent: " + liste.precedent());
					break;
				case '>':
					System.out.println("le suivant: " + liste.suivant());
					break;
				case 'd':
					System.out.println("le dernier: " + liste.dernier());
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("p (premier) < (précédent) >(suivant) d (dernier) f (fin)");
		}
	}

	//Méthode générique
	public static <T extends Classable> void tri(ListeGenerique<T> liste) 
			throws Exception 
	{
		int i, j;
		T c;
		for (i = 0; i < liste.getNbElements() - 1; i++) {
			for (j = i + 1; j < liste.getNbElements(); j++) {
				if (liste.getElement(j).compare(liste.getElement(i)) == 
						Classable.INFERIEUR) {
					c = liste.getElement(j);
					liste.remplace(liste.getElement(i), j);
					liste.remplace(c, i);
				} else if (liste.getElement(j).compare(liste.getElement(i)) == 
						Classable.ERREUR) {
					throw new Exception("erreur pendant le tri");
				}
			}
		}
	}

}
