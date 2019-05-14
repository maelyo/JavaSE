package fr.eni.editions.ihm26;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ecran extends JFrame

{
	JPanel pano;

	public Ecran() {
		setTitle("Présentation JLabel");
		setBounds(0, 0, 400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();
		
		JLabel lNom=new JLabel("Nom:"); 
		JTextField tfNom=new JTextField();
		tfNom.setPreferredSize(new Dimension(100,25));
		//Raccourci pour accéder à la zone de saisie:
		lNom.setDisplayedMnemonic('n');
		lNom.setLabelFor(tfNom);
		
		JLabel lPrenom=new JLabel("Prénom:"); 
		JTextField tfPrenom=new JTextField();
		tfPrenom.setPreferredSize(new Dimension(100,25));
		//Raccourci pour accéder à la zone de saisie:
		lPrenom.setDisplayedMnemonic('p');
		lPrenom.setLabelFor(tfPrenom);
				
		
		pano.add(lNom);
		pano.add(tfNom);
		pano.add(lPrenom);
		pano.add(tfPrenom);
		
		getContentPane().add(pano);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
