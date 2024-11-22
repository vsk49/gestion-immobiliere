package dao;

import java.util.List;

import modele.Bail;
import modele.BienImmobilier;

public interface DAOBail extends DAO<Bail, Integer> {
	
	public List<Bail> getByBienImmobilier(BienImmobilier bien);

}
