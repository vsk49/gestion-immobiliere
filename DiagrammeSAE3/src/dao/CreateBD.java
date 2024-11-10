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
	
	public CreateBD() {
		try {
			Connection connexion = JDBCConnexion.getConnexion();
			createTablesBD(connexion);
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createTablesBD(Connection connexion) throws SQLException {
		Statement requeteSQL = null;
		
		// initialisation de la requete SQL
		try {
			requeteSQL = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		// mise a jour de la base de donnees (supression des tables en cas d'erreur)
		try {
			requeteSQL.executeUpdate("DROP TABLE Locataire");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeUpdate("DROP TABLE BienImmobilier");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Bail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Assurance");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Loyer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Compteur");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Caution");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Bail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Charge");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE FactureTravail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Diagnostic");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		// creation des tables
		
	}

}
