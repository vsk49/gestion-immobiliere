package dao;

import java.time.LocalDate;
import java.util.List;

import modele.Locataire;
import modele.Logement;
import modele.Loyer;

public interface DAOLoyer extends DAO<Loyer, Integer> {
	
	public List<Loyer> getByDateLoyer(LocalDate date);
	
	public List<Loyer> getByLocataire(Locataire locataire);
	
	public List<Loyer> getByLogement(Logement logement);

}
