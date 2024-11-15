package dao;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCConnexion extends OracleDataSource {

	private static final long serialVersionUID = 1L;
	private static Connection connexion;

	private JDBCConnexion() throws SQLException {
		this.setURL("jdbc:oracle:thin:@localhost:1521/xe");
		this.setUser("sae3a01");
		this.setPassword("$iutinfo");
	}

	public static synchronized Connection getConnexion() {
		if (connexion == null) {
			try {
				OracleDataSource bd = new JDBCConnexion();
				connexion = bd.getConnection();
				System.out.println("Connexion réussite");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connexion;
	}

	public static void closeConnexion() {
		if (connexion != null) {
			try {
				connexion.close();
				connexion = null;
				System.out.println("Connexion fermée");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		Connection connexion = JDBCConnexion.getConnexion();
		JDBCConnexion.closeConnexion();
	}
	
}