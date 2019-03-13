import java.util.Arrays;

public class LesTableaux {

	public static void main(String[] args) {
		/*
		//Déclaration
		int[] chiffreAffaire;
		//Initialisation
		chiffreAffaire  = new int[12];
		chiffreAffaire[0]=123;
		chiffreAffaire[1]=563;
		//...
		*/
		
		//Déclaration et initialisation avec des valeurs connues
		int[] chiffreAffaire = {123,563,657,453,986,678,564,234,786,123,534,975};
		
		//Lecture
		int chiffreAffaireMoisJanvier = chiffreAffaire[0];
		//Ecriture
		chiffreAffaire[0]=354;
		
		//Déclaration d'un tableau à 2 dimensions avec taille définie pour toutes les dimensions.
		int[][] chiffreAffaireParRegion;
		chiffreAffaireParRegion = new int[2][12];
		//...
		
		
		//Déclaration d'un tableau à 2 dimensions en créant uniquement la première dimension à l'initialisation
		int[][] matrice;
		matrice = new int[2][];
		//Initialisation de la deuxième dimension pour chacune des cases de la première dimension.
		//Il est possible d'initialiser avec des tableaux de tailles différentes.
		matrice[0]=new int[3];
		matrice[1]=new int[2];
		
		//Lecture
		int case_0_0 = matrice[0][0];
		//Ecriture
		matrice[1][1]=14;
		
		/*
		//Possibilité d'initialiser avec des valeurs connues:
		int[][] matrice = {
							{11,12,13},
							{21,22,23}
						  };
		*/
		
		//Manipulation d'un tableau
		matrice = new int[8][3];
		
		//Connaitre la taille d'un tableau
		System.out.println("le tableau comporte " + matrice.length + " cases sur " + matrice[0].length + " cases");
		
		//Afficher le contenu d'un tableau à 1 dimension:
		System.out.println("Contenu du tableau chiffreAffaire:");
		System.out.println(Arrays.toString(chiffreAffaire));
		
		//Afficher le contenu d'un tableau à N dimensions:
		int[][] grille = {{11,12,13},{21,22,23},{31,32,33}};
		System.out.println("Contenu du tableau grille:");
		System.out.println(Arrays.deepToString(grille));
		
		//Trier le contneu d'un tableau:
		System.out.println("Contenu trié u tableau chiffreAffaire:");
		Arrays.sort(chiffreAffaire);
		System.out.println(Arrays.toString(chiffreAffaire));
		
		//Rechercher un élément dans le tableau (trié au préalable)
		System.out.println("Recherche le premier index du tableau contenant un chiffre d'affaire à 123. Retourne une valeur négative si n'existe pas");
		System.out.println(Arrays.binarySearch(chiffreAffaire, 123));
		
		//Copier un tableau
		System.out.println("Copier un tableau");
		int[] copieChiffreAffaire = Arrays.copyOf(chiffreAffaire, 24);
		System.out.println(Arrays.toString(copieChiffreAffaire));
		
		//Copier une partie du tableau:
		System.out.println("Copier une partie d'un tableau");
		int[] premierTrimestre = Arrays.copyOfRange(chiffreAffaire, 0, 3);
		System.out.println(Arrays.toString(premierTrimestre));
		
		//Remplir un tableau avec une valeur précise
		System.out.println("Remplir un tableau avec des 2");
		int[] tableau = new int[5];
		Arrays.fill(tableau, 2);
		System.out.println(Arrays.toString(tableau));
		
	}

}