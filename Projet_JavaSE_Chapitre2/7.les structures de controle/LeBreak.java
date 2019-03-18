
public class LeBreak {

	public static void main(String[] args) {
		System.out.println("Dans quelle case se trouve le 0 dans le tableau?");
		int[][] points = {  
	               { 10,10,}, 
	               { 0,10 }, 
	               { 45,24 }}; 
		int x=0,y=0; //les variables sont déclarées en dehors des boucles pour se rappeler des coordonnées de la case contenant le 0
					 //après la sortie des deux boucles
		boolean trouve=false; //Le booléen permet de savoir si le 0 a été trouvé
	
		recherche: 
		for (x = 0; x <points.length; x++) 
		{ 
		   for (y = 0; y < points[x].length;y++)  
		   { 
		      if (points[x][y] == 0) 
		      { 
		         trouve = true; 
		         break recherche; 
		      } 
		   } 
		} 
	
		if (trouve) //si le 0 a été trouvé, x-y correspondent aux coordonnées du 0 sinon correspondent à la dernière case testée
		{ 
		   System.out.println("resultat trouvé dans la case " 
		                      + x + "-" + y); 
		} 
		else 
		{ 
		   System.out.println("recherche infructueuse"); 
		}
	}
}
