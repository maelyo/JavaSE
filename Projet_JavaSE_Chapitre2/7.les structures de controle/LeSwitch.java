import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeSwitch {

	//La gestion des exceptions sera mieux gérée dans le prochaine chapitre
	public static void main(String[] args) throws IOException {
		System.out.println("Répondez oui, non ou n'importe quoi:");
		//L'instruction suivante permet d'accéder aux saisie de l'utilisateur sur la console
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		String reponse=""; 
		//L'instruction suivante permet de lire la saisie de l'utilisateur jusqu'à l'appuie sur la touche Entrée
		reponse=br.readLine(); 
		switch (reponse) 
		{ 
		     case "oui": 
		     case "OUI": 
		          System.out.println("réponse positive"); 
		          break; 
		     case "non": 
		     case "NON": 
		          System.out.println("réponse négative"); 
		          break; 
		     default:  
		          System.out.println("mauvaise réponse"); 
		}
	}
}
