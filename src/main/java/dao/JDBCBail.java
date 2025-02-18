package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Bail;
import modele.BienImmobilier;

public class JDBCBail implements DAOBail {

	private JDBCBienImmobilier bienConcerne = new JDBCBienImmobilier();
	private JDBCLoyer loyerConcerne = new JDBCLoyer();

	@Override
	public List<Bail> getAll() {
		List<Bail> baux = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Bail");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Bail b = new Bail(resultat.getInt("idBail"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDouble("depotDeGarantie"), resultat.getDate("dateSignature").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate(), resultat.getInt("indexAncienBail"),
						bienConcerne.getById(resultat.getString("idBienImmobilier")).get(),
						loyerConcerne.getById(resultat.getInt("idLoyer")).get());
				baux.add(b);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return baux;
	}

	@Override
	public Optional<Bail> getById(Integer id) {
		Optional<Bail> bail = Optional.empty();
		try {
			String requete = "SELECT * FROM Bail WHERE idBail = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Bail b = new Bail(resultat.getInt("idBail"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDouble("depotDeGarantie"), resultat.getDate("dateSignature").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate(), resultat.getInt("indexAncienBail"),
						bienConcerne.getById(resultat.getString("idBienImmobilier")).get(),
						loyerConcerne.getById(resultat.getInt("idLoyer")).get());
				bail = Optional.ofNullable(b);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bail;
	}

	@Override
	public boolean insert(Bail t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Bail VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdBail());
			statement.setDate(2, Date.valueOf(t.getDateDebut()));
			statement.setDouble(3, t.getDepotDeGarantie());
			statement.setDate(4, Date.valueOf(t.getDateSignature()));
			statement.setDate(5, Date.valueOf(t.getDateFin()));
			statement.setInt(6, t.getIndexAncienBail());
			statement.setString(7, t.getBienImmobilier().getIdBienImmobilier());
			statement.setInt(8, t.getLoyer().getIdLoyer());
			statement.executeUpdate();
			System.out.println("Le bail a ete ajoute.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(Bail t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Bail SET dateFin = ? WHERE idBail = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setDate(1, Date.valueOf(t.getDateFin()));
			statement.setInt(2, t.getIdBail());
			statement.executeUpdate();
			System.out.println("Le bail a ete modifie.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Bail t) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Bail WHERE idBail = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, t.getIdBail());
			statement.executeUpdate();
			System.out.println("Le Bail est archive.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public List<Bail> getByBienImmobilier(BienImmobilier bien) {
		List<Bail> baux = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Bail WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, bien.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Bail b = new Bail(resultat.getInt("idBail"), resultat.getDate("dateDebut").toLocalDate(),
						resultat.getDouble("depotDeGarantie"), resultat.getDate("dateSignature").toLocalDate(),
						resultat.getDate("dateFin").toLocalDate(), resultat.getInt("indexAncienBail"), bien,
						loyerConcerne.getById(resultat.getInt("idLoyer")).get());
				baux.add(b);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return baux;
	}

}
