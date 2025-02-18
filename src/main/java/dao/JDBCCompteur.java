package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import modele.BienImmobilier;
import modele.Compteur;
import modele.TypeCompteur;

public class JDBCCompteur implements DAOCompteur {

	private final JDBCBienImmobilier jdbcBienImmobilier = new JDBCBienImmobilier();

	@Override
	public List<Compteur> getAll() {
		List<Compteur> compteurs = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Compteur");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Compteur c = extraireCompteur(resultat);
				compteurs.add(c);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return compteurs;
	}

	@Override
	public Optional<Compteur> getById(Integer id) {
		Optional<Compteur> conteneur = Optional.empty();
		try {
			String requete = "SELECT * FROM Compteur where idCompteur = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Compteur c = extraireCompteur(resultat);
				conteneur = Optional.of(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return conteneur;
	}

	@Override
	public boolean insert(Compteur t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Compteur VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setInt(1, t.getIdCompteur());
			statement.setString(2, t.getNumero());
			statement.setString(3, t.getTypeCompteur().name());
			statement.setInt(4, t.getIndexAncien());
			statement.setInt(5, t.getIndexActuel());
			statement.setDate(6, Date.valueOf(t.getDateReleveEntree()));
			statement.setInt(7, t.getConsommation());
			statement.setString(8, t.getBien().getIdBienImmobilier());

			statement.executeUpdate();
			System.out.println("Le compteur numero " + t.getNumero() + " a été ajouté.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean update(Compteur t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Compteur SET indexActuel = ? WHERE idCompteur = ?";

			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setInt(1, t.getIndexActuel());
			statement.setInt(2, t.getIdCompteur());

			statement.executeUpdate();
			System.out.println("Le compteur numero " + t.getNumero() + " a été modifié.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public boolean delete(Compteur t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Compteur WHERE idCompteur = ?";

			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdCompteur());

			statement.executeUpdate();
			System.out.println("Le compteur numero " + t.getNumero() + " a été supprimé.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public Optional<Compteur> getByNumero(String numero) {
		Optional<Compteur> conteneur = Optional.empty();
		try {
			String requete = "SELECT * FROM Compteur where numero = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, numero);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Compteur c = extraireCompteur(resultat);
				conteneur = Optional.of(c);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return conteneur;
	}

	private Compteur extraireCompteur(ResultSet resultat) throws SQLException {
		BienImmobilier bien = jdbcBienImmobilier.getById(resultat.getString("idBienImmobilier")).orElseThrow();
        return new Compteur(resultat.getInt("idCompteur"), resultat.getString("numero"),
                TypeCompteur.valueOf(resultat.getString("typeCompteur")), resultat.getInt("indexAncien"),
                resultat.getInt("indexActuel"), resultat.getDate("dateReleveEntree").toLocalDate(),
                resultat.getInt("volumeEauConsommee"), bien);
	}

	@Override
	public Optional<Compteur> getByBienImmobilier(BienImmobilier bien) {
		Optional<Compteur> conteneur = Optional.empty();
		try {
			String requete = "SELECT * FROM Compteur where idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, bien.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Compteur c = new Compteur(resultat.getInt("idCompteur"), resultat.getString("numero"),
						TypeCompteur.valueOf(resultat.getString("typeCompteur")), resultat.getInt("indexAncien"),
						resultat.getInt("indexActuel"), resultat.getDate("dateReleveEntree").toLocalDate(),
						resultat.getInt("volumeEauConsommee"), bien);
				conteneur = Optional.of(c);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return conteneur;
	}

}
