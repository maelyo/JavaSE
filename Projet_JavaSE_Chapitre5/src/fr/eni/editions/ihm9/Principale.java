package fr.eni.editions.ihm9;

import javax.swing.SwingUtilities;


public class Principale { 
 
     public static void main(String[] args) 
     { 
         SwingUtilities.invokeLater(()->
         {
			Ecran ecran = new Ecran();
			// création d'une instance de la classe chargée 
			// de gérer les événements 
			EcouteurFenetre ef=new EcouteurFenetre(); 
			// référencement de cette instance de classe 
			// comme écouteur d'événement pour la fenêtre 
			ecran.addWindowListener(ef); 
			//affichage de l'écran
			ecran.afficher();
         });
     } 
}
