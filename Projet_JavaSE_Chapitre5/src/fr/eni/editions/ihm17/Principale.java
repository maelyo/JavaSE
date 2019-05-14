package fr.eni.editions.ihm17;

import javax.swing.SwingUtilities;

public class Principale { 
 
     public static void main(String[] args) 
     { 
          SwingUtilities.invokeLater(()->new Ecran().afficher());
     } 
}
