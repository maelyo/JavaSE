package fr.eni.editions.ihm29;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ecran extends JFrame

{
	JPanel pano;
	JTextArea txt;
	JCheckBox chkWrap, chkWrapWord;
	JScrollPane defil;

	public Ecran() {
		setTitle("Présentation JTextArea");
		setBounds(0, 0, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();
		txt = new JTextArea(10, 40);
		defil = new JScrollPane(txt);
		pano.add(defil);
		chkWrap = new JCheckBox("retours à la ligne automatiques");
		chkWrapWord = new JCheckBox("retours entre deux mots");
		chkWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setLineWrap(chkWrap.isSelected());
			}
		});
		chkWrapWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setWrapStyleWord(chkWrapWord.isSelected());
			}
		});
		pano.add(chkWrap);
		pano.add(chkWrapWord);
		getContentPane().add(pano);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
