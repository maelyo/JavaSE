package fr.eni.editions.heritage;

import java.time.LocalDate;

public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException{
		Client c; 
		c=new Client("ENI","",LocalDate.of(1981,05,15),TypeClient.ENTREPRISE); 
		Commande cmd1,cmd2; 
		// création et initialisation d'une commande 
		cmd1=new Commande(); 
		cmd1.setLeClient(c); 
		System.out.println("hashCode de la commande : " + cmd1.hashCode()); 
		System.out.println("hashCode du Client : " + cmd1.getLeClient().hashCode()); 
		System.out.println("hashCode des lignes : " 
		+cmd1.getLesLignes().hashCode()); 
		cmd2=(Commande)cmd1.clone(); 
		System.out.println("hashCode de la copie  : " +cmd2.hashCode()); 
		System.out.println("hashCode du Client de la copie: " + cmd2.getLeClient().hashCode()); 
		System.out.println("hashCode des lignes de la copie: " + cmd2.getLesLignes().hashCode());
	}

}
