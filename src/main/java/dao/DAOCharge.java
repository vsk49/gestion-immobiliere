package dao;

import java.util.List;

import modele.Charge;
import modele.Locataire;

public interface DAOCharge extends DAO<Charge, Integer> {
	
	public List<Charge> getByLocataire(Locataire locataire);

}
