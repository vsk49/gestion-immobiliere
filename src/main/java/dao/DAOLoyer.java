package dao;

import java.time.LocalDate;
import java.util.List;

import modele.BienLouable;
import modele.Loyer;

public interface DAOLoyer extends DAO<Loyer, Integer> {
	
	public List<Loyer> getByDateLoyer(LocalDate date);
	
	public List<Loyer> getByBienLouable(BienLouable bien);

}
