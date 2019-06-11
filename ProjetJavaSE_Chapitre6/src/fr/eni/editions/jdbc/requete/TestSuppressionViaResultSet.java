package fr.eni.editions.jdbc.requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

public class TestSuppressionViaResultSet {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				Statement stmSuppression = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				Statement stmLecture = cnx.createStatement()) {
			lireEtSupprimerPersonnes(stmSuppression);
			lirePersonnes(stmLecture);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private static void lireEtSupprimerPersonnes(Statement stmSuppression) throws SQLException {
		ResultSet rs = stmSuppression.executeQuery("select id, nom, prenom, dateDeNaissance from PERSONNES");
		while(rs.next())
		{
			//Suppression de l'enregistrement si la personnes s'appelle Eastwood
			System.out.println("Personne courante : " + rs.getString("nom"));
			if("Eastwood".equalsIgnoreCase(rs.getString("nom")))
			{
				System.out.println("Je supprime la personne");
				rs.deleteRow();
			}
		}
	}

	private static void lirePersonnes(Statement stm) throws SQLException {
		ResultSet rs = stm.executeQuery("select id, nom, prenom, dateDeNaissance from PERSONNES");
		System.out.println("id\t\tnom\t\tprénom\t\tdate de naissance");
		while(rs.next())
		{
			int id = rs.getInt("id");
			System.out.print(rs.wasNull()?"inconnu":id);
			System.out.print("\t\t");
			
			String nom = rs.getString("nom");
			System.out.print(rs.wasNull()?"inconnu":nom);
			System.out.print("\t\t");
			
			String prenom = rs.getString("prenom");
			System.out.print(rs.wasNull()?"inconnu":prenom);
			System.out.print("\t\t");
			
			Date sqlDate = rs.getDate("dateDeNaissance");
			System.out.println(rs.wasNull()?"inconnue":DateTimeFormatter.ofPattern("dd/MM/yyyy").format(sqlDate.toLocalDate()));
		}
		
	}
	private static Connection getConnexion() throws SQLException {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		return DriverManager.getConnection(url, user, password);
	}
}
