package fr.eni.editions.ihm15;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	ConsoleLog lg;

	public Ecran() {
		setTitle("premiere fenetre en JAVA");
		setBounds(0, 0, 300, 130);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// création des trois boutons

		btnRouge = new JButton("Rouge");
		btnRouge.setActionCommand("red");
		btnVert = new JButton("Vert");
		btnVert.setActionCommand("green");
		btnBleu = new JButton("Bleu");
		btnBleu.setActionCommand("blue");
		// création de l’unique écouteur
		EcouteurCouleur ec;
		ec = new EcouteurCouleur();
		// association de l'écouteur à chaque bouton
		btnRouge.addActionListener(ec);
		btnVert.addActionListener(ec);
		btnBleu.addActionListener(ec);
		// création de la case à cocher
		JCheckBox chkLog;
		chkLog = new JCheckBox("log sur console");
		// ajout d'un écouteur à la case à cocher
		chkLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCheckBox chk;
				chk = (JCheckBox) arg0.getSource();
				if (chk.isSelected()) // Si la case est cochée
				{
					// ajout d'un écouteur supplémentaire
					// aux boutons et menus
					lg = new ConsoleLog();
					btnBleu.addActionListener(lg);
					btnRouge.addActionListener(lg);
					btnVert.addActionListener(lg);
					mnuBleu.addActionListener(lg);
					mnuRouge.addActionListener(lg);
					mnuVert.addActionListener(lg);
				} else {
					// suppression de l'écouteur supplémentaire
					// des boutons et menus
					btnBleu.removeActionListener(lg);
					btnRouge.removeActionListener(lg);
					btnVert.removeActionListener(lg);
					mnuBleu.removeActionListener(lg);
					mnuRouge.removeActionListener(lg);
					mnuVert.removeActionListener(lg);
				}

			}
		});
		// Création du menu
		JMenuBar barreMenu;
		barreMenu = new JMenuBar();
		JMenu mnuCouleurs;
		mnuCouleurs = new JMenu("Couleurs");
		barreMenu.add(mnuCouleurs);
		mnuRouge = new JMenuItem("Rouge");
		mnuRouge.setActionCommand("red");
		mnuVert = new JMenuItem("Vert");
		mnuVert.setActionCommand("green");
		mnuBleu = new JMenuItem("Bleu");
		mnuBleu.setActionCommand("blue");
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
		pano.add(chkLog);
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
			String commande;
			commande = arg0.getActionCommand();
			if (commande.equals("red")) {
				pano.setBackground(Color.RED);
			}
			if (commande.equals("green")) {
				pano.setBackground(Color.GREEN);
			}
			if (commande.equals("blue")) {
				pano.setBackground(Color.BLUE);
			}
		}
	}

}
