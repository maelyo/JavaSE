package fr.eni.editions.ihm28;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.undo.UndoManager;

public class Ecran extends JFrame

{
	JPanel pano;

	public Ecran() {
		setTitle("Présentation JTextField");
		setBounds(0, 0, 400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();

		JTextField txt = new JTextField(10);
		txt.addFocusListener(new FocusListener() {
			// Sélection du texte sur le focus
			public void focusGained(FocusEvent e) {
				txt.selectAll();
			}

			// Désélection du texte sur la perte de focus
			public void focusLost(FocusEvent e) {
				txt.setSelectionStart(0);
				txt.setSelectionEnd(0);
			}
		});

		// Mise en place d'un menu pour gérer les copier/couper/coller.
		JPopupMenu mnu = new JPopupMenu();
		JMenuItem mnuCopier;
		JMenuItem mnuCouper;
		JMenuItem mnuColler;
		mnuCopier = new JMenuItem("Copier");
		mnuCouper = new JMenuItem("Couper");
		mnuColler = new JMenuItem("Coller");
		mnuCopier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tout copier
				txt.selectAll();
				txt.copy();
			}
		});
		mnuCouper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Tout couper
				txt.selectAll();
				txt.cut();
			}
		});
		mnuColler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.paste();
			}
		});
		mnu.add(mnuCopier);
		mnu.add(mnuCouper);
		mnu.add(mnuColler);
		// Faire apparaitre le menu sur un clic droit dans la zone de texte
		txt.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					mnu.show((Component) e.getSource(), e.getX(), e.getY());
				}
			}
		});

		// création du UndoManager
		UndoManager udm;
		udm = new UndoManager();
		// association avec le JTextField
		txt.getDocument().addUndoableEditListener(udm);
		// ajout d'un écouteur pour intercepter le ctrl Z
		txt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == (int) 'Z' && e.isControlDown()) {
					udm.undo();
				}
			}
		});

		JTextField txt2 = new JTextField(10);

		pano.add(txt);
		pano.add(txt2);
		pano.add(mnu);

		getContentPane().add(pano);
	}

	public void afficher() {
		this.setVisible(true);
	}
}
