package fr.eni.editions.jdbc.requete;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class TestMappingTypeJavaSQL {

	public static void main(String[] args) {
		try (Connection cnx = getConnexion();
				PreparedStatement pstm = cnx.prepareStatement("insert into PERSONNES(nom, prenom, dateDeNaissance) values(?,?,?)");
				Statement stm = cnx.createStatement()) {
			insererPersonnes(pstm);
			lirePersonnes(stm);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private static void insererPersonnes(PreparedStatement pstm) throws SQLException {
		//L'instruction suivante permet de mettre en concordance 
		//la timezone de la JVM avec la timezone du serveur MySQL.
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		//Ajout d'une première personne
		//Appliquer les paramètres
		pstm.setString(1, "Eastwood");
		pstm.setString(2, "Clint");
		//Ecriture de la date de naissance
		//pstm.setObject(3, LocalDate.of(1930, 5, 31));
		//ou
		pstm.setDate(3, Date.valueOf(LocalDate.of(1930, 5, 31)));
		
		//Exécuter la requête
		int resultat = pstm.executeUpdate();
		if(resultat==1)
		{
			System.out.println("L'insertion a réussi");
		}
		
		//Ajout d'une seconde personne
		//Appliquer les paramètres
		pstm.setString(1, "Tarantino");
		pstm.setString(2, "Quentin");
		pstm.setObject(3, null);
		
		//Exécuter la requête
		resultat = pstm.executeUpdate();
		if(resultat==1)
		{
			System.out.println("L'insertion a réussi");
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
