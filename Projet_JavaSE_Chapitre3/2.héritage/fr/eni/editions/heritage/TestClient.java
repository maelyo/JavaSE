package fr.eni.editions.heritage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;


public class TestClient {

	public static void main(String[] args) throws FileNotFoundException {
		Client c; 
		c=new Client(); 
		c.setNom("ENI"); 
		c.setPrenom(""); 
		c.setDateDeNaissance(LocalDate.of(1981,05,15)); 
		c.setType(TypeClient.ENTREPRISE); 
		c.afficher();
		
		Client c2 = new Client("ENI", "", LocalDate.of(1981,05,15), TypeClient.ENTREPRISE);
		c2.afficher();
		FileInputStream fis = new FileInputStream("fichierInconnu.txt");
	}

}
