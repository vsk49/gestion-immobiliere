package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;
import modele.Logement;

public class JDBCLogement extends JDBCBienLouable {

	private final JDBCBienLouable donneesBienLouable = new JDBCBienLouable();

	@Override
	public List<BienImmobilier> getAll() {
        List<BienImmobilier> logements = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Logement");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Logement logement = (Logement) this.donneesBienLouable.getById(resultat.getInt("idBienLouable"))
						.orElseThrow();
				logements.add(logement);
				enregistrementExiste = resultat.next();
			}
		} catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
		return logements;
    }

	@Override
	public Optional<BienImmobilier> getById(Integer id) {
		Optional<BienImmobilier> logement = Optional.empty();
		try {
			String requete = "SELECT * FROM Logement WHERE idLogement = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, id);
			ResultSet resultat = statement.executeQuery();
			if (resultat.next()) {
				Logement logementTrouve = (Logement) this.donneesBienLouable.getById(id).orElseThrow();
				logement = Optional.of(logementTrouve);
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return logement;
	}

	@Override
	public boolean insert(BienImmobilier logement) {
		boolean resultat = super.insert(logement);
		if (resultat) {
			try {
				String insertion = "INSERT INTO Logement (idLogement, idBienLouable) VALUES (?, ?)";
				PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
				statement.setInt(1, logement.getIdBienImmobilier());
				statement.setInt(2, logement.getIdBienImmobilier());
				statement.executeUpdate();
				System.out.println("Le logement a été inséré");
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + " : " + e.getMessage());
            }
		}
		return resultat;
	}

	@Override
	public boolean update(BienImmobilier logement) {
		boolean resultat = super.update(logement);
		if (resultat) {
			try {
				String miseAJour = "UPDATE Logement SET idBienLouable = ? WHERE idLogement = ?";
				PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(miseAJour);
				statement.setInt(1, logement.getIdBienImmobilier());
				statement.setInt(2, logement.getIdBienImmobilier());
				statement.executeUpdate();
				System.out.println("Le logement a été mis à jour");
			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + " : " + e.getMessage());
			}
		}
		return resultat;
	}

	@Override
	public boolean delete(BienImmobilier logement) {
		boolean resultat = false;
		try {
			String suppression = "DELETE FROM Logement WHERE idLogement = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
			statement.setInt(1, logement.getIdBienImmobilier());
			statement.executeUpdate();
			resultat = super.delete(logement);
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return resultat;
	}

	@Override
	public Optional<BienImmobilier> getByNumeroFiscal(String numeroFiscal) {
		return super.getByNumeroFiscal(numeroFiscal);
	}

}
