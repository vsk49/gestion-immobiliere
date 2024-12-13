package dao;

import modele.TaxeFonciere;

import java.util.List;
import java.util.Optional;

public class JDBCTaxeFonciere implements DAOTaxeFonciere {

    @Override
    public TaxeFonciere findByBienImmobilier(int idBienImmobilier) {
        return null;
    }

    @Override
    public TaxeFonciere findByAnnee(int annee) {
        return null;
    }

    @Override
    public TaxeFonciere findByBienImmobilierAndAnnee(int idBienImmobilier, int annee) {
        return null;
    }

    @Override
    public List<TaxeFonciere> getAll() throws DAOException {
        return List.of();
    }

    @Override
    public Optional<TaxeFonciere> getById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean insert(TaxeFonciere taxeFonciere) {
        return false;
    }

    @Override
    public boolean update(TaxeFonciere taxeFonciere) {
        return false;
    }

    @Override
    public boolean delete(TaxeFonciere taxeFonciere) {
        return false;
    }

}
