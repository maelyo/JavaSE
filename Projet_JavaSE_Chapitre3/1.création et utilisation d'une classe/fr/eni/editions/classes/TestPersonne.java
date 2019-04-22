package fr.eni.editions.classes;

import java.time.LocalDate;

public class TestPersonne {
	@SuppressWarnings("deprecation") 
	public static void main(String[] args) {
		Personne p = new Personne();
		p.setNom("dupont"); 
		p.setPrenom("albert"); 
		
		System.out.println("Affichage des caractéristiques de la personne");
		System.out.println(p.getNom()); 
		System.out.println(p.getPrenom());
		System.out.println("Numéro : " + p.getNumero());
		
		System.out.println("Affichage de la personne avec la méthode dépréciée afficher()");
		p.afficher();
		
		System.out.println("Affichage de la personne avec la méthode afficher(true)");
		p.afficher(true);
		
		System.out.println("Affichage de la personne avec la méthode afficher(false)");
		p.afficher(false);
		
		
		Personne pe=new Personne("Martin",
                				 "Benoit", 
                				 LocalDate.of(1975,2,5));
		System.out.println("Affichage de la personne ayant une date de naissance");
		pe.afficher(true);
		System.out.println("Affichage du numéro de la personne");
		System.out.println("Numéro : " + pe.getNumero());
	}
	
}
