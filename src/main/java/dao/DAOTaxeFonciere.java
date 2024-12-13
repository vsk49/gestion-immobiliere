package dao;

import modele.TaxeFonciere;

public interface DAOTaxeFonciere extends DAO<TaxeFonciere, Integer> {

    TaxeFonciere findByBienImmobilier(int idBienImmobilier);

    TaxeFonciere findByAnnee(int annee);

    TaxeFonciere findByBienImmobilierAndAnnee(int idBienImmobilier, int annee);

}
