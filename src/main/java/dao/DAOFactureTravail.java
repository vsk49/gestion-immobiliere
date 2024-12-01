package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modele.BienLouable;
import modele.FactureTravail;

public interface DAOFactureTravail extends DAO<FactureTravail, Integer> {
	
	public Optional<FactureTravail> getByNumeroFacture(String numeroFacture);
	
	public List<FactureTravail> getFacturesByDate(LocalDate d);
	
	public List<FactureTravail> getByBienLouable(BienLouable b);

}
