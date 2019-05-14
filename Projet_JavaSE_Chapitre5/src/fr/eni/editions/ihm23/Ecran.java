package fr.eni.editions.ihm23;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ecran extends JFrame

{
	JPanel pano;
	JCheckBox chkGras, chkItalique;
	JLabel lblTaille, lblExemple;
	JComboBox<String> cboTaille;
	JList<String> lstPolices;
	JScrollPane defilPolices;

	public Ecran() {
		setTitle("choix d\'une police");
		setBounds(0, 0, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants

		pano = new JPanel();
		chkGras = new JCheckBox("gras");
		chkItalique = new JCheckBox("italique");
		lblTaille = new JLabel("taille");
		lblExemple = new JLabel("essai de police de caractères");
		cboTaille = new JComboBox(new String[] { "10", "12", "14", "16", "18", "20" });
		lstPolices = new JList(
				new String[] { "arial", "courier", "letter", "helvetica", "times roman", "symbole", "antique" });
		defilPolices = new JScrollPane(lstPolices);

		GridBagLayout gbl;
		gbl = new GridBagLayout();
		pano.setLayout(gbl);

		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		// position dans la case 0,0
		gbc.gridy = 0;
		// sur une colonne de largeur
		gbc.gridwidth = 1;
		// et sur trois lignes en hauteur
		gbc.gridheight = 3;
		// pondération en cas d'agrandissmment du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		// le composant est redimensionné pour occuper
		// tout l'espace disponible dans son conteneur
		gbc.fill = GridBagConstraints.BOTH;
		pano.add(defilPolices, gbc);
		// position dans la case 1,0
		gbc.gridx = 1;
		gbc.gridy = 0;
		// sur deux colonnes de largeur
		gbc.gridwidth = 2;
		// et sur une ligne en hauteur
		gbc.gridheight = 1;
		// pondération en cas d'agrandissement du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		// le composant n'est pas redimensionné pour occuper
		// tout l'espace disponible dans son conteneur
		gbc.fill = GridBagConstraints.NONE;
		pano.add(chkGras, gbc);
		// position dans la case 1,1
		gbc.gridx = 1;
		gbc.gridy = 1;
		// sur deux colonnes de largeur
		gbc.gridwidth = 2;
		// et sur une ligne en hauteur
		gbc.gridheight = 1;
		// pondération en cas d'agrandissement du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		pano.add(chkItalique, gbc);
		// position dans la case 1,2
		gbc.gridx = 1;
		gbc.gridy = 2;
		// sur une colonne de largeur
		gbc.gridwidth = 1;
		// et sur une ligne en hauteur
		gbc.gridheight = 1;
		// pondération en cas d'agrandissement du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		pano.add(lblTaille, gbc);
		// position dans la case 2,2
		gbc.gridx = 2;
		gbc.gridy = 2;
		// sur une colonne de largeur
		gbc.gridwidth = 1;
		// et sur une ligne en hauteur
		gbc.gridheight = 1;
		// pondération en cas d'agrandissement du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		pano.add(cboTaille, gbc);
		// position dans la case 0,3
		gbc.gridx = 0;
		gbc.gridy = 3;
		// sur trois colonnes de largeur
		gbc.gridwidth = 3;
		// et sur une ligne en hauteur
		gbc.gridheight = 1;
		// pondération en cas d'agrandissement du conteneur
		gbc.weightx = 100;
		gbc.weighty = 100;
		pano.add(lblExemple, gbc);
		getContentPane().add(pano);
		
		//Gestion de l'apparence:
		//lstPolices.setBackground(Color.red); 
		//lstPolices.setForeground(Color.GREEN);
		lstPolices.setBackground(new Color(23,67,89)); 
		lstPolices.setForeground(new Color(167,86,23));
		lstPolices.setFont(new Font("Serif",Font.BOLD,24));
		lstPolices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chkGras.setVisible(false); 
		chkItalique.setEnabled(false); 
		lstPolices.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				lstPolices.setForeground(Color.RED); 
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				lstPolices.setForeground(Color.BLACK); 
			}
		});

	}

	public void afficher() {
		this.setVisible(true);
	}
}
