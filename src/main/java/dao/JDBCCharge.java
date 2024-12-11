package dao;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Charge;
import modele.Locataire;

public class JDBCCharge implements DAOCharge {

	@Override
	public List<Charge> getAll() {
		List<Charge> charges = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Charge");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Charge c = new Charge(resultat.getInt("idCharge"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate());
				charges.add(c);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return charges;
	}

	@Override
	public Optional<Charge> getById(Integer id) {
		Optional<Charge> charge = Optional.empty();
		try {
			String requete = "SELECT * FROM Charge WHERE idCharge = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Charge c = new Charge(resultat.getInt("idCharge"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate());
				charge = Optional.of(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return charge;
	}

	@Override
	public boolean insert(Charge t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Charge (idCharge, dateDebut, dateFin) VALUES (?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdCharge());
			statement.setDate(2, Date.valueOf(t.getDateDebut()));
			statement.setDate(3, Date.valueOf(t.getDateFin()));
			statement.executeUpdate();
			System.out.println("La charge concernant a ete ajoutee.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean update(Charge t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Charge SET idCharge = ? WHERE idCharge = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDouble(1, t.getIdCharge());
			statement.setInt(2, t.getIdCharge());
			statement.executeUpdate();
			System.out.println("La charge concernant a ete mise a jour.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean delete(Charge t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Charge WHERE idCharge = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdCharge());
			statement.executeUpdate();
			System.out.println("La charge concernant a ete supprimee.");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public List<Charge> getByLocataire(Locataire locataire) {
		List<Charge> charges = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Charge WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, locataire.getIdLocataire());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Charge c = new Charge(resultat.getInt("idCharge"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate());
				charges.add(c);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return charges;
	}

}
