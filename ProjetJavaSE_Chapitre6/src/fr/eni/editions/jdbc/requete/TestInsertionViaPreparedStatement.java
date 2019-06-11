package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertionViaPreparedStatement {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				//Requête d'insertion avec les champs obligatoires
				PreparedStatement pstm = cnx.prepareStatement("insert into PERSONNES(nom, prenom) values(?,?)",
						Statement.RETURN_GENERATED_KEYS)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir le nom de la personne à ajouter :");
			String nom = br.readLine();
			System.out.println("saisir le prénom de la personne à ajouter :");
			String prenom = br.readLine();
			//Appliquer les paramètres
			pstm.setString(1, nom);
			pstm.setString(2, prenom);
			//Exécuter la requête et obtenir le résultat
			pstm.executeUpdate();
			//Récupérer le ResultSet contenant éventuellement une clé
			ResultSet rsCleGeneree = pstm.getGeneratedKeys();
			//S'il y a un enregistrement, c'est qu'il y a une clé
			if(rsCleGeneree.next())
			{
				System.out.println("La clé de l'enregistrement générée est " + rsCleGeneree.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Connection getConnexion() throws SQLException {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		return DriverManager.getConnection(url, user, password);
	}

}
