package dao;

import java.util.List;
import java.util.Optional;

import modele.Bail;
import modele.BienImmobilier;
import modele.Loyer;

public interface DAOBail extends DAO<Bail, Integer> {
	
	public List<Bail> getByBienImmobilier(BienImmobilier bien);
	
	public Optional<Bail> getByLoyer(Loyer loyer);

}
