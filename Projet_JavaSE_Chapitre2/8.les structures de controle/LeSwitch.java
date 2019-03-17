import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeSwitch {

	public static void main(String[] args) throws IOException {
		System.out.println("Répondez oui, non ou n'importe quoi:");
		BufferedReader br; 
		br=new BufferedReader(new InputStreamReader(System.in)); 
		String reponse=""; 
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
