package dao;

import modele.Batiment;
import modele.BienImmobilier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCBatiment extends JDBCBienImmobilier {

    @Override
    public boolean insert(BienImmobilier batiment) {
        boolean resultat = super.insert(batiment);
        if (resultat) {
            try {
                // garder l'idBienImmobilier
                int idBienImmobilier = batiment.getIdBienImmobilier();

                // insertion dans la table Batiment
                String insertion = "INSERT INTO Batiment (idBatiment, idBienImmobilier) VALUES (?, ?)";
                PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(insertion);
                statement.setInt(1, idBienImmobilier);
                statement.setInt(2, idBienImmobilier);
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
        Optional<BienImmobilier> bien = Optional.empty();
        try {
            // Chercher les donnees dans la table Batiment
            String requeteBatiment = "SELECT * FROM Batiment WHERE idBatiment = ?";
            PreparedStatement statementBatiment = JDBCConnexion.getConnexion().prepareStatement(requeteBatiment);
            statementBatiment.setInt(1, id);
            ResultSet resultatBatiment = statementBatiment.executeQuery();

            if (resultatBatiment.next()) {
                // Retirer idBienImmobilier selon le resulat
                int idBienImmobilier = resultatBatiment.getInt("idBienImmobilier");

                // chercher dans la table BienImmobilier en utilisant la clef etrangere idBienImmobilier
                Batiment bienTrouve = (Batiment) super.getById(idBienImmobilier).orElseThrow();
                bien = Optional.of(bienTrouve);
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return bien;
    }

    @Override
    public boolean delete(BienImmobilier batiment) {
        boolean resultat = false;
        try {
            // suppression dans la table Batiment
            String suppression = "DELETE FROM Batiment WHERE idBatiment = ?";
            PreparedStatement statement = JDBCConnexion.getConnexion().prepareStatement(suppression);
            statement.setInt(1, batiment.getIdBienImmobilier());
            statement.executeUpdate();

            // suppression dans la table BienImmobilier
            resultat = super.delete(batiment);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " : " + e.getMessage());
        }
        return resultat;
    }

}