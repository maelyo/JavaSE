package fr.eni.editions.jdbc.requete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				PreparedStatement pstm = cnx.prepareStatement("select * from PERSONNES where nom = ?",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("saisir le nom de la personne recherchée :");
			String nom = br.readLine();
			//Appliquer les paramètres
			pstm.setString(1, nom);
			//Exécuter la requête et obtenir le résultat
			ResultSet rs = pstm.executeQuery();
			//Tant qu'il y a des enregistrements
			while (rs.next()) {
				//Boucler sur le nombre de colonnes pour afficher les informations
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

	private static Connection getConnexion() throws SQLException {
		String url = Parametres.getValeur("url");
		String user = Parametres.getValeur("user");
		String password = Parametres.getValeur("password");
		return DriverManager.getConnection(url, user, password);
	}

}
