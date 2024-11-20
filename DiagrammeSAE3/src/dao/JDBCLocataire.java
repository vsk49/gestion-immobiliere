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
				Locataire l = new Locataire(resultat.getInt("idLocataire"), resultat.getString("nom"),
						resultat.getString("prenom"), Genre.valueOf(resultat.getString("genre")),
						resultat.getDate("dateNaissance").toLocalDate(), resultat.getString("lieuNaissance"),
						resultat.getString("nationalite"), resultat.getString("profession"),
						resultat.getString("telephone"), resultat.getString("email"),
						resultat.getDate("dateEntree").toLocalDate(), resultat.getDate("dateDepart").toLocalDate(),
						resultat.getDouble("quotite"));
				locataires.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locataires;
	}

	@Override
	public Optional<Locataire> getById(Integer id) {
		Optional<Locataire> locataire = Optional.empty();
		try {
			String requete = "SELECT * FROM Locataire WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Locataire l = new Locataire(resultat.getInt("idLocataire"), resultat.getString("nom"),
						resultat.getString("prenom"), Genre.valueOf(resultat.getString("genre")),
						resultat.getDate("dateNaissance").toLocalDate(), resultat.getString("lieuNaissance"),
						resultat.getString("nationalite"), resultat.getString("profession"),
						resultat.getString("telephone"), resultat.getString("email"),
						resultat.getDate("dateEntree").toLocalDate(), resultat.getDate("dateDepart").toLocalDate(),
						resultat.getDouble("quotite"));
				locataire = Optional.ofNullable(l);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locataire;
	}

	@Override
	public boolean insert(Locataire t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Locataire VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdLocataire());
			statement.setString(2, t.getNom());
			statement.setString(3, t.getPrenom());
			statement.setString(4, t.getGenre().name());
			statement.setDate(5, Date.valueOf(t.getDateNaissance()));
			statement.setString(6, t.getLieuNaissance());
			statement.setString(7, t.getNationalite());
			statement.setString(8, t.getProfession());
			statement.setString(9, t.getTelephone());
			statement.setString(10, t.getEmail());
			statement.setDate(11, Date.valueOf(t.getDateEntree()));
			statement.setDate(12, Date.valueOf(t.getDateDepart()));
			statement.setDouble(13, t.getQuotite());
			statement.executeUpdate();
			System.out.println("Le locataire a ete enregistre.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
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
			statement.setInt(2, t.getIdLocataire());
			statement.executeUpdate();
			System.out.println("La quotite du locataire a ete mise a jour.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Locataire t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Locataire WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdLocataire());
			statement.executeUpdate();
			System.out.println("Le locataire a ete archive");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Optional<Locataire> getByNom(String nom) {
		Optional<Locataire> locataire = Optional.empty();
		try {
			String requete = "SELECT * FROM Locataire WHERE nom = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, nom);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Locataire l = new Locataire(resultat.getInt("idLocataire"), nom, resultat.getString("prenom"),
						Genre.valueOf(resultat.getString("genre")), resultat.getDate("dateNaissance").toLocalDate(),
						resultat.getString("lieuNaissance"), resultat.getString("nationalite"),
						resultat.getString("profession"), resultat.getString("telephone"), resultat.getString("email"),
						resultat.getDate("dateEntree").toLocalDate(), resultat.getDate("dateDepart").toLocalDate(),
						resultat.getDouble("quotite"));
				locataire = Optional.ofNullable(l);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locataire;
	}

}
