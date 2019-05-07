package fr.eni.editions.api.implementation.sql;

import fr.eni.editions.api.Persistence;

public class PersistenceSQL implements Persistence {

	@Override
	public void ajouter(Object o) {
		System.out.println("J'ajoute avec l'API SQL");

	}

	@Override
	public void supprimer(Object o) {
		System.out.println("Je supprime avec l'API SQL");

	}

}
