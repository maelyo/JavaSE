package fr.eni.editions.ihm25;

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
		setBounds(0, 0, 300,	300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();
		
		JLabel legende=new JLabel("nom"); 
		legende.setBorder(BorderFactory.createEtchedBorder()); 
		legende.setPreferredSize(new Dimension(250,250)); 
		//L'instruction getClass().getResource() permet 
		//de rechercher une ressource dans le même package
		//que la classe en cours d'exécution
		legende.setIcon(new ImageIcon(getClass().getResource("duke.png"))); 
		legende.setHorizontalTextPosition(SwingConstants.LEFT); 
		legende.setVerticalTextPosition(SwingConstants.BOTTOM); 
		legende.setIconTextGap(40);
		
		pano.add(legende);
		
		getContentPane().add(pano);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
