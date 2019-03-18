import java.util.Random;
import java.util.Scanner; 

public class Exercice3  
{ 
    public static void main(String[] args) 
    { 
        int nbEssais=0; 
        int secret; 
        int nbSaisi;
        Random rd = new Random();
        
        secret=rd.nextInt(1000); 
        Scanner sc=new Scanner(System.in); 
        System.out.println("Veuillez saisir un entier entre 0 et 1000");
        do 
        { 
        	//récupération de la valeur saisie par l'utilisateur
            nbSaisi=sc.nextInt(); 
            //incrémentation du nombre d'essais
            nbEssais++; 
            //comparaison avec le nombre secret.
            //affichage d'un message si le nombre est différent
            if(nbSaisi<secret) 
            { 
                 System.out.println("c'est plus"); 
            } 
            else if(nbSaisi>secret) 
            { 
                 System.out.println("c'est moins"); 
            }   
          //On continue si le nbSaisi n'est pas égal au nombre secret!
        } while (nbSaisi!=secret); 
        System.out.println("Bravo vous avez trouvé en " + nbEssais + " essai(s)"); 
    } 
}