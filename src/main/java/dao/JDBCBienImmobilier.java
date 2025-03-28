package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import modele.Batiment;
import modele.BienImmobilier;
import modele.Garage;
import modele.Logement;

public class JDBCBienImmobilier implements DAO<BienImmobilier, String> {

	private static final Connection jdbcConnexion = JDBCConnexion.getConnexion();
	private static final Logger LOGGER = Logger.getLogger(JDBCBienImmobilier.class.getName());

	@Override
	public List<BienImmobilier> getAll() {
		List<BienImmobilier> biensImmobiliers = new ArrayList<>();
		String requete = "SELECT idBienImmobilier, adresse, codePostal, ville, dateAcquisition, typeBien, " +
				"nombreEtages, periodeConstruction, numeroEtage, surfaceHabitable, nbPieces " +
				"FROM BienImmobilier";
		try (ResultSet resultat = jdbcConnexion.createStatement().executeQuery(requete)) {
			while (resultat.next()) {
				BienImmobilier b = distinguerTypesBien(resultat);
				biensImmobiliers.add(b);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return biensImmobiliers;
	}

	// Distingue les types de biens immobiliers
	private BienImmobilier distinguerTypesBien(ResultSet resultat) throws SQLException {
		String typeBien = resultat.getString("typeBien");
		return switch (typeBien) {
			case "BATIMENT" -> new Batiment(
					resultat.getString("idBienImmobilier"),
					resultat.getString("adresse"),
					resultat.getInt("codePostal"),
					resultat.getString("ville"),
					resultat.getInt("nombreEtages"),
					resultat.getString("periodeConstruction")
			);
			case "LOGEMENT" -> new Logement(
					resultat.getString("idBienImmobilier"),
					resultat.getString("adresse"),
					resultat.getInt("codePostal"),
					resultat.getString("ville"),
					resultat.getDate("dateAcquisition") != null ? resultat.getDate("dateAcquisition").toLocalDate() : null,
					resultat.getInt("numeroEtage"),
					resultat.getDouble("surfaceHabitable"),
					resultat.getInt("nbPieces")
			);
			default -> new Garage(
					resultat.getString("idBienImmobilier"),
					resultat.getString("adresse"),
					resultat.getInt("codePostal"),
					resultat.getString("ville"),
					resultat.getDate("dateAcquisition") != null ? resultat.getDate("dateAcquisition").toLocalDate() : null
			);
		};
	}

	@Override
	public Optional<BienImmobilier> getById(String id) {
		Optional<BienImmobilier> bien = Optional.empty();
		String requete = "SELECT idBienImmobilier, adresse, codePostal, ville, dateAcquisition, typeBien, " +
				"nombreEtages, periodeConstruction, numeroEtage, surfaceHabitable, nbPieces " +
				"FROM BienImmobilier WHERE idBienImmobilier = ?";
		try (PreparedStatement statement = jdbcConnexion.prepareStatement(requete)) {
			statement.setString(1, id);
			ResultSet resultat = statement.executeQuery();
			if (resultat.next()) {
				bien = Optional.of(distinguerTypesBien(resultat));
			}
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return bien;
	}

	@Override
	public boolean insert(BienImmobilier t) {
		String insertion = "INSERT INTO BienImmobilier (idBienImmobilier, adresse, codePostal, ville, typeBien, " +
				"nombreEtages, periodeConstruction, dateAcquisition, numeroEtage, surfaceHabitable, nbPieces) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = jdbcConnexion.prepareStatement(insertion)) {
			statement.setString(1, t.getIdBienImmobilier());
			statement.setString(2, t.getAdresse());
			statement.setInt(3, t.getCodePostal());
			statement.setString(4, t.getVille());
			configurerParametresBien(t, statement);
			statement.executeUpdate();
			LOGGER.info("Le bien " + t.getIdBienImmobilier() + " a ete insere.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			return false;
		}
		return true;
	}

	// Configure les paramètres spécifiques à chaque type de bien
	private void configurerParametresBien(BienImmobilier t, PreparedStatement statement) throws SQLException {
		if (t instanceof Batiment batiment) {
            statement.setString(5, "BATIMENT");
			statement.setInt(6, batiment.getNombreEtages());
			statement.setString(7, batiment.getPeriodeConstruction());
			statement.setDate(8, null);
			statement.setInt(9, 0);
			statement.setDouble(10, 0);
			statement.setInt(11, 0);
		} else if (t instanceof Logement logement) {
			statement.setString(5, "LOGEMENT");
			statement.setInt(6, 0);
			statement.setString(7, "");
			statement.setDate(8, Date.valueOf(t.getDateAcquisition()));
			statement.setInt(9, logement.getNumeroEtage());
			statement.setDouble(10, logement.getSurfaceHabitable());
			statement.setInt(11, logement.getNbPieces());
		} else {
			statement.setString(5, "GARAGE");
			statement.setInt(6, 0);
			statement.setString(7, "");
			statement.setDate(8, Date.valueOf(t.getDateAcquisition()));
			statement.setInt(9, 0);
			statement.setDouble(10, 0);
			statement.setInt(11, 0);
		}
	}

	@Override
	public boolean update(BienImmobilier t) {
		String misAJour = "UPDATE BienImmobilier SET periodeConstruction = ? WHERE idBienImmobilier = ?";
		try (PreparedStatement statement = jdbcConnexion.prepareStatement(misAJour)) {
			statement.setString(1, ((Batiment) t).getPeriodeConstruction());
			statement.setString(2, t.getIdBienImmobilier());
			statement.executeUpdate();
			LOGGER.info("Bien " + t.getIdBienImmobilier() + " a ete mis a jour.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(BienImmobilier t) {
		String suppression = "DELETE FROM BienImmobilier WHERE idBienImmobilier = ?";
		try (PreparedStatement statement = jdbcConnexion.prepareStatement(suppression)) {
			statement.setString(1, t.getIdBienImmobilier());
			statement.executeUpdate();
			LOGGER.info("Bien " + t.getIdBienImmobilier() + " a ete supprime.");
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
			return false;
		}
		return true;
	}

}
