package fr.eni.editions.ihm1;

import javax.swing.JFrame;

public class Principale { 
     public static void main(String[] args) 
     { 
          JFrame fenetre; 
          // création de l'instance de la classe JFrame 
          fenetre=new JFrame(); 
          // modification de la position et de la 
          // taille de la fenêtre 
          fenetre.setBounds(0,0,300,400); 
          // modification du titre de la fenêtre 
          fenetre.setTitle("première fenêtre en JAVA"); 
          // affichage de la fenêtre 
          fenetre.setVisible(true); 
     }
}

