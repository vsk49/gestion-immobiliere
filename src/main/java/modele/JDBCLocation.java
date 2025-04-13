package modele;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class JDBCLocation implements DAO<Location, Integer> {

    private static final Logger LOGGER = Logger.getLogger(JDBCLocation.class.getName());

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        String requete = "SELECT idBienImmobilier, idLocataire, dateDebut, dateFin, loyer FROM Location";
        try (ResultSet resultat = JDBCConnexion.getConnexion().createStatement().executeQuery(requete)) {
            while (resultat.next()) {
                String idBienImmobilier = resultat.getString("idBienImmobilier");
                String idLocataire = resultat.getString("idLocataire");
                LocalDate dateDebut = resultat.getDate("dateDebut").toLocalDate();
                LocalDate dateFin = resultat.getDate("dateFin").toLocalDate();
                double loyer = resultat.getDouble("loyer");
                Location location = new Location(idBienImmobilier, idLocataire, dateDebut, dateFin, loyer);
                locations.add(location);
            }
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return locations;
    }

    @Override
    public Optional<Location> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean insert(Location location) {
        boolean resultat = false;
        String insertion = "INSERT INTO Location VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion)) {
            statement.setString(1, location.getIdBienImmobilier());
            statement.setString(2, location.getIdLocataire());
            statement.setDate(3, Date.valueOf(location.getDateDebut()));
            statement.setDate(4, Date.valueOf(location.getDateFin()));
            statement.setDouble(5, location.getLoyer());
            statement.executeUpdate();
            LOGGER.info("La location a ete ajoute.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean update(Location location) {
        boolean resultat = false;
        String misAJour = "UPDATE Location SET dateDebut = ?, dateFin = ?, loyer = ? WHERE IDLOCATAIRE = ? AND IDBIENIMMOBILIER = ?";
        try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(misAJour)) {
            statement.setDate(1, Date.valueOf(location.getDateDebut()));
            statement.setDate(2, Date.valueOf(location.getDateFin()));
            statement.setDouble(3, location.getLoyer());
            statement.setString(4, location.getIdLocataire());
            statement.setString(5, location.getIdBienImmobilier());
            statement.executeUpdate();
            LOGGER.info("Le locataire a ete mis a jour.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    @Override
    public boolean delete(Location location) {
        boolean resultat = false;
        String suppression = "DELETE FROM Location WHERE idLocataire = ? AND idbienImmobilier = ?";
        try (PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression)) {
            statement.setString(1, location.getIdLocataire());
            statement.setString(2, location.getIdBienImmobilier());
            statement.executeUpdate();
            LOGGER.info("Le locataire a ete supprime.");
            resultat = true;
        } catch (SQLException e) {
            LOGGER.severe(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

    public List<Location> getAllByLocataire(String idLocataire) {
        return this.getAll().stream().filter(location -> location.getIdLocataire().equals(idLocataire)).toList();
    }

    public List<Location> getAllByBien(String idBien) {
        return this.getAll().stream().filter(location -> location.getIdBienImmobilier().equals(idBien)).toList();
    }

    public boolean isLoue(String idBien) {
        return !this.getAllByBien(idBien).isEmpty();
    }

}
