package fr.eni.editions.modules;

import fr.eni.editions.api.Persistence;
import fr.eni.editions.api.PersistenceFactory;
import fr.eni.editions.api.PersistenceType;

public class TestModule {

	public static void main(String[] args) {
		Persistence p = PersistenceFactory.getPersistence(PersistenceType.SQL);
	}

}





