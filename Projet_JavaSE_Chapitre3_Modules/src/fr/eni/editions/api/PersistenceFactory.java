package fr.eni.editions.api;

import fr.eni.editions.api.implementation.nosql.PersistenceNoSQL;
import fr.eni.editions.api.implementation.sql.PersistenceSQL;

public abstract class PersistenceFactory {
	public static Persistence getPersistence(PersistenceType type)
	{
		switch (type) {
		case SQL:
			return new PersistenceSQL();
		case NoSQL:
			return new PersistenceNoSQL();
		}
		return null;
	}
}
