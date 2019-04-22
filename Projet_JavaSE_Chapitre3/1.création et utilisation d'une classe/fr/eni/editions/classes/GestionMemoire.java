package fr.eni.editions.classes;

import java.time.LocalDate;

public class GestionMemoire 
{ 
    //Le code suivant est consommateur d'espace mémoire avec la création de 1000 tableaux de 1000 personnes.
	//Lorsque l'espace mémoire vient à manquer, le Garbage Collector la nettoie en supprimant tous les objets inaccessibles.
    public static void main(String[] args) throws InterruptedException 
    { 
        double total; 
        double reste; 
        double pourcentage; 
        double restePrecedent=-1;   
        for (int j=0;j<1000;j++) 
        { 
            creationTableau(); 
            total=Runtime.getRuntime().totalMemory(); 
            reste=Runtime.getRuntime().freeMemory();
            if(reste>restePrecedent && restePrecedent!=-1)
            {
            	System.out.println("Le garbage collector est passé");
            }
            restePrecedent=reste;
            pourcentage=100-(reste/total)*100; 
            System.out.println("création du " + j + "ième tableau mémoire pleine à : " + pourcentage + "%" ); 
            // une petite pause pour pouvoir lire les messages 
            Thread.sleep(100); 
        } 
    } 
 
    public static void creationTableau() 
    { 
        // création d'un tableau de 1000 Personnes dans une 
        // variable locale
        // à la fin de cette fonction les éléments du tableau ne 
        // sont plus accessibles et peuvent être supprimés 
        // de la mémoire 
        Personne[] tablo; 
        tablo=new Personne[1000]; 
        for (int i=0;i<1000;i++) 
        { 
             tablo[i]=new Personne("Dupont",
                                   "albert",
                                   LocalDate.of(1956,12,13)); 
        } 
    }
}

