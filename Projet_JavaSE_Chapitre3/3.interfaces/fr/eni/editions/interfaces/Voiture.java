package fr.eni.editions.interfaces;

public class Voiture implements Classable 

{ 
   private String immatriculation; 
   private String marque; 
   private String modele; 
   private int puissance; 
   
   public Voiture() 
   { 
      super(); 
   } 
    
   public Voiture(String immatriculation,
		          String marque,
		          String modele,
		          int puissance) 
   { 
      this.immatriculation=immatriculation; 
      this.marque=marque; 
      this.modele=modele; 
      this.puissance=puissance; 
   } 
 
   public String getImmatriculation() 
   { 
      return immatriculation; 
   } 
 
   public void setImmatriculation(String immatriculation) 
   { 
      this.immatriculation = immatriculation; 
   } 
   public String getMarque()  
   { 
      return marque; 
   } 
   public void setMarque(String marque) 
   { 
      this.marque = marque; 
   } 
   public String getModele()  
   { 
      return modele; 
} 
 
   public void setModele(String modele)  
   { 
      this.modele = modele; 
   } 
   public int getPuissance()  
   { 
      return puissance; 
   } 
 
   public void setPuissance(int puissance)  
   { 
      this.puissance = puissance; 
   } 
 
   /**
    * Comparaison sur la puissance de la voiture
    */
   @Override 
   public int compare(Object o)  
   { 
      Voiture v; 
      if (o instanceof Voiture) 
      { 
         v=(Voiture)o; 
      } 
      else 
      { 
         return Classable.ERREUR; 
      } 
      if (this.getPuissance()<v.getPuissance()) 
      { 
         return Classable.INFERIEUR; 
      } 
      if (this.getPuissance()>v.getPuissance()) 
      { 
         return Classable.SUPERIEUR; 
      } 
       
      return Classable.EGAL; 
   } 
   /**
    * @return true si la puissance de la voiture est inférieure
    */
   @Override 
   public boolean isInferieur(Object o) 
   { 
      return this.compare(o)==Classable.INFERIEUR; 
   }
   /**
    * @return true si la puissance de la voiture est supérieure
    */
   @Override 
   public boolean isSuperieur(Object o) 
   { 
      return this.compare(o)==Classable.SUPERIEUR;
   } 
    
}

