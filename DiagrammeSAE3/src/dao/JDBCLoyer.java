package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import modele.Locataire;
import modele.Logement;
import modele.Loyer;

public class JDBCLoyer implements DAOLoyer {

	private JDBCLogement logementConcerne = new JDBCLogement();
	private JDBCLocataire locataireConcerne = new JDBCLocataire();

	@Override
	public List<Loyer> getAll() {
		List<Loyer> loyers = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Loyer");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"),
						logementConcerne.getById(resultat.getInt("idLogement")).get(),
						locataireConcerne.getById(resultat.getInt("idLocataire")).get());
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loyers;
	}

	@Override
	public Optional<Loyer> getById(Integer id) {
		Optional<Loyer> loyer = Optional.empty();
		try {
			String requete = "SELECT * FROM Loyer WHERE idLoyer = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"),
						logementConcerne.getById(resultat.getInt("idLogement")).get(),
						locataireConcerne.getById(resultat.getInt("idLocataire")).get());
				loyer = Optional.ofNullable(l);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loyer;
	}

	@Override
	public boolean insert(Loyer t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Loyer VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setInt(1, t.getIdLoyer());
			statement.setDate(2, Date.valueOf(t.getDateLoyer()));
			statement.setDouble(3, t.getMontantLoyer());
			statement.setDouble(4, t.getProvisionPourCharge());
			statement.setInt(5, t.getLogement().getIdBienImmobilier());
			statement.setInt(6, t.getLocataire().getIdLocataire());

			statement.executeUpdate();
			System.out.println("Le loyer du locataire " + t.getLocataire().getNom() + "pour "
					+ t.getDateLoyer().toString() + " a ete ajoute.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(Loyer t) {
		boolean resultat = false;
		try {
			String miseAJour = "UPDATE Loyer SET montantLoyer = ?, provisionPourCharge = ? WHERE idLoyer = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(miseAJour);

			statement.setDouble(1, t.getMontantLoyer());
			statement.setDouble(2, t.getProvisionPourCharge());
			statement.setInt(3, t.getIdLoyer());

			statement.executeUpdate();
			System.out.println("Le loyer du locataire " + t.getLocataire().getNom() + "pour "
					+ t.getDateLoyer().toString() + " a ete modifie.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Loyer t) {
		boolean resultat = false;
		try {
			String requete = "DELETE FROM Loyer WHERE idLoyer = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, t.getIdLoyer());
			statement.executeUpdate();
			System.out.println("Le loyer du locataire " + t.getLocataire().getNom() + "pour "
					+ t.getDateLoyer().toString() + " a ete supprime.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public List<Loyer> getByDateLoyer(LocalDate date) {
		List<Loyer> loyers = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Loyer WHERE dateLoyer = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setDate(1, Date.valueOf(date));
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), date, resultat.getDouble("montantLoyer"),
						resultat.getDouble("provisionPourCharge"),
						logementConcerne.getById(resultat.getInt("idLogement")).get(),
						locataireConcerne.getById(resultat.getInt("idLocataire")).get());
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loyers;
	}

	@Override
	public List<Loyer> getByLocataire(Locataire locataire) {
		List<Loyer> loyers = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Loyer WHERE idLocataire = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, locataire.getIdLocataire());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"),
						logementConcerne.getById(resultat.getInt("idLogement")).get(), locataire);
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loyers;
	}

	@Override
	public List<Loyer> getByLogement(Logement logement) {
		List<Loyer> loyers = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Loyer WHERE idLogement = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, logement.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"), logement,
						locataireConcerne.getById(resultat.getInt("idLocataire")).get());
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loyers;
	}

}
