package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import modele.BienImmobilier;
import modele.Diagnostic;

public class JDBCDiagnostic implements DAODiagnostic {

	private JDBCBienImmobilier bienConcerne = new JDBCBienImmobilier();

	@Override
	public List<Diagnostic> getAll() {
		List<Diagnostic> diagnostics = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement()
					.executeQuery("SELECT * FROM Diagnostic");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Diagnostic d = new Diagnostic(resultat.getInt("idDiagnostic"), resultat.getString("reference"),
						resultat.getDate("dateRealisation").toLocalDate(), resultat.getString("type"),
						resultat.getDate("dateExpiration").toLocalDate(), resultat.getString("classification"),
						resultat.getString("operateur"), resultat.getString("numeroRapport"),
						bienConcerne.getById(resultat.getString("idBienImmobilier")).get());
				diagnostics.add(d);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnostics;
	}

	@Override
	public Optional<Diagnostic> getById(Integer id) {
		Optional<Diagnostic> diagnostic = Optional.empty();
		try {
			String requete = "SELECT * FROM Diagnostic WHERE idDiagnostic = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Diagnostic d = new Diagnostic(resultat.getInt("idDiagnostic"), resultat.getString("reference"),
						resultat.getDate("dateRealisation").toLocalDate(), resultat.getString("type"),
						resultat.getDate("dateExpiration").toLocalDate(), resultat.getString("classification"),
						resultat.getString("operateur"), resultat.getString("numeroRapport"),
						bienConcerne.getById(resultat.getString("idBienImmobilier")).get());
				diagnostic = Optional.ofNullable(d);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public boolean insert(Diagnostic t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Diagnostic VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
			statement.setInt(1, t.getIdDiagnostic());
			statement.setString(2, t.getReference());
			statement.setDate(3, Date.valueOf(t.getDateRealisation()));
			statement.setString(4, t.getType());
			statement.setDate(5, Date.valueOf(t.getDateExpiraion()));
			statement.setString(6, t.getClassification());
			statement.setString(7, t.getOperateur());
			statement.setString(8, t.getNumeroRapport());
			statement.setString(9, t.getBien().getIdBienImmobilier());
			statement.executeUpdate();
			System.out.println("Le diagnostic " + t.getReference() + " a ete ajoute.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean update(Diagnostic t) {
		boolean resultat = false;
		try {
			String misAJour = "UPDATE Diagnostic SET classification = ? WHERE idDiagnostic = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
			statement.setString(1, t.getClassification());
			statement.setInt(2, t.getIdDiagnostic());
			statement.executeUpdate();
			System.out.println("Le diagnostic " + t.getReference() + " a ete mis a jour.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public boolean delete(Diagnostic t) {
		boolean resultat = false;
		try {
			String suppresion = "DELETE FROM Diagnostic WHERE idDiagnostic = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppresion);
			statement.setInt(1, t.getIdDiagnostic());
			statement.executeUpdate();
			System.out.println("Le diagnostic " + t.getReference() + " a ete supprime.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Optional<Diagnostic> getByNumeroRapport(String numeroRapport) {
		Optional<Diagnostic> diagnostic = Optional.empty();
		try {
			String requete = "SELECT * FROM Diagnostic WHERE numeroRapport = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, numeroRapport);
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			if (enregistrementExiste) {
				Diagnostic d = new Diagnostic(resultat.getInt("idDiagnostic"), resultat.getString("reference"),
						resultat.getDate("dateRealisation").toLocalDate(), resultat.getString("type"),
						resultat.getDate("dateExpiration").toLocalDate(), resultat.getString("classification"),
						resultat.getString("operateur"), resultat.getString("numeroRapport"),
						bienConcerne.getById(resultat.getString("idBienImmobilier")).get());
				diagnostic = Optional.ofNullable(d);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnostic;
	}

	@Override
	public List<Diagnostic> getByBienImmobilier(BienImmobilier bien) {
		List<Diagnostic> diagnostics = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Diagnostic WHERE idBienImmobilier = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setString(1, bien.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Diagnostic d = new Diagnostic(resultat.getInt("idDiagnostic"), resultat.getString("reference"),
						resultat.getDate("dateRealisation").toLocalDate(), resultat.getString("type"),
						resultat.getDate("dateExpiration").toLocalDate(), resultat.getString("classification"),
						resultat.getString("operateur"), resultat.getString("numeroRapport"), bien);
				diagnostics.add(d);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagnostics;
	}

}
