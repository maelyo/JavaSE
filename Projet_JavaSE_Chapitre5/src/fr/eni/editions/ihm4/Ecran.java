package fr.eni.editions.ihm4; 
 
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
          // ajout du conteneur sur le ContentPane 
          getContentPane().add(pano); 
     } 
     
     public void afficher()
     {
    	 this.setVisible(true);
     }
} 
