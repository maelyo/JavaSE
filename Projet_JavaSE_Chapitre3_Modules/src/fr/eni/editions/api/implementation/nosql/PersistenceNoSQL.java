package fr.eni.editions.api.implementation.nosql;

import fr.eni.editions.api.Persistence;

public class PersistenceNoSQL implements Persistence {

	@Override
	public void ajouter(Object o) {
		System.out.println("J'ajoute avec l'API NoSQL");

	}

	@Override
	public void supprimer(Object o) {
		System.out.println("Je supprime avec l'API NoSQL");

	}

}
