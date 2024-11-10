package dao;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import modele.Locataire;

public class JDBCLocataire implements DAOLocataire {
	
	@Override
	public List<Locataire> getAll() {
		return null;
		// return this.locataires;
	}

	@Override
	public Optional<Locataire> getById(Integer id) {
		return null;
		// return this.locataires.stream().filter(l -> l.getIdLocataire() == id).findFirst();
	}

	@Override
	public void insert(Locataire t) throws IllegalArgumentException {
		// if (this.locataires.contains(t)) {
			throw new IllegalArgumentException("locataire deja existant");
		// }
		// this.locataires.add(t);
	}

	@Override
	public void update(Locataire t) throws IllegalArgumentException {
		// if (!this.locataires.contains(t)) {
			// throw new IllegalArgumentException("locataire inexistant");
		// }
		// Locataire ancien = this.getById(t.getIdLocataire());
		// this.delete(ancien);
		this.insert(t);
	}

	@Override
	public void delete(Locataire t) throws IllegalArgumentException {
		// if (!this.locataires.contains(t)) {
			// throw new IllegalArgumentException("locataire inexistant");
		// }
		// this.locataires.remove(t);
	}

	@Override
	public Optional<Locataire> getByNom(String nom) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
