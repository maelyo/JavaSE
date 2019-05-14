package fr.eni.editions.ihm24;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ecran extends JFrame

{
	JPanel pano;

	public Ecran() {
		setTitle("Présentation JLabel");
		setBounds(0, 0, 220, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants

		pano = new JPanel();
		
		JLabel legende=new JLabel("nom"); 
		legende.setBorder(BorderFactory.createEtchedBorder()); 
		legende.setPreferredSize(new Dimension(200,50)); 
		legende.setHorizontalAlignment(SwingConstants.LEFT); 
		legende.setVerticalAlignment(SwingConstants.TOP); 

		pano.add(legende);
		
		getContentPane().add(pano);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
