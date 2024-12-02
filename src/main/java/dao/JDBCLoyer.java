package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import modele.BienImmobilier;
import modele.BienLouable;
import modele.Locataire;
import modele.Loyer;

public class JDBCLoyer implements DAOLoyer {

	private final JDBCBienLouable bienConcerne = new JDBCBienLouable();

	@Override
	public List<Loyer> getAll() {
		List<Loyer> loyers = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Loyer");
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"),
						(BienLouable) bienConcerne.getById(resultat.getInt("idBienLouable"))
								.orElseThrow(NullPointerException::new));
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
						(BienLouable) bienConcerne.getById(resultat.getInt("idBienLouable"))
								.orElseThrow(NullPointerException::new));
				loyer = Optional.of(l);
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return loyer;
	}

	@Override
	public boolean insert(Loyer t) {
		boolean resultat = false;
		try {
			String insertion = "INSERT INTO Loyer (dateLoyer, montantLoyer, provisionPourCharge, idBienLouable) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);

			statement.setDate(1, Date.valueOf(t.getDateLoyer()));
			statement.setDouble(2, t.getMontantLoyer());
			statement.setDouble(3, t.getProvisionPourCharge());
			statement.setInt(4, t.getBienLouable().getIdBienImmobilier());

			statement.executeUpdate();
			System.out.println("Le loyer du logement " + t.getBienLouable().getNumeroFiscal() + " pour "
					+ t.getDateLoyer().toString() + " a ete ajoute.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
			System.out.println("Le loyer du logement " + t.getBienLouable().getNumeroFiscal() + " pour "
					+ t.getDateLoyer().toString() + " a ete modifie.");
			resultat = true;
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
			System.out.println("Le loyer du logement " + t.getBienLouable().getNumeroFiscal() + " pour "
					+ t.getDateLoyer().toString() + " a ete supprime.");

		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
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
						(BienLouable) bienConcerne.getById(resultat.getInt("idBienLouable"))
								.orElseThrow(NullPointerException::new));
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return loyers;
	}

	@Override
	public List<Loyer> getByBienLouable(BienLouable bien) {
		List<Loyer> loyers = new ArrayList<>();
		try {
			String requete = "SELECT * FROM Loyer WHERE idBienLouable = ?";
			PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
			statement.setInt(1, bien.getIdBienImmobilier());
			ResultSet resultat = statement.executeQuery();
			boolean enregistrementExiste = resultat.next();
			while (enregistrementExiste) {
				Loyer l = new Loyer(resultat.getInt("idLoyer"), resultat.getDate("dateLoyer").toLocalDate(),
						resultat.getDouble("montantLoyer"), resultat.getDouble("provisionPourCharge"), bien);
				loyers.add(l);
				enregistrementExiste = resultat.next();
			}
			JDBCConnexion.closeConnexion();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " : " + e.getMessage());
		}
		return loyers;
	}

	@Override
	public boolean importerLoyersCSV(String cheminFichier) {
		boolean resultat = false;
		try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
			String ligne;
			lecteur.readLine();
			while ((ligne = lecteur.readLine()) != null) {
				String[] donnees = ligne.split(",");

				// le fichier CSV suit cet ordre : idLogement, idLocataire, dateLoyer, montantLoyer, provisionPourCharge
				int idLoyer = Integer.parseInt(donnees[0].trim());
				int idBienLouable = Integer.parseInt(donnees[1].trim());
				String idLocataire = String.valueOf(Integer.parseInt(donnees[2].trim()));
				LocalDate dateLoyer = LocalDate.parse(donnees[3].trim());
				double montantLoyer = Double.parseDouble(donnees[4].trim());
				double provisionPourCharge = Double.parseDouble(donnees[5].trim());

				Optional<BienImmobilier> bienLouableOpt = bienConcerne.getById(idBienLouable);
				if (bienLouableOpt.isPresent()) {
					BienLouable bienLouable = (BienLouable) bienLouableOpt.get();

					Loyer loyer = new Loyer(idLoyer, dateLoyer, montantLoyer, provisionPourCharge, bienLouable);
					this.insert(loyer);
					Locataire locataire = new JDBCLocataire().getById(idLocataire).orElseThrow(NullPointerException::new);
					loyer.ajouterLocataires(locataire);
				}
			}
			System.out.println("Importation des loyers réussie !");
			resultat = true;
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture du fichier.");
		}
		return resultat;
	}

}
