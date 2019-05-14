package fr.eni.editions.lambdas;

import java.time.LocalDate;

public class Client extends Personne {

	public Client() {
		super();
	}

	public Client(String n, String p, LocalDate d) {
		super(n, p, d);
	}

	@Override
	public String toString() {
		return "Client [getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getDateDeNaissance()="
				+ getDateDeNaissance() + ", calculerAge()=" + calculerAge() + "]";
	}

	
	
	

}