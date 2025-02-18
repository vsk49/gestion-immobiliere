package dao;

import java.sql.*;
import java.util.logging.Logger;

public class CreateBD {

	private static final Connection jdbcConnexion = JDBCConnexion.getConnexion();
	private static final Logger LOGGER = Logger.getLogger(CreateBD.class.getName());
	
	public static void main(String[] args) {
		try {
			dropTablesBD();
			createTablesBD();
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
	}

	// suppression des tables en cas d'erreur
	private static void dropTablesBD() throws SQLException {
		try (Statement requeteSQL = jdbcConnexion.createStatement()) {
			requeteSQL.executeUpdate("DROP TABLE TaxeFonciere");
			requeteSQL.executeUpdate("DROP TABLE Caution");
			requeteSQL.executeUpdate("DROP TABLE Charge");
			requeteSQL.executeUpdate("DROP TABLE Locataire");
			requeteSQL.executeUpdate("DROP TABLE Compteur");
			requeteSQL.executeUpdate("DROP TABLE FactureTravail");
			requeteSQL.executeUpdate("DROP TABLE Loyer");
			requeteSQL.executeUpdate("DROP TABLE Bail");
			requeteSQL.executeUpdate("DROP TABLE Diagnostic");
			requeteSQL.executeUpdate("DROP TABLE Assurance");
			requeteSQL.executeUpdate("DROP TABLE BienImmobilier");
			requeteSQL.executeUpdate("DROP TABLE Proprietaire");
			LOGGER.info("Tables dropped.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			System.exit(-1);
		}
	}

	// creation des tables
	private static void createTablesBD() throws SQLException {
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
					"CREATE TABLE Bail ("
							+ "idBail INTEGER PRIMARY KEY, "
							+ "dateDebut DATE NOT NULL, "
							+ "depotDeGarantie BINARY_DOUBLE, "
							+ "dateSignature DATE, "
							+ "dateFin DATE, "
							+ "indexAncienBail NUMBER(4), "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table Bail created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Loyer ("
							+ "idLoyer INTEGER PRIMARY KEY, "
							+ "dateLoyer DATE NOT NULL, "
							+ "montantLoyer BINARY_DOUBLE, "
							+ "provisionPourCharge BINARY_DOUBLE NOT NULL, "
							+ "idBail INTEGER, "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBail) REFERENCES Bail(idBail), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table Loyer created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Compteur ("
							+ "idCompteur INTEGER PRIMARY KEY, "
							+ "numero CHAR(14) NOT NULL, "
							+ "typeCompteur VARCHAR2(11) CHECK (typeCompteur in ('EAU', 'ELECTRICITE')), "
							+ "indexAncien NUMBER(4) NOT NULL, "
							+ "indexActuel NUMBER(4), "
							+ "dateReleveEntree DATE, "
							+ "volumeEauConsommee NUMBER(4), "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table Compteur created.");
			requeteSQL.executeQuery(
					"CREATE TABLE FactureTravail ("
							+ "idFactureTravail INTEGER PRIMARY KEY, "
							+ "numeroFacture CHAR(10) NOT NULL, "
							+ "dateFacture DATE NOT NULL, "
							+ "nature VARCHAR2(50), "
							+ "montant BINARY_DOUBLE, "
							+ "entreprise VARCHAR2(50), "
							+ "referenceDevis CHAR(10), "
							+ "montantDevis BINARY_DOUBLE, "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table FactureTravail created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Assurance ("
							+ "idAssurance INTEGER PRIMARY KEY, "
							+ "typeAssurance VARCHAR2(15) CHECK (typeAssurance IN ('PROPRIETAIRE', 'AIDE_JURIDIQUE')), "
							+ "nomAssureur VARCHAR2(50) NOT NULL, "
							+ "dateDebutAssurance DATE, "
							+ "quotiteJurisprudence BINARY_DOUBLE, "
							+ "protectionJuridique BINARY_DOUBLE, "
							+ "prime BINARY_DOUBLE, "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table Assurance created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Diagnostic ("
							+ "idDiagnostic INTEGER PRIMARY KEY, "
							+ "reference VARCHAR2(15) NOT NULL, "
							+ "dateRealisation DATE NOT NULL, "
							+ "type VARCHAR2(15), "
							+ "dateExpiration DATE, "
							+ "classification CHAR(1) CHECK (classification IN ('A', 'B', 'C', 'D', 'E', 'F')), "
							+ "operateur VARCHAR(50), "
							+ "numeroRapport CHAR(15), "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table Diagnostic created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Caution ("
							+ "idCaution INTEGER PRIMARY KEY, "
							+ "nom VARCHAR2(50) NOT NULL, "
							+ "prenom VARCHAR2(50) NOT NULL, "
							+ "dateNaissance DATE NOT NULL, "
							+ "nationalite VARCHAR(50), "
							+ "adresse VARCHAR2(50), "
							+ "codePostal NUMBER(5), "
							+ "ville VARCHAR2(15), "
							+ "profession VARCHAR(50), "
							+ "employeur VARCHAR2(50), "
							+ "revenusMensuelsNet BINARY_DOUBLE, "
							+ "typeContratTravail VARCHAR2(10), "
							+ "lienLocataire VARCHAR2(10), "
							+ "dateSignature DATE, "
							+ "montantCautionne BINARY_DOUBLE, "
							+ "idLocataire VARCHAR2(10), "
							+ "FOREIGN KEY (idLocataire) REFERENCES Locataire(idLocataire)"
							+ ")"
			);
			LOGGER.info("Table Caution created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Charge ("
							+ "idCharge INTEGER PRIMARY KEY, "
							+ "dateDebut DATE NOT NULL, "
							+ "dateFin DATE, "
							+ "montantEau BINARY_DOUBLE, "
							+ "montantCoPropriete BINARY_DOUBLE, "
							+ "montantElectricite BINARY_DOUBLE, "
							+ "idLocataire VARCHAR2(10), "
							+ "FOREIGN KEY (idLocataire) REFERENCES Locataire(idLocataire)"
							+ ")"
			);
			LOGGER.info("Table Charge created.");
			requeteSQL.executeQuery(
					"CREATE TABLE Proprietaire ("
							+ "IdProprietaire VARCHAR2(50) PRIMARY KEY, "
							+ "MotDePasse VARCHAR2(50) "
							+ ")"
			);
			LOGGER.info("Table Proprietaire created.");
			requeteSQL.executeQuery(
					"CREATE TABLE TaxeFonciere ("
							+ "idTaxeFonciere INTEGER PRIMARY KEY, "
							+ "annee NUMBER(4) NOT NULL, "
							+ "montantBase BINARY_DOUBLE, "
							+ "idBienImmobilier VARCHAR2(13), "
							+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
							+ ")"
			);
			LOGGER.info("Table TaxeFonciere created.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			System.exit(-1);
		}
	}

}
