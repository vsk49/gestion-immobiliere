package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.BienLouable;
import modele.FactureTravail;

public class JDBCFactureTravail implements DAOFactureTravail {

	JDBCBienLouable bienConcerne = new JDBCBienLouable();

	@Override
	public List<FactureTravail> getAll() {
		List<FactureTravail> factures = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement()
					.executeQuery("SELECT * FROM FactureTravail");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				FactureTravail f = new FactureTravail(resultat.getInt(1), resultat.getString(2),
						resultat.getDate(3).toLocalDate(), resultat.getString(4), resultat.getDouble(5),
						resultat.getString(6), resultat.getString(7), resultat.getDouble(8),
						(BienLouable) bienConcerne.getById(resultat.getInt(9)).get());
				factures.add(f);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factures;
	}

	@Override
	public Optional<FactureTravail> getById(Integer id) {
		Optional<FactureTravail> facture = Optional.empty();
		try {
			String requete = "SELECT * FROM FactureTravail WHERE idFactureTravail = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				FactureTravail f = new FactureTravail(resultat.getInt(1), resultat.getString(2),
						resultat.getDate(3).toLocalDate(), resultat.getString(4), resultat.getDouble(5),
						resultat.getString(6), resultat.getString(7), resultat.getDouble(8),
						(BienLouable) bienConcerne.getById(resultat.getInt(9)).get());
				facture = Optional.ofNullable(f);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facture;
	}

	@Override
	public boolean insert(FactureTravail t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO FactureTravail VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setInt(1, t.getIdFactureTravail());
			statement.setString(2, t.getNumeroFacture());
			statement.setDate(3, Date.valueOf(t.getDateFacture()));
			statement.setString(4, t.getNature());
			statement.setDouble(5, t.getMontant());
			statement.setString(6, t.getEntreprise());
			statement.setString(7, t.getReferenceDevis());
			statement.setDouble(8, t.getMontantDevis());
			statement.setInt(9, t.getBien().getIdBienImmobilier());

			statement.executeUpdate();
			System.out.println("La facture numero " + t.getNumeroFacture() + " a été ajouté.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(FactureTravail t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE FactureTravail SET montant = ? WHERE idCompteur = ?";

			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDouble(1, t.getMontant());
			statement.setInt(2, t.getIdFactureTravail());

			statement.executeUpdate();
			System.out.println("La facture numero " + t.getNumeroFacture() + " a été modifié.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(FactureTravail t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM FactureTravail WHERE idFactureTravail = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);

			statement.setInt(1, t.getIdFactureTravail());

			statement.executeUpdate();
			System.out.println("La facture numero " + t.getNumeroFacture() + " a ete supprimee.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Optional<FactureTravail> getByNumeroFacture(String numeroFacture) {
		Optional<FactureTravail> facture = Optional.empty();
		try {
			String requete = "SELECT * FROM FactureTravail WHERE numeroFacture = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, numeroFacture);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				FactureTravail f = new FactureTravail(resultat.getInt(1), resultat.getString(2),
						resultat.getDate(3).toLocalDate(), resultat.getString(4), resultat.getDouble(5),
						resultat.getString(6), resultat.getString(7), resultat.getDouble(8),
						(BienLouable) bienConcerne.getById(resultat.getInt(9)).get());
				facture = Optional.ofNullable(f);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facture;
	}

	@Override
	public List<FactureTravail> getFacturesByDate(LocalDate d) {
		List<FactureTravail> factures = new ArrayList<>();
		try {
			String requete = "SELECT * FROM FactureTravail WHERE dateFacture = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setDate(1, Date.valueOf(d));
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				FactureTravail f = new FactureTravail(resultat.getInt(1), resultat.getString(2),
						resultat.getDate(3).toLocalDate(), resultat.getString(4), resultat.getDouble(5),
						resultat.getString(6), resultat.getString(7), resultat.getDouble(8),
						(BienLouable) bienConcerne.getById(resultat.getInt(9)).get());
				factures.add(f);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factures;
	}

	@Override
	public List<FactureTravail> getByBienLouable(BienLouable b) {
		List<FactureTravail> factures = new ArrayList<>();
		try {
			String requete = "SELECT * FROM FactureTravail WHERE idBienLouable = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, b.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				FactureTravail f = new FactureTravail(resultat.getInt(1), resultat.getString(2),
						resultat.getDate(3).toLocalDate(), resultat.getString(4), resultat.getDouble(5),
						resultat.getString(6), resultat.getString(7), resultat.getDouble(8), b);
				factures.add(f);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return factures;
	}

}
