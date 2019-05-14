package fr.eni.editions.ihm27;

import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Ecran extends JFrame

{
	JPanel pano;
	JProgressBar pgbHeure, pgbMinutes, pgbSeconde, pgbDefil;

	public Ecran() {
		setTitle("Horloge");
		setBounds(0, 0, 400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// création des composants
		pgbHeure = new JProgressBar();
		pgbMinutes = new JProgressBar();
		pgbSeconde = new JProgressBar();
		pgbDefil = new JProgressBar();
		pgbHeure.setMinimum(0);
		pgbHeure.setMaximum(23);
		pgbMinutes.setMinimum(0);
		pgbMinutes.setMaximum(59);
		pgbSeconde.setMinimum(0);
		pgbSeconde.setMaximum(59);
		pgbHeure.setString("heure");
		pgbHeure.setStringPainted(true);
		pgbMinutes.setString("minute");
		pgbMinutes.setStringPainted(true);
		pgbSeconde.setString("seconde");
		pgbSeconde.setStringPainted(true);
		pgbDefil.setString("le temps passe");
		pgbDefil.setStringPainted(true);
		pgbDefil.setIndeterminate(true);
		pano = new JPanel();
		pano.add(pgbHeure);
		pano.add(pgbMinutes);
		pano.add(pgbSeconde);
		pano.add(pgbDefil);
		getContentPane().add(pano);
		Thread th;
		th = new Thread() {
			public void run() {
				while (true) {
					LocalTime d;
					d = LocalTime.now();
					pgbHeure.setValue(d.getHour());
					pgbMinutes.setValue(d.getMinute());
					pgbSeconde.setValue(d.getSecond());
					try {
						sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		th.start();
	}

	public void afficher() {
		this.setVisible(true);
	}
}
