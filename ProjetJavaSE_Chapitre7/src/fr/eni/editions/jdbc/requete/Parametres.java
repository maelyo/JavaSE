package fr.eni.editions.jdbc.requete;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class Parametres {
	//Objet permettant de stocker en mémoire le contenu du fichier properties
	private static Properties props = new Properties();
	
	//Chargement du fichier au chargement de la classe
	static {
		try(FileInputStream input = new FileInputStream("./conf/configuration.properties")){
			props.load(input);
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param cle
	 * @return la valeur associée à la clé ou une {@link RuntimeException} en cas d'absence de valeur
	 */
	public static String getValeur(String cle) {
		String valeur = props.getProperty(cle);
		if(valeur!=null) {
			return valeur;
		}
		throw new RuntimeException("Le fichier configuration.properties n'est pas disponible");
	}
}
 