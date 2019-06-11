package fr.eni.editions.jdbc.requete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {

	public static void main(String[] args) {
		mouvement("123456789", "987654321", 1000);
	}

	public static void mouvement(String compteDebit, String compteCredit, double somme) {
		try (Connection cnx = getConnexion()) {
			try (PreparedStatement pstm = cnx.prepareStatement("update COMPTES set solde=solde + ? where numero=?");) {
				cnx.setAutoCommit(false);
				pstm.setDouble(1, somme * -1);
				pstm.setString(2, compteDebit);
				pstm.executeUpdate();
				impressionRapport(compteDebit, somme * -1);
				pstm.setDouble(1, somme);
				pstm.setString(2, compteCredit);
				pstm.executeUpdate();
				impressionRapport(compteCredit, somme);
				//Validation des traitements
				System.out.println("Validation de la transaction");
				cnx.commit();
			} catch (Exception e) {
				try {
					//Annulation des traitements
					System.out.println("Annulation de la transaction");
					cnx.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private static void impressionRapport(String compte, double somme) throws Exception {
		System.out.println(compte + " : " + somme);
		//Décommentez la ligne suivante pour provoquer l'annulation des traitements
		throw new Exception("Erreur édition du rapport");
	}

	private static Connection getConnexion() throws SQLException {
		String url = "jdbc:mysql://localhost/demo_java?serverTimezone=UTC";
		String user = "mysqluser";
		String password = "Pa$$w0rd";
		return DriverManager.getConnection(url, user, password);
	}
}
