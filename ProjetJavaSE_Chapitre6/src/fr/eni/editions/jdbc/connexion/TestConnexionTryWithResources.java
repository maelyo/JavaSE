package fr.eni.editions.jdbc.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionTryWithResources {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		//Utilisation de l'instruction try with resources
		try(Connection cnx = DriverManager.getConnection(url, user, password)) {
			System.out.println("Etat de la connexion :");
			System.out.println(cnx.isClosed() ? "fermée" : "ouverte");
		}//fermeture automatique de la connexion 
		catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}
	}
}
