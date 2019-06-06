package fr.eni.editions.ihm40;


import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class CompteAReboursSwingWorker extends SwingWorker<String, Integer> {

	private JLabel label;
	private JTextArea textArea;
	
	public CompteAReboursSwingWorker(JLabel label, JTextArea textArea) {
		this.label=label;
		this.textArea=textArea;
	}

	//Méthode exécutée dans un thread enfant
	@Override
	protected String doInBackground() throws Exception {
		for(int i=10;i>=0;i--)
		{
			System.out.println(i);
			this.publish(i);
			Thread.sleep(1000);
		}
		return "terminé";
	}
	
	//Exécutée dans le thread EDT
	@Override
	protected void process(List<Integer> chunks) {
		label.setText("Temps restant : " + chunks.get(chunks.size()-1));
	}
	
	//Exécutée dans le thread EDT
	@Override
	protected void done() {
		try {
			label.setText(this.get() + 
					", nombre de caractères saisies : " + 
					textArea.getText().length());
			textArea.setEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
