package fr.eni.editions.ihm27;

import javax.swing.SwingUtilities;

public class Principale { 
 
     public static void main(String[] args) 
     { 
          SwingUtilities.invokeLater(()->new Ecran().afficher());
     } 
}
