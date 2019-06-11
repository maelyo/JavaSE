package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir votre instruction SQL :");
			String requete = br.readLine();
			boolean resultat = stm.execute(requete);
			//Si vrai, il y a eu un résultat
			if (resultat) {
				System.out.println("votre instruction a généré un jeu d\'enregistrements");
				//Récupération du jeu de résultat
				ResultSet rs = stm.getResultSet();
				//Positionnement sur le dernier enregistrement
				rs.last();
				//Lecture de numéro de la ligne
				System.out.println("il contient " + rs.getRow() + " enregistrements");
			//si faux, il y a peut-être eu une mise à jour	
			} else {
				System.out.println("votre instruction a modifié des enregistrements dans la base");
				System.out.println("nombre d'enregistrements modifiés :" + stm.getUpdateCount());
			}
		} catch (SQLException e) {
			System.out.println("votre instruction n\'a pas fonctionné correctement");
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
