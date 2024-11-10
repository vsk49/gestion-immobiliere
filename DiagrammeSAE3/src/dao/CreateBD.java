package dao;

import java.sql.*;

public class CreateBD {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			CreateBD monBD = new CreateBD();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CreateBD() throws Exception {
		Connection connexion;
		try {
			connexion = JDBCConnexion.getConnexion();
			createTablesBD(connexion);
			JDBCConnexion.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createTablesBD(Connection connexion) throws Exception {
		Statement requeteSQL = null;
		
		// initialisation de la requete SQL
		try {
			requeteSQL = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// mise a jour de la base de donnees (s'il y a deja des tables, elles sont supprimees)
		try {
			requeteSQL.executeUpdate("DROP TABLE Etudiant");
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}

	}

}
