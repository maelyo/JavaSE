package fr.eni.editions.exercice4;

import java.time.Duration; 
import java.util.ArrayList; 
 
 
public class Dvd extends Article 
{ 
     private Duration duree; 
     private Personne realisateur; 
      
     public Dvd() 
     { 
         super(); 
     } 
      
     public Dvd(int reference,String designation,double 
prix,Duration duree,Personne realisateur) 
     { 
         super(reference,designation,prix); 
      
         setDuree(duree); 
         setRealisateur(realisateur); 
     } 
  
     public Duration getDuree()  
     { 
         return duree; 
     } 
  
     public void setDuree(Duration duree)  
     { 
         this.duree = duree; 
     } 
  
     public Personne getRealisateur()  
     { 
         return realisateur; 
     } 
  
     public void setRealisateur(Personne realisateur)  
     { 
         //si l'œuvre appartenait à un autre réalisateur
         //alors je la retire de la liste de cet ancien réalisateur
         if(this.realisateur!=null)
         {
              this.realisateur.getOeuvres().remove(this);
         }
         this.realisateur = realisateur; 
         ArrayList<Article> lst; 
         lst=realisateur.getOeuvres(); 
         if (!lst.contains(this)) 
         { 
             lst.add(this); 
         } 
     } 
  
   public String toString() 
   { 
         return super.toString() + " " + 
getDuree().toMinutes() + " " + getRealisateur(); 
	}
}
