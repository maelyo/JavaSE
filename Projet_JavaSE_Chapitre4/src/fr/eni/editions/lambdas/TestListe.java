package fr.eni.editions.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestListe {

	public static void main(String[] args) {
		List<String> liste = new ArrayList<String>(List.of("bonjour", "tout", "le", "monde"));

		System.out.println("Affichage classique:");
		for(String element : liste)
		{
			System.out.print(element+" ");
		}
		
		System.out.println();
		System.out.println("Affichage avec une expression lambda :");
		
		System.out.println("Exemple 1:");
		//s prend successivement la valeur 
		//de chaque élément de la liste.
		//L'expression lambda respecte 
		//la signature de l'interface Consumer<T> :
		//void accept(T t);
		liste.forEach((String element)->{System.out.print(element+" ");});
		
		System.out.println();
		System.out.println("Exemple 2:");
		//Syntaxe plus condensée comme il n'y a qu'une seule instruction
		liste.forEach(s->System.out.print(s+" "));
		
		System.out.println();
		System.out.println("Exemple 3:");
		//Définition d'une variable du type de l'interface:
		Consumer<String> afficheur = s->System.out.print(s+" ");
		liste.forEach(afficheur);
		
		System.out.println();
		System.out.println("Exemple 4:");
		//Utilisation d'une référence de méthode
		liste.forEach(TestListe::afficheurStatic);

		System.out.println();
		System.out.println("Suppression des éléments avec un o");
		for(int i=liste.size()-1;i>=0;i--)
		{
			if(liste.get(i).contains("o"))
			{
				liste.remove(i);
			}
		}
		liste.forEach(s->System.out.println(s));
		
		System.out.println();
		System.out.println("Suppression avec une expression lambda");
		
		System.out.println();
		System.out.println("Exemple 1:");
		liste.removeIf((String s)->{return s.contains("o");});
		liste.forEach(s->System.out.println(s));
		
		System.out.println();
		System.out.println("Exemple 2:");
		//Syntaxe plus condensée comme il n'y a qu'une seule instruction
		liste.removeIf(s->s.contains("o"));
		liste.forEach(s->System.out.println(s));
		
		//Réinitialisation de la liste
		liste = new ArrayList<String>(List.of("bonjour", "tout", "le", "monde"));
		
		System.out.println();
		System.out.println("Tri de la liste");
		
		
		System.out.println();
		System.out.println("Exemple 1:");
		liste.sort((String s1, String s2)->{return s1.compareTo(s2);});
		liste.forEach(s->System.out.println(s));
		
		System.out.println();
		System.out.println("Exemple 2:");
		//Syntaxe plus condensée comme il n'y a qu'une seule instruction
		liste.sort((s1, s2)->s1.compareTo(s2));
		liste.forEach(s->System.out.println(s));
		
	}
	
	//Définition d'une méthode respectant la méthode void accept(T t)
	//de l'interface Consumer<T>
	private static void afficheurStatic(String s) {
		System.out.print(s+" ");
	}
}
