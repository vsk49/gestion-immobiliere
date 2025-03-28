package dao;

import java.sql.*;
import java.util.logging.Logger;

public class CreateBD {

	private static final Connection jdbcConnexion = JDBCConnexion.getConnexion();
	private static final Logger LOGGER = Logger.getLogger(CreateBD.class.getName());
	
	public static void main(String[] args) {
        dropTablesBD();
        createTablesBD();
        JDBCConnexion.closeConnexion();
    }

	// suppression des tables en cas d'erreur
	private static void dropTablesBD() {
		try (Statement requeteSQL = jdbcConnexion.createStatement()) {
			requeteSQL.executeUpdate("DROP TABLE Locataire");
			requeteSQL.executeUpdate("DROP TABLE BienImmobilier");
			requeteSQL.executeUpdate("DROP TABLE Proprietaire");
			LOGGER.info("Tables dropped.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			System.exit(-1);
		}
	}

	// creation des tables
	private static void createTablesBD() {
		try (Statement requeteSQL = jdbcConnexion.createStatement()) {
			requeteSQL.executeQuery(
					"Create table Locataire ("
							+ "idLocataire VARCHAR2(10) PRIMARY KEY, "
							+ "nom VARCHAR2(50) NOT NULL, "
							+ "prenom VARCHAR2(50) NOT NULL, "
							+ "dateNaissance DATE NOT NULL, "
							+ "email VARCHAR(100), "
							+ "telephone VARCHAR(21)"
							+ ")"
			);
			LOGGER.info("Table Locataire created.");
			requeteSQL.executeQuery(
					"Create table BienImmobilier ("
							+ "idBienImmobilier VARCHAR2(13) PRIMARY KEY, "
							+ "adresse VARCHAR2(50) NOT NULL, "
							+ "codePostal NUMBER(5) NOT NULL , "
							+ "ville VARCHAR(50) NOT NULL , "
							+ "typeBien VARCHAR2(15) CHECK (typeBien IN ('BATIMENT', 'LOGEMENT', 'GARAGE')), "
							+ "nombreEtages NUMBER(4), "
							+ "periodeConstruction VARCHAR2(20), "
							+ "dateAcquisition DATE, "
							+ "numeroEtage NUMBER(4), "
							+ "surfaceHabitable DOUBLE PRECISION, "
							+ "nbPieces NUMBER(4)"
							+ ")"
			);
			LOGGER.info("Table BienImmobilier created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Proprietaire ("
							+ "IdProprietaire VARCHAR2(50) PRIMARY KEY, "
							+ "MotDePasse VARCHAR2(50) "
							+ ")"
			);
			LOGGER.info("Table Proprietaire created.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			System.exit(-1);
		}
	}

}
