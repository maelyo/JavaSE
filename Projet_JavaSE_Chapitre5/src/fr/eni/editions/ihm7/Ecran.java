package fr.eni.editions.ihm7; 
 
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
           // création d'une instance de la classe chargée 
           // de gérer les événements 
           EcouteurFenetre ef; 
           ef=new EcouteurFenetre(); 
           // référencement de cette instance de classe 
           // comme écouteur d'événement pour la fenêtre 
 
           addWindowListener(ef); 
      }
	  public void afficher()
	  {
		this.setVisible(true);
	  } 
 
      public class EcouteurFenetre implements WindowListener 
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
      } 
} 
