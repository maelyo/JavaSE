package fr.eni.editions.ihm8; 
 
import java.awt.event.WindowEvent; 
import java.awt.event.WindowListener; 
 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
 
public class Ecran extends JFrame 
 
{ 
      public Ecran() 
      { 
           setTitle("première fenêtre en JAVA"); 
           setBounds(0,0,300,100); 
           setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
           // création des trois boutons 
           JButton b1,b2,b3; 
           b1=new JButton("Rouge"); 
           b2=new JButton("Vert"); 
           b3=new JButton("Bleu"); 
           // création du conteneur intermédiaire 
           JPanel pano; 
           pano=new JPanel(); 
           // ajout des boutons sur le conteneur intermédiaire 
           pano.add(b1); 
           pano.add(b2); 
           pano.add(b3); 
           // ajout du conteneur intermédiaire sur le ContentPane 
           getContentPane().add(pano); 
           // création d'une instance d'une classe anonyme 
           // chargée de gérer les événements 
           addWindowListener(new WindowListener() 
           // début de la définition de la classe 
           { 
                public void windowActivated(WindowEvent arg0) 
                { 
                } 
                public void windowClosed(WindowEvent arg0) 
                { 
                } 
                public void windowClosing(WindowEvent arg0) 
                { 
                     System.exit(0); 
                } 
                public void windowDeactivated(WindowEvent arg0) 
                { 
                } 
                public void windowDeiconified(WindowEvent arg0) 
                { 
                } 
                public void windowIconified(WindowEvent arg0) 
                { 
                } 
                public void windowOpened(WindowEvent arg0) 
                { 
                } 
           } // fin de la définition de la classe 
           ); // fin de l'appel de la méthode addWindowListener 
      }// fin du constructeur 
	  public void afficher()
	  {
		this.setVisible(true);
	  } 
}// fin de la classe Ecran 
