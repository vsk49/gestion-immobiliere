package dao;

import modele.Batiment;
import modele.BienImmobilier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCBatiment extends JDBCBienImmobilier implements DAOBatiment {

    public boolean insert(Batiment batiment) {
        boolean resultat = super.insert(batiment);
        if (resultat) {
            try {
                String insertion = "INSERT INTO Batiment (idBatiment, idBienImmobilier) VALUES (?, ?)";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
                statement.setInt(1, batiment.getIdBienImmobilier());
                statement.setInt(2, batiment.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le batiment a été inséré");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
                resultat = false;
            }
        }
        return resultat;
    }

    @Override
    public Optional<BienImmobilier> getById(Integer id) {
        Optional<BienImmobilier> batiment = Optional.empty();
        try {
            String requete = "SELECT * FROM Batiment WHERE idBatiment = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(requete);
            statement.setInt(1, id);
            ResultSet resultat = statement.executeQuery();
            if (resultat.next()) {
                Batiment b = (Batiment) super.getById(resultat.getInt("idBienImmobilier")).orElse(null);
                assert b != null;
                batiment = Optional.of(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return batiment;
    }

    public boolean delete(Batiment batiment) {
        boolean resultat = super.delete(batiment);
        if (resultat) {
            try {
                String suppression = "DELETE FROM Batiment WHERE idBatiment = ?";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
                statement.setInt(1, batiment.getIdBienImmobilier());
                statement.executeUpdate();
                System.out.println("Le batiment a été supprimé");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode() + " : " + e.getMessage());
                resultat = false;
            }
        }
        return resultat;
    }

}