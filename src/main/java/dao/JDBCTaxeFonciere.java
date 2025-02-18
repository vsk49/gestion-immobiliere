package dao;

import modele.BienImmobilier;
import modele.TaxeFonciere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class JDBCTaxeFonciere implements DAOTaxeFonciere {

    private final JDBCBienImmobilier jdbcBienImmobilier = new JDBCBienImmobilier();
    private static final Connection connexion = JDBCConnexion.getConnexion();
    private static final Logger LOGGER = Logger.getLogger(JDBCTaxeFonciere.class.getName());

    @Override
    public List<TaxeFonciere> findByBienImmobilier(BienImmobilier bienImmobilier) {
        List<TaxeFonciere> taxes = new ArrayList<>();
        String requete = "SELECT * FROM TAXEFONCIERE WHERE idBienImmobilier = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, bienImmobilier.getIdBienImmobilier());
            ResultSet resultat = statement.executeQuery();
            boolean enregistrementExiste = resultat.next();
            while (enregistrementExiste) {
                TaxeFonciere t = new TaxeFonciere(resultat.getInt("IDTAXEFONCIERE"),
                        resultat.getInt("ANNEE"),
                        resultat.getDouble("MONTANTBASE"), bienImmobilier);
                taxes.add(t);
                enregistrementExiste = resultat.next();
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return taxes;
    }

    @Override
    public List<TaxeFonciere> findByAnnee(int annee) {
        List<TaxeFonciere> taxes = new ArrayList<>();
        String requete = "SELECT * FROM TAXEFONCIERE WHERE annee = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setInt(1, annee);
            ResultSet resultat = statement.executeQuery();
            boolean enregistrementExiste = resultat.next();
            while (enregistrementExiste) {
                BienImmobilier bien = jdbcBienImmobilier.getById(resultat.getString("IDBIENIMMOBILIER")).orElseThrow();
                TaxeFonciere t = new TaxeFonciere(resultat.getInt("IDTAXEFONCIERE"), annee,
                        resultat.getDouble("MONTANTBASE"), bien);
                taxes.add(t);
                enregistrementExiste = resultat.next();
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return taxes;
    }

    @Override
    public Optional<TaxeFonciere> findByBienImmobilierAndAnnee(int annee, int idBienImmobilier) {
        Optional<TaxeFonciere> taxeFonciere = Optional.empty();
        try {
            String requete = "SELECT * FROM TAXEFONCIERE WHERE annee = ? AND idBienImmobilier = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
            statement.setInt(1, annee);
            statement.setInt(2, idBienImmobilier);
            ResultSet resultat = statement.executeQuery();
            boolean enregistrementExiste = resultat.next();
            if (enregistrementExiste) {
                TaxeFonciere t = extraireTaxeFonciere(resultat);
                taxeFonciere = Optional.of(t);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return taxeFonciere;
    }

    private TaxeFonciere extraireTaxeFonciere(ResultSet resultat) throws SQLException {
        BienImmobilier bien = jdbcBienImmobilier.getById(resultat.getString("IDBIENIMMOBILIER")).orElseThrow();
        return new TaxeFonciere(resultat.getInt("IDTAXEFONCIERE"),
                resultat.getInt("ANNEE"),
                resultat.getDouble("MONTANTBASE"), bien);
    }

    @Override
    public List<TaxeFonciere> getAll() {
        List<TaxeFonciere> taxes = new ArrayList<>();
        try {
            ResultSet resultat = JDBCConnexion.getConnexion().createStatement()
                    .executeQuery("SELECT * FROM TAXEFONCIERE");
            boolean enregistrementExiste = resultat.next();
            while (enregistrementExiste) {
                TaxeFonciere t = extraireTaxeFonciere(resultat);
                taxes.add(t);
                enregistrementExiste = resultat.next();
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return taxes;
    }

    @Override
    public Optional<TaxeFonciere> getById(Integer id) {
        Optional<TaxeFonciere> taxeFonciere = Optional.empty();
        try {
            String requete = "SELECT * FROM TAXEFONCIERE WHERE IDTAXEFONCIERE = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
            statement.setInt(1, id);
            ResultSet resultat = statement.executeQuery();
            boolean enregistrementExiste = resultat.next();
            if (enregistrementExiste) {
                TaxeFonciere t = extraireTaxeFonciere(resultat);
                taxeFonciere = Optional.of(t);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return taxeFonciere;
    }

    @Override
    public boolean insert(TaxeFonciere t) {
        boolean resultat = false;
        try {
            String insertion = "INSERT INTO TAXEFONCIERE VALUES (?, ?, ?, ?)";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
            statement.setInt(1, t.idTaxeFonciere());
            statement.setInt(2, t.annee());
            statement.setDouble(3, t.montantBase());
            statement.setString(4, t.bien().getIdBienImmobilier());
            statement.executeUpdate();
            LOGGER.info("la taxe fonciere a ete inseree.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean update(TaxeFonciere t) {
        boolean resultat = false;
        try {
            String misAJour = "UPDATE TAXEFONCIERE SET MONTANTBASE = ? WHERE IDTAXEFONCIERE = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour);
            statement.setDouble(1, t.montantBase());
            statement.setInt(2, t.idTaxeFonciere());
            statement.executeUpdate();
            LOGGER.info("la taxe fonciere a ete mise a jour.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean delete(TaxeFonciere t) {
        boolean resultat = false;
        String suppression = "DELETE FROM TAXEFONCIERE WHERE IDTAXEFONCIERE = ?";
        try {
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
            statement.setInt(1, t.idTaxeFonciere());
            statement.executeUpdate();
            LOGGER.info("la taxe fonciere a ete supprimee.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

}
