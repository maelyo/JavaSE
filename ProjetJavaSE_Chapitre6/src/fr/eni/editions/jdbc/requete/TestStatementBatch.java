package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatementBatch {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir vos instructions SQL puis run pour exécuter le lot :");
			String requete = br.readLine();
			while (!requete.equalsIgnoreCase("run")) {
				stm.addBatch(requete);
				requete = br.readLine();
			}
			System.out.println("exécution du lot d'instructions");
			int[] resultats = stm.executeBatch();
			for (int i = 0; i < resultats.length; i++) {
				switch (resultats[i]) {
				case Statement.EXECUTE_FAILED:
					System.out.println("l'exécution de l'instruction " + i + " a échoué");
					break;
				case Statement.SUCCESS_NO_INFO:
					System.out.println("l'exécution de l'instruction " + i + " a réussi");
					System.out.println("le nombre d'enregistrements modifiés est inconnu");
					break;
				default:
					System.out.println("l'exécution de l'instruction " + i + " a réussi");
					System.out.println("elle a modifié " + resultats[i] + " enregistrements");
					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("votre batch n'a pas fonctionné correctement");
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
