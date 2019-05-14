package fr.eni.editions.ihm20;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ecran extends JFrame

{
	
	public Ecran() {
		setTitle("première fenêtre en JAVA");
		setBounds(0, 0, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel ligne; 
		ligne=new JPanel(); 
		BoxLayout bl; 
		bl=new BoxLayout(ligne,BoxLayout.X_AXIS); 
		ligne.setLayout(bl); 
		JButton b1,b2,b3,b4,b5; 
		// création d'un bouton avec alignement sur le haut 
		b1=new JButton("petit"); 
		b1.setAlignmentY(0); 
		b1.setMaximumSize(new Dimension(50, 20));
		ligne.add(b1);
		
		//Création d'un séparateur de taille variable
		ligne.add(Box.createGlue()); 
		
		// création d'un bouton avec alignement sur le bas 
		b2=new JButton("   moyen   "); 
		b2.setAlignmentY(1);
		b2.setMaximumSize(new Dimension(70, 20));
		ligne.add(b2); 
		// utilisation de html pour le libellé du bouton 
		b3=new JButton("<html>très<BR>haut</html>");
		b3.setMaximumSize(new Dimension(50, 100));
		ligne.add(b3); 
		b4=new JButton("      très    large      ");
		b4.setMaximumSize(new Dimension(100, 20));
		ligne.add(b4); 
		b5=new JButton("<html>très haut<br>et<br>très large</html>");
		b5.setMaximumSize(new Dimension(100, 100));
		ligne.add(b5); 
		getContentPane().add(ligne);

	}

	public void afficher() {
		this.setVisible(true);
	}

}
