package fr.eni.editions.ihm22;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ecran extends JFrame {
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

		// ajout sur le conteneur 
		pano.setLayout(null);
		pano.add(defilPolices);
		pano.add(chkGras);
		pano.add(chkItalique);
		pano.add(lblTaille);
		pano.add(cboTaille);
		pano.add(lblExemple);

		// position des composants. 
		defilPolices.setBounds(24, 29, 156, 255);
		chkGras.setBounds(258, 78, 170, 25);
		chkItalique.setBounds(261, 139, 167, 46);
		lblTaille.setBounds(215, 211, 106, 24);
		cboTaille.setBounds(354, 208, 107, 32);
		lblExemple.setBounds(17, 309, 459, 28);
		getContentPane().add(pano);
	}
	public void afficher() {
		this.setVisible(true);
	}
}