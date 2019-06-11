package fr.eni.editions.jdbc.connexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class TestConnexion {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		try {
			Connection cnx = DriverManager.getConnection(url, user, password);
			System.out.println("Etat de la connexion :");
			System.out.println(cnx.isClosed() ? "fermée" : "ouverte");

			testEstValide(cnx);
			testLectureSeule(cnx);
			affichageWarnings(cnx);
			changerDeBaseDeDonnes(cnx);
			cnx.setCatalog("demo_java");
			infosBase(cnx);
		} catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}

	}

	public static void testEstValide(Connection cnx) {
		boolean estValide;
		try {
			estValide = cnx.isValid(0);
			if (estValide) {
				System.out.println("la connexion est valide");
			} else {
				System.out.println("La connexion n'est pas valide");
			}
		} catch (Exception e) {
			System.out.println("La méthode isValid n'est pas prise en charge par le pilote");
			e.printStackTrace();
		}
	}

	public static void testLectureSeule(Connection cnx) {
		boolean etat;
		try {
			etat = cnx.isReadOnly();
			cnx.setReadOnly(!etat);
			if (cnx.isReadOnly() != etat) {
				System.out.println("le mode lecture seule est pris en charge par ce pilote");
			} else {
				System.out.println("le mode lecture seule n'est pas pris en charge par ce pilote");
			}
			cnx.setReadOnly(etat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void affichageWarnings(Connection cnx) {
		SQLWarning avertissement;
		try {
			avertissement = cnx.getWarnings();
			if (avertissement == null) {
				System.out.println("il n'y a pas d'avertissement");
			} else {
				while (avertissement != null) {
					System.out.println(avertissement.getMessage());
					System.out.println(avertissement.getSQLState());
					System.out.println(avertissement.getErrorCode());
					avertissement = avertissement.getNextWarning();
				}
			}
			cnx.clearWarnings();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void changerDeBaseDeDonnes(Connection cnx) {
		try {
			System.out.println("base actuelle : " + cnx.getCatalog());
			System.out.println("changement de base de données");
			cnx.setCatalog("demo_java_2");
			System.out.println("base actuelle : " + cnx.getCatalog());
		} catch (SQLException e) {
			System.out.println("Problème dans la manipulation des bases de données sur le serveur");
			e.printStackTrace();
		}
	}

	public static void infosBase(Connection cnx) {
		ResultSet rs;
		DatabaseMetaData dbmd;
		try {
			dbmd = cnx.getMetaData();
			System.out.println("type de base : " + dbmd.getDatabaseProductName());
			System.out.println("version: " + dbmd.getDatabaseProductVersion());
			System.out.println("nom du pilote : " + dbmd.getDriverName());
			System.out.println("version du pilote : " + dbmd.getDriverVersion());
			System.out.println("nom de l\'utilisateur : " + dbmd.getUserName());
			System.out.println("url de connexion : " + dbmd.getURL());
			rs = dbmd.getTables(null, null, "%", null);
			System.out.println("structure de la base");
			System.out.println("base\tschema\tnom table\ttype table");
			while (rs.next()) {
				for (int i = 1; i <= 4; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			rs.close();
			rs = dbmd.getProcedures(null, null, "%");
			System.out.println("les procédures stockées");
			System.out.println("base\tschema\tnom procedure");
			while (rs.next()) {
				for (int i = 1; i <= 3; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
