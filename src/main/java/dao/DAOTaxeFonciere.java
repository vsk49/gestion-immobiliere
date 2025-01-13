package dao;

import modele.BienImmobilier;
import modele.TaxeFonciere;

import java.util.List;
import java.util.Optional;

public interface DAOTaxeFonciere extends DAO<TaxeFonciere, Integer> {

    List<TaxeFonciere> findByBienImmobilier(BienImmobilier bienImmobilier);

    List<TaxeFonciere> findByAnnee(int annee);

    Optional<TaxeFonciere> findByBienImmobilierAndAnnee(int annee, int idBienImmobilier);

}
