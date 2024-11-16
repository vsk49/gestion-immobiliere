package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Caution;

public class JDBCCaution implements DAOCaution {

	@Override
	public List<Caution> getAll() {
		List<Caution> cautions = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Caution");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Caution c = new Caution(resultat.getInt("idCaution"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getDate("dateNaissance").toLocalDate(),
						resultat.getString("nationalite"), resultat.getString("adresse"),
						resultat.getString("codePostal"), resultat.getString("ville"), resultat.getString("profession"),
						resultat.getString("employeur"), resultat.getDouble("revenusMensuelsNets"),
						resultat.getString("typeContratTravail"), resultat.getString("lienLocataire"),
						resultat.getDate("dateSignature").toLocalDate(), resultat.getDouble("montantCautionne"));
				cautions.add(c);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cautions;
	}

	@Override
	public Optional<Caution> getById(Integer id) {
		Optional<Caution> conteneur = Optional.empty();
		try {
			String requete = "SELECT * FROM Caution where idCaution = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Caution c = new Caution(resultat.getInt("idCaution"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getDate("dateNaissance").toLocalDate(),
						resultat.getString("nationalite"), resultat.getString("adresse"),
						resultat.getString("codePostal"), resultat.getString("ville"), resultat.getString("profession"),
						resultat.getString("employeur"), resultat.getDouble("revenusMensuelsNets"),
						resultat.getString("typeContratTravail"), resultat.getString("lienLocataire"),
						resultat.getDate("dateSignature").toLocalDate(), resultat.getDouble("montantCautionne"));
				conteneur = Optional.ofNullable(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conteneur;
	}

	@Override
	public boolean insert(Caution t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Caution VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setInt(1, t.getIdCaution());
			statement.setString(2, t.getNom());
			statement.setString(3, t.getPrenom());
			statement.setDate(4, Date.valueOf(t.getDateNaissance()));
			statement.setString(5, t.getNationalite());
			statement.setString(6, t.getAdresse());
			statement.setString(7, t.getCodePostal());
			statement.setString(8, t.getVille());
			statement.setString(9, t.getProfession());
			statement.setString(10, t.getEmployeur());
			statement.setDouble(11, t.getRevenusMensuelsNets());
			statement.setString(12, t.getTypeContratTravail());
			statement.setString(13, t.getLienLocataire());
			statement.setDate(14, Date.valueOf(t.getDateSignature()));
			statement.setDouble(15, t.getMontantCautionne());

			statement.executeUpdate();
			System.out.println("La caution " + t.getNom() + " " + t.getPrenom() + " a été ajouté.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(Caution t) {
		boolean resultat = false;
		try {
			String miseAJour = "UPDATE Caution SET montantCautionne = ? WHERE idCaution = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(miseAJour);

			statement.setDouble(1, t.getMontantCautionne());
			statement.setInt(2, t.getIdCaution());

			statement.executeUpdate();
			System.out.println("La caution " + t.getNom() + " " + t.getPrenom() + " a été modifié.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Caution t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Caution WHERE idCaution = ?";

			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdCaution());

			statement.executeUpdate();
			System.out.println("La caution " + t.getNom() + " " + t.getPrenom() + " a été supprimée.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Optional<Caution> getByNom(String nom) {
		Optional<Caution> conteneur = Optional.empty();
		try {
			String requete = "SELECT * FROM Caution where nom = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, nom);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Caution c = new Caution(resultat.getInt("idCaution"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getDate("dateNaissance").toLocalDate(),
						resultat.getString("nationalite"), resultat.getString("adresse"),
						resultat.getString("codePostal"), resultat.getString("ville"), resultat.getString("profession"),
						resultat.getString("employeur"), resultat.getDouble("revenusMensuelsNets"),
						resultat.getString("typeContratTravail"), resultat.getString("lienLocataire"),
						resultat.getDate("dateSignature").toLocalDate(), resultat.getDouble("montantCautionne"));
				conteneur = Optional.ofNullable(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conteneur;
	}

}
