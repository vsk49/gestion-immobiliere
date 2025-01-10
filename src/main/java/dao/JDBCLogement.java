package dao;

import java.util.List;
import java.util.Optional;

import modele.BienImmobilier;

public class JDBCLogement implements DAOLogement {

	@Override
	public List<BienImmobilier> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BienImmobilier> getById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean insert(BienImmobilier t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BienImmobilier t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BienImmobilier t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<BienImmobilier> getByNumeroFiscal(String numeroFiscal) {
		return Optional.empty();
	}

}
