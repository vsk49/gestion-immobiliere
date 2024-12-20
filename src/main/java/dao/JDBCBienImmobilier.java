package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;
import modele.Compteur;
import modele.TaxeFonciere;

public class JDBCBienImmobilier implements DAOBienImmobilier {

	private final JDBCTaxeFonciere jdbcTaxeFonciere = new JDBCTaxeFonciere();
	private final JDBCCompteur jdbcCompteur = new JDBCCompteur();

	@Override
	public List<BienImmobilier> getAll() {
		List<BienImmobilier> biensImmobiliers = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement()
					.executeQuery("SELECT * FROM BienImmobilier");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				BienImmobilier b = extraireBienImmobilier(resultat);
				biensImmobiliers.add(b);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return biensImmobiliers;
	}

	private BienImmobilier extraireBienImmobilier(ResultSet resultat) throws SQLException {
		TaxeFonciere taxeFonciere = jdbcTaxeFonciere.getById(resultat.getInt("idTaxesFoncieres")).orElseThrow();
		Compteur compteur = jdbcCompteur.getById(resultat.getInt("idCompteurGeneral")).orElseThrow();
		return new BienImmobilier(resultat.getInt("idBienImmobilier"),
				resultat.getString("numeroFiscal"), resultat.getString("adresse"),
				resultat.getInt("codePostal"), resultat.getString("ville"),
				resultat.getDate("dateAnniversaire").toLocalDate(), taxeFonciere,
				resultat.getInt("ICCDateDebut"), compteur);
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
				BienImmobilier b = extraireBienImmobilier(resultat);
				bien = Optional.of(b);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return bien;
	}

	@Override
	public boolean insert(BienImmobilier t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO BienImmobilier VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdBienImmobilier());
			statement.setString(2, t.getNumeroFiscal()!= null ? t.getNumeroFiscal() : null);
			statement.setString(3, t.getAdresse());
			statement.setInt(4, t.getCodePostal());
			statement.setString(5, t.getVille());
			statement.setDate(6, Date.valueOf(t.getDateAnniversaire()));
			statement.setInt(7, t.getICCDateDebut());
			statement.executeUpdate();
			System.out.println("le bien a ete insere");
			resultat = true;
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

}
