package fr.eni.editions.ihm3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Principale {
	private JFrame fenetre;
	//Constructeur appelé par le thread EDT
	Principale(String[] args) {
        // Construction de l'IHM
		// création de la fenêtre 
        this.fenetre=new JFrame(); 
        this.fenetre.setTitle("première fenêtre en JAVA"); 
        this.fenetre.setBounds(0,0,300,100); 
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // création des trois boutons 
        JButton b1,b2,b3; 
        b1=new JButton("Rouge"); 
        b2=new JButton("Vert"); 
        b3=new JButton("Bleu"); 
        // création du conteneur intermédiaire 
        JPanel pano; 
        pano=new JPanel(); 
        // ajout des boutons sur le conteneur intermédiaire 
        pano.add(b1); 
        pano.add(b2); 
        pano.add(b3); 
        // ajout du conteneur intermédiaire sur le ContentPane 
        this.fenetre.getContentPane().add(pano);
    }

	//Méthode appelée par le thread EDT
    public void afficher() {
        // Affichage de l'IHM
    	this.fenetre.setVisible(true);
    }

    //Point d'entrée exécuté par le thread main
    public static void main(final String[] args) {
        // Programme une tâche pour le thread EDT:
        // Création et affichage de l'interface graphique
        /*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Principale3(args).afficher();
            }
        });*/
    	SwingUtilities.invokeLater(()->new Principale(args).afficher());
    }
}
