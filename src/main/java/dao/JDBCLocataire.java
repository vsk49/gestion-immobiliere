package dao;

import java.util.logging.Logger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Locataire;

public class JDBCLocataire implements DAO<Locataire, String> {

	private static final Logger LOGGER = Logger.getLogger(JDBCLocataire.class.getName());

	@Override
	public List<Locataire> getAll() {
		List<Locataire> locataires = new ArrayList<>();
		String requete = "SELECT idLocataire, nom, prenom, dateNaissance, email, telephone FROM Locataire";
		try (ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery(requete)) {
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Locataire l = getLocataire(resultat);
				locataires.add(l);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return locataires;
	}

	private static Locataire getLocataire(ResultSet resultat) throws SQLException {
		return new Locataire(
				resultat.getString("idLocataire"),
				resultat.getString("nom"),
				resultat.getString("prenom"),
				resultat.getDate("dateNaissance").toLocalDate(),
				resultat.getString("email"),
				resultat.getString("telephone")
		);
	}

	@Override
	public Optional<Locataire> getById(String idLocataire) {
		Optional<Locataire> locataire = Optional.empty();
		String sql = "SELECT idLocataire, nom, prenom, dateNaissance, email, telephone FROM Locataire where IDLOCATAIRE = ?";
		try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(sql)) {
			statement.setString(1, idLocataire);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Locataire l = getLocataire(resultat);
				locataire = Optional.of(l);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return locataire;
	}

	@Override
	public boolean insert(Locataire t) {
		boolean resultat = false;
		String insertion = "INSERT INTO Locataire VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion)) {
			statement.setString(1, t.getIdLocataire());
			statement.setString(2, t.getNom());
			statement.setString(3, t.getPrenom());
            statement.setDate(4, Date.valueOf(t.getDateNaissance()));
			statement.setString(5, t.getEmail());
			statement.setString(6, t.getTelephone());
			statement.executeUpdate();
			LOGGER.info("Le locataire a ete ajoute.");
			resultat = true;
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean update(Locataire t) {
		boolean resultat = false;
		String misAJour = "UPDATE Locataire SET nom = ?, prenom = ?, dateNaissance = ?, email = ?, telephone = ? " +
				"WHERE IDLOCATAIRE = ?";
		try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour)) {
			statement.setString(1, t.getNom());
			statement.setString(2, t.getPrenom());
			statement.setDate(3, Date.valueOf(t.getDateNaissance()));
			statement.setString(4, t.getEmail());
			statement.setString(5, t.getTelephone());
			statement.setString(6, t.getIdLocataire());
			statement.executeUpdate();
			LOGGER.info("Le locataire a ete mis a jour.");
			resultat = true;
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean delete(Locataire t) {
		boolean resultat = false;
		String suppression = "DELETE FROM Locataire WHERE idLocataire = ?";
		try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression)) {
			statement.setString(1, t.getIdLocataire());
			statement.executeUpdate();
			LOGGER.info("Le locataire a ete supprime.");
			resultat = true;
		} catch (SQLException e) {
			LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

}