package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modele.Locataire;

public class JDBCLocataire implements DAOLocataire {

	@Override
	public List<Locataire> getAll() {
		List<Locataire> locataires = new ArrayList<>();
		try {
			ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery("SELECT * FROM Locataire");
			while (resultat.next()) {
				/*
				locataires.add(new Locataire(resultat.getInt("idLocataire"), resultat.getString("nom"),
						resultat.getString("prenom"), resultat.getObject("genre", LocalDate.class),
						resultat.getObject("dateNaissance", LocalDate.class), resultat.getString("lieuNaissance"),
						resultat.getString("nationalite"), resultat.getString("profession"),
						resultat.getString("telephone"), resultat.getString("email"),
						resultat.getObject("dateEntree", LocalDate.class),
						resultat.getObject("dateDepart", LocalDate.class), resultat.getDouble("quotite"), 
						resultat.getInt("caution")));
				*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locataires;
	}

	@Override
	public Optional<Locataire> getById(Integer id) {
		return Optional.empty();
	}

	@Override
	public boolean insert(Locataire t) {
		return false;
	}

	@Override
	public boolean update(Locataire t) {
		return false;
	}

	@Override
	public boolean delete(Locataire t) {
		return false;
	}

	@Override
	public Optional<Locataire> getByNom(String nom) {
		return Optional.empty();
	}

}
