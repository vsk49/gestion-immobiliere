package dao;

import java.util.Optional;

import modele.BienImmobilier;
import modele.BienLouable;
import modele.Compteur;

public interface DAOCompteur extends DAO<Compteur, Integer> {
	
	public Optional<Compteur> getByNumero(String numero);
	
	public Optional<Compteur> getByBienImmobilier(BienImmobilier bien);

}
