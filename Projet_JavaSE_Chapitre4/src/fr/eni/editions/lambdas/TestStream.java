package fr.eni.editions.lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TestStream {

	public static void main(String[] args) {
//Obtention d'un stream générique
		List<Personne> listePersonnes = new ArrayList<Personne>(
											List.of(new Personne("Wayne", "John", LocalDate.of(1907, 5, 26)),
											        new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24)),
											        new Personne("Lennon", "John", LocalDate.of(1940, 10, 9)),
											        new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3)),
										            new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19))));
		Stream<Personne> streamPersonnes = listePersonnes.stream();
		
		Stream<String> streamStrings = Stream.<String>builder()
													   .add("Bonjour")
													   .add("tout")
													   .add("le")
													   .add("monde")
													   .build();

//Obtention d'un stream numérique
		
		//IntStream streamNumeriquesEntiers = IntStream.builder().add(1).add(15).build();
		
		List<Integer> listeEntiers = List.of(1, 15, 13, 5, 48, 6, 89, 25, 46, 35);
		IntStream streamNumeriquesEntiers = listeEntiers.stream().mapToInt(i->i);
		
		IntStream streamAgesPersonnes = listePersonnes.stream().mapToInt(p->p.calculerAge());
		
		
//Manipulation d'un stream générique
		//FILTRER ET TRIER
		System.out.println("Les mots de 5 caractères minimum:");
		List<String> mots5CaracteresMin = streamStrings.filter(s->s.length()>=5)
													   .sorted()
													   .collect(Collectors.toList());
		mots5CaracteresMin.forEach(s->System.out.println(s));
		
		// la fonction allMatch retourne true si tous les éléments  
		// de la liste remplissent la condition exprimée 
		// dans l'expression lambda 
		 
		         
		if(listePersonnes.stream().allMatch(p->p.getDateDeNaissance().getYear()>1945))
			System.out.println("toutes les personnes sont nées après 1945"); 
		else 
			System.out.println("certaines personnes sont nées avant 1945"); 
		   
		// filtrage de personnes nées au mois de mars 
		// ce filtrage génère un nouveau Stream  
		// forEach parcours ce nouveau Stream et 
		// exécute l'expression lambda pour chaque élément 
		   
				listePersonnes.stream().filter(p->p.getDateDeNaissance().getMonthValue()==3)
									   .forEach(p->System.out.println(p.getNom())); 
		       
		// recherche de la personne la plus âgée de la liste 
		// l'expression lambda représente l'implémentation  
		// de l'interface Comparator 
		   
		System.out.println(listePersonnes.stream().max((pe1,pe2)-> pe1.calculerAge()-pe2.calculerAge())
												  .get()
												  .getNom());
		   
		// calcul de l'âge moyen des personnes présentes dans la  
		// liste mapToLong génère un nouveau Stream de type long  
		// obtenu à partir de la référence de fonction  
		// average calcule la moyenne de ce nouveau flux 
		// getAsDouble la tranforme en type double 
		double ageMoyen = listePersonnes.stream().mapToLong(p->p.calculerAge()) 
												 .average()
												 .getAsDouble(); 
		 
		System.out.println("age moyen des personnes de la liste : " + ageMoyen + " ans"); 

		System.out.println("Création d'une liste de clients à partir de la liste de personnes:");
		//Transformer une collection de personnes en collection de clients
		List<Client> listeClients = listePersonnes.stream().map(p->new Client(p.getNom(), 
																			  p.getPrenom(), 
																			  p.getDateDeNaissance()))
														   .collect(Collectors.toList());
		listeClients.forEach(c->System.out.println(c));
//Manipulation d'un stream numérique		
		System.out.println("Somme des nombres");
		int somme = listeEntiers.stream().mapToInt(i->i)
										 .sum();
		System.out.println("La somme est de " + somme);
		
		System.out.println("Moyenne des nombres");
		OptionalDouble moyenne = listeEntiers.stream().mapToInt(i->i)
											 .average();
		System.out.println("La moyenne est de " + moyenne);
		
		
		System.out.println("La valeur max est :");
		OptionalInt optMax = listeEntiers.stream().mapToInt(i->i).max();
		if(optMax.isPresent())
		{
			System.out.println(optMax.getAsInt());
		}
		else
		{
			System.out.println("Pas de valeur max");
		}
		System.out.println("Retrouver la valeur max ou donner une valeur par défaut:");
		int valMax = listeEntiers.stream().mapToInt(i->i).max().orElse(123);
		
	}

}
