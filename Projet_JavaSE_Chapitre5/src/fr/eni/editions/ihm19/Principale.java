package fr.eni.editions.ihm19;

import javax.swing.SwingUtilities;

public class Principale { 
 
     public static void main(String[] args) 
     { 
          SwingUtilities.invokeLater(()->new Ecran().afficher());
     } 
}
