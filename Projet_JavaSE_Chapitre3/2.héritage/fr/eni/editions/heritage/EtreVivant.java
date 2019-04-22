package fr.eni.editions.heritage;

public abstract /*final*/ class EtreVivant 
{ 
     private double taille; 
     private double poids; 
     public double getTaille() 
     { 
          return taille; 
     } 
     public void setTaille(double taille) 
     { 
          this.taille = taille; 
     } 
     public double getPoids() 
     { 
          return poids; 
     } 
     public void setPoids(double poids) 
     { 
          this.poids = poids; 
     } 
     // cette méthode devra être implémentée dans les classes dérivées 
     protected abstract void seDeplacer(); 
}

