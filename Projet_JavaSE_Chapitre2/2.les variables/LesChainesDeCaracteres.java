
public class LesChainesDeCaracteres {

	public static void main(String[] args) {
		//Déclaration d'une chaine de caractères
		String nomDuCapitaine = "Crochet";
		String chaine1 = "eni";
		String chaine2 = new String("eni");
		
		//Déclaration d'une chaine de caractère avec une guillemet
		String chaine = "Il a dit : \"ça suffit!\"";
		System.out.println(chaine);
		
		//Manipulation des chaines de caractères:
		chaine1 = "l'hiver sera pluvieux";
		chaine2 = "l'hiver sera froid";
		System.out.println("chaine 1 = "+chaine1);
		System.out.println("chaine 2 = "+chaine2);
		
		//Extraire un caractère particulier:
		System.out.println("le 3ème caractère de la chaine 1 est " + chaine1.charAt(2));
		
		//Obtenir la longueur d'une chaine
		System.out.println("la chaine 1 contient " + chaine1.length() + " caractères");
		
		//Découper une chaine
		System.out.println("un morceau de la chaine 1 : " + chaine1.substring(2,7));
		
		//Tester l'égalité du contenu de 2 chaines
		if(chaine1.equals(chaine2))
		{
			System.out.println("les deux chaines sont identiques");
		}
		else
		{
			System.out.println("les deux chaines sont différentes");
		}
		
		//Comparer 2 chaines
		if(chaine1.compareTo(chaine2)>0)
		{
			System.out.println("chaine1 est supérieure à chaine2");
		}
		else if(chaine1.compareTo(chaine2)<0)
		{
			System.out.println("chaine1 est inférieure à chaine2");
		}
		else
		{
			System.out.println("les deux chaines sont identiques");
		}
		
		String nom = "Code.java";
		if(nom.endsWith(".java"))
		{
			System.out.println("c'est un fichier source java");
		}
		
		//Supprimer les espaces
		String eni="          eni         ";
		System.out.println("longueur de la chaine : " + eni.length());
		System.out.println("longueur de la chaine nettoyée :" + eni.trim().length());
		
		//Changer la casse
		System.out.println(chaine1.toUpperCase());
		System.out.println(chaine1.toLowerCase());
		
		//Rechercher dans une chaine de caractères
		String recherche;
		int position;
		recherche="e";
		position = chaine1.indexOf(recherche,0);
		while(position>=0)
		{
			System.out.println("chaine trouvée à la position " + position);
			position = chaine1.indexOf(recherche, position+1);
		}
		System.out.println("fin de la recherche");

		//Remplacer une partie d'une chaine
		String chaine3 = chaine1.replace("hiver", "été");
		System.out.println(chaine3);
		
		//Formater une chaine
		boolean b = true;
		String s = "chaine";
		int i=56;
		double d=5.5;
		System.out.println(
							String.format("boolean : %b %n" +
										  "chaine de caractères : %s %n" +
										  "entier : %d %n" +
										  "entier en hexadécimal : %x %n" +
										  "entier en ocatl: %o %n" +
										  "décimal : %f %n" +
										  "décimal précis au dixième : %.1f %n" +
										  "décimal au format scientifique : %e %n", 
										  b,s,i,i,i,d,d,d)
						  );
			
	}

}
