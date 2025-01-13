package dao;

import modele.BienImmobilier;

import java.util.Optional;

public interface DAOBienImmobilier extends DAO<BienImmobilier, Integer> {

    Optional<BienImmobilier> getByNumeroFiscal(String numeroFiscal);
	
}
