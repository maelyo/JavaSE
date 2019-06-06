package fr.eni.editions.ihm39;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.SwingWorker;
import javax.swing.SwingWorker.StateValue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ecran extends JFrame {
	JPanel pano;
	JTextArea textArea;
	JButton bouton;
	JLabel label;
	
	public Ecran() {
		setTitle("éditeur de texte");
		setBounds(0, 0, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pano = new JPanel();
		pano.setLayout(new BorderLayout());

		bouton = new JButton("Démarrer");
		pano.add(bouton,BorderLayout.NORTH);
		
		label = new JLabel();
		label.setPreferredSize(new Dimension(600, 30));
		pano.add(label,BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		pano.add(textArea,BorderLayout.CENTER);
		
		this.getContentPane().add(pano);

		//Déclencher le traitement long sur le clic du bouton:
		bouton.addActionListener(this::demarrerTraitementLong);
	}



	public void afficher() {
		this.setVisible(true);
	}
	
	private void demarrerTraitementLong(ActionEvent e)
	{
		textArea.setEnabled(true);
		textArea.setText("");
		CompteAReboursSwingWorker compteARebours = new CompteAReboursSwingWorker();
		compteARebours.addPropertyChangeListener(
						(PropertyChangeEvent pce)->
						{
							System.out.println(pce.getPropertyName());
							if("progress".equals(pce.getPropertyName()))
							{
								label.setText("Temps restant : " + compteARebours.getProgress());
							}
							else if("state".equals(pce.getPropertyName()))
							{
								if(compteARebours.getState()==StateValue.DONE)
								{
									try {
										label.setText(compteARebours.get() + 
												", nombre de caractères saisies : " + 
												textArea.getText().length());
										textArea.setEnabled(false);
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
							}
						});
		compteARebours.execute();
	}
}
