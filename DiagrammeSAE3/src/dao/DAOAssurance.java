package dao;

import java.util.List;
import java.util.Optional;

import modele.Assurance;
import modele.BienImmobilier;

public interface DAOAssurance extends DAO<Assurance, Integer> {
	
	public Optional<Assurance> getByNomAssureur(String nomAssureur);
	
	public List<Assurance> getByBienImmobilier(BienImmobilier bien);

}
