package fr.eni.editions.jdbc.requete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPositionPointeurResultSet {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				Statement stm = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			// Exécuter la requête et obtenir le résultat
			ResultSet rs = stm.executeQuery("select * from PERSONNES");
			
			afficherPositionPointeur(rs);
			// Tant qu'il y a des enregistrements
			while (rs.next()) {
				afficherPositionPointeur(rs);
			}
			afficherPositionPointeur(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void afficherPositionPointeur(ResultSet rs) {
		try {
			if (rs.isBeforeFirst()) {
				System.out.println("le pointeur est avant le premier enregistrement");
			}
			if (rs.isAfterLast()) {
				System.out.println("le pointeur est après le dernier enregistrement");
			}
			if (rs.isFirst()) {
				System.out.println("le pointeur est sur le premier enregistrement");
			}
			if (rs.isLast()) {
				System.out.println("le pointeur est sur le dernier enregistrement");
			}
			int position;
			position = rs.getRow();
			if (position != 0) {
				System.out.println("c'est l'enregistrement numéro " + position);
			}
		} catch (SQLException e) {
			// TODO Bloc catch autogénéré
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
