
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class JDBCConnexion extends OracleDataSource {

	private static Connection connection;

	private JDBCConnexion() {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
		this.setUser("khv4609a");
		this.setPassword("$iutinfo");
	}

	public static synchronized Connection getConnection() {
		if (connection == null) {
			try {
				OracleDataSource bd = new JDBCConnexion();
				Connection cn = bd.getConnection();
				System.out.println("Connexion réussite");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			connection = null;
		}
	}

}
