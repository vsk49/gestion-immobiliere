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
		
		// mise a jour de la base de donnees (suppression des tables en cas d'erreur)
		try {
			requeteSQL.executeUpdate("DROP TABLE Caution");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Charge");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Locataire");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Garage");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Logement");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Compteur");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE FactureTravail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Loyer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE BienLouable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE Batiment");
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
			requeteSQL.executeUpdate("DROP TABLE Diagnostic");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
			requeteSQL.executeUpdate("DROP TABLE BienImmobilier");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		// creation des tables
		try {
			requeteSQL.executeQuery(
				"Create table Locataire ("
				+ "idLocataire VARCHAR2(10) PRIMARY KEY, "
				+ "nom VARCHAR2(50) NOT NULL, "
				+ "prenom VARCHAR2(50) NOT NULL, "
				+ "genre CHAR(1) CHECK (genre IN ('M', 'F')), "
				+ "dateNaissance DATE NOT NULL, "
				+ "lieuNaissance VARCHAR2(50), "
				+ "nationalite VARCHAR(50), "
				+ "profession VARCHAR(50), "
				+ "telephone VARCHAR(15), "
				+ "email VARCHAR(100), "
				+ "dateEntree DATE NOT NULL, "
				+ "dateDepart DATE, "
				+ "quotite BINARY_DOUBLE CHECK (quotite >= 0 AND quotite <= 1)"
				+ ")"
			);
			System.out.println("Table Locataire created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"Create table BienImmobilier ("
				+ "idBienImmobilier INTEGER PRIMARY KEY, "
				+ "numeroFiscal CHAR(12), "
				+ "adresse VARCHAR2(50) NOT NULL, "
				+ "codePostal NUMBER(5) NOT NULL, "
				+ "ville VARCHAR(50) NOT NULL, "
				+ "dateAnniversaire DATE NOT NULL, "
				+ "montantTaxesFoncieres BINARY_DOUBLE, "
				+ "ICCDateDebut NUMBER(4) NOT NULL"
				+ ")"
			);
			System.out.println("Table BienImmobilier created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
		    requeteSQL.executeQuery(
		        "CREATE TABLE Bail ("
		        + "idBail INTEGER PRIMARY KEY, "
		        + "dateDebut DATE NOT NULL, "
		        + "depotDeGarantie BINARY_DOUBLE, "
		        + "dateSignature DATE, "
		        + "dateFin DATE, "
		        + "indexAncienBail NUMBER(4), "
		        + "idBienImmobilier INTEGER, "
		        + "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
		        + ")"
		    );
		    System.out.println("Table Bail created.");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE BienLouable ("
				+ "idBienLouable INTEGER PRIMARY KEY, "
				+ "surface BINARY_DOUBLE, "
				+ "nbPieces NUMBER NOT NULL, "
				+ "idBienImmobilier INTEGER, "
				+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
				+ ")"
			);
			System.out.println("Table BienLouable created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Loyer ("
				+ "idLoyer INTEGER PRIMARY KEY, "
				+ "dateLoyer DATE NOT NULL, "
				+ "montantLoyer BINARY_DOUBLE, "
				+ "provisionPourCharge BINARY_DOUBLE NOT NULL, "
				+ "idBail INTEGER, "
				+ "idBienLouable INTEGER, "
				+ "FOREIGN KEY (idBail) REFERENCES Bail(idBail), "
				+ "FOREIGN KEY (idBienLouable) REFERENCES BienLouable(idBienLouable)"
				+ ")"
			);
			System.out.println("Table Loyer created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Compteur ("
				+ "idCompteur INTEGER PRIMARY KEY, "
				+ "numero CHAR(14) NOT NULL, "
				+ "typeCompteur VARCHAR2(11) CHECK (typeCompteur in ('EAU', 'ELECTRICITE')), "
				+ "indexAncien NUMBER(4) NOT NULL, "
				+ "indexActuel NUMBER(4), "
				+ "dateReleveEntree DATE, "
				+ "idBienLouable INTEGER, "
				+ "FOREIGN KEY (idBienLouable) REFERENCES BienLouable(idBienLouable)"
				+ ")"
				);
			System.out.println("Table Compteur created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
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
				+ "idBienLouable INTEGER, "
				+ "FOREIGN KEY (idBienLouable) REFERENCES BienLouable(idBienLouable)"
				+ ")"
				);
			System.out.println("Table FactureTravail created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Assurance ("
				+ "idAssurance INTEGER PRIMARY KEY, "
				+ "typeAssurance VARCHAR2(15) CHECK (typeAssurance IN ('PROPRIETAIRE', 'AIDE_JURIDIQUE')), "
				+ "nomAssureur VARCHAR2(50) NOT NULL, "
				+ "dateDebutAssurance DATE, "
				+ "quotiteJurisprudence BINARY_DOUBLE, "
				+ "protectionJuridique BINARY_DOUBLE, "
				+ "prime BINARY_DOUBLE, "
				+ "idBienImmobilier INTEGER, "
				+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
				+ ")"
				);
			System.out.println("Table Assurance created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
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
				+ "idBienImmobilier INTEGER, "
				+ "FOREIGN KEY (idBienImmobilier) REFERENCES BienImmobilier(idBienImmobilier)"
				+ ")"
				);
			System.out.println("Table Diagnostic created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
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
			System.out.println("Table Caution created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
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
			System.out.println("Table Charge created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Logement ("
				+ "idLogement INTEGER PRIMARY KEY, "
				+ "estEnColocation NUMBER(1) CHECK (estEnColocation BETWEEN 0 AND 1), "
				+ "idBienLouable INTEGER, "
				+ "FOREIGN KEY (idBienLouable) REFERENCES BienLouable(idBienLouable)"
				+ ")"
			);
			System.out.println("Table Logement created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Garage ("
				+ "idGarage INTEGER PRIMARY KEY, "
				+ "idLogement INTEGER, "
				+ "FOREIGN KEY (idLogement) REFERENCES Logement(idLogement)"
				+ ")"
			);
			System.out.println("Table Garage created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			requeteSQL.executeQuery(
				"CREATE TABLE Batiment ("
				+ "idBatiment INTEGER PRIMARY KEY"
				+ ")"
			);
			System.out.println("Table Batiment created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
