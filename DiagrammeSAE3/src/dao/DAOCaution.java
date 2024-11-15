package dao;

import java.util.Optional;

import modele.Caution;

public interface DAOCaution extends DAO<Caution, Integer> {

	public Optional<Caution> getByNom(String nom);
	
}
