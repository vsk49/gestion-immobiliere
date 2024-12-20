package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Proprietaire;

public class JDBCProprietaire implements DAOProprietaire {

	@Override
	public List<Proprietaire> getAll() {
		List<Proprietaire> Proprietaire = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Proprietaire");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Proprietaire l = getProprietaire(resultat);
				Proprietaire.add(l);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return Proprietaire;
	}

	private static Proprietaire getProprietaire(ResultSet resultat) throws SQLException {
		return new Proprietaire(
				resultat.getString("idProprietaire"),
				resultat.getString("MotDePasse")
		);
	}

	@Override
	public Optional<Proprietaire> getById(String idProprietaire) {
		Optional<Proprietaire> Proprietaire = Optional.empty();
		try {
			String requete = "SELECT * FROM Proprietaire WHERE idProprietaire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, idProprietaire);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Proprietaire l = getProprietaire(resultat);
				Proprietaire = Optional.of(l);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return Proprietaire;
	}

	@Override
	public boolean insert(Proprietaire t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Proprietaire VALUES (?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setString(1, t.getIdProprietaire());
			statement.setString(2, t.getMotDePasse());
			statement.executeUpdate();
			System.out.println("Le proprietaire a ete enregistre.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean update(Proprietaire t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Proprietaire SET quotite = ? WHERE idProprietaire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setString(2, t.getIdProprietaire());
			statement.executeUpdate();
			System.out.println("La quotite du proprietaire a ete mise a jour.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean delete(Proprietaire t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Proprietaire WHERE idProprietaire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setString(1, t.getIdProprietaire());
			statement.executeUpdate();
			System.out.println("Le proprietaire a ete archive");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

}