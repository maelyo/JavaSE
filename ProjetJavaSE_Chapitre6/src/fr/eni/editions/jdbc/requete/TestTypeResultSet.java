package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTypeResultSet {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				PreparedStatement pstm = cnx.prepareStatement("select * from PERSONNES where nom = ?",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir le nom de la personne recherchée :");
			String nom = br.readLine();
			// Appliquer les paramètres
			pstm.setString(1, nom);
			// Ex�cuter la requête et obtenir le résultat
			ResultSet rs = pstm.executeQuery();
			afficherTypeResultSet(rs);
			// Tant qu'il y a des enregistrements
			while (rs.next()) {
				// Boucler sur le nombre de colonnes pour afficher les informations
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void afficherTypeResultSet(ResultSet rs) {
		try {
			switch (rs.getType()) {
			case ResultSet.TYPE_FORWARD_ONLY:
				System.out.println("le ResultSet est à défilement en avant seulement");
				break;
			case ResultSet.TYPE_SCROLL_INSENSITIVE:
				System.out.println("le ResultSet peut être parcouru dans les deux sens");
				System.out.println("il n'est pas sensible aux modifications faites par d'autres utilisateurs");
				break;
			case ResultSet.TYPE_SCROLL_SENSITIVE:
				System.out.println("le ResultSet peut être parcouru dans les deux sens");
				System.out.println("il est sensible aux modifications faites par d'autres utilisateurs");
				break;
			}
			switch (rs.getConcurrency()) {
			case ResultSet.CONCUR_READ_ONLY:
				System.out.println("les données contenues dans le ResulSet sont en lecture seule");
				break;
			case ResultSet.CONCUR_UPDATABLE:
				System.out.println("les données contenues dans le ResulSet sont modifiables");
				break;
			}
		} catch (SQLException e) {
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
