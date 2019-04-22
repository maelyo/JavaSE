package fr.eni.editions.generiques;

import java.time.LocalDate;

public class TestHeritageAvecGenerique {

	public static void main(String[] args) throws Exception {
		//ListeGenerique<Client> listeClient = new ListeGenerique<Client>(5);
		//La ligne suivante ne compile pas
		//ListeGenerique<Personne> listePersonne = listeClient;
		
		ListeGenerique<Personne> listePersonnes = new ListeGenerique<>(5);
		
		listePersonnes.ajout(new Personne("toto2", "prenom2", LocalDate.of(1922, 2, 15)));
		listePersonnes.ajout(new Personne("toto1", "prenom1", LocalDate.of(1911, 1, 15)));
		listePersonnes.ajout(new Personne("toto5", "prenom5", LocalDate.of(1955, 5, 15)));
		listePersonnes.ajout(new Personne("toto3", "prenom3", LocalDate.of(1933, 3, 15)));
		listePersonnes.ajout(new Personne("toto4", "prenom4", LocalDate.of(1944, 4, 15)));
		
		affichage(listePersonnes);
		
		ListeGenerique<Client> listeClients = new ListeGenerique<>(5);
		
		listeClients.ajout(new Client("toto6", "prenom6", LocalDate.of(19666, 6, 15)));
		listeClients.ajout(new Client("toto7", "prenom7", LocalDate.of(1977, 7, 15)));
		
		affichage(listeClients);
	}
	
	public static void affichage(
			ListeGenerique<? extends Personne> liste) throws Exception 
	{
		liste.premier();
		for (int i = 0; i < liste.getNbElements(); i++) {
			System.out.println(liste.getElement(i).getNom());
			System.out.println(liste.getElement(i).getPrenom());
			System.out.println("-----------------------------");
		}
	}

}















