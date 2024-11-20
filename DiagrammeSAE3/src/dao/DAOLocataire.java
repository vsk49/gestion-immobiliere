package dao;

import modele.Locataire;

import java.util.Optional;

public interface DAOLocataire extends DAO<Locataire, Integer> {

	public Optional<Locataire> getByNom(String nom);
	
}
