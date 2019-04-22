package fr.eni.editions.heritage;

public class Commande implements Cloneable 
{ 
     Client leClient; 
     LignesDeCommande lesLignes; 
 
     public Commande() 
     { 
          super(); 
          lesLignes=new LignesDeCommande(); 
 
     } 
     public Object clone() throws CloneNotSupportedException 
     { 
          Commande cmd; 
          // création d'une copie de la commande 
          cmd=(Commande)super.clone(); 
          // duplication des lignes de la commande 
          cmd.lesLignes=(LignesDeCommande)lesLignes.clone(); 
          return cmd; 
           
     } 
     public Client getLeClient() 
     { 
          return leClient; 
     } 
     public void setLeClient(Client leClient) 
     { 
          this.leClient = leClient; 
     } 
     public LignesDeCommande getLesLignes() 
     { 
          return lesLignes; 
     } 
     public void setLesLignes(LignesDeCommande lesLignes) 
     { 
          this.lesLignes = lesLignes; 
     } 
}

