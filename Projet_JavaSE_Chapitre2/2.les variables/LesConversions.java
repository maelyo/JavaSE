
public class LesConversions {
	public static void main(String[] args) {
		{
			//Conversions entre numériques
			float surface; 
			surface=2356.8f; 
			//Conversion implicite
			double grandeSurface=surface; 
			//Conversion explicite
			int approximation=(int)surface;
			//Affichage des informations
			System.out.println("Surface en float : " + surface);
			System.out.println("Surface en double : " + grandeSurface);
			System.out.println("Surface en int : " + approximation);
		}
		{
			//Conversion implicite numérique vers String
			double prixHt; 
			prixHt=152; 
			String recap; 
			recap="le montant de la commande est : " + prixHt*1.20;
			System.out.println(recap);
		}
		{
			//Conversion explicite numérique vers String
			double prixHt; 
			prixHt=152; 
			String recap; 
			recap="le montant de la commande est : " + String.valueOf(prixHt*1.20);
			System.out.println(recap);
		}
		{
			//Conversion chaine de caractères vers wrappers
			Integer entier = Integer.valueOf("10");
			entier = Integer.valueOf(10);
			//autoboxing
			entier = 10;
			//undoxing
			int x = entier;
			System.out.println("x est un int issu de l'Integer entier par unboxing");
			System.out.println("entier : " + entier);
			System.out.println("x : " + x);
			//Conversion chaine de caractères vers numérique de base
			int nombre = Integer.parseInt("10");
			System.out.println("la variable nombre est issue de la conversion du texte \"10\" en type primitif (int)");
			System.out.println("nombre : " + nombre);
		}
	}
}
