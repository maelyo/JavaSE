import java.util.ArrayList;

public class LaBoucleForEach {

	public static void main(String[] args) {
		System.out.println("Les couleurs présentes dans le tableau:");
		String[] tablo={"rouge","vert","bleu","blanc"}; 
		/*for (int cpt = 0; cpt < tablo.length; cpt++) 
		{ 
		      System.out.println(tablo[cpt]); 
		}*/
		for (String s : tablo) 
		{ 
		     System.out.println(s); 
		}
		
		System.out.println();
		
		System.out.println("Liste de clients et tentative de modification dans une boucle foreach");
		ArrayList<String> lst=new ArrayList<String>(); 
		lst.add("client 1"); 
		lst.add("client 2"); 
		lst.add("client 3"); 
		lst.add("client 5"); 
		   
		for(String st:lst) 
		{ 
		   System.out.println(st); 
		   if(st.endsWith("3")) 
		   { 
			   //La ligne suivante provoque une erreur car pendant l'itération lst est en lecture seule
			   lst.add("client 4"); 
		   } 
		}

	}
}
