package dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;

public class JDBCBienImmobilier implements DAOBienImmobilier {
	
	private List<BienImmobilier> biens = new LinkedList<>();

	@Override
	public List<BienImmobilier> getAll() {
		return this.biens;
	}

	@Override
	public Optional<BienImmobilier> getById(Integer id) {
		return this.biens.stream().filter(b -> b.getIdBienImmobilier() == id).findFirst();
	}

	@Override
	public boolean insert(BienImmobilier t) {
		return false;
	}

	@Override
	public boolean update(BienImmobilier t) {
		return false;
	}

	@Override
	public boolean delete(BienImmobilier t) {
		return false;
	}

}
