
public class ManipulationEnumeres {

	public static void main(String[] args) {
		//Déclaration d'une variable de type Dalton initialisée avec une valeur de l'énuméré.
		Dalton d = Dalton.JACK;
		System.out.println(d.toString());

		//Affectation de la variable avec la valeur d'énuméré correspondant au texte "JOE" 
		d = Dalton.valueOf("JOE"); 
		System.out.println("poids : "+ d.poids()); 
		System.out.println("taille : "+ d.taille());

		//Parcourir toutes les valeurs de l'énuméré
		System.out.println("les frères Dalton"); 
		for(Dalton dalton: Dalton.values()) 
		{ 
		   System.out.println(dalton.toString()); 
		}
		
		//Tester la valeur d'une variable d'un type énuméré
		Jour repere = Jour.LUNDI;
		switch (repere) 
		{ 
		    case LUNDI: 
		    case MARDI: 
		    case MERCREDI: 
		    case JEUDI: 
		         System.out.println("C\'est dur de travailler"); 
		         break; 
		    case VENDREDI: 
		         System.out.println("Bientôt le week end !"); 
		         break; 
		    case SAMEDI: 
		         System.out.println("Enfin !"); 
		          break; 
		     case DIMANCHE: 
		          System.out.println("Et ça recommence !"); 
		          break; 
		}

	}

}
