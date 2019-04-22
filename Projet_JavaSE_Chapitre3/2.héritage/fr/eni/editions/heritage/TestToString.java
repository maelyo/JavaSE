package fr.eni.editions.heritage;

import java.time.LocalDate;

public class TestToString {
	public static void main(String[] args) {
		Client c; 
		c=new Client("ENI",
				     "",
				     LocalDate.of(1981,05,15),
				     TypeClient.ENTREPRISE); 
		//La méthode println prenant un objet en paramètre
		//teste la non nullité de l'objet avant d'appeler
		//la méthode toString de cet objet
		System.out.println(c);
		//La méthode println suivante affiche la chaine
		//de caractères passée en paramètre
		System.out.println(c.toString());
	}
}
