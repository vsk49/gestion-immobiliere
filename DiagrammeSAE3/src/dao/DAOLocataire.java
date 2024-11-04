package dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import modele.Locataire;

public class DAOLocataire implements DAO<Locataire> {

	private List<Locataire> locataires = new LinkedList<>();

	@Override
	public List<Locataire> getAll() {
		return this.locataires;
	}

	@Override
	public Locataire getById(String id) {
		return this.locataires.stream().filter(l -> l.getId() == id).findFirst().get();
	}

	@Override
	public void insert(Locataire t) throws IllegalArgumentException {
		if (this.locataires.contains(t)) {
			throw new IllegalArgumentException("locataire deja existant");
		}
		this.locataires.add(t);
	}

	@Override
	public void update(Locataire t) throws IllegalArgumentException {
		if (!this.locataires.contains(t)) {
			throw new IllegalArgumentException("locataire inexistant");
		}
		Locataire ancien = this.getById(t.getId());
		this.delete(ancien);
		this.insert(t);
	}

	@Override
	public void delete(Locataire t) throws IllegalArgumentException {
		if (!this.locataires.contains(t)) {
			throw new IllegalArgumentException("locataire inexistant");
		}
		this.locataires.remove(t);
	}

}
