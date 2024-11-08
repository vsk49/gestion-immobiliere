package dao;

import java.util.LinkedList;

import java.util.List;

import modele.BienImmobilier;

public class DAOBienImmobilier implements DAO<BienImmobilier> {
	
	private List<BienImmobilier> biens = new LinkedList<>();

	@Override
	public List<BienImmobilier> getAll() {
		return this.biens;
	}

	@Override
	public BienImmobilier getById(String id) {
		return this.biens.stream().filter(b -> b.getIdBienImmobilier() == id).findFirst().get();
	}

	@Override
	public void insert(BienImmobilier t) throws IllegalArgumentException {
		if (this.biens.contains(t)) {
			throw new IllegalArgumentException("Bien deja existant");
		}
		this.biens.add(t);
	}

	@Override
	public void update(BienImmobilier t) throws IllegalArgumentException {
		if (!this.biens.contains(t)) {
			throw new IllegalArgumentException("Bien inexistant");
		}
		BienImmobilier bien = this.getById(t.getIdBienImmobilier());
		this.delete(bien);
		this.insert(t);
	}

	@Override
	public void delete(BienImmobilier t) throws IllegalArgumentException {
		if (!this.biens.contains(t)) {
			throw new IllegalArgumentException("Bien inexistant");
		}
		this.biens.remove(t);
	}

}
