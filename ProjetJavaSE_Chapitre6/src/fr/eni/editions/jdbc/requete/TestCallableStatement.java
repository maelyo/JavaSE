package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCallableStatement {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				CallableStatement cstm = cnx.prepareCall("{call nombrePersonnesParNom ( ?, ? )}",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
			System.out.println("saisir le tri du résultat (ASC ou DESC) :");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String tri = br.readLine();
			// Application des paramètres
			cstm.setString(1, tri);
			cstm.registerOutParameter(2, java.sql.Types.INTEGER);
			// Exécution de la requête
			boolean existeResultat = cstm.execute();
			// Récupération du paramètre du type out
			int nombrePersonnes = cstm.getInt(2);
			System.out.println("nombre de personnes: " + nombrePersonnes);

			if (existeResultat) {
				ResultSet rs = cstm.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString("nom") + ": " + rs.getInt("nombrePersonnes") + " personnes");
				}
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
