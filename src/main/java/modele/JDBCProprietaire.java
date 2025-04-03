package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class JDBCProprietaire implements DAO<Proprietaire, String> {

    private final Connection connexion = JDBCConnexion.getConnexion();
    private static final Logger LOGGER = Logger.getLogger(JDBCProprietaire.class.getName());

    @Override
    public List<Proprietaire> getAll() {
        List<Proprietaire> proprietaires = new ArrayList<>();
        try (ResultSet resultat = connexion.createStatement()
                .executeQuery("SELECT IDPROPRIETAIRE, MOTDEPASSE FROM Proprietaire")) {
            boolean enregistrementExiste = resultat.next();
            while (enregistrementExiste) {
                Proprietaire l = getProprietaire(resultat);
                proprietaires.add(l);
                enregistrementExiste = resultat.next();
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return proprietaires;
    }

    private static Proprietaire getProprietaire(ResultSet resultat) throws SQLException {
        return new Proprietaire(
                resultat.getString("idProprietaire"),
                resultat.getString("MotDePasse")
        );
    }

    @Override
    public Optional<Proprietaire> getById(String idProprietaire) {
        Optional<Proprietaire> proprietaire = Optional.empty();
        String requete = "SELECT IDPROPRIETAIRE, MOTDEPASSE FROM Proprietaire WHERE idProprietaire = ?";
        try (PreparedStatement statement = connexion.prepareStatement(requete)) {
            statement.setString(1, idProprietaire);
            ResultSet resultat = statement.executeQuery();
            if (resultat.next()) {
                Proprietaire p = getProprietaire(resultat);
                proprietaire = Optional.of(p);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return proprietaire;
    }

    @Override
    public boolean insert(Proprietaire t) {
        boolean resultat = false;
        String insertion = "INSERT INTO Proprietaire VALUES (?, ?)";
        try (PreparedStatement statement = connexion.prepareStatement(insertion)) {
            statement.setString(1, t.idProprietaire());
            statement.setString(2, t.motDePasse());
            statement.executeUpdate();
            resultat = true;
            LOGGER.info("Le proprietaire a ete ajoute.");
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean update(Proprietaire t) {
        boolean resultat = false;
        String misAJour = "UPDATE Proprietaire SET MOTDEPASSE = ? WHERE idProprietaire = ?";
        try (PreparedStatement statement = connexion.prepareStatement(misAJour)) {
            statement.setString(1, t.motDePasse());
            statement.setString(2, t.idProprietaire());
            statement.executeUpdate();
            resultat = true;
            LOGGER.info("Le proprietaire a ete mis a jour.");
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean delete(Proprietaire t) {
        boolean resultat = false;
        String suppression = "DELETE FROM Proprietaire WHERE idProprietaire = ?";
        try (PreparedStatement statement = connexion.prepareStatement(suppression)) {
            statement.setString(1, t.idProprietaire());
            statement.executeUpdate();
            resultat = true;
            LOGGER.info("Le proprietaire a ete supprime.");
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    // Vérifie si un propriétaire est présent dans la base de données
    public boolean isPresentInformationProprietaire(String idProprietaire) {
        return this.getById(idProprietaire).isPresent();
    }

}
