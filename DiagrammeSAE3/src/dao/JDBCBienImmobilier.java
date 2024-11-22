package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;

public class JDBCBienImmobilier implements DAOBienImmobilier {

	@Override
	public List<BienImmobilier> getAll() {
		List<BienImmobilier> biensImmobiliers = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement()
					.executeQuery("SELECT * FROM BienImmobilier");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				BienImmobilier b = new BienImmobilier(resultat.getInt("idBienImmobilier"),
						resultat.getString("numeroFiscal"), resultat.getString("adresse"),
						resultat.getInt("codePostal"), resultat.getString("ville"),
						resultat.getDate("dateAnniversaire").toLocalDate(), resultat.getDouble("montantTaxesFoncieres"),
						resultat.getInt("ICCDateDebut"));
				biensImmobiliers.add(b);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return biensImmobiliers;
	}

	@Override
	public Optional<BienImmobilier> getById(Integer id) {
		Optional<BienImmobilier> bien = Optional.empty();
		try {
			String requete = "SELECT * FROM BienImmobilier WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				BienImmobilier b = new BienImmobilier(resultat.getInt("idBienImmobilier"),
						resultat.getString("numeroFiscal"), resultat.getString("adresse"),
						resultat.getInt("codePostal"), resultat.getString("ville"),
						resultat.getDate("dateAnniversaire").toLocalDate(), resultat.getDouble("montantTaxesFoncieres"),
						resultat.getInt("ICCDateDebut"));
				bien = Optional.ofNullable(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bien;
	}

	@Override
	public boolean insert(BienImmobilier t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO BienImmobilier VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdBienImmobilier());
			statement.setString(2, t.getNumeroFiscal());
			statement.setString(3, t.getAdresse());
			statement.setInt(4, t.getCodePostal());
			statement.setString(5, t.getVille());
			statement.setDate(6, Date.valueOf(t.getDateAnniversaire()));
			statement.setDouble(7, t.getMontantTaxesFoncieres());
			statement.setDouble(8, t.getICCDateDebut());
			statement.executeUpdate();
			System.out.println("le bien a ete insere");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(BienImmobilier t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE BienImmobilier SET ICCDateDebut = ? WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDouble(1, t.getICCDateDebut());
			statement.setInt(2, t.getIdBienImmobilier());
			statement.executeUpdate();
			System.out.println("l'index du bien a ete mis a jour.");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(BienImmobilier t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM BienImmobilier WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdBienImmobilier());
			statement.executeUpdate();
			System.out.println("le bien a ete supprime");
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

}
