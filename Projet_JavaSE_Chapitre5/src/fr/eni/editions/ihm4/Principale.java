package fr.eni.editions.ihm4;

import javax.swing.SwingUtilities;

public class Principale { 
 
     public static void main(String[] args) 
     { 
          SwingUtilities.invokeLater(()->new Ecran().afficher());
     } 
}
