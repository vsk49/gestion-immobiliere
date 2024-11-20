package dao;

import java.util.Optional;

import modele.Caution;
import modele.Locataire;

public interface DAOCaution extends DAO<Caution, Integer> {

	public Optional<Caution> getByNom(String nom);
	
	public Optional<Caution> getByLocataire(Locataire locataire);
	
}
