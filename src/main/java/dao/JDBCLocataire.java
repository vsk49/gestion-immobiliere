package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Genre;
import modele.Locataire;

public class JDBCLocataire implements DAOLocataire {

	@Override
	public List<Locataire> getAll() {
		List<Locataire> locataires = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Locataire");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Locataire l = getLocataire(resultat);
				locataires.add(l);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return locataires;
	}

	private static Locataire getLocataire(ResultSet resultat) throws SQLException {
		String genreString = resultat.getString("genre");
		Genre genre = null;
		if (genreString != null) {
            genre = switch (genreString.toUpperCase()) {
                case "M" -> Genre.MASCULIN;
                case "F" -> Genre.FEMININ;
                default -> throw new IllegalArgumentException("Unknown genre: " + genreString);
            };
		}

		return new Locataire(
				resultat.getString("idLocataire"),
				resultat.getString("nom"),
				resultat.getString("prenom"),
				genre,
				resultat.getDate("dateNaissance").toLocalDate(),
				resultat.getString("lieuNaissance"),
				resultat.getString("nationalite"),
				resultat.getString("profession"),
				resultat.getString("telephone"),
				resultat.getString("email"),
				resultat.getDate("dateEntree")!= null ? resultat.getDate("dateEntree").toLocalDate() : null,
				resultat.getDate("dateDepart") != null ? resultat.getDate("dateDepart").toLocalDate() : null,
				resultat.getDouble("quotite")
		);
	}

	@Override
	public Optional<Locataire> getById(String idLocataire) {
		Optional<Locataire> locataire = Optional.empty();
		try {
			String requete = "SELECT * FROM Locataire WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, idLocataire);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Locataire l = getLocataire(resultat);
				locataire = Optional.of(l);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return locataire;
	}

	@Override
	public boolean insert(Locataire t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Locataire VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setString(1, t.getIdLocataire());
			statement.setString(2, t.getNom());
			statement.setString(3, t.getPrenom());
			statement.setString(4, t.getGenre() != null ? t.getGenre().getLibelle() : null);
			statement.setDate(5, Date.valueOf(t.getDateNaissance()));
			statement.setString(6, t.getLieuNaissance());
			statement.setString(7, t.getNationalite());
			statement.setString(8, t.getProfession());
			statement.setString(9, t.getTelephone());
			statement.setString(10, t.getEmail());
			statement.setDate(11, t.getDateEntree() != null ? Date.valueOf(t.getDateEntree()) : null);
			statement.setDate(12, t.getDateDepart() != null ? Date.valueOf(t.getDateDepart()) : null);
			statement.setDouble(13, t.getQuotite());
			statement.executeUpdate();
			System.out.println("Le locataire a ete enregistre.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean update(Locataire t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Locataire SET quotite = ? WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDouble(1, t.getQuotite());
			statement.setString(2, t.getIdLocataire());
			statement.executeUpdate();
			System.out.println("La quotite du locataire a ete mise a jour.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean delete(Locataire t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Locataire WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setString(1, t.getIdLocataire());
			statement.executeUpdate();
			System.out.println("Le locataire a ete archive");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

}