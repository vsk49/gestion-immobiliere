package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Assurance;
import modele.BienImmobilier;
import modele.TypeAssurance;

public class JDBCAssurance implements DAOAssurance {

	JDBCBienImmobilier bienConcerne = new JDBCBienImmobilier();

	@Override
	public List<Assurance> getAll() {
		List<Assurance> assurances = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Assurance");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Assurance a = new Assurance(resultat.getInt(1), TypeAssurance.valueOf(resultat.getString(2)),
						resultat.getString(3), resultat.getDate(4).toLocalDate(), resultat.getDouble(5),
						resultat.getDouble(6), resultat.getDouble(7), bienConcerne.getById(resultat.getInt(8)).get());
				assurances.add(a);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assurances;
	}

	@Override
	public Optional<Assurance> getById(Integer id) {
		Optional<Assurance> assurance = Optional.empty();
		try {
			String requete = "SELECT * FROM Assurance WHERE idAssurance = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Assurance a = new Assurance(resultat.getInt(1), TypeAssurance.valueOf(resultat.getString(2)),
						resultat.getString(3), resultat.getDate(4).toLocalDate(), resultat.getDouble(5),
						resultat.getDouble(6), resultat.getDouble(7), bienConcerne.getById(resultat.getInt(8)).get());
				assurance = Optional.ofNullable(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assurance;
	}

	@Override
	public boolean insert(Assurance t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Assurance VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setInt(1, t.getIdAssurance());
			statement.setString(2, t.getTypeAssurance().name());
			statement.setString(3, t.getNomAssureur());
			statement.setDate(4, Date.valueOf(t.getDateDebutAssurance()));
			statement.setDouble(5, t.getQuotiteJurisprudence());
			statement.setDouble(6, t.getProtectionJuridique());
			statement.setDouble(7, t.getPrime());
			statement.setInt(8, t.getBien().getIdBienImmobilier());

			statement.executeUpdate();
			System.out.println("L'assurance du nom " + t.getNomAssureur() + " a été ajoutée.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(Assurance t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Assurance SET prime = ? WHERE idAssurance = ?";

			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDouble(1, t.getPrime());
			statement.setInt(2, t.getIdAssurance());

			statement.executeUpdate();
			System.out.println("L'assurance du nom " + t.getNomAssureur() + " a été modifiée.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Assurance t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Assurance WHERE idAssurance = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);

			statement.setInt(1, t.getIdAssurance());

			statement.executeUpdate();
			System.out.println("L'assurance du nom " + t.getNomAssureur() + " a ete supprimee.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Optional<Assurance> getByNomAssureur(String nomAssureur) {
		Optional<Assurance> assurance = Optional.empty();
		try {
			String requete = "SELECT * FROM Assurance WHERE nomAssureur = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, nomAssureur);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Assurance a = new Assurance(resultat.getInt(1), TypeAssurance.valueOf(resultat.getString(2)),
						resultat.getString(3), resultat.getDate(4).toLocalDate(), resultat.getDouble(5),
						resultat.getDouble(6), resultat.getDouble(7), bienConcerne.getById(resultat.getInt(8)).get());
				assurance = Optional.ofNullable(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assurance;
	}

	@Override
	public List<Assurance> getByBienImmobilier(BienImmobilier bien) {
		List<Assurance> assurances = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Assurance WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, bien.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Assurance a = new Assurance(resultat.getInt(1), TypeAssurance.valueOf(resultat.getString(2)),
						resultat.getString(3), resultat.getDate(4).toLocalDate(), resultat.getDouble(5),
						resultat.getDouble(6), resultat.getDouble(7), bien);
				assurances.add(a);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assurances;
	}

}
