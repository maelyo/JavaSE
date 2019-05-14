package fr.eni.editions.ihm32;

import java.awt.BorderLayout;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Ecran extends JFrame

{
	JPanel pano;
	JTextArea txt;
	JScrollPane defil;
	JMenuBar barre;
	JMenu mnuFichier, mnuEdition, mnuSauvegarde;
	JMenuItem mnuNouveau, mnuOuvrir, mnuEnregister, mnuEnregistrerSous, mnuQuitter;
	JMenuItem mnuCopier, mnuCouper, mnuColler;
	File fichier;
	JCheckBox chkGras, chkItalique;

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
		// création des boutons
		btnNouveau = new JButton(new ImageIcon(getClass().getResource("new.png")));
		btnOuvrir = new JButton(new ImageIcon(getClass().getResource("open.png")));
		btnEnregister = new JButton(new ImageIcon(getClass().getResource("save.png")));
		btnCopier = new JButton(new ImageIcon(getClass().getResource("copy.png")));
		btnColler = new JButton(new ImageIcon(getClass().getResource("paste.png")));
		btnCouper = new JButton(new ImageIcon(getClass().getResource("cut.png")));
		// ajout des boutons à la barre d'outils
		tlbr.add(btnNouveau);
		tlbr.add(btnOuvrir);
		tlbr.add(btnEnregister);
		tlbr.addSeparator();
		tlbr.add(btnCopier);
		tlbr.add(btnCouper);
		tlbr.add(btnColler);
		// ajout de la barre d'outils sur son conteneur
		pano.add(tlbr, BorderLayout.NORTH);
		// réutilisation écouteurs déjà associés aux menus
		btnNouveau.addActionListener(mnuNouveau.getActionListeners()[0]);
		btnOuvrir.addActionListener(mnuOuvrir.getActionListeners()[0]);
		btnEnregister.addActionListener(mnuEnregister.getActionListeners()[0]);
		btnCopier.addActionListener(mnuCopier.getActionListeners()[0]);
		btnCouper.addActionListener(mnuCouper.getActionListeners()[0]);
		btnColler.addActionListener(mnuColler.getActionListeners()[0]);

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

		pano.add(options, BorderLayout.SOUTH);

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
		police = new Font(txt.getFont().getName(), attributs, txt.getFont().getSize());
		txt.setFont(police);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
