package fr.eni.editions.ihm13;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Ecran extends JFrame

{
	JPanel pano;
	JButton btnRouge, btnVert, btnBleu;
	JMenuItem mnuRouge, mnuVert, mnuBleu;

	public Ecran() {
		setTitle("première fenêtre en JAVA");
		setBounds(0, 0, 300, 100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// création des trois boutons
		btnRouge = new JButton("Rouge");
		btnVert = new JButton("Vert");
		btnBleu = new JButton("Bleu");
		// création d’un seul écouteur
		EcouteurCouleur ec;
		ec = new EcouteurCouleur();
		// association de l'écouteur à chaque bouton
		btnRouge.addActionListener(ec);
		btnVert.addActionListener(ec);
		btnBleu.addActionListener(ec);
		// Création du menu
		JMenuBar barreMenu;
		barreMenu = new JMenuBar();
		JMenu mnuCouleurs;
		mnuCouleurs = new JMenu("Couleurs");
		barreMenu.add(mnuCouleurs);

		mnuRouge = new JMenuItem("Rouge");
		mnuVert = new JMenuItem("Vert");
		mnuBleu = new JMenuItem("Bleu");
		mnuCouleurs.add(mnuRouge);
		mnuCouleurs.add(mnuVert);
		mnuCouleurs.add(mnuBleu);
		// association de l'écouteur à chaque menu
		// (le même que pour les boutons)
		mnuRouge.addActionListener(ec);
		mnuVert.addActionListener(ec);
		mnuBleu.addActionListener(ec);
		// ajout du menu sur la fenêtre
		setJMenuBar(barreMenu);
		// création du conteneur intermédiaire
		pano = new JPanel();
		// ajout des boutons sur le conteneur intermédiaire
		pano.add(btnRouge);
		pano.add(btnVert);
		pano.add(btnBleu);
		// ajout du conteneur intermédiaire sur le ContentPane
		getContentPane().add(pano);
		// création d'une instance d'une classe anonyme
		// chargée de gérer les événements
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	public void afficher() {
		this.setVisible(true);
	}

	public class EcouteurCouleur implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnRouge || arg0.getSource() == mnuRouge) {
				pano.setBackground(Color.RED);
			}
			if (arg0.getSource() == btnVert || arg0.getSource() == mnuVert) {
				pano.setBackground(Color.GREEN);
			}
			if (arg0.getSource() == btnBleu || arg0.getSource() == mnuBleu) {
				pano.setBackground(Color.BLUE);
			}
		}
	}

}
