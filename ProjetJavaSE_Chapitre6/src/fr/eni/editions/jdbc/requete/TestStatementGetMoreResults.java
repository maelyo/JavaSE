package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatementGetMoreResults {

	public static void main(String[] args) {
		boolean resultat;
		ResultSet rs;
		try (Connection cnx = getConnexion();
				Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir vos instructions SQL séparées par ; :");
			String requete = br.readLine();
			resultat = stm.execute(requete);
			int i = 1;
			// traitement du résultat généré par la première
			// instruction
			if (resultat) {
				System.out.println("votre instruction N° " + i + " a généré un jeu d'enregistrements");
				rs = stm.getResultSet();
				rs.last();
				System.out.println("il contient " + rs.getRow() + " enregistrements");
			} else {
				System.out.println("votre instruction N° " + i + " a modifié des enregistrements dans la base");
				System.out.println("nombre d'enregistrements modifiés :" + stm.getUpdateCount());
			}
			i++;
			// déplacement du pointeur sur un éventuel résultat
			// suivant
			resultat = stm.getMoreResults();
			// boucle tant qu'il y a encore un résultat de type jeu
			// d'enregistrement -> resultat==true
			// ou qu'il y a encore un resultat de type nombre
			// d'enregistrements modifiés -> getUpdateCount != -1
			while (resultat || stm.getUpdateCount() != -1) {
				if (resultat) {
					System.out.println("votre instruction N° " + i + " a généré un jeu d\'enregistrements");
					rs = stm.getResultSet();
					rs.last();
					System.out.println("il contient " + rs.getRow() + " enregistrements");
				} else {
					System.out.println("votre instruction N° " + i + " a modifié des enregistrements dans la base");
					System.out.println("nombre d'enregistrements modifiés :" + stm.getUpdateCount());
				}
				i++;
				// déplacement du pointeur sur un éventuel résultat
				// suivant
				resultat = stm.getMoreResults();
			}
		} catch (SQLException e) {
			System.out.println("votre instruction n'a pas fonctionné correctement");
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnexion() throws SQLException {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC&allowMultiQueries=true";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		return DriverManager.getConnection(url, user, password);
	}

}
