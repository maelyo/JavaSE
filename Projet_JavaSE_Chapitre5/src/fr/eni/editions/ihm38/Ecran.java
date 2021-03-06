package fr.eni.editions.ihm38;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ecran extends JFrame {
	JPanel pano;
	JTextArea txt;
	JScrollPane defil;
	JMenuBar barre;
	JMenu mnuFichier, mnuEdition, mnuSauvegarde;
	JMenuItem mnuNouveau, mnuOuvrir, mnuEnregister, mnuEnregistrerSous, mnuQuitter;
	JMenuItem mnuCopier, mnuCouper, mnuColler;
	File fichier;
	JCheckBox chkGras, chkItalique;
	JList<String> polices;
	JComboBox<Integer> cboTaille;

	public Ecran() {
		setTitle("éditeur de texte");
		setBounds(0, 0, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();
		pano.setLayout(new BorderLayout());
		txt = new JTextArea();
		defil = new JScrollPane(txt);
		pano.add(defil, BorderLayout.CENTER);
		getContentPane().add(pano);
		// création des composants des menus
		barre = new JMenuBar();
		mnuFichier = new JMenu("Fichier");
		mnuEdition = new JMenu("Edition");
		mnuSauvegarde = new JMenu("Sauvegarde");
		mnuNouveau = new JMenuItem("Nouveau");
		mnuOuvrir = new JMenuItem("Ouvrir");
		mnuEnregister = new JMenuItem("Enregistrer");
		mnuEnregister.setEnabled(false);
		mnuEnregistrerSous = new JMenuItem("Enregistrer sous");
		mnuCopier = new JMenuItem("Copier");
		mnuCouper = new JMenuItem("Couper");
		mnuColler = new JMenuItem("Coller");
		mnuQuitter = new JMenuItem("Quitter");
		// association des éléments
		barre.add(mnuFichier);
		barre.add(mnuEdition);
		mnuFichier.add(mnuNouveau);
		mnuFichier.add(mnuOuvrir);
		mnuFichier.add(mnuSauvegarde);
		mnuSauvegarde.add(mnuEnregister);
		mnuSauvegarde.add(mnuEnregistrerSous);
		mnuFichier.add(new JSeparator());
		mnuFichier.add(mnuQuitter);
		mnuEdition.add(mnuCopier);
		mnuEdition.add(mnuCouper);
		mnuEdition.add(mnuColler);
		// association du menu avec la JFrame
		setJMenuBar(barre);
		// les écouteurs associés aux différents menus
		mnuNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fichier = null;
				txt.setText("");
				mnuEnregister.setEnabled(false);
			}

		});
		mnuOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dlg;
				dlg = new JFileChooser();
				dlg.showDialog(null, "Ouvrir");
				fichier = dlg.getSelectedFile();
				FileInputStream in;
				try {
					in = new FileInputStream(fichier);
					BufferedReader br;
					br = new BufferedReader(new InputStreamReader(in));
					String ligne;
					txt.setText("");
					while ((ligne = br.readLine()) != null) {
						txt.append(ligne + "\r\n");
					}
					br.close();
					mnuEnregister.setEnabled(true);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mnuQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuCopier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.copy();
			}
		});
		mnuCouper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.cut();
			}
		});
		mnuColler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.paste();
			}
		});
		mnuEnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter pw;
					pw = new PrintWriter(fichier);
					pw.write(txt.getText());
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		mnuEnregistrerSous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser dlg;
					dlg = new JFileChooser();
					dlg.showDialog(null, "enregistrer sous");
					fichier = dlg.getSelectedFile();
					PrintWriter pw;
					pw = new PrintWriter(fichier);
					pw.write(txt.getText());
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

		JToolBar tlbr;
		tlbr = new JToolBar();
		JButton btnNouveau, btnOuvrir, btnEnregister;
		JButton btnCopier, btnCouper, btnColler;
		JButton btnTraitementLong;
		// création des boutons
		btnNouveau = new JButton(new ImageIcon(getClass().getResource("new.png")));
		btnOuvrir = new JButton(new ImageIcon(getClass().getResource("open.png")));
		btnEnregister = new JButton(new ImageIcon(getClass().getResource("save.png")));
		btnCopier = new JButton(new ImageIcon(getClass().getResource("copy.png")));
		btnColler = new JButton(new ImageIcon(getClass().getResource("paste.png")));
		btnCouper = new JButton(new ImageIcon(getClass().getResource("cut.png")));
		btnTraitementLong = new JButton(new ImageIcon(getClass().getResource("time.png")));
		// ajout des boutons à la barre d'outils
		tlbr.add(btnNouveau);
		tlbr.add(btnOuvrir);
		tlbr.add(btnEnregister);
		tlbr.addSeparator();
		tlbr.add(btnCopier);
		tlbr.add(btnCouper);
		tlbr.add(btnColler);
		tlbr.addSeparator();
		tlbr.add(btnTraitementLong);
		// ajout de la barre d'outils sur son conteneur
		pano.add(tlbr, BorderLayout.NORTH);
		// réutilisation écouteurs déjà associés aux menus
		btnNouveau.addActionListener(mnuNouveau.getActionListeners()[0]);
		btnOuvrir.addActionListener(mnuOuvrir.getActionListeners()[0]);
		btnEnregister.addActionListener(mnuEnregister.getActionListeners()[0]);
		btnCopier.addActionListener(mnuCopier.getActionListeners()[0]);
		btnCouper.addActionListener(mnuCouper.getActionListeners()[0]);
		btnColler.addActionListener(mnuColler.getActionListeners()[0]);
		// Ajout d'un écouteur sur le clic du bouton btnTraitementLong:
		btnTraitementLong.addActionListener(this::lancerTraitementLong);

		// Ajout des options pour le style d'écriture
		JPanel options;
		GridLayout gl;
		options = new JPanel();
		gl = new GridLayout(2, 1);
		options.setLayout(gl);
		chkGras = new JCheckBox("Gras");
		chkItalique = new JCheckBox("Italique");
		options.add(chkGras);
		options.add(chkItalique);
		chkGras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePolice();
			}
		});
		chkItalique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePolice();
			}
		});

		// Ajout des options pour la police d'écriture
		JScrollPane defilPolices;

		String[] nomsPolices = { "Dialog", "DialogInput", "Monospaced", "Serif", "SansSerif" };
		polices = new JList<String>(nomsPolices);
		polices.setSelectedIndex(0);
		defilPolices = new JScrollPane(polices);
		defilPolices.setPreferredSize(new Dimension(100, 60));
		options.add(defilPolices);
		polices.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					changePolice();
				}
			}
		});

		// Ajout des optiones pour la taille de la police
		Integer tailles[] = { 10, 12, 14, 16, 20 };
		cboTaille = new JComboBox<Integer>(tailles);
		cboTaille.setEditable(true);
		options.add(cboTaille);
		cboTaille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePolice();
			}
		});

		pano.add(options, BorderLayout.SOUTH);

		// Ajout des options pour gérer la couleur du texte
		// et la couleur de fond
		JRadioButton optFondRouge, optFondVert, optFondBleu;
		JRadioButton optRouge, optVert, optBleu;
		JPanel couleur, couleurFond;
		ButtonGroup grpCouleur, grpCouleurFond;
		// création des boutons
		optRouge = new JRadioButton("Rouge");
		optVert = new JRadioButton("Vert");
		optBleu = new JRadioButton("Bleu");
		optFondRouge = new JRadioButton("Rouge");
		optFondVert = new JRadioButton("Vert");
		optFondBleu = new JRadioButton("Bleu");
		// regroupement logique des boutons
		grpCouleur = new ButtonGroup();
		grpCouleur.add(optRouge);
		grpCouleur.add(optVert);
		grpCouleur.add(optBleu);
		grpCouleurFond = new ButtonGroup();
		grpCouleurFond.add(optFondRouge);
		grpCouleurFond.add(optFondVert);
		grpCouleurFond.add(optFondBleu);
		// regroupement physique des boutons
		couleur = new JPanel();
		couleur.setLayout(new GridLayout(0, 1));
		couleur.add(optRouge);
		couleur.add(optVert);
		couleur.add(optBleu);

		pano.add(couleur, BorderLayout.WEST);

		couleurFond = new JPanel();
		couleurFond.setLayout(new GridLayout(0, 1));
		couleurFond.add(optFondRouge);
		couleurFond.add(optFondVert);
		couleurFond.add(optFondBleu);

		pano.add(couleurFond, BorderLayout.EAST);

		// ajout d'une bordure avec titre
		couleur.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Texte"));
		couleurFond.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Fond"));
		// référencement des écouteurs
		optBleu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setForeground(Color.BLUE);
			}
		});
		optVert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setForeground(Color.GREEN);
			}
		});
		optRouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setForeground(Color.RED);
			}
		});
		optFondBleu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setBackground(Color.BLUE);
			}
		});
		optFondRouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setBackground(Color.RED);
			}
		});
		optFondVert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setBackground(Color.GREEN);
			}
		});

	}

	public void changePolice() {
		int attributs;
		attributs = 0;
		if (chkGras.isSelected()) {
			attributs = attributs + Font.BOLD;
		}
		if (chkItalique.isSelected()) {
			attributs = attributs + Font.ITALIC;
		}

		Font police;
		police = new Font(polices.getSelectedValue().toString(), attributs,
				cboTaille.getItemAt(cboTaille.getSelectedIndex()));
		txt.setFont(police);
	}

	// Traitement long exécuté dans le thread EDT:
	/*
	 * public void lancerTraitementLong(ActionEvent actionEvent) { String chaine
	 * ="s"; for(int i=0;i<200000;i++) { chaine+="s"; } }
	 */
	// Traitement long exécuté dans un thread enfant:
	private void lancerTraitementLong(ActionEvent actionEvent) {
		Thread threadEnfant = new Thread(() -> {
			String chaine = "s";
			for (int i = 0; i < 200000; i++) {
				chaine += "s";
			}
			SwingUtilities.invokeLater(()->notifierFinTraitementLong());
		});
		threadEnfant.start();
	}
	
	private void notifierFinTraitementLong()
	{
		JOptionPane.showMessageDialog(null, "le traitement long est terminé", "Traitement long",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
