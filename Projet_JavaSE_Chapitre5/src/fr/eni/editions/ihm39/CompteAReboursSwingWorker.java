package fr.eni.editions.ihm39;


import javax.swing.SwingWorker;

public class CompteAReboursSwingWorker extends SwingWorker<String, Integer> {

	//Méthode exécutée dans un thread enfant
	@Override
	protected String doInBackground() throws Exception {
		for(int i=10;i>=0;i--)
		{
			System.out.println(i);
			this.setProgress(i);
			Thread.sleep(1000);
		}
		return "terminé";
	}
}
