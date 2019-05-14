package fr.eni.editions.ihm18;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ecran extends JFrame

{
	
	public Ecran() {
		setTitle("première fenêtre en JAVA");
		setBounds(0, 0, 400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel grille; 
		grille=new JPanel(); 
		GridLayout grl; 
		//grl=new GridLayout(2,2);
		grl=new GridLayout(0,2);
		grille.setLayout(grl); 
		grille.add(new JButton("1")); 
		grille.add(new JButton("2")); 
		grille.add(new JButton("3")); 
		grille.add(new JButton("4")); 
		grille.add(new JButton("5")); 
		grille.add(new JButton("6")); 
		
		getContentPane().add(grille);
	}

	public void afficher() {
		this.setVisible(true);
	}

}
