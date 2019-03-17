
public class LeIf {
	public static void main(String[] args) {
		boolean test=true;
		//Structure la plus simple:
		System.out.println("if(test)");
		System.out.println("résultat: " + test);
		if(test)
			System.out.println("   instruction conditionnée par le résultat du test");
		System.out.println("   instruction obligatoirement exécutée");
		
		System.out.println();
		
		//Structure permettant de conditionner l'exécutation de plusieurs instructions
		System.out.println("if(test){...}");
		System.out.println("résultat: " + test);
		if(test)
		{
			System.out.println("   intruction 1 (if)");
			System.out.println("   ... (if)");
			System.out.println("   instruction n (if)");
		}
		
		System.out.println();
		
		//Structure permettant d'ajouter une alternative avec un else
		test=false;
		System.out.println("if(test){...}else{...}");
		System.out.println("résultat: " + test);
		if(test)
		{
			System.out.println("   intruction 1 (if)");
			System.out.println("   ... (if)");
			System.out.println("   instruction n (if)");
		}
		else
		{
			System.out.println("   intruction 1 (else)");
			System.out.println("   ... (else)");
			System.out.println("   instruction n (else)");
		}
		
		System.out.println();
		
		//Structure permettant d'ajouter une conditionnelle avec else if
		test=false;
		boolean test2=true;
		System.out.println("if(test){...}else if{test2}else{...}");
		System.out.println("résultat if: " + test);
		System.out.println("résultat else if: " + test2);
		if(test)
		{
			System.out.println("   intruction 1 (if)");
			System.out.println("   ... (if)");
			System.out.println("   instruction n (if)");
		}
		else if(test2)
		{
			System.out.println("   intruction 1 (else if)");
			System.out.println("   ... (else if)");
			System.out.println("   instruction n (else if)");
		}
		else
		{
			System.out.println("   intruction 1 (else)");
			System.out.println("   ... (else)");
			System.out.println("   instruction n (else)");
		}
		
		System.out.println();
		System.out.println("Exemple concret:");
		int age = 25;
		System.out.println("Votre age est : " + age);
		if(age>=18)
		{
			System.out.println("Vous êtes un adulte");
		}
		else
		{
			System.out.println("Vous êtes un enfant");
		}
	}
}
