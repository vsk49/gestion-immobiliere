package modele;

import java.io.Serial;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCConnexion extends OracleDataSource {

	@Serial
	private static final long serialVersionUID = 1L;
	private static Connection connexion;

	private JDBCConnexion() throws SQLException {
		this.setURL("jdbc:oracle:thin:@//localhost:1521/XEPDB1");
		this.setUser("SAE3A01");
		this.setPassword("$iutinfo");
	}

	public static synchronized Connection getConnexion() {
		if (connexion == null) {
			try {
				OracleDataSource bd = new JDBCConnexion();
				connexion = bd.getConnection();
				System.out.println("Connexion réussite");
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + " : " + e.getMessage());
			}
		}
		return connexion;
	}

	public static void closeConnexion() {
		if (connexion != null) {
			connexion = null;
			System.out.println("Connexion fermée");
		}
	}
	
}