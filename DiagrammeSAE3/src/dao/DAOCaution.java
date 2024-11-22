package dao;

import java.util.List;
import java.util.Optional;

import modele.Caution;
import modele.Locataire;

public interface DAOCaution extends DAO<Caution, Integer> {

	public Optional<Caution> getByNom(String nom);
	
	public List<Caution> getByLocataire(Locataire locataire);
	
}
