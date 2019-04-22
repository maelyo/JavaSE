package fr.eni.editions.collections;

import java.time.LocalDate;
import java.util.LinkedList; 
 
public class TestLinkedList  
{ 
    public static void main(String[] args) 
    { 
        LinkedList<Personne> ll; 
        ll=new LinkedList<Personne>(); 
        // création des personnes pour remplir le HashSet 
        Personne p1,p2,p3,p4,p5; 
        p1 = new Personne("Wayne", "John",LocalDate.of(1907,5,26)); 
        p2 = new Personne("McQueen", "Steeve",LocalDate.of(1930,3,24)); 
        p3 = new Personne("Lennon", "John",LocalDate.of(1940,10,9)); 
        p4 = new Personne("Gibson", "Mel",LocalDate.of(1956,1,3)); 
        p5 = new Personne("Willis", "Bruce",LocalDate.of(1955,3,19)); 
        // ajout des éléments dans la liste 
        ll.addFirst(p1); 
        ll.addFirst(p2); 
        ll.addFirst(p3); 
        ll.addFirst(p4); 
        ll.addFirst(p5); 
        Personne p=null; 
        // extraction et suppression des éléments  
        // de la liste en commençant par le plus ancien 
        do  
        { 
            p=ll.pollLast(); 
            if (p!=null) 
                System.out.println(p.getNom()); 
        } while(p!=null); 
         
        ll.clear();
    } 
}

