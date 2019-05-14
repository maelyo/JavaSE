package fr.eni.editions.ihm12;

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

	public Ecran() {
		setTitle("première fenêtre en JAVA");
		setBounds(0, 0, 300, 100);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// création des trois boutons
		JButton btnRouge, btnVert, btnBleu;
		btnRouge = new JButton("Rouge");
		btnVert = new JButton("Vert");
		btnBleu = new JButton("Bleu");
		// création des trois écouteurs
		EcouteurRouge ecR;
		EcouteurVert ecV;
		EcouteurBleu ecB;
		ecR = new EcouteurRouge();
		ecV = new EcouteurVert();
		ecB = new EcouteurBleu();
		// association de l'écouteur à chaque bouton
		btnRouge.addActionListener(ecR);
		btnVert.addActionListener(ecV);
		btnBleu.addActionListener(ecB);
		// Création du menu
		JMenuBar barreMenu;
		barreMenu = new JMenuBar();
		JMenu mnuCouleurs;
		mnuCouleurs = new JMenu("Couleurs");
		barreMenu.add(mnuCouleurs);
		JMenuItem mnuRouge, mnuVert, mnuBleu;
		mnuRouge = new JMenuItem("Rouge");
		mnuVert = new JMenuItem("Vert");
		mnuBleu = new JMenuItem("Bleu");
		mnuCouleurs.add(mnuRouge);
		mnuCouleurs.add(mnuVert);
		mnuCouleurs.add(mnuBleu);
		// association de l'écouteur à chaque menu
		// (les mêmes que pour les boutons)
		mnuRouge.addActionListener(ecR);
		mnuVert.addActionListener(ecV);
		mnuBleu.addActionListener(ecB);
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
		// chargée de gérer les événements de la fenêtre
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	public void afficher() {
		this.setVisible(true);
	}

	public class EcouteurRouge implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pano.setBackground(Color.RED);
		}
	}

	public class EcouteurVert implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pano.setBackground(Color.GREEN);
		}
	}

	public class EcouteurBleu implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pano.setBackground(Color.BLUE);
		}
	}

}
