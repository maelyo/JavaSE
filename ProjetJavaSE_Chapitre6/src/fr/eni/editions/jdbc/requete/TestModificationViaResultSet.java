package fr.eni.editions.jdbc.requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

public class TestModificationViaResultSet {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				Statement stmModif = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				Statement stmLecture = cnx.createStatement()) {
			lireEtModifierPersonnes(stmModif);
			lirePersonnes(stmLecture);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void lireEtModifierPersonnes(Statement stmModif) throws SQLException {
		ResultSet rs = stmModif.executeQuery("select id, nom, prenom, dateDeNaissance from PERSONNES");
		while(rs.next())
		{
			//Modification du nom en le mettant en majuscule
			rs.updateString("nom", rs.getString("nom").toUpperCase());
			rs.updateRow();
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
