package dao;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCConnexion extends OracleDataSource {

	private static final long serialVersionUID = 1L;
	private static Connection connexion;

	private JDBCConnexion() throws SQLException {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
		this.setUser("khv4609a");
		this.setPassword("$iutinfo");
	}

	public static synchronized Connection getConnexion() {
		if (connexion == null) {
			try {
				OracleDataSource bd = new JDBCConnexion();
				@SuppressWarnings("unused")
				Connection connexion = bd.getConnection();
				System.out.println("Connexion réussite");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connexion;
	}

	public static void closeConnexion() {
		if (connexion != null) {
			connexion = null;
		}
	}
	
	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		Connection connexion = JDBCConnexion.getConnexion();
	}

}
