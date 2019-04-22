package fr.eni.editions.exceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestExceptions {

	public static void main(String[] args) {
		lireFichier("unFichierInconnu.txt");

	}

	/*public static void lireFichier(String nom) {
		FileInputStream fichier = null;
		BufferedReader br = null;
		String ligne = null;
		try {
			fichier = new FileInputStream(nom);
			br = new BufferedReader(new InputStreamReader(fichier));
			ligne = br.readLine();
			while (ligne != null) {
				System.out.println(ligne);
				ligne = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	public static void lireFichier(String nom) 
	{
		FileInputStream fichier = null;
		BufferedReader br = null;
		String ligne = null;
		double somme = 0;
	
		try 
		{
			fichier = new FileInputStream(nom);
			br = new BufferedReader(new InputStreamReader(fichier));
			ligne = br.readLine();
			while (ligne != null) {
				System.out.println(ligne);
				ligne = br.readLine();
				somme = somme + Double.parseDouble(ligne);
			}
			System.out.println("total : " + somme);
		}
		catch (IOException | NumberFormatException e) 
		{
			e.printStackTrace();
		}
	}

}
