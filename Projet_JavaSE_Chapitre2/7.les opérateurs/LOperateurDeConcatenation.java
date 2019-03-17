
public class LOperateurDeConcatenation {

	public static void main(String[] args) {
		long duree; 
		String lievre; 
		String tortue=""; 
		long debut, fin; 
		debut = System.currentTimeMillis(); 
		for (int i = 0; i <= 10000; i++) 
		{ 
		     tortue = tortue + " " + i; 
		} 
		fin = System.currentTimeMillis(); 
		duree = fin-debut; 
		System.out.println("durée pour la tortue : " + duree + "ms"); 
		debut = System.currentTimeMillis(); 
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i <= 10000; i++) 
		{ 
		     sb.append(" "); 
		     sb.append(i); 
		} 
		lievre = sb.toString(); 
		fin = System.currentTimeMillis(); 
		duree = fin-debut; 
		System.out.println("durée pour le lièvre : " + duree + "ms"); 
		if (lievre.equals(tortue)) 
		{ 
		     System.out.println("les deux chaînes sont identiques"); 
		}
	}
}
