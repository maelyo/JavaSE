package fr.eni.editions.ihm36;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ecran extends JFrame {

	public Ecran() {
		setTitle("Boîte de dialogue");
		setBounds(0, 0, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String nom;
		nom = JOptionPane.showInputDialog("saisir le nom du client");
		System.out.println("Le nom saisi est : " + nom);

		nom = JOptionPane.showInputDialog(null, "saisir le nom du client", "recherche d'un client",
				JOptionPane.WARNING_MESSAGE);
		System.out.println("Le nom saisi est : " + nom);

		Personne[] choix;
		choix = new Personne[5];
		choix[0] = new Personne("Wayne", "John", LocalDate.of(1907, 5, 26));
		choix[1] = new Personne("McQueen", "Steeve", LocalDate.of(1930, 3, 24));
		choix[2] = new Personne("Lennon", "John", LocalDate.of(1940, 10, 9));
		choix[3] = new Personne("Gibson", "Mel", LocalDate.of(1956, 1, 3));
		choix[4] = new Personne("Willis", "Bruce", LocalDate.of(1955, 3, 19));

		Personne choisie;

		choisie = (Personne) JOptionPane.showInputDialog(null, "sélectionner le client", "recherche d'un client",
				JOptionPane.WARNING_MESSAGE, null, choix, choix[1]);
		System.out.println("La personne choisie est : " + choisie);

		JOptionPane.showMessageDialog(null, "le client est introuvable", "recherche d'un client",
				JOptionPane.WARNING_MESSAGE);

		int reponse = JOptionPane.showConfirmDialog(null, "voulez vous quitter sans enregistrer",
				"fermeture de l'application", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		System.out.println("LA réponse est : " + reponse);

	}

	public void afficher() {
		this.setVisible(true);
	}
}
