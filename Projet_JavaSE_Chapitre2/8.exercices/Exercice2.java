import java.util.Random;

public class Exercice2  
{ 
    public static void main(String[] args) 
    { 
    	int nombreTentative=0; 
        int nb1,nb2,nb3;
        Random rd = new Random();
        //La boucle do...while est adaptée car il faut au moins une tentative
        do 
        { 
        	//Tirage au sort des 3 variables
        	nb1=rd.nextInt(1000); 
            nb2=rd.nextInt(1000); 
            nb3=rd.nextInt(1000); 
            //Incrémentation du nombre de tentative
            nombreTentative++; 
            //Affichage de la tentative
            System.out.println("nombre 1:" + nb1 + " nombre 2:" + nb2 + " nombre 3:" + nb3);
            //On recommence si nb1 est impair ou si nb2 est impair ou si nb3 est pair.
            //pour cela, on évalue le reste de la division entière par 2.
            //si le reste égal 1, le nombre est impair
            //si le reste égal 0, le nombre est pair
         } while(nb1 % 2==1 || nb2 % 2==1 || nb3 % 2==0);
         System.out.println("Résultat obtenu en " + nombreTentative + " essai(s)"); 	
    } 
}
